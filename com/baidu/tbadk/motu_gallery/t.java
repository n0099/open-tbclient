package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ s WS;
    private final /* synthetic */ a WT;
    private final /* synthetic */ x Ww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, x xVar, a aVar) {
        this.WS = sVar;
        this.Ww = xVar;
        this.WT = aVar;
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
        rVar = this.WS.WQ;
        jigsawAlbumListActivity = rVar.WN;
        u uVar = jigsawAlbumListActivity.Wi;
        rVar2 = this.WS.WQ;
        jigsawAlbumListActivity2 = rVar2.WN;
        uVar.b(jigsawAlbumListActivity2, this.Ww.getUri());
        this.WT.setIsSelected(false);
        rVar3 = this.WS.WQ;
        jigsawAlbumListActivity3 = rVar3.WN;
        linearLayout = jigsawAlbumListActivity3.Ws;
        linearLayout.removeView(view);
        rVar4 = this.WS.WQ;
        jigsawAlbumListActivity4 = rVar4.WN;
        textView = jigsawAlbumListActivity4.Wr;
        rVar5 = this.WS.WQ;
        jigsawAlbumListActivity5 = rVar5.WN;
        u uVar2 = jigsawAlbumListActivity5.Wi;
        rVar6 = this.WS.WQ;
        jigsawAlbumListActivity6 = rVar6.WN;
        textView.setText(uVar2.E(jigsawAlbumListActivity6));
    }
}
