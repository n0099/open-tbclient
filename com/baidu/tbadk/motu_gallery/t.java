package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    private final /* synthetic */ x acG;
    final /* synthetic */ s adb;
    private final /* synthetic */ a adc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, x xVar, a aVar) {
        this.adb = sVar;
        this.acG = xVar;
        this.adc = aVar;
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
        rVar = this.adb.acZ;
        jigsawAlbumListActivity = rVar.acW;
        u uVar = jigsawAlbumListActivity.acr;
        rVar2 = this.adb.acZ;
        jigsawAlbumListActivity2 = rVar2.acW;
        uVar.d(jigsawAlbumListActivity2.getPageContext().getContext(), this.acG.getUri());
        this.adc.setIsSelected(false);
        rVar3 = this.adb.acZ;
        jigsawAlbumListActivity3 = rVar3.acW;
        linearLayout = jigsawAlbumListActivity3.acC;
        linearLayout.removeView(view);
        rVar4 = this.adb.acZ;
        jigsawAlbumListActivity4 = rVar4.acW;
        textView = jigsawAlbumListActivity4.acB;
        rVar5 = this.adb.acZ;
        jigsawAlbumListActivity5 = rVar5.acW;
        u uVar2 = jigsawAlbumListActivity5.acr;
        rVar6 = this.adb.acZ;
        jigsawAlbumListActivity6 = rVar6.acW;
        textView.setText(uVar2.ab(jigsawAlbumListActivity6.getPageContext().getContext()));
    }
}
