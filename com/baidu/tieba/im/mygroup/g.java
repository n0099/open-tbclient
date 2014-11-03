package com.baidu.tieba.im.mygroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonGroupActivity personGroupActivity) {
        this.bfQ = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bfQ.Nr();
    }
}
