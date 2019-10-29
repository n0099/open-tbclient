package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.idCard.MaskView;
import com.baidu.tieba.barselect.idCard.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class CameraView extends FrameLayout {
    private View eGV;
    private final int eHN;
    private int eHO;
    private a eHP;
    private d eHQ;
    private MaskView eHR;
    private ImageView eHS;
    private TextView eHT;
    private LinearLayout eHU;
    private b eHV;
    private int maskType;
    Handler uiHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void r(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.eHO = i;
    }

    public d getCameraControl() {
        return this.eHQ;
    }

    public void setOrientation(int i) {
        this.eHQ.setDisplayOrientation(i);
    }

    public CameraView(Context context) {
        super(context);
        this.eHN = 0;
        this.eHO = 0;
        this.eHP = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHN = 0;
        this.eHO = 0;
        this.eHP = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHN = 0;
        this.eHO = 0;
        this.eHP = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.eHQ.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.eHQ.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.eHP.file = file;
        this.eHP.eHW = bVar;
        this.eHQ.a(this.eHP);
    }

    public void setAutoPictureCallback(b bVar) {
        this.eHV = bVar;
    }

    public void setMaskType(@MaskView.MaskType int i, Context context) {
        int i2;
        boolean z = false;
        this.eHR.setMaskType(i);
        this.eHR.setVisibility(0);
        this.eHS.setVisibility(0);
        this.maskType = i;
        switch (i) {
            case 1:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            case 2:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            default:
                this.eHR.setVisibility(4);
                this.eHS.setVisibility(4);
                z = true;
                i2 = R.drawable.bd_ocr_hint_align_id_card;
                break;
        }
        if (z) {
            this.eHS.setImageResource(i2);
            this.eHU.setVisibility(4);
        }
    }

    private String oE(int i) {
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
        this.eHQ = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.eGV = this.eHQ.aZC();
        addView(this.eGV);
        this.eHR = new MaskView(getContext());
        addView(this.eHR);
        this.eHS = new ImageView(getContext());
        addView(this.eHS);
        this.eHU = new LinearLayout(getContext());
        this.eHU.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.eHT = new TextView(getContext());
        this.eHT.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.eHT.setAlpha(0.5f);
        this.eHT.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.eHU.addView(this.eHT, layoutParams);
        this.eHT.setGravity(17);
        this.eHT.setTextColor(-1);
        this.eHT.setTextSize(2, 14.0f);
        this.eHT.setText(oE(-1));
        addView(this.eHU, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.eGV.layout(i, 0, i3, i4 - i2);
        this.eHR.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.eHR.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.eHU.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.eHS.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect aZK = this.eHQ.aZK();
            if (this.eHR.getWidth() == 0 || this.eHR.getHeight() == 0 || aZK.width() == 0 || aZK.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % SubsamplingScaleImageView.ORIENTATION_180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % SubsamplingScaleImageView.ORIENTATION_180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.eHR.getFrameRect();
            int width2 = (frameRect.left * width) / this.eHR.getWidth();
            int height2 = (frameRect.top * height) / this.eHR.getHeight();
            int width3 = (frameRect.right * width) / this.eHR.getWidth();
            int height3 = (frameRect.bottom * height) / this.eHR.getHeight();
            if (aZK.top < 0) {
                int height4 = (aZK.height() * getWidth()) / aZK.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / aZK.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / aZK.width()) * height) / aZK.height();
                height3 = (height5 * height) / aZK.height();
            } else if (aZK.left < 0) {
                int width4 = (aZK.width() * getHeight()) / aZK.height();
                int width5 = (((width4 - this.eHR.getFrameRect().width()) / 2) * getHeight()) / aZK.height();
                int width6 = (((width4 + this.eHR.getFrameRect().width()) / 2) * getHeight()) / aZK.height();
                width2 = (width5 * width) / aZK.width();
                width3 = (width6 * width) / aZK.width();
            }
            Rect rect = new Rect();
            rect.left = width2;
            rect.top = height2;
            rect.right = width3;
            rect.bottom = height3;
            if (i % SubsamplingScaleImageView.ORIENTATION_180 == 90) {
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

    /* loaded from: classes3.dex */
    private class a implements d.b {
        private b eHW;
        private File file;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void A(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eHW.r(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.B(bArr)));
                }
            });
        }
    }
}
