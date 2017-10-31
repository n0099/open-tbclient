package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PageDialogHelper {

    /* loaded from: classes.dex */
    public enum PayForm {
        NOT_SET,
        DIALOG,
        NORMAL
    }

    public static boolean a(Activity activity, Intent intent, int i, String str) {
        boolean z;
        PayForm payForm = (PayForm) intent.getSerializableExtra(BuyTBeanActivityConfig.PAY_FORM);
        if (payForm == null) {
            payForm = PayForm.NOT_SET;
        }
        if (payForm == PayForm.NOT_SET) {
            com.baidu.tbadk.coreExtra.data.k consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
            int intExtra = intent.getIntExtra("pay_type", i);
            if (consumePathData != null) {
                z = consumePathData.j(intExtra, str);
            }
            z = true;
        } else if (payForm == PayForm.NORMAL) {
            z = false;
        } else {
            if (payForm == PayForm.DIALOG) {
                z = true;
            }
            z = true;
        }
        if (z) {
            activity.setTheme(16973835);
            activity.requestWindowFeature(1);
        } else {
            activity.setTheme(d.k.swipeback_activity_style);
        }
        return z;
    }

    public static void v(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        attributes.x = 0;
        attributes.height = displayMetrics.heightPixels - 400;
        attributes.width = -1;
        attributes.y = 0;
        attributes.gravity = 80;
        activity.getWindow().setAttributes(attributes);
        activity.setFinishOnTouchOutside(false);
    }
}
