package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.chB();
        com.baidu.tieba.im.pushNotify.a.ciA();
        LocalViewSize.aOt().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cib().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.ciB().open();
        com.baidu.tieba.im.push.a.cis();
        com.baidu.tieba.im.sendmessage.a.ciP();
    }
}
