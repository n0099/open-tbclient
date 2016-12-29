package com.baidu.tieba.frs.acrossForum;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.acrossForum.message.AcrossAwardRequestMsg;
import tbclient.Acrossaward.DataRes;
/* loaded from: classes.dex */
public class a {
    private static a bCK;
    private com.baidu.adp.framework.listener.a bCL = new b(this, CmdConfigHttp.CMD_ACROSS_AWARD, 309425);

    public a() {
        MessageManager.getInstance().registerListener(this.bCL);
    }

    public static a Yl() {
        if (bCK == null) {
            bCK = new a();
        }
        return bCK;
    }

    public void iD(String str) {
        if (!StringUtils.isNull(str)) {
            if (!str.equals("across_sign") || !com.baidu.tieba.acrossForum.a.Ml().Mm()) {
                AcrossAwardRequestMsg acrossAwardRequestMsg = new AcrossAwardRequestMsg();
                acrossAwardRequestMsg.awardType = str;
                MessageManager.getInstance().sendMessage(acrossAwardRequestMsg);
            }
        }
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.bCL);
        bCK = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes != null && !StringUtils.isNull(dataRes.tips)) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m9getInst().getContext(), dataRes.tips);
        }
    }
}
