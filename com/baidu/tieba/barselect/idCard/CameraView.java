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
    private View eyn;
    private final int ezf;
    private int ezg;
    private a ezh;
    private d ezi;
    private MaskView ezj;
    private ImageView ezk;
    private TextView ezl;
    private LinearLayout ezm;
    private b ezn;
    private int maskType;
    Handler uiHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void t(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.ezg = i;
    }

    public d getCameraControl() {
        return this.ezi;
    }

    public void setOrientation(int i) {
        this.ezi.setDisplayOrientation(i);
    }

    public CameraView(Context context) {
        super(context);
        this.ezf = 0;
        this.ezg = 0;
        this.ezh = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezf = 0;
        this.ezg = 0;
        this.ezh = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ezf = 0;
        this.ezg = 0;
        this.ezh = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.ezi.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.ezi.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.ezh.file = file;
        this.ezh.ezo = bVar;
        this.ezi.a(this.ezh);
    }

    public void setAutoPictureCallback(b bVar) {
        this.ezn = bVar;
    }

    public void setMaskType(@MaskView.MaskType int i, Context context) {
        int i2;
        boolean z = false;
        this.ezj.setMaskType(i);
        this.ezj.setVisibility(0);
        this.ezk.setVisibility(0);
        this.maskType = i;
        switch (i) {
            case 1:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            case 2:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            default:
                this.ezj.setVisibility(4);
                this.ezk.setVisibility(4);
                z = true;
                i2 = R.drawable.bd_ocr_hint_align_id_card;
                break;
        }
        if (z) {
            this.ezk.setImageResource(i2);
            this.ezm.setVisibility(4);
        }
    }

    private String pC(int i) {
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
        this.ezi = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.eyn = this.ezi.aZz();
        addView(this.eyn);
        this.ezj = new MaskView(getContext());
        addView(this.ezj);
        this.ezk = new ImageView(getContext());
        addView(this.ezk);
        this.ezm = new LinearLayout(getContext());
        this.ezm.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.ezl = new TextView(getContext());
        this.ezl.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.ezl.setAlpha(0.5f);
        this.ezl.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.ezm.addView(this.ezl, layoutParams);
        this.ezl.setGravity(17);
        this.ezl.setTextColor(-1);
        this.ezl.setTextSize(2, 14.0f);
        this.ezl.setText(pC(-1));
        addView(this.ezm, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.eyn.layout(i, 0, i3, i4 - i2);
        this.ezj.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.ezj.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.ezm.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.ezk.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect aZH = this.ezi.aZH();
            if (this.ezj.getWidth() == 0 || this.ezj.getHeight() == 0 || aZH.width() == 0 || aZH.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % SubsamplingScaleImageView.ORIENTATION_180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % SubsamplingScaleImageView.ORIENTATION_180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.ezj.getFrameRect();
            int width2 = (frameRect.left * width) / this.ezj.getWidth();
            int height2 = (frameRect.top * height) / this.ezj.getHeight();
            int width3 = (frameRect.right * width) / this.ezj.getWidth();
            int height3 = (frameRect.bottom * height) / this.ezj.getHeight();
            if (aZH.top < 0) {
                int height4 = (aZH.height() * getWidth()) / aZH.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / aZH.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / aZH.width()) * height) / aZH.height();
                height3 = (height5 * height) / aZH.height();
            } else if (aZH.left < 0) {
                int width4 = (aZH.width() * getHeight()) / aZH.height();
                int width5 = (((width4 - this.ezj.getFrameRect().width()) / 2) * getHeight()) / aZH.height();
                int width6 = (((width4 + this.ezj.getFrameRect().width()) / 2) * getHeight()) / aZH.height();
                width2 = (width5 * width) / aZH.width();
                width3 = (width6 * width) / aZH.width();
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
        private b ezo;
        private File file;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void M(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ezo.t(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.N(bArr)));
                }
            });
        }
    }
}
