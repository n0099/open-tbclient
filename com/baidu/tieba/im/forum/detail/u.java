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
    private final /* synthetic */ BaseActivity baY;
    final /* synthetic */ t baZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, BaseActivity baseActivity) {
        this.baZ = tVar;
        this.baY = baseActivity;
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
        itemFootNavView = this.baZ.baV;
        itemFootNavView.cQ(false);
        itemFootNavView2 = this.baZ.baV;
        itemFootNavView2.cR(false);
        itemFootNavView3 = this.baZ.baV;
        recommendForumInfo = itemFootNavView3.bay;
        if (recommendForumInfo != null) {
            itemFootNavView4 = this.baZ.baV;
            recommendForumInfo2 = itemFootNavView4.bay;
            if (recommendForumInfo2.forum_id.longValue() != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, false));
                MessageManager messageManager = MessageManager.getInstance();
                StringBuilder sb = new StringBuilder();
                itemFootNavView5 = this.baZ.baV;
                recommendForumInfo3 = itemFootNavView5.bay;
                messageManager.sendMessage(new CustomMessage(2003004, sb.append(recommendForumInfo3.forum_id).toString()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void g(String str, long j) {
        this.baY.showToast(this.baY.getPageContext().getString(z.unlike_failure));
    }
}
