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
    private CustomMessageListener eZA;
    private CustomMessageListener eZB;
    private CustomMessageListener eZC;
    private CustomMessageListener eZD;
    private boolean eZd;
    private boolean eZe;
    private boolean eZf;
    private boolean eZg;
    private boolean eZh;
    private boolean eZi;
    private boolean eZj;
    private int eZk;
    private int eZl;
    private int eZm;
    private int eZn;
    private int eZo;
    private boolean eZp;
    private boolean eZq;
    private boolean eZr;
    private boolean eZs;
    private boolean eZt;
    private boolean eZu;
    private boolean eZv;
    private boolean eZw;
    private boolean eZx;
    private final CustomMessageListener eZy;
    CustomMessageListener eZz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0059a {
        private static final a eZF = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.eZd = false;
        this.eZe = false;
        this.eZf = false;
        this.eZg = false;
        this.eZh = false;
        this.eZi = false;
        this.eZj = false;
        this.eZk = 0;
        this.eZl = 0;
        this.eZm = 0;
        this.eZn = 0;
        this.eZo = 0;
        this.eZp = false;
        this.mHasNewVersion = false;
        this.eZq = false;
        this.eZr = false;
        this.eZs = false;
        this.eZt = false;
        this.eZu = false;
        this.eZv = false;
        this.eZx = false;
        this.eZy = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.eZz = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.eZA = new d(this, CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP);
        this.eZB = new e(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.eZC = new f(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.eZD = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        Mj();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a bap() {
        return C0059a.eZF;
    }

    private void Mj() {
        MessageManager.getInstance().registerListener(this.eZy);
        MessageManager.getInstance().registerListener(this.eZz);
        MessageManager.getInstance().registerListener(this.eZB);
        MessageManager.getInstance().registerListener(this.eZC);
        MessageManager.getInstance().registerListener(this.eZD);
        MessageManager.getInstance().registerListener(this.eZA);
    }

    private void baq() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.eZh = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.eZw = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bar() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.eZh || this.eZi)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.eZt = newsNotifyMessage.getMsgBookmark() > this.eZn;
            this.eZr = newsNotifyMessage.getMsgFans() > this.eZk;
            this.eZs = newsNotifyMessage.getMsgGiftNum() > this.eZl;
            this.eZn = newsNotifyMessage.getMsgBookmark();
            this.eZk = newsNotifyMessage.getMsgFans();
            this.eZl = newsNotifyMessage.getMsgGiftNum();
            this.eZm = newsNotifyMessage.getMsgLiveVip();
            if (this.eZt || this.eZr || this.eZs || this.mHasNewVersion) {
                this.eZd = this.eZr ? true : this.eZd;
                this.eZe = this.eZt ? true : this.eZe;
                this.eZf = this.eZs ? true : this.eZf;
                this.eZh = this.mHasNewVersion ? true : this.eZh;
                bat();
            }
        }
    }

    public void bas() {
        if (this.eZp) {
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
    public void bat() {
        SparseArray sparseArray = new SparseArray();
        if (this.eZp) {
            sparseArray.append(4, new i.a(this.eZg, this.eZo));
        }
        if (this.eZr) {
            sparseArray.append(2, new i.a(this.eZd, this.eZk));
        }
        if (this.eZs) {
            sparseArray.append(1, new i.a(this.eZf, this.eZl));
        }
        if (this.eZt) {
            sparseArray.append(3, new i.a(this.eZe, this.eZn));
        }
        if (this.eZq) {
            sparseArray.append(6, new i.a(this.eZi, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new i.a(this.eZh, 0));
        }
        if (this.eZu) {
            sparseArray.append(7, new i.a(this.eZj, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
        bav();
    }

    public void bau() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new i.a(this.eZg, this.eZo));
        sparseArray.append(2, new i.a(this.eZd, this.eZk));
        sparseArray.append(1, new i.a(this.eZf, this.eZl));
        sparseArray.append(3, new i.a(this.eZe, this.eZn));
        sparseArray.append(6, new i.a(this.eZi, 0));
        sparseArray.append(5, new i.a(this.eZh, 0));
        sparseArray.append(7, new i.a(this.eZj, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
    }

    private void bav() {
        boolean z = (this.eZk > 0 && this.eZr) || (this.eZo > 0 && this.eZp) || ((this.eZn > 0 && this.eZt) || this.mHasNewVersion || this.eZq);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void baw() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void D(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.eZf = z;
                break;
            case 2:
                this.eZd = z;
                break;
            case 3:
                this.eZe = z;
                break;
            case 4:
                this.eZg = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.eZx = true;
                this.eZh = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.tQ().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.eZi = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.tQ().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                this.eZj = z;
                break;
        }
        bau();
    }

    public void bax() {
        this.eZd = false;
        this.eZe = false;
        this.eZf = false;
        this.eZg = false;
        this.eZh = false;
        this.eZi = false;
        this.eZj = false;
        this.eZk = 0;
        this.eZl = 0;
        this.eZm = 0;
        this.eZn = 0;
        this.eZo = 0;
        this.eZp = false;
        this.mHasNewVersion = false;
        this.eZr = false;
        this.eZs = false;
        this.eZt = false;
        this.eZv = false;
        this.eZu = false;
        baq();
        com.baidu.adp.lib.g.h.eE().post(new h(this));
        bar();
    }
}
