package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bFn();
        com.baidu.tieba.im.pushNotify.a.bGm();
        LocalViewSize.aiz().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bFN().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bGn().ZP();
        com.baidu.tieba.im.push.a.bGe();
        com.baidu.tieba.im.sendmessage.a.bGB();
    }
}
