package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.Vl();
        com.baidu.tieba.im.pushNotify.b.Wf();
        LocalViewSize.tY().I(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.UV().start();
        com.baidu.tieba.im.b.b.VM().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.Wg().open();
        com.baidu.tieba.im.c.a.Ws();
    }
}
