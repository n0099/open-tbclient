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
import com.baidu.tieba.barselect.idCard.MaskView;
import com.baidu.tieba.barselect.idCard.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public class CameraView extends FrameLayout {
    private View gjt;
    private final int gkj;
    private int gkk;
    private a gkl;
    private d gkm;
    private MaskView gkn;
    private ImageView gko;
    private TextView gkp;
    private LinearLayout gkq;
    private b gkr;
    private int maskType;
    Handler uiHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface b {
        void t(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.gkk = i;
    }

    public d getCameraControl() {
        return this.gkm;
    }

    public void setOrientation(int i) {
        this.gkm.setDisplayOrientation(i);
    }

    public CameraView(Context context) {
        super(context);
        this.gkj = 0;
        this.gkk = 0;
        this.gkl = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkj = 0;
        this.gkk = 0;
        this.gkl = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkj = 0;
        this.gkk = 0;
        this.gkl = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.gkm.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.gkm.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.gkl.file = file;
        this.gkl.gks = bVar;
        this.gkm.a(this.gkl);
    }

    public void setAutoPictureCallback(b bVar) {
        this.gkr = bVar;
    }

    public void setMaskType(@MaskView.MaskType int i, Context context) {
        int i2;
        boolean z = false;
        this.gkn.setMaskType(i);
        this.gkn.setVisibility(0);
        this.gko.setVisibility(0);
        this.maskType = i;
        switch (i) {
            case 1:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            case 2:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            default:
                this.gkn.setVisibility(4);
                this.gko.setVisibility(4);
                z = true;
                i2 = R.drawable.bd_ocr_hint_align_id_card;
                break;
        }
        if (z) {
            this.gko.setImageResource(i2);
            this.gkq.setVisibility(4);
        }
    }

    private String rD(int i) {
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
        this.gkm = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.gjt = this.gkm.bEc();
        addView(this.gjt);
        this.gkn = new MaskView(getContext());
        addView(this.gkn);
        this.gko = new ImageView(getContext());
        addView(this.gko);
        this.gkq = new LinearLayout(getContext());
        this.gkq.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.gkp = new TextView(getContext());
        this.gkp.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.gkp.setAlpha(0.5f);
        this.gkp.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.gkq.addView(this.gkp, layoutParams);
        this.gkp.setGravity(17);
        this.gkp.setTextColor(-1);
        this.gkp.setTextSize(2, 14.0f);
        this.gkp.setText(rD(-1));
        addView(this.gkq, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.gjt.layout(i, 0, i3, i4 - i2);
        this.gkn.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(250);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.gkn.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.gkq.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.gko.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect bEk = this.gkm.bEk();
            if (this.gkn.getWidth() == 0 || this.gkn.getHeight() == 0 || bEk.width() == 0 || bEk.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.gkn.getFrameRect();
            int width2 = (frameRect.left * width) / this.gkn.getWidth();
            int height2 = (frameRect.top * height) / this.gkn.getHeight();
            int width3 = (frameRect.right * width) / this.gkn.getWidth();
            int height3 = (frameRect.bottom * height) / this.gkn.getHeight();
            if (bEk.top < 0) {
                int height4 = (bEk.height() * getWidth()) / bEk.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / bEk.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / bEk.width()) * height) / bEk.height();
                height3 = (height5 * height) / bEk.height();
            } else if (bEk.left < 0) {
                int width4 = (bEk.width() * getHeight()) / bEk.height();
                int width5 = (((width4 - this.gkn.getFrameRect().width()) / 2) * getHeight()) / bEk.height();
                int width6 = (((width4 + this.gkn.getFrameRect().width()) / 2) * getHeight()) / bEk.height();
                width2 = (width5 * width) / bEk.width();
                width3 = (width6 * width) / bEk.width();
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

    /* loaded from: classes8.dex */
    private class a implements d.b {
        private File file;
        private b gks;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void S(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gks.t(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.T(bArr)));
                }
            });
        }
    }
}
