package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String akN = n.ya + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String akK;
    public String akL;
    public boolean akG = false;
    public boolean akH = false;
    public boolean akI = false;
    public boolean isFromPhotoLive = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> akM = null;
    public String akJ = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.akM == null || (bitmap = this.akM.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void j(Bitmap bitmap) {
        this.akM = new WeakReference<>(bitmap);
    }
}
