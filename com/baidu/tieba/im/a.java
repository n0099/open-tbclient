package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aQV();
        com.baidu.tieba.im.pushNotify.a.aRX();
        LocalViewSize.BY().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aRy().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aRY().open();
        com.baidu.tieba.im.push.a.aRP();
        com.baidu.tieba.im.sendmessage.a.aSn();
    }
}
