package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.ax;
import tbclient.RecommendForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ ItemFootNavView bdn;
    private final /* synthetic */ BaseActivity bdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ItemFootNavView itemFootNavView, BaseActivity baseActivity) {
        this.bdn = itemFootNavView;
        this.bdq = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        RecommendForumInfo recommendForumInfo;
        RecommendForumInfo recommendForumInfo2;
        aVar2 = this.bdn.bdm;
        aVar2.dismiss();
        ax axVar = new ax();
        axVar.setFrom("bar_detail");
        axVar.a(new u(this, this.bdq));
        recommendForumInfo = this.bdn.bcQ;
        String str = recommendForumInfo.forum_name;
        recommendForumInfo2 = this.bdn.bcQ;
        axVar.i(str, recommendForumInfo2.forum_id.longValue());
    }
}
