package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.c.Qs();
        com.baidu.tieba.im.pushNotify.b.RJ();
        LocalViewSize.oQ().K(TbadkCoreApplication.m255getInst().getContext());
        com.baidu.tieba.im.a.c.Qc().start();
        com.baidu.tieba.im.b.b.QX().init(TbadkCoreApplication.m255getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.RK().open();
        com.baidu.tieba.im.c.a.SS();
    }
}
