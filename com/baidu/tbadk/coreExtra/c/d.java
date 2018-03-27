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
    public static final String blD = k.alY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public int aQu;
    private Bundle blB;
    public String blp;
    public String blu;
    public String blv;
    public int bly;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean blh = false;
    public boolean bli = false;
    public boolean blj = false;
    public boolean blk = false;
    public boolean bll = false;
    public boolean blm = false;
    public boolean bln = false;
    public String blo = "";
    public int blw = 0;
    public int blx = 3;
    public boolean blz = false;
    public boolean blC = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String blq = null;
    public Uri blr = null;
    public Location bls = null;
    private WeakReference<Bitmap> blA = null;
    public String blt = null;
    public String extData = null;

    public Bundle IX() {
        return this.blB;
    }

    public void i(Bundle bundle) {
        this.blB = bundle;
    }

    public Bitmap IY() {
        Bitmap bitmap;
        if (this.blA == null || (bitmap = this.blA.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.blA = new WeakReference<>(bitmap);
    }
}
