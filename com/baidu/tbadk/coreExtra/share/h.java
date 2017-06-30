package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h {
    public static final String atf = n.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String ata;
    public String atb;
    public String fid;
    public boolean asS = false;
    public boolean asT = false;
    public boolean asU = false;
    public boolean asV = false;
    public boolean asW = false;
    public boolean asX = false;
    public int atc = 0;
    public int atd = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String asY = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> ate = null;
    public String asZ = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.ate == null || (bitmap = this.ate.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.ate = new WeakReference<>(bitmap);
    }
}
