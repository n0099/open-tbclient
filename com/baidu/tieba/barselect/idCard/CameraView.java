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
    private View ewv;
    private final int exn;
    private int exo;
    private a exp;
    private d exq;
    private MaskView exr;
    private ImageView exs;
    private TextView exu;
    private LinearLayout exv;
    private b exw;
    private int maskType;
    Handler uiHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void t(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.exo = i;
    }

    public d getCameraControl() {
        return this.exq;
    }

    public void setOrientation(int i) {
        this.exq.setDisplayOrientation(i);
    }

    public CameraView(Context context) {
        super(context);
        this.exn = 0;
        this.exo = 0;
        this.exp = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exn = 0;
        this.exo = 0;
        this.exp = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.exn = 0;
        this.exo = 0;
        this.exp = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.exq.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.exq.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.exp.file = file;
        this.exp.exx = bVar;
        this.exq.a(this.exp);
    }

    public void setAutoPictureCallback(b bVar) {
        this.exw = bVar;
    }

    public void setMaskType(@MaskView.MaskType int i, Context context) {
        int i2;
        boolean z = false;
        this.exr.setMaskType(i);
        this.exr.setVisibility(0);
        this.exs.setVisibility(0);
        this.maskType = i;
        switch (i) {
            case 1:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            case 2:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            default:
                this.exr.setVisibility(4);
                this.exs.setVisibility(4);
                z = true;
                i2 = R.drawable.bd_ocr_hint_align_id_card;
                break;
        }
        if (z) {
            this.exs.setImageResource(i2);
            this.exv.setVisibility(4);
        }
    }

    private String px(int i) {
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
        this.exq = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.ewv = this.exq.aYT();
        addView(this.ewv);
        this.exr = new MaskView(getContext());
        addView(this.exr);
        this.exs = new ImageView(getContext());
        addView(this.exs);
        this.exv = new LinearLayout(getContext());
        this.exv.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.exu = new TextView(getContext());
        this.exu.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.exu.setAlpha(0.5f);
        this.exu.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.exv.addView(this.exu, layoutParams);
        this.exu.setGravity(17);
        this.exu.setTextColor(-1);
        this.exu.setTextSize(2, 14.0f);
        this.exu.setText(px(-1));
        addView(this.exv, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.ewv.layout(i, 0, i3, i4 - i2);
        this.exr.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.exr.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.exv.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.exs.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect aZb = this.exq.aZb();
            if (this.exr.getWidth() == 0 || this.exr.getHeight() == 0 || aZb.width() == 0 || aZb.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % SubsamplingScaleImageView.ORIENTATION_180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % SubsamplingScaleImageView.ORIENTATION_180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.exr.getFrameRect();
            int width2 = (frameRect.left * width) / this.exr.getWidth();
            int height2 = (frameRect.top * height) / this.exr.getHeight();
            int width3 = (frameRect.right * width) / this.exr.getWidth();
            int height3 = (frameRect.bottom * height) / this.exr.getHeight();
            if (aZb.top < 0) {
                int height4 = (aZb.height() * getWidth()) / aZb.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / aZb.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / aZb.width()) * height) / aZb.height();
                height3 = (height5 * height) / aZb.height();
            } else if (aZb.left < 0) {
                int width4 = (aZb.width() * getHeight()) / aZb.height();
                int width5 = (((width4 - this.exr.getFrameRect().width()) / 2) * getHeight()) / aZb.height();
                int width6 = (((width4 + this.exr.getFrameRect().width()) / 2) * getHeight()) / aZb.height();
                width2 = (width5 * width) / aZb.width();
                width3 = (width6 * width) / aZb.width();
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
        private b exx;
        private File file;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void M(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.exx.t(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.N(bArr)));
                }
            });
        }
    }
}
