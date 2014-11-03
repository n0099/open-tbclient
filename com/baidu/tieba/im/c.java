package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tieba.im.chat.w;
/* loaded from: classes.dex */
public class c {
    private static c aNp = new c();
    public static long aNq;
    private boolean adG = false;

    private c() {
        initConfig();
        com.baidu.tieba.im.memorycache.c.PN();
        com.baidu.tieba.im.pushNotify.d.Rp();
        new com.baidu.tieba.light.share.a();
    }

    private void initConfig() {
        this.adG = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public static c Ji() {
        return aNp;
    }

    public static void V(Context context) {
        d.Jn();
        com.baidu.tieba.im.messageCenter.b.Qj();
        LocalViewSize.lV().l(context);
        com.baidu.tieba.im.messageCenter.a.af(context);
        com.baidu.tieba.im.b.c.Px().start();
        com.baidu.tieba.im.c.b.Qy().init(context);
        com.baidu.tieba.im.pushNotify.f.Rq().open();
        w.Js();
        aNq = Thread.currentThread().getId();
    }

    public static void setCurrentAccount(AccountData accountData, Context context) {
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().c(new com.baidu.tbadk.coreExtra.b.c());
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgChat(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgAtme(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgFans(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgGiftNum(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().oT();
    }

    public static String Jj() {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            return null;
        }
        return currentAccountObj.getPortrait();
    }

    public static AccountData Jk() {
        return TbadkApplication.getCurrentAccountObj();
    }

    public boolean Jl() {
        return this.adG;
    }

    public void cw(boolean z) {
        this.adG = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }

    public void C(long j) {
        TbadkSettings.getInst().saveLong("nearbygroup_date" + TbadkApplication.getCurrentAccount(), j);
    }

    public long Jm() {
        return TbadkSettings.getInst().loadLong("nearbygroup_date" + TbadkApplication.getCurrentAccount(), 0L);
    }
}
