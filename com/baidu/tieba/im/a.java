package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.axa();
        com.baidu.tieba.im.pushNotify.a.ayb();
        LocalViewSize.vf().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.awJ().start();
        com.baidu.tieba.im.b.b.axC().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.ayc().open();
        com.baidu.tieba.im.push.a.axT();
        com.baidu.tieba.im.sendmessage.a.ayn();
    }
}
