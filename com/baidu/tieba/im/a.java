package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bVf();
        com.baidu.tieba.im.pushNotify.a.bWe();
        LocalViewSize.aDR().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bVF().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bWf().open();
        com.baidu.tieba.im.push.a.bVW();
        com.baidu.tieba.im.sendmessage.a.bWt();
    }
}
