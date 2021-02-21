package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes11.dex */
public class e {
    private static File gsl = null;

    public static File bPr() {
        if (gsl == null) {
            gsl = getPrivateCaptureRootChildDir("duMakeup");
        }
        return gsl;
    }

    public static File getPrivateCaptureRootChildDir(String str) {
        String str2 = TbadkCoreApplication.getInst().getContext().getFilesDir().getAbsoluteFile() + File.separator + "live_ar" + File.separator;
        return TextUtils.isEmpty(str) ? new File(str2) : new File(str2, str);
    }
}
