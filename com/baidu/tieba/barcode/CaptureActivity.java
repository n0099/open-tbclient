package com.baidu.tieba.barcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.webkit.URLUtil;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.barcode.result.ZxingResult;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.bv;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.NavigationBar;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.slidingmenu.lib.R;
import java.io.IOException;
import java.util.Hashtable;
import protobuf.Im;
/* loaded from: classes.dex */
public final class CaptureActivity extends com.baidu.tieba.f implements SurfaceHolder.Callback {
    private com.baidu.tieba.barcode.a.e a;
    private CaptureActivityHandler b;
    private Result c;
    private ViewfinderView d;
    private boolean e;
    private o f;
    private NavigationBar g;
    private TextView h;
    private k i;
    private j j;
    private ProgressBar k;
    private Bitmap l;
    private Handler m = new Handler();

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, CaptureActivity.class), 16003);
    }

    public final ViewfinderView a() {
        return this.d;
    }

    public final Handler b() {
        return this.b;
    }

    public final com.baidu.tieba.barcode.a.e c() {
        return this.a;
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(R.layout.barcode_capture);
        this.k = (ProgressBar) findViewById(R.id.progress);
        this.k.setVisibility(8);
        this.g = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.g.a(getResources().getString(R.string.bar_code_scanning));
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.h = this.g.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.album));
        this.h.setOnClickListener(new b(this));
        this.e = false;
        this.f = new o(this);
        this.i = new k(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tieba.data.i.b());
        registerReceiver(this.i, intentFilter);
    }

    public static /* synthetic */ boolean d(CaptureActivity captureActivity) {
        if (af.a()) {
            return true;
        }
        captureActivity.showToast(captureActivity.getString(R.string.voice_error_sdcard));
        return false;
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12002 && intent != null && intent.getData() != null) {
            TiebaPrepareImageService.a(i, intent.getData(), bv.a().e(), BdUtilHelper.b(this));
        }
    }

    public static /* synthetic */ void a(CaptureActivity captureActivity) {
        if (captureActivity.j != null) {
            captureActivity.j.cancel();
        }
        captureActivity.j = new j(captureActivity, (byte) 0);
        captureActivity.j.execute(new Object[0]);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            new AlertDialog.Builder(this).setTitle(R.string.anti_title).setMessage(R.string.msg_album_bug).setPositiveButton(R.string.alert_yes_button, new c(this)).create().show();
            return;
        }
        cb.a(this, "2d_code_scan_suc", "onclick", 1, new Object[0]);
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            if (com.baidu.tieba.im.util.p.a(str)) {
                com.baidu.tieba.im.util.p.a((Context) this, str, false);
                Intent intent = new Intent();
                intent.putExtra("result", str);
                setResult(-1, intent);
                this.k.setVisibility(8);
                finish();
                return;
            }
            new AlertDialog.Builder(this).setTitle(R.string.del_post_tip).setMessage(String.format(getString(R.string.url_notify), str)).setPositiveButton(R.string.alert_yes_button, new d(this, str)).setNegativeButton(R.string.alert_no_button, new e(this)).create().show();
            return;
        }
        new AlertDialog.Builder(this).setTitle(R.string.bar_code_result).setMessage(str).setPositiveButton(R.string.alert_yes_button, new f(this)).create().show();
    }

    public static String a(Bitmap bitmap) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        try {
            return new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(width, height, iArr))), hashtable).getText();
        } catch (ChecksumException e) {
            e.printStackTrace();
            return null;
        } catch (FormatException e2) {
            e2.printStackTrace();
            return null;
        } catch (NotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.a = new com.baidu.tieba.barcode.a.e(getApplication());
        this.d = (ViewfinderView) findViewById(R.id.viewfinder_view);
        this.d.setCameraManager(this.a);
        this.b = null;
        this.d.setVisibility(0);
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.preview_view)).getHolder();
        if (this.e) {
            a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f.c();
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public final void onPause() {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        this.f.b();
        this.a.b();
        if (!this.e) {
            ((SurfaceView) findViewById(R.id.preview_view)).getHolder().removeCallback(this);
        }
        if (this.d != null) {
            this.d.d();
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public final void onDestroy() {
        TiebaPrepareImageService.a();
        this.f.d();
        if (this.d != null) {
            this.d.e();
        }
        if (this.l != null && !this.l.isRecycled()) {
            this.l.recycle();
        }
        unregisterReceiver(this.i);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case Im.GroupInfo.ACTIVEDAY_FIELD_NUMBER /* 27 */:
            case com.baidu.loginshare.e.i /* 80 */:
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "surfaceCreated", "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.e) {
            this.e = true;
            this.m.postDelayed(new g(this, surfaceHolder), 1L);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.e = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public final void a(Result result, Bitmap bitmap, float f) {
        ResultPoint[] resultPoints;
        this.f.a();
        if ((bitmap != null) && (resultPoints = result.getResultPoints()) != null && resultPoints.length > 0) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.result_points));
            if (resultPoints.length == 2) {
                paint.setStrokeWidth(4.0f);
                a(canvas, paint, resultPoints[0], resultPoints[1], f);
            } else if (resultPoints.length == 4 && (result.getBarcodeFormat() == BarcodeFormat.UPC_A || result.getBarcodeFormat() == BarcodeFormat.EAN_13)) {
                a(canvas, paint, resultPoints[0], resultPoints[1], f);
                a(canvas, paint, resultPoints[2], resultPoints[3], f);
            } else {
                paint.setStrokeWidth(10.0f);
                for (ResultPoint resultPoint : resultPoints) {
                    canvas.drawPoint(resultPoint.getX() * f, resultPoint.getY() * f, paint);
                }
            }
        }
        this.d.setVisibility(8);
        ZxingResult zxingResult = new ZxingResult();
        zxingResult.a(ResultParser.parseResult(result).getDisplayResult().toString());
        cb.a(this, "2d_code_scan", "onclick", 1, new Object[0]);
        a(zxingResult.a());
    }

    private static void a(Canvas canvas, Paint paint, ResultPoint resultPoint, ResultPoint resultPoint2, float f) {
        if (resultPoint != null && resultPoint2 != null) {
            canvas.drawLine(f * resultPoint.getX(), f * resultPoint.getY(), f * resultPoint2.getX(), f * resultPoint2.getY(), paint);
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.a.a()) {
            com.baidu.adp.lib.util.e.c(getClass().getName(), "initCamera", "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.a.a(surfaceHolder);
            if (this.b == null) {
                this.b = new CaptureActivityHandler(this, null, null, null, this.a);
            }
            if (this.b != null) {
                if (this.c != null) {
                    this.b.sendMessage(Message.obtain(this.b, R.id.decode_succeeded, this.c));
                }
                this.c = null;
                return;
            }
            this.c = null;
        } catch (IOException e) {
            com.baidu.adp.lib.util.e.c(getClass().getName(), "initCamera", e.toString());
            e();
        } catch (RuntimeException e2) {
            com.baidu.adp.lib.util.e.c(getClass().getName(), "initCamera", "Unexpected error initializing camera" + e2.toString());
            e();
        }
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.msg_camera_framework_bug));
        builder.setPositiveButton(R.string.dialog_ok, new h(this));
        builder.setOnCancelListener(new i(this));
        builder.show();
    }

    public final void d() {
        this.d.c();
    }

    @Override // com.baidu.tieba.f
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.g.b(i);
    }
}
