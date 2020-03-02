package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bWI();
        com.baidu.tieba.im.pushNotify.a.bXH();
        LocalViewSize.aGd().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bXi().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bXI().open();
        com.baidu.tieba.im.push.a.bXz();
        com.baidu.tieba.im.sendmessage.a.bXW();
    }
}
