package com.baidu.tbadk.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class r {
    public static final boolean bIY() {
        Object valueForField = com.baidu.adp.lib.OrmObject.a.a.getValueForField(Looper.myQueue(), "mMessages");
        if (valueForField == null || !(valueForField instanceof Message)) {
            return false;
        }
        Message message = (Message) valueForField;
        int i = 0;
        boolean z = false;
        while (message != null && message.obj != null && !z && i < 10) {
            int i2 = i + 1;
            z = Q(message);
            Object valueForField2 = com.baidu.adp.lib.OrmObject.a.a.getValueForField(message, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
            if (valueForField2 != null && (valueForField2 instanceof Message)) {
                message = (Message) valueForField2;
            } else {
                message = null;
            }
            i = i2;
        }
        return z;
    }

    private static final boolean Q(Message message) {
        Object valueForField;
        ComponentName component;
        if (message == null) {
            return false;
        }
        Object obj = message.obj;
        return (obj == null || (valueForField = com.baidu.adp.lib.OrmObject.a.a.getValueForField(obj, "intent")) == null || !(valueForField instanceof Intent) || (component = ((Intent) valueForField).getComponent()) == null || !"com.baidu.tieba.LogoActivity".equals(component.getClassName())) ? false : true;
    }

    public static final boolean lA(boolean z) {
        Message message;
        Object valueForField;
        Intent intent;
        ComponentName component;
        Object valueForField2 = com.baidu.adp.lib.OrmObject.a.a.getValueForField(Looper.myQueue(), "mMessages");
        if (valueForField2 != null && (valueForField2 instanceof Message)) {
            int i = 0;
            Message message2 = (Message) valueForField2;
            while (message2 != null && message2.obj != null && i < 10) {
                int i2 = i + 1;
                Object obj = message2.obj;
                if (obj != null && (valueForField = com.baidu.adp.lib.OrmObject.a.a.getValueForField(obj, "intent")) != null && (valueForField instanceof Intent) && (component = (intent = (Intent) valueForField).getComponent()) != null) {
                    try {
                        Class.forName(component.getClassName());
                    } catch (Throwable th) {
                        TiebaStatic.log(new aq("check_change_intent_tologo").dX("obj_param1", (i2 == 1) + "").dX(TiebaInitialize.Params.OBJ_PARAM2, component.getClassName()));
                        if (z && i2 == 1) {
                            intent.setClassName(TbadkCoreApplication.getInst(), "com.baidu.tieba.LogoActivity");
                            return false;
                        }
                        return false;
                    }
                }
                Object valueForField3 = com.baidu.adp.lib.OrmObject.a.a.getValueForField(message2, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                if (valueForField3 != null && (valueForField3 instanceof Message)) {
                    message = (Message) valueForField3;
                } else {
                    message = null;
                }
                i = i2;
                message2 = message;
            }
        }
        return true;
    }
}
