package com.baidu.tieba.im.mygroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonGroupActivity personGroupActivity) {
        this.a = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.n();
    }
}
