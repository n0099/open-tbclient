package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cYy();
        com.baidu.tieba.im.pushNotify.a.cZs();
        LocalViewSize.bvO().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cYU().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cZt().open();
        com.baidu.tieba.im.push.a.cZk();
        com.baidu.tieba.im.sendmessage.a.cZI();
    }
}
