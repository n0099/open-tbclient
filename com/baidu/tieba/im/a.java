package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.Zt();
        com.baidu.tieba.im.pushNotify.b.aan();
        LocalViewSize.uG().I(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.Zd().start();
        com.baidu.tieba.im.b.b.ZU().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.aao().open();
        com.baidu.tieba.im.c.a.aaA();
    }
}
