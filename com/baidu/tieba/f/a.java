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
    private boolean flQ;
    private boolean flR;
    private boolean flS;
    private boolean flT;
    private boolean flU;
    private boolean flV;
    private int flW;
    private int flX;
    private int flY;
    private int flZ;
    private int fma;
    private boolean fmb;
    private boolean fmc;
    private boolean fmd;
    private boolean fme;
    private boolean fmf;
    private boolean fmg;
    private boolean fmh;
    private boolean fmi;
    private final CustomMessageListener fmj;
    CustomMessageListener fmk;
    private CustomMessageListener fml;
    private CustomMessageListener fmm;
    private CustomMessageListener fmn;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0059a {
        private static final a fmp = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.flQ = false;
        this.flR = false;
        this.flS = false;
        this.flT = false;
        this.flU = false;
        this.flV = false;
        this.flW = 0;
        this.flX = 0;
        this.flY = 0;
        this.flZ = 0;
        this.fma = 0;
        this.fmb = false;
        this.mHasNewVersion = false;
        this.fmc = false;
        this.fmd = false;
        this.fme = false;
        this.fmf = false;
        this.fmg = false;
        this.fmi = false;
        this.fmj = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.fmk = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.fml = new d(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.fmm = new e(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.fmn = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        VV();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a beM() {
        return C0059a.fmp;
    }

    private void VV() {
        MessageManager.getInstance().registerListener(this.fmj);
        MessageManager.getInstance().registerListener(this.fmk);
        MessageManager.getInstance().registerListener(this.fml);
        MessageManager.getInstance().registerListener(this.fmm);
        MessageManager.getInstance().registerListener(this.fmn);
    }

    private void beN() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.um().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.flU = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.fmh = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void beO() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.flU || this.flV)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fmf = newsNotifyMessage.getMsgBookmark() > this.flZ;
            this.fmd = newsNotifyMessage.getMsgFans() > this.flW;
            this.fme = newsNotifyMessage.getMsgGiftNum() > this.flX;
            this.flZ = newsNotifyMessage.getMsgBookmark();
            this.flW = newsNotifyMessage.getMsgFans();
            this.flX = newsNotifyMessage.getMsgGiftNum();
            this.flY = newsNotifyMessage.getMsgLiveVip();
            if (this.fmf || this.fmd || this.fme || this.mHasNewVersion) {
                this.flQ = this.fmd ? true : this.flQ;
                this.flR = this.fmf ? true : this.flR;
                this.flS = this.fme ? true : this.flS;
                this.flU = this.mHasNewVersion ? true : this.flU;
                beQ();
            }
        }
    }

    public void beP() {
        if (this.fmb) {
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

    public void kH(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beQ() {
        SparseArray sparseArray = new SparseArray();
        if (this.fmb) {
            sparseArray.append(4, new h.a(this.flT, this.fma));
        }
        if (this.fmd) {
            sparseArray.append(2, new h.a(this.flQ, this.flW));
        }
        if (this.fme) {
            sparseArray.append(1, new h.a(this.flS, this.flX));
        }
        if (this.fmf) {
            sparseArray.append(3, new h.a(this.flR, this.flZ));
        }
        if (this.fmc) {
            sparseArray.append(6, new h.a(this.flV, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new h.a(this.flU, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new h(sparseArray)));
        beS();
    }

    public void beR() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new h.a(this.flT, this.fma));
        sparseArray.append(2, new h.a(this.flQ, this.flW));
        sparseArray.append(1, new h.a(this.flS, this.flX));
        sparseArray.append(3, new h.a(this.flR, this.flZ));
        sparseArray.append(6, new h.a(this.flV, 0));
        sparseArray.append(5, new h.a(this.flU, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new h(sparseArray)));
    }

    private void beS() {
        boolean z = (this.flW > 0 && this.fmd) || (this.fma > 0 && this.fmb) || ((this.flZ > 0 && this.fmf) || this.mHasNewVersion || this.fmc);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void beT() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void R(int i, boolean z) {
        switch (i) {
            case 1:
                this.flS = z;
                break;
            case 2:
                this.flQ = z;
                break;
            case 3:
                this.flR = z;
                break;
            case 4:
                this.flT = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.um().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fmi = true;
                this.flU = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.um().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.flV = z;
                break;
        }
        beR();
    }

    public void beU() {
        this.flQ = false;
        this.flR = false;
        this.flS = false;
        this.flT = false;
        this.flU = false;
        this.flV = false;
        this.flW = 0;
        this.flX = 0;
        this.flY = 0;
        this.flZ = 0;
        this.fma = 0;
        this.fmb = false;
        this.mHasNewVersion = false;
        this.fmd = false;
        this.fme = false;
        this.fmf = false;
        this.fmg = false;
        beN();
        com.baidu.adp.lib.h.h.eG().post(new g(this));
        beO();
    }
}
