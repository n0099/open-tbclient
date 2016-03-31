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
public class de implements View.OnClickListener {
    final /* synthetic */ dd bpi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar) {
        this.bpi = ddVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedForumData feedForumData;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        com.baidu.tieba.tbadkCore.w wVar;
        cf cfVar = (cf) view.getTag();
        if (cfVar != null && (feedForumData = (FeedForumData) this.bpi.getItem(cfVar.position)) != null) {
            if (view.getId() == t.g.frs_feed_forum_attention) {
                tbPageContext3 = this.bpi.MX;
                if (((FrsMoreFeedForumsActivity) tbPageContext3.getOrignalPage()).checkUpIsLogin()) {
                    wVar = this.bpi.MY;
                    wVar.bC(feedForumData.getForumName(), feedForumData.getForumId());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10048").ac("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == t.g.frs_like_feed_forum_item) {
                tbPageContext = this.bpi.MX;
                tbPageContext2 = this.bpi.MX;
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext2.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10050").ac("fid", feedForumData.getForumId()));
            }
        }
    }
}
