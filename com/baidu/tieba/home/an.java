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
public class an implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SearchActivity searchActivity) {
        this.f1398a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        ba baVar;
        ba baVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        ba baVar3;
        ba baVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.f1398a.B;
        if (i2 == 0) {
            DatabaseService.m(str);
            FrsActivity.a(this.f1398a, str, "tb_searchlist");
            baVar3 = this.f1398a.o;
            baVar3.a(i);
            baVar4 = this.f1398a.o;
            baVar4.notifyDataSetChanged();
            this.f1398a.finish();
        } else if (str != null && str.length() > 0) {
            baVar = this.f1398a.o;
            baVar.a(i);
            baVar2 = this.f1398a.o;
            baVar2.notifyDataSetChanged();
            this.f1398a.a(1, str);
            editText = this.f1398a.c;
            editText.setText(str);
            editText2 = this.f1398a.c;
            editText2.requestFocus();
            editText3 = this.f1398a.c;
            Selection.setSelection(editText3.getText(), str.length());
        }
    }
}
