package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h {
    public static final String f = s.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String a = null;
    public String b = null;
    public String c = null;
    public Uri d = null;
    public Location e = null;
    private WeakReference<Bitmap> g = null;

    public Bitmap a() {
        Bitmap bitmap;
        if (this.g == null || (bitmap = this.g.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void a(Bitmap bitmap) {
        this.g = new WeakReference<>(bitmap);
    }
}
