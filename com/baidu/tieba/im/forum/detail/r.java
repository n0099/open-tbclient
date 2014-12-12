package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.au;
import tbclient.RecommendForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ BaseActivity aZC;
    final /* synthetic */ ItemFootNavView aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ItemFootNavView itemFootNavView, BaseActivity baseActivity) {
        this.aZz = itemFootNavView;
        this.aZC = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        RecommendForumInfo recommendForumInfo;
        RecommendForumInfo recommendForumInfo2;
        aVar2 = this.aZz.aZy;
        aVar2.dismiss();
        au auVar = new au();
        auVar.setFrom("bar_detail");
        auVar.a(new s(this, this.aZC));
        recommendForumInfo = this.aZz.aZc;
        String str = recommendForumInfo.forum_name;
        recommendForumInfo2 = this.aZz.aZc;
        auVar.i(str, recommendForumInfo2.forum_id.longValue());
    }
}
