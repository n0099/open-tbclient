package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cUG();
        com.baidu.tieba.im.pushNotify.a.cVA();
        LocalViewSize.brU().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cVc().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cVB().open();
        com.baidu.tieba.im.push.a.cVs();
        com.baidu.tieba.im.sendmessage.a.cVQ();
    }
}
