package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static final String anu = m.rC + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public String ans;
    public String shareAbstract;
    public boolean anm = false;
    public boolean ann = false;
    public boolean ano = false;
    public boolean anp = false;
    public boolean anq = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> ant = null;
    public String anr = null;
    public String extData = null;

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.ant == null || (bitmap = this.ant.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void i(Bitmap bitmap) {
        this.ant = new WeakReference<>(bitmap);
    }
}
