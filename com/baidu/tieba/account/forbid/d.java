package com.baidu.tieba.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n {
    final /* synthetic */ ForbidActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.a = forbidActivity;
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.a.h;
        str = this.a.g;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.a.findViewById(R.id.radio_forbid_3).setVisibility(0);
            this.a.findViewById(R.id.radio_forbid_10).setVisibility(0);
        }
        this.a.j = new e(forbidTplData.reason);
        bdListView = this.a.i;
        eVar = this.a.j;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.a.showToast(forbidTplData.error.b);
    }
}
