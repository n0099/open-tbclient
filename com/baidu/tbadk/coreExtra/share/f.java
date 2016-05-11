package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String aiR = m.oH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String aiO;
    public String aiP;
    public boolean aiI = false;
    public boolean aiJ = false;
    public boolean aiK = false;
    public boolean aiL = false;
    public boolean aiM = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> aiQ = null;
    public String aiN = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.aiQ == null || (bitmap = this.aiQ.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.aiQ = new WeakReference<>(bitmap);
    }
}
