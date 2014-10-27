package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ s bbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.bbt = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EllipsizingTextView ellipsizingTextView;
        ellipsizingTextView = this.bbt.baA;
        ellipsizingTextView.setMaxLines(1000);
    }
}
