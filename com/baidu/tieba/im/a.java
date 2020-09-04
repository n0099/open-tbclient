package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cGN();
        com.baidu.tieba.im.pushNotify.a.cHQ();
        LocalViewSize.biN().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cHr().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cHR().open();
        com.baidu.tieba.im.push.a.cHI();
        com.baidu.tieba.im.sendmessage.a.cIf();
    }
}
