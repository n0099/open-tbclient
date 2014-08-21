package com.baidu.tieba.im.live.livenotify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.al;
import com.baidu.tbadk.core.atomData.am;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.x;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class LiveNotifyActivity extends BaseActivity {
    public static boolean a = false;
    private s b;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> c;
    private com.baidu.tieba.im.a<Boolean> d;
    private UpdatesItemData f;
    private o g;
    private boolean e = false;
    private com.baidu.adp.framework.listener.d h = new a(this, 0);
    private CustomMessageListener i = new b(this, 0);

    static {
        TbadkApplication.m252getInst().RegisterIntent(al.class, LiveNotifyActivity.class);
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
        this.g = new o();
        this.b = new s(this);
        b();
        registerListener(2001167, this.i);
        this.b.a(true);
        o.b(this.c);
        registerListener(202004, this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(3);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tieba.im.message.f("-1004", -5)));
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

    private void b() {
        this.d = new d(this, new c(this));
        this.c = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.destroy();
        }
        if (this.g != null) {
            this.g.c();
        }
        this.f = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.b != null) {
            if (view.equals(this.b.e())) {
                finish();
            } else if (view.equals(this.b.f())) {
                a(true);
                this.b.b();
            } else if (view.equals(this.b.g())) {
                a(false);
                this.b.c();
                this.g.b();
                o.b(this.c);
            } else if (view.equals(this.b.h())) {
                this.b.a(true);
                String a2 = this.g.a();
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
        if (4 == i && keyEvent.getAction() == 0 && this.e) {
            a(false);
            this.g.b();
            this.b.a(this.g.d());
            this.b.c();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
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
        if (updatesItemData != null && 101 == i && !a() && updatesItemData.getLiveCardData() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new am(this, updatesItemData.getLiveCardData().getGroupId())));
        }
    }

    public void a(View view, boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            if (z) {
                this.g.a(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.g.d() > 100) {
                    this.g.b(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(x.updates_activity_del_limit);
                }
            } else {
                this.g.b(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.b.a(this.g.d());
            this.b.d();
        }
    }

    public boolean a() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
