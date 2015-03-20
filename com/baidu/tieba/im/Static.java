package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(103104, new i(0));
        MessageManager.getInstance().registerListener(new j(103101));
        MessageManager.getInstance().registerListener(103112, new k(0));
    }
}
