package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.awn();
        com.baidu.tieba.im.pushNotify.a.axo();
        LocalViewSize.uU().ad(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.avW().start();
        com.baidu.tieba.im.b.b.awP().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.axp().open();
        com.baidu.tieba.im.push.a.axg();
        com.baidu.tieba.im.sendmessage.a.axA();
    }
}
