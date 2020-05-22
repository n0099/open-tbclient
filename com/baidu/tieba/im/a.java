package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cnY();
        com.baidu.tieba.im.pushNotify.a.coX();
        LocalViewSize.aUx().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.coy().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.coY().open();
        com.baidu.tieba.im.push.a.coP();
        com.baidu.tieba.im.sendmessage.a.cpm();
    }
}
