package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.c.Sq();
        com.baidu.tieba.im.pushNotify.b.Tk();
        LocalViewSize.sj().K(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.Sa().start();
        com.baidu.tieba.im.b.b.SS().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.Tl().open();
        com.baidu.tieba.im.c.a.Tx();
    }
}
