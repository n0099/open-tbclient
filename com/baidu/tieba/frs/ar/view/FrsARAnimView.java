package com.baidu.tieba.frs.ar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class FrsARAnimView extends View implements com.baidu.tieba.frs.ar.view.a {
    private Rect aPJ;
    private BdUniqueId adq;
    private Bitmap bQU;
    private Rect bQV;
    private Runnable bRd;
    private String[] dpc;
    private boolean dpd;
    private Bitmap dpe;
    private Rect dpf;
    private Rect dpg;
    private int frameCount;
    private int index;
    private long startShowTime;
    private long totalTime;

    public FrsARAnimView(Context context) {
        super(context);
        this.dpd = false;
        this.index = 0;
        this.dpf = new Rect();
        this.dpg = new Rect();
        this.aPJ = new Rect();
        this.bQV = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bRd = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.dpc.length) {
                        FrsARAnimView.this.nextFrame();
                        return;
                    }
                    FrsARAnimView.this.stopAnim();
                    if (FrsARAnimView.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) FrsARAnimView.this.getParent()).removeView(FrsARAnimView.this);
                        return;
                    }
                    return;
                }
                e.im().postDelayed(FrsARAnimView.this.bRd, 10L);
            }
        };
        init();
    }

    public FrsARAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpd = false;
        this.index = 0;
        this.dpf = new Rect();
        this.dpg = new Rect();
        this.aPJ = new Rect();
        this.bQV = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bRd = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.dpc.length) {
                        FrsARAnimView.this.nextFrame();
                        return;
                    }
                    FrsARAnimView.this.stopAnim();
                    if (FrsARAnimView.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) FrsARAnimView.this.getParent()).removeView(FrsARAnimView.this);
                        return;
                    }
                    return;
                }
                e.im().postDelayed(FrsARAnimView.this.bRd, 10L);
            }
        };
        init();
    }

    public FrsARAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dpd = false;
        this.index = 0;
        this.dpf = new Rect();
        this.dpg = new Rect();
        this.aPJ = new Rect();
        this.bQV = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bRd = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.dpc.length) {
                        FrsARAnimView.this.nextFrame();
                        return;
                    }
                    FrsARAnimView.this.stopAnim();
                    if (FrsARAnimView.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) FrsARAnimView.this.getParent()).removeView(FrsARAnimView.this);
                        return;
                    }
                    return;
                }
                e.im().postDelayed(FrsARAnimView.this.bRd, 10L);
            }
        };
        init();
    }

    private void init() {
        this.dpe = a(getResources(), d.f.frs_ar_bg_mask, 720, 1280);
        this.dpf.set(0, 0, this.dpe.getWidth(), this.dpe.getHeight());
        int i = getResources().getDisplayMetrics().widthPixels;
        this.dpg.set(0, 0, i, (this.dpe.getHeight() * i) / this.dpe.getWidth());
        int i2 = this.frameCount;
        this.dpc = new String[i2];
        for (int i3 = 1; i3 < i2 + 1; i3++) {
            if (i3 < 10) {
                this.dpc[i3 - 1] = "frsar/frs_ar_fullscreen_anim_00" + i3 + ".png";
            } else if (i3 >= 100) {
                this.dpc[i3 - 1] = ("frsar/frs_ar_fullscreen_anim_" + i3 + ".png") + ".png";
            } else {
                this.dpc[i3 - 1] = "frsar/frs_ar_fullscreen_anim_0" + i3 + ".png";
            }
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsARAnimView.this.stopAnim();
                if (FrsARAnimView.this.getParent() instanceof ViewGroup) {
                    ((ViewGroup) FrsARAnimView.this.getParent()).removeView(FrsARAnimView.this);
                }
            }
        });
    }

    public void startAnim() {
        this.index = 0;
        a aVar = new a(this, 720, 1280);
        aVar.setTag(this.adq);
        aVar.setKey("LoadImageAsyncTask");
        aVar.execute(this.dpc[this.index]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextFrame() {
        a aVar = new a(this, 720, 1280);
        aVar.setTag(this.adq);
        aVar.setKey("LoadImageAsyncTask");
        aVar.execute(this.dpc[this.index]);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.dpg.set(0, getMeasuredHeight() - this.dpg.height(), this.dpg.width(), this.dpg.height());
    }

    @Override // com.baidu.tieba.frs.ar.view.a
    public void l(Bitmap bitmap) {
        if (this.startShowTime <= 0) {
            this.startShowTime = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.bQU != null) {
                this.bQU.recycle();
            }
            this.bQU = bitmap;
            this.aPJ.set(0, 0, this.bQU.getWidth(), this.bQU.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        this.index++;
        if (this.index >= this.dpc.length) {
            stopAnim();
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
                return;
            }
            return;
        }
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.startShowTime) * this.frameCount) / this.totalTime);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.dpc.length) {
                stopAnim();
                if (getParent() instanceof ViewGroup) {
                    ((ViewGroup) getParent()).removeView(this);
                    return;
                }
                return;
            }
            nextFrame();
            return;
        }
        e.im().postDelayed(this.bRd, 10L);
    }

    public void stopAnim() {
        BdAsyncTask.removeAllTask(this.adq, "FrsARAnimView");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dpe != null) {
            canvas.drawBitmap(this.dpe, this.aPJ, this.bQV, (Paint) null);
        }
        if (this.bQU != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int height = (this.bQU.getHeight() * getMeasuredWidth()) / this.bQU.getWidth();
            this.bQV.set(0, getMeasuredHeight() - height, i, height);
            canvas.drawBitmap(this.bQU, this.aPJ, this.bQV, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.adq = bdUniqueId;
    }

    private static final Bitmap a(Resources resources, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = calculateInSampleSize(options, i2, i3);
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeResource(resources, i, options2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [258=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap m(String str, int i, int i2) {
        InputStream inputStream;
        Throwable th;
        Bitmap bitmap = null;
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                inputStream = TbadkCoreApplication.getInst().getApplicationContext().getAssets().open(str);
                try {
                    BitmapFactory.decodeStream(inputStream, null, options);
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = calculateInSampleSize(options, i, i2);
                    options2.inPreferredConfig = Bitmap.Config.RGB_565;
                    bitmap = BitmapFactory.decodeStream(inputStream, null, options2);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bitmap;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            if (inputStream != null) {
            }
            throw th;
        }
        return bitmap;
    }

    private static final int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            i5 = 2;
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<String, Bitmap, Bitmap> {
        private int bLA;
        private int bLz;
        private com.baidu.tieba.frs.ar.view.a dpi;

        private a(com.baidu.tieba.frs.ar.view.a aVar, int i, int i2) {
            this.dpi = aVar;
            this.bLz = i;
            this.bLA = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (strArr == null || strArr[0] == null) {
                return null;
            }
            return FrsARAnimView.m(strArr[0], this.bLz, this.bLA);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.dpi != null) {
                this.dpi.l(bitmap);
            }
        }
    }
}
