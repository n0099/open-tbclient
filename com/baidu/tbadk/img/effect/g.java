package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class g extends b {
    public String bvp = "";

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
        com.baidu.tbadk.imageManager.c.LR().ia(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.loadResizedBitmap(this.bvp, l.ao(TbadkCoreApplication.getInst()), l.aq(TbadkCoreApplication.getInst()));
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap gM(String str) throws Exception {
        return b(BitmapHelper.loadResizedBitmap(str, l.ao(TbadkCoreApplication.getInst()), l.aq(TbadkCoreApplication.getInst())), true);
    }

    public void setPath(String str) {
        this.bvp = str;
    }
}
