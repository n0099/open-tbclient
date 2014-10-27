package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.MotuPlugin;
/* loaded from: classes.dex */
public class a extends b {
    private String Vl = "";

    @Override // com.baidu.tbadk.img.effect.b
    public String sp() {
        return "filter";
    }

    public static ImageOperation dv(String str) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "filter";
        imageOperation.actionParam = str;
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void dw(String str) {
        if (str != null) {
            this.Vl = str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [102=4, 103=4] */
    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.sg().cR(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
        if (WriteImageActivityConfig.FILTER_NAME_NORMAL.equals(this.Vl)) {
            return bitmap;
        }
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_MOTUSDK);
        MotuPlugin motuPlugin = pluginByName != null ? (MotuPlugin) pluginByName.getClassInstance(MotuPlugin.class) : null;
        if (!bitmap.isMutable()) {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = TbConfig.BitmapConfig;
            }
            Bitmap copy = bitmap.copy(config, true);
            if (copy != null) {
                try {
                    if (motuPlugin != null) {
                        try {
                            bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkApplication.m251getInst().getApp(), this.Vl, copy);
                        } catch (IllegalStateException e) {
                            BdLog.e(e.toString());
                            if (copy != null && copy != null) {
                                copy.recycle();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.toString());
                            if (copy != null && copy != null) {
                                copy.recycle();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    if (copy != null && copy != null) {
                        copy.recycle();
                    }
                    throw th2;
                }
            }
            if (copy != null && bitmap2 != copy) {
                copy.recycle();
            }
        } else if (motuPlugin != null) {
            try {
                bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkApplication.m251getInst().getApp(), this.Vl, bitmap);
            } catch (Throwable th3) {
                TiebaStatic.imgError("", TbErrInfo.ERR_IMG_LOAD_BITMAP, "motou filter failed: " + th3.toString(), "");
                if (BdLog.isDebugMode()) {
                    th3.printStackTrace();
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
