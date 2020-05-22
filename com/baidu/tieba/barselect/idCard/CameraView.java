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
    private final int gyZ;
    private View gyj;
    private int gza;
    private a gzb;
    private d gzc;
    private MaskView gzd;
    private ImageView gze;
    private TextView gzf;
    private LinearLayout gzg;
    private b gzh;
    private int maskType;
    Handler uiHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface b {
        void t(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.gza = i;
    }

    public d getCameraControl() {
        return this.gzc;
    }

    public void setOrientation(int i) {
        this.gzc.setDisplayOrientation(i);
    }

    public CameraView(Context context) {
        super(context);
        this.gyZ = 0;
        this.gza = 0;
        this.gzb = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gyZ = 0;
        this.gza = 0;
        this.gzb = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gyZ = 0;
        this.gza = 0;
        this.gzb = new a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.gzc.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.gzc.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.gzb.file = file;
        this.gzb.gzi = bVar;
        this.gzc.a(this.gzb);
    }

    public void setAutoPictureCallback(b bVar) {
        this.gzh = bVar;
    }

    public void setMaskType(@MaskView.MaskType int i, Context context) {
        int i2;
        boolean z = false;
        this.gzd.setMaskType(i);
        this.gzd.setVisibility(0);
        this.gze.setVisibility(0);
        this.maskType = i;
        switch (i) {
            case 1:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            case 2:
                i2 = R.drawable.bd_ocr_round_corner;
                break;
            default:
                this.gzd.setVisibility(4);
                this.gze.setVisibility(4);
                z = true;
                i2 = R.drawable.bd_ocr_hint_align_id_card;
                break;
        }
        if (z) {
            this.gze.setImageResource(i2);
            this.gzg.setVisibility(4);
        }
    }

    private String sg(int i) {
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
        this.gzc = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.gyj = this.gzc.bKt();
        addView(this.gyj);
        this.gzd = new MaskView(getContext());
        addView(this.gzd);
        this.gze = new ImageView(getContext());
        addView(this.gze);
        this.gzg = new LinearLayout(getContext());
        this.gzg.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.gzf = new TextView(getContext());
        this.gzf.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.gzf.setAlpha(0.5f);
        this.gzf.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.gzg.addView(this.gzf, layoutParams);
        this.gzf.setGravity(17);
        this.gzf.setTextColor(-1);
        this.gzf.setTextSize(2, 14.0f);
        this.gzf.setText(sg(-1));
        addView(this.gzg, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.gyj.layout(i, 0, i3, i4 - i2);
        this.gzd.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(250);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.gzd.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.gzg.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.gze.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect bKB = this.gzc.bKB();
            if (this.gzd.getWidth() == 0 || this.gzd.getHeight() == 0 || bKB.width() == 0 || bKB.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.gzd.getFrameRect();
            int width2 = (frameRect.left * width) / this.gzd.getWidth();
            int height2 = (frameRect.top * height) / this.gzd.getHeight();
            int width3 = (frameRect.right * width) / this.gzd.getWidth();
            int height3 = (frameRect.bottom * height) / this.gzd.getHeight();
            if (bKB.top < 0) {
                int height4 = (bKB.height() * getWidth()) / bKB.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / bKB.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / bKB.width()) * height) / bKB.height();
                height3 = (height5 * height) / bKB.height();
            } else if (bKB.left < 0) {
                int width4 = (bKB.width() * getHeight()) / bKB.height();
                int width5 = (((width4 - this.gzd.getFrameRect().width()) / 2) * getHeight()) / bKB.height();
                int width6 = (((width4 + this.gzd.getFrameRect().width()) / 2) * getHeight()) / bKB.height();
                width2 = (width5 * width) / bKB.width();
                width3 = (width6 * width) / bKB.width();
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
        private b gzi;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void Z(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gzi.t(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.aa(bArr)));
                }
            });
        }
    }
}
