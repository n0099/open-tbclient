package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.agY();
        com.baidu.tieba.im.pushNotify.b.aib();
        LocalViewSize.tt().z(TbadkCoreApplication.m11getInst().getContext());
        com.baidu.tieba.im.a.c.agH().start();
        com.baidu.tieba.im.b.b.ahA().init(TbadkCoreApplication.m11getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.aic().open();
        com.baidu.tieba.im.push.a.ahT();
        com.baidu.tieba.im.c.a.aio();
    }
}
