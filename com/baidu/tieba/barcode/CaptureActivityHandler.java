package com.baidu.tieba.barcode;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.tieba.u;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public final class CaptureActivityHandler extends Handler {
    private final CaptureActivity a;
    private final m b;
    private State c;
    private final com.baidu.tieba.barcode.a.e d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum State {
        PREVIEW,
        SUCCESS,
        DONE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CaptureActivityHandler(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, com.baidu.tieba.barcode.a.e eVar) {
        this.a = captureActivity;
        this.b = new m(captureActivity, collection, map, str, new q(captureActivity.a()));
        this.b.start();
        this.c = State.SUCCESS;
        this.d = eVar;
        eVar.c();
        b();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Bitmap bitmap;
        float f;
        if (message.what == u.restart_preview) {
            b();
        } else if (message.what == u.decode_succeeded) {
            this.c = State.SUCCESS;
            Bundle data = message.getData();
            if (data == null) {
                bitmap = null;
                f = 1.0f;
            } else {
                byte[] byteArray = data.getByteArray("barcode_bitmap");
                Bitmap copy = byteArray != null ? BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Bitmap.Config.ARGB_8888, true) : null;
                f = data.getFloat("barcode_scaled_factor");
                bitmap = copy;
            }
            this.a.a((Result) message.obj, bitmap, f);
        } else if (message.what == u.decode_failed) {
            this.c = State.PREVIEW;
            this.d.a(this.b.a(), u.decode);
        } else if (message.what == u.return_scan_result) {
            this.a.setResult(-1, (Intent) message.obj);
            this.a.finish();
        } else if (message.what == u.launch_product_query) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            intent.setData(Uri.parse((String) message.obj));
            ResolveInfo resolveActivity = this.a.getPackageManager().resolveActivity(intent, AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED);
            String str = resolveActivity.activityInfo != null ? resolveActivity.activityInfo.packageName : null;
            if ("com.android.browser".equals(str) || "com.android.chrome".equals(str)) {
                intent.setPackage(str);
                intent.addFlags(268435456);
                intent.putExtra("com.android.browser.application_id", str);
            }
            try {
                this.a.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void a() {
        this.c = State.DONE;
        this.d.d();
        Message.obtain(this.b.a(), u.quit).sendToTarget();
        try {
            this.b.join(500L);
        } catch (InterruptedException e) {
        }
        removeMessages(u.decode_succeeded);
        removeMessages(u.decode_failed);
    }

    private void b() {
        if (this.c == State.SUCCESS) {
            this.c = State.PREVIEW;
            this.d.a(this.b.a(), u.decode);
            this.a.d();
        }
    }
}
