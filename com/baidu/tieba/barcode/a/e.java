package com.baidu.tieba.barcode.a;

import android.hardware.Camera;
import java.util.Comparator;
/* loaded from: classes.dex */
class e implements Comparator<Camera.Size> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1138a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f1138a = dVar;
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
