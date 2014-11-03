package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bbH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bbH = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EllipsizingTextView ellipsizingTextView;
        ellipsizingTextView = this.bbH.baO;
        ellipsizingTextView.setMaxLines(1000);
    }
}
