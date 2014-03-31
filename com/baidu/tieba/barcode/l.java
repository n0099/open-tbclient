package com.baidu.tieba.barcode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.io.ByteArrayOutputStream;
import java.util.Map;
/* loaded from: classes.dex */
final class l extends Handler {
    private final CaptureActivity a;
    private boolean c = true;
    private final MultiFormatReader b = new MultiFormatReader();

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(CaptureActivity captureActivity, Map<DecodeHintType, Object> map) {
        this.b.setHints(map);
        this.a = captureActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Result result;
        if (this.c) {
            if (message.what == com.baidu.tieba.a.h.decode) {
                byte[] bArr = (byte[]) message.obj;
                int i = message.arg1;
                int i2 = message.arg2;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr2 = new byte[bArr.length];
                for (int i3 = 0; i3 < i2; i3++) {
                    for (int i4 = 0; i4 < i; i4++) {
                        bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
                    }
                }
                Rect f = this.a.c().f();
                PlanarYUVLuminanceSource planarYUVLuminanceSource = f == null ? null : new PlanarYUVLuminanceSource(bArr2, i2, i, f.left, f.top, f.width(), f.height(), false);
                if (planarYUVLuminanceSource != null) {
                    try {
                        result = this.b.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
                        this.b.reset();
                    } catch (ReaderException e) {
                        this.b.reset();
                        result = null;
                    } catch (Throwable th) {
                        this.b.reset();
                        throw th;
                    }
                } else {
                    result = null;
                }
                Handler b = this.a.b();
                if (result == null) {
                    if (b != null) {
                        Message.obtain(b, com.baidu.tieba.a.h.decode_failed).sendToTarget();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.f.e(getClass().getName(), "decode", "Found barcode in " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                if (b != null) {
                    Message obtain = Message.obtain(b, com.baidu.tieba.a.h.decode_succeeded, result);
                    Bundle bundle = new Bundle();
                    int[] renderThumbnail = planarYUVLuminanceSource.renderThumbnail();
                    int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
                    Bitmap createBitmap = Bitmap.createBitmap(renderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Bitmap.Config.ARGB_8888);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                    bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
                    bundle.putFloat("barcode_scaled_factor", thumbnailWidth / planarYUVLuminanceSource.getWidth());
                    obtain.setData(bundle);
                    obtain.sendToTarget();
                }
            } else if (message.what == com.baidu.tieba.a.h.quit) {
                this.c = false;
                Looper.myLooper().quit();
            }
        }
    }
}
