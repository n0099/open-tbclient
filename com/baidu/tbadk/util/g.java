package com.baidu.tbadk.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class g {
    public static final boolean Gy() {
        int i = 0;
        Object c = com.baidu.adp.lib.a.a.a.c(Looper.myQueue(), "mMessages");
        if (c == null || !(c instanceof Message)) {
            return false;
        }
        Message message = (Message) c;
        boolean z = false;
        while (message != null && message.obj != null && !z && i < 10) {
            i++;
            boolean b = b(message);
            Object c2 = com.baidu.adp.lib.a.a.a.c(message, "next");
            if (c2 != null && (c2 instanceof Message)) {
                message = (Message) c2;
                z = b;
            } else {
                message = null;
                z = b;
            }
        }
        return z;
    }

    private static final boolean b(Message message) {
        Object c;
        ComponentName component;
        if (message == null) {
            return false;
        }
        Object obj = message.obj;
        return (obj == null || (c = com.baidu.adp.lib.a.a.a.c(obj, "intent")) == null || !(c instanceof Intent) || (component = ((Intent) c).getComponent()) == null || !"com.baidu.tieba.LogoActivity".equals(component.getClassName())) ? false : true;
    }
}
