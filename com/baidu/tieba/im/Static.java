package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(103104, new h(0));
        MessageManager.getInstance().registerListener(new i(103101));
        MessageManager.getInstance().registerListener(103112, new j(0));
    }
}
