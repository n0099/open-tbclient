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
    private BdUniqueId aJU;
    private Rect bwe;
    private Bitmap cOJ;
    private String[] dJo;
    private boolean dJp;
    private Bitmap dJq;
    private Rect dJr;
    private Rect dJs;
    private Rect dJt;
    private Runnable dJu;
    private int frameCount;
    private int index;
    private long startShowTime;
    private long totalTime;

    public a(Context context) {
        super(context);
        this.dJp = false;
        this.index = 0;
        this.dJr = new Rect();
        this.dJs = new Rect();
        this.bwe = new Rect();
        this.dJt = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.dJu = new Runnable() { // from class: com.baidu.tieba.frs.ar.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - a.this.startShowTime) * a.this.frameCount) / a.this.totalTime);
                if (currentTimeMillis > a.this.index) {
                    a.this.index = currentTimeMillis;
                    if (a.this.index < a.this.dJo.length) {
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
                e.ns().postDelayed(a.this.dJu, 10L);
            }
        };
        init();
    }

    private void init() {
        this.cOJ = a(getResources(), d.f.frs_ar_bg_mask, 720, 1280);
        this.dJr.set(0, 0, this.cOJ.getWidth(), this.cOJ.getHeight());
        int i = getResources().getDisplayMetrics().widthPixels;
        this.dJs.set(0, 0, i, (this.cOJ.getHeight() * i) / this.cOJ.getWidth());
        int i2 = this.frameCount;
        this.dJo = new String[i2];
        for (int i3 = 1; i3 < i2 + 1; i3++) {
            if (i3 < 10) {
                this.dJo[i3 - 1] = "frsar/frs_ar_fullscreen_anim_00" + i3 + ".png";
            } else if (i3 >= 100) {
                this.dJo[i3 - 1] = ("frsar/frs_ar_fullscreen_anim_" + i3 + ".png") + ".png";
            } else {
                this.dJo[i3 - 1] = "frsar/frs_ar_fullscreen_anim_0" + i3 + ".png";
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
        C0150a c0150a = new C0150a(this, 720, 1280);
        c0150a.setTag(this.aJU);
        c0150a.setKey("LoadImageAsyncTask");
        c0150a.execute(this.dJo[this.index]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextFrame() {
        C0150a c0150a = new C0150a(this, 720, 1280);
        c0150a.setTag(this.aJU);
        c0150a.setKey("LoadImageAsyncTask");
        c0150a.execute(this.dJo[this.index]);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.dJs.set(0, getMeasuredHeight() - this.dJs.height(), this.dJs.width(), this.dJs.height());
    }

    @Override // com.baidu.tieba.frs.ar.a.c
    public void o(Bitmap bitmap) {
        if (this.startShowTime <= 0) {
            this.startShowTime = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.dJq != null) {
                this.dJq.recycle();
            }
            this.dJq = bitmap;
            this.bwe.set(0, 0, this.dJq.getWidth(), this.dJq.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        this.index++;
        if (this.index >= this.dJo.length) {
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
            if (this.index >= this.dJo.length) {
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
        e.ns().postDelayed(this.dJu, 10L);
    }

    public void stopAnim() {
        BdAsyncTask.removeAllTask(this.aJU, "FrsARAnimView");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cOJ != null) {
            canvas.drawBitmap(this.cOJ, this.bwe, this.dJt, (Paint) null);
        }
        if (this.dJq != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int height = (this.dJq.getHeight() * getMeasuredWidth()) / this.dJq.getWidth();
            this.dJt.set(0, getMeasuredHeight() - height, i, height);
            canvas.drawBitmap(this.dJq, this.bwe, this.dJt, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aJU = bdUniqueId;
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
    public static class C0150a extends BdAsyncTask<String, Bitmap, Bitmap> {
        private c dJw;
        private int dJx;
        private int dJy;

        private C0150a(c cVar, int i, int i2) {
            this.dJw = cVar;
            this.dJx = i;
            this.dJy = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (strArr == null || strArr[0] == null) {
                return null;
            }
            return a.k(strArr[0], this.dJx, this.dJy);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((C0150a) bitmap);
            if (this.dJw != null) {
                this.dJw.o(bitmap);
            }
        }
    }
}
