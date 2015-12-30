package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import java.io.Serializable;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    final /* synthetic */ br bfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar) {
        this.bfQ = brVar;
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
        com.baidu.tieba.tbadkCore.x xVar;
        int i3;
        String str4;
        if (view.getId() == n.g.frs_feed_forum_attention) {
            if (this.bfQ.mTbPageContext.getOrignalPage().checkUpIsLogin() && (feedForumData = (FeedForumData) view.getTag()) != null) {
                xVar = this.bfQ.MB;
                xVar.bc(feedForumData.getForumName(), feedForumData.getForumId());
                i3 = this.bfQ.mType;
                if (i3 == 1) {
                    str4 = "c10028";
                } else {
                    str4 = "c10040";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.av(str4).aa(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
            }
        } else if (view.getId() != n.g.like_feed_forums_arrow) {
            if (view.getId() == n.g.frs_like_feed_forum_item) {
                FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                if (feedForumData2 != null) {
                    String str5 = "";
                    i = this.bfQ.mType;
                    if (i == 1) {
                        str5 = FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND;
                    }
                    this.bfQ.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bfQ.mTbPageContext.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), str5)));
                    i2 = this.bfQ.mType;
                    if (i2 == 2) {
                        str2 = "c10042";
                    } else {
                        str2 = "c10030";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av(str2).aa(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                    return;
                }
                return;
            }
            int id = view.getId();
            textView = this.bfQ.bfL;
            if (id == textView.getId()) {
                list = this.bfQ.bfO;
                if (com.baidu.tbadk.core.util.y.l(list) > 0) {
                    Activity pageActivity = this.bfQ.mTbPageContext.getPageActivity();
                    list2 = this.bfQ.bfO;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(pageActivity, (Serializable) list2)));
                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10046");
                    str = this.bfQ.mForumId;
                    TiebaStatic.log(avVar.aa(ImageViewerConfig.FORUM_ID, str));
                }
            }
        } else {
            this.bfQ.showDialog();
            com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c10029");
            str3 = this.bfQ.mForumId;
            TiebaStatic.log(avVar2.aa(ImageViewerConfig.FORUM_ID, str3));
        }
    }
}
