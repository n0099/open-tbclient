package com.baidu.tieba.home;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        ax axVar;
        ax axVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        ax axVar3;
        ax axVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.D;
        if (i2 == 0) {
            com.baidu.tieba.c.k.j(str);
            FrsActivity.a(this.a, str, "tb_searchlist");
            axVar3 = this.a.l;
            axVar3.a(i);
            axVar4 = this.a.l;
            axVar4.notifyDataSetChanged();
            this.a.finish();
        } else if (str != null && str.length() > 0) {
            axVar = this.a.l;
            axVar.a(i);
            axVar2 = this.a.l;
            axVar2.notifyDataSetChanged();
            this.a.a(1, str);
            editText = this.a.c;
            editText.setText(str);
            editText2 = this.a.c;
            editText2.requestFocus();
            editText3 = this.a.c;
            Selection.setSelection(editText3.getText(), str.length());
        }
    }
}
