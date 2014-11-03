package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    private final /* synthetic */ x WA;
    final /* synthetic */ s WW;
    private final /* synthetic */ a WX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, x xVar, a aVar) {
        this.WW = sVar;
        this.WA = xVar;
        this.WX = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        JigsawAlbumListActivity jigsawAlbumListActivity;
        r rVar2;
        JigsawAlbumListActivity jigsawAlbumListActivity2;
        r rVar3;
        JigsawAlbumListActivity jigsawAlbumListActivity3;
        LinearLayout linearLayout;
        r rVar4;
        JigsawAlbumListActivity jigsawAlbumListActivity4;
        TextView textView;
        r rVar5;
        JigsawAlbumListActivity jigsawAlbumListActivity5;
        r rVar6;
        JigsawAlbumListActivity jigsawAlbumListActivity6;
        rVar = this.WW.WU;
        jigsawAlbumListActivity = rVar.WR;
        u uVar = jigsawAlbumListActivity.Wm;
        rVar2 = this.WW.WU;
        jigsawAlbumListActivity2 = rVar2.WR;
        uVar.b(jigsawAlbumListActivity2, this.WA.getUri());
        this.WX.setIsSelected(false);
        rVar3 = this.WW.WU;
        jigsawAlbumListActivity3 = rVar3.WR;
        linearLayout = jigsawAlbumListActivity3.Ww;
        linearLayout.removeView(view);
        rVar4 = this.WW.WU;
        jigsawAlbumListActivity4 = rVar4.WR;
        textView = jigsawAlbumListActivity4.Wv;
        rVar5 = this.WW.WU;
        jigsawAlbumListActivity5 = rVar5.WR;
        u uVar2 = jigsawAlbumListActivity5.Wm;
        rVar6 = this.WW.WU;
        jigsawAlbumListActivity6 = rVar6.WR;
        textView.setText(uVar2.E(jigsawAlbumListActivity6));
    }
}
