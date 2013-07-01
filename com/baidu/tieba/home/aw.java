package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f911a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SearchActivity searchActivity) {
        this.f911a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f911a.f886a;
        String trim = editText.getText().toString().trim();
        if (trim != null && trim.length() > 0) {
            com.baidu.tieba.util.ab.d(this.f911a, "http://m.baidu.com/s?from=1001157a&word=" + trim);
        } else {
            com.baidu.tieba.util.ab.d(this.f911a, "http://m.baidu.com/?from=1001157a");
        }
        StatService.onEvent(this.f911a, "search_in_baidu", "searchclick", 1);
    }
}
