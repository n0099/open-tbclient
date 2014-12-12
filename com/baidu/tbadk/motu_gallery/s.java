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
    final /* synthetic */ r acZ;
    private final /* synthetic */ c ada;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.acZ = rVar;
        this.ada = cVar;
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
        jigsawAlbumListActivity = this.acZ.acW;
        u uVar = jigsawAlbumListActivity.acr;
        jigsawAlbumListActivity2 = this.acZ.acW;
        if (uVar.X(jigsawAlbumListActivity2.getPageContext().getContext()) >= 10) {
            y.showToastShort(z.jigsaw_image_most);
        } else if (!b.eu(this.ada.path)) {
            y.showToastShort(z.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.ada.ack));
            jigsawAlbumListActivity3 = this.acZ.acW;
            if (jigsawAlbumListActivity3.acr.g(parse)) {
                jigsawAlbumListActivity14 = this.acZ.acW;
                jigsawAlbumListActivity14.e(parse);
                return;
            }
            jigsawAlbumListActivity4 = this.acZ.acW;
            x xVar = new x(jigsawAlbumListActivity4.getPageContext().getContext());
            context = this.acZ.mContext;
            int dimension = (int) context.getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            xVar.setLayoutParams(layoutParams);
            try {
                if (xVar.h(parse)) {
                    jigsawAlbumListActivity8 = this.acZ.acW;
                    u uVar2 = jigsawAlbumListActivity8.acr;
                    jigsawAlbumListActivity9 = this.acZ.acW;
                    if (uVar2.c(jigsawAlbumListActivity9.getPageContext().getContext(), parse)) {
                        jigsawAlbumListActivity10 = this.acZ.acW;
                        linearLayout2 = jigsawAlbumListActivity10.acC;
                        linearLayout2.addView(xVar);
                        jigsawAlbumListActivity11 = this.acZ.acW;
                        textView = jigsawAlbumListActivity11.acB;
                        jigsawAlbumListActivity12 = this.acZ.acW;
                        u uVar3 = jigsawAlbumListActivity12.acr;
                        jigsawAlbumListActivity13 = this.acZ.acW;
                        textView.setText(uVar3.ab(jigsawAlbumListActivity13.getPageContext().getContext()));
                    }
                    aVar.setIsSelected(true);
                    xVar.setOnClickListener(new t(this, xVar, aVar));
                } else {
                    y.showToastLong(z.open_error);
                }
                jigsawAlbumListActivity5 = this.acZ.acW;
                linearLayout = jigsawAlbumListActivity5.acC;
                linearLayout.invalidate();
                jigsawAlbumListActivity6 = this.acZ.acW;
                horizontalScrollView = jigsawAlbumListActivity6.acR;
                horizontalScrollView.invalidate();
                jigsawAlbumListActivity7 = this.acZ.acW;
                horizontalScrollView2 = jigsawAlbumListActivity7.acR;
                horizontalScrollView2.fling(TbConfig.BIG_IMAGE_MIN_CAPACITY);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
