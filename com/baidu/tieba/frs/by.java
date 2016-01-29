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
import com.baidu.tieba.t;
import java.io.Serializable;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ bx biy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.biy = bxVar;
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
            if (this.biy.mTbPageContext.getOrignalPage().checkUpIsLogin() && (feedForumData = (FeedForumData) view.getTag()) != null) {
                wVar = this.biy.MS;
                wVar.bl(feedForumData.getForumName(), feedForumData.getForumId());
                i3 = this.biy.mType;
                if (i3 == 1) {
                    str4 = "c10028";
                } else {
                    str4 = "c10040";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.au(str4).aa(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
            }
        } else if (view.getId() != t.g.like_feed_forums_arrow) {
            if (view.getId() == t.g.frs_like_feed_forum_item) {
                FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                if (feedForumData2 != null) {
                    String str5 = "";
                    i = this.biy.mType;
                    if (i == 1) {
                        str5 = FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND;
                    }
                    this.biy.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.biy.mTbPageContext.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), str5)));
                    i2 = this.biy.mType;
                    if (i2 == 2) {
                        str2 = "c10042";
                    } else {
                        str2 = "c10030";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au(str2).aa(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                    return;
                }
                return;
            }
            int id = view.getId();
            textView = this.biy.bit;
            if (id == textView.getId()) {
                list = this.biy.biw;
                if (com.baidu.tbadk.core.util.x.o(list) > 0) {
                    Activity pageActivity = this.biy.mTbPageContext.getPageActivity();
                    list2 = this.biy.biw;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(pageActivity, (Serializable) list2)));
                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10046");
                    str = this.biy.mForumId;
                    TiebaStatic.log(auVar.aa(ImageViewerConfig.FORUM_ID, str));
                }
            }
        } else {
            this.biy.Gp();
            com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au("c10029");
            str3 = this.biy.mForumId;
            TiebaStatic.log(auVar2.aa(ImageViewerConfig.FORUM_ID, str3));
        }
    }
}
