package com.baidu.tieba.barcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.v;
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
    public void handleMessage(Message message) {
        if (this.c) {
            if (message.what == v.decode) {
                a((byte[]) message.obj, message.arg1, message.arg2);
            } else if (message.what == v.quit) {
                this.c = false;
                Looper.myLooper().quit();
            }
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        System.currentTimeMillis();
        Result result = null;
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        PlanarYUVLuminanceSource a = this.a.c().a(bArr2, i2, i);
        if (a != null) {
            try {
                result = this.b.decodeWithState(new BinaryBitmap(new HybridBinarizer(a)));
            } catch (ReaderException e) {
            } finally {
                this.b.reset();
            }
        }
        Handler b = this.a.b();
        if (result != null) {
            System.currentTimeMillis();
            if (b != null) {
                Message obtain = Message.obtain(b, v.decode_succeeded, result);
                Bundle bundle = new Bundle();
                a(a, bundle);
                obtain.setData(bundle);
                obtain.sendToTarget();
            }
        } else if (b != null) {
            Message.obtain(b, v.decode_failed).sendToTarget();
        }
    }

    private static void a(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] renderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap createBitmap = Bitmap.createBitmap(renderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", thumbnailWidth / planarYUVLuminanceSource.getWidth());
    }
}
