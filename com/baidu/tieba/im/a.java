package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aza();
        com.baidu.tieba.im.pushNotify.a.aAb();
        LocalViewSize.vc().ac(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.ayJ().start();
        com.baidu.tieba.im.b.b.azC().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aAc().open();
        com.baidu.tieba.im.push.a.azT();
        com.baidu.tieba.im.sendmessage.a.aAn();
    }
}
