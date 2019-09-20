package com.baidu.tbadk.widget.lottie;

import android.graphics.Bitmap;
import com.airbnb.lottie.c;
import com.airbnb.lottie.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.e.m;
/* loaded from: classes.dex */
public class a implements c {
    public static final String cLt = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private m cLu;
    private boolean cLv = false;
    private String wX;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (aq.isEmpty(this.wX)) {
            return null;
        }
        String str = this.wX + gVar.bU().replace("/", "") + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.iE().b(str, 36, new Object[0]);
        if (aVar == null && getFristLoadInternal()) {
            if (this.cLu == null) {
                this.cLu = new m();
            }
            aVar = this.cLu.n(str, 0, 0);
        }
        if (aVar != null && aVar.nK() != null) {
            Bitmap nK = aVar.nK();
            try {
                return nK.copy(nK.getConfig(), false);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e);
            }
        }
        com.baidu.adp.lib.f.c.iE().a(str, 36, null, null);
        return null;
    }

    public void setPath(String str) {
        this.wX = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return cLt + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.cLv = z;
    }

    public boolean getFristLoadInternal() {
        return this.cLv;
    }
}
