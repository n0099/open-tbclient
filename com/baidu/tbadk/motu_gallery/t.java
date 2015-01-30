package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    private final /* synthetic */ a adA;
    private final /* synthetic */ w ade;
    final /* synthetic */ s adz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, w wVar, a aVar) {
        this.adz = sVar;
        this.ade = wVar;
        this.adA = aVar;
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
        rVar = this.adz.adx;
        jigsawAlbumListActivity = rVar.adu;
        u uVar = jigsawAlbumListActivity.acP;
        rVar2 = this.adz.adx;
        jigsawAlbumListActivity2 = rVar2.adu;
        uVar.d(jigsawAlbumListActivity2.getPageContext().getContext(), this.ade.getUri());
        this.adA.setIsSelected(false);
        rVar3 = this.adz.adx;
        jigsawAlbumListActivity3 = rVar3.adu;
        linearLayout = jigsawAlbumListActivity3.acZ;
        linearLayout.removeView(view);
        rVar4 = this.adz.adx;
        jigsawAlbumListActivity4 = rVar4.adu;
        textView = jigsawAlbumListActivity4.acY;
        rVar5 = this.adz.adx;
        jigsawAlbumListActivity5 = rVar5.adu;
        u uVar2 = jigsawAlbumListActivity5.acP;
        rVar6 = this.adz.adx;
        jigsawAlbumListActivity6 = rVar6.adu;
        textView.setText(uVar2.ab(jigsawAlbumListActivity6.getPageContext().getContext()));
    }
}
