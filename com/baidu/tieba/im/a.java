package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.awy();
        com.baidu.tieba.im.pushNotify.a.axz();
        LocalViewSize.ve().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.awh().start();
        com.baidu.tieba.im.b.b.axa().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.axA().open();
        com.baidu.tieba.im.push.a.axr();
        com.baidu.tieba.im.sendmessage.a.axL();
    }
}
