package com.baidu.tieba.barcode.a;

import android.hardware.Camera;
import java.util.Comparator;
/* loaded from: classes.dex */
final class d implements Comparator<Camera.Size> {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
        Camera.Size size3 = size;
        Camera.Size size4 = size2;
        int i = size3.height * size3.width;
        int i2 = size4.height * size4.width;
        if (i2 < i) {
            return -1;
        }
        return i2 > i ? 1 : 0;
    }
}
