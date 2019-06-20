package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bCs();
        com.baidu.tieba.im.pushNotify.a.bDr();
        LocalViewSize.ahv().ae(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bCS().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bDs().open();
        com.baidu.tieba.im.push.a.bDj();
        com.baidu.tieba.im.sendmessage.a.bDG();
    }
}
