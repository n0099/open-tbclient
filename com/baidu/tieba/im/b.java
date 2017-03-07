package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.asj();
        com.baidu.tieba.im.pushNotify.a.atn();
        LocalViewSize.uS().ae(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.arS().start();
        com.baidu.tieba.im.b.b.asL().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.c.ato().open();
        com.baidu.tieba.im.push.a.atf();
        com.baidu.tieba.im.sendmessage.a.atA();
    }
}
