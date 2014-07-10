package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(QuickSearchActivity quickSearchActivity) {
        this.a = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        View view2;
        ListView listView;
        editText = this.a.d;
        editText.setText("");
        view2 = this.a.f;
        view2.setVisibility(8);
        listView = this.a.g;
        listView.setVisibility(8);
    }
}
