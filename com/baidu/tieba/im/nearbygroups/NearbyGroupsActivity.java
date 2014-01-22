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
import com.baidu.tieba.im.message.bx;
import com.baidu.tieba.im.message.cp;
import com.baidu.tieba.im.message.cq;
import com.baidu.tieba.im.message.q;
import com.baidu.tieba.im.model.af;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ca;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends com.baidu.tieba.j implements com.baidu.tieba.im.messageCenter.g {
    private k b = null;
    private af c = null;
    private com.baidu.adp.lib.g.c d = null;
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
        this.d = new com.baidu.adp.lib.g.c(this);
        this.c = new af();
        com.baidu.tieba.im.messageCenter.e.a().a(103009, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103008, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-115, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103105, this);
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
            return ca.a(ca.a(), new Date(j)) >= 1;
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
            if (!TiebaApplication.B()) {
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
    public void a(q qVar) {
        if (qVar != null) {
            if (qVar.w() == 103105) {
                if (qVar instanceof cp) {
                    cp cpVar = (cp) qVar;
                    if (!cpVar.k() || cpVar.l() == 2230110) {
                        this.c.d();
                    }
                }
            } else if (qVar.w() == 103009 || qVar.w() == -115) {
                this.c.a(false);
                if (!(qVar instanceof bx)) {
                    this.b.h();
                    return;
                }
                if (qVar.w() == -115) {
                    if (UtilHelper.b()) {
                        if (a(TiebaApplication.h().bc())) {
                            this.c.h();
                            return;
                        }
                        this.c.g();
                    }
                } else {
                    TiebaApplication.h().d(System.currentTimeMillis());
                }
                bx bxVar = (bx) qVar;
                if (bxVar.k() && bxVar.l() > 0) {
                    showToast(bxVar.m());
                } else {
                    NearbyGroupsData a = bxVar.a();
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
            } else if (qVar.w() == 103008 && (qVar instanceof cq)) {
                try {
                    cq cqVar = (cq) qVar;
                    if (cqVar.k() && cqVar.l() > 0) {
                        showToast(cqVar.m());
                        return;
                    }
                    GroupPermData a2 = cqVar.a();
                    if (a2 != null) {
                        if (a2.isCreatePersonal()) {
                            CreateGroupStepActivity.a(this, 2, 0, 1011, a2.getCanCreateNormalNum(), a2.getCanCreateOfficialNum(), a2.getCanCreatePersonalNum());
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
