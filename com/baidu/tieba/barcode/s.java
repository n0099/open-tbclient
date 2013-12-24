package com.baidu.tieba.barcode;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
/* loaded from: classes.dex */
final class s implements ResultPointCallback {
    private final ViewfinderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ViewfinderView viewfinderView) {
        this.a = viewfinderView;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.a.a(resultPoint);
    }
}
