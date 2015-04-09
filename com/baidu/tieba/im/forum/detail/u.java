package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.ay;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
class u implements ay {
    private final /* synthetic */ BaseActivity bdq;
    final /* synthetic */ t bdr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, BaseActivity baseActivity) {
        this.bdr = tVar;
        this.bdq = baseActivity;
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
        itemFootNavView = this.bdr.bdn;
        itemFootNavView.cC(false);
        itemFootNavView2 = this.bdr.bdn;
        itemFootNavView2.cD(false);
        itemFootNavView3 = this.bdr.bdn;
        recommendForumInfo = itemFootNavView3.bcQ;
        if (recommendForumInfo != null) {
            itemFootNavView4 = this.bdr.bdn;
            recommendForumInfo2 = itemFootNavView4.bcQ;
            if (recommendForumInfo2.forum_id.longValue() != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, false));
                MessageManager messageManager = MessageManager.getInstance();
                StringBuilder sb = new StringBuilder();
                itemFootNavView5 = this.bdr.bdn;
                recommendForumInfo3 = itemFootNavView5.bcQ;
                messageManager.sendMessage(new CustomMessage(2003004, sb.append(recommendForumInfo3.forum_id).toString()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ay
    public void e(String str, long j) {
        this.bdq.showToast(this.bdq.getPageContext().getString(com.baidu.tieba.y.unlike_failure));
    }
}
