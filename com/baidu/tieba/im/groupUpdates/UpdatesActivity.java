package com.baidu.tieba.im.groupUpdates;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import cn.jingling.lib.file.Shared;
import com.baidu.tieba.ai;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.groupInfo.ag;
import com.baidu.tieba.im.groupInfo.aj;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.mention.v;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesActivity extends com.baidu.tieba.f implements AbsListView.OnScrollListener, com.baidu.tieba.im.messageCenter.g {
    public static boolean a = false;
    private q b;
    private AlertDialog c;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> d;
    private com.baidu.tieba.im.a<Boolean> e;
    private Runnable f;
    private com.baidu.tieba.util.i g;
    private boolean h = false;
    private UpdatesItemData i;
    private m j;

    public static void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, UpdatesActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new m();
        this.b = new q(this);
        c();
        this.g = new com.baidu.tieba.util.i(this);
        this.g.d(true);
        com.baidu.tieba.im.messageCenter.e.a().a(-136, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-137, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-134, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-133, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-141, this);
        this.b.a(true);
        m.b(this.d);
        com.baidu.tieba.im.messageCenter.e.a().a(202004, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        v.a().a(2);
        v.a().g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        a = false;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        a = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    private void c() {
        this.e = new a(this);
        this.d = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.c();
        }
        if (this.j != null) {
            this.j.c();
        }
        this.i = null;
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.b != null) {
            if (view.equals(this.b.h())) {
                finish();
            } else if (view.equals(this.b.j())) {
                a(true);
                this.b.e();
            } else if (view.equals(this.b.k())) {
                a(false);
                this.b.f();
                this.j.b();
                m.b(this.d);
            } else if (view.equals(this.b.l())) {
                this.b.a(true);
                String a2 = this.j.a();
                if (!TextUtils.isEmpty(a2)) {
                    a(a2);
                } else {
                    this.b.a(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (4 == i && keyEvent.getAction() == 0 && this.h) {
            a(false);
            this.j.b();
            this.b.a(this.j.d());
            this.b.f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0068: ARITH  (r1v6 long A[REMOVE]) = (wrap: long : 0x005d: INVOKE  (r1v5 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0059: INVOKE  (r1v4 java.lang.String A[REMOVE]) = (r7v0 com.baidu.tieba.im.groupUpdates.UpdatesItemData) type: VIRTUAL call: com.baidu.tieba.im.groupUpdates.UpdatesItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.c.j.a().e()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.c.j.a().e()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.b.a(true);
                ag agVar = new ag();
                agVar.a(Integer.parseInt(com.baidu.tieba.im.c.j.a().e()));
                agVar.a(new StringBuilder().append(Long.parseLong(updatesItemData.getNotice_id()) / 100).toString());
                com.baidu.adp.lib.util.f.e("del group info request: gid" + updatesItemData.getGroupId() + " msgid:" + updatesItemData.getNotice_id() + " systemGid:" + agVar.b());
                com.baidu.tieba.im.messageCenter.e.a().a(agVar);
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
        }
    }

    private void a(String str) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String e = com.baidu.tieba.im.c.j.a().e();
            if (!TextUtils.isEmpty(e) && TextUtils.isDigitsOnly(e)) {
                this.b.a(true);
                ag agVar = new ag();
                agVar.a(Integer.parseInt(e));
                agVar.a(str);
                com.baidu.adp.lib.util.f.e("del group info request: " + str);
                com.baidu.tieba.im.messageCenter.e.a().a(agVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.b(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !b()) {
            String groupId = updatesItemData.getGroupId();
            com.baidu.adp.lib.util.f.e("go to level gid:" + groupId);
            String updatesType = updatesItemData.getUpdatesType();
            com.baidu.adp.lib.util.f.e("updateType:" + updatesType);
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        GroupLevelActivity.a(this, Long.parseLong(groupId));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            ai.a(this, "update_activity_group_event_click");
                            UtilHelper.a(this, updatesItemData.getEventLink(), null, null);
                        } else if (updatesType.equals("group_activitys_change")) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.f.b.a(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.f.b.a(updatesItemData.getGroupId(), 0L), 1);
                        } else {
                            GroupInfoActivity.a(this, Long.parseLong(groupId), 0);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(View view, boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            if (z) {
                this.j.a(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.j.d() > 100) {
                    this.j.b(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(R.string.updates_activity_del_limit);
                }
            } else {
                this.j.b(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.b.a(this.j.d());
            this.b.g();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !b()) {
            if (this.c == null) {
                this.i = updatesItemData;
                d();
            }
            this.c.show();
        }
    }

    private void d() {
        String string = getString(R.string.delete_user_chat);
        c cVar = new c(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, cVar);
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b.i() != null) {
            f();
            this.b.i().removeCallbacks(this.f);
            this.b.i().post(this.f);
        }
    }

    private void f() {
        if (this.f == null) {
            this.f = new d(this);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            e();
        }
    }

    public com.baidu.tieba.util.i a() {
        return this.g;
    }

    public boolean b() {
        return this.h;
    }

    public void a(boolean z) {
        this.h = z;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        this.b.a(false);
        if (sVar != null && (sVar instanceof da)) {
            int w = sVar.w();
            if (202004 == w) {
                aj ajVar = (aj) sVar;
                ag agVar = (ag) ajVar.o();
                if (ajVar.l()) {
                    com.baidu.adp.lib.util.f.b("del group info err:" + ajVar.n());
                    return;
                }
                com.baidu.adp.lib.util.f.e("del group info: gid" + agVar.b() + " msgid:" + agVar.c());
                if (this.i != null) {
                    m.a(this.i, this.e);
                    this.i = null;
                }
                if (this.j != null && this.j.d() > 0) {
                    this.j.a(this.e);
                }
                com.baidu.tieba.im.validate.l.a(Shared.INFINITY, 0, this.d);
                com.baidu.tieba.im.c.a.a(false, (com.baidu.tieba.im.a<Void>) null);
            } else if (-136 == w || -137 == w || -134 == w || -133 == w || -141 == w) {
                m.b(this.d);
            }
        }
    }
}
