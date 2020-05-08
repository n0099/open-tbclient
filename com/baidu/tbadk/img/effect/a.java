package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.MotuPlugin;
/* loaded from: classes.dex */
public class a extends b {
    private String filterLabel = "";

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return FilterImageAction.ACTION_NAME;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.filterLabel = str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [96=4, 97=4] */
    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap processImage(Bitmap bitmap, boolean z) throws Exception {
        Bitmap createOneKeyFilterAndApply;
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.aYk().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
        if ("normal".equals(this.filterLabel)) {
            return bitmap;
        }
        MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
        if (bitmap.isMutable()) {
            if (motuPlugin != null) {
                try {
                    createOneKeyFilterAndApply = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst().getApp(), this.filterLabel, bitmap);
                } catch (Throwable th) {
                    TiebaStatic.imgError(-1008, "motou filter failed: " + th.toString(), "");
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
                            bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst(), this.filterLabel, copy);
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
