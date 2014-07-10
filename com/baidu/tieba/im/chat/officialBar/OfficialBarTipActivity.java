package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.bi;
/* loaded from: classes.dex */
public class OfficialBarTipActivity extends BaseActivity implements AbsListView.OnScrollListener {
    public static boolean a = false;
    private bi b;
    private bb c;
    private Handler d;
    private final com.baidu.tieba.im.a<Void> e = new at(this);
    private Runnable f = new au(this);
    private CustomMessageListener g = new av(this, 0);

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
        MessageManager.getInstance().registerListener(2001140, this.g);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        a();
    }

    private void a() {
        showLoadingDialog(getString(com.baidu.tieba.y.loading), null);
        this.b.a(this.e);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a = false;
        MessageManager.getInstance().unRegisterListener(this.g);
        com.baidu.tieba.im.model.p.a(false);
    }

    private void b() {
        this.b = new bi();
        this.d = new Handler();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.d != null) {
                this.d.removeCallbacks(this.f);
                this.d.postDelayed(this.f, 90L);
            }
        } else if (this.d != null) {
            this.d.removeCallbacks(this.f);
        }
    }

    private void c() {
        this.c = new bb(this);
        this.c.a().setOnScrollListener(this);
        this.c.a().setOnItemClickListener(new aw(this));
        this.c.a().setOnItemLongClickListener(new ax(this));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.c.a(i);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        a = true;
        this.c.c().a();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        a = false;
        this.c.c().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.c.c().b(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.d != null) {
            this.d.removeCallbacks(this.f);
            this.d.postDelayed(this.f, 0L);
        }
    }
}
