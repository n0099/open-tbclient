package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.axj();
        com.baidu.tieba.im.pushNotify.b.ayn();
        LocalViewSize.uP().I(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.awS().start();
        com.baidu.tieba.im.b.b.axL().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.ayo().open();
        com.baidu.tieba.im.push.a.ayf();
        com.baidu.tieba.im.c.a.ayA();
    }
}
