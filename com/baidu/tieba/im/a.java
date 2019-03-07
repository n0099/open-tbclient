package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.buF();
        com.baidu.tieba.im.pushNotify.a.bvH();
        LocalViewSize.acA().aN(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bvi().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bvI().open();
        com.baidu.tieba.im.push.a.bvz();
        com.baidu.tieba.im.sendmessage.a.bvX();
    }
}
