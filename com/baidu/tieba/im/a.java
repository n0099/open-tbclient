package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aIV();
        com.baidu.tieba.im.pushNotify.a.aJX();
        LocalViewSize.BY().an(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aJx().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aJY().open();
        com.baidu.tieba.im.push.a.aJP();
        com.baidu.tieba.im.sendmessage.a.aKk();
    }
}
