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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.slidingmenu.lib.R;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public final class CaptureActivityHandler extends Handler {
    private final CaptureActivity a;
    private final n b;
    private State c;
    private final com.baidu.tieba.barcode.a.f d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CaptureActivityHandler(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, com.baidu.tieba.barcode.a.f fVar) {
        this.a = captureActivity;
        this.b = new n(captureActivity, collection, map, str, new s(captureActivity.a()));
        this.b.start();
        this.c = State.SUCCESS;
        this.d = fVar;
        fVar.c();
        b();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Bitmap bitmap;
        float f;
        String str = null;
        switch (message.what) {
            case R.id.decode_failed /* 2131099700 */:
                this.c = State.PREVIEW;
                this.d.a(this.b.a(), R.id.decode);
                return;
            case R.id.decode_succeeded /* 2131099701 */:
                com.baidu.adp.lib.g.e.e(getClass().getName(), "handleMessage", "Got decode succeeded message");
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
                return;
            case R.id.launch_product_query /* 2131099702 */:
                com.baidu.adp.lib.g.e.e(getClass().getName(), "handleMessage", "Got product query message");
                String str2 = (String) message.obj;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(524288);
                intent.setData(Uri.parse(str2));
                ResolveInfo resolveActivity = this.a.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity.activityInfo != null) {
                    str = resolveActivity.activityInfo.packageName;
                    com.baidu.adp.lib.g.e.e(getClass().getName(), "handleMessage", "Using browser in package " + str);
                }
                if ("com.android.browser".equals(str) || "com.android.chrome".equals(str)) {
                    intent.setPackage(str);
                    intent.addFlags(268435456);
                    intent.putExtra("com.android.browser.application_id", str);
                }
                try {
                    this.a.startActivity(intent);
                    return;
                } catch (ActivityNotFoundException e) {
                    com.baidu.adp.lib.g.e.e(getClass().getName(), "handleMessage", "Can't find anything to handle VIEW of URI " + str2);
                    return;
                }
            case R.id.quit /* 2131099703 */:
            default:
                return;
            case R.id.restart_preview /* 2131099704 */:
                com.baidu.adp.lib.g.e.e(getClass().getName(), "handleMessage", "Got restart preview message");
                b();
                return;
            case R.id.return_scan_result /* 2131099705 */:
                com.baidu.adp.lib.g.e.e(getClass().getName(), "handleMessage", "Got return scan result message");
                this.a.setResult(-1, (Intent) message.obj);
                this.a.finish();
                return;
        }
    }

    public void a() {
        this.c = State.DONE;
        this.d.d();
        Message.obtain(this.b.a(), (int) R.id.quit).sendToTarget();
        try {
            this.b.join(500L);
        } catch (InterruptedException e) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    private void b() {
        if (this.c == State.SUCCESS) {
            this.c = State.PREVIEW;
            this.d.a(this.b.a(), R.id.decode);
            this.a.d();
        }
    }
}
