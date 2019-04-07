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
    public static final String cAS = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m cAT;
    private boolean cAU = false;
    private String mPath;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ap.isEmpty(this.mPath)) {
            return null;
        }
        String str = this.mPath + gVar.cW().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jB().a(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.cAT == null) {
                this.cAT = new m();
            }
            aVar = this.cAT.n(str, 0, 0);
        }
        if (aVar != null && aVar.oy() != null) {
            Bitmap oy = aVar.oy();
            try {
                return oy.copy(oy.getConfig(), false);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e);
            }
        }
        com.baidu.adp.lib.f.c.jB().a(str, 36, null, null);
        return null;
    }

    public void setPath(String str) {
        this.mPath = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return cAS + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.cAU = z;
    }

    public boolean getFristLoadInternal() {
        return this.cAU;
    }
}
