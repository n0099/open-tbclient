package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    private final /* synthetic */ w ada;
    final /* synthetic */ s adw;
    private final /* synthetic */ a adx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, w wVar, a aVar) {
        this.adw = sVar;
        this.ada = wVar;
        this.adx = aVar;
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
        rVar = this.adw.adu;
        jigsawAlbumListActivity = rVar.adr;
        u uVar = jigsawAlbumListActivity.acM;
        rVar2 = this.adw.adu;
        jigsawAlbumListActivity2 = rVar2.adr;
        uVar.d(jigsawAlbumListActivity2.getPageContext().getContext(), this.ada.getUri());
        this.adx.setIsSelected(false);
        rVar3 = this.adw.adu;
        jigsawAlbumListActivity3 = rVar3.adr;
        linearLayout = jigsawAlbumListActivity3.acW;
        linearLayout.removeView(view);
        rVar4 = this.adw.adu;
        jigsawAlbumListActivity4 = rVar4.adr;
        textView = jigsawAlbumListActivity4.acV;
        rVar5 = this.adw.adu;
        jigsawAlbumListActivity5 = rVar5.adr;
        u uVar2 = jigsawAlbumListActivity5.acM;
        rVar6 = this.adw.adu;
        jigsawAlbumListActivity6 = rVar6.adr;
        textView.setText(uVar2.ab(jigsawAlbumListActivity6.getPageContext().getContext()));
    }
}
