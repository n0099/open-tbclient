package com.baidu.tieba.home;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        az azVar;
        az azVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        az azVar3;
        az azVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.B;
        if (i2 == 0) {
            DatabaseService.n(str);
            FrsActivity.a(this.a, str, "tb_searchlist");
            azVar3 = this.a.o;
            azVar3.a(i);
            azVar4 = this.a.o;
            azVar4.notifyDataSetChanged();
            this.a.finish();
        } else if (str != null && str.length() > 0) {
            azVar = this.a.o;
            azVar.a(i);
            azVar2 = this.a.o;
            azVar2.notifyDataSetChanged();
            this.a.a(1, str);
            editText = this.a.a;
            editText.setText(str);
            editText2 = this.a.a;
            editText2.requestFocus();
            editText3 = this.a.a;
            Selection.setSelection(editText3.getText(), str.length());
        }
    }
}
