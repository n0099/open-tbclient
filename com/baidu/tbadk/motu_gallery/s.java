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
    final /* synthetic */ r adu;
    private final /* synthetic */ c adv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.adu = rVar;
        this.adv = cVar;
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
        jigsawAlbumListActivity = this.adu.adr;
        u uVar = jigsawAlbumListActivity.acM;
        jigsawAlbumListActivity2 = this.adu.adr;
        if (uVar.X(jigsawAlbumListActivity2.getPageContext().getContext()) >= 10) {
            x.showToastShort(z.jigsaw_image_most);
        } else if (!b.er(this.adv.path)) {
            x.showToastShort(z.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.adv.acF));
            jigsawAlbumListActivity3 = this.adu.adr;
            if (jigsawAlbumListActivity3.acM.g(parse)) {
                jigsawAlbumListActivity14 = this.adu.adr;
                jigsawAlbumListActivity14.e(parse);
                return;
            }
            jigsawAlbumListActivity4 = this.adu.adr;
            w wVar = new w(jigsawAlbumListActivity4.getPageContext().getContext());
            context = this.adu.mContext;
            int dimension = (int) context.getResources().getDimension(com.baidu.tieba.u.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            try {
                if (wVar.h(parse)) {
                    jigsawAlbumListActivity8 = this.adu.adr;
                    u uVar2 = jigsawAlbumListActivity8.acM;
                    jigsawAlbumListActivity9 = this.adu.adr;
                    if (uVar2.c(jigsawAlbumListActivity9.getPageContext().getContext(), parse)) {
                        jigsawAlbumListActivity10 = this.adu.adr;
                        linearLayout2 = jigsawAlbumListActivity10.acW;
                        linearLayout2.addView(wVar);
                        jigsawAlbumListActivity11 = this.adu.adr;
                        textView = jigsawAlbumListActivity11.acV;
                        jigsawAlbumListActivity12 = this.adu.adr;
                        u uVar3 = jigsawAlbumListActivity12.acM;
                        jigsawAlbumListActivity13 = this.adu.adr;
                        textView.setText(uVar3.ab(jigsawAlbumListActivity13.getPageContext().getContext()));
                    }
                    aVar.setIsSelected(true);
                    wVar.setOnClickListener(new t(this, wVar, aVar));
                } else {
                    x.showToastLong(z.open_error);
                }
                jigsawAlbumListActivity5 = this.adu.adr;
                linearLayout = jigsawAlbumListActivity5.acW;
                linearLayout.invalidate();
                jigsawAlbumListActivity6 = this.adu.adr;
                horizontalScrollView = jigsawAlbumListActivity6.adm;
                horizontalScrollView.invalidate();
                jigsawAlbumListActivity7 = this.adu.adr;
                horizontalScrollView2 = jigsawAlbumListActivity7.adm;
                horizontalScrollView2.fling(TbConfig.BIG_IMAGE_MIN_CAPACITY);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
