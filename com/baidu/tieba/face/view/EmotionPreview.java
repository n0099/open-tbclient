package com.baidu.tieba.face.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class EmotionPreview extends LinearLayout {
    private ImageView dkz;
    private int mImageWidth;

    public EmotionPreview(Context context) {
        super(context);
        init();
    }

    public EmotionPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public EmotionPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setBackgroundResource(e.f.bg_expression_bubble);
        int h = l.h(getContext(), e.C0200e.ds20);
        setPadding(h, h, h, l.h(getContext(), e.C0200e.ds40));
        this.mImageWidth = l.h(getContext(), e.C0200e.ds200);
    }

    public void a(final String str, final String str2, boolean z, int i) {
        if (!TextUtils.isEmpty(str)) {
            removeAllViews();
            if (z || i == 20) {
                this.dkz = new GifView(getContext());
                ((GifView) this.dkz).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = str;
                gifInfo.mDynamicUrl = str;
                gifInfo.mStaticUrl = str2;
                this.dkz.setTag(gifInfo.mSharpText);
                ((GifView) this.dkz).a(gifInfo);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mImageWidth, this.mImageWidth);
                layoutParams.gravity = 17;
                addView(this.dkz, layoutParams);
                return;
            }
            c.jA().a(str, 10, new b<a>() { // from class: com.baidu.tieba.face.view.EmotionPreview.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(a aVar, String str3, int i2) {
                    if (aVar != null) {
                        if (aVar.isGif()) {
                            EmotionPreview.this.dkz = new GifView(EmotionPreview.this.getContext());
                            ((GifView) EmotionPreview.this.dkz).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = str;
                            gifInfo2.mDynamicUrl = str;
                            gifInfo2.mStaticUrl = str2;
                            EmotionPreview.this.dkz.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionPreview.this.dkz).a(gifInfo2);
                        } else {
                            EmotionPreview.this.dkz = new TbImageView(EmotionPreview.this.getContext());
                            ((TbImageView) EmotionPreview.this.dkz).setGifIconSupport(false);
                            aVar.a(EmotionPreview.this.dkz);
                        }
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(EmotionPreview.this.mImageWidth, EmotionPreview.this.mImageWidth);
                        layoutParams2.gravity = 17;
                        EmotionPreview.this.addView(EmotionPreview.this.dkz, layoutParams2);
                    }
                }
            }, null);
        }
    }
}
