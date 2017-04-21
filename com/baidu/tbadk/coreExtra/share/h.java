package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h {
    public static final String aso = l.yt + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String asl;
    public String asm;
    public boolean ase = false;
    public boolean asf = false;
    public boolean asg = false;
    public boolean ash = false;
    public boolean asi = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String asj = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> asn = null;
    public String ask = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.asn == null || (bitmap = this.asn.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.asn = new WeakReference<>(bitmap);
    }
}
