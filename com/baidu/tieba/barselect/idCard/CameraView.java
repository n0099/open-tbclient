package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.idCard.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes21.dex */
public class CameraView extends FrameLayout {
    private TextView hAA;
    private LinearLayout hAB;
    Handler hAC;
    private b hAD;
    private final int hAu;
    private int hAv;
    private a hAw;
    private d hAx;
    private MaskView hAy;
    private ImageView hAz;
    private View hzD;
    private int maskType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public interface b {
        void x(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.hAv = i;
    }

    public d getCameraControl() {
        return this.hAx;
    }

    public void setOrientation(int i) {
        this.hAx.wp(i);
    }

    public CameraView(Context context) {
        super(context);
        this.hAu = 0;
        this.hAv = 0;
        this.hAw = new a();
        this.hAC = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAu = 0;
        this.hAv = 0;
        this.hAw = new a();
        this.hAC = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAu = 0;
        this.hAv = 0;
        this.hAw = new a();
        this.hAC = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.hAx.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.hAx.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.hAw.file = file;
        this.hAw.hAE = bVar;
        this.hAx.a(this.hAw);
    }

    public void setAutoPictureCallback(b bVar) {
        this.hAD = bVar;
    }

    public void setMaskType(int i, Context context) {
        int i2;
        boolean z = false;
        this.hAy.setMaskType(i);
        this.hAy.setVisibility(0);
        this.hAz.setVisibility(0);
        int i3 = R.drawable.bd_ocr_hint_align_id_card;
        this.maskType = i;
        switch (i) {
            case 1:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            case 2:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            default:
                this.hAy.setVisibility(4);
                this.hAz.setVisibility(4);
                z = true;
                i2 = i3;
                break;
        }
        if (z) {
            this.hAz.setImageResource(i2);
            this.hAB.setVisibility(4);
        }
    }

    private String ws(int i) {
        switch (i) {
            case 0:
                return "";
            case 1:
            case 8:
            case 9:
            default:
                return "请将身份证置于取景框内";
            case 2:
                return "身份证模糊，请重新尝试";
            case 3:
                return "身份证反光，请重新尝试";
            case 4:
                return "请将身份证前后反转再进行识别";
            case 5:
                return "请拿稳镜头和身份证";
            case 6:
                return "请将镜头靠近身份证";
            case 7:
                return "请将身份证完整置于取景框内";
            case 10:
                return "本地SO库加载失败";
            case 11:
                return "本地质量控制授权失败";
            case 12:
                return "本地模型加载失败";
        }
    }

    private void init() {
        this.hAx = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.hzD = this.hAx.chK();
        addView(this.hzD);
        this.hAy = new MaskView(getContext());
        addView(this.hAy);
        this.hAz = new ImageView(getContext());
        addView(this.hAz);
        this.hAB = new LinearLayout(getContext());
        this.hAB.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.hAA = new TextView(getContext());
        this.hAA.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.hAA.setAlpha(0.5f);
        this.hAA.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.hAB.addView(this.hAA, layoutParams);
        this.hAA.setGravity(17);
        this.hAA.setTextColor(-1);
        this.hAA.setTextSize(2, 14.0f);
        this.hAA.setText(ws(-1));
        addView(this.hAB, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.hzD.layout(i, 0, i3, i4 - i2);
        this.hAy.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(250);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.hAy.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.hAB.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.hAz.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect chS = this.hAx.chS();
            if (this.hAy.getWidth() == 0 || this.hAy.getHeight() == 0 || chS.width() == 0 || chS.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.hAy.getFrameRect();
            int width2 = (frameRect.left * width) / this.hAy.getWidth();
            int height2 = (frameRect.top * height) / this.hAy.getHeight();
            int width3 = (frameRect.right * width) / this.hAy.getWidth();
            int height3 = (frameRect.bottom * height) / this.hAy.getHeight();
            if (chS.top < 0) {
                int height4 = (chS.height() * getWidth()) / chS.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / chS.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / chS.width()) * height) / chS.height();
                height3 = (height5 * height) / chS.height();
            } else if (chS.left < 0) {
                int width4 = (chS.width() * getHeight()) / chS.height();
                int width5 = (((width4 - this.hAy.getFrameRect().width()) / 2) * getHeight()) / chS.height();
                int width6 = (((width4 + this.hAy.getFrameRect().width()) / 2) * getHeight()) / chS.height();
                width2 = (width5 * width) / chS.width();
                width3 = (width6 * width) / chS.width();
            }
            Rect rect = new Rect();
            rect.left = width2;
            rect.top = height2;
            rect.right = width3;
            rect.bottom = height3;
            if (i % 180 == 90) {
                int width7 = newInstance.getWidth() / 2;
                int height6 = newInstance.getHeight() / 2;
                int height7 = rect.height();
                int width8 = rect.width();
                rect.left = width7 - (height7 / 2);
                rect.top = height6 - (width8 / 2);
                rect.right = width7 + (height7 / 2);
                rect.bottom = (width8 / 2) + height6;
                rect.sort();
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.outWidth = width;
            options.outHeight = height;
            int min = Math.min(Math.min(newInstance.getWidth(), newInstance.getHeight()), 640);
            options.inSampleSize = com.baidu.tieba.barselect.a.c.calculateInSampleSize(options, min, min);
            options.inScaled = true;
            options.inDensity = Math.max(options.outWidth, options.outHeight);
            options.inTargetDensity = min;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
            if (i != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(i);
                Bitmap createBitmap = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix, false);
                if (decodeRegion != createBitmap) {
                    decodeRegion.recycle();
                }
                decodeRegion = createBitmap;
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                decodeRegion.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return decodeRegion;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes21.dex */
    private class a implements d.b {
        private File file;
        private b hAE;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void ac(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hAE.x(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.ad(bArr)));
                }
            });
        }
    }
}
