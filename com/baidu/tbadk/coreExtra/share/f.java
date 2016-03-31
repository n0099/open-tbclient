package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String and = m.yB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String ana;
    public String anb;
    public boolean amV = false;
    public boolean amW = false;
    public boolean amX = false;
    public boolean amY = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> anc = null;
    public String amZ = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.anc == null || (bitmap = this.anc.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void f(Bitmap bitmap) {
        this.anc = new WeakReference<>(bitmap);
    }
}
