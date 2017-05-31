package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aqX();
        com.baidu.tieba.im.pushNotify.a.asa();
        LocalViewSize.uy().ad(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.aqG().start();
        com.baidu.tieba.im.b.b.arz().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.c.asb().open();
        com.baidu.tieba.im.push.a.arS();
        com.baidu.tieba.im.sendmessage.a.asm();
    }
}
