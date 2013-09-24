package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SearchActivity searchActivity) {
        this.f1229a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1229a.c;
        UtilHelper.i(this.f1229a, editText.getText().toString().trim());
    }
}
