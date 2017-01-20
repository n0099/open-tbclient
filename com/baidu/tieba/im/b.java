package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.asO();
        com.baidu.tieba.im.pushNotify.a.atS();
        LocalViewSize.uv().G(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.asx().start();
        com.baidu.tieba.im.b.b.atq().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.c.atT().open();
        com.baidu.tieba.im.push.a.atK();
        com.baidu.tieba.im.sendmessage.a.auf();
    }
}
