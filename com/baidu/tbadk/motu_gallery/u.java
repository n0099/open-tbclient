package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements View.OnClickListener {
    final /* synthetic */ t a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, c cVar) {
        this.a = tVar;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        Context context;
        n nVar5;
        LinearLayout linearLayout;
        n nVar6;
        HorizontalScrollView horizontalScrollView;
        n nVar7;
        HorizontalScrollView horizontalScrollView2;
        n nVar8;
        n nVar9;
        n nVar10;
        LinearLayout linearLayout2;
        n nVar11;
        TextView textView;
        n nVar12;
        n nVar13;
        n nVar14;
        a aVar = (a) view;
        nVar = this.a.a;
        w wVar = nVar.a;
        nVar2 = this.a.a;
        if (wVar.a(nVar2) >= 10) {
            z.b(com.baidu.tbadk.l.jigsaw_image_most);
        } else if (!b.a(this.b.b)) {
            z.b(com.baidu.tbadk.l.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.b.c));
            nVar3 = this.a.a;
            if (nVar3.a.b(parse)) {
                nVar14 = this.a.a;
                n.a(nVar14, parse);
                return;
            }
            nVar4 = this.a.a;
            y yVar = new y(nVar4);
            context = this.a.b;
            int dimension = (int) context.getResources().getDimension(com.baidu.tbadk.h.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            yVar.setLayoutParams(layoutParams);
            try {
                if (yVar.a(parse)) {
                    nVar8 = this.a.a;
                    w wVar2 = nVar8.a;
                    nVar9 = this.a.a;
                    if (wVar2.a(nVar9, parse)) {
                        nVar10 = this.a.a;
                        linearLayout2 = nVar10.m;
                        linearLayout2.addView(yVar);
                        nVar11 = this.a.a;
                        textView = nVar11.o;
                        nVar12 = this.a.a;
                        w wVar3 = nVar12.a;
                        nVar13 = this.a.a;
                        textView.setText(wVar3.c(nVar13));
                    }
                    aVar.setIsSelected(true);
                    yVar.setOnClickListener(new v(this, yVar, aVar));
                } else {
                    z.a(com.baidu.tbadk.l.open_error);
                }
                nVar5 = this.a.a;
                linearLayout = nVar5.m;
                linearLayout.invalidate();
                nVar6 = this.a.a;
                horizontalScrollView = nVar6.n;
                horizontalScrollView.invalidate();
                nVar7 = this.a.a;
                horizontalScrollView2 = nVar7.n;
                horizontalScrollView2.fling(10000);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
