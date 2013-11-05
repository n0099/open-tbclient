package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends android.support.v4.app.n {

    /* renamed from: a  reason: collision with root package name */
    private int f981a = -1;
    private e b;
    private com.baidu.tieba.util.i c;

    protected abstract void a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.c = com.baidu.tieba.util.i.a();
        super.onCreate(bundle);
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.v(true);
        TiebaApplication.g().a(getClass().getName());
        this.b = new e();
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.h.a());
            } catch (Exception e) {
                be.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onResume() {
        this.c.c();
        super.onResume();
        if (TiebaApplication.g().as() != this.f981a) {
            this.f981a = TiebaApplication.g().as();
            a(this.f981a);
        }
        if (TiebaApplication.g().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                be.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.g().aD();
        TiebaApplication.g().a(getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onPause() {
        this.c.b();
        super.onPause();
        TiebaApplication.g().aE();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                be.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        if (this.b != null) {
            this.b.a();
        }
        super.onDestroy();
    }

    public e a() {
        return this.b;
    }

    public void a(String str) {
        this.c.a(str, 2000);
    }

    public void b(int i) {
        this.c.a(i, 2000);
    }

    @Override // android.support.v4.app.n, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.b == null) {
            this.b = new e();
        }
        this.b.a(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }
}
