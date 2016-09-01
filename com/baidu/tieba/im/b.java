package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.auN();
        com.baidu.tieba.im.pushNotify.b.avR();
        LocalViewSize.uw().I(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.auw().start();
        com.baidu.tieba.im.b.b.avp().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.avS().open();
        com.baidu.tieba.im.push.a.avJ();
        com.baidu.tieba.im.c.a.awe();
    }
}
