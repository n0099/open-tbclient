package com.baidu.tieba.home;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SearchActivity searchActivity) {
        this.f1457a = searchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        if (z) {
            this.f1457a.a(1);
            radioButton = this.f1457a.i;
            radioButton.setChecked(false);
        }
    }
}
