package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SearchActivity searchActivity) {
        this.f1155a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1155a.c;
        UtilHelper.i(this.f1155a, editText.getText().toString().trim());
    }
}
