package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class g extends b {
    public String cnx = "";

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
        com.baidu.tbadk.imageManager.c.anm().jL(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.loadResizedBitmap(this.cnx, l.aO(TbadkCoreApplication.getInst()), l.aQ(TbadkCoreApplication.getInst()));
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap po(String str) throws Exception {
        return b(BitmapHelper.loadResizedBitmap(str, l.aO(TbadkCoreApplication.getInst()), l.aQ(TbadkCoreApplication.getInst())), true);
    }

    public void setPath(String str) {
        this.cnx = str;
    }
}
