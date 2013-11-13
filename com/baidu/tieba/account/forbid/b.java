package com.baidu.tieba.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForbidActivity f1067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForbidActivity forbidActivity) {
        this.f1067a = forbidActivity;
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.f1067a.g;
        str = this.f1067a.f;
        textView.setText(str);
        this.f1067a.i = new e(forbidTplData.reason);
        bdListView = this.f1067a.h;
        eVar = this.f1067a.i;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.f1067a.showToast(forbidTplData.error.b);
    }
}
