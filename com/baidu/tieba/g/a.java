package com.baidu.tieba.g;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.g.i;
/* loaded from: classes.dex */
public class a {
    private boolean fdA;
    private boolean fdB;
    private boolean fdC;
    private boolean fdD;
    private boolean fdE;
    private int fdF;
    private int fdG;
    private int fdH;
    private int fdI;
    private int fdJ;
    private boolean fdK;
    private boolean fdL;
    private boolean fdM;
    private boolean fdN;
    private boolean fdO;
    private boolean fdP;
    private boolean fdQ;
    private boolean fdR;
    private boolean fdS;
    private final CustomMessageListener fdT;
    CustomMessageListener fdU;
    private CustomMessageListener fdV;
    private CustomMessageListener fdW;
    private CustomMessageListener fdX;
    private CustomMessageListener fdY;
    private boolean fdy;
    private boolean fdz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0058a {
        private static final a fea = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.fdy = false;
        this.fdz = false;
        this.fdA = false;
        this.fdB = false;
        this.fdC = false;
        this.fdD = false;
        this.fdE = false;
        this.fdF = 0;
        this.fdG = 0;
        this.fdH = 0;
        this.fdI = 0;
        this.fdJ = 0;
        this.fdK = false;
        this.mHasNewVersion = false;
        this.fdL = false;
        this.fdM = false;
        this.fdN = false;
        this.fdO = false;
        this.fdP = false;
        this.fdQ = false;
        this.fdS = false;
        this.fdT = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.fdU = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.fdV = new d(this, CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP);
        this.fdW = new e(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.fdX = new f(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.fdY = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        MV();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a baa() {
        return C0058a.fea;
    }

    private void MV() {
        MessageManager.getInstance().registerListener(this.fdT);
        MessageManager.getInstance().registerListener(this.fdU);
        MessageManager.getInstance().registerListener(this.fdW);
        MessageManager.getInstance().registerListener(this.fdX);
        MessageManager.getInstance().registerListener(this.fdY);
        MessageManager.getInstance().registerListener(this.fdV);
    }

    private void bab() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fdC = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.fdR = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bac() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fdC || this.fdD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fdO = newsNotifyMessage.getMsgBookmark() > this.fdI;
            this.fdM = newsNotifyMessage.getMsgFans() > this.fdF;
            this.fdN = newsNotifyMessage.getMsgGiftNum() > this.fdG;
            this.fdI = newsNotifyMessage.getMsgBookmark();
            this.fdF = newsNotifyMessage.getMsgFans();
            this.fdG = newsNotifyMessage.getMsgGiftNum();
            this.fdH = newsNotifyMessage.getMsgLiveVip();
            if (this.fdO || this.fdM || this.fdN || this.mHasNewVersion) {
                this.fdy = this.fdM ? true : this.fdy;
                this.fdz = this.fdO ? true : this.fdz;
                this.fdA = this.fdN ? true : this.fdA;
                this.fdC = this.mHasNewVersion ? true : this.fdC;
                bae();
            }
        }
    }

    public void bad() {
        if (this.fdK) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.m9getInst();
            inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
            return;
        }
        TbadkSettings inst2 = TbadkSettings.getInst();
        StringBuilder sb2 = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        inst2.saveBoolean(sb2.append(TbadkCoreApplication.getCurrentAccount()).toString(), true);
    }

    public void kA(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        SparseArray sparseArray = new SparseArray();
        if (this.fdK) {
            sparseArray.append(4, new i.a(this.fdB, this.fdJ));
        }
        if (this.fdM) {
            sparseArray.append(2, new i.a(this.fdy, this.fdF));
        }
        if (this.fdN) {
            sparseArray.append(1, new i.a(this.fdA, this.fdG));
        }
        if (this.fdO) {
            sparseArray.append(3, new i.a(this.fdz, this.fdI));
        }
        if (this.fdL) {
            sparseArray.append(6, new i.a(this.fdD, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new i.a(this.fdC, 0));
        }
        if (this.fdP) {
            sparseArray.append(7, new i.a(this.fdE, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
        bag();
    }

    public void baf() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new i.a(this.fdB, this.fdJ));
        sparseArray.append(2, new i.a(this.fdy, this.fdF));
        sparseArray.append(1, new i.a(this.fdA, this.fdG));
        sparseArray.append(3, new i.a(this.fdz, this.fdI));
        sparseArray.append(6, new i.a(this.fdD, 0));
        sparseArray.append(5, new i.a(this.fdC, 0));
        sparseArray.append(7, new i.a(this.fdE, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
    }

    private void bag() {
        boolean z = (this.fdF > 0 && this.fdM) || (this.fdJ > 0 && this.fdK) || ((this.fdI > 0 && this.fdO) || this.mHasNewVersion || this.fdL);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void bah() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void E(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.fdA = z;
                break;
            case 2:
                this.fdy = z;
                break;
            case 3:
                this.fdz = z;
                break;
            case 4:
                this.fdB = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fdS = true;
                this.fdC = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.uo().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fdD = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.uo().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                this.fdE = z;
                break;
        }
        baf();
    }

    public void bai() {
        this.fdy = false;
        this.fdz = false;
        this.fdA = false;
        this.fdB = false;
        this.fdC = false;
        this.fdD = false;
        this.fdE = false;
        this.fdF = 0;
        this.fdG = 0;
        this.fdH = 0;
        this.fdI = 0;
        this.fdJ = 0;
        this.fdK = false;
        this.mHasNewVersion = false;
        this.fdM = false;
        this.fdN = false;
        this.fdO = false;
        this.fdQ = false;
        this.fdP = false;
        bab();
        com.baidu.adp.lib.g.h.fM().post(new h(this));
        bac();
    }
}
