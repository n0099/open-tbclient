package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class g extends b {
    public String aHM = "";

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "sticker";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Fa().eX(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.loadResizedBitmap(this.aHM, l.af(TbadkCoreApplication.getInst()), l.ah(TbadkCoreApplication.getInst()));
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap gL(String str) throws Exception {
        return b(BitmapHelper.loadResizedBitmap(str, l.af(TbadkCoreApplication.getInst()), l.ah(TbadkCoreApplication.getInst())), true);
    }

    public void setPath(String str) {
        this.aHM = str;
    }
}
