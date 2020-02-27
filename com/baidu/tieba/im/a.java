package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bWG();
        com.baidu.tieba.im.pushNotify.a.bXF();
        LocalViewSize.aGb().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bXg().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bXG().open();
        com.baidu.tieba.im.push.a.bXx();
        com.baidu.tieba.im.sendmessage.a.bXU();
    }
}
