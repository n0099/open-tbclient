package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aKX();
        com.baidu.tieba.im.pushNotify.a.aMa();
        LocalViewSize.yQ().ag(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aLA().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aMb().open();
        com.baidu.tieba.im.push.a.aLS();
        com.baidu.tieba.im.sendmessage.a.aMq();
    }
}
