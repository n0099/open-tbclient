package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aay();
        com.baidu.tieba.im.pushNotify.b.abv();
        LocalViewSize.uq().I(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.aai().start();
        com.baidu.tieba.im.b.b.aba().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.abw().open();
        com.baidu.tieba.im.push.a.abt();
        com.baidu.tieba.im.c.a.abI();
    }
}
