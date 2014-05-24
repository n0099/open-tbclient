package com.baidu.tieba.barcode;

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
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.barcode.result.ZxingResult;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
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
/* loaded from: classes.dex */
public final class CaptureActivity extends BaseActivity implements SurfaceHolder.Callback {
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
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.f.class, CaptureActivity.class);
    }

    public ViewfinderView a() {
        return this.d;
    }

    public Handler b() {
        return this.b;
    }

    public com.baidu.tieba.barcode.a.e c() {
        return this.a;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(w.barcode_capture);
        this.l = (ProgressBar) findViewById(v.progress);
        this.l.setVisibility(8);
        this.g = (NavigationBar) findViewById(v.view_navigation_bar);
        this.h = this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h.setOnClickListener(new a(this));
        this.g.a(getResources().getString(y.bar_code_scanning));
        this.i = this.g.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(y.album));
        this.i.setOnClickListener(new b(this));
        this.e = false;
        this.f = new n(this);
        f();
    }

    public boolean e() {
        if (x.a()) {
            return true;
        }
        showToast(getString(y.voice_error_sdcard));
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12002 && intent != null && intent.getData() != null) {
            TiebaPrepareImageService.StartService(i, intent.getData(), bf.a().e(), com.baidu.adp.lib.util.k.b(this));
        }
    }

    private void f() {
        this.j = new j(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.j, intentFilter);
    }

    public void g() {
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = new i(this, null);
        this.k.execute(new Object[0]);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.tbadk.coreExtra.c.a.a(this, new c(this));
            return;
        }
        TiebaStatic.eventStat(this, "2d_code_scan_suc", "onclick", 1, new Object[0]);
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            bi.a().a((Context) this, new String[]{str}, true, (bm) new d(this));
            return;
        }
        com.baidu.tbadk.coreExtra.c.a.a(this, new e(this), str);
    }

    public String a(Bitmap bitmap) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a = new com.baidu.tieba.barcode.a.e(getApplication());
        this.d = (ViewfinderView) findViewById(v.viewfinder_view);
        this.d.setCameraManager(this.a);
        this.b = null;
        i();
        SurfaceHolder holder = ((SurfaceView) findViewById(v.preview_view)).getHolder();
        if (this.e) {
            a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f.c();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        this.f.b();
        this.a.b();
        if (!this.e) {
            ((SurfaceView) findViewById(v.preview_view)).getHolder().removeCallback(this);
        }
        if (this.d != null) {
            this.d.d();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 27:
            case 80:
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void a(Bitmap bitmap, Result result) {
        if (this.b == null) {
            this.c = result;
            return;
        }
        if (result != null) {
            this.c = result;
        }
        if (this.c != null) {
            this.b.sendMessage(Message.obtain(this.b, v.decode_succeeded, this.c));
        }
        this.c = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            BdLog.e(getClass().getName(), "surfaceCreated", "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.e) {
            this.e = true;
            this.n.postDelayed(new f(this, surfaceHolder), 1L);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.e = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void a(Result result, Bitmap bitmap, float f) {
        this.f.a();
        if (bitmap != null) {
            a(bitmap, f, result);
        }
        a(result, bitmap);
    }

    private void a(Bitmap bitmap, float f, Result result) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints != null && resultPoints.length > 0) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(s.result_points));
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
    }

    private static void a(Canvas canvas, Paint paint, ResultPoint resultPoint, ResultPoint resultPoint2, float f) {
        if (resultPoint != null && resultPoint2 != null) {
            canvas.drawLine(f * resultPoint.getX(), f * resultPoint.getY(), f * resultPoint2.getX(), f * resultPoint2.getY(), paint);
        }
    }

    private void a(Result result, Bitmap bitmap) {
        this.d.setVisibility(8);
        ZxingResult zxingResult = new ZxingResult();
        zxingResult.a(ResultParser.parseResult(result).getDisplayResult().toString());
        TiebaStatic.eventStat(this, "2d_code_scan", "onclick", 1, new Object[0]);
        a(zxingResult.a());
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.a.a()) {
            BdLog.w(getClass().getName(), "initCamera", "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.a.a(surfaceHolder);
            if (this.b == null) {
                this.b = new CaptureActivityHandler(this, null, null, null, this.a);
            }
            a((Bitmap) null, (Result) null);
        } catch (IOException e) {
            BdLog.w(getClass().getName(), "initCamera", e.toString());
            h();
        } catch (RuntimeException e2) {
            BdLog.w(getClass().getName(), "initCamera", "Unexpected error initializing camera" + e2.toString());
            h();
        }
    }

    private void h() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(y.app_name));
        builder.setMessage(getString(y.msg_camera_framework_bug));
        builder.setPositiveButton(y.dialog_ok, new g(this));
        builder.setOnCancelListener(new h(this));
        builder.show();
    }

    private void i() {
        this.d.setVisibility(0);
    }

    public void d() {
        this.d.c();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.g.c(i);
    }
}
