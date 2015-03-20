package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.ay;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
class u implements ay {
    private final /* synthetic */ BaseActivity bda;
    final /* synthetic */ t bdb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, BaseActivity baseActivity) {
        this.bdb = tVar;
        this.bda = baseActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void d(String str, long j) {
        ItemFootNavView itemFootNavView;
        ItemFootNavView itemFootNavView2;
        ItemFootNavView itemFootNavView3;
        RecommendForumInfo recommendForumInfo;
        ItemFootNavView itemFootNavView4;
        RecommendForumInfo recommendForumInfo2;
        ItemFootNavView itemFootNavView5;
        RecommendForumInfo recommendForumInfo3;
        itemFootNavView = this.bdb.bcX;
        itemFootNavView.cE(false);
        itemFootNavView2 = this.bdb.bcX;
        itemFootNavView2.cF(false);
        itemFootNavView3 = this.bdb.bcX;
        recommendForumInfo = itemFootNavView3.bcA;
        if (recommendForumInfo != null) {
            itemFootNavView4 = this.bdb.bcX;
            recommendForumInfo2 = itemFootNavView4.bcA;
            if (recommendForumInfo2.forum_id.longValue() != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, false));
                MessageManager messageManager = MessageManager.getInstance();
                StringBuilder sb = new StringBuilder();
                itemFootNavView5 = this.bdb.bcX;
                recommendForumInfo3 = itemFootNavView5.bcA;
                messageManager.sendMessage(new CustomMessage(2003004, sb.append(recommendForumInfo3.forum_id).toString()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void e(String str, long j) {
        this.bda.showToast(this.bda.getPageContext().getString(com.baidu.tieba.y.unlike_failure));
    }
}
