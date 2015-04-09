package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity axI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(QuickSearchActivity quickSearchActivity) {
        this.axI = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TextView textView;
        ListView listView;
        editText = this.axI.axD;
        editText.setText("");
        textView = this.axI.axF;
        textView.setVisibility(8);
        listView = this.axI.axG;
        listView.setVisibility(8);
    }
}
