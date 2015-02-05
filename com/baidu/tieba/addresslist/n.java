package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity apg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(QuickSearchActivity quickSearchActivity) {
        this.apg = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        View view2;
        ListView listView;
        editText = this.apg.apb;
        editText.setText("");
        view2 = this.apg.apd;
        view2.setVisibility(8);
        listView = this.apg.ape;
        listView.setVisibility(8);
    }
}
