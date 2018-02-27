package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aKA();
        com.baidu.tieba.im.pushNotify.a.aLD();
        LocalViewSize.Cr().an(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aLd().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aLE().open();
        com.baidu.tieba.im.push.a.aLv();
        com.baidu.tieba.im.sendmessage.a.aLQ();
    }
}
