package com.baidu.tieba.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    public static void a(String str, String str2, String str3, com.baidu.tbadk.core.a.b bVar) {
        new e(str, str2, str3, bVar, false).execute(new String[0]);
    }

    public static AccountData h(String str, String str2, String str3) {
        aa aaVar = new aa(TbConfig.LOGIN_FULL_ADDRESS);
        aaVar.sX().tS().mIsUseCurrentBDUSS = false;
        aaVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        aaVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        aaVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        aaVar.sX().tS().WD = false;
        String sw = aaVar.sw();
        if (aaVar.sX().tT().qa() && sw != null) {
            n nVar = new n();
            nVar.parserJson(sw);
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.qK() != null) {
                accountData.setTbs(nVar.qK().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }
}
