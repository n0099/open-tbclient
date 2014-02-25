package com.baidu.tieba.barcode.a;

import android.hardware.Camera;
import java.util.Comparator;
/* loaded from: classes.dex */
class d implements Comparator<Camera.Size> {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Camera.Size size, Camera.Size size2) {
        int i = size.height * size.width;
        int i2 = size2.height * size2.width;
        if (i2 < i) {
            return -1;
        }
        if (i2 > i) {
            return 1;
        }
        return 0;
    }
}
