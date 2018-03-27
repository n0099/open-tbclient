package com.baidu.tbadk.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class l {
    public static final boolean Pb() {
        Message message;
        int i = 0;
        Object g = com.baidu.adp.lib.OrmObject.a.a.g(Looper.myQueue(), "mMessages");
        if (g == null || !(g instanceof Message)) {
            return false;
        }
        Message message2 = (Message) g;
        boolean z = false;
        while (message2 != null && message2.obj != null && !z && i < 10) {
            i++;
            boolean l = l(message2);
            Object g2 = com.baidu.adp.lib.OrmObject.a.a.g(message2, "next");
            if (g2 != null && (g2 instanceof Message)) {
                message = (Message) g2;
            } else {
                message = null;
            }
            message2 = message;
            z = l;
        }
        return z;
    }

    private static final boolean l(Message message) {
        Object g;
        ComponentName component;
        if (message == null) {
            return false;
        }
        Object obj = message.obj;
        return (obj == null || (g = com.baidu.adp.lib.OrmObject.a.a.g(obj, "intent")) == null || !(g instanceof Intent) || (component = ((Intent) g).getComponent()) == null || !"com.baidu.tieba.LogoActivity".equals(component.getClassName())) ? false : true;
    }
}
