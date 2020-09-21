package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cKt();
        com.baidu.tieba.im.pushNotify.a.cLw();
        LocalViewSize.bjI().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cKX().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cLx().open();
        com.baidu.tieba.im.push.a.cLo();
        com.baidu.tieba.im.sendmessage.a.cLL();
    }
}
