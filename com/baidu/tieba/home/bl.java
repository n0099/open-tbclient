package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.slidingmenu.lib.R;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f1421a;
    final /* synthetic */ bo b;
    final /* synthetic */ bk c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar, z zVar, bo boVar) {
        this.c = bkVar;
        this.f1421a = zVar;
        this.b = boVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap hashMap;
        Context context;
        if (!this.f1421a.k()) {
            this.b.i.setVisibility(4);
            this.b.j.setVisibility(0);
            this.b.k.setText(R.string.signallforum_resigning);
            this.f1421a.c(true);
            bz bzVar = new bz();
            bzVar.a(this.c);
            String str = this.f1421a.a() + "";
            hashMap = this.c.g;
            hashMap.put(str, bzVar);
            bzVar.a(this.f1421a.b(), str);
            context = this.c.c;
            com.baidu.tieba.al.a(context, "signall_resign_click");
        }
    }
}
