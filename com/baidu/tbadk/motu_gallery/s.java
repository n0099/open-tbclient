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
    final /* synthetic */ r WU;
    private final /* synthetic */ c WV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.WU = rVar;
        this.WV = cVar;
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
        jigsawAlbumListActivity = this.WU.WR;
        u uVar = jigsawAlbumListActivity.Wm;
        jigsawAlbumListActivity2 = this.WU.WR;
        if (uVar.A(jigsawAlbumListActivity2) >= 10) {
            y.dd(com.baidu.tieba.y.jigsaw_image_most);
        } else if (!b.dH(this.WV.path)) {
            y.dd(com.baidu.tieba.y.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.WV.Wf));
            jigsawAlbumListActivity3 = this.WU.WR;
            if (jigsawAlbumListActivity3.Wm.f(parse)) {
                jigsawAlbumListActivity14 = this.WU.WR;
                jigsawAlbumListActivity14.d(parse);
                return;
            }
            jigsawAlbumListActivity4 = this.WU.WR;
            x xVar = new x(jigsawAlbumListActivity4);
            context = this.WU.mContext;
            int dimension = (int) context.getResources().getDimension(com.baidu.tieba.t.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            try {
                if (xVar.g(parse)) {
                    jigsawAlbumListActivity8 = this.WU.WR;
                    u uVar2 = jigsawAlbumListActivity8.Wm;
                    jigsawAlbumListActivity9 = this.WU.WR;
                    if (uVar2.a(jigsawAlbumListActivity9, parse)) {
                        jigsawAlbumListActivity10 = this.WU.WR;
                        linearLayout2 = jigsawAlbumListActivity10.Ww;
                        linearLayout2.addView(xVar);
                        jigsawAlbumListActivity11 = this.WU.WR;
                        textView = jigsawAlbumListActivity11.Wv;
                        jigsawAlbumListActivity12 = this.WU.WR;
                        u uVar3 = jigsawAlbumListActivity12.Wm;
                        jigsawAlbumListActivity13 = this.WU.WR;
                        textView.setText(uVar3.E(jigsawAlbumListActivity13));
                    }
                    aVar.setIsSelected(true);
                    xVar.setOnClickListener(new t(this, xVar, aVar));
                } else {
                    y.dc(com.baidu.tieba.y.open_error);
                }
                jigsawAlbumListActivity5 = this.WU.WR;
                linearLayout = jigsawAlbumListActivity5.Ww;
                linearLayout.invalidate();
                jigsawAlbumListActivity6 = this.WU.WR;
                horizontalScrollView = jigsawAlbumListActivity6.WM;
                horizontalScrollView.invalidate();
                jigsawAlbumListActivity7 = this.WU.WR;
                horizontalScrollView2 = jigsawAlbumListActivity7.WM;
                horizontalScrollView2.fling(TbConfig.BIG_IMAGE_MIN_CAPACITY);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
