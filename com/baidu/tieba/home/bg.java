package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.slidingmenu.lib.R;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ u a;
    final /* synthetic */ bj b;
    final /* synthetic */ bf c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar, u uVar, bj bjVar) {
        this.c = bfVar;
        this.a = uVar;
        this.b = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap hashMap;
        Context context;
        if (!this.a.k()) {
            this.b.i.setVisibility(4);
            this.b.j.setVisibility(0);
            this.b.k.setText(R.string.signallforum_resigning);
            this.a.c(true);
            bu buVar = new bu();
            buVar.a(this.c);
            String str = this.a.a() + "";
            hashMap = this.c.g;
            hashMap.put(str, buVar);
            buVar.a(this.a.b(), str);
            context = this.c.c;
            com.baidu.tieba.ao.a(context, "signall_resign_click");
        }
    }
}
