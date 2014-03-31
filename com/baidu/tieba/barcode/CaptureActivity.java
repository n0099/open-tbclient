package com.baidu.tieba.barcode;

import android.app.AlertDialog;
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
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.barcode.result.ZxingResult;
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
import java.io.IOException;
import java.util.Hashtable;
import protobuf.Im;
/* loaded from: classes.dex */
public final class CaptureActivity extends com.baidu.tbadk.a implements SurfaceHolder.Callback {
    private com.baidu.tieba.barcode.a.e a;
    private CaptureActivityHandler b;
    private Result c;
    private ViewfinderView d;
    private boolean e;
    private n f;
    private NavigationBar g;
    private View h;
    private TextView i;
    private j j;
    private i k;
    private ProgressBar l;
    private Bitmap m;
    private Handler n = new Handler();

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.e.class, CaptureActivity.class);
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

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(com.baidu.tieba.a.i.barcode_capture);
        this.l = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.l.setVisibility(8);
        this.g = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.h = this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h.setOnClickListener(new a(this));
        this.g.a(getResources().getString(com.baidu.tieba.a.k.bar_code_scanning));
        this.i = this.g.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.a.k.album));
        this.i.setOnClickListener(new b(this));
        this.e = false;
        this.f = new n(this);
        this.j = new j(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tbadk.core.data.n.t());
        registerReceiver(this.j, intentFilter);
    }

    public static /* synthetic */ boolean d(CaptureActivity captureActivity) {
        if (w.a()) {
            return true;
        }
        captureActivity.showToast(captureActivity.getString(com.baidu.tieba.a.k.voice_error_sdcard));
        return false;
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12002 && intent != null && intent.getData() != null) {
            TiebaPrepareImageService.a(i, intent.getData(), bd.a().e(), com.baidu.adp.lib.util.i.b(this));
        }
    }

    public static /* synthetic */ void a(CaptureActivity captureActivity) {
        if (captureActivity.k != null) {
            captureActivity.k.cancel();
        }
        captureActivity.k = new i(captureActivity, (byte) 0);
        captureActivity.k.execute(new Object[0]);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tbadk.l.anti_title).setMessage(com.baidu.tbadk.l.msg_album_bug).setPositiveButton(com.baidu.tbadk.l.alert_yes_button, new c(this)).create().show();
            return;
        }
        TiebaStatic.a(this, "2d_code_scan_suc", "onclick", 1, new Object[0]);
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            bg.a().a(this, new String[]{str}, true, new d(this));
            return;
        }
        new AlertDialog.Builder(this).setTitle(com.baidu.tbadk.l.bar_code_result).setMessage(str).setPositiveButton(com.baidu.tbadk.l.alert_yes_button, new e(this)).create().show();
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

    @Override // com.baidu.tbadk.a, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.a = new com.baidu.tieba.barcode.a.e(getApplication());
        this.d = (ViewfinderView) findViewById(com.baidu.tieba.a.h.viewfinder_view);
        this.d.setCameraManager(this.a);
        this.b = null;
        this.d.setVisibility(0);
        SurfaceHolder holder = ((SurfaceView) findViewById(com.baidu.tieba.a.h.preview_view)).getHolder();
        if (this.e) {
            a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f.c();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public final void onPause() {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        this.f.b();
        this.a.b();
        if (!this.e) {
            ((SurfaceView) findViewById(com.baidu.tieba.a.h.preview_view)).getHolder().removeCallback(this);
        }
        if (this.d != null) {
            this.d.d();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public final void onDestroy() {
        TiebaPrepareImageService.a();
        this.f.d();
        if (this.d != null) {
            this.d.e();
        }
        if (this.m != null && !this.m.isRecycled()) {
            this.m.recycle();
        }
        unregisterReceiver(this.j);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "surfaceCreated", "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.e) {
            this.e = true;
            this.n.postDelayed(new f(this, surfaceHolder), 1L);
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
            paint.setColor(getResources().getColor(com.baidu.tieba.a.e.result_points));
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
        TiebaStatic.a(this, "2d_code_scan", "onclick", 1, new Object[0]);
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
            com.baidu.adp.lib.util.f.c(getClass().getName(), "initCamera", "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.a.a(surfaceHolder);
            if (this.b == null) {
                this.b = new CaptureActivityHandler(this, null, null, null, this.a);
            }
            if (this.b != null) {
                if (this.c != null) {
                    this.b.sendMessage(Message.obtain(this.b, com.baidu.tieba.a.h.decode_succeeded, this.c));
                }
                this.c = null;
                return;
            }
            this.c = null;
        } catch (IOException e) {
            com.baidu.adp.lib.util.f.c(getClass().getName(), "initCamera", e.toString());
            e();
        } catch (RuntimeException e2) {
            com.baidu.adp.lib.util.f.c(getClass().getName(), "initCamera", "Unexpected error initializing camera" + e2.toString());
            e();
        }
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.a.k.app_name));
        builder.setMessage(getString(com.baidu.tieba.a.k.msg_camera_framework_bug));
        builder.setPositiveButton(com.baidu.tieba.a.k.dialog_ok, new g(this));
        builder.setOnCancelListener(new h(this));
        builder.show();
    }

    public final void d() {
        this.d.c();
    }

    @Override // com.baidu.tbadk.a
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.g.b(i);
    }
}
