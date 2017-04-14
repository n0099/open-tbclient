package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    public static final String asm = l.yq + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String asj;
    public String ask;
    public boolean asc = false;
    public boolean asd = false;
    public boolean ase = false;
    public boolean asf = false;
    public boolean asg = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String ash = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> asl = null;
    public String asi = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.asl == null || (bitmap = this.asl.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.asl = new WeakReference<>(bitmap);
    }
}
