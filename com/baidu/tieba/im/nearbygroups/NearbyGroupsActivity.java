package com.baidu.tieba.im.nearbygroups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.message.cg;
import com.baidu.tieba.im.message.cy;
import com.baidu.tieba.im.message.cz;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.model.ak;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cd;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends com.baidu.tieba.f implements com.baidu.tieba.im.messageCenter.g {
    private k b = null;
    private ak c = null;
    private com.baidu.adp.lib.util.c d = null;
    private com.baidu.adp.widget.ListView.b e = new b(this);
    com.baidu.adp.lib.c.d a = new c(this);

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, NearbyGroupsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new k(this);
        this.b.a(this.e);
        this.b.a(new d(this));
        this.b.a(new e(this));
        this.d = new com.baidu.adp.lib.util.c(this);
        this.c = new ak();
        com.baidu.tieba.im.messageCenter.d.a().a(103009, this);
        com.baidu.tieba.im.messageCenter.d.a().a(103008, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-115, this);
        com.baidu.tieba.im.messageCenter.d.a().a(103105, this);
        this.b.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private static boolean a(long j) {
        if (j == 0) {
            return true;
        }
        try {
            return cd.a(cd.a(), new Date(j)) >= 1;
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(NearbyGroupsActivity nearbyGroupsActivity) {
        if (!nearbyGroupsActivity.c.b()) {
            nearbyGroupsActivity.b.d();
        } else if (nearbyGroupsActivity.c.a()) {
        } else {
            nearbyGroupsActivity.b.e();
            nearbyGroupsActivity.c.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag;
        super.onClick(view);
        if (view.getId() == this.b.h()) {
            if (!TiebaApplication.w()) {
                LoginActivity.a((Activity) this, "", true, 0);
                return;
            }
            showProgressBar();
            this.c.a(0L);
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.c.i();
        com.baidu.tieba.im.messageCenter.d.a().a(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [325=4] */
    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        if (sVar == null) {
            return;
        }
        if (sVar.w() == 103105) {
            if (sVar instanceof cy) {
                cy cyVar = (cy) sVar;
                if (!cyVar.l() || cyVar.m() == 2230110) {
                    this.c.d();
                }
            }
        } else if (sVar.w() != 103009 && sVar.w() != -115) {
            if (sVar.w() == 103008 && (sVar instanceof cz)) {
                try {
                    cz czVar = (cz) sVar;
                    if (czVar.l() && czVar.m() > 0) {
                        showToast(czVar.n());
                        return;
                    }
                    GroupPermData a = czVar.a();
                    if (a != null) {
                        if (a.isCreatePersonal()) {
                            CreateGroupStepActivity.a(this, 2, 0, 1011, a.getCanCreateNormalNum(), a.getCanCreateOfficialNum(), a.getCanCreatePersonalNum());
                        } else if (!TextUtils.isEmpty(a.getCreatePersonalTip())) {
                            showToast(a.getCreatePersonalTip());
                        }
                    }
                } catch (Exception e) {
                } finally {
                    hideProgressBar();
                }
            }
        } else {
            this.c.a(false);
            if (!(sVar instanceof cg)) {
                this.b.g();
                return;
            }
            if (sVar.w() != -115) {
                TiebaApplication.g().d(System.currentTimeMillis());
            } else if (UtilHelper.b()) {
                if (a(TiebaApplication.g().aR())) {
                    this.c.h();
                    return;
                }
                this.c.g();
            }
            cg cgVar = (cg) sVar;
            if (!cgVar.l() || cgVar.m() <= 0) {
                NearbyGroupsData a2 = cgVar.a();
                if (a2 != null) {
                    this.c.b(a2.getHasMore());
                    this.c.a(a2.getGeo());
                } else {
                    a2 = new NearbyGroupsData();
                }
                this.b.a(a2);
                if (a2 != null && a2.size() > 0) {
                    this.b.a();
                }
            } else {
                showToast(cgVar.n());
            }
            this.b.g();
        }
    }
}
