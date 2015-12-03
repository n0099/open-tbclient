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
public class bp implements View.OnClickListener {
    final /* synthetic */ bo bbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.bbR = boVar;
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
        if (view.getId() == n.f.frs_feed_forum_attention) {
            if (this.bbR.mTbPageContext.getOrignalPage().checkUpIsLogin() && (feedForumData = (FeedForumData) view.getTag()) != null) {
                xVar = this.bbR.Ml;
                xVar.bg(feedForumData.getForumName(), feedForumData.getForumId());
                i3 = this.bbR.mType;
                if (i3 == 1) {
                    str4 = "c10028";
                } else {
                    str4 = "c10040";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.av(str4).ab(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
            }
        } else if (view.getId() != n.f.like_feed_forums_arrow) {
            if (view.getId() == n.f.frs_like_feed_forum_item) {
                FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                if (feedForumData2 != null) {
                    String str5 = "";
                    i = this.bbR.mType;
                    if (i == 1) {
                        str5 = FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND;
                    }
                    this.bbR.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bbR.mTbPageContext.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), str5)));
                    i2 = this.bbR.mType;
                    if (i2 == 2) {
                        str2 = "c10042";
                    } else {
                        str2 = "c10030";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av(str2).ab(ImageViewerConfig.FORUM_ID, feedForumData2.getForumId()));
                    return;
                }
                return;
            }
            int id = view.getId();
            textView = this.bbR.bbM;
            if (id == textView.getId()) {
                list = this.bbR.bbP;
                if (com.baidu.tbadk.core.util.y.k(list) > 0) {
                    Activity pageActivity = this.bbR.mTbPageContext.getPageActivity();
                    list2 = this.bbR.bbP;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsMoreFeedForumsConfig(pageActivity, (Serializable) list2)));
                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10046");
                    str = this.bbR.mForumId;
                    TiebaStatic.log(avVar.ab(ImageViewerConfig.FORUM_ID, str));
                }
            }
        } else {
            this.bbR.showDialog();
            com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c10029");
            str3 = this.bbR.mForumId;
            TiebaStatic.log(avVar2.ab(ImageViewerConfig.FORUM_ID, str3));
        }
    }
}
