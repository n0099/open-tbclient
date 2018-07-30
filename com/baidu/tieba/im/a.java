package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aLY();
        com.baidu.tieba.im.pushNotify.a.aNa();
        LocalViewSize.yH().ag(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aMB().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aNb().open();
        com.baidu.tieba.im.push.a.aMS();
        com.baidu.tieba.im.sendmessage.a.aNq();
    }
}
