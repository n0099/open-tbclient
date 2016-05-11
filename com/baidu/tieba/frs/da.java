package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements View.OnClickListener {
    final /* synthetic */ cz bkB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cz czVar) {
        this.bkB = czVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedForumData feedForumData;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        com.baidu.tieba.tbadkCore.x xVar;
        ce ceVar = (ce) view.getTag();
        if (ceVar != null && (feedForumData = (FeedForumData) this.bkB.getItem(ceVar.position)) != null) {
            if (view.getId() == t.g.frs_feed_forum_attention) {
                tbPageContext3 = this.bkB.Do;
                if (((FrsMoreFeedForumsActivity) tbPageContext3.getOrignalPage()).checkUpIsLogin()) {
                    xVar = this.bkB.Dp;
                    xVar.bH(feedForumData.getForumName(), feedForumData.getForumId());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10048").ac("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == t.g.frs_like_feed_forum_item) {
                tbPageContext = this.bkB.Do;
                tbPageContext2 = this.bkB.Do;
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext2.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10050").ac("fid", feedForumData.getForumId()));
            }
        }
    }
}
