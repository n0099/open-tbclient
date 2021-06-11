package com.baidu.tieba.faceshop.emotiondetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
import d.a.c.e.l.c;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class EmotionDetailImageView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final float f14914h = l.h(TbadkCoreApplication.getInst());

    /* renamed from: e  reason: collision with root package name */
    public ImageView f14915e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f14916f;

    /* renamed from: g  reason: collision with root package name */
    public int f14917g;

    /* loaded from: classes4.dex */
    public class a extends c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionDetailData f14918a;

        public a(EmotionDetailData emotionDetailData) {
            this.f14918a = emotionDetailData;
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            EmotionDetailImageView.this.f14916f.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            EmotionDetailImageView.this.f14916f.setVisibility(8);
            if (aVar != null) {
                EmotionDetailImageView.this.f14915e = new TbMemeImageView(EmotionDetailImageView.this.getContext());
                ((TbMemeImageView) EmotionDetailImageView.this.f14915e).g(aVar);
                EmotionDetailImageView emotionDetailImageView = EmotionDetailImageView.this;
                ImageView imageView = emotionDetailImageView.f14915e;
                EmotionDetailData.PicInfo picInfo = this.f14918a.pic_info;
                emotionDetailImageView.g(imageView, picInfo.width, picInfo.height, 200, 200);
                EmotionDetailImageView emotionDetailImageView2 = EmotionDetailImageView.this;
                emotionDetailImageView2.addView(emotionDetailImageView2.f14915e);
            }
        }
    }

    public EmotionDetailImageView(Context context) {
        super(context);
        this.f14916f = null;
        e();
    }

    public final void e() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        ProgressBar progressBar = new ProgressBar(getContext(), null, 16843399);
        this.f14916f = progressBar;
        progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        layoutParams.gravity = 17;
        this.f14916f.setLayoutParams(layoutParams);
        this.f14916f.setIndeterminate(true);
        addView(this.f14916f);
        this.f14917g = l.k(getContext());
    }

    public void f(EmotionDetailData emotionDetailData, int i2, boolean z) {
        EmotionDetailData.PicInfo picInfo;
        if (emotionDetailData == null || (picInfo = emotionDetailData.pic_info) == null || TextUtils.isEmpty(picInfo.pic_url)) {
            return;
        }
        if (z) {
            GifView gifView = new GifView(getContext());
            this.f14915e = gifView;
            gifView.setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            EmotionDetailData.PicInfo picInfo2 = emotionDetailData.pic_info;
            String str = picInfo2.thumbnail;
            gifInfo.mSharpText = str;
            String str2 = picInfo2.pic_url;
            gifInfo.mDynamicUrl = str2;
            gifInfo.mStaticUrl = str2;
            gifInfo.mGifWidth = picInfo2.width;
            gifInfo.mGifHeight = picInfo2.height;
            this.f14915e.setTag(str);
            ((GifView) this.f14915e).w0(gifInfo);
            ImageView imageView = this.f14915e;
            EmotionDetailData.PicInfo picInfo3 = emotionDetailData.pic_info;
            g(imageView, picInfo3.width, picInfo3.height, 200, 200);
            addView(this.f14915e);
            this.f14916f.setVisibility(8);
            return;
        }
        this.f14916f.setVisibility(0);
        d.h().m(emotionDetailData.pic_info.pic_url, i2, new a(emotionDetailData), null);
    }

    public final boolean g(ImageView imageView, int i2, int i3, int i4, int i5) {
        int i6 = this.f14917g;
        if (i6 > 0) {
            i5 = (int) (i6 * 0.5f);
            i4 = i6;
        }
        int[] l = l.l(i2, i3, i4, i5);
        if (l == null) {
            return false;
        }
        int[] iArr = {l[0], l[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (i4 > i7) {
            float f2 = f14914h;
            if (f2 > 1.0f) {
                float f3 = i7;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i7 = i4 - (l.g(getContext(), R.dimen.ds34) * 2);
                } else {
                    float f5 = f4 * 0.68f;
                    i7 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                }
                if (iArr[0] > 0) {
                    i8 = (iArr[1] * i7) / iArr[0];
                }
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
        layoutParams.gravity = 17;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    public EmotionDetailImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14916f = null;
        e();
    }

    public EmotionDetailImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14916f = null;
        e();
    }
}
