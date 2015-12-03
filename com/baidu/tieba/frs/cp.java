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
public class cp implements View.OnClickListener {
    final /* synthetic */ co bdk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.bdk = coVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedForumData feedForumData;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        com.baidu.tieba.tbadkCore.x xVar;
        bu buVar = (bu) view.getTag();
        if (buVar != null && (feedForumData = (FeedForumData) this.bdk.getItem(buVar.position)) != null) {
            if (view.getId() == n.f.frs_feed_forum_attention) {
                tbPageContext3 = this.bdk.mContext;
                if (((FrsMoreFeedForumsActivity) tbPageContext3.getOrignalPage()).checkUpIsLogin()) {
                    xVar = this.bdk.Ml;
                    xVar.bg(feedForumData.getForumName(), feedForumData.getForumId());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10048").ab(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == n.f.frs_like_feed_forum_item) {
                tbPageContext = this.bdk.mContext;
                tbPageContext2 = this.bdk.mContext;
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext2.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10050").ab(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
            }
        }
    }
}
