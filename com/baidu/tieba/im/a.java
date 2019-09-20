package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bGb();
        com.baidu.tieba.im.pushNotify.a.bHa();
        LocalViewSize.aiD().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bGB().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bHb().ZT();
        com.baidu.tieba.im.push.a.bGS();
        com.baidu.tieba.im.sendmessage.a.bHp();
    }
}
