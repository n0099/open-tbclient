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
import d.a.c.e.l.c;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class EmotionPreview extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f14681e;

    /* renamed from: f  reason: collision with root package name */
    public int f14682f;

    /* loaded from: classes4.dex */
    public class a extends c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f14683a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f14684b;

        public a(String str, String str2) {
            this.f14683a = str;
            this.f14684b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            if (aVar != null) {
                if (aVar.t()) {
                    EmotionPreview.this.f14681e = new GifView(EmotionPreview.this.getContext());
                    ((GifView) EmotionPreview.this.f14681e).setSupportNoImage(false);
                    GifInfo gifInfo = new GifInfo();
                    String str2 = this.f14683a;
                    gifInfo.mSharpText = str2;
                    gifInfo.mDynamicUrl = str2;
                    gifInfo.mStaticUrl = this.f14684b;
                    EmotionPreview.this.f14681e.setTag(gifInfo.mSharpText);
                    ((GifView) EmotionPreview.this.f14681e).w0(gifInfo);
                } else {
                    EmotionPreview.this.f14681e = new TbImageView(EmotionPreview.this.getContext());
                    ((TbImageView) EmotionPreview.this.f14681e).setGifIconSupport(false);
                    aVar.h(EmotionPreview.this.f14681e);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(EmotionPreview.this.f14682f, EmotionPreview.this.f14682f);
                layoutParams.gravity = 17;
                EmotionPreview emotionPreview = EmotionPreview.this;
                emotionPreview.addView(emotionPreview.f14681e, layoutParams);
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
        this.f14682f = l.g(getContext(), R.dimen.ds200);
    }

    public void e(String str, String str2, boolean z, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        removeAllViews();
        if (!z && i2 != 20) {
            d.h().m(str, 10, new a(str, str2), null);
            return;
        }
        GifView gifView = new GifView(getContext());
        this.f14681e = gifView;
        gifView.setSupportNoImage(false);
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = str;
        gifInfo.mDynamicUrl = str;
        gifInfo.mStaticUrl = str2;
        this.f14681e.setTag(str);
        ((GifView) this.f14681e).w0(gifInfo);
        int i3 = this.f14682f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        addView(this.f14681e, layoutParams);
    }

    public EmotionPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public EmotionPreview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d();
    }
}
