package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import java.io.Serializable;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ bz bnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.bnj = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        List list;
        List list2;
        String str;
        int i;
        int i2;
        String str2;
        String str3;
        FeedForumData feedForumData;
        com.baidu.tieba.tbadkCore.w wVar;
        int i3;
        String str4;
        if (view.getId() == t.g.frs_feed_forum_attention) {
            if (this.bnj.mTbPageContext.getOrignalPage().checkUpIsLogin() && (feedForumData = (FeedForumData) view.getTag()) != null) {
                wVar = this.bnj.MY;
                wVar.bC(feedForumData.getForumName(), feedForumData.getForumId());
                i3 = this.bnj.mType;
                if (i3 == 1) {
                    str4 = "c10028";
                } else {
                    str4 = "c10040";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str4).ac("fid", feedForumData.getForumId()));
            }
        } else if (view.getId() != t.g.like_feed_forums_arrow) {
            if (view.getId() == t.g.frs_like_feed_forum_item) {
                FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                if (feedForumData2 != null) {
                    String str5 = "";
                    i = this.bnj.mType;
                    if (i == 1) {
                        str5 = FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND;
                    }
                    this.bnj.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bnj.mTbPageContext.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), str5)));
                    i2 = this.bnj.mType;
                    if (i2 == 2) {
                        str2 = "c10042";
                    } else {
                        str2 = "c10030";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str2).ac("fid", feedForumData2.getForumId()));
                    return;
                }
                return;
            }
            int id = view.getId();
            textView = this.bnj.bne;
            if (id == textView.getId()) {
                list = this.bnj.bnh;
                if (com.baidu.tbadk.core.util.y.p(list) > 0) {
                    Activity pageActivity = this.bnj.mTbPageContext.getPageActivity();
                    list2 = this.bnj.bnh;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(pageActivity, (Serializable) list2)));
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10046");
                    str = this.bnj.mForumId;
                    TiebaStatic.log(awVar.ac("fid", str));
                }
            }
        } else {
            this.bnj.Hl();
            com.baidu.tbadk.core.util.aw awVar2 = new com.baidu.tbadk.core.util.aw("c10029");
            str3 = this.bnj.mForumId;
            TiebaStatic.log(awVar2.ac("fid", str3));
        }
    }
}
