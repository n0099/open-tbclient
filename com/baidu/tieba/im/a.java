package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.coh();
        com.baidu.tieba.im.pushNotify.a.cpg();
        LocalViewSize.aUx().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.coH().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cph().open();
        com.baidu.tieba.im.push.a.coY();
        com.baidu.tieba.im.sendmessage.a.cpv();
    }
}
