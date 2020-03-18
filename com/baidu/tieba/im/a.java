package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bXb();
        com.baidu.tieba.im.pushNotify.a.bYa();
        LocalViewSize.aGh().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bXB().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bYb().open();
        com.baidu.tieba.im.push.a.bXS();
        com.baidu.tieba.im.sendmessage.a.bYp();
    }
}
