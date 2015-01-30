package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.c.QO();
        com.baidu.tieba.im.pushNotify.b.Sf();
        LocalViewSize.oT().K(TbadkCoreApplication.m255getInst().getContext());
        com.baidu.tieba.im.a.c.Qy().start();
        com.baidu.tieba.im.b.b.Rt().init(TbadkCoreApplication.m255getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.Sg().open();
        com.baidu.tieba.im.c.a.To();
    }
}
