package com.baidu.tieba.im.chat;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalViewSize {

    /* renamed from: a  reason: collision with root package name */
    private static LocalViewSize f1482a = null;
    private Context b = null;

    public static LocalViewSize a() {
        if (f1482a == null) {
            f1482a = new LocalViewSize();
        }
        return f1482a;
    }

    private LocalViewSize() {
    }

    public void a(Context context) {
        this.b = context;
    }

    /* loaded from: classes.dex */
    public class ImageSize implements Serializable {
        public int height;
        public int width;

        public ImageSize() {
        }
    }

    public ImageSize a(ImageSize imageSize, int i, int i2) {
        if (i > imageSize.height || i2 > imageSize.width) {
            return b(imageSize, i, i2);
        }
        ImageSize imageSize2 = new ImageSize();
        imageSize2.height = i;
        imageSize2.width = i2;
        return imageSize2;
    }

    private ImageSize b(ImageSize imageSize, int i, int i2) {
        ImageSize imageSize2 = new ImageSize();
        if (i / i2 > imageSize.height / imageSize.width) {
            imageSize2.height = imageSize.height;
            imageSize2.width = (imageSize2.height * i2) / i;
        } else {
            imageSize2.width = imageSize.width;
            imageSize2.height = (imageSize2.width * i) / i2;
        }
        return imageSize2;
    }

    public int b() {
        int a2 = com.baidu.adp.lib.h.f.a(this.b);
        if (a2 >= 1080) {
            return 1080;
        }
        return (a2 < 720 || a2 >= 1080) ? 480 : 720;
    }

    public ImageSize c() {
        int i = 240;
        int a2 = com.baidu.adp.lib.h.f.a(this.b);
        com.baidu.adp.lib.h.d.c("=======getEquipmentWidth:" + a2);
        if (a2 < 240) {
            i = a2 / 3;
        } else if (a2 <= 320) {
            i = 80;
        } else if (a2 <= 480) {
            i = 160;
        } else if (a2 > 720) {
            i = a2 / 3;
        }
        ImageSize imageSize = new ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public ImageSize d() {
        ImageSize imageSize = new ImageSize();
        imageSize.height = com.baidu.adp.lib.h.f.b(this.b);
        imageSize.width = com.baidu.adp.lib.h.f.a(this.b);
        return imageSize;
    }

    public int e() {
        ImageSize c = c();
        return c.height >= c.width ? c.height : c.width;
    }
}
