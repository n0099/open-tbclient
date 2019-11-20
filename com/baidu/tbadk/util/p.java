package com.baidu.tbadk.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
/* loaded from: classes.dex */
public class p {
    public static final boolean axE() {
        Message message;
        int i = 0;
        Object valueForField = com.baidu.adp.lib.OrmObject.a.a.getValueForField(Looper.myQueue(), "mMessages");
        if (valueForField == null || !(valueForField instanceof Message)) {
            return false;
        }
        Message message2 = (Message) valueForField;
        boolean z = false;
        while (message2 != null && message2.obj != null && !z && i < 10) {
            i++;
            boolean x = x(message2);
            Object valueForField2 = com.baidu.adp.lib.OrmObject.a.a.getValueForField(message2, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
            if (valueForField2 != null && (valueForField2 instanceof Message)) {
                message = (Message) valueForField2;
            } else {
                message = null;
            }
            message2 = message;
            z = x;
        }
        return z;
    }

    private static final boolean x(Message message) {
        Object valueForField;
        ComponentName component;
        if (message == null) {
            return false;
        }
        Object obj = message.obj;
        return (obj == null || (valueForField = com.baidu.adp.lib.OrmObject.a.a.getValueForField(obj, "intent")) == null || !(valueForField instanceof Intent) || (component = ((Intent) valueForField).getComponent()) == null || !"com.baidu.tieba.LogoActivity".equals(component.getClassName())) ? false : true;
    }
}
