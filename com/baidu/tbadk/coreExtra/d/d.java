package com.baidu.tbadk.coreExtra.d;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    public static final String atR = k.xS + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String Xf;
    public int atE;
    public String atF;
    public String atK;
    public String atL;
    public int atO;
    private Bundle atQ;
    public String fid;
    public String uid;
    public boolean atw = false;
    public boolean atx = false;
    public boolean aty = false;
    public boolean atz = false;
    public boolean atA = false;
    public boolean atB = false;
    public boolean atC = false;
    public String atD = "";
    public int atM = 0;
    public int atN = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String atG = null;
    public Uri atH = null;
    public Location atI = null;
    private WeakReference<Bitmap> atP = null;
    public String atJ = null;
    public String extData = null;

    public Bundle Au() {
        return this.atQ;
    }

    public void e(Bundle bundle) {
        this.atQ = bundle;
    }

    public Bitmap Av() {
        Bitmap bitmap;
        if (this.atP == null || (bitmap = this.atP.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.atP = new WeakReference<>(bitmap);
    }
}
