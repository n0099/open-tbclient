package com.baidu.tieba.frs.ar.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
public class a extends View implements c {
    private BdUniqueId aJJ;
    private Rect bvR;
    private Bitmap cOx;
    private String[] dJc;
    private boolean dJd;
    private Bitmap dJe;
    private Rect dJf;
    private Rect dJg;
    private Rect dJh;
    private Runnable dJi;
    private int frameCount;
    private int index;
    private long startShowTime;
    private long totalTime;

    public a(Context context) {
        super(context);
        this.dJd = false;
        this.index = 0;
        this.dJf = new Rect();
        this.dJg = new Rect();
        this.bvR = new Rect();
        this.dJh = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.dJi = new Runnable() { // from class: com.baidu.tieba.frs.ar.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - a.this.startShowTime) * a.this.frameCount) / a.this.totalTime);
                if (currentTimeMillis > a.this.index) {
                    a.this.index = currentTimeMillis;
                    if (a.this.index < a.this.dJc.length) {
                        a.this.nextFrame();
                        return;
                    }
                    a.this.stopAnim();
                    if (a.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) a.this.getParent()).removeView(a.this);
                        return;
                    }
                    return;
                }
                e.ns().postDelayed(a.this.dJi, 10L);
            }
        };
        init();
    }

    private void init() {
        this.cOx = a(getResources(), d.f.frs_ar_bg_mask, 720, 1280);
        this.dJf.set(0, 0, this.cOx.getWidth(), this.cOx.getHeight());
        int i = getResources().getDisplayMetrics().widthPixels;
        this.dJg.set(0, 0, i, (this.cOx.getHeight() * i) / this.cOx.getWidth());
        int i2 = this.frameCount;
        this.dJc = new String[i2];
        for (int i3 = 1; i3 < i2 + 1; i3++) {
            if (i3 < 10) {
                this.dJc[i3 - 1] = "frsar/frs_ar_fullscreen_anim_00" + i3 + ".png";
            } else if (i3 >= 100) {
                this.dJc[i3 - 1] = ("frsar/frs_ar_fullscreen_anim_" + i3 + ".png") + ".png";
            } else {
                this.dJc[i3 - 1] = "frsar/frs_ar_fullscreen_anim_0" + i3 + ".png";
            }
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ar.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.stopAnim();
                if (a.this.getParent() instanceof ViewGroup) {
                    ((ViewGroup) a.this.getParent()).removeView(a.this);
                }
            }
        });
    }

    public void startAnim() {
        this.index = 0;
        C0151a c0151a = new C0151a(this, 720, 1280);
        c0151a.setTag(this.aJJ);
        c0151a.setKey("LoadImageAsyncTask");
        c0151a.execute(this.dJc[this.index]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextFrame() {
        C0151a c0151a = new C0151a(this, 720, 1280);
        c0151a.setTag(this.aJJ);
        c0151a.setKey("LoadImageAsyncTask");
        c0151a.execute(this.dJc[this.index]);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.dJg.set(0, getMeasuredHeight() - this.dJg.height(), this.dJg.width(), this.dJg.height());
    }

    @Override // com.baidu.tieba.frs.ar.a.c
    public void o(Bitmap bitmap) {
        if (this.startShowTime <= 0) {
            this.startShowTime = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.dJe != null) {
                this.dJe.recycle();
            }
            this.dJe = bitmap;
            this.bvR.set(0, 0, this.dJe.getWidth(), this.dJe.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        this.index++;
        if (this.index >= this.dJc.length) {
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
            if (this.index >= this.dJc.length) {
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
        e.ns().postDelayed(this.dJi, 10L);
    }

    public void stopAnim() {
        BdAsyncTask.removeAllTask(this.aJJ, "FrsARAnimView");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cOx != null) {
            canvas.drawBitmap(this.cOx, this.bvR, this.dJh, (Paint) null);
        }
        if (this.dJe != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int height = (this.dJe.getHeight() * getMeasuredWidth()) / this.dJe.getWidth();
            this.dJh.set(0, getMeasuredHeight() - height, i, height);
            canvas.drawBitmap(this.dJe, this.bvR, this.dJh, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aJJ = bdUniqueId;
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
    public static final Bitmap k(String str, int i, int i2) {
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
    /* renamed from: com.baidu.tieba.frs.ar.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0151a extends BdAsyncTask<String, Bitmap, Bitmap> {
        private c dJk;
        private int dJl;
        private int dJm;

        private C0151a(c cVar, int i, int i2) {
            this.dJk = cVar;
            this.dJl = i;
            this.dJm = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (strArr == null || strArr[0] == null) {
                return null;
            }
            return a.k(strArr[0], this.dJl, this.dJm);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((C0151a) bitmap);
            if (this.dJk != null) {
                this.dJk.o(bitmap);
            }
        }
    }
}
