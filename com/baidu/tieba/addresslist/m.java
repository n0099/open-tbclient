package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity agP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(QuickSearchActivity quickSearchActivity) {
        this.agP = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        View view2;
        ListView listView;
        editText = this.agP.agK;
        editText.setText("");
        view2 = this.agP.agM;
        view2.setVisibility(8);
        listView = this.agP.agN;
        listView.setVisibility(8);
    }
}
