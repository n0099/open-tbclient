package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity azu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(QuickSearchActivity quickSearchActivity) {
        this.azu = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TextView textView;
        ListView listView;
        editText = this.azu.azp;
        editText.setText("");
        textView = this.azu.azr;
        textView.setVisibility(8);
        listView = this.azu.azs;
        listView.setVisibility(8);
    }
}
