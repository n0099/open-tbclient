package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1417a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(SearchActivity searchActivity) {
        this.f1417a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1417a.c;
        UtilHelper.i(this.f1417a, editText.getText().toString().trim());
    }
}
