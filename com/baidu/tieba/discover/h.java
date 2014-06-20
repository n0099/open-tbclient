package com.baidu.tieba.discover;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ DiscoverItemView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(DiscoverItemView discoverItemView) {
        this.a = discoverItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        boolean z;
        boolean z2;
        ImageView imageView;
        View.OnClickListener onClickListener2;
        onClickListener = this.a.q;
        if (onClickListener != null) {
            onClickListener2 = this.a.q;
            onClickListener2.onClick(view);
        }
        z = this.a.n;
        if (z) {
            z2 = this.a.o;
            if (z2) {
                String a = ak.a(this.a.c);
                if (!com.baidu.tbadk.f.a().a(a, false)) {
                    com.baidu.tbadk.f.a().b(a, true);
                    imageView = this.a.k;
                    imageView.setVisibility(8);
                }
            }
        }
    }
}
