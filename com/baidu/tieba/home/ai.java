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
public class ai implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        av avVar;
        av avVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        av avVar3;
        av avVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.a.B;
        if (i2 == 0) {
            DatabaseService.m(str);
            FrsActivity.a(this.a, str, "tb_searchlist");
            avVar3 = this.a.o;
            avVar3.a(i);
            avVar4 = this.a.o;
            avVar4.notifyDataSetChanged();
            this.a.finish();
        } else if (str != null && str.length() > 0) {
            avVar = this.a.o;
            avVar.a(i);
            avVar2 = this.a.o;
            avVar2.notifyDataSetChanged();
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
