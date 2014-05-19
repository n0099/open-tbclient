package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class Static {
    private static final CustomMessageListener a = new x(0);

    static {
        ad.a();
        MessageManager.getInstance().registerListener(2007009, a);
        MessageManager.getInstance().registerListener(2007010, a);
        MessageManager.getInstance().registerListener(2007011, a);
        MessageManager.getInstance().registerListener(2007012, a);
        MessageManager.getInstance().registerListener(2007013, a);
    }
}
