package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cWL();
        com.baidu.tieba.im.pushNotify.a.cXF();
        LocalViewSize.bso().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cXh().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cXG().open();
        com.baidu.tieba.im.push.a.cXx();
        com.baidu.tieba.im.sendmessage.a.cXV();
    }
}
