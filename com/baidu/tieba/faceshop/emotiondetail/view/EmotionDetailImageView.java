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
import d.b.b.e.l.c;
import d.b.b.e.l.d;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class EmotionDetailImageView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final float f15812h = l.h(TbadkCoreApplication.getInst());

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15813e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f15814f;

    /* renamed from: g  reason: collision with root package name */
    public int f15815g;

    /* loaded from: classes4.dex */
    public class a extends c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionDetailData f15816a;

        public a(EmotionDetailData emotionDetailData) {
            this.f15816a = emotionDetailData;
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            EmotionDetailImageView.this.f15814f.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            EmotionDetailImageView.this.f15814f.setVisibility(8);
            if (aVar != null) {
                EmotionDetailImageView.this.f15813e = new TbMemeImageView(EmotionDetailImageView.this.getContext());
                ((TbMemeImageView) EmotionDetailImageView.this.f15813e).g(aVar);
                EmotionDetailImageView emotionDetailImageView = EmotionDetailImageView.this;
                ImageView imageView = emotionDetailImageView.f15813e;
                EmotionDetailData.PicInfo picInfo = this.f15816a.pic_info;
                emotionDetailImageView.g(imageView, picInfo.width, picInfo.height, 200, 200);
                EmotionDetailImageView emotionDetailImageView2 = EmotionDetailImageView.this;
                emotionDetailImageView2.addView(emotionDetailImageView2.f15813e);
            }
        }
    }

    public EmotionDetailImageView(Context context) {
        super(context);
        this.f15814f = null;
        e();
    }

    public final void e() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        ProgressBar progressBar = new ProgressBar(getContext(), null, 16843399);
        this.f15814f = progressBar;
        progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        layoutParams.gravity = 17;
        this.f15814f.setLayoutParams(layoutParams);
        this.f15814f.setIndeterminate(true);
        addView(this.f15814f);
        this.f15815g = l.k(getContext());
    }

    public void f(EmotionDetailData emotionDetailData, int i, boolean z) {
        EmotionDetailData.PicInfo picInfo;
        if (emotionDetailData == null || (picInfo = emotionDetailData.pic_info) == null || TextUtils.isEmpty(picInfo.pic_url)) {
            return;
        }
        if (z) {
            GifView gifView = new GifView(getContext());
            this.f15813e = gifView;
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
            this.f15813e.setTag(str);
            ((GifView) this.f15813e).w0(gifInfo);
            ImageView imageView = this.f15813e;
            EmotionDetailData.PicInfo picInfo3 = emotionDetailData.pic_info;
            g(imageView, picInfo3.width, picInfo3.height, 200, 200);
            addView(this.f15813e);
            this.f15814f.setVisibility(8);
            return;
        }
        this.f15814f.setVisibility(0);
        d.h().m(emotionDetailData.pic_info.pic_url, i, new a(emotionDetailData), null);
    }

    public final boolean g(ImageView imageView, int i, int i2, int i3, int i4) {
        int i5 = this.f15815g;
        if (i5 > 0) {
            i4 = (int) (i5 * 0.5f);
            i3 = i5;
        }
        int[] l = l.l(i, i2, i3, i4);
        if (l == null) {
            return false;
        }
        int[] iArr = {l[0], l[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (i3 > i6) {
            float f2 = f15812h;
            if (f2 > 1.0f) {
                float f3 = i6;
                float f4 = i3;
                if (f3 * f2 > f4) {
                    i6 = i3 - (l.g(getContext(), R.dimen.ds34) * 2);
                } else {
                    float f5 = f4 * 0.68f;
                    i6 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                }
                if (iArr[0] > 0) {
                    i7 = (iArr[1] * i6) / iArr[0];
                }
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        layoutParams.gravity = 17;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    public EmotionDetailImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15814f = null;
        e();
    }

    public EmotionDetailImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15814f = null;
        e();
    }
}
