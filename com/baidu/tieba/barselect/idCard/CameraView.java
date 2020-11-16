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
/* loaded from: classes20.dex */
public class CameraView extends FrameLayout {
    private View hSw;
    private final int hTn;
    private int hTo;
    private a hTp;
    private d hTq;
    private MaskView hTr;
    private ImageView hTs;
    private TextView hTt;
    private LinearLayout hTu;
    Handler hTv;
    private b hTw;
    private int maskType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public interface b {
        void x(Bitmap bitmap);
    }

    public void setInitNativeStatus(int i) {
        this.hTo = i;
    }

    public d getCameraControl() {
        return this.hTq;
    }

    public void setOrientation(int i) {
        this.hTq.xt(i);
    }

    public CameraView(Context context) {
        super(context);
        this.hTn = 0;
        this.hTo = 0;
        this.hTp = new a();
        this.hTv = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hTn = 0;
        this.hTo = 0;
        this.hTp = new a();
        this.hTv = new Handler(Looper.getMainLooper());
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTn = 0;
        this.hTo = 0;
        this.hTp = new a();
        this.hTv = new Handler(Looper.getMainLooper());
        init();
    }

    public void start() {
        this.hTq.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.hTq.stop();
        setKeepScreenOn(false);
    }

    public void a(File file, b bVar) {
        this.hTp.file = file;
        this.hTp.hTx = bVar;
        this.hTq.a(this.hTp);
    }

    public void setAutoPictureCallback(b bVar) {
        this.hTw = bVar;
    }

    public void setMaskType(int i, Context context) {
        int i2;
        boolean z = false;
        this.hTr.setMaskType(i);
        this.hTr.setVisibility(0);
        this.hTs.setVisibility(0);
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
                this.hTr.setVisibility(4);
                this.hTs.setVisibility(4);
                z = true;
                i2 = i3;
                break;
        }
        if (z) {
            this.hTs.setImageResource(i2);
            this.hTu.setVisibility(4);
        }
    }

    private String xw(int i) {
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
        this.hTq = new com.baidu.tieba.barselect.idCard.b(getContext());
        this.hSw = this.hTq.cmU();
        addView(this.hSw);
        this.hTr = new MaskView(getContext());
        addView(this.hTr);
        this.hTs = new ImageView(getContext());
        addView(this.hTs);
        this.hTu = new LinearLayout(getContext());
        this.hTu.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.tieba.barselect.a.b.dpToPx(25));
        layoutParams.gravity = 17;
        this.hTt = new TextView(getContext());
        this.hTt.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.hTt.setAlpha(0.5f);
        this.hTt.setPadding(com.baidu.tieba.barselect.a.b.dpToPx(10), 0, com.baidu.tieba.barselect.a.b.dpToPx(10), 0);
        this.hTu.addView(this.hTt, layoutParams);
        this.hTt.setGravity(17);
        this.hTt.setTextColor(-1);
        this.hTt.setTextSize(2, 14.0f);
        this.hTt.setText(xw(-1));
        addView(this.hTu, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.hSw.layout(i, 0, i3, i4 - i2);
        this.hTr.layout(i, 0, i3, i4 - i2);
        int dpToPx = com.baidu.tieba.barselect.a.b.dpToPx(250);
        int dpToPx2 = com.baidu.tieba.barselect.a.b.dpToPx(25);
        int width = (getWidth() - dpToPx) / 2;
        int dpToPx3 = this.hTr.getFrameRect().bottom + com.baidu.tieba.barselect.a.b.dpToPx(16);
        this.hTu.layout(width, dpToPx3, width + dpToPx, dpToPx3 + dpToPx2);
        this.hTs.layout(width, dpToPx3, dpToPx + width, dpToPx2 + dpToPx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(File file, byte[] bArr, int i) {
        try {
            Rect cnc = this.hTq.cnc();
            if (this.hTr.getWidth() == 0 || this.hTr.getHeight() == 0 || cnc.width() == 0 || cnc.height() == 0) {
                return null;
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
            int width = i % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.hTr.getFrameRect();
            int width2 = (frameRect.left * width) / this.hTr.getWidth();
            int height2 = (frameRect.top * height) / this.hTr.getHeight();
            int width3 = (frameRect.right * width) / this.hTr.getWidth();
            int height3 = (frameRect.bottom * height) / this.hTr.getHeight();
            if (cnc.top < 0) {
                int height4 = (cnc.height() * getWidth()) / cnc.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / cnc.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / cnc.width()) * height) / cnc.height();
                height3 = (height5 * height) / cnc.height();
            } else if (cnc.left < 0) {
                int width4 = (cnc.width() * getHeight()) / cnc.height();
                int width5 = (((width4 - this.hTr.getFrameRect().width()) / 2) * getHeight()) / cnc.height();
                int width6 = (((width4 + this.hTr.getFrameRect().width()) / 2) * getHeight()) / cnc.height();
                width2 = (width5 * width) / cnc.width();
                width3 = (width6 * width) / cnc.width();
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

    /* loaded from: classes20.dex */
    private class a implements d.b {
        private File file;
        private b hTx;

        private a() {
        }

        @Override // com.baidu.tieba.barselect.idCard.d.b
        public void ac(final byte[] bArr) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hTx.x(CameraView.this.a(a.this.file, bArr, com.baidu.tieba.barselect.a.c.ad(bArr)));
                }
            });
        }
    }
}
