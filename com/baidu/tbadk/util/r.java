package com.baidu.tbadk.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class r {
    public static final boolean bgD() {
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
            boolean P = P(message2);
            Object valueForField2 = com.baidu.adp.lib.OrmObject.a.a.getValueForField(message2, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
            if (valueForField2 != null && (valueForField2 instanceof Message)) {
                message = (Message) valueForField2;
            } else {
                message = null;
            }
            message2 = message;
            z = P;
        }
        return z;
    }

    private static final boolean P(Message message) {
        Object valueForField;
        ComponentName component;
        if (message == null) {
            return false;
        }
        Object obj = message.obj;
        return (obj == null || (valueForField = com.baidu.adp.lib.OrmObject.a.a.getValueForField(obj, "intent")) == null || !(valueForField instanceof Intent) || (component = ((Intent) valueForField).getComponent()) == null || !"com.baidu.tieba.LogoActivity".equals(component.getClassName())) ? false : true;
    }

    public static boolean ea(Context context) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(100)) {
            if ("com.baidu.tieba.LogoActivity".equals(runningTaskInfo.baseActivity.getClassName()) && "com.baidu.tieba.LogoActivity".equals(runningTaskInfo.topActivity.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean ix(boolean z) {
        Message message;
        Object valueForField;
        Intent intent;
        ComponentName component;
        Object valueForField2 = com.baidu.adp.lib.OrmObject.a.a.getValueForField(Looper.myQueue(), "mMessages");
        if (valueForField2 != null && (valueForField2 instanceof Message)) {
            Message message2 = (Message) valueForField2;
            int i = 0;
            while (message2 != null && message2.obj != null && i < 10) {
                int i2 = i + 1;
                Object obj = message2.obj;
                if (obj != null && (valueForField = com.baidu.adp.lib.OrmObject.a.a.getValueForField(obj, "intent")) != null && (valueForField instanceof Intent) && (component = (intent = (Intent) valueForField).getComponent()) != null) {
                    try {
                        Class.forName(component.getClassName());
                    } catch (Throwable th) {
                        TiebaStatic.log(new an("check_change_intent_tologo").dh("obj_param1", (i2 == 1) + "").dh(TiebaInitialize.Params.OBJ_PARAM2, component.getClassName()));
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
                message2 = message;
                i = i2;
            }
        }
        return true;
    }
}
