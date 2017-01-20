package com.baidu.tbadk.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class i {
    public static final boolean Gn() {
        int i = 0;
        Object d = com.baidu.adp.lib.OrmObject.a.a.d(Looper.myQueue(), "mMessages");
        if (d == null || !(d instanceof Message)) {
            return false;
        }
        Message message = (Message) d;
        boolean z = false;
        while (message != null && message.obj != null && !z && i < 10) {
            i++;
            boolean l = l(message);
            Object d2 = com.baidu.adp.lib.OrmObject.a.a.d(message, "next");
            if (d2 != null && (d2 instanceof Message)) {
                message = (Message) d2;
                z = l;
            } else {
                message = null;
                z = l;
            }
        }
        return z;
    }

    private static final boolean l(Message message) {
        Object d;
        ComponentName component;
        if (message == null) {
            return false;
        }
        Object obj = message.obj;
        return (obj == null || (d = com.baidu.adp.lib.OrmObject.a.a.d(obj, "intent")) == null || !(d instanceof Intent) || (component = ((Intent) d).getComponent()) == null || !"com.baidu.tieba.LogoActivity".equals(component.getClassName())) ? false : true;
    }
}
