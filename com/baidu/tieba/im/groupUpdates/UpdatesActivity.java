package com.baidu.tieba.im.groupUpdates;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.groupInfo.al;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesActivity extends com.baidu.tbadk.a implements AbsListView.OnScrollListener {
    public static boolean a = false;
    private t b;
    private AlertDialog c;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> d;
    private com.baidu.tieba.im.a<Boolean> e;
    private Runnable f;
    private aa g;
    private UpdatesItemData i;
    private p j;
    private boolean h = false;
    private com.baidu.adp.framework.c.g k = new a(this, 0);
    private com.baidu.adp.framework.c.a l = new b(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008013, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    public static void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, UpdatesActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new p();
        this.b = new t(this);
        this.e = new d(this);
        this.d = new e(this);
        this.g = new aa(this);
        this.g.a(true);
        registerListener(2001136, this.l);
        registerListener(2001137, this.l);
        registerListener(2001134, this.l);
        registerListener(2001133, this.l);
        registerListener(2001141, this.l);
        this.b.a(true);
        p.a(this.d);
        registerListener(202004, this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
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
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.c();
        }
        if (this.j != null) {
            this.j.b();
        }
        this.i = null;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.b != null) {
            if (view.equals(this.b.f())) {
                finish();
            } else if (view.equals(this.b.h())) {
                this.h = true;
                this.b.a();
            } else if (view.equals(this.b.i())) {
                this.h = false;
                this.b.d();
                this.j.b();
                p.a(this.d);
            } else if (view.equals(this.b.j())) {
                this.b.a(true);
                String a2 = this.j.a();
                if (!TextUtils.isEmpty(a2)) {
                    if (!UtilHelper.a()) {
                        showToast(com.baidu.tieba.im.j.neterror);
                        return;
                    } else if (TextUtils.isEmpty(a2)) {
                        return;
                    } else {
                        String e = com.baidu.tieba.im.pushNotify.o.a().e();
                        if (TextUtils.isEmpty(e) || !TextUtils.isDigitsOnly(e)) {
                            return;
                        }
                        this.b.a(true);
                        al alVar = new al();
                        alVar.d(Integer.parseInt(e));
                        alVar.a(a2);
                        com.baidu.adp.lib.util.f.e("del group info request: " + a2);
                        com.baidu.adp.framework.c.a().a(alVar);
                        return;
                    }
                }
                this.b.a(false);
            }
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (4 == i && keyEvent.getAction() == 0 && this.h) {
            this.h = false;
            this.j.b();
            this.b.a(this.j.c());
            this.b.d();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0067: ARITH  (r1v6 long A[REMOVE]) = (wrap: long : 0x005c: INVOKE  (r1v5 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0058: INVOKE  (r1v4 java.lang.String A[REMOVE]) = (r7v0 com.baidu.tieba.im.groupUpdates.UpdatesItemData) type: VIRTUAL call: com.baidu.tieba.im.groupUpdates.UpdatesItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(UpdatesActivity updatesActivity, UpdatesItemData updatesItemData) {
        if (!UtilHelper.a()) {
            updatesActivity.showToast(com.baidu.tieba.im.j.neterror);
        } else if (updatesItemData == null || TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.o.a().e()) || !TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.o.a().e()) || TextUtils.isEmpty(updatesItemData.getNotice_id()) || !TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
        } else {
            try {
                updatesActivity.b.a(true);
                al alVar = new al();
                alVar.d(Integer.parseInt(com.baidu.tieba.im.pushNotify.o.a().e()));
                alVar.a(new StringBuilder().append(Long.parseLong(updatesItemData.getNotice_id()) / 100).toString());
                com.baidu.adp.lib.util.f.e("del group info request: gid" + updatesItemData.getGroupId() + " msgid:" + updatesItemData.getNotice_id() + " systemGid:" + alVar.i());
                com.baidu.adp.framework.c.a().a(alVar);
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.b(i);
        }
    }

    public final void a(int i, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && !this.h) {
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
                            com.baidu.tbadk.core.g.a(this, "update_activity_group_event_click");
                            bg.a().a(this, new String[]{updatesItemData.getEventLink()});
                        } else if (updatesType.equals("group_activitys_change")) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.f.b.a(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.f.b.a(updatesItemData.getGroupId(), 0L), 1);
                        } else {
                            sendMessage(new com.baidu.adp.framework.message.a(2008011, new com.baidu.tbadk.core.b.o(this, Long.parseLong(groupId), 0)));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void a(boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            if (z) {
                this.j.a(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.j.c() > 100) {
                    this.j.b(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(com.baidu.tieba.im.j.updates_activity_del_limit);
                }
            } else {
                this.j.b(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.b.a(this.j.c());
            this.b.e();
        }
    }

    public final void a(View view, int i, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && !this.h) {
            if (this.c == null) {
                this.i = updatesItemData;
                String string = getString(com.baidu.tieba.im.j.delete_user_chat);
                f fVar = new f(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(com.baidu.tieba.im.j.operation);
                builder.setItems(new String[]{string}, fVar);
                this.c = builder.create();
                this.c.setCanceledOnTouchOutside(true);
            }
            this.c.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.b.g() != null) {
            if (this.f == null) {
                this.f = new g(this);
            }
            this.b.g().removeCallbacks(this.f);
            this.b.g().post(this.f);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            c();
        }
    }

    public final aa a() {
        return this.g;
    }

    public final boolean b() {
        return this.h;
    }

    public final void a(boolean z) {
        this.h = z;
    }
}
