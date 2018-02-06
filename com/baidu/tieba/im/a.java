package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aKB();
        com.baidu.tieba.im.pushNotify.a.aLE();
        LocalViewSize.Cs().an(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aLe().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aLF().open();
        com.baidu.tieba.im.push.a.aLw();
        com.baidu.tieba.im.sendmessage.a.aLR();
    }
}
