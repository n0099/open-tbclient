package com.baidu.tieba.im.mygroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MyGroupActivity myGroupActivity;
        MyGroupActivity myGroupActivity2;
        MyGroupActivity myGroupActivity3;
        myGroupActivity = this.a.a;
        x xVar = new x(myGroupActivity);
        myGroupActivity2 = this.a.a;
        xVar.setUniqueId(myGroupActivity2.getUniqueId());
        myGroupActivity3 = this.a.a;
        myGroupActivity3.e_();
        xVar.a(0L);
    }
}
