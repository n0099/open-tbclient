package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import java.io.File;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tbadk.coreExtra.d.b aCv = new com.baidu.tbadk.coreExtra.d.b();

    public Bitmap aq(Context context) {
        Bitmap bitmap = null;
        String xF = this.aCv.xF();
        if (!StringUtils.isNull(xF)) {
            try {
                File cJ = com.baidu.tbadk.core.util.n.cJ(au.dn(xF));
                if (cJ == null) {
                    this.aCv.xG();
                } else {
                    bitmap = BitmapFactory.decodeFile(cJ.getAbsolutePath());
                    if (bitmap == null) {
                        this.aCv.xG();
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return bitmap;
    }
}
