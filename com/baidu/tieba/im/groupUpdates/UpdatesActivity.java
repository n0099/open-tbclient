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
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.y;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesActivity extends BaseActivity implements AbsListView.OnScrollListener {
    public static boolean isOpen = false;
    private t bca;
    private AlertDialog bcb;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> bcc;
    private com.baidu.tieba.im.a<Boolean> bcd;
    private Runnable bce;
    private UpdatesItemData bcg;
    private p bch;
    private boolean bcf = false;
    private com.baidu.adp.framework.listener.e ayS = new a(this, 0);
    private CustomMessageListener mCustomListener = new b(this, 0);

    static {
        Kn();
    }

    private static void Kn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008013, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void ae(Context context) {
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
        this.bch = new p();
        this.bca = new t(this);
        Pf();
        registerListener(2001136, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        registerListener(2001134, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001141, this.mCustomListener);
        this.bca.dg(true);
        p.c(this.bcc);
        registerListener(202004, this.ayS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        isOpen = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().bY(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().oO();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a("-1002", -3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        isOpen = false;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        isOpen = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        isOpen = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        isOpen = false;
    }

    private void Pf() {
        this.bcd = new e(this, new d(this));
        this.bcc = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bca != null) {
            this.bca.destroy();
        }
        if (this.bch != null) {
            this.bch.ya();
        }
        this.bcg = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.bca != null) {
            if (view.equals(this.bca.Pp())) {
                finish();
            } else if (view.equals(this.bca.Pr())) {
                this.bch.Pj();
                this.bch.X(this.bca.Pm().getDatas());
                this.bca.fT(this.bch.Pk());
                df(true);
                this.bca.Pn();
            } else if (view.equals(this.bca.Ps())) {
                df(false);
                this.bca.Po();
                this.bch.Pj();
                p.c(this.bcc);
            } else if (view.equals(this.bca.Pt())) {
                this.bca.dg(true);
                String Pi = this.bch.Pi();
                if (!TextUtils.isEmpty(Pi)) {
                    go(Pi);
                } else {
                    this.bca.dg(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.bcf) {
            df(false);
            this.bch.Pj();
            this.bca.fT(this.bch.Pk());
            this.bca.Po();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0067: ARITH  (r1v6 long A[REMOVE]) = (wrap: long : 0x005c: INVOKE  (r1v5 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0058: INVOKE  (r1v4 java.lang.String A[REMOVE]) = (r7v0 com.baidu.tieba.im.groupUpdates.UpdatesItemData) type: VIRTUAL call: com.baidu.tieba.im.groupUpdates.UpdatesItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!com.baidu.adp.lib.util.j.fh()) {
            showToast(y.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.f.Rq().Rs()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.f.Rq().Rs()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.bca.dg(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(com.baidu.tieba.im.pushNotify.f.Rq().Rs()));
                requestDelSystemMessage.setMsgIds(new StringBuilder().append(Long.parseLong(updatesItemData.getNotice_id()) / 100).toString());
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void go(String str) {
        if (!com.baidu.adp.lib.util.j.fh()) {
            showToast(y.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String Rs = com.baidu.tieba.im.pushNotify.f.Rq().Rs();
            if (!TextUtils.isEmpty(Rs) && TextUtils.isDigitsOnly(Rs)) {
                this.bca.dg(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(Rs));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bca != null) {
            this.bca.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !Ph()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        GroupLevelActivity.a(this, com.baidu.adp.lib.g.c.a(groupId, 0L), updatesItemData.isShown());
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            com.baidu.tbadk.core.j.l(this, "update_activity_group_event_click");
                            bg.mR().b(this, new String[]{updatesItemData.getEventLink()});
                        } else if (updatesType.equals("group_activitys_change")) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.g.c.f(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.g.c.a(updatesItemData.getGroupId(), 0L), 1);
                        } else {
                            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(this, Long.parseLong(groupId), 0)));
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
                this.bch.d(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.bch.Pk() > 100) {
                    this.bch.e(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(y.updates_activity_del_limit);
                }
            } else {
                this.bch.e(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.bca.fT(this.bch.Pk());
            this.bca.NT();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !Ph()) {
            if (this.bcb == null) {
                this.bcg = updatesItemData;
                Pg();
            }
            com.baidu.adp.lib.g.j.a(this.bcb, this);
        }
    }

    private void Pg() {
        String string = getString(y.delete_user_chat);
        g gVar = new g(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(y.operation);
        builder.setItems(new String[]{string}, gVar);
        this.bcb = builder.create();
        this.bcb.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg() {
        if (this.bca.Pq() != null) {
            this.bca.Pq().removeCallbacks(this.bce);
            this.bca.Pq().post(this.bce);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            Dg();
        }
    }

    public boolean Ph() {
        return this.bcf;
    }

    public void df(boolean z) {
        this.bcf = z;
    }
}
