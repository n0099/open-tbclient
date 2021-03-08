package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cWS();
        com.baidu.tieba.im.pushNotify.a.cXM();
        LocalViewSize.bsr().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cXo().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cXN().open();
        com.baidu.tieba.im.push.a.cXE();
        com.baidu.tieba.im.sendmessage.a.cYc();
    }
}
