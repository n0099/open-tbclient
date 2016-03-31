package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.agR();
        com.baidu.tieba.im.pushNotify.b.ahU();
        LocalViewSize.vN().z(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.agA().start();
        com.baidu.tieba.im.b.b.aht().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.ahV().open();
        com.baidu.tieba.im.push.a.ahM();
        com.baidu.tieba.im.c.a.aih();
    }
}
