package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cYD();
        com.baidu.tieba.im.pushNotify.a.cZF();
        LocalViewSize.bts().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cZh().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cZG().open();
        com.baidu.tieba.im.push.a.cZx();
        com.baidu.tieba.im.sendmessage.a.cZU();
    }
}
