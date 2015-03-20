package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.MotuPlugin;
/* loaded from: classes.dex */
public class a extends b {
    private String als = "";

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "filter";
    }

    public static ImageOperation et(String str) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "filter";
        imageOperation.actionParam = str;
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void eu(String str) {
        if (str != null) {
            this.als = str;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [95=4, 96=4] */
    /* JADX DEBUG: Incorrect finally slice size: {[IF, INVOKE, INVOKE, MOVE, IF] complete}, expected: {[IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.img.effect.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap b(Bitmap bitmap, boolean z) {
        Bitmap bitmap2;
        Bitmap bitmap3 = null;
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.zs().dE(com.baidu.tbadk.core.util.c.d(bitmap) * 2);
        if (WriteImageActivityConfig.FILTER_NAME_NORMAL.equals(this.als)) {
            return bitmap;
        }
        MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
        if (bitmap.isMutable()) {
            if (motuPlugin != null) {
                try {
                    bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.m411getInst().getApp(), this.als, bitmap);
                } catch (Throwable th) {
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_LOAD_BITMAP, "motou filter failed: " + th.toString(), "");
                    if (BdLog.isDebugMode()) {
                        th.printStackTrace();
                        bitmap2 = null;
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
            bitmap2 = null;
            if (bitmap2 != null) {
            }
        } else {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = TbConfig.BitmapConfig;
            }
            Bitmap copy = bitmap.copy(config, true);
            if (copy != null && motuPlugin != null) {
                try {
                    try {
                        bitmap3 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.m411getInst().getApp(), this.als, copy);
                    } catch (IllegalStateException e) {
                        BdLog.e(e.toString());
                        if (copy != null && copy != null) {
                            copy.recycle();
                            bitmap2 = null;
                        }
                    }
                } catch (Throwable th2) {
                    if (copy != null && copy != null) {
                        copy.recycle();
                    }
                    throw th2;
                }
            }
            if (copy == null || bitmap3 == copy) {
                bitmap2 = bitmap3;
            } else {
                copy.recycle();
                bitmap2 = bitmap3;
            }
            if (bitmap2 != null) {
            }
        }
    }
}
