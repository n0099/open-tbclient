package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements ChildViewPager.a {
    final /* synthetic */ bh aWA;
    private final /* synthetic */ bh.a aWB;
    private final /* synthetic */ com.baidu.tbadk.core.data.l aWF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bh bhVar, bh.a aVar, com.baidu.tbadk.core.data.l lVar) {
        this.aWA = bhVar;
        this.aWB = aVar;
        this.aWF = lVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ChildViewPager.a
    public void fk(int i) {
        int fm;
        Context context;
        Context context2;
        if (!this.aWA.aSJ.checkUpIsLogin()) {
            return;
        }
        fm = this.aWB.fm(i);
        if (this.aWF != null && this.aWF.rL() != null && fm >= 0 && fm < this.aWF.rL().size()) {
            TiebaStatic.log("forum_live_ck");
            LiveCardData liveCardData = this.aWF.rL().get(fm);
            if (liveCardData != null && liveCardData.getType() != 33 && liveCardData.getFromType() == 0 && this.aWA.aSJ != null && (this.aWA.aSJ instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) this.aWA.aSJ;
                if (frsActivity.Lu() != null && frsActivity.Lu().acG() != null) {
                    context2 = this.aWA.mContext;
                    TiebaStatic.eventStat(context2, "frs_broadcast_module", "click", 1, "loc", Integer.valueOf(fm + 1), ImageViewerConfig.FORUM_ID, frsActivity.Lu().acG().getId(), "group_id", Integer.valueOf(liveCardData.getGroupId()));
                }
                MessageManager messageManager = MessageManager.getInstance();
                context = this.aWA.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(context, liveCardData.getGroupId())));
            }
        }
    }
}
