package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.avm();
        com.baidu.tieba.im.pushNotify.b.awq();
        LocalViewSize.uL().I(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.auV().start();
        com.baidu.tieba.im.b.b.avO().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.awr().open();
        com.baidu.tieba.im.push.a.awi();
        com.baidu.tieba.im.c.a.awD();
    }
}
