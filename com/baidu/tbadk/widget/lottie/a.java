package com.baidu.tbadk.widget.lottie;

import android.graphics.Bitmap;
import com.airbnb.lottie.c;
import com.airbnb.lottie.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.d.m;
/* loaded from: classes.dex */
public class a implements c {
    public static final String bqg = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m bqh;
    private boolean bqi = false;
    private String mPath;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ao.isEmpty(this.mPath)) {
            return null;
        }
        String str = this.mPath + gVar.cX().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jA().a(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.bqh == null) {
                this.bqh = new m();
            }
            aVar = this.bqh.o(str, 0, 0);
        }
        if (aVar != null && aVar.ot() != null) {
            Bitmap ot = aVar.ot();
            try {
                return ot.copy(ot.getConfig(), false);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e);
            }
        }
        com.baidu.adp.lib.f.c.jA().a(str, 36, null, null);
        return null;
    }

    public void setPath(String str) {
        this.mPath = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return bqg + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.bqi = z;
    }

    public boolean getFristLoadInternal() {
        return this.bqi;
    }
}
