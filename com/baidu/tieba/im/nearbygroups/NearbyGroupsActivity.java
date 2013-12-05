package com.baidu.tieba.im.nearbygroups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.model.s;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bf;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends com.baidu.tieba.j implements com.baidu.tieba.im.messageCenter.g {
    private k b = null;
    private s c = null;
    private com.baidu.adp.lib.h.c d = null;
    private com.baidu.adp.widget.ListView.b e = new d(this);

    /* renamed from: a  reason: collision with root package name */
    com.baidu.adp.lib.c.d f1842a = new e(this);

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, NearbyGroupsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new k(this);
        this.b.a(this.e);
        this.b.a(new b(this));
        this.b.a(new c(this));
        this.d = new com.baidu.adp.lib.h.c(this);
        this.c = new s();
        com.baidu.tieba.im.messageCenter.e.a().a(103009, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103008, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-115, this);
        this.b.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private boolean a(long j) {
        if (j == 0) {
            return true;
        }
        try {
            return bf.a(bf.a(), new Date(j)) >= 1;
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (!this.c.b()) {
            this.b.e();
        } else if (!this.c.a()) {
            this.b.f();
            this.c.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    private void b() {
        showProgressBar();
        this.c.a(0L);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag;
        super.onClick(view);
        if (view.getId() == this.b.i()) {
            b();
        } else if (view.getId() == R.id.guide_setting) {
            this.d.a();
        } else if (view.getId() == R.id.list_item_content && (tag = view.getTag()) != null) {
            GroupInfoActivity.a(this, com.baidu.adp.lib.f.b.a(tag.toString(), 0L), 1);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.c.i();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        if (message != null) {
            if (message.getCmd() == 103009 || message.getCmd() == -115) {
                this.c.a(false);
                if (message instanceof ResponseNearbyGroupsMessage) {
                    if (message.getCmd() == -115) {
                        if (UtilHelper.b()) {
                            if (a(TiebaApplication.h().bd())) {
                                this.c.h();
                                return;
                            }
                            this.c.g();
                        }
                    } else {
                        TiebaApplication.h().d(System.currentTimeMillis());
                    }
                    ResponseNearbyGroupsMessage responseNearbyGroupsMessage = (ResponseNearbyGroupsMessage) message;
                    if (responseNearbyGroupsMessage.hasError() && responseNearbyGroupsMessage.getErrNo() > 0) {
                        showToast(responseNearbyGroupsMessage.getErrMsg());
                    } else {
                        NearbyGroupsData nearbyGroups = responseNearbyGroupsMessage.getNearbyGroups();
                        if (nearbyGroups != null) {
                            this.c.b(nearbyGroups.getHasMore());
                            this.c.a(nearbyGroups.getGeo());
                        } else {
                            nearbyGroups = new NearbyGroupsData();
                        }
                        this.b.a(nearbyGroups);
                        if (nearbyGroups != null && nearbyGroups.size() > 0) {
                            this.b.a();
                        }
                    }
                    this.b.h();
                }
            } else if (message.getCmd() == 103008 && (message instanceof ResponseUserPermissionMessage)) {
                try {
                    ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) message;
                    if (responseUserPermissionMessage.hasError() && responseUserPermissionMessage.getErrNo() > 0) {
                        showToast(responseUserPermissionMessage.getErrMsg());
                        return;
                    }
                    GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                    if (groupPermData != null) {
                        if (groupPermData.isCreatePersonal()) {
                            CreateGroupStepActivity.a(this, 2, 0, 1011);
                        } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                            showToast(groupPermData.getCreatePersonalTip());
                        }
                    }
                } catch (Exception e) {
                } finally {
                    hideProgressBar();
                }
            }
        }
    }
}
