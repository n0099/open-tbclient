package com.baidu.tieba.barcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.util.bd;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ReaderException;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.util.Map;
/* loaded from: classes.dex */
final class m extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final CaptureActivity f1153a;
    private boolean c = true;
    private final com.google.zxing.d b = new com.google.zxing.d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(CaptureActivity captureActivity, Map<DecodeHintType, Object> map) {
        this.b.a(map);
        this.f1153a = captureActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.c) {
            switch (message.what) {
                case R.id.decode /* 2131099699 */:
                    a((byte[]) message.obj, message.arg1, message.arg2);
                    return;
                case R.id.quit /* 2131099703 */:
                    this.c = false;
                    Looper.myLooper().quit();
                    return;
                default:
                    return;
            }
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        com.google.zxing.h hVar = null;
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        com.google.zxing.e a2 = this.f1153a.c().a(bArr2, i2, i);
        if (a2 != null) {
            try {
                hVar = this.b.a(new com.google.zxing.b(new com.google.zxing.common.h(a2)));
            } catch (ReaderException e) {
            } finally {
                this.b.a();
            }
        }
        Handler b = this.f1153a.b();
        if (hVar != null) {
            bd.e(getClass().getName(), "decode", "Found barcode in " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (b != null) {
                Message obtain = Message.obtain(b, R.id.decode_succeeded, hVar);
                Bundle bundle = new Bundle();
                a(a2, bundle);
                obtain.setData(bundle);
                obtain.sendToTarget();
            }
        } else if (b != null) {
            Message.obtain(b, (int) R.id.decode_failed).sendToTarget();
        }
    }

    private static void a(com.google.zxing.e eVar, Bundle bundle) {
        int[] d = eVar.d();
        int e = eVar.e();
        Bitmap createBitmap = Bitmap.createBitmap(d, 0, e, e, eVar.f(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", e / eVar.b());
    }
}
