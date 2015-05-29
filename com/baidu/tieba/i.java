package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tbadk.coreExtra.c.c avl = new com.baidu.tbadk.coreExtra.c.c();

    public Bitmap ar(Context context) {
        String wB = this.avl.wB();
        Bitmap bitmap = null;
        if (!StringUtils.isNull(wB)) {
            try {
                bitmap = BitmapFactory.decodeFile(com.baidu.tbadk.core.util.o.cB(bd.db(wB)).getAbsolutePath());
                if (bitmap == null) {
                    this.avl.wC();
                }
            } catch (Throwable th) {
            }
        }
        return bitmap;
    }
}
