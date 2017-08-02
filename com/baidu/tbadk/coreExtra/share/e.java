package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    public static final String atX = k.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String atS;
    public String atT;
    public String fid;
    public boolean atJ = false;
    public boolean atK = false;
    public boolean atL = false;
    public boolean atM = false;
    public boolean atN = false;
    public boolean atO = false;
    public String atP = "";
    public int atU = 0;
    public int atV = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String atQ = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> atW = null;
    public String atR = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.atW == null || (bitmap = this.atW.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.atW = new WeakReference<>(bitmap);
    }
}
