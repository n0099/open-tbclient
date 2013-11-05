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
public class ae implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1331a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SearchActivity searchActivity) {
        this.f1331a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        ar arVar;
        ar arVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        ar arVar3;
        ar arVar4;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.f1331a.E;
        if (i2 == 0) {
            DatabaseService.l(str);
            FrsActivity.a(this.f1331a, str, "tb_searchlist");
            arVar3 = this.f1331a.r;
            arVar3.a(i);
            arVar4 = this.f1331a.r;
            arVar4.notifyDataSetChanged();
            this.f1331a.finish();
        } else if (str != null && str.length() > 0) {
            arVar = this.f1331a.r;
            arVar.a(i);
            arVar2 = this.f1331a.r;
            arVar2.notifyDataSetChanged();
            this.f1331a.a(1, str);
            editText = this.f1331a.c;
            editText.setText(str);
            editText2 = this.f1331a.c;
            editText2.requestFocus();
            editText3 = this.f1331a.c;
            Selection.setSelection(editText3.getText(), str.length());
        }
    }
}
