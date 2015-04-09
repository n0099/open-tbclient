package com.baidu.tieba.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, String str2, b bVar) {
        c cVar = new c(str, str2, bVar);
        cVar.setPriority(3);
        cVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData aM(String str, String str2) {
        aa aaVar;
        String rO;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            aaVar = new aa(sb.toString());
            aaVar.o("un", str);
            aaVar.o("passwd", str2);
            aaVar.o("isphone", GameInfoData.NOT_FROM_DETAIL);
            aaVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            aaVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            aaVar.sp().tp().ts().Wr = true;
            aaVar.sp().tp().mIsNeedAddCommenParam = false;
            aaVar.sp().tp().mIsUseCurrentBDUSS = false;
            rO = aaVar.rO();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (aaVar.sp().tq().pv() && rO != null) {
            n nVar = new n();
            nVar.parserJson(rO);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            if (nVar.getUser().getPassword() != null) {
                accountData.setPassword(nVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.qe() != null) {
                accountData.setTbs(nVar.qe().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (aaVar.ss()) {
            switch (aaVar.st()) {
                case 1:
                case 2:
                case 5:
                    aaVar.hh();
                    ReloginManager.rw().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
