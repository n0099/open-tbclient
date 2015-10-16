package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String aiU = n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String aiR;
    public String aiS;
    public boolean aiN = false;
    public boolean aiO = false;
    public boolean aiP = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> aiT = null;
    public String aiQ = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.aiT == null || (bitmap = this.aiT.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.aiT = new WeakReference<>(bitmap);
    }
}
