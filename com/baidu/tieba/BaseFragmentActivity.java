package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends android.support.v4.app.n {

    /* renamed from: a  reason: collision with root package name */
    private int f818a = -1;

    protected abstract void c(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.u(true);
        TiebaApplication.f().a(getClass().getName());
        if (TiebaApplication.f().t()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.g.a());
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.f().au() != this.f818a) {
            this.f818a = TiebaApplication.f().au();
            c(this.f818a);
        }
        if (TiebaApplication.f().t()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.f().aJ();
        TiebaApplication.f().a(getClass().getName());
    }
}
