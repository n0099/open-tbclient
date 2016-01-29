package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.ady();
        com.baidu.tieba.im.pushNotify.b.aeB();
        LocalViewSize.vu().I(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.adh().start();
        com.baidu.tieba.im.b.b.aea().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.aeC().open();
        com.baidu.tieba.im.push.a.aet();
        com.baidu.tieba.im.c.a.aeO();
    }
}
