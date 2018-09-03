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
    public static final String bdw = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m bdx;
    private boolean bdy = false;
    private String wg;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ap.isEmpty(this.wg)) {
            return null;
        }
        String str = this.wg + gVar.bz().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.ih().a(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.bdx == null) {
                this.bdx = new m();
            }
            aVar = this.bdx.fh(str);
        }
        if (aVar != null && aVar.nb() != null) {
            Bitmap nb = aVar.nb();
            try {
                return nb.copy(nb.getConfig(), false);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e);
            }
        }
        com.baidu.adp.lib.f.c.ih().a(str, 36, null, null);
        return null;
    }

    public void setPath(String str) {
        this.wg = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return bdw + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.bdy = z;
    }

    public boolean getFristLoadInternal() {
        return this.bdy;
    }
}
