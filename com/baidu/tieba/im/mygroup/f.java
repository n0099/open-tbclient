package com.baidu.tieba.im.mygroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bfC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonGroupActivity personGroupActivity) {
        this.bfC = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bfC.finish();
    }
}
