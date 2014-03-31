package com.baidu.tieba.discover;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {
    final /* synthetic */ DiscoverItemView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(DiscoverItemView discoverItemView) {
        this.a = discoverItemView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
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
                String a = ah.a(this.a.c);
                s.a();
                if (!s.a(a, false)) {
                    s.a();
                    s.b(a, true);
                    imageView = this.a.k;
                    imageView.setVisibility(8);
                }
            }
        }
    }
}
