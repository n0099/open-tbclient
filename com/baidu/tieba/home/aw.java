package com.baidu.tieba.home;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SearchActivity searchActivity) {
        this.f1168a = searchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        if (z) {
            this.f1168a.b(0);
            radioButton = this.f1168a.m;
            radioButton.setChecked(false);
        }
    }
}
