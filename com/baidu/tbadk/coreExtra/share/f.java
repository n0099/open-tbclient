package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.o;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String ads = o.yl + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String adp;
    public String adq;
    public boolean adl = false;
    public String title = null;
    public String content = null;
    public String adm = null;
    public Uri adn = null;
    public Location ado = null;
    private WeakReference<Bitmap> adr = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.adr == null || (bitmap = this.adr.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.adr = new WeakReference<>(bitmap);
    }
}
