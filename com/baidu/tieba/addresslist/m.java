package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity aHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(QuickSearchActivity quickSearchActivity) {
        this.aHY = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.aHY.aHT;
        editText.setText("");
        this.aHY.aHV.setVisibility(8);
        this.aHY.aHW.setVisibility(8);
    }
}
