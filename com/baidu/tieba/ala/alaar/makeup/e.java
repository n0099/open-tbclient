package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public class e {
    private static File gjw = null;

    public static File bPX() {
        if (gjw == null) {
            gjw = getPrivateCaptureRootChildDir("duMakeup");
        }
        return gjw;
    }

    public static File getPrivateCaptureRootChildDir(String str) {
        String str2 = TbadkCoreApplication.getInst().getContext().getFilesDir().getAbsoluteFile() + File.separator + "live_ar" + File.separator;
        return TextUtils.isEmpty(str) ? new File(str2) : new File(str2, str);
    }
}
