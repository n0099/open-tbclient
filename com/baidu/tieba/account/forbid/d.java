package com.baidu.tieba.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n {
    final /* synthetic */ ForbidActivity agi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.agi = forbidActivity;
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.agi.agf;
        str = this.agi.mUserName;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.agi.findViewById(v.radio_forbid_3).setVisibility(0);
            this.agi.findViewById(v.radio_forbid_10).setVisibility(0);
        }
        this.agi.agg = new e(forbidTplData.reason);
        bdListView = this.agi.vl;
        eVar = this.agi.agg;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.agi.showToast(forbidTplData.error.errMsg);
    }
}
