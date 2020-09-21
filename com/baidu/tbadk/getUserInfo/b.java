package com.baidu.tbadk.getUserInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.UserData;
/* loaded from: classes.dex */
public class b {
    private static b eQO;
    private UserData eQP;

    private b() {
    }

    public static b btU() {
        if (eQO == null) {
            synchronized (b.class) {
                if (eQO == null) {
                    eQO = new b();
                }
            }
        }
        return eQO;
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_USER_INFO, GetUserInfoSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_USER_INFO, 1003001, TbConfig.GET_USER_INFO, GetUserInfoHttpResponseMessage.class, false, false, false, false);
    }

    public void btV() {
        GetUserInfoRequstData getUserInfoRequstData = new GetUserInfoRequstData(1003001, CmdConfigSocket.CMD_GET_USER_INFO);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            getUserInfoRequstData.setUid(com.baidu.adp.lib.f.b.toLong(currentAccountObj.getID(), 0L));
        }
        getUserInfoRequstData.setScreenWidth(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()));
        MessageManager.getInstance().sendMessage(getUserInfoRequstData);
    }

    public void a(UserData userData) {
        this.eQP = userData;
        if (userData != null) {
            final AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = new AccountData();
            }
            if (!StringUtils.isNull(userData.getUserName())) {
                currentAccountObj.setAccount(userData.getUserName());
            }
            if (!StringUtils.isNull(userData.getPortrait())) {
                currentAccountObj.setPortrait(userData.getPortrait());
            }
            if (userData.getBaijiahaoInfo() != null && !StringUtils.isNull(userData.getBaijiahaoInfo().avatar)) {
                currentAccountObj.setBjhAvatar(userData.getBaijiahaoInfo().avatar);
            }
            currentAccountObj.setSex(userData.getSex());
            currentAccountObj.setMemberType(userData.getIsMem());
            currentAccountObj.setVipInfo(userData.getUserVipInfo());
            currentAccountObj.setPersonalBgUrl(userData.getBg_pic());
            if (userData.getGodUserData() != null) {
                currentAccountObj.setGodType(userData.getGodUserData().getType());
            }
            if (userData.getNewGodData() != null) {
                currentAccountObj.setNewGodStatus(userData.getNewGodData().getStatus());
            }
            if (!TextUtils.isEmpty(userData.getUk())) {
                currentAccountObj.setUk(userData.getUk());
            }
            currentAccountObj.setIsBigV(userData.isBigV());
            currentAccountObj.setNameShow(userData.getName_show());
            if (!StringUtils.isNull(userData.getBimg_url())) {
                TbadkCoreApplication.getInst().setDefaultBubble(userData.getBimg_url());
            }
            PayMemberInfoData payMemberInfoData = userData.getPayMemberInfoData();
            if (currentAccountObj.getVipInfo() != null) {
                currentAccountObj.setMemberIconUrl(currentAccountObj.getVipInfo().getVipIconUrl());
            } else {
                currentAccountObj.setMemberIconUrl(null);
            }
            CloseAdData closeAdData = userData.getCloseAdData();
            if (closeAdData != null) {
                currentAccountObj.setMemberCloseAdIsOpen(closeAdData.brK());
                currentAccountObj.setMemberCloseAdVipClose(closeAdData.brL());
            }
            currentAccountObj.setUserIcons(userData.getIconInfo());
            currentAccountObj.setIsSelectTail(userData.getIsSelectTail());
            h.mY().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tbadk.getUserInfo.b.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.a.b.b(currentAccountObj);
                }
            });
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_INFO_CHANGED, payMemberInfoData));
        }
    }

    public UserData btW() {
        return this.eQP;
    }
}
