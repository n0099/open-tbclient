package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.ah;
import tbclient.RecommendForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.i {
    final /* synthetic */ ItemFootNavView bdn;
    private final /* synthetic */ ForumDetailActivity bdo;
    private final /* synthetic */ af bdp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ItemFootNavView itemFootNavView, af afVar, ForumDetailActivity forumDetailActivity) {
        this.bdn = itemFootNavView;
        this.bdp = afVar;
        this.bdo = forumDetailActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        RecommendForumInfo recommendForumInfo;
        if (this.bdp.getErrorCode() == 22) {
            this.bdn.cC(true);
            this.bdn.cD(true);
        } else if (this.bdp.getErrorCode() != 0) {
            this.bdo.showToast(this.bdp.getErrorString());
        } else if (((ah) obj) != null) {
            this.bdn.cC(true);
            TbadkApplication inst = TbadkApplication.getInst();
            recommendForumInfo = this.bdn.bcQ;
            inst.addLikeForum(recommendForumInfo.forum_name);
            this.bdn.cD(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, true));
        } else {
            this.bdo.showToast(this.bdo.getPageContext().getString(com.baidu.tieba.y.neterror));
        }
    }
}
