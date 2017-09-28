package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.axM();
        com.baidu.tieba.im.pushNotify.a.ayN();
        LocalViewSize.uG().ac(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.axv().start();
        com.baidu.tieba.im.b.b.ayo().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.ayO().open();
        com.baidu.tieba.im.push.a.ayF();
        com.baidu.tieba.im.sendmessage.a.aza();
    }
}
