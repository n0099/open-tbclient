package com.baidu.tieba.faceshop.emotiondetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
/* loaded from: classes8.dex */
public class EmotionDetailImageView extends FrameLayout {
    private static final float fXz = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private int gBW;
    private ImageView jbI;
    private ProgressBar mProgressBar;

    public EmotionDetailImageView(Context context) {
        super(context);
        this.mProgressBar = null;
        init();
    }

    public EmotionDetailImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressBar = null;
        init();
    }

    public EmotionDetailImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgressBar = null;
        init();
    }

    private void init() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mProgressBar = new ProgressBar(getContext(), null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        this.gBW = l.getEquipmentWidth(getContext());
    }

    public void a(final EmotionDetailData emotionDetailData, int i, boolean z) {
        if (emotionDetailData != null && emotionDetailData.pic_info != null && !TextUtils.isEmpty(emotionDetailData.pic_info.pic_url)) {
            if (z) {
                this.jbI = new GifView(getContext());
                ((GifView) this.jbI).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = emotionDetailData.pic_info.thumbnail;
                gifInfo.mDynamicUrl = emotionDetailData.pic_info.pic_url;
                gifInfo.mStaticUrl = emotionDetailData.pic_info.pic_url;
                gifInfo.mGifWidth = emotionDetailData.pic_info.width;
                gifInfo.mGifHeight = emotionDetailData.pic_info.height;
                this.jbI.setTag(gifInfo.mSharpText);
                ((GifView) this.jbI).a(gifInfo);
                a(this.jbI, emotionDetailData.pic_info.width, emotionDetailData.pic_info.height, 200, 200);
                addView(this.jbI);
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.mProgressBar.setVisibility(0);
            d.mw().a(emotionDetailData.pic_info.pic_url, i, new c<a>() { // from class: com.baidu.tieba.faceshop.emotiondetail.view.EmotionDetailImageView.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onCancelled(String str) {
                    EmotionDetailImageView.this.mProgressBar.setVisibility(8);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(a aVar, String str, int i2) {
                    EmotionDetailImageView.this.mProgressBar.setVisibility(8);
                    if (aVar != null) {
                        EmotionDetailImageView.this.jbI = new TbMemeImageView(EmotionDetailImageView.this.getContext());
                        ((TbMemeImageView) EmotionDetailImageView.this.jbI).f(aVar);
                        EmotionDetailImageView.this.a(EmotionDetailImageView.this.jbI, emotionDetailData.pic_info.width, emotionDetailData.pic_info.height, 200, 200);
                        EmotionDetailImageView.this.addView(EmotionDetailImageView.this.jbI);
                    }
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ImageView imageView, int i, int i2, int i3, int i4) {
        if (this.gBW > 0) {
            i3 = this.gBW;
            i4 = (int) (i3 * 0.5f);
        }
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return false;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (i3 > i5 && fXz > 1.0f) {
            if (i5 * fXz > i3) {
                i5 = i3 - (l.getDimens(getContext(), R.dimen.ds34) * 2);
            } else if (i5 * fXz > i3 * 0.68f) {
                i5 = (int) (i3 * 0.68f);
            } else {
                i5 = (int) (i5 * fXz);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i5) / iArr[0];
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
        layoutParams.gravity = 17;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        return true;
    }
}
