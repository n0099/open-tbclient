package com.baidu.tieba.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForbidActivity f1081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForbidActivity forbidActivity) {
        this.f1081a = forbidActivity;
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.f1081a.h;
        str = this.f1081a.g;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.f1081a.findViewById(R.id.radio_forbid_3).setVisibility(0);
            this.f1081a.findViewById(R.id.radio_forbid_10).setVisibility(0);
        }
        this.f1081a.j = new e(forbidTplData.reason);
        bdListView = this.f1081a.i;
        eVar = this.f1081a.j;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.f1081a.showToast(forbidTplData.error.b);
    }
}
