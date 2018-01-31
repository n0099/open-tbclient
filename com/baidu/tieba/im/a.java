package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aJa();
        com.baidu.tieba.im.pushNotify.a.aKc();
        LocalViewSize.BZ().an(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aJC().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aKd().open();
        com.baidu.tieba.im.push.a.aJU();
        com.baidu.tieba.im.sendmessage.a.aKp();
    }
}
