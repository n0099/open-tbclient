package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.MotuPlugin;
/* loaded from: classes.dex */
public class a extends b {
    private String a = "";

    @Override // com.baidu.tbadk.img.effect.b
    public String a() {
        return "filter";
    }

    public static ImageOperation a(String str) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "filter";
        imageOperation.actionParam = str;
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void b(String str) {
        if (str != null) {
            this.a = str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [104=4, 105=4] */
    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap a(Bitmap bitmap, boolean z) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().c(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
        if ("normal".equals(this.a)) {
            return bitmap;
        }
        com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("motu");
        MotuPlugin motuPlugin = a != null ? (MotuPlugin) a.a(MotuPlugin.class) : null;
        if (!bitmap.isMutable()) {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = TbConfig.BitmapConfig;
            }
            Bitmap copy = bitmap.copy(config, true);
            if (copy != null && motuPlugin != null) {
                try {
                    try {
                        bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkApplication.m252getInst().getApp(), this.a, copy);
                    } catch (IllegalStateException e) {
                        BdLog.e(e.toString());
                        if (copy != null && copy != null) {
                            copy.recycle();
                        }
                    }
                } catch (Throwable th) {
                    if (copy != null && copy != null) {
                        copy.recycle();
                    }
                    throw th;
                }
            }
            if (copy != null && bitmap2 != copy) {
                copy.recycle();
            }
        } else if (motuPlugin != null) {
            try {
                bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkApplication.m252getInst().getApp(), this.a, bitmap);
            } catch (Throwable th2) {
                TiebaStatic.imgError("", TbErrInfo.ERR_IMG_LOAD_BITMAP, "motou filter failed: " + th2.toString(), "");
                if (BdLog.isDebugMode()) {
                    th2.printStackTrace();
                }
            }
        }
        if (bitmap2 != null) {
            if (z && bitmap2 != bitmap) {
                bitmap.recycle();
            }
            return bitmap2;
        }
        return bitmap;
    }
}
