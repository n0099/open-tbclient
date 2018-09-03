package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aLV();
        com.baidu.tieba.im.pushNotify.a.aMX();
        LocalViewSize.yF().ag(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aMy().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aMY().open();
        com.baidu.tieba.im.push.a.aMP();
        com.baidu.tieba.im.sendmessage.a.aNn();
    }
}
