package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.aTA();
        com.baidu.tieba.im.pushNotify.a.aUC();
        LocalViewSize.Dc().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.aUd().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.aUD().open();
        com.baidu.tieba.im.push.a.aUu();
        com.baidu.tieba.im.sendmessage.a.aUS();
    }
}
