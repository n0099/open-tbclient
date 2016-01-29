package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements View.OnClickListener {
    final /* synthetic */ cy bjZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cy cyVar) {
        this.bjZ = cyVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedForumData feedForumData;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        com.baidu.tieba.tbadkCore.w wVar;
        cd cdVar = (cd) view.getTag();
        if (cdVar != null && (feedForumData = (FeedForumData) this.bjZ.getItem(cdVar.position)) != null) {
            if (view.getId() == t.g.frs_feed_forum_attention) {
                tbPageContext3 = this.bjZ.MR;
                if (((FrsMoreFeedForumsActivity) tbPageContext3.getOrignalPage()).checkUpIsLogin()) {
                    wVar = this.bjZ.MS;
                    wVar.bl(feedForumData.getForumName(), feedForumData.getForumId());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10048").aa(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            } else if (view.getId() == t.g.frs_like_feed_forum_item) {
                tbPageContext = this.bjZ.MR;
                tbPageContext2 = this.bjZ.MR;
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext2.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10050").aa(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
            }
        }
    }
}
