package com.baidu.tieba.face.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.l.c;
import d.b.b.e.l.d;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class EmotionPreview extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15557e;

    /* renamed from: f  reason: collision with root package name */
    public int f15558f;

    /* loaded from: classes4.dex */
    public class a extends c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f15559a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f15560b;

        public a(String str, String str2) {
            this.f15559a = str;
            this.f15560b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                if (aVar.t()) {
                    EmotionPreview.this.f15557e = new GifView(EmotionPreview.this.getContext());
                    ((GifView) EmotionPreview.this.f15557e).setSupportNoImage(false);
                    GifInfo gifInfo = new GifInfo();
                    String str2 = this.f15559a;
                    gifInfo.mSharpText = str2;
                    gifInfo.mDynamicUrl = str2;
                    gifInfo.mStaticUrl = this.f15560b;
                    EmotionPreview.this.f15557e.setTag(gifInfo.mSharpText);
                    ((GifView) EmotionPreview.this.f15557e).w0(gifInfo);
                } else {
                    EmotionPreview.this.f15557e = new TbImageView(EmotionPreview.this.getContext());
                    ((TbImageView) EmotionPreview.this.f15557e).setGifIconSupport(false);
                    aVar.h(EmotionPreview.this.f15557e);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(EmotionPreview.this.f15558f, EmotionPreview.this.f15558f);
                layoutParams.gravity = 17;
                EmotionPreview emotionPreview = EmotionPreview.this;
                emotionPreview.addView(emotionPreview.f15557e, layoutParams);
            }
        }
    }

    public EmotionPreview(Context context) {
        super(context);
        d();
    }

    public final void d() {
        setBackgroundResource(R.drawable.bg_expression_bubble);
        int g2 = l.g(getContext(), R.dimen.ds20);
        setPadding(g2, g2, g2, l.g(getContext(), R.dimen.ds40));
        this.f15558f = l.g(getContext(), R.dimen.ds200);
    }

    public void e(String str, String str2, boolean z, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        removeAllViews();
        if (!z && i != 20) {
            d.h().m(str, 10, new a(str, str2), null);
            return;
        }
        GifView gifView = new GifView(getContext());
        this.f15557e = gifView;
        gifView.setSupportNoImage(false);
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = str;
        gifInfo.mDynamicUrl = str;
        gifInfo.mStaticUrl = str2;
        this.f15557e.setTag(str);
        ((GifView) this.f15557e).w0(gifInfo);
        int i2 = this.f15558f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 17;
        addView(this.f15557e, layoutParams);
    }

    public EmotionPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public EmotionPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }
}
