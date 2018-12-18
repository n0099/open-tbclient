package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aSM();
        com.baidu.tieba.im.pushNotify.a.aTO();
        LocalViewSize.Dc().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aTp().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aTP().open();
        com.baidu.tieba.im.push.a.aTG();
        com.baidu.tieba.im.sendmessage.a.aUe();
    }
}
