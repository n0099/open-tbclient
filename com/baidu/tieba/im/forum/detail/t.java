package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.au;
import tbclient.RecommendForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ ItemFootNavView baV;
    private final /* synthetic */ BaseActivity baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ItemFootNavView itemFootNavView, BaseActivity baseActivity) {
        this.baV = itemFootNavView;
        this.baY = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        RecommendForumInfo recommendForumInfo;
        RecommendForumInfo recommendForumInfo2;
        aVar2 = this.baV.baU;
        aVar2.dismiss();
        au auVar = new au();
        auVar.setFrom("bar_detail");
        auVar.a(new u(this, this.baY));
        recommendForumInfo = this.baV.bay;
        String str = recommendForumInfo.forum_name;
        recommendForumInfo2 = this.baV.bay;
        auVar.i(str, recommendForumInfo2.forum_id.longValue());
    }
}
