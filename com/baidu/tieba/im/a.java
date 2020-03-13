package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bWJ();
        com.baidu.tieba.im.pushNotify.a.bXI();
        LocalViewSize.aGd().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bXj().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bXJ().open();
        com.baidu.tieba.im.push.a.bXA();
        com.baidu.tieba.im.sendmessage.a.bXX();
    }
}
