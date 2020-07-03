package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.crW();
        com.baidu.tieba.im.pushNotify.a.csV();
        LocalViewSize.aWr().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.csw().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.csW().open();
        com.baidu.tieba.im.push.a.csN();
        com.baidu.tieba.im.sendmessage.a.ctk();
    }
}
