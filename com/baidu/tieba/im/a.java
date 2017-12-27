package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aIQ();
        com.baidu.tieba.im.pushNotify.a.aJS();
        LocalViewSize.Cg().an(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aJs().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aJT().open();
        com.baidu.tieba.im.push.a.aJK();
        com.baidu.tieba.im.sendmessage.a.aKf();
    }
}
