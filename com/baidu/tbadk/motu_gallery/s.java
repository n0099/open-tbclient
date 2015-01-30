package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ r adx;
    private final /* synthetic */ c ady;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.adx = rVar;
        this.ady = cVar;
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
        jigsawAlbumListActivity = this.adx.adu;
        u uVar = jigsawAlbumListActivity.acP;
        jigsawAlbumListActivity2 = this.adx.adu;
        if (uVar.X(jigsawAlbumListActivity2.getPageContext().getContext()) >= 10) {
            x.showToastShort(z.jigsaw_image_most);
        } else if (!b.eu(this.ady.path)) {
            x.showToastShort(z.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.ady.acI));
            jigsawAlbumListActivity3 = this.adx.adu;
            if (jigsawAlbumListActivity3.acP.g(parse)) {
                jigsawAlbumListActivity14 = this.adx.adu;
                jigsawAlbumListActivity14.e(parse);
                return;
            }
            jigsawAlbumListActivity4 = this.adx.adu;
            w wVar = new w(jigsawAlbumListActivity4.getPageContext().getContext());
            context = this.adx.mContext;
            int dimension = (int) context.getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            try {
                if (wVar.h(parse)) {
                    jigsawAlbumListActivity8 = this.adx.adu;
                    u uVar2 = jigsawAlbumListActivity8.acP;
                    jigsawAlbumListActivity9 = this.adx.adu;
                    if (uVar2.c(jigsawAlbumListActivity9.getPageContext().getContext(), parse)) {
                        jigsawAlbumListActivity10 = this.adx.adu;
                        linearLayout2 = jigsawAlbumListActivity10.acZ;
                        linearLayout2.addView(wVar);
                        jigsawAlbumListActivity11 = this.adx.adu;
                        textView = jigsawAlbumListActivity11.acY;
                        jigsawAlbumListActivity12 = this.adx.adu;
                        u uVar3 = jigsawAlbumListActivity12.acP;
                        jigsawAlbumListActivity13 = this.adx.adu;
                        textView.setText(uVar3.ab(jigsawAlbumListActivity13.getPageContext().getContext()));
                    }
                    aVar.setIsSelected(true);
                    wVar.setOnClickListener(new t(this, wVar, aVar));
                } else {
                    x.showToastLong(z.open_error);
                }
                jigsawAlbumListActivity5 = this.adx.adu;
                linearLayout = jigsawAlbumListActivity5.acZ;
                linearLayout.invalidate();
                jigsawAlbumListActivity6 = this.adx.adu;
                horizontalScrollView = jigsawAlbumListActivity6.adp;
                horizontalScrollView.invalidate();
                jigsawAlbumListActivity7 = this.adx.adu;
                horizontalScrollView2 = jigsawAlbumListActivity7.adp;
                horizontalScrollView2.fling(TbConfig.BIG_IMAGE_MIN_CAPACITY);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
