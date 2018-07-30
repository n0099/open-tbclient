package com.baidu.tbadk.widget.lottie;

import android.graphics.Bitmap;
import com.airbnb.lottie.c;
import com.airbnb.lottie.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
/* loaded from: classes.dex */
public class a implements c {
    private String wf;

    @Override // com.airbnb.lottie.c
    public Bitmap a(g gVar) {
        if (ap.isEmpty(this.wf)) {
            return null;
        }
        String str = this.wf + gVar.bz() + "/" + gVar.getFileName();
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.ih().a(str, 36, new Object[0]);
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
        this.wf = l.ym() + str + "/";
    }
}
