package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tieba.im.chat.w;
/* loaded from: classes.dex */
public class c {
    private static c aNb = new c();
    public static long aNc;
    private boolean adB = false;

    private c() {
        initConfig();
        com.baidu.tieba.im.memorycache.c.PK();
        com.baidu.tieba.im.pushNotify.d.Rm();
        new com.baidu.tieba.light.share.a();
    }

    private void initConfig() {
        this.adB = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public static c Je() {
        return aNb;
    }

    public static void V(Context context) {
        d.Jj();
        com.baidu.tieba.im.messageCenter.b.Qg();
        LocalViewSize.lV().l(context);
        com.baidu.tieba.im.messageCenter.a.af(context);
        com.baidu.tieba.im.b.c.Pu().start();
        com.baidu.tieba.im.c.b.Qv().init(context);
        com.baidu.tieba.im.pushNotify.f.Rn().open();
        w.Jo();
        aNc = Thread.currentThread().getId();
    }

    public static void setCurrentAccount(AccountData accountData, Context context) {
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().c(new com.baidu.tbadk.coreExtra.b.c());
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgChat(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgAtme(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgFans(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgGiftNum(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oR();
    }

    public static String Jf() {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            return null;
        }
        return currentAccountObj.getPortrait();
    }

    public static AccountData Jg() {
        return TbadkApplication.getCurrentAccountObj();
    }

    public boolean Jh() {
        return this.adB;
    }

    public void cw(boolean z) {
        this.adB = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }

    public void C(long j) {
        TbadkSettings.getInst().saveLong("nearbygroup_date" + TbadkApplication.getCurrentAccount(), j);
    }

    public long Ji() {
        return TbadkSettings.getInst().loadLong("nearbygroup_date" + TbadkApplication.getCurrentAccount(), 0L);
    }
}
