package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.model.bi;
/* loaded from: classes.dex */
public class OfficialBarTipActivity extends BaseActivity implements AbsListView.OnScrollListener {
    private bi a;
    private ax b;
    private Handler c;
    private final com.baidu.tieba.im.a<Void> d = new ap(this);
    private Runnable e = new aq(this);
    private CustomMessageListener f = new ar(this, 0);

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, OfficialBarTipActivity.class));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_MSG_ARRIVED, this.f);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a();
    }

    private void a() {
        showLoadingDialog(getString(com.baidu.tieba.u.loading), null);
        this.a.a(this.d);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.f);
    }

    private void b() {
        this.a = new bi();
        this.c = new Handler();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.c != null) {
                this.c.removeCallbacks(this.e);
                this.c.postDelayed(this.e, 90L);
            }
        } else if (this.c != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    private void c() {
        this.b = new ax(this);
        this.b.a().setOnScrollListener(this);
        this.b.a().setOnItemClickListener(new as(this));
        this.b.a().setOnItemLongClickListener(new at(this));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.b.a(i);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.b.c().a();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b.c().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.b.c().b(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.c != null) {
            this.c.removeCallbacks(this.e);
            this.c.postDelayed(this.e, 0L);
        }
    }
}
