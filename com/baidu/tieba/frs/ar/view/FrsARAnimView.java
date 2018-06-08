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
    private Rect aON;
    private BdUniqueId ada;
    private Bitmap bOK;
    private Rect bOL;
    private Runnable bOS;
    private Bitmap cnI;
    private String[] dmq;
    private boolean dmr;
    private Rect dms;
    private Rect dmt;
    private int frameCount;
    private int index;
    private long startShowTime;
    private long totalTime;

    public FrsARAnimView(Context context) {
        super(context);
        this.dmr = false;
        this.index = 0;
        this.dms = new Rect();
        this.dmt = new Rect();
        this.aON = new Rect();
        this.bOL = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bOS = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.dmq.length) {
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
                e.im().postDelayed(FrsARAnimView.this.bOS, 10L);
            }
        };
        init();
    }

    public FrsARAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmr = false;
        this.index = 0;
        this.dms = new Rect();
        this.dmt = new Rect();
        this.aON = new Rect();
        this.bOL = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bOS = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.dmq.length) {
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
                e.im().postDelayed(FrsARAnimView.this.bOS, 10L);
            }
        };
        init();
    }

    public FrsARAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dmr = false;
        this.index = 0;
        this.dms = new Rect();
        this.dmt = new Rect();
        this.aON = new Rect();
        this.bOL = new Rect();
        this.startShowTime = 0L;
        this.totalTime = 6000L;
        this.frameCount = 144;
        this.bOS = new Runnable() { // from class: com.baidu.tieba.frs.ar.view.FrsARAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - FrsARAnimView.this.startShowTime) * FrsARAnimView.this.frameCount) / FrsARAnimView.this.totalTime);
                if (currentTimeMillis > FrsARAnimView.this.index) {
                    FrsARAnimView.this.index = currentTimeMillis;
                    if (FrsARAnimView.this.index < FrsARAnimView.this.dmq.length) {
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
                e.im().postDelayed(FrsARAnimView.this.bOS, 10L);
            }
        };
        init();
    }

    private void init() {
        this.cnI = a(getResources(), d.f.frs_ar_bg_mask, 720, 1280);
        this.dms.set(0, 0, this.cnI.getWidth(), this.cnI.getHeight());
        int i = getResources().getDisplayMetrics().widthPixels;
        this.dmt.set(0, 0, i, (this.cnI.getHeight() * i) / this.cnI.getWidth());
        int i2 = this.frameCount;
        this.dmq = new String[i2];
        for (int i3 = 1; i3 < i2 + 1; i3++) {
            if (i3 < 10) {
                this.dmq[i3 - 1] = "frsar/frs_ar_fullscreen_anim_00" + i3 + ".png";
            } else if (i3 >= 100) {
                this.dmq[i3 - 1] = ("frsar/frs_ar_fullscreen_anim_" + i3 + ".png") + ".png";
            } else {
                this.dmq[i3 - 1] = "frsar/frs_ar_fullscreen_anim_0" + i3 + ".png";
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
        aVar.setTag(this.ada);
        aVar.setKey("LoadImageAsyncTask");
        aVar.execute(this.dmq[this.index]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextFrame() {
        a aVar = new a(this, 720, 1280);
        aVar.setTag(this.ada);
        aVar.setKey("LoadImageAsyncTask");
        aVar.execute(this.dmq[this.index]);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.dmt.set(0, getMeasuredHeight() - this.dmt.height(), this.dmt.width(), this.dmt.height());
    }

    @Override // com.baidu.tieba.frs.ar.view.a
    public void l(Bitmap bitmap) {
        if (this.startShowTime <= 0) {
            this.startShowTime = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.bOK != null) {
                this.bOK.recycle();
            }
            this.bOK = bitmap;
            this.aON.set(0, 0, this.bOK.getWidth(), this.bOK.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        this.index++;
        if (this.index >= this.dmq.length) {
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
            if (this.index >= this.dmq.length) {
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
        e.im().postDelayed(this.bOS, 10L);
    }

    public void stopAnim() {
        BdAsyncTask.removeAllTask(this.ada, "FrsARAnimView");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cnI != null) {
            canvas.drawBitmap(this.cnI, this.aON, this.bOL, (Paint) null);
        }
        if (this.bOK != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int height = (this.bOK.getHeight() * getMeasuredWidth()) / this.bOK.getWidth();
            this.bOL.set(0, getMeasuredHeight() - height, i, height);
            canvas.drawBitmap(this.bOK, this.aON, this.bOL, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.ada = bdUniqueId;
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
        private com.baidu.tieba.frs.ar.view.a dmv;
        private int dmw;
        private int dmx;

        private a(com.baidu.tieba.frs.ar.view.a aVar, int i, int i2) {
            this.dmv = aVar;
            this.dmw = i;
            this.dmx = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (strArr == null || strArr[0] == null) {
                return null;
            }
            return FrsARAnimView.l(strArr[0], this.dmw, this.dmx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.dmv != null) {
                this.dmv.l(bitmap);
            }
        }
    }
}
