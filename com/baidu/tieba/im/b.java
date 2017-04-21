package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.atd();
        com.baidu.tieba.im.pushNotify.a.auh();
        LocalViewSize.vp().ad(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.asM().start();
        com.baidu.tieba.im.b.b.atF().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.c.aui().open();
        com.baidu.tieba.im.push.a.atZ();
        com.baidu.tieba.im.sendmessage.a.auu();
    }
}
