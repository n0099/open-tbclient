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
    public static final String cJc = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m cJd;
    private boolean cJe = false;
    private String wU;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ap.isEmpty(this.wU)) {
            return null;
        }
        String str = this.wU + gVar.bQ().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.iv().b(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.cJd == null) {
                this.cJd = new m();
            }
            aVar = this.cJd.n(str, 0, 0);
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
        this.wU = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return cJc + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.cJe = z;
    }

    public boolean getFristLoadInternal() {
        return this.cJe;
    }
}
