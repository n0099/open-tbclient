package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.crX();
        com.baidu.tieba.im.pushNotify.a.csW();
        LocalViewSize.aWr().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.csx().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.csX().open();
        com.baidu.tieba.im.push.a.csO();
        com.baidu.tieba.im.sendmessage.a.ctl();
    }
}
