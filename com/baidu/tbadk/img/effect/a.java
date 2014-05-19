package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.tbplugin.m;
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4, 99=4] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.img.effect.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap a(Bitmap bitmap, boolean z) {
        Bitmap bitmap2;
        MotuPlugin motuPlugin;
        Bitmap bitmap3 = null;
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().c(g.a(bitmap) * 2);
        if ("normal".equals(this.a)) {
            return bitmap;
        }
        if (bitmap.isMutable()) {
            try {
                motuPlugin = (MotuPlugin) m.a().b(MotuPlugin.class);
            } catch (Throwable th) {
                BdLog.e("motou filter failed." + th.toString());
                TiebaStatic.imgError("", TbErrInfo.ERR_IMG_LOAD_BITMAP, "motou filter failed: " + th.toString(), "");
                if (BdLog.isDebugMode()) {
                    th.printStackTrace();
                    bitmap2 = null;
                }
            }
            if (motuPlugin != null) {
                bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkApplication.m252getInst().getApp(), this.a, bitmap);
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
            try {
                if (copy != null) {
                    try {
                        MotuPlugin motuPlugin2 = (MotuPlugin) m.a().b(MotuPlugin.class);
                        if (motuPlugin2 != null) {
                            bitmap3 = motuPlugin2.createOneKeyFilterAndApply(TbadkApplication.m252getInst().getApp(), this.a, copy);
                        }
                    } catch (IllegalStateException e) {
                        BdLog.e(e.toString());
                        if (copy != null && copy != null) {
                            copy.recycle();
                            bitmap2 = null;
                        }
                    } catch (Throwable th2) {
                        BdLog.e(th2.toString());
                        if (copy != null && copy != null) {
                            copy.recycle();
                            bitmap2 = null;
                        }
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
            } catch (Throwable th3) {
                if (copy != null && copy != null) {
                    copy.recycle();
                }
                throw th3;
            }
        }
    }
}
