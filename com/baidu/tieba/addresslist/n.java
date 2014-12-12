package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity aoo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(QuickSearchActivity quickSearchActivity) {
        this.aoo = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        View view2;
        ListView listView;
        editText = this.aoo.aoj;
        editText.setText("");
        view2 = this.aoo.aol;
        view2.setVisibility(8);
        listView = this.aoo.aom;
        listView.setVisibility(8);
    }
}
