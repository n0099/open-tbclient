package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes2.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cGM();
        com.baidu.tieba.im.pushNotify.a.cHP();
        LocalViewSize.biN().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cHq().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cHQ().open();
        com.baidu.tieba.im.push.a.cHH();
        com.baidu.tieba.im.sendmessage.a.cIe();
    }
}
