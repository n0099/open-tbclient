package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.c.TE();
        com.baidu.tieba.im.pushNotify.b.Uy();
        LocalViewSize.sR().K(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.To().start();
        com.baidu.tieba.im.b.b.Ug().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.Uz().open();
        com.baidu.tieba.im.c.a.UL();
    }
}
