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
import com.baidu.tieba.im.message.bk;
import com.baidu.tieba.im.message.by;
import com.baidu.tieba.im.message.n;
import com.baidu.tieba.im.model.ad;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends com.baidu.tieba.j implements com.baidu.tieba.im.messageCenter.g {
    private k b = null;
    private ad c = null;
    private com.baidu.adp.lib.h.c d = null;
    private com.baidu.adp.widget.ListView.b e = new d(this);
    com.baidu.adp.lib.c.d a = new e(this);

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
        this.c = new ad();
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
            return bg.a(bg.a(), new Date(j)) >= 1;
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
            if (!TiebaApplication.C()) {
                LoginActivity.a((Activity) this, "", true, 0);
            } else {
                b();
            }
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
    public void a(n nVar) {
        if (nVar != null) {
            if (nVar.t() == 103009 || nVar.t() == -115) {
                this.c.a(false);
                if (!(nVar instanceof bk)) {
                    this.b.h();
                    return;
                }
                if (nVar.t() == -115) {
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
                bk bkVar = (bk) nVar;
                if (bkVar.i() && bkVar.j() > 0) {
                    showToast(bkVar.k());
                } else {
                    NearbyGroupsData a = bkVar.a();
                    if (a != null) {
                        this.c.b(a.getHasMore());
                        this.c.a(a.getGeo());
                    } else {
                        a = new NearbyGroupsData();
                    }
                    this.b.a(a);
                    if (a != null && a.size() > 0) {
                        this.b.a();
                    }
                }
                this.b.h();
            } else if (nVar.t() == 103008 && (nVar instanceof by)) {
                try {
                    by byVar = (by) nVar;
                    if (byVar.i() && byVar.j() > 0) {
                        showToast(byVar.k());
                        return;
                    }
                    GroupPermData a2 = byVar.a();
                    if (a2 != null) {
                        if (a2.isCreatePersonal()) {
                            CreateGroupStepActivity.a(this, 2, 0, 1011);
                        } else if (!TextUtils.isEmpty(a2.getCreatePersonalTip())) {
                            showToast(a2.getCreatePersonalTip());
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
