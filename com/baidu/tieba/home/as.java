package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1458a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SearchActivity searchActivity) {
        this.f1458a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1458a.c;
        UtilHelper.h(this.f1458a, editText.getText().toString().trim());
    }
}
