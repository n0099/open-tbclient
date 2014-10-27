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
    final /* synthetic */ r WQ;
    private final /* synthetic */ c WR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.WQ = rVar;
        this.WR = cVar;
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
        jigsawAlbumListActivity = this.WQ.WN;
        u uVar = jigsawAlbumListActivity.Wi;
        jigsawAlbumListActivity2 = this.WQ.WN;
        if (uVar.A(jigsawAlbumListActivity2) >= 10) {
            y.dd(com.baidu.tieba.y.jigsaw_image_most);
        } else if (!b.dH(this.WR.path)) {
            y.dd(com.baidu.tieba.y.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.WR.Wb));
            jigsawAlbumListActivity3 = this.WQ.WN;
            if (jigsawAlbumListActivity3.Wi.f(parse)) {
                jigsawAlbumListActivity14 = this.WQ.WN;
                jigsawAlbumListActivity14.d(parse);
                return;
            }
            jigsawAlbumListActivity4 = this.WQ.WN;
            x xVar = new x(jigsawAlbumListActivity4);
            context = this.WQ.mContext;
            int dimension = (int) context.getResources().getDimension(com.baidu.tieba.t.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            try {
                if (xVar.g(parse)) {
                    jigsawAlbumListActivity8 = this.WQ.WN;
                    u uVar2 = jigsawAlbumListActivity8.Wi;
                    jigsawAlbumListActivity9 = this.WQ.WN;
                    if (uVar2.a(jigsawAlbumListActivity9, parse)) {
                        jigsawAlbumListActivity10 = this.WQ.WN;
                        linearLayout2 = jigsawAlbumListActivity10.Ws;
                        linearLayout2.addView(xVar);
                        jigsawAlbumListActivity11 = this.WQ.WN;
                        textView = jigsawAlbumListActivity11.Wr;
                        jigsawAlbumListActivity12 = this.WQ.WN;
                        u uVar3 = jigsawAlbumListActivity12.Wi;
                        jigsawAlbumListActivity13 = this.WQ.WN;
                        textView.setText(uVar3.E(jigsawAlbumListActivity13));
                    }
                    aVar.setIsSelected(true);
                    xVar.setOnClickListener(new t(this, xVar, aVar));
                } else {
                    y.dc(com.baidu.tieba.y.open_error);
                }
                jigsawAlbumListActivity5 = this.WQ.WN;
                linearLayout = jigsawAlbumListActivity5.Ws;
                linearLayout.invalidate();
                jigsawAlbumListActivity6 = this.WQ.WN;
                horizontalScrollView = jigsawAlbumListActivity6.WI;
                horizontalScrollView.invalidate();
                jigsawAlbumListActivity7 = this.WQ.WN;
                horizontalScrollView2 = jigsawAlbumListActivity7.WI;
                horizontalScrollView2.fling(TbConfig.BIG_IMAGE_MIN_CAPACITY);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
