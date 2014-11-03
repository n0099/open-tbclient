package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class Static {
    private static final CustomMessageListener Sg = new ab(0);

    static {
        aj.wj();
        MessageManager.getInstance().registerListener(2005009, Sg);
        MessageManager.getInstance().registerListener(2005010, Sg);
        MessageManager.getInstance().registerListener(2005011, Sg);
        MessageManager.getInstance().registerListener(2005012, Sg);
        MessageManager.getInstance().registerListener(2005013, Sg);
        MessageManager.getInstance().registerListener(2005015, Sg);
    }
}
