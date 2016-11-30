package com.baidu.tieba.frs.acrossForum;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.acrossForum.message.AcrossAwardRequestMsg;
import tbclient.Acrossaward.DataRes;
/* loaded from: classes.dex */
public class a {
    private static a bWA;
    private com.baidu.adp.framework.listener.a bWB = new b(this, CmdConfigHttp.CMD_ACROSS_AWARD, 309425);

    public a() {
        MessageManager.getInstance().registerListener(this.bWB);
    }

    public static a adR() {
        if (bWA == null) {
            bWA = new a();
        }
        return bWA;
    }

    public void jY(String str) {
        if (!StringUtils.isNull(str)) {
            if (!str.equals("across_sign") || !com.baidu.tieba.acrossForum.a.MS().MT()) {
                AcrossAwardRequestMsg acrossAwardRequestMsg = new AcrossAwardRequestMsg();
                acrossAwardRequestMsg.awardType = str;
                MessageManager.getInstance().sendMessage(acrossAwardRequestMsg);
            }
        }
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.bWB);
        bWA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes != null && !StringUtils.isNull(dataRes.tips)) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m9getInst().getContext(), dataRes.tips);
        }
    }
}
