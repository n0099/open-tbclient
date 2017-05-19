package com.baidu.tieba.h;

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
import com.baidu.tieba.h.i;
/* loaded from: classes.dex */
public class a {
    private boolean fdA;
    private boolean fdB;
    private boolean fdC;
    private boolean fdD;
    private boolean fdE;
    private boolean fdF;
    private boolean fdG;
    private boolean fdH;
    private boolean fdI;
    private final CustomMessageListener fdJ;
    CustomMessageListener fdK;
    private CustomMessageListener fdL;
    private CustomMessageListener fdM;
    private CustomMessageListener fdN;
    private CustomMessageListener fdO;
    private boolean fdl;
    private boolean fdm;
    private boolean fdn;
    private boolean fdo;
    private boolean fdp;
    private boolean fdq;
    private boolean fdr;
    private boolean fds;
    private int fdt;
    private int fdu;
    private int fdv;
    private int fdw;
    private int fdx;
    private int fdy;
    private boolean fdz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062a {
        private static final a fdQ = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.fdl = false;
        this.fdm = false;
        this.fdn = false;
        this.fdo = false;
        this.fdp = false;
        this.fdq = false;
        this.fdr = false;
        this.fds = false;
        this.fdt = 0;
        this.fdu = 0;
        this.fdv = 0;
        this.fdw = 0;
        this.fdx = 0;
        this.fdy = 0;
        this.fdz = false;
        this.mHasNewVersion = false;
        this.fdA = false;
        this.fdB = false;
        this.fdC = false;
        this.fdD = false;
        this.fdE = false;
        this.fdF = false;
        this.fdG = false;
        this.fdI = false;
        this.fdJ = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.fdK = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.fdL = new d(this, CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP);
        this.fdM = new e(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.fdN = new f(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.fdO = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        initListener();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a aZj() {
        return C0062a.fdQ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fdJ);
        MessageManager.getInstance().registerListener(this.fdK);
        MessageManager.getInstance().registerListener(this.fdM);
        MessageManager.getInstance().registerListener(this.fdN);
        MessageManager.getInstance().registerListener(this.fdO);
        MessageManager.getInstance().registerListener(this.fdL);
    }

    private void aZk() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fdp = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.fdH = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void aZl() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fdp || this.fdq)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fdD = newsNotifyMessage.getMsgBookmark() > this.fdw;
            this.fdB = newsNotifyMessage.getMsgFans() > this.fdt;
            this.fdC = newsNotifyMessage.getMsgGiftNum() > this.fdu;
            this.fdG = a(newsNotifyMessage) > this.fdy;
            this.fdw = newsNotifyMessage.getMsgBookmark();
            this.fdt = newsNotifyMessage.getMsgFans();
            this.fdu = newsNotifyMessage.getMsgGiftNum();
            this.fdv = newsNotifyMessage.getMsgLiveVip();
            this.fdy = a(newsNotifyMessage);
            if (this.fdD || this.fdB || this.fdC || this.mHasNewVersion || this.fdG) {
                this.fdl = this.fdB ? true : this.fdl;
                this.fdm = this.fdD ? true : this.fdm;
                this.fdn = this.fdC ? true : this.fdn;
                this.fdp = this.mHasNewVersion ? true : this.fdp;
                this.fds = this.fdG ? true : this.fds;
                aZn();
            }
        }
    }

    private int a(NewsNotifyMessage newsNotifyMessage) {
        int i;
        int i2;
        if (newsNotifyMessage == null) {
            return 0;
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yR().yZ() && com.baidu.tbadk.coreExtra.messageCenter.c.yR().zg()) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        int msgAtme = ((com.baidu.tbadk.coreExtra.messageCenter.c.yR().yW() ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (com.baidu.tbadk.coreExtra.messageCenter.c.yR().yY() ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().zl()) {
            msgAtme -= newsNotifyMessage.getMsgOfficialMerge();
        }
        return msgAtme;
    }

    public void aZm() {
        if (this.fdz) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void aZn() {
        SparseArray sparseArray = new SparseArray();
        if (this.fdz) {
            sparseArray.append(4, new i.a(this.fdo, this.fdx));
        }
        if (this.fdB) {
            sparseArray.append(2, new i.a(this.fdl, this.fdt));
        }
        if (this.fdC) {
            sparseArray.append(1, new i.a(this.fdn, this.fdu));
        }
        if (this.fdD) {
            sparseArray.append(3, new i.a(this.fdm, this.fdw));
        }
        if (this.fdA) {
            sparseArray.append(6, new i.a(this.fdq, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new i.a(this.fdp, 0));
        }
        if (this.fdE) {
            sparseArray.append(7, new i.a(this.fdr, 0));
        }
        if (this.fdG) {
            sparseArray.append(8, new i.a(this.fds, this.fdy));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
        aZp();
    }

    public void aZo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new i.a(this.fdo, this.fdx));
        sparseArray.append(2, new i.a(this.fdl, this.fdt));
        sparseArray.append(1, new i.a(this.fdn, this.fdu));
        sparseArray.append(3, new i.a(this.fdm, this.fdw));
        sparseArray.append(6, new i.a(this.fdq, 0));
        sparseArray.append(5, new i.a(this.fdp, 0));
        sparseArray.append(7, new i.a(this.fdr, 0));
        sparseArray.append(8, new i.a(this.fds, this.fdy));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
    }

    private void aZp() {
        boolean z = (this.fdt > 0 && this.fdB) || (this.fdx > 0 && this.fdz) || ((this.fdw > 0 && this.fdD) || this.mHasNewVersion || this.fdA || this.fdE || this.fdG);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, this.fdy)));
        }
    }

    public void D(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.fdn = z;
                break;
            case 2:
                this.fdl = z;
                break;
            case 3:
                this.fdm = z;
                break;
            case 4:
                this.fdo = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fdI = true;
                this.fdp = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.tX().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fdq = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.tX().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                this.fdr = z;
                break;
            case 8:
                this.fds = z;
                break;
        }
        aZo();
        aZq();
    }

    private void aZq() {
        boolean z = this.fdn || this.fdm || this.fdl || this.fdo || this.fdp || this.fdq || this.fdr || this.fds;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, this.fds ? 0 : this.fdy)));
        }
    }

    public void aZr() {
        this.fdl = false;
        this.fdm = false;
        this.fdn = false;
        this.fdo = false;
        this.fdp = false;
        this.fdq = false;
        this.fdr = false;
        this.fds = false;
        this.fdt = 0;
        this.fdu = 0;
        this.fdv = 0;
        this.fdw = 0;
        this.fdx = 0;
        this.fdy = 0;
        this.fdz = false;
        this.mHasNewVersion = false;
        this.fdB = false;
        this.fdC = false;
        this.fdD = false;
        this.fdF = false;
        this.fdE = false;
        this.fdG = false;
        aZk();
        com.baidu.adp.lib.g.h.fS().post(new h(this));
        aZl();
    }
}
