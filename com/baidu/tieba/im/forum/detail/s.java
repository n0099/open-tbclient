package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.z;
import tbclient.RecommendForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.i {
    final /* synthetic */ ItemFootNavView baV;
    private final /* synthetic */ ForumDetailActivity baW;
    private final /* synthetic */ ac baX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ItemFootNavView itemFootNavView, ac acVar, ForumDetailActivity forumDetailActivity) {
        this.baV = itemFootNavView;
        this.baX = acVar;
        this.baW = forumDetailActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        RecommendForumInfo recommendForumInfo;
        if (this.baX.getErrorCode() == 22) {
            this.baV.cQ(true);
            this.baV.cR(true);
        } else if (this.baX.getErrorCode() != 0) {
            this.baW.showToast(this.baX.getErrorString());
        } else if (((ae) obj) != null) {
            this.baV.cQ(true);
            TbadkApplication inst = TbadkApplication.getInst();
            recommendForumInfo = this.baV.bay;
            inst.addLikeForum(recommendForumInfo.forum_name);
            this.baV.cR(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, true));
        } else {
            this.baW.showToast(this.baW.getPageContext().getString(z.neterror));
        }
    }
}
