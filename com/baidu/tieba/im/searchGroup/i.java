package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1881a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f1881a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        e eVar;
        TextView textView;
        editText = this.f1881a.e;
        editText.setText("");
        eVar = this.f1881a.j;
        eVar.a(new LinkedList());
        textView = this.f1881a.h;
        textView.setVisibility(8);
    }
}
