package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bCo();
        com.baidu.tieba.im.pushNotify.a.bDn();
        LocalViewSize.ahv().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bCO().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bDo().open();
        com.baidu.tieba.im.push.a.bDf();
        com.baidu.tieba.im.sendmessage.a.bDC();
    }
}
