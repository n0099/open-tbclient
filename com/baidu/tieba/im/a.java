package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.cOc();
        com.baidu.tieba.im.pushNotify.a.cPe();
        LocalViewSize.bmr().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.cOG().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.cPf().open();
        com.baidu.tieba.im.push.a.cOW();
        com.baidu.tieba.im.sendmessage.a.cPt();
    }
}
