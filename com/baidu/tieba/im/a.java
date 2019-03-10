package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.buG();
        com.baidu.tieba.im.pushNotify.a.bvI();
        LocalViewSize.acA().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bvj().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bvJ().open();
        com.baidu.tieba.im.push.a.bvA();
        com.baidu.tieba.im.sendmessage.a.bvY();
    }
}
