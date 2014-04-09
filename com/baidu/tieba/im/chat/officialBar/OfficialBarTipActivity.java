package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class OfficialBarTipActivity extends com.baidu.tbadk.a implements AbsListView.OnScrollListener {
    private com.baidu.tieba.im.model.bd a;
    private az b;
    private Handler c;
    private final com.baidu.tieba.im.a<Void> d = new ar(this);
    private Runnable e = new as(this);
    private com.baidu.adp.framework.c.a f = new at(this, 0);

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, OfficialBarTipActivity.class));
        }
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new com.baidu.tieba.im.model.bd();
        this.c = new Handler();
        this.b = new az(this);
        this.b.a().setOnScrollListener(this);
        this.b.a().setOnItemClickListener(new au(this));
        this.b.a().setOnItemLongClickListener(new av(this));
        com.baidu.adp.framework.c.a().a(2001140, this.f);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        showLoadingDialog(getString(com.baidu.tieba.im.j.loading), null);
        this.a.a(this.d);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.framework.c.a().b(this.f);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.c != null) {
                this.c.removeCallbacks(this.e);
                this.c.postDelayed(this.e, 300L);
            }
        } else if (this.c != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.b.a(i);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.b.e().a();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b.e().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(OfficialBarTipActivity officialBarTipActivity) {
        if (officialBarTipActivity.c != null) {
            officialBarTipActivity.c.removeCallbacks(officialBarTipActivity.e);
            officialBarTipActivity.c.postDelayed(officialBarTipActivity.e, 0L);
        }
    }
}
