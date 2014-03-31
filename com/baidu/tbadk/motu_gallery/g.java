package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
final class g implements View.OnClickListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
