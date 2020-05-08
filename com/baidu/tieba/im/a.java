package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.chA();
        com.baidu.tieba.im.pushNotify.a.ciz();
        LocalViewSize.aOt().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cia().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.ciA().open();
        com.baidu.tieba.im.push.a.cir();
        com.baidu.tieba.im.sendmessage.a.ciO();
    }
}
