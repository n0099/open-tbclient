package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.Vn();
        com.baidu.tieba.im.pushNotify.b.Wh();
        LocalViewSize.ud().I(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.a.c.UX().start();
        com.baidu.tieba.im.b.b.VO().init(TbadkCoreApplication.m411getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.Wi().open();
        com.baidu.tieba.im.c.a.Wu();
    }
}
