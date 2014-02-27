package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.location.LocationClientOption;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EllipsizingTextView ellipsizingTextView;
        ellipsizingTextView = this.a.n;
        ellipsizingTextView.setMaxLines(LocationClientOption.MIN_SCAN_SPAN);
    }
}
