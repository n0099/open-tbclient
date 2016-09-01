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
import com.baidu.tieba.g.h;
/* loaded from: classes.dex */
public class a {
    private boolean fbP;
    private boolean fbQ;
    private boolean fbR;
    private boolean fbS;
    private boolean fbT;
    private boolean fbU;
    private int fbV;
    private int fbW;
    private int fbX;
    private int fbY;
    private int fbZ;
    private boolean fca;
    private boolean fcb;
    private boolean fcc;
    private boolean fcd;
    private boolean fce;
    private boolean fcf;
    private boolean fcg;
    private boolean fch;
    private final CustomMessageListener fci;
    CustomMessageListener fcj;
    private CustomMessageListener fck;
    private CustomMessageListener fcl;
    private CustomMessageListener fcm;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0059a {
        private static final a fco = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.fbP = false;
        this.fbQ = false;
        this.fbR = false;
        this.fbS = false;
        this.fbT = false;
        this.fbU = false;
        this.fbV = 0;
        this.fbW = 0;
        this.fbX = 0;
        this.fbY = 0;
        this.fbZ = 0;
        this.fca = false;
        this.mHasNewVersion = false;
        this.fcb = false;
        this.fcc = false;
        this.fcd = false;
        this.fce = false;
        this.fcf = false;
        this.fch = false;
        this.fci = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.fcj = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.fck = new d(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.fcl = new e(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.fcm = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        UA();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a bbB() {
        return C0059a.fco;
    }

    private void UA() {
        MessageManager.getInstance().registerListener(this.fci);
        MessageManager.getInstance().registerListener(this.fcj);
        MessageManager.getInstance().registerListener(this.fck);
        MessageManager.getInstance().registerListener(this.fcl);
        MessageManager.getInstance().registerListener(this.fcm);
    }

    private void bbC() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fbT = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.fcg = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bbD() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fbT || this.fbU)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fce = newsNotifyMessage.getMsgBookmark() > this.fbY;
            this.fcc = newsNotifyMessage.getMsgFans() > this.fbV;
            this.fcd = newsNotifyMessage.getMsgGiftNum() > this.fbW;
            this.fbY = newsNotifyMessage.getMsgBookmark();
            this.fbV = newsNotifyMessage.getMsgFans();
            this.fbW = newsNotifyMessage.getMsgGiftNum();
            this.fbX = newsNotifyMessage.getMsgLiveVip();
            if (this.fce || this.fcc || this.fcd || this.mHasNewVersion) {
                this.fbP = this.fcc ? true : this.fbP;
                this.fbQ = this.fce ? true : this.fbQ;
                this.fbR = this.fcd ? true : this.fbR;
                this.fbT = this.mHasNewVersion ? true : this.fbT;
                bbF();
            }
        }
    }

    public void bbE() {
        if (this.fca) {
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

    public void kc(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbF() {
        SparseArray sparseArray = new SparseArray();
        if (this.fca) {
            sparseArray.append(4, new h.a(this.fbS, this.fbZ));
        }
        if (this.fcc) {
            sparseArray.append(2, new h.a(this.fbP, this.fbV));
        }
        if (this.fcd) {
            sparseArray.append(1, new h.a(this.fbR, this.fbW));
        }
        if (this.fce) {
            sparseArray.append(3, new h.a(this.fbQ, this.fbY));
        }
        if (this.fcb) {
            sparseArray.append(6, new h.a(this.fbU, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new h.a(this.fbT, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new h(sparseArray)));
        bbH();
    }

    public void bbG() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new h.a(this.fbS, this.fbZ));
        sparseArray.append(2, new h.a(this.fbP, this.fbV));
        sparseArray.append(1, new h.a(this.fbR, this.fbW));
        sparseArray.append(3, new h.a(this.fbQ, this.fbY));
        sparseArray.append(6, new h.a(this.fbU, 0));
        sparseArray.append(5, new h.a(this.fbT, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new h(sparseArray)));
    }

    private void bbH() {
        boolean z = (this.fbV > 0 && this.fcc) || (this.fbZ > 0 && this.fca) || ((this.fbY > 0 && this.fce) || this.mHasNewVersion || this.fcb);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void bbI() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void O(int i, boolean z) {
        switch (i) {
            case 1:
                this.fbR = z;
                break;
            case 2:
                this.fbP = z;
                break;
            case 3:
                this.fbQ = z;
                break;
            case 4:
                this.fbS = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fch = true;
                this.fbT = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.tS().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fbU = z;
                break;
        }
        bbG();
    }

    public void bbJ() {
        this.fbP = false;
        this.fbQ = false;
        this.fbR = false;
        this.fbS = false;
        this.fbT = false;
        this.fbU = false;
        this.fbV = 0;
        this.fbW = 0;
        this.fbX = 0;
        this.fbY = 0;
        this.fbZ = 0;
        this.fca = false;
        this.mHasNewVersion = false;
        this.fcc = false;
        this.fcd = false;
        this.fce = false;
        this.fcf = false;
        bbC();
        com.baidu.adp.lib.h.h.eG().post(new g(this));
        bbD();
    }
}
