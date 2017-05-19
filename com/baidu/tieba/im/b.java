package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.apX();
        com.baidu.tieba.im.pushNotify.a.arb();
        LocalViewSize.uC().ad(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.apG().start();
        com.baidu.tieba.im.b.b.aqz().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.c.arc().open();
        com.baidu.tieba.im.push.a.aqT();
        com.baidu.tieba.im.sendmessage.a.aro();
    }
}
