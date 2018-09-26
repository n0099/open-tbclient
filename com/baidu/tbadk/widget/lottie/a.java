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
    public static final String bgR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m bgS;
    private boolean bgT = false;
    private String yz;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ao.isEmpty(this.yz)) {
            return null;
        }
        String str = this.yz + gVar.cG().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jn().a(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.bgS == null) {
                this.bgS = new m();
            }
            aVar = this.bgS.m(str, 0, 0);
        }
        if (aVar != null && aVar.oh() != null) {
            Bitmap oh = aVar.oh();
            try {
                return oh.copy(oh.getConfig(), false);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e);
            }
        }
        com.baidu.adp.lib.f.c.jn().a(str, 36, null, null);
        return null;
    }

    public void setPath(String str) {
        this.yz = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return bgR + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.bgT = z;
    }

    public boolean getFristLoadInternal() {
        return this.bgT;
    }
}
