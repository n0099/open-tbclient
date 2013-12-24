package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.location.LocationClientOption;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EllipsizingTextView ellipsizingTextView;
        ellipsizingTextView = this.a.h;
        ellipsizingTextView.setMaxLines(LocationClientOption.MIN_SCAN_SPAN);
    }
}
