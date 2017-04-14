package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.asc();
        com.baidu.tieba.im.pushNotify.a.atg();
        LocalViewSize.vp().ad(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.arL().start();
        com.baidu.tieba.im.b.b.asE().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.c.ath().open();
        com.baidu.tieba.im.push.a.asY();
        com.baidu.tieba.im.sendmessage.a.att();
    }
}
