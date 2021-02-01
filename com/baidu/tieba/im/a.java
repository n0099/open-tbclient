package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cWE();
        com.baidu.tieba.im.pushNotify.a.cXy();
        LocalViewSize.bso().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cXa().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cXz().open();
        com.baidu.tieba.im.push.a.cXq();
        com.baidu.tieba.im.sendmessage.a.cXO();
    }
}
