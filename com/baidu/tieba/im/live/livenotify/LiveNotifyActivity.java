package com.baidu.tieba.im.live.livenotify;

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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ad;
import com.baidu.tbadk.core.atomData.ae;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.y;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class LiveNotifyActivity extends BaseActivity implements AbsListView.OnScrollListener {
    public static boolean a = false;
    private s b;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> c;
    private com.baidu.tieba.im.a<Boolean> d;
    private Runnable e;
    private ab f;
    private UpdatesItemData h;
    private o i;
    private boolean g = false;
    private com.baidu.adp.framework.listener.b j = new a(this, 0);
    private CustomMessageListener k = new b(this, 0);

    static {
        TbadkApplication.m252getInst().RegisterIntent(ad.class, LiveNotifyActivity.class);
    }

    public static void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, LiveNotifyActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = new o();
        this.b = new s(this);
        c();
        this.f = new ab(this);
        this.f.d(true);
        registerListener(MessageTypes.CMD_LIVE_NOTIFY_LOCAL, this.k);
        this.b.a(true);
        o.b(this.c);
        registerListener(MessageTypes.CMD_DELETE_GROUP_MSG, this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
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
        this.d = new c(this);
        this.c = new d(this);
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
            if (view.equals(this.b.e())) {
                finish();
            } else if (view.equals(this.b.g())) {
                a(true);
                this.b.b();
            } else if (view.equals(this.b.h())) {
                a(false);
                this.b.c();
                this.i.b();
                o.b(this.c);
            } else if (view.equals(this.b.i())) {
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
        if (keyEvent == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (4 == i && keyEvent.getAction() == 0 && this.g) {
            a(false);
            this.i.b();
            this.b.a(this.i.d());
            this.b.c();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void a(String str) {
        if (!UtilHelper.isNetOk()) {
            showToast(y.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String e = com.baidu.tieba.im.pushNotify.p.a().e();
            if (!TextUtils.isEmpty(e) && TextUtils.isDigitsOnly(e)) {
                this.b.a(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(e));
                requestDelSystemMessage.setMsgIds(str);
                BdLog.d("del group info request: " + str);
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
        if (updatesItemData != null && 101 == i && !b() && updatesItemData.getLiveCardData() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new ae(this, updatesItemData.getLiveCardData().getGroupId())));
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
                    showToast(y.updates_activity_del_limit);
                }
            } else {
                this.i.b(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.b.a(this.i.d());
            this.b.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.b.f() != null) {
            e();
            this.b.f().removeCallbacks(this.e);
            this.b.f().post(this.e);
        }
    }

    private void e() {
        if (this.e == null) {
            this.e = new e(this);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            d();
        }
    }

    public ab a() {
        return this.f;
    }

    public boolean b() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }
}
