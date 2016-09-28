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
import com.baidu.tieba.f.h;
/* loaded from: classes.dex */
public class a {
    private boolean feA;
    private boolean feB;
    private boolean feC;
    private boolean feD;
    private int feE;
    private int feF;
    private int feG;
    private int feH;
    private int feI;
    private boolean feJ;
    private boolean feK;
    private boolean feL;
    private boolean feM;
    private boolean feN;
    private boolean feO;
    private boolean feP;
    private boolean feQ;
    private final CustomMessageListener feR;
    CustomMessageListener feS;
    private CustomMessageListener feT;
    private CustomMessageListener feU;
    private CustomMessageListener feV;
    private boolean fey;
    private boolean fez;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0059a {
        private static final a feX = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.fey = false;
        this.fez = false;
        this.feA = false;
        this.feB = false;
        this.feC = false;
        this.feD = false;
        this.feE = 0;
        this.feF = 0;
        this.feG = 0;
        this.feH = 0;
        this.feI = 0;
        this.feJ = false;
        this.mHasNewVersion = false;
        this.feK = false;
        this.feL = false;
        this.feM = false;
        this.feN = false;
        this.feO = false;
        this.feQ = false;
        this.feR = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.feS = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.feT = new d(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.feU = new e(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.feV = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        UT();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a bcl() {
        return C0059a.feX;
    }

    private void UT() {
        MessageManager.getInstance().registerListener(this.feR);
        MessageManager.getInstance().registerListener(this.feS);
        MessageManager.getInstance().registerListener(this.feT);
        MessageManager.getInstance().registerListener(this.feU);
        MessageManager.getInstance().registerListener(this.feV);
    }

    private void bcm() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.feC = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.feP = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bcn() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.feC || this.feD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.feN = newsNotifyMessage.getMsgBookmark() > this.feH;
            this.feL = newsNotifyMessage.getMsgFans() > this.feE;
            this.feM = newsNotifyMessage.getMsgGiftNum() > this.feF;
            this.feH = newsNotifyMessage.getMsgBookmark();
            this.feE = newsNotifyMessage.getMsgFans();
            this.feF = newsNotifyMessage.getMsgGiftNum();
            this.feG = newsNotifyMessage.getMsgLiveVip();
            if (this.feN || this.feL || this.feM || this.mHasNewVersion) {
                this.fey = this.feL ? true : this.fey;
                this.fez = this.feN ? true : this.fez;
                this.feA = this.feM ? true : this.feA;
                this.feC = this.mHasNewVersion ? true : this.feC;
                bcp();
            }
        }
    }

    public void bco() {
        if (this.feJ) {
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

    public void kf(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcp() {
        SparseArray sparseArray = new SparseArray();
        if (this.feJ) {
            sparseArray.append(4, new h.a(this.feB, this.feI));
        }
        if (this.feL) {
            sparseArray.append(2, new h.a(this.fey, this.feE));
        }
        if (this.feM) {
            sparseArray.append(1, new h.a(this.feA, this.feF));
        }
        if (this.feN) {
            sparseArray.append(3, new h.a(this.fez, this.feH));
        }
        if (this.feK) {
            sparseArray.append(6, new h.a(this.feD, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new h.a(this.feC, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new h(sparseArray)));
        bcr();
    }

    public void bcq() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new h.a(this.feB, this.feI));
        sparseArray.append(2, new h.a(this.fey, this.feE));
        sparseArray.append(1, new h.a(this.feA, this.feF));
        sparseArray.append(3, new h.a(this.fez, this.feH));
        sparseArray.append(6, new h.a(this.feD, 0));
        sparseArray.append(5, new h.a(this.feC, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new h(sparseArray)));
    }

    private void bcr() {
        boolean z = (this.feE > 0 && this.feL) || (this.feI > 0 && this.feJ) || ((this.feH > 0 && this.feN) || this.mHasNewVersion || this.feK);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void bcs() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void O(int i, boolean z) {
        switch (i) {
            case 1:
                this.feA = z;
                break;
            case 2:
                this.fey = z;
                break;
            case 3:
                this.fez = z;
                break;
            case 4:
                this.feB = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.feQ = true;
                this.feC = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.uh().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.feD = z;
                break;
        }
        bcq();
    }

    public void bct() {
        this.fey = false;
        this.fez = false;
        this.feA = false;
        this.feB = false;
        this.feC = false;
        this.feD = false;
        this.feE = 0;
        this.feF = 0;
        this.feG = 0;
        this.feH = 0;
        this.feI = 0;
        this.feJ = false;
        this.mHasNewVersion = false;
        this.feL = false;
        this.feM = false;
        this.feN = false;
        this.feO = false;
        bcm();
        com.baidu.adp.lib.h.h.eG().post(new g(this));
        bcn();
    }
}
