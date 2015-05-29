package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.c.TD();
        com.baidu.tieba.im.pushNotify.b.Ux();
        LocalViewSize.sR().K(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.Tn().start();
        com.baidu.tieba.im.b.b.Uf().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.Uy().open();
        com.baidu.tieba.im.c.a.UK();
    }
}
