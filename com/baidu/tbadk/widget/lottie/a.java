package com.baidu.tbadk.widget.lottie;

import android.graphics.Bitmap;
import com.airbnb.lottie.c;
import com.airbnb.lottie.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.d.m;
/* loaded from: classes.dex */
public class a implements c {
    public static final String cJb = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m cJc;
    private boolean cJd = false;
    private String wV;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ap.isEmpty(this.wV)) {
            return null;
        }
        String str = this.wV + gVar.bQ().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.iv().b(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.cJc == null) {
                this.cJc = new m();
            }
            aVar = this.cJc.n(str, 0, 0);
        }
        if (aVar != null && aVar.ns() != null) {
            Bitmap ns = aVar.ns();
            try {
                return ns.copy(ns.getConfig(), false);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e);
            }
        }
        com.baidu.adp.lib.f.c.iv().a(str, 36, null, null);
        return null;
    }

    public void setPath(String str) {
        this.wV = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return cJb + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.cJd = z;
    }

    public boolean getFristLoadInternal() {
        return this.cJd;
    }
}
