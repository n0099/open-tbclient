package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String alT = n.yc + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String alQ;
    public String alR;
    public boolean alM = false;
    public boolean alN = false;
    public boolean alO = false;
    public boolean isFromPhotoLive = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> alS = null;
    public String alP = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.alS == null || (bitmap = this.alS.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.alS = new WeakReference<>(bitmap);
    }
}
