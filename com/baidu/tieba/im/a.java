package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.VW();
        com.baidu.tieba.im.pushNotify.b.WQ();
        LocalViewSize.ub().I(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.VG().start();
        com.baidu.tieba.im.b.b.Wx().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.WR().open();
        com.baidu.tieba.im.c.a.Xd();
    }
}
