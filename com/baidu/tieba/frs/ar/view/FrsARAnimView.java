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
    private BdUniqueId Vb;
    private Rect aGs;
    private Bitmap bGI;
    private Rect bGJ;
    private Runnable bGQ;
    private Bitmap cfD;
    private String[] ddb;
    private boolean ddc;
    private Rect ddd;
    private Rect dde;
    private int frameCount;
    private int index;
    private long startShowTime;
    private long totalTime;

    public FrsARAnimView(Context context) {
        super(context);
        this.ddc = false;
        this.index = 0;
        this.ddd = new Rect();
        this.dde = new Rect();
        this.aGs = new Rect();
        this.bGJ = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bGQ = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.ddb.length) {
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
                e.fw().postDelayed(FrsARAnimView.this.bGQ, 10L);
            }
        };
        init();
    }

    public FrsARAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddc = false;
        this.index = 0;
        this.ddd = new Rect();
        this.dde = new Rect();
        this.aGs = new Rect();
        this.bGJ = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bGQ = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.ddb.length) {
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
                e.fw().postDelayed(FrsARAnimView.this.bGQ, 10L);
            }
        };
        init();
    }

    public FrsARAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ddc = false;
        this.index = 0;
        this.ddd = new Rect();
        this.dde = new Rect();
        this.aGs = new Rect();
        this.bGJ = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bGQ = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.ddb.length) {
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
                e.fw().postDelayed(FrsARAnimView.this.bGQ, 10L);
            }
        };
        init();
    }

    private void init() {
        this.cfD = a(getResources(), d.f.frs_ar_bg_mask, 720, 1280);
        this.ddd.set(0, 0, this.cfD.getWidth(), this.cfD.getHeight());
        int i = getResources().getDisplayMetrics().widthPixels;
        this.dde.set(0, 0, i, (this.cfD.getHeight() * i) / this.cfD.getWidth());
        int i2 = this.frameCount;
        this.ddb = new String[i2];
        for (int i3 = 1; i3 < i2 + 1; i3++) {
            if (i3 < 10) {
                this.ddb[i3 - 1] = "frsar/frs_ar_fullscreen_anim_00" + i3 + ".png";
            } else if (i3 >= 100) {
                this.ddb[i3 - 1] = ("frsar/frs_ar_fullscreen_anim_" + i3 + ".png") + ".png";
            } else {
                this.ddb[i3 - 1] = "frsar/frs_ar_fullscreen_anim_0" + i3 + ".png";
            }
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
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
        aVar.setTag(this.Vb);
        aVar.setKey("LoadImageAsyncTask");
        aVar.execute(this.ddb[this.index]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextFrame() {
        a aVar = new a(this, 720, 1280);
        aVar.setTag(this.Vb);
        aVar.setKey("LoadImageAsyncTask");
        aVar.execute(this.ddb[this.index]);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.dde.set(0, getMeasuredHeight() - this.dde.height(), this.dde.width(), this.dde.height());
    }

    @Override // com.baidu.tieba.frs.ar.view.a
    public void m(Bitmap bitmap) {
        if (this.startShowTime <= 0) {
            this.startShowTime = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.bGI != null) {
                this.bGI.recycle();
            }
            this.bGI = bitmap;
            this.aGs.set(0, 0, this.bGI.getWidth(), this.bGI.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        this.index++;
        if (this.index >= this.ddb.length) {
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
            if (this.index >= this.ddb.length) {
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
        e.fw().postDelayed(this.bGQ, 10L);
    }

    public void stopAnim() {
        BdAsyncTask.removeAllTask(this.Vb, "FrsARAnimView");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cfD != null) {
            canvas.drawBitmap(this.cfD, this.aGs, this.bGJ, (Paint) null);
        }
        if (this.bGI != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int height = (this.bGI.getHeight() * getMeasuredWidth()) / this.bGI.getWidth();
            this.bGJ.set(0, getMeasuredHeight() - height, i, height);
            canvas.drawBitmap(this.bGI, this.aGs, this.bGJ, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.Vb = bdUniqueId;
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
    public static final Bitmap l(String str, int i, int i2) {
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
        private com.baidu.tieba.frs.ar.view.a ddg;
        private int ddh;
        private int ddi;

        private a(com.baidu.tieba.frs.ar.view.a aVar, int i, int i2) {
            this.ddg = aVar;
            this.ddh = i;
            this.ddi = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (strArr == null || strArr[0] == null) {
                return null;
            }
            return FrsARAnimView.l(strArr[0], this.ddh, this.ddi);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.ddg != null) {
                this.ddg.m(bitmap);
            }
        }
    }
}
