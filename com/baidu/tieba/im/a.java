package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bCK();
        com.baidu.tieba.im.pushNotify.a.bDJ();
        LocalViewSize.amm().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bDk().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bDK().open();
        com.baidu.tieba.im.push.a.bDB();
        com.baidu.tieba.im.sendmessage.a.bDY();
    }
}
