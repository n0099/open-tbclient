package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.slidingmenu.lib.R;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ v a;
    final /* synthetic */ bk b;
    final /* synthetic */ bg c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar, v vVar, bk bkVar) {
        this.c = bgVar;
        this.a = vVar;
        this.b = bkVar;
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
            bw bwVar = new bw();
            bwVar.a(this.c);
            String str = this.a.a() + "";
            synchronized (this.c) {
                hashMap = this.c.g;
                hashMap.put(str, bwVar);
            }
            bwVar.a(this.a.b(), str);
            context = this.c.c;
            com.baidu.tieba.ao.a(context, "signall_resign_click");
        }
    }
}
