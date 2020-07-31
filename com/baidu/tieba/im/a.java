package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cvV();
        com.baidu.tieba.im.pushNotify.a.cwY();
        LocalViewSize.bas().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cwz().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cwZ().open();
        com.baidu.tieba.im.push.a.cwQ();
        com.baidu.tieba.im.sendmessage.a.cxn();
    }
}
