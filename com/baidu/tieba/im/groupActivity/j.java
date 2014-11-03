package com.baidu.tieba.im.groupActivity;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ e aZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.aZh = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.aZh.aYR;
        editText.setText("");
    }
}
