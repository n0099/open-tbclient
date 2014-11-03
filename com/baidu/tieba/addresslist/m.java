package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity agY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(QuickSearchActivity quickSearchActivity) {
        this.agY = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        View view2;
        ListView listView;
        editText = this.agY.agT;
        editText.setText("");
        view2 = this.agY.agV;
        view2.setVisibility(8);
        listView = this.agY.agW;
        listView.setVisibility(8);
    }
}
