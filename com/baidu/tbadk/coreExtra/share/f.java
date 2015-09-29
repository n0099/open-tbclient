package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String aiT = n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String aiQ;
    public String aiR;
    public boolean aiM = false;
    public boolean aiN = false;
    public boolean aiO = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> aiS = null;
    public String aiP = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.aiS == null || (bitmap = this.aiS.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.aiS = new WeakReference<>(bitmap);
    }
}
