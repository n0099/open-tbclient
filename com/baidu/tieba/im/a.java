package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cYC();
        com.baidu.tieba.im.pushNotify.a.cZE();
        LocalViewSize.bts().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cZg().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cZF().open();
        com.baidu.tieba.im.push.a.cZw();
        com.baidu.tieba.im.sendmessage.a.cZT();
    }
}
