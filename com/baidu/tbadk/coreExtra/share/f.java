package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class f {
    public static final String f = w.a + "/" + n.f() + "/share/SHARED_IMAGE";
    public String a = null;
    public String b = null;
    public String c = null;
    public Uri d = null;
    public Location e = null;
    private WeakReference<Bitmap> g = null;

    public final Bitmap a() {
        Bitmap bitmap;
        if (this.g == null || (bitmap = this.g.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public final void a(Bitmap bitmap) {
        this.g = new WeakReference<>(bitmap);
    }
}
