package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aha();
        com.baidu.tieba.im.pushNotify.b.aid();
        LocalViewSize.tu().z(TbadkCoreApplication.m11getInst().getContext());
        com.baidu.tieba.im.a.c.agJ().start();
        com.baidu.tieba.im.b.b.ahC().init(TbadkCoreApplication.m11getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.aie().open();
        com.baidu.tieba.im.push.a.ahV();
        com.baidu.tieba.im.c.a.aiq();
    }
}
