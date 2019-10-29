package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bCM();
        com.baidu.tieba.im.pushNotify.a.bDL();
        LocalViewSize.amo().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bDm().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bDM().open();
        com.baidu.tieba.im.push.a.bDD();
        com.baidu.tieba.im.sendmessage.a.bEa();
    }
}
