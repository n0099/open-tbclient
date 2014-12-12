package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.av;
import com.baidu.tieba.z;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
class s implements av {
    private final /* synthetic */ BaseActivity aZC;
    final /* synthetic */ r aZD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, BaseActivity baseActivity) {
        this.aZD = rVar;
        this.aZC = baseActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void f(String str, long j) {
        ItemFootNavView itemFootNavView;
        ItemFootNavView itemFootNavView2;
        ItemFootNavView itemFootNavView3;
        RecommendForumInfo recommendForumInfo;
        ItemFootNavView itemFootNavView4;
        RecommendForumInfo recommendForumInfo2;
        ItemFootNavView itemFootNavView5;
        RecommendForumInfo recommendForumInfo3;
        itemFootNavView = this.aZD.aZz;
        itemFootNavView.cL(false);
        itemFootNavView2 = this.aZD.aZz;
        itemFootNavView2.cM(false);
        itemFootNavView3 = this.aZD.aZz;
        recommendForumInfo = itemFootNavView3.aZc;
        if (recommendForumInfo != null) {
            itemFootNavView4 = this.aZD.aZz;
            recommendForumInfo2 = itemFootNavView4.aZc;
            if (recommendForumInfo2.forum_id.longValue() != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, false));
                MessageManager messageManager = MessageManager.getInstance();
                StringBuilder sb = new StringBuilder();
                itemFootNavView5 = this.aZD.aZz;
                recommendForumInfo3 = itemFootNavView5.aZc;
                messageManager.sendMessage(new CustomMessage(2003004, sb.append(recommendForumInfo3.forum_id).toString()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void g(String str, long j) {
        this.aZC.showToast(this.aZC.getPageContext().getString(z.unlike_failure));
    }
}
