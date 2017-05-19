package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h {
    public static final String ass = l.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String asn;
    public String aso;
    public boolean asg = false;
    public boolean ash = false;
    public boolean asi = false;
    public boolean asj = false;
    public boolean ask = false;
    public int asp = 0;
    public int asq = 3;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String asl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> asr = null;
    public String asm = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.asr == null || (bitmap = this.asr.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void h(Bitmap bitmap) {
        this.asr = new WeakReference<>(bitmap);
    }
}
