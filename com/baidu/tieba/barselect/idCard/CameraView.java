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
import d.b.i0.v.c.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
public class CameraView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f15157e;

    /* renamed from: f  reason: collision with root package name */
    public d f15158f;

    /* renamed from: g  reason: collision with root package name */
    public View f15159g;

    /* renamed from: h  reason: collision with root package name */
    public MaskView f15160h;
    public ImageView i;
    public TextView j;
    public LinearLayout k;

    /* loaded from: classes4.dex */
    public class b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        public File f15161a;

        /* renamed from: b  reason: collision with root package name */
        public c f15162b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f15164e;

            public a(byte[] bArr) {
                this.f15164e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                int c2 = d.b.i0.v.e.c.c(this.f15164e);
                b bVar = b.this;
                b.this.f15162b.a(CameraView.this.b(bVar.f15161a, this.f15164e, c2));
            }
        }

        public b() {
        }

        @Override // d.b.i0.v.c.d.b
        public void a(byte[] bArr) {
            d.b.i0.v.c.c.c(new a(bArr));
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    public CameraView(Context context) {
        super(context);
        this.f15157e = new b();
        new Handler(Looper.getMainLooper());
        d();
    }

    public final Bitmap b(File file, byte[] bArr, int i) {
        try {
            Rect i2 = this.f15158f.i();
            if (this.f15160h.getWidth() != 0 && this.f15160h.getHeight() != 0 && i2.width() != 0 && i2.height() != 0) {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
                int width = i % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
                int height = i % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
                Rect frameRect = this.f15160h.getFrameRect();
                int width2 = (frameRect.left * width) / this.f15160h.getWidth();
                int height2 = (frameRect.top * height) / this.f15160h.getHeight();
                int width3 = (frameRect.right * width) / this.f15160h.getWidth();
                int height3 = (frameRect.bottom * height) / this.f15160h.getHeight();
                if (i2.top < 0) {
                    int height4 = (i2.height() * getWidth()) / i2.width();
                    int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / i2.width();
                    int height6 = (((((height4 - frameRect.height()) / 2) * getWidth()) / i2.width()) * height) / i2.height();
                    height3 = (height5 * height) / i2.height();
                    height2 = height6;
                } else if (i2.left < 0) {
                    int width4 = (i2.width() * getHeight()) / i2.height();
                    int width5 = (((width4 - this.f15160h.getFrameRect().width()) / 2) * getHeight()) / i2.height();
                    int width6 = (((width4 + this.f15160h.getFrameRect().width()) / 2) * getHeight()) / i2.height();
                    width2 = (width5 * width) / i2.width();
                    width3 = (width6 * width) / i2.width();
                }
                Rect rect = new Rect();
                rect.left = width2;
                rect.top = height2;
                rect.right = width3;
                rect.bottom = height3;
                if (i % 180 == 90) {
                    int width7 = newInstance.getWidth() / 2;
                    int height7 = newInstance.getHeight() / 2;
                    int height8 = rect.height();
                    int width8 = rect.width();
                    rect.left = width7 - (height8 / 2);
                    rect.top = height7 - (width8 / 2);
                    rect.right = width7 + (height8 / 2);
                    rect.bottom = height7 + (width8 / 2);
                    rect.sort();
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.outWidth = width;
                options.outHeight = height;
                int min = Math.min(Math.min(newInstance.getWidth(), newInstance.getHeight()), 640);
                options.inSampleSize = d.b.i0.v.e.c.a(options, min, min);
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
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public final String c(int i) {
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

    public final void d() {
        d.b.i0.v.c.b bVar = new d.b.i0.v.c.b(getContext());
        this.f15158f = bVar;
        View d2 = bVar.d();
        this.f15159g = d2;
        addView(d2);
        MaskView maskView = new MaskView(getContext());
        this.f15160h = maskView;
        addView(maskView);
        ImageView imageView = new ImageView(getContext());
        this.i = imageView;
        addView(imageView);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.k = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, d.b.i0.v.e.b.a(25));
        layoutParams.gravity = 17;
        TextView textView = new TextView(getContext());
        this.j = textView;
        textView.setBackgroundResource(R.drawable.bd_ocr_round_corner);
        this.j.setAlpha(0.5f);
        this.j.setPadding(d.b.i0.v.e.b.a(10), 0, d.b.i0.v.e.b.a(10), 0);
        this.k.addView(this.j, layoutParams);
        this.j.setGravity(17);
        this.j.setTextColor(-1);
        this.j.setTextSize(2, 14.0f);
        this.j.setText(c(-1));
        addView(this.k, layoutParams);
    }

    public void e() {
        this.f15158f.start();
        setKeepScreenOn(true);
    }

    public void f() {
        this.f15158f.stop();
        setKeepScreenOn(false);
    }

    public void g(File file, c cVar) {
        this.f15157e.f15161a = file;
        this.f15157e.f15162b = cVar;
        this.f15158f.e(this.f15157e);
    }

    public d getCameraControl() {
        return this.f15158f;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i4 - i2;
        this.f15159g.layout(i, 0, i3, i5);
        this.f15160h.layout(i, 0, i3, i5);
        int a2 = d.b.i0.v.e.b.a(250);
        int a3 = d.b.i0.v.e.b.a(25);
        int width = (getWidth() - a2) / 2;
        int a4 = this.f15160h.getFrameRect().bottom + d.b.i0.v.e.b.a(16);
        int i6 = a2 + width;
        int i7 = a3 + a4;
        this.k.layout(width, a4, i6, i7);
        this.i.layout(width, a4, i6, i7);
    }

    public void setAutoPictureCallback(c cVar) {
    }

    public void setInitNativeStatus(int i) {
    }

    public void setMaskType(int i, Context context) {
        this.f15160h.setMaskType(i);
        boolean z = false;
        this.f15160h.setVisibility(0);
        this.i.setVisibility(0);
        int i2 = R.drawable.bd_ocr_hint_align_id_card;
        if (i == 1) {
            i2 = R.drawable.bd_ocr_round_corner;
        } else if (i != 2) {
            this.f15160h.setVisibility(4);
            this.i.setVisibility(4);
            z = true;
        } else {
            i2 = R.drawable.bd_ocr_round_corner;
        }
        if (z) {
            this.i.setImageResource(i2);
            this.k.setVisibility(4);
        }
    }

    public void setOrientation(int i) {
        this.f15158f.f(i);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15157e = new b();
        new Handler(Looper.getMainLooper());
        d();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15157e = new b();
        new Handler(Looper.getMainLooper());
        d();
    }
}
