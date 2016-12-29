package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.arI();
        com.baidu.tieba.im.pushNotify.b.asM();
        LocalViewSize.uB().G(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.arr().start();
        com.baidu.tieba.im.b.b.ask().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.asN().open();
        com.baidu.tieba.im.push.a.asE();
        com.baidu.tieba.im.c.a.asZ();
    }
}
