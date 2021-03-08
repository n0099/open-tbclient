package com.baidu.tbadk.widget.lottie;

import android.graphics.Bitmap;
import com.airbnb.lottie.g;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.d.j;
/* loaded from: classes.dex */
public class a implements com.airbnb.lottie.b {
    public static final String INTERNEL_STORAGE_DIRECTORY = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private j fWl;
    private boolean isFirstLoadInternal = false;
    private String mPath;

    @Override // com.airbnb.lottie.b
    public Bitmap a(g gVar) {
        if (au.isEmpty(this.mPath)) {
            return null;
        }
        String str = this.mPath + gVar.ik().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) d.mw().loadResourceFromMemery(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.fWl == null) {
                this.fWl = new j();
            }
            aVar = this.fWl.q(str, 0, 0);
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
        d.mw().a(str, 36, null, null);
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
