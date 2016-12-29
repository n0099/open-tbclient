package com.baidu.tieba.f;

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
import com.baidu.tieba.f.i;
/* loaded from: classes.dex */
public class a {
    private boolean ePI;
    private boolean ePJ;
    private boolean ePK;
    private boolean ePL;
    private boolean ePM;
    private boolean ePN;
    private boolean ePO;
    private int ePP;
    private int ePQ;
    private int ePR;
    private int ePS;
    private int ePT;
    private boolean ePU;
    private boolean ePV;
    private boolean ePW;
    private boolean ePX;
    private boolean ePY;
    private boolean ePZ;
    private boolean eQa;
    private boolean eQb;
    private boolean eQc;
    private final CustomMessageListener eQd;
    CustomMessageListener eQe;
    private CustomMessageListener eQf;
    private CustomMessageListener eQg;
    private CustomMessageListener eQh;
    private CustomMessageListener eQi;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0058a {
        private static final a eQk = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.ePI = false;
        this.ePJ = false;
        this.ePK = false;
        this.ePL = false;
        this.ePM = false;
        this.ePN = false;
        this.ePO = false;
        this.ePP = 0;
        this.ePQ = 0;
        this.ePR = 0;
        this.ePS = 0;
        this.ePT = 0;
        this.ePU = false;
        this.mHasNewVersion = false;
        this.ePV = false;
        this.ePW = false;
        this.ePX = false;
        this.ePY = false;
        this.ePZ = false;
        this.eQa = false;
        this.eQc = false;
        this.eQd = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.eQe = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.eQf = new d(this, CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP);
        this.eQg = new e(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.eQh = new f(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.eQi = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        Tc();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a aYA() {
        return C0058a.eQk;
    }

    private void Tc() {
        MessageManager.getInstance().registerListener(this.eQd);
        MessageManager.getInstance().registerListener(this.eQe);
        MessageManager.getInstance().registerListener(this.eQg);
        MessageManager.getInstance().registerListener(this.eQh);
        MessageManager.getInstance().registerListener(this.eQi);
        MessageManager.getInstance().registerListener(this.eQf);
    }

    private void aYB() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ePM = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.eQb = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void aYC() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.ePM || this.ePN)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.ePY = newsNotifyMessage.getMsgBookmark() > this.ePS;
            this.ePW = newsNotifyMessage.getMsgFans() > this.ePP;
            this.ePX = newsNotifyMessage.getMsgGiftNum() > this.ePQ;
            this.ePS = newsNotifyMessage.getMsgBookmark();
            this.ePP = newsNotifyMessage.getMsgFans();
            this.ePQ = newsNotifyMessage.getMsgGiftNum();
            this.ePR = newsNotifyMessage.getMsgLiveVip();
            if (this.ePY || this.ePW || this.ePX || this.mHasNewVersion) {
                this.ePI = this.ePW ? true : this.ePI;
                this.ePJ = this.ePY ? true : this.ePJ;
                this.ePK = this.ePX ? true : this.ePK;
                this.ePM = this.mHasNewVersion ? true : this.ePM;
                aYE();
            }
        }
    }

    public void aYD() {
        if (this.ePU) {
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

    public void kq(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYE() {
        SparseArray sparseArray = new SparseArray();
        if (this.ePU) {
            sparseArray.append(4, new i.a(this.ePL, this.ePT));
        }
        if (this.ePW) {
            sparseArray.append(2, new i.a(this.ePI, this.ePP));
        }
        if (this.ePX) {
            sparseArray.append(1, new i.a(this.ePK, this.ePQ));
        }
        if (this.ePY) {
            sparseArray.append(3, new i.a(this.ePJ, this.ePS));
        }
        if (this.ePV) {
            sparseArray.append(6, new i.a(this.ePN, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new i.a(this.ePM, 0));
        }
        if (this.ePZ) {
            sparseArray.append(7, new i.a(this.ePO, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
        aYG();
    }

    public void aYF() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new i.a(this.ePL, this.ePT));
        sparseArray.append(2, new i.a(this.ePI, this.ePP));
        sparseArray.append(1, new i.a(this.ePK, this.ePQ));
        sparseArray.append(3, new i.a(this.ePJ, this.ePS));
        sparseArray.append(6, new i.a(this.ePN, 0));
        sparseArray.append(5, new i.a(this.ePM, 0));
        sparseArray.append(7, new i.a(this.ePO, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
    }

    private void aYG() {
        boolean z = (this.ePP > 0 && this.ePW) || (this.ePT > 0 && this.ePU) || ((this.ePS > 0 && this.ePY) || this.mHasNewVersion || this.ePV);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void aYH() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void D(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.ePK = z;
                break;
            case 2:
                this.ePI = z;
                break;
            case 3:
                this.ePJ = z;
                break;
            case 4:
                this.ePL = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.eQc = true;
                this.ePM = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.tW().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.ePN = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.tW().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                this.ePO = z;
                break;
        }
        aYF();
    }

    public void aYI() {
        this.ePI = false;
        this.ePJ = false;
        this.ePK = false;
        this.ePL = false;
        this.ePM = false;
        this.ePN = false;
        this.ePO = false;
        this.ePP = 0;
        this.ePQ = 0;
        this.ePR = 0;
        this.ePS = 0;
        this.ePT = 0;
        this.ePU = false;
        this.mHasNewVersion = false;
        this.ePW = false;
        this.ePX = false;
        this.ePY = false;
        this.eQa = false;
        this.ePZ = false;
        aYB();
        com.baidu.adp.lib.h.h.eG().post(new h(this));
        aYC();
    }
}
