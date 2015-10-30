package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.VS();
        com.baidu.tieba.im.pushNotify.b.WM();
        LocalViewSize.tY().I(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.VC().start();
        com.baidu.tieba.im.b.b.Wt().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.WN().open();
        com.baidu.tieba.im.c.a.WZ();
    }
}
