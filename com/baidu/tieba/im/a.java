package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cRj();
        com.baidu.tieba.im.pushNotify.a.cSl();
        LocalViewSize.bok().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cRN().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cSm().open();
        com.baidu.tieba.im.push.a.cSd();
        com.baidu.tieba.im.sendmessage.a.cSA();
    }
}
