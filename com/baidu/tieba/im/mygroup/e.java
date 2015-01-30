package com.baidu.tieba.im.mygroup;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonGroupActivity personGroupActivity) {
        this.bkz = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bkz.finish();
    }
}
