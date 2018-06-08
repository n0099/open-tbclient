package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aKr();
        com.baidu.tieba.im.pushNotify.a.aLu();
        LocalViewSize.yC().ag(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aKU().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aLv().open();
        com.baidu.tieba.im.push.a.aLm();
        com.baidu.tieba.im.sendmessage.a.aLK();
    }
}
