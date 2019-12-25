package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class a {
    public static void init() {
        com.baidu.tieba.im.memorycache.b.bTW();
        com.baidu.tieba.im.pushNotify.a.bUV();
        LocalViewSize.aDy().initial(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.a.b.bUw().init(TbadkCoreApplication.getInst().getContext());
        com.baidu.tieba.im.pushNotify.b.bUW().open();
        com.baidu.tieba.im.push.a.bUN();
        com.baidu.tieba.im.sendmessage.a.bVk();
    }
}
