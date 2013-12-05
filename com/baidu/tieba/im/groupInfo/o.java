package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.location.LocationClientOption;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.f1755a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EllipsizingTextView ellipsizingTextView;
        ellipsizingTextView = this.f1755a.h;
        ellipsizingTextView.setMaxLines(LocationClientOption.MIN_SCAN_SPAN);
    }
}
