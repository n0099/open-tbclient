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
public class q extends com.baidu.adp.base.i {
    private final /* synthetic */ ForumDetailActivity aZA;
    private final /* synthetic */ ac aZB;
    final /* synthetic */ ItemFootNavView aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ItemFootNavView itemFootNavView, ac acVar, ForumDetailActivity forumDetailActivity) {
        this.aZz = itemFootNavView;
        this.aZB = acVar;
        this.aZA = forumDetailActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        RecommendForumInfo recommendForumInfo;
        if (this.aZB.getErrorCode() == 22) {
            this.aZz.cL(true);
            this.aZz.cM(true);
        } else if (this.aZB.getErrorCode() != 0) {
            this.aZA.showToast(this.aZB.getErrorString());
        } else if (((ae) obj) != null) {
            this.aZz.cL(true);
            TbadkApplication inst = TbadkApplication.getInst();
            recommendForumInfo = this.aZz.aZc;
            inst.addLikeForum(recommendForumInfo.forum_name);
            this.aZz.cM(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, true));
        } else {
            this.aZA.showToast(this.aZA.getPageContext().getString(z.neterror));
        }
    }
}
