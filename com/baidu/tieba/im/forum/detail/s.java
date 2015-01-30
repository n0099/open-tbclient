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
    final /* synthetic */ ItemFootNavView baW;
    private final /* synthetic */ ForumDetailActivity baX;
    private final /* synthetic */ ac baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ItemFootNavView itemFootNavView, ac acVar, ForumDetailActivity forumDetailActivity) {
        this.baW = itemFootNavView;
        this.baY = acVar;
        this.baX = forumDetailActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        RecommendForumInfo recommendForumInfo;
        if (this.baY.getErrorCode() == 22) {
            this.baW.cQ(true);
            this.baW.cR(true);
        } else if (this.baY.getErrorCode() != 0) {
            this.baX.showToast(this.baY.getErrorString());
        } else if (((ae) obj) != null) {
            this.baW.cQ(true);
            TbadkApplication inst = TbadkApplication.getInst();
            recommendForumInfo = this.baW.baz;
            inst.addLikeForum(recommendForumInfo.forum_name);
            this.baW.cR(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, true));
        } else {
            this.baX.showToast(this.baX.getPageContext().getString(z.neterror));
        }
    }
}
