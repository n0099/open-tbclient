package com.baidu.tieba.im.mygroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bjc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonGroupActivity personGroupActivity) {
        this.bjc = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bjc.finish();
    }
}
