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
import com.baidu.tbadk.data.h;
/* loaded from: classes.dex */
public class b {
    private static b aCo;

    private b() {
    }

    public static b EB() {
        if (aCo == null) {
            synchronized (b.class) {
                if (aCo == null) {
                    aCo = new b();
                }
            }
        }
        return aCo;
    }

    public void EC() {
        com.baidu.tieba.tbadkCore.a.a.a(303024, GetUserInfoSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303024, CmdConfigHttp.CMD_GET_USER_INFO, TbConfig.GET_USER_INFO, GetUserInfoHttpResponseMessage.class, false, false, false, false);
    }

    public void ED() {
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
            currentAccountObj.setVipInfo(userData.getUserVipInfo());
            currentAccountObj.setPersonalBgUrl(userData.getBg_pic());
            if (userData.getGodUserData() != null) {
                currentAccountObj.setGodType(userData.getGodUserData().getType());
            }
            TbadkCoreApplication.m9getInst().setDefaultBubble(userData.getBimg_url());
            h payMemberInfoData = userData.getPayMemberInfoData();
            if (currentAccountObj.getVipInfo() != null) {
                currentAccountObj.setMemberIconUrl(currentAccountObj.getVipInfo().getVipIconUrl());
            } else {
                currentAccountObj.setMemberIconUrl(null);
            }
            com.baidu.tbadk.data.c closeAdData = userData.getCloseAdData();
            if (closeAdData != null) {
                currentAccountObj.setMemberCloseAdIsOpen(closeAdData.Cz());
                currentAccountObj.setMemberCloseAdVipClose(closeAdData.CA());
            }
            currentAccountObj.setUserIcons(userData.getIconInfo());
            currentAccountObj.setIsSelectTail(userData.getIsSelectTail());
            k.fT().e(new c(this, currentAccountObj));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_INFO_CHANGED, payMemberInfoData));
        }
    }
}
