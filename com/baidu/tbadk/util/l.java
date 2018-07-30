package com.baidu.tbadk.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class l {
    public static final boolean Ll() {
        Message message;
        int i = 0;
        Object c = com.baidu.adp.lib.OrmObject.a.a.c(Looper.myQueue(), "mMessages");
        if (c == null || !(c instanceof Message)) {
            return false;
        }
        Message message2 = (Message) c;
        boolean z = false;
        while (message2 != null && message2.obj != null && !z && i < 10) {
            i++;
            boolean m = m(message2);
            Object c2 = com.baidu.adp.lib.OrmObject.a.a.c(message2, "next");
            if (c2 != null && (c2 instanceof Message)) {
                message = (Message) c2;
            } else {
                message = null;
            }
            message2 = message;
            z = m;
        }
        return z;
    }

    private static final boolean m(Message message) {
        Object c;
        ComponentName component;
        if (message == null) {
            return false;
        }
        Object obj = message.obj;
        return (obj == null || (c = com.baidu.adp.lib.OrmObject.a.a.c(obj, "intent")) == null || !(c instanceof Intent) || (component = ((Intent) c).getComponent()) == null || !"com.baidu.tieba.LogoActivity".equals(component.getClassName())) ? false : true;
    }
}
