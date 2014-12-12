package com.baidu.tieba.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n {
    final /* synthetic */ ForbidActivity anH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.anH = forbidActivity;
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.anH.anE;
        str = this.anH.mUserName;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.anH.findViewById(w.radio_forbid_3).setVisibility(0);
            this.anH.findViewById(w.radio_forbid_10).setVisibility(0);
        }
        this.anH.anF = new e(forbidTplData.reason);
        bdListView = this.anH.mListView;
        eVar = this.anH.anF;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.anH.showToast(forbidTplData.error.errMsg);
    }
}
