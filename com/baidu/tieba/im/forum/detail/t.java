package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.au;
import tbclient.RecommendForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ ItemFootNavView baW;
    private final /* synthetic */ BaseActivity baZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ItemFootNavView itemFootNavView, BaseActivity baseActivity) {
        this.baW = itemFootNavView;
        this.baZ = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        RecommendForumInfo recommendForumInfo;
        RecommendForumInfo recommendForumInfo2;
        aVar2 = this.baW.baV;
        aVar2.dismiss();
        au auVar = new au();
        auVar.setFrom("bar_detail");
        auVar.a(new u(this, this.baZ));
        recommendForumInfo = this.baW.baz;
        String str = recommendForumInfo.forum_name;
        recommendForumInfo2 = this.baW.baz;
        auVar.i(str, recommendForumInfo2.forum_id.longValue());
    }
}
