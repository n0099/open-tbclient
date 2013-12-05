package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.slidingmenu.lib.R;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1471a;
    final /* synthetic */ bj b;
    final /* synthetic */ bf c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar, u uVar, bj bjVar) {
        this.c = bfVar;
        this.f1471a = uVar;
        this.b = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap hashMap;
        Context context;
        if (!this.f1471a.k()) {
            this.b.i.setVisibility(4);
            this.b.j.setVisibility(0);
            this.b.k.setText(R.string.signallforum_resigning);
            this.f1471a.c(true);
            bu buVar = new bu();
            buVar.a(this.c);
            String str = this.f1471a.a() + "";
            hashMap = this.c.g;
            hashMap.put(str, buVar);
            buVar.a(this.f1471a.b(), str);
            context = this.c.c;
            com.baidu.tieba.ap.a(context, "signall_resign_click");
        }
    }
}
