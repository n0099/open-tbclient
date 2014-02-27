package com.baidu.tieba.im.chat;

import android.content.Context;
import com.baidu.adp.lib.util.BdUtilHelper;
import java.io.Serializable;
/* loaded from: classes.dex */
public final class LocalViewSize {
    private static LocalViewSize a = null;
    private Context b = null;

    public final void a(com.baidu.tieba.img.a<?> aVar) {
        ImageSize c = c();
        ImageSize d = d();
        aVar.a(d.width, d.height, c.width, c.height);
    }

    public static LocalViewSize a() {
        if (a == null) {
            a = new LocalViewSize();
        }
        return a;
    }

    private LocalViewSize() {
    }

    public final void a(Context context) {
        this.b = context;
    }

    /* loaded from: classes.dex */
    public class ImageSize implements Serializable {
        public int height;
        public int width;

        public ImageSize() {
        }
    }

    public final ImageSize a(ImageSize imageSize, int i, int i2) {
        if (i <= imageSize.height && i2 <= imageSize.width) {
            ImageSize imageSize2 = new ImageSize();
            imageSize2.height = i;
            imageSize2.width = i2;
            return imageSize2;
        }
        ImageSize imageSize3 = new ImageSize();
        if (i / i2 > imageSize.height / imageSize.width) {
            imageSize3.height = imageSize.height;
            imageSize3.width = (imageSize3.height * i2) / i;
            return imageSize3;
        }
        imageSize3.width = imageSize.width;
        imageSize3.height = (imageSize3.width * i) / i2;
        return imageSize3;
    }

    public final int b() {
        int b = BdUtilHelper.b(this.b);
        if (b >= 1080) {
            return 1080;
        }
        return (b < 720 || b >= 1080) ? 480 : 720;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r1 > 720) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ImageSize c() {
        int i = 240;
        int b = BdUtilHelper.b(this.b);
        com.baidu.adp.lib.util.e.d("=======getEquipmentWidth:" + b);
        if (b >= 240) {
            if (b <= 320) {
                i = 80;
            } else if (b <= 480) {
                i = 160;
            }
            ImageSize imageSize = new ImageSize();
            imageSize.height = i;
            imageSize.width = i;
            return imageSize;
        }
        i = b / 3;
        ImageSize imageSize2 = new ImageSize();
        imageSize2.height = i;
        imageSize2.width = i;
        return imageSize2;
    }

    public final ImageSize d() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = BdUtilHelper.c(this.b);
        imageSize.width = BdUtilHelper.b(this.b);
        return imageSize;
    }

    public final int e() {
        ImageSize c = c();
        return c.height >= c.width ? c.height : c.width;
    }
}
