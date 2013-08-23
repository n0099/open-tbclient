package com.baidu.tieba.home;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(SearchActivity searchActivity) {
        this.f1169a = searchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        if (z) {
            this.f1169a.b(1);
            radioButton = this.f1169a.l;
            radioButton.setChecked(false);
        }
    }
}
