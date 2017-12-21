package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aBP();
        com.baidu.tieba.im.pushNotify.a.aCQ();
        LocalViewSize.uG().ab(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aCr().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aCR().open();
        com.baidu.tieba.im.push.a.aCI();
        com.baidu.tieba.im.sendmessage.a.aDd();
    }
}
