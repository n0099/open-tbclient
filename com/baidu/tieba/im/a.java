package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.Wn();
        com.baidu.tieba.im.pushNotify.b.Xh();
        LocalViewSize.ub().I(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.VX().start();
        com.baidu.tieba.im.b.b.WO().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.Xi().open();
        com.baidu.tieba.im.c.a.Xu();
    }
}
