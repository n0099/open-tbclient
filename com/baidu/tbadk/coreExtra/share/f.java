package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String anr = m.rB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String ano;
    public String anp;
    public boolean ani = false;
    public boolean anj = false;
    public boolean ank = false;
    public boolean anl = false;
    public boolean anm = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> anq = null;
    public String ann = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.anq == null || (bitmap = this.anq.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.anq = new WeakReference<>(bitmap);
    }
}
