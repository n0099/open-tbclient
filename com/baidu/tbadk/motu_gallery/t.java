package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ s a;
    private final /* synthetic */ x b;
    private final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, x xVar, a aVar) {
        this.a = sVar;
        this.b = xVar;
        this.c = aVar;
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
        rVar = this.a.a;
        jigsawAlbumListActivity = rVar.a;
        u uVar = jigsawAlbumListActivity.a;
        rVar2 = this.a.a;
        jigsawAlbumListActivity2 = rVar2.a;
        uVar.b(jigsawAlbumListActivity2, this.b.getUri());
        this.c.setIsSelected(false);
        rVar3 = this.a.a;
        jigsawAlbumListActivity3 = rVar3.a;
        linearLayout = jigsawAlbumListActivity3.m;
        linearLayout.removeView(view);
        rVar4 = this.a.a;
        jigsawAlbumListActivity4 = rVar4.a;
        textView = jigsawAlbumListActivity4.o;
        rVar5 = this.a.a;
        jigsawAlbumListActivity5 = rVar5.a;
        u uVar2 = jigsawAlbumListActivity5.a;
        rVar6 = this.a.a;
        jigsawAlbumListActivity6 = rVar6.a;
        textView.setText(uVar2.e(jigsawAlbumListActivity6));
    }
}
