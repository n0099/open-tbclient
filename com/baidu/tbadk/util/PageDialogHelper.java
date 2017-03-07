package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PageDialogHelper {

    /* loaded from: classes.dex */
    public enum PayForm {
        NOT_SET,
        DIALOG,
        NORMAL;

        /* JADX DEBUG: Replace access to removed values field (aIR) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PayForm[] valuesCustom() {
            PayForm[] valuesCustom = values();
            int length = valuesCustom.length;
            PayForm[] payFormArr = new PayForm[length];
            System.arraycopy(valuesCustom, 0, payFormArr, 0, length);
            return payFormArr;
        }
    }

    public static boolean a(Activity activity, Intent intent, int i, String str) {
        boolean z;
        PayForm payForm = (PayForm) intent.getSerializableExtra(BuyTBeanActivityConfig.PAY_FORM);
        if (payForm == null) {
            payForm = PayForm.NOT_SET;
        }
        if (payForm == PayForm.NOT_SET) {
            com.baidu.tbadk.coreExtra.data.k consumePathData = TbadkCoreApplication.m9getInst().getConsumePathData();
            int intExtra = intent.getIntExtra("pay_type", i);
            if (consumePathData != null) {
                z = consumePathData.i(intExtra, str);
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
            activity.setTheme(w.m.swipeback_activity_style);
        }
        return z;
    }

    public static void s(Activity activity) {
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
