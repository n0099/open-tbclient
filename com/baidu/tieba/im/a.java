package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aFy();
        com.baidu.tieba.im.pushNotify.a.aGB();
        LocalViewSize.vc().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aGb().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aGC().open();
        com.baidu.tieba.im.push.a.aGt();
        com.baidu.tieba.im.sendmessage.a.aGR();
    }
}
