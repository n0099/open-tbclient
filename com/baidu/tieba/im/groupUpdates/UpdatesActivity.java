package com.baidu.tieba.im.groupUpdates;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.z;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.x;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesActivity extends BaseActivity implements AbsListView.OnScrollListener {
    public static boolean a = false;
    private t b;
    private AlertDialog c;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> d;
    private com.baidu.tieba.im.a<Boolean> e;
    private Runnable f;
    private UpdatesItemData h;
    private p i;
    private boolean g = false;
    private com.baidu.adp.framework.listener.d j = new a(this, 0);
    private CustomMessageListener k = new b(this, 0);

    static {
        b();
    }

    private static void b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008013, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, UpdatesActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = new p();
        this.b = new t(this);
        c();
        registerListener(2001136, this.k);
        registerListener(2001137, this.k);
        registerListener(2001134, this.k);
        registerListener(2001133, this.k);
        registerListener(2001141, this.k);
        this.b.a(true);
        p.b(this.d);
        registerListener(202004, this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().h();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tieba.im.message.f("-1002", -3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    private void c() {
        this.e = new e(this, new d(this));
        this.d = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.destroy();
        }
        if (this.i != null) {
            this.i.c();
        }
        this.h = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.b != null) {
            if (view.equals(this.b.f())) {
                finish();
            } else if (view.equals(this.b.h())) {
                this.i.b();
                this.i.a(this.b.b().b());
                this.b.a(this.i.d());
                a(true);
                this.b.c();
            } else if (view.equals(this.b.i())) {
                a(false);
                this.b.d();
                this.i.b();
                p.b(this.d);
            } else if (view.equals(this.b.j())) {
                this.b.a(true);
                String a2 = this.i.a();
                if (!TextUtils.isEmpty(a2)) {
                    a(a2);
                } else {
                    this.b.a(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.g) {
            a(false);
            this.i.b();
            this.b.a(this.i.d());
            this.b.d();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0067: ARITH  (r1v6 long A[REMOVE]) = (wrap: long : 0x005c: INVOKE  (r1v5 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0058: INVOKE  (r1v4 java.lang.String A[REMOVE]) = (r7v0 com.baidu.tieba.im.groupUpdates.UpdatesItemData) type: VIRTUAL call: com.baidu.tieba.im.groupUpdates.UpdatesItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!UtilHelper.isNetOk()) {
            showToast(x.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.f.a().c()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.f.a().c()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.b.a(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(com.baidu.tieba.im.pushNotify.f.a().c()));
                requestDelSystemMessage.setMsgIds(new StringBuilder().append(Long.parseLong(updatesItemData.getNotice_id()) / 100).toString());
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(String str) {
        if (!UtilHelper.isNetOk()) {
            showToast(x.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String c = com.baidu.tieba.im.pushNotify.f.a().c();
            if (!TextUtils.isEmpty(c) && TextUtils.isDigitsOnly(c)) {
                this.b.a(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(c));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.b(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !a()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        GroupLevelActivity.a(this, com.baidu.adp.lib.e.c.a(groupId, 0L), updatesItemData.isShown());
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            com.baidu.tbadk.core.f.a(this, "update_activity_group_event_click");
                            bg.a().a(this, new String[]{updatesItemData.getEventLink()});
                        } else if (updatesType.equals("group_activitys_change")) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.e.c.a(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.e.c.a(updatesItemData.getGroupId(), 0L), 1);
                        } else {
                            sendMessage(new CustomMessage(2008011, new z(this, Long.parseLong(groupId), 0)));
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
                this.i.a(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.i.d() > 100) {
                    this.i.b(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(x.updates_activity_del_limit);
                }
            } else {
                this.i.b(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.b.a(this.i.d());
            this.b.e();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !a()) {
            if (this.c == null) {
                this.h = updatesItemData;
                d();
            }
            com.baidu.adp.lib.e.e.a(this.c, this);
        }
    }

    private void d() {
        String string = getString(x.delete_user_chat);
        g gVar = new g(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(x.operation);
        builder.setItems(new String[]{string}, gVar);
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b.g() != null) {
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
            e();
        }
    }

    public boolean a() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }
}
