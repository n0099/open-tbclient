package com.baidu.tieba.im.mygroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MyGroupActivity myGroupActivity;
        MyGroupActivity myGroupActivity2;
        MyGroupActivity myGroupActivity3;
        myGroupActivity = this.a.a;
        s sVar = new s(myGroupActivity);
        myGroupActivity2 = this.a.a;
        sVar.setUniqueId(myGroupActivity2.getUniqueId());
        myGroupActivity3 = this.a.a;
        myGroupActivity3.e_();
        sVar.a(0L);
    }
}
