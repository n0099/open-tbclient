package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String amM = m.yk + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String amJ;
    public String amK;
    public boolean amE = false;
    public boolean amF = false;
    public boolean amG = false;
    public boolean amH = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> amL = null;
    public String amI = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.amL == null || (bitmap = this.amL.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.amL = new WeakReference<>(bitmap);
    }
}
