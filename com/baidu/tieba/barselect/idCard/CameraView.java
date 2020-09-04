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
/* loaded from: classes15.dex */
public class CameraView extends FrameLayout {
    private View hdH;
    private a heA;
    private d heB;
    private MaskView heC;
    private ImageView heD;
    private TextView heE;
    private LinearLayout heF;
    Handler heG;
    private b heH;
    private final int hey;
    private int hez;
    private int maskType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public interface b {
        void x(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.hez = i;
    }

    public d getCameraControl() {
        return this.heB;
    }

    public void setOrientation(int i) {
        this.heB.vk(i);
    }

    public CameraView(Context context) {
        super(context);
        this.hey = 0;
        this.hez = 0;
        this.heA = new a();
        this.heG = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hey = 0;
        this.hez = 0;
        this.heA = new a();
        this.heG = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hey = 0;
        this.hez = 0;
        this.heA = new a();
        this.heG = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.heB.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.heB.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.heA.file = file;
        this.heA.heI = bVar;
        this.heB.a(this.heA);
    }

    public void setAutoPictureCallback(b bVar) {
        this.heH = bVar;
    }

    public void setMaskType(int i, Context context) {
        int i2;
        boolean z = false;
        this.heC.setMaskType(i);
        this.heC.setVisibility(0);
        this.heD.setVisibility(0);
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
                this.heC.setVisibility(4);
                this.heD.setVisibility(4);
                z = true;
                i2 = i3;
                break;
        }
        if (z) {
            this.heD.setImageResource(i2);
            this.heF.setVisibility(4);
        }
    }

    private String vn(int i) {
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
        this.heB = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.hdH = this.heB.caZ();
        addView(this.hdH);
        this.heC = new MaskView(getContext());
        addView(this.heC);
        this.heD = new ImageView(getContext());
        addView(this.heD);
        this.heF = new LinearLayout(getContext());
        this.heF.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.heE = new TextView(getContext());
        this.heE.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.heE.setAlpha(0.5f);
        this.heE.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.heF.addView(this.heE, layoutParams);
        this.heE.setGravity(17);
        this.heE.setTextColor(-1);
        this.heE.setTextSize(2, 14.0f);
        this.heE.setText(vn(-1));
        addView(this.heF, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.hdH.layout(i, 0, i3, i4 - i2);
        this.heC.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(250);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.heC.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.heF.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.heD.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect cbh = this.heB.cbh();
            if (this.heC.getWidth() == 0 || this.heC.getHeight() == 0 || cbh.width() == 0 || cbh.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.heC.getFrameRect();
            int width2 = (frameRect.left * width) / this.heC.getWidth();
            int height2 = (frameRect.top * height) / this.heC.getHeight();
            int width3 = (frameRect.right * width) / this.heC.getWidth();
            int height3 = (frameRect.bottom * height) / this.heC.getHeight();
            if (cbh.top < 0) {
                int height4 = (cbh.height() * getWidth()) / cbh.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / cbh.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / cbh.width()) * height) / cbh.height();
                height3 = (height5 * height) / cbh.height();
            } else if (cbh.left < 0) {
                int width4 = (cbh.width() * getHeight()) / cbh.height();
                int width5 = (((width4 - this.heC.getFrameRect().width()) / 2) * getHeight()) / cbh.height();
                int width6 = (((width4 + this.heC.getFrameRect().width()) / 2) * getHeight()) / cbh.height();
                width2 = (width5 * width) / cbh.width();
                width3 = (width6 * width) / cbh.width();
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

    /* loaded from: classes15.dex */
    private class a implements d.b {
        private File file;
        private b heI;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void ac(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.heI.x(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.ad(bArr)));
                }
            });
        }
    }
}
