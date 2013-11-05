package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SearchActivity searchActivity) {
        this.f1327a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1327a.c;
        UtilHelper.i(this.f1327a, editText.getText().toString().trim());
    }
}
