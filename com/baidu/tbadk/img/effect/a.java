package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.MotuPlugin;
/* loaded from: classes.dex */
public class a extends b {
    private String bdb = "";

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "filter";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.bdb = str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [96=4, 97=4] */
    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        Bitmap createOneKeyFilterAndApply;
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Nu().ga(BitmapHelper.getBitmapSize(bitmap) * 2);
        if ("normal".equals(this.bdb)) {
            return bitmap;
        }
        MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
        if (bitmap.isMutable()) {
            if (motuPlugin != null) {
                try {
                    createOneKeyFilterAndApply = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst().getApp(), this.bdb, bitmap);
                } catch (Throwable th) {
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_LOAD_BITMAP, "motou filter failed: " + th.toString(), "");
                    if (BdLog.isDebugMode()) {
                        th.printStackTrace();
                    }
                }
            } else {
                createOneKeyFilterAndApply = null;
            }
            bitmap2 = createOneKeyFilterAndApply;
        } else {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = TbConfig.BitmapConfig;
            }
            Bitmap copy = bitmap.copy(config, true);
            if (copy != null) {
                try {
                    if (motuPlugin != null) {
                        try {
                            bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst(), this.bdb, copy);
                        } catch (IllegalStateException e) {
                            BdLog.e(e.toString());
                            e.printStackTrace();
                            if (copy != null && copy != null) {
                                copy.recycle();
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.toString());
                            th2.printStackTrace();
                            if (copy != null && copy != null) {
                                copy.recycle();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    if (copy != null && copy != null) {
                        copy.recycle();
                    }
                    throw th3;
                }
            }
            if (copy != null && bitmap2 != copy) {
                copy.recycle();
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
