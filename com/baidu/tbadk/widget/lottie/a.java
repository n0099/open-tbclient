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
    public static final String blg = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m blh;
    private boolean bli = false;
    private String mPath;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ao.isEmpty(this.mPath)) {
            return null;
        }
        String str = this.mPath + gVar.cY().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jC().a(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.blh == null) {
                this.blh = new m();
            }
            aVar = this.blh.m(str, 0, 0);
        }
        if (aVar != null && aVar.os() != null) {
            Bitmap os = aVar.os();
            try {
                return os.copy(os.getConfig(), false);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e);
            }
        }
        com.baidu.adp.lib.f.c.jC().a(str, 36, null, null);
        return null;
    }

    public void setPath(String str) {
        this.mPath = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return blg + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.bli = z;
    }

    public boolean getFristLoadInternal() {
        return this.bli;
    }
}
