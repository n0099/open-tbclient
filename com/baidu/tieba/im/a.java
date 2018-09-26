package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aOk();
        com.baidu.tieba.im.pushNotify.a.aPm();
        LocalViewSize.zK().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aON().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aPn().open();
        com.baidu.tieba.im.push.a.aPe();
        com.baidu.tieba.im.sendmessage.a.aPC();
    }
}
