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
    public static final String bpp = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m bpq;
    private boolean bpr = false;
    private String mPath;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ao.isEmpty(this.mPath)) {
            return null;
        }
        String str = this.mPath + gVar.cX().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jA().a(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.bpq == null) {
                this.bpq = new m();
            }
            aVar = this.bpq.o(str, 0, 0);
        }
        if (aVar != null && aVar.op() != null) {
            Bitmap op = aVar.op();
            try {
                return op.copy(op.getConfig(), false);
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
        return bpp + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.bpr = z;
    }

    public boolean getFristLoadInternal() {
        return this.bpr;
    }
}
