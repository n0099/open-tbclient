package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tieba.tbadkCore.c {
    final /* synthetic */ ba aNg;
    private final /* synthetic */ bd aNh;
    private final /* synthetic */ com.baidu.tbadk.core.data.m aNl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ba baVar, bd bdVar, com.baidu.tbadk.core.data.m mVar) {
        this.aNg = baVar;
        this.aNh = bdVar;
        this.aNl = mVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c
    public void eX(int i) {
        int eZ;
        Context context;
        Context context2;
        Context context3;
        if (!this.aNg.aMl.checkUpIsLogin()) {
            return;
        }
        eZ = this.aNh.eZ(i);
        if (this.aNl != null && this.aNl.qJ() != null && eZ >= 0 && eZ < this.aNl.qJ().size()) {
            context = this.aNg.mContext;
            com.baidu.tbadk.core.k.A(context, "forum_live_ck");
            LiveCardData liveCardData = this.aNl.qJ().get(eZ);
            if (liveCardData != null && liveCardData.getFromType() == 0) {
                if (this.aNg.aMl != null && this.aNg.aMl.KF() != null && this.aNg.aMl.KF().aas() != null) {
                    context3 = this.aNg.mContext;
                    TiebaStatic.eventStat(context3, "frs_broadcast_module", "click", 1, "loc", Integer.valueOf(eZ + 1), ImageViewerConfig.FORUM_ID, this.aNg.aMl.KF().aas().getId(), "group_id", Integer.valueOf(liveCardData.getGroupId()));
                }
                MessageManager messageManager = MessageManager.getInstance();
                context2 = this.aNg.mContext;
                messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(context2, liveCardData.getGroupId())));
            }
        }
    }
}
