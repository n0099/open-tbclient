package com.baidu.tieba.ala.liveroom.sticker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes11.dex */
public class AudienceStickerContainerView extends RelativeLayout {
    public AudienceStickerContainerView(Context context) {
        super(context);
    }

    public AudienceStickerContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AudienceStickerContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void b(AlaLiveStickerInfo alaLiveStickerInfo) {
        ViewGroup.LayoutParams layoutParams;
        int i;
        int i2;
        Bitmap createScaledBitmap;
        if (alaLiveStickerInfo != null) {
            int dip2px = BdUtilHelper.dip2px(getContext(), 98.0f) / 2;
            int dip2px2 = BdUtilHelper.dip2px(getContext(), 64.0f) / 2;
            int dip2px3 = BdUtilHelper.dip2px(getContext(), 162.0f) / 2;
            int dip2px4 = BdUtilHelper.dip2px(getContext(), 64.0f) / 2;
            TextView textView = new TextView(getContext());
            if (alaLiveStickerInfo.bitmap != null) {
                if (alaLiveStickerInfo.type == 1) {
                    createScaledBitmap = Bitmap.createScaledBitmap(alaLiveStickerInfo.bitmap, dip2px * 2, dip2px2 * 2, true);
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(alaLiveStickerInfo.bitmap, dip2px3 * 2, dip2px4 * 2, true);
                }
                textView.setBackground(new BitmapDrawable(createScaledBitmap));
            }
            textView.setTextColor(getContext().getResources().getColor(a.c.sdk_cp_cont_q));
            if (alaLiveStickerInfo.type == 2) {
                textView.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds26));
                textView.setGravity(17);
                textView.setSingleLine();
                textView.setText(alaLiveStickerInfo.text);
            }
            if (alaLiveStickerInfo.type == 1) {
                layoutParams = new RelativeLayout.LayoutParams(dip2px * 2, dip2px2 * 2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(dip2px3 * 2, dip2px4 * 2);
            }
            int i3 = (getParent() == null || !(getParent() instanceof AlaLiveView)) ? 0 : ((ViewGroup.MarginLayoutParams) ((AlaLiveView) getParent()).getLayoutParams()).topMargin;
            int width = getWidth();
            int height = getHeight() + i3;
            if (alaLiveStickerInfo.type == 1) {
                i = ((int) (width * alaLiveStickerInfo.centerX)) - dip2px;
                i2 = ((int) (height * alaLiveStickerInfo.centerY)) - dip2px2;
            } else {
                i = ((int) (width * alaLiveStickerInfo.centerX)) - dip2px3;
                i2 = ((int) (height * alaLiveStickerInfo.centerY)) - dip2px4;
            }
            textView.setTranslationX(i);
            textView.setTranslationY(i2 - i3);
            addView(textView, layoutParams);
        }
    }
}
