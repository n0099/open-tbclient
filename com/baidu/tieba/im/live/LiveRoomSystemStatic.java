package com.baidu.tieba.im.live;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class LiveRoomSystemStatic {
    static {
        q qVar = new q(0);
        MessageManager.getInstance().registerListener(2001202, qVar);
        MessageManager.getInstance().registerListener(2001203, qVar);
        MessageManager.getInstance().registerListener(2001204, qVar);
        MessageManager.getInstance().registerListener(2001205, qVar);
        MessageManager.getInstance().registerListener(2001206, qVar);
        MessageManager.getInstance().registerListener(2001207, qVar);
        MessageManager.getInstance().registerListener(2001208, qVar);
        MessageManager.getInstance().registerListener(2001209, qVar);
    }
}
