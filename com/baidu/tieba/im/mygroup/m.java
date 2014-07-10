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
        t tVar = new t();
        myGroupActivity = this.a.a;
        tVar.setUniqueId(myGroupActivity.getUniqueId());
        myGroupActivity2 = this.a.a;
        myGroupActivity2.e_();
        tVar.a(0L);
    }
}
