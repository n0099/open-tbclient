package com.baidu.tieba.im.mygroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity blD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonGroupActivity personGroupActivity) {
        this.blD = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.blD.QB();
    }
}
