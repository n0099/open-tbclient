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
    final /* synthetic */ ba aNf;
    private final /* synthetic */ bd aNg;
    private final /* synthetic */ com.baidu.tbadk.core.data.m aNk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ba baVar, bd bdVar, com.baidu.tbadk.core.data.m mVar) {
        this.aNf = baVar;
        this.aNg = bdVar;
        this.aNk = mVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c
    public void eX(int i) {
        int eZ;
        Context context;
        Context context2;
        Context context3;
        if (!this.aNf.aMk.checkUpIsLogin()) {
            return;
        }
        eZ = this.aNg.eZ(i);
        if (this.aNk != null && this.aNk.qJ() != null && eZ >= 0 && eZ < this.aNk.qJ().size()) {
            context = this.aNf.mContext;
            com.baidu.tbadk.core.k.A(context, "forum_live_ck");
            LiveCardData liveCardData = this.aNk.qJ().get(eZ);
            if (liveCardData != null && liveCardData.getFromType() == 0) {
                if (this.aNf.aMk != null && this.aNf.aMk.KE() != null && this.aNf.aMk.KE().aar() != null) {
                    context3 = this.aNf.mContext;
                    TiebaStatic.eventStat(context3, "frs_broadcast_module", "click", 1, "loc", Integer.valueOf(eZ + 1), ImageViewerConfig.FORUM_ID, this.aNf.aMk.KE().aar().getId(), "group_id", Integer.valueOf(liveCardData.getGroupId()));
                }
                MessageManager messageManager = MessageManager.getInstance();
                context2 = this.aNf.mContext;
                messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(context2, liveCardData.getGroupId())));
            }
        }
    }
}
