package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.chC();
        com.baidu.tieba.im.pushNotify.a.ciB();
        LocalViewSize.aOv().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cic().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.ciC().open();
        com.baidu.tieba.im.push.a.cit();
        com.baidu.tieba.im.sendmessage.a.ciQ();
    }
}
