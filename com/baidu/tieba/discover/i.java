package com.baidu.tieba.discover;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ DiscoverItemView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(DiscoverItemView discoverItemView) {
        this.a = discoverItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        boolean z;
        boolean z2;
        ImageView imageView;
        View.OnClickListener onClickListener2;
        onClickListener = this.a.p;
        if (onClickListener != null) {
            onClickListener2 = this.a.p;
            onClickListener2.onClick(view);
        }
        z = this.a.m;
        if (z) {
            z2 = this.a.n;
            if (z2) {
                String a = an.a(this.a.d);
                if (!com.baidu.tbadk.i.a().a(a, false)) {
                    com.baidu.tbadk.i.a().c(a, true);
                    imageView = this.a.j;
                    imageView.setVisibility(8);
                }
            }
        }
    }
}
