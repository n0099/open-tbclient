package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aBO();
        com.baidu.tieba.im.pushNotify.a.aCP();
        LocalViewSize.uG().ab(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aCq().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aCQ().open();
        com.baidu.tieba.im.push.a.aCH();
        com.baidu.tieba.im.sendmessage.a.aDc();
    }
}
