package com.baidu.tieba.home;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        ap apVar;
        ap apVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        ap apVar3;
        ap apVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.B;
        if (i2 == 0) {
            com.baidu.tieba.d.k.k(str);
            FrsActivity.a(this.a, str, "tb_searchlist");
            apVar3 = this.a.o;
            apVar3.a(i);
            apVar4 = this.a.o;
            apVar4.notifyDataSetChanged();
            this.a.finish();
        } else if (str != null && str.length() > 0) {
            apVar = this.a.o;
            apVar.a(i);
            apVar2 = this.a.o;
            apVar2.notifyDataSetChanged();
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
