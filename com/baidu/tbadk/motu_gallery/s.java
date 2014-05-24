package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.a = rVar;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        JigsawAlbumListActivity jigsawAlbumListActivity;
        JigsawAlbumListActivity jigsawAlbumListActivity2;
        JigsawAlbumListActivity jigsawAlbumListActivity3;
        JigsawAlbumListActivity jigsawAlbumListActivity4;
        Context context;
        JigsawAlbumListActivity jigsawAlbumListActivity5;
        LinearLayout linearLayout;
        JigsawAlbumListActivity jigsawAlbumListActivity6;
        HorizontalScrollView horizontalScrollView;
        JigsawAlbumListActivity jigsawAlbumListActivity7;
        HorizontalScrollView horizontalScrollView2;
        JigsawAlbumListActivity jigsawAlbumListActivity8;
        JigsawAlbumListActivity jigsawAlbumListActivity9;
        JigsawAlbumListActivity jigsawAlbumListActivity10;
        LinearLayout linearLayout2;
        JigsawAlbumListActivity jigsawAlbumListActivity11;
        TextView textView;
        JigsawAlbumListActivity jigsawAlbumListActivity12;
        JigsawAlbumListActivity jigsawAlbumListActivity13;
        JigsawAlbumListActivity jigsawAlbumListActivity14;
        a aVar = (a) view;
        jigsawAlbumListActivity = this.a.a;
        u uVar = jigsawAlbumListActivity.a;
        jigsawAlbumListActivity2 = this.a.a;
        if (uVar.a(jigsawAlbumListActivity2) >= 10) {
            y.b(com.baidu.tieba.y.jigsaw_image_most);
        } else if (!b.a(this.b.b)) {
            y.b(com.baidu.tieba.y.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.b.c));
            jigsawAlbumListActivity3 = this.a.a;
            if (jigsawAlbumListActivity3.a.b(parse)) {
                jigsawAlbumListActivity14 = this.a.a;
                jigsawAlbumListActivity14.a(parse);
                return;
            }
            jigsawAlbumListActivity4 = this.a.a;
            x xVar = new x(jigsawAlbumListActivity4);
            context = this.a.b;
            int dimension = (int) context.getResources().getDimension(com.baidu.tieba.t.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            try {
                if (xVar.a(parse)) {
                    jigsawAlbumListActivity8 = this.a.a;
                    u uVar2 = jigsawAlbumListActivity8.a;
                    jigsawAlbumListActivity9 = this.a.a;
                    if (uVar2.a(jigsawAlbumListActivity9, parse)) {
                        jigsawAlbumListActivity10 = this.a.a;
                        linearLayout2 = jigsawAlbumListActivity10.m;
                        linearLayout2.addView(xVar);
                        jigsawAlbumListActivity11 = this.a.a;
                        textView = jigsawAlbumListActivity11.o;
                        jigsawAlbumListActivity12 = this.a.a;
                        u uVar3 = jigsawAlbumListActivity12.a;
                        jigsawAlbumListActivity13 = this.a.a;
                        textView.setText(uVar3.e(jigsawAlbumListActivity13));
                    }
                    aVar.setIsSelected(true);
                    xVar.setOnClickListener(new t(this, xVar, aVar));
                } else {
                    y.a(com.baidu.tieba.y.open_error);
                }
                jigsawAlbumListActivity5 = this.a.a;
                linearLayout = jigsawAlbumListActivity5.m;
                linearLayout.invalidate();
                jigsawAlbumListActivity6 = this.a.a;
                horizontalScrollView = jigsawAlbumListActivity6.n;
                horizontalScrollView.invalidate();
                jigsawAlbumListActivity7 = this.a.a;
                horizontalScrollView2 = jigsawAlbumListActivity7.n;
                horizontalScrollView2.fling(TbConfig.BIG_IMAGE_MIN_CAPACITY);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
