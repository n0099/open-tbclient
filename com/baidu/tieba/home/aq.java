package com.baidu.tieba.home;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SearchActivity searchActivity) {
        this.f1456a = searchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        if (z) {
            this.f1456a.a(0);
            radioButton = this.f1456a.j;
            radioButton.setChecked(false);
        }
    }
}
