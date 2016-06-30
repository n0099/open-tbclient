package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String ajx = m.oH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String aju;
    public String ajv;
    public boolean ajo = false;
    public boolean ajp = false;
    public boolean ajq = false;
    public boolean ajr = false;
    public boolean ajs = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> ajw = null;
    public String ajt = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.ajw == null || (bitmap = this.ajw.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void e(Bitmap bitmap) {
        this.ajw = new WeakReference<>(bitmap);
    }
}
