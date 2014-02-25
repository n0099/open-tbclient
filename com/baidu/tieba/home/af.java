package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.slidingmenu.lib.R;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ae a;
    private final /* synthetic */ v b;
    private final /* synthetic */ ai c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, v vVar, ai aiVar) {
        this.a = aeVar;
        this.b = vVar;
        this.c = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap hashMap;
        Context context;
        if (!this.b.k()) {
            this.c.i.setVisibility(4);
            this.c.j.setVisibility(0);
            this.c.k.setText(R.string.signallforum_resigning);
            this.b.c(true);
            au auVar = new au();
            auVar.a(this.a);
            String sb = new StringBuilder(String.valueOf(this.b.a())).toString();
            synchronized (this.a) {
                hashMap = this.a.g;
                hashMap.put(sb, auVar);
            }
            auVar.a(this.b.b(), sb);
            context = this.a.c;
            com.baidu.tieba.ai.a(context, "signall_resign_click");
        }
    }
}
