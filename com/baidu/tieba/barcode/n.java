package com.baidu.tieba.barcode;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tieba.util.bd;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final CaptureActivity f1154a;
    private Handler c;
    private final CountDownLatch d = new CountDownLatch(1);
    private final Map<DecodeHintType, Object> b = new EnumMap(DecodeHintType.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, com.google.zxing.j jVar) {
        this.f1154a = captureActivity;
        if (map != null) {
            this.b.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            collection = EnumSet.noneOf(BarcodeFormat.class);
            collection.addAll(l.f1152a);
        }
        this.b.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.b.put(DecodeHintType.CHARACTER_SET, str);
        }
        this.b.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, jVar);
        bd.a(getClass().getName(), "DecodeThread", "Hints: " + this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler a() {
        try {
            this.d.await();
        } catch (InterruptedException e) {
        }
        return this.c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.c = new m(this.f1154a, this.b);
        this.d.countDown();
        Looper.loop();
    }
}
