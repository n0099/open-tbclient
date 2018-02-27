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
    public static final String blA = k.alY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public int aQs;
    public String blm;
    public String blr;
    public String bls;
    public int blv;
    private Bundle bly;
    public String fid;
    public OriginalThreadInfo originalThreadInfo;
    public String price;
    public String tid;
    public String uid;
    public boolean ble = false;
    public boolean blf = false;
    public boolean blg = false;
    public boolean blh = false;
    public boolean bli = false;
    public boolean blj = false;
    public boolean blk = false;
    public String bll = "";
    public int blt = 0;
    public int blu = 3;
    public boolean blw = false;
    public boolean blz = true;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String bln = null;
    public Uri blo = null;
    public Location blp = null;
    private WeakReference<Bitmap> blx = null;
    public String blq = null;
    public String extData = null;

    public Bundle IW() {
        return this.bly;
    }

    public void i(Bundle bundle) {
        this.bly = bundle;
    }

    public Bitmap IX() {
        Bitmap bitmap;
        if (this.blx == null || (bitmap = this.blx.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.blx = new WeakReference<>(bitmap);
    }
}
