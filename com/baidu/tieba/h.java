package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import java.io.File;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tbadk.coreExtra.d.b aDq = new com.baidu.tbadk.coreExtra.d.b();

    public Bitmap aq(Context context) {
        Bitmap bitmap = null;
        String xD = this.aDq.xD();
        if (!StringUtils.isNull(xD)) {
            try {
                File cI = com.baidu.tbadk.core.util.n.cI(at.dm(xD));
                if (cI == null) {
                    this.aDq.xE();
                } else {
                    bitmap = BitmapFactory.decodeFile(cI.getAbsolutePath());
                    if (bitmap == null) {
                        this.aDq.xE();
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return bitmap;
    }
}
