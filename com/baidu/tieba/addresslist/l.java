package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity axA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(QuickSearchActivity quickSearchActivity) {
        this.axA = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TextView textView;
        ListView listView;
        editText = this.axA.axv;
        editText.setText("");
        textView = this.axA.axx;
        textView.setVisibility(8);
        listView = this.axA.axy;
        listView.setVisibility(8);
    }
}
