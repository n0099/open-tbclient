package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bCr();
        com.baidu.tieba.im.pushNotify.a.bDq();
        LocalViewSize.ahv().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bCR().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bDr().open();
        com.baidu.tieba.im.push.a.bDi();
        com.baidu.tieba.im.sendmessage.a.bDF();
    }
}
