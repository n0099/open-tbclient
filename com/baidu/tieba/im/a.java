package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aBG();
        com.baidu.tieba.im.pushNotify.a.aCH();
        LocalViewSize.uJ().ab(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aCi().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aCI().open();
        com.baidu.tieba.im.push.a.aCz();
        com.baidu.tieba.im.sendmessage.a.aCU();
    }
}
