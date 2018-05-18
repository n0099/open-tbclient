package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aFw();
        com.baidu.tieba.im.pushNotify.a.aGz();
        LocalViewSize.vb().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aFZ().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aGA().open();
        com.baidu.tieba.im.push.a.aGr();
        com.baidu.tieba.im.sendmessage.a.aGP();
    }
}
