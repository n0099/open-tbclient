package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aSN();
        com.baidu.tieba.im.pushNotify.a.aTP();
        LocalViewSize.Dc().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aTq().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aTQ().open();
        com.baidu.tieba.im.push.a.aTH();
        com.baidu.tieba.im.sendmessage.a.aUf();
    }
}
