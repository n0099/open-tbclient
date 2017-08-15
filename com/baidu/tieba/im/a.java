package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.axf();
        com.baidu.tieba.im.pushNotify.a.ayg();
        LocalViewSize.ve().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.c.awO().start();
        com.baidu.tieba.im.b.b.axH().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.ayh().open();
        com.baidu.tieba.im.push.a.axY();
        com.baidu.tieba.im.sendmessage.a.ays();
    }
}
