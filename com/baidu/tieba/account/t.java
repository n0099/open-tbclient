package com.baidu.tieba.account;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f911a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.f911a = loginActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        View view2;
        view = this.f911a.G;
        if (view.getVisibility() != 8 || i != 4) {
            view2 = this.f911a.G;
            if (view2.getVisibility() != 0 || i != 6) {
                return false;
            }
        }
        this.f911a.n();
        return true;
    }
}
