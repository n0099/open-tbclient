package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cTq();
        com.baidu.tieba.im.pushNotify.a.cUs();
        LocalViewSize.bpX().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cTU().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cUt().open();
        com.baidu.tieba.im.push.a.cUk();
        com.baidu.tieba.im.sendmessage.a.cUH();
    }
}
