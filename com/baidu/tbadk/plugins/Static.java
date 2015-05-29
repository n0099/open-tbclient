package com.baidu.tbadk.plugins;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class Static {
    public static final String[] arz = {"android.content.res.Resources$NotFoundException", "android.view.InflateException"};

    static {
        MessageManager.getInstance().registerListener(new a(2001011));
        MessageManager.getInstance().registerListener(new b(2016301));
    }
}
