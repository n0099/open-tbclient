package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(103104, new g(0));
        MessageManager.getInstance().registerListener(new h(103101));
        MessageManager.getInstance().registerListener(103112, new i(0));
    }
}
