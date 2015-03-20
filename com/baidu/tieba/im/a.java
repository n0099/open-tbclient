package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.c.Sd();
        com.baidu.tieba.im.pushNotify.b.SX();
        LocalViewSize.sj().K(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.RN().start();
        com.baidu.tieba.im.b.b.SF().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.SY().open();
        com.baidu.tieba.im.c.a.Tk();
    }
}
