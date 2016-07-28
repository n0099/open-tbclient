package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.apZ();
        com.baidu.tieba.im.pushNotify.b.ard();
        LocalViewSize.tq().y(TbadkCoreApplication.m10getInst().getContext());
        com.baidu.tieba.im.a.c.apI().start();
        com.baidu.tieba.im.b.b.aqB().init(TbadkCoreApplication.m10getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.are().open();
        com.baidu.tieba.im.push.a.aqV();
        com.baidu.tieba.im.c.a.arq();
    }
}
