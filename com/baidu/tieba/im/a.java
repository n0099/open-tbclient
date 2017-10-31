package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aAc();
        com.baidu.tieba.im.pushNotify.a.aBd();
        LocalViewSize.uG().ab(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.azL().start();
        com.baidu.tieba.im.b.b.aAE().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aBe().open();
        com.baidu.tieba.im.push.a.aAV();
        com.baidu.tieba.im.sendmessage.a.aBq();
    }
}
