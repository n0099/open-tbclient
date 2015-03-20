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
    final /* synthetic */ ItemFootNavView bcX;
    private final /* synthetic */ ForumDetailActivity bcY;
    private final /* synthetic */ af bcZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ItemFootNavView itemFootNavView, af afVar, ForumDetailActivity forumDetailActivity) {
        this.bcX = itemFootNavView;
        this.bcZ = afVar;
        this.bcY = forumDetailActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        RecommendForumInfo recommendForumInfo;
        if (this.bcZ.getErrorCode() == 22) {
            this.bcX.cE(true);
            this.bcX.cF(true);
        } else if (this.bcZ.getErrorCode() != 0) {
            this.bcY.showToast(this.bcZ.getErrorString());
        } else if (((ah) obj) != null) {
            this.bcX.cE(true);
            TbadkApplication inst = TbadkApplication.getInst();
            recommendForumInfo = this.bcX.bcA;
            inst.addLikeForum(recommendForumInfo.forum_name);
            this.bcX.cF(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, true));
        } else {
            this.bcY.showToast(this.bcY.getPageContext().getString(com.baidu.tieba.y.neterror));
        }
    }
}
