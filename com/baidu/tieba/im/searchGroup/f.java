package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f1703a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        b bVar;
        TextView textView;
        editText = this.f1703a.e;
        editText.setText("");
        bVar = this.f1703a.j;
        bVar.a(new LinkedList());
        textView = this.f1703a.h;
        textView.setVisibility(8);
    }
}
