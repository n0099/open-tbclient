package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends android.support.v4.app.n {

    /* renamed from: a  reason: collision with root package name */
    private int f839a = -1;

    protected abstract void a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.t(true);
        TiebaApplication.g().a(getClass().getName());
        if (TiebaApplication.g().u()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.g.a());
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.g().an() != this.f839a) {
            this.f839a = TiebaApplication.g().an();
            a(this.f839a);
        }
        if (TiebaApplication.g().u()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.g().aA();
        TiebaApplication.g().a(getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.g().aB();
        if (TiebaApplication.g().u()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }
}
