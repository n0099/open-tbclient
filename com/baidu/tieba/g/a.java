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
    private CustomMessageListener ffA;
    private boolean ffa;
    private boolean ffb;
    private boolean ffc;
    private boolean ffd;
    private boolean ffe;
    private boolean fff;
    private boolean ffg;
    private int ffh;
    private int ffi;
    private int ffj;
    private int ffk;
    private int ffl;
    private boolean ffm;
    private boolean ffn;
    private boolean ffo;
    private boolean ffp;
    private boolean ffq;
    private boolean ffr;
    private boolean ffs;
    private boolean fft;
    private boolean ffu;
    private final CustomMessageListener ffv;
    CustomMessageListener ffw;
    private CustomMessageListener ffx;
    private CustomMessageListener ffy;
    private CustomMessageListener ffz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0057a {
        private static final a ffC = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.ffa = false;
        this.ffb = false;
        this.ffc = false;
        this.ffd = false;
        this.ffe = false;
        this.fff = false;
        this.ffg = false;
        this.ffh = 0;
        this.ffi = 0;
        this.ffj = 0;
        this.ffk = 0;
        this.ffl = 0;
        this.ffm = false;
        this.mHasNewVersion = false;
        this.ffn = false;
        this.ffo = false;
        this.ffp = false;
        this.ffq = false;
        this.ffr = false;
        this.ffs = false;
        this.ffu = false;
        this.ffv = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.ffw = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.ffx = new d(this, CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP);
        this.ffy = new e(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.ffz = new f(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.ffA = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        initListener();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a baJ() {
        return C0057a.ffC;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.ffv);
        MessageManager.getInstance().registerListener(this.ffw);
        MessageManager.getInstance().registerListener(this.ffy);
        MessageManager.getInstance().registerListener(this.ffz);
        MessageManager.getInstance().registerListener(this.ffA);
        MessageManager.getInstance().registerListener(this.ffx);
    }

    private void baK() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ffe = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.fft = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void baL() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.ffe || this.fff)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.ffq = newsNotifyMessage.getMsgBookmark() > this.ffk;
            this.ffo = newsNotifyMessage.getMsgFans() > this.ffh;
            this.ffp = newsNotifyMessage.getMsgGiftNum() > this.ffi;
            this.ffk = newsNotifyMessage.getMsgBookmark();
            this.ffh = newsNotifyMessage.getMsgFans();
            this.ffi = newsNotifyMessage.getMsgGiftNum();
            this.ffj = newsNotifyMessage.getMsgLiveVip();
            if (this.ffq || this.ffo || this.ffp || this.mHasNewVersion) {
                this.ffa = this.ffo ? true : this.ffa;
                this.ffb = this.ffq ? true : this.ffb;
                this.ffc = this.ffp ? true : this.ffc;
                this.ffe = this.mHasNewVersion ? true : this.ffe;
                baN();
            }
        }
    }

    public void baM() {
        if (this.ffm) {
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

    public void kC(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baN() {
        SparseArray sparseArray = new SparseArray();
        if (this.ffm) {
            sparseArray.append(4, new i.a(this.ffd, this.ffl));
        }
        if (this.ffo) {
            sparseArray.append(2, new i.a(this.ffa, this.ffh));
        }
        if (this.ffp) {
            sparseArray.append(1, new i.a(this.ffc, this.ffi));
        }
        if (this.ffq) {
            sparseArray.append(3, new i.a(this.ffb, this.ffk));
        }
        if (this.ffn) {
            sparseArray.append(6, new i.a(this.fff, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new i.a(this.ffe, 0));
        }
        if (this.ffr) {
            sparseArray.append(7, new i.a(this.ffg, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
        baP();
    }

    public void baO() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new i.a(this.ffd, this.ffl));
        sparseArray.append(2, new i.a(this.ffa, this.ffh));
        sparseArray.append(1, new i.a(this.ffc, this.ffi));
        sparseArray.append(3, new i.a(this.ffb, this.ffk));
        sparseArray.append(6, new i.a(this.fff, 0));
        sparseArray.append(5, new i.a(this.ffe, 0));
        sparseArray.append(7, new i.a(this.ffg, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
    }

    private void baP() {
        boolean z = (this.ffh > 0 && this.ffo) || (this.ffl > 0 && this.ffm) || ((this.ffk > 0 && this.ffq) || this.mHasNewVersion || this.ffn);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void baQ() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void E(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.ffc = z;
                break;
            case 2:
                this.ffa = z;
                break;
            case 3:
                this.ffb = z;
                break;
            case 4:
                this.ffd = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.ffu = true;
                this.ffe = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fff = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                this.ffg = z;
                break;
        }
        baO();
    }

    public void baR() {
        this.ffa = false;
        this.ffb = false;
        this.ffc = false;
        this.ffd = false;
        this.ffe = false;
        this.fff = false;
        this.ffg = false;
        this.ffh = 0;
        this.ffi = 0;
        this.ffj = 0;
        this.ffk = 0;
        this.ffl = 0;
        this.ffm = false;
        this.mHasNewVersion = false;
        this.ffo = false;
        this.ffp = false;
        this.ffq = false;
        this.ffs = false;
        this.ffr = false;
        baK();
        com.baidu.adp.lib.g.h.fR().post(new h(this));
        baL();
    }
}
