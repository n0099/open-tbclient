package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cTK();
        com.baidu.tieba.im.pushNotify.a.cUM();
        LocalViewSize.bqK().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cUo().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cUN().open();
        com.baidu.tieba.im.push.a.cUE();
        com.baidu.tieba.im.sendmessage.a.cVb();
    }
}
