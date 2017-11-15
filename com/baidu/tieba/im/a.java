package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aAg();
        com.baidu.tieba.im.pushNotify.a.aBh();
        LocalViewSize.uG().ab(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aAI().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aBi().open();
        com.baidu.tieba.im.push.a.aAZ();
        com.baidu.tieba.im.sendmessage.a.aBu();
    }
}
