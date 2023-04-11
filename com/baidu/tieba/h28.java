package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(final String str, final boolean z, int i, int i2, final boolean z2) {
        final boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            final Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (i == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            jg.a().post(new Runnable() { // from class: com.baidu.tieba.v18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        h28.b(currentActivity, z, z2, z3, str);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void b(Activity activity, boolean z, boolean z2, boolean z3, String str) {
        if (activity != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (z) {
                if (z2 && !z3 && dq4.d().b("share_thread")) {
                    return;
                }
                spannableStringBuilder.append((CharSequence) str);
            } else {
                spannableStringBuilder.append((CharSequence) str);
            }
            BdToast.b(TbadkCoreApplication.getInst().getContext(), spannableStringBuilder).o();
        }
    }
}
