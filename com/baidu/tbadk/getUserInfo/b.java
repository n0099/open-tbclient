package com.baidu.tbadk.getUserInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.k;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.data.e;
/* loaded from: classes.dex */
public class b {
    private static b atc;

    private b() {
    }

    public static b BV() {
        if (atc == null) {
            synchronized (b.class) {
                if (atc == null) {
                    atc = new b();
                }
            }
        }
        return atc;
    }

    public void BW() {
        com.baidu.tieba.tbadkCore.a.a.a(303024, GetUserInfoSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303024, CmdConfigHttp.CMD_GET_USER_INFO, TbConfig.GET_USER_INFO, GetUserInfoHttpResponseMessage.class, false, false, false, false);
    }

    public void BX() {
        GetUserInfoRequstData getUserInfoRequstData = new GetUserInfoRequstData(CmdConfigHttp.CMD_GET_USER_INFO, 303024);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            getUserInfoRequstData.setUid(com.baidu.adp.lib.g.b.c(currentAccountObj.getID(), 0L));
        }
        MessageManager.getInstance().sendMessage(getUserInfoRequstData);
    }

    public void a(UserData userData) {
        if (userData != null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = new AccountData();
            }
            if (!StringUtils.isNull(userData.getUserName())) {
                currentAccountObj.setAccount(userData.getUserName());
            }
            if (!StringUtils.isNull(userData.getPortrait())) {
                currentAccountObj.setPortrait(userData.getPortrait());
            }
            currentAccountObj.setSex(userData.getSex());
            currentAccountObj.setMemberType(userData.getIsMem());
            e payMemberInfoData = userData.getPayMemberInfoData();
            if (payMemberInfoData != null && userData.getIsMem() != 0 && payMemberInfoData.rk() * 1000 > System.currentTimeMillis() && !StringUtils.isNull(payMemberInfoData.getUrl())) {
                currentAccountObj.setMemberIconUrl(payMemberInfoData.getUrl());
            } else {
                currentAccountObj.setMemberIconUrl(null);
            }
            currentAccountObj.setUserIcons(userData.getIconInfo());
            currentAccountObj.setIsSelectTail(userData.getIsSelectTail());
            k.hh().b(new c(this, currentAccountObj));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_INFO_CHANGED, payMemberInfoData));
        }
    }
}
