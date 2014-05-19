package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        e eVar;
        TextView textView;
        editText = this.a.e;
        editText.setText("");
        eVar = this.a.j;
        eVar.a(new LinkedList());
        textView = this.a.h;
        textView.setVisibility(8);
    }
}
