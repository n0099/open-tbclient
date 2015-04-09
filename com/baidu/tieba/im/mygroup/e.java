package com.baidu.tieba.im.mygroup;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity blD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonGroupActivity personGroupActivity) {
        this.blD = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.blD.finish();
    }
}
