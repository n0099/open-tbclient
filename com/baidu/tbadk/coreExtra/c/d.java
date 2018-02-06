package com.baidu.tbadk.coreExtra.c;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    public static final String blN = k.ame + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public int aQD;
    public String blE;
    public String blF;
    public int blI;
    private Bundle blL;
    public String blz;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean blr = false;
    public boolean bls = false;
    public boolean blt = false;
    public boolean blu = false;
    public boolean blv = false;
    public boolean blw = false;
    public boolean blx = false;
    public String bly = "";
    public int blG = 0;
    public int blH = 3;
    public boolean blJ = false;
    public boolean blM = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String blA = null;
    public Uri blB = null;
    public Location blC = null;
    private WeakReference<Bitmap> blK = null;
    public String blD = null;
    public String extData = null;

    public Bundle IX() {
        return this.blL;
    }

    public void i(Bundle bundle) {
        this.blL = bundle;
    }

    public Bitmap IY() {
        Bitmap bitmap;
        if (this.blK == null || (bitmap = this.blK.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.blK = new WeakReference<>(bitmap);
    }
}
