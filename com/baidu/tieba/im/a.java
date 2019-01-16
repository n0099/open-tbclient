package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aUa();
        com.baidu.tieba.im.pushNotify.a.aVc();
        LocalViewSize.Dp().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aUD().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aVd().open();
        com.baidu.tieba.im.push.a.aUU();
        com.baidu.tieba.im.sendmessage.a.aVs();
    }
}
