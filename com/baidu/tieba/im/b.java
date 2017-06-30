package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.auI();
        com.baidu.tieba.im.pushNotify.a.avL();
        LocalViewSize.uO().ad(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.aur().start();
        com.baidu.tieba.im.b.b.avk().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.c.avM().open();
        com.baidu.tieba.im.push.a.avD();
        com.baidu.tieba.im.sendmessage.a.avX();
    }
}
