package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity azv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(QuickSearchActivity quickSearchActivity) {
        this.azv = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TextView textView;
        ListView listView;
        editText = this.azv.azq;
        editText.setText("");
        textView = this.azv.azs;
        textView.setVisibility(8);
        listView = this.azv.azt;
        listView.setVisibility(8);
    }
}
