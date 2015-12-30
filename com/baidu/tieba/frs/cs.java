package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements View.OnClickListener {
    final /* synthetic */ cr bhk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.bhk = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedForumData feedForumData;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        com.baidu.tieba.tbadkCore.x xVar;
        bx bxVar = (bx) view.getTag();
        if (bxVar != null && (feedForumData = (FeedForumData) this.bhk.getItem(bxVar.position)) != null) {
            if (view.getId() == n.g.frs_feed_forum_attention) {
                tbPageContext3 = this.bhk.mContext;
                if (((FrsMoreFeedForumsActivity) tbPageContext3.getOrignalPage()).checkUpIsLogin()) {
                    xVar = this.bhk.MB;
                    xVar.bc(feedForumData.getForumName(), feedForumData.getForumId());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10048").aa(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == n.g.frs_like_feed_forum_item) {
                tbPageContext = this.bhk.mContext;
                tbPageContext2 = this.bhk.mContext;
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext2.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10050").aa(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
            }
        }
    }
}
