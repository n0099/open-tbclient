package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbplugin.k;
/* loaded from: classes.dex */
public class a extends b {
    private String a = "";

    @Override // com.baidu.tbadk.img.effect.b
    public final String a() {
        return "filter";
    }

    public static ImageOperation a(String str) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "filter";
        imageOperation.actionParam = str;
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public final void b(String str) {
        if (str != null) {
            this.a = str;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4, 99=4, 100=4] */
    /* JADX DEBUG: Incorrect finally slice size: {[IF, INVOKE, INVOKE, MOVE, IF] complete}, expected: {[IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.img.effect.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap a(Bitmap bitmap, boolean z) {
        Bitmap bitmap2;
        MotuPlugin motuPlugin;
        Bitmap bitmap3 = null;
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().b(g.a(bitmap) * 2);
        if ("normal".equals(this.a)) {
            return bitmap;
        }
        if (bitmap.isMutable()) {
            try {
                motuPlugin = (MotuPlugin) k.a().a(MotuPlugin.class);
            } catch (Throwable th) {
                com.baidu.adp.lib.util.f.b("motou filter failed." + th.toString());
                TiebaStatic.a("", -1008, "motou filter failed: " + th.toString(), "");
                if (com.baidu.adp.lib.util.f.a()) {
                    th.printStackTrace();
                    bitmap2 = null;
                }
            }
            if (motuPlugin != null) {
                bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkApplication.j().b(), this.a, bitmap);
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
                config = n.b;
            }
            Bitmap copy = bitmap.copy(config, true);
            if (copy != null) {
                try {
                    try {
                        MotuPlugin motuPlugin2 = (MotuPlugin) k.a().a(MotuPlugin.class);
                        if (motuPlugin2 != null) {
                            bitmap3 = motuPlugin2.createOneKeyFilterAndApply(TbadkApplication.j().b(), this.a, copy);
                        }
                    } catch (IllegalStateException e) {
                        com.baidu.adp.lib.util.f.b(e.toString());
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
            if (copy != null && bitmap3 != copy) {
                copy.recycle();
            }
            bitmap2 = bitmap3;
            if (bitmap2 != null) {
            }
        }
    }
}
