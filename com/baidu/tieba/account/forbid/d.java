package com.baidu.tieba.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n {
    final /* synthetic */ ForbidActivity agq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.agq = forbidActivity;
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.agq.agn;
        str = this.agq.mUserName;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.agq.findViewById(v.radio_forbid_3).setVisibility(0);
            this.agq.findViewById(v.radio_forbid_10).setVisibility(0);
        }
        this.agq.ago = new e(forbidTplData.reason);
        bdListView = this.agq.vl;
        eVar = this.agq.ago;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.agq.showToast(forbidTplData.error.errMsg);
    }
}
