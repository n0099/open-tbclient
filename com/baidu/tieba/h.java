package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import java.io.File;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tbadk.coreExtra.c.b aCD = new com.baidu.tbadk.coreExtra.c.b();

    public Bitmap as(Context context) {
        Bitmap bitmap = null;
        String xL = this.aCD.xL();
        if (!StringUtils.isNull(xL)) {
            try {
                File cC = com.baidu.tbadk.core.util.n.cC(as.dc(xL));
                if (cC == null) {
                    this.aCD.xM();
                } else {
                    bitmap = BitmapFactory.decodeFile(cC.getAbsolutePath());
                    if (bitmap == null) {
                        this.aCD.xM();
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return bitmap;
    }
}
