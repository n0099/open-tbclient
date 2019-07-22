package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bEZ();
        com.baidu.tieba.im.pushNotify.a.bFY();
        LocalViewSize.aix().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bFz().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bFZ().ZP();
        com.baidu.tieba.im.push.a.bFQ();
        com.baidu.tieba.im.sendmessage.a.bGn();
    }
}
