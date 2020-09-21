package com.baidu.tieba.face.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EmotionPreview extends LinearLayout {
    private ImageView hMj;
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
        setBackgroundResource(R.drawable.bg_expression_bubble);
        int dimens = l.getDimens(getContext(), R.dimen.ds20);
        setPadding(dimens, dimens, dimens, l.getDimens(getContext(), R.dimen.ds40));
        this.mImageWidth = l.getDimens(getContext(), R.dimen.ds200);
    }

    public void a(final String str, final String str2, boolean z, int i) {
        if (!TextUtils.isEmpty(str)) {
            removeAllViews();
            if (z || i == 20) {
                this.hMj = new GifView(getContext());
                ((GifView) this.hMj).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = str;
                gifInfo.mDynamicUrl = str;
                gifInfo.mStaticUrl = str2;
                this.hMj.setTag(gifInfo.mSharpText);
                ((GifView) this.hMj).a(gifInfo);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mImageWidth, this.mImageWidth);
                layoutParams.gravity = 17;
                addView(this.hMj, layoutParams);
                return;
            }
            c.mR().a(str, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionPreview.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str3, int i2) {
                    if (aVar != null) {
                        if (aVar.isGif()) {
                            EmotionPreview.this.hMj = new GifView(EmotionPreview.this.getContext());
                            ((GifView) EmotionPreview.this.hMj).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = str;
                            gifInfo2.mDynamicUrl = str;
                            gifInfo2.mStaticUrl = str2;
                            EmotionPreview.this.hMj.setTag(gifInfo2.mSharpText);
                            ((GifView) EmotionPreview.this.hMj).a(gifInfo2);
                        } else {
                            EmotionPreview.this.hMj = new TbImageView(EmotionPreview.this.getContext());
                            ((TbImageView) EmotionPreview.this.hMj).setGifIconSupport(false);
                            aVar.drawImageTo(EmotionPreview.this.hMj);
                        }
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(EmotionPreview.this.mImageWidth, EmotionPreview.this.mImageWidth);
                        layoutParams2.gravity = 17;
                        EmotionPreview.this.addView(EmotionPreview.this.hMj, layoutParams2);
                    }
                }
            }, null);
        }
    }
}
