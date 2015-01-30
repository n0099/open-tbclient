package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.av;
import com.baidu.tieba.z;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
class u implements av {
    private final /* synthetic */ BaseActivity baZ;
    final /* synthetic */ t bba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, BaseActivity baseActivity) {
        this.bba = tVar;
        this.baZ = baseActivity;
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
        itemFootNavView = this.bba.baW;
        itemFootNavView.cQ(false);
        itemFootNavView2 = this.bba.baW;
        itemFootNavView2.cR(false);
        itemFootNavView3 = this.bba.baW;
        recommendForumInfo = itemFootNavView3.baz;
        if (recommendForumInfo != null) {
            itemFootNavView4 = this.bba.baW;
            recommendForumInfo2 = itemFootNavView4.baz;
            if (recommendForumInfo2.forum_id.longValue() != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, false));
                MessageManager messageManager = MessageManager.getInstance();
                StringBuilder sb = new StringBuilder();
                itemFootNavView5 = this.bba.baW;
                recommendForumInfo3 = itemFootNavView5.baz;
                messageManager.sendMessage(new CustomMessage(2003004, sb.append(recommendForumInfo3.forum_id).toString()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void g(String str, long j) {
        this.baZ.showToast(this.baZ.getPageContext().getString(z.unlike_failure));
    }
}
