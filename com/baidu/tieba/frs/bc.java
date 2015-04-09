package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.plugins.XiubaPlugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tieba.tbadkCore.c {
    final /* synthetic */ ba aKY;
    private final /* synthetic */ bd aKZ;
    private final /* synthetic */ com.baidu.tbadk.core.data.m aLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ba baVar, bd bdVar, com.baidu.tbadk.core.data.m mVar) {
        this.aKY = baVar;
        this.aKZ = bdVar;
        this.aLc = mVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c
    public void eJ(int i) {
        int eL;
        Context context;
        FrsActivity frsActivity;
        Context context2;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        Context context3;
        FrsActivity frsActivity4;
        Context context4;
        Context context5;
        Context context6;
        eL = this.aKZ.eL(i);
        if (this.aLc != null && this.aLc.qd() != null && eL >= 0 && eL < this.aLc.qd().size()) {
            context = this.aKY.mContext;
            com.baidu.tbadk.core.k.A(context, "forum_live_ck");
            LiveCardData liveCardData = this.aLc.qd().get(eL);
            if (liveCardData != null) {
                if (liveCardData.getFromType() != 1) {
                    frsActivity = this.aKY.aKd;
                    if (frsActivity != null) {
                        frsActivity2 = this.aKY.aKd;
                        if (frsActivity2.JA() != null) {
                            frsActivity3 = this.aKY.aKd;
                            if (frsActivity3.JA().Za() != null) {
                                context3 = this.aKY.mContext;
                                frsActivity4 = this.aKY.aKd;
                                TiebaStatic.eventStat(context3, "frs_broadcast_module", "click", 1, "loc", Integer.valueOf(eL + 1), ImageViewerConfig.FORUM_ID, frsActivity4.JA().Za().getId(), "group_id", Integer.valueOf(this.aLc.qd().get(eL).getGroupId()));
                            }
                        }
                    }
                    MessageManager messageManager = MessageManager.getInstance();
                    context2 = this.aKY.mContext;
                    messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(context2, liveCardData.getGroupId())));
                } else if (!UtilHelper.isNetOk()) {
                    context4 = this.aKY.mContext;
                    UtilHelper.showToast(context4, com.baidu.tieba.y.neterror);
                } else {
                    XiubaPlugin xiubaPlugin = (XiubaPlugin) PluginCenter.getInstance().getXiubaClassInstance();
                    if (xiubaPlugin != null) {
                        context6 = this.aKY.mContext;
                        xiubaPlugin.startLivingRoom(context6, String.valueOf(liveCardData.getGroupId()));
                        return;
                    }
                    context5 = this.aKY.mContext;
                    UtilHelper.showToast(context5, com.baidu.tieba.y.plugin_not_success);
                }
            }
        }
    }
}
