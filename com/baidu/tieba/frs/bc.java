package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.plugins.XiubaPlugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tieba.tbadkCore.c {
    final /* synthetic */ ba aKO;
    private final /* synthetic */ bd aKP;
    private final /* synthetic */ com.baidu.tbadk.core.data.m aKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ba baVar, bd bdVar, com.baidu.tbadk.core.data.m mVar) {
        this.aKO = baVar;
        this.aKP = bdVar;
        this.aKS = mVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c
    public void eJ(int i) {
        int eL;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        eL = this.aKP.eL(i);
        if (this.aKS != null && this.aKS.qd() != null && eL >= 0 && eL < this.aKS.qd().size()) {
            context = this.aKO.mContext;
            com.baidu.tbadk.core.k.A(context, "forum_live_ck");
            LiveCardData liveCardData = this.aKS.qd().get(eL);
            if (liveCardData != null) {
                if (liveCardData.getFromType() != 1) {
                    context2 = this.aKO.mContext;
                    TiebaStatic.eventStat(context2, "frs_broadcast_module", "click", 1, new Object[0]);
                    MessageManager messageManager = MessageManager.getInstance();
                    context3 = this.aKO.mContext;
                    messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(context3, liveCardData.getGroupId())));
                } else if (!UtilHelper.isNetOk()) {
                    context4 = this.aKO.mContext;
                    UtilHelper.showToast(context4, com.baidu.tieba.y.neterror);
                } else {
                    XiubaPlugin xiubaPlugin = (XiubaPlugin) PluginCenter.getInstance().getXiubaClassInstance();
                    if (xiubaPlugin != null) {
                        context6 = this.aKO.mContext;
                        xiubaPlugin.startLivingRoom(context6, String.valueOf(liveCardData.getGroupId()));
                        return;
                    }
                    context5 = this.aKO.mContext;
                    UtilHelper.showToast(context5, com.baidu.tieba.y.plugin_not_success);
                }
            }
        }
    }
}
