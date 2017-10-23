package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.axH();
        com.baidu.tieba.im.pushNotify.a.ayI();
        LocalViewSize.uz().ac(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.axq().start();
        com.baidu.tieba.im.b.b.ayj().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.ayJ().open();
        com.baidu.tieba.im.push.a.ayA();
        com.baidu.tieba.im.sendmessage.a.ayV();
    }
}
