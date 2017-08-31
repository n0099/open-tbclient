package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.ayP();
        com.baidu.tieba.im.pushNotify.a.azQ();
        LocalViewSize.vc().ab(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.ayy().start();
        com.baidu.tieba.im.b.b.azr().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.azR().open();
        com.baidu.tieba.im.push.a.azI();
        com.baidu.tieba.im.sendmessage.a.aAc();
    }
}
