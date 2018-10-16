package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aRy();
        com.baidu.tieba.im.pushNotify.a.aSA();
        LocalViewSize.BR().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aSb().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aSB().open();
        com.baidu.tieba.im.push.a.aSs();
        com.baidu.tieba.im.sendmessage.a.aSQ();
    }
}
