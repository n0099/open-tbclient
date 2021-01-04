package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cYx();
        com.baidu.tieba.im.pushNotify.a.cZr();
        LocalViewSize.bvN().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cYT().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cZs().open();
        com.baidu.tieba.im.push.a.cZj();
        com.baidu.tieba.im.sendmessage.a.cZH();
    }
}
