package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.buC();
        com.baidu.tieba.im.pushNotify.a.bvE();
        LocalViewSize.acx().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bvf().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bvF().open();
        com.baidu.tieba.im.push.a.bvw();
        com.baidu.tieba.im.sendmessage.a.bvU();
    }
}
