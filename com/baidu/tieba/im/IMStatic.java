package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class IMStatic {
    static {
        MessageManager.getInstance().registerListener(2005016, new b(0));
    }
}
