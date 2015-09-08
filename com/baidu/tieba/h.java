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
    private com.baidu.tbadk.coreExtra.c.b aEl = new com.baidu.tbadk.coreExtra.c.b();

    public Bitmap ar(Context context) {
        Bitmap bitmap = null;
        String xS = this.aEl.xS();
        if (!StringUtils.isNull(xS)) {
            try {
                File cI = com.baidu.tbadk.core.util.n.cI(as.di(xS));
                if (cI == null) {
                    this.aEl.xT();
                } else {
                    bitmap = BitmapFactory.decodeFile(cI.getAbsolutePath());
                    if (bitmap == null) {
                        this.aEl.xT();
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return bitmap;
    }
}
