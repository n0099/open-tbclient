package com.baidu.tieba.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n {
    final /* synthetic */ ForbidActivity aoz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.aoz = forbidActivity;
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.aoz.aow;
        str = this.aoz.mUserName;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.aoz.findViewById(w.radio_forbid_3).setVisibility(0);
            this.aoz.findViewById(w.radio_forbid_10).setVisibility(0);
        }
        this.aoz.aox = new e(forbidTplData.reason);
        bdListView = this.aoz.mListView;
        eVar = this.aoz.aox;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.aoz.showToast(forbidTplData.error.errMsg);
    }
}
