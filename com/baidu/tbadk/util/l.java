package com.baidu.tbadk.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class l {
    public static final boolean GO() {
        Message message;
        int i = 0;
        Object d = com.baidu.adp.lib.OrmObject.a.a.d(Looper.myQueue(), "mMessages");
        if (d == null || !(d instanceof Message)) {
            return false;
        }
        Message message2 = (Message) d;
        boolean z = false;
        while (message2 != null && message2.obj != null && !z && i < 10) {
            i++;
            boolean l = l(message2);
            Object d2 = com.baidu.adp.lib.OrmObject.a.a.d(message2, "next");
            if (d2 != null && (d2 instanceof Message)) {
                message = (Message) d2;
            } else {
                message = null;
            }
            message2 = message;
            z = l;
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
