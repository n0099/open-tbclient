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
    private int fhA;
    private int fhB;
    private int fhC;
    private boolean fhD;
    private boolean fhE;
    private boolean fhF;
    private boolean fhG;
    private boolean fhH;
    private boolean fhI;
    private boolean fhJ;
    private boolean fhK;
    private boolean fhL;
    private final CustomMessageListener fhM;
    CustomMessageListener fhN;
    private CustomMessageListener fhO;
    private CustomMessageListener fhP;
    private CustomMessageListener fhQ;
    private CustomMessageListener fhR;
    private boolean fhr;
    private boolean fhs;
    private boolean fht;
    private boolean fhu;
    private boolean fhv;
    private boolean fhw;
    private boolean fhx;
    private int fhy;
    private int fhz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0057a {
        private static final a fhT = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.fhr = false;
        this.fhs = false;
        this.fht = false;
        this.fhu = false;
        this.fhv = false;
        this.fhw = false;
        this.fhx = false;
        this.fhy = 0;
        this.fhz = 0;
        this.fhA = 0;
        this.fhB = 0;
        this.fhC = 0;
        this.fhD = false;
        this.mHasNewVersion = false;
        this.fhE = false;
        this.fhF = false;
        this.fhG = false;
        this.fhH = false;
        this.fhI = false;
        this.fhJ = false;
        this.fhL = false;
        this.fhM = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.fhN = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.fhO = new d(this, CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP);
        this.fhP = new e(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.fhQ = new f(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.fhR = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        initListener();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a bbK() {
        return C0057a.fhT;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fhM);
        MessageManager.getInstance().registerListener(this.fhN);
        MessageManager.getInstance().registerListener(this.fhP);
        MessageManager.getInstance().registerListener(this.fhQ);
        MessageManager.getInstance().registerListener(this.fhR);
        MessageManager.getInstance().registerListener(this.fhO);
    }

    private void bbL() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fhv = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.fhK = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bbM() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fhv || this.fhw)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fhH = newsNotifyMessage.getMsgBookmark() > this.fhB;
            this.fhF = newsNotifyMessage.getMsgFans() > this.fhy;
            this.fhG = newsNotifyMessage.getMsgGiftNum() > this.fhz;
            this.fhB = newsNotifyMessage.getMsgBookmark();
            this.fhy = newsNotifyMessage.getMsgFans();
            this.fhz = newsNotifyMessage.getMsgGiftNum();
            this.fhA = newsNotifyMessage.getMsgLiveVip();
            if (this.fhH || this.fhF || this.fhG || this.mHasNewVersion) {
                this.fhr = this.fhF ? true : this.fhr;
                this.fhs = this.fhH ? true : this.fhs;
                this.fht = this.fhG ? true : this.fht;
                this.fhv = this.mHasNewVersion ? true : this.fhv;
                bbO();
            }
        }
    }

    public void bbN() {
        if (this.fhD) {
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

    public void kM(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbO() {
        SparseArray sparseArray = new SparseArray();
        if (this.fhD) {
            sparseArray.append(4, new i.a(this.fhu, this.fhC));
        }
        if (this.fhF) {
            sparseArray.append(2, new i.a(this.fhr, this.fhy));
        }
        if (this.fhG) {
            sparseArray.append(1, new i.a(this.fht, this.fhz));
        }
        if (this.fhH) {
            sparseArray.append(3, new i.a(this.fhs, this.fhB));
        }
        if (this.fhE) {
            sparseArray.append(6, new i.a(this.fhw, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new i.a(this.fhv, 0));
        }
        if (this.fhI) {
            sparseArray.append(7, new i.a(this.fhx, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
        bbQ();
    }

    public void bbP() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new i.a(this.fhu, this.fhC));
        sparseArray.append(2, new i.a(this.fhr, this.fhy));
        sparseArray.append(1, new i.a(this.fht, this.fhz));
        sparseArray.append(3, new i.a(this.fhs, this.fhB));
        sparseArray.append(6, new i.a(this.fhw, 0));
        sparseArray.append(5, new i.a(this.fhv, 0));
        sparseArray.append(7, new i.a(this.fhx, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
    }

    private void bbQ() {
        boolean z = (this.fhy > 0 && this.fhF) || (this.fhC > 0 && this.fhD) || ((this.fhB > 0 && this.fhH) || this.mHasNewVersion || this.fhE);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void bbR() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void E(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.fht = z;
                break;
            case 2:
                this.fhr = z;
                break;
            case 3:
                this.fhs = z;
                break;
            case 4:
                this.fhu = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fhL = true;
                this.fhv = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fhw = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                this.fhx = z;
                break;
        }
        bbP();
    }

    public void bbS() {
        this.fhr = false;
        this.fhs = false;
        this.fht = false;
        this.fhu = false;
        this.fhv = false;
        this.fhw = false;
        this.fhx = false;
        this.fhy = 0;
        this.fhz = 0;
        this.fhA = 0;
        this.fhB = 0;
        this.fhC = 0;
        this.fhD = false;
        this.mHasNewVersion = false;
        this.fhF = false;
        this.fhG = false;
        this.fhH = false;
        this.fhJ = false;
        this.fhI = false;
        bbL();
        com.baidu.adp.lib.g.h.fS().post(new h(this));
        bbM();
    }
}
