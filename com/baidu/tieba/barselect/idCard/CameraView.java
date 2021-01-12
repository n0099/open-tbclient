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
/* loaded from: classes7.dex */
public class CameraView extends FrameLayout {
    private final int ilY;
    private int ilZ;
    private View ilh;
    private a ima;
    private d imb;
    private MaskView imc;
    private ImageView imd;
    private TextView ime;
    private LinearLayout imf;
    Handler imh;
    private b imi;
    private int maskType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface b {
        void y(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.ilZ = i;
    }

    public d getCameraControl() {
        return this.imb;
    }

    public void setOrientation(int i) {
        this.imb.setDisplayOrientation(i);
    }

    public CameraView(Context context) {
        super(context);
        this.ilY = 0;
        this.ilZ = 0;
        this.ima = new a();
        this.imh = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ilY = 0;
        this.ilZ = 0;
        this.ima = new a();
        this.imh = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilY = 0;
        this.ilZ = 0;
        this.ima = new a();
        this.imh = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.imb.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.imb.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.ima.file = file;
        this.ima.imj = bVar;
        this.imb.a(this.ima);
    }

    public void setAutoPictureCallback(b bVar) {
        this.imi = bVar;
    }

    public void setMaskType(int i, Context context) {
        boolean z = false;
        this.imc.setMaskType(i);
        this.imc.setVisibility(0);
        this.imd.setVisibility(0);
        int i2 = R.drawable.bd_ocr_hint_align_id_card;
        this.maskType = i;
        switch (i) {
            case 1:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            case 2:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            default:
                this.imc.setVisibility(4);
                this.imd.setVisibility(4);
                z = true;
                break;
        }
        if (z) {
            this.imd.setImageResource(i2);
            this.imf.setVisibility(4);
        }
    }

    private String wI(int i) {
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
        this.imb = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.ilh = this.imb.cqk();
        addView(this.ilh);
        this.imc = new MaskView(getContext());
        addView(this.imc);
        this.imd = new ImageView(getContext());
        addView(this.imd);
        this.imf = new LinearLayout(getContext());
        this.imf.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.ime = new TextView(getContext());
        this.ime.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.ime.setAlpha(0.5f);
        this.ime.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.imf.addView(this.ime, layoutParams);
        this.ime.setGravity(17);
        this.ime.setTextColor(-1);
        this.ime.setTextSize(2, 14.0f);
        this.ime.setText(wI(-1));
        addView(this.imf, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.ilh.layout(i, 0, i3, i4 - i2);
        this.imc.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(250);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.imc.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.imf.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.imd.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect cqs = this.imb.cqs();
            if (this.imc.getWidth() == 0 || this.imc.getHeight() == 0 || cqs.width() == 0 || cqs.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.imc.getFrameRect();
            int width2 = (frameRect.left * width) / this.imc.getWidth();
            int height2 = (frameRect.top * height) / this.imc.getHeight();
            int width3 = (frameRect.right * width) / this.imc.getWidth();
            int height3 = (frameRect.bottom * height) / this.imc.getHeight();
            if (cqs.top < 0) {
                int height4 = (cqs.height() * getWidth()) / cqs.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / cqs.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / cqs.width()) * height) / cqs.height();
                height3 = (height5 * height) / cqs.height();
            } else if (cqs.left < 0) {
                int width4 = (cqs.width() * getHeight()) / cqs.height();
                int width5 = (((width4 - this.imc.getFrameRect().width()) / 2) * getHeight()) / cqs.height();
                int width6 = (((width4 + this.imc.getFrameRect().width()) / 2) * getHeight()) / cqs.height();
                width2 = (width5 * width) / cqs.width();
                width3 = (width6 * width) / cqs.width();
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

    /* loaded from: classes7.dex */
    private class a implements d.b {
        private File file;
        private b imj;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void aa(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.imj.y(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.ab(bArr)));
                }
            });
        }
    }
}
