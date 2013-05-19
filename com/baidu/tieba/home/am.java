package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.a.c;
        String trim = editText.getText().toString().trim();
        if (trim != null && trim.length() > 0) {
            com.baidu.tieba.d.ag.d(this.a, "http://m.baidu.com/s?from=1001157a&word=" + trim);
        } else {
            com.baidu.tieba.d.ag.d(this.a, "http://m.baidu.com/?from=1001157a");
        }
        StatService.onEvent(this.a, "search_in_baidu", "searchclick", 1);
    }
}
