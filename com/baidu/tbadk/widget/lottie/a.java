package com.baidu.tbadk.widget.lottie;

import android.graphics.Bitmap;
import com.airbnb.lottie.c;
import com.airbnb.lottie.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.c.m;
/* loaded from: classes.dex */
public class a implements c {
    public static final String INTERNEL_STORAGE_DIRECTORY = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m dMZ;
    private boolean isFirstLoadInternal = false;
    private String mPath;

    @Override // com.airbnb.lottie.c
    public Bitmap fetchBitmap(h hVar) {
        if (aq.isEmpty(this.mPath)) {
            return null;
        }
        String str = this.mPath + hVar.bx().replace("/", "") + "/" + hVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.gr().loadResourceFromMemery(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.dMZ == null) {
                this.dMZ = new m();
            }
            aVar = this.dMZ.n(str, 0, 0);
        }
        if (aVar != null && aVar.getRawBitmap() != null) {
            Bitmap rawBitmap = aVar.getRawBitmap();
            try {
                return rawBitmap.copy(rawBitmap.getConfig(), false);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e);
            }
        }
        com.baidu.adp.lib.e.c.gr().a(str, 36, null, null);
        return null;
    }

    public void setPath(String str) {
        this.mPath = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return INTERNEL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.isFirstLoadInternal = z;
    }

    public boolean getFristLoadInternal() {
        return this.isFirstLoadInternal;
    }
}
