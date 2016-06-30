package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.apn();
        com.baidu.tieba.im.pushNotify.b.aqr();
        LocalViewSize.tr().y(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.a.c.aoW().start();
        com.baidu.tieba.im.b.b.apP().init(TbadkCoreApplication.m9getInst().getContext());
        com.baidu.tieba.im.pushNotify.d.aqs().open();
        com.baidu.tieba.im.push.a.aqj();
        com.baidu.tieba.im.c.a.aqE();
    }
}
