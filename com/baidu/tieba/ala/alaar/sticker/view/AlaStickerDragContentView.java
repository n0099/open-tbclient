package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class AlaStickerDragContentView extends RelativeLayout {
    private int borderWidth;
    private int gwD;

    public AlaStickerDragContentView(Context context) {
        super(context);
    }

    public AlaStickerDragContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlaStickerDragContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void bB(int i, int i2) {
        this.borderWidth = i;
        this.gwD = i2;
    }

    public DragTextView a(int i, Bitmap bitmap, int i2, e eVar, AlaLiveStickerInfo alaLiveStickerInfo) {
        ViewGroup.LayoutParams layoutParams;
        Bitmap createScaledBitmap;
        DragTextView dragTextView = new DragTextView(getContext());
        int dip2px = BdUtilHelper.dip2px(getContext(), 98.0f) / 2;
        int dip2px2 = BdUtilHelper.dip2px(getContext(), 64.0f) / 2;
        int dip2px3 = BdUtilHelper.dip2px(getContext(), 162.0f) / 2;
        int dip2px4 = BdUtilHelper.dip2px(getContext(), 64.0f) / 2;
        if (bitmap != null) {
            if (i == 1) {
                createScaledBitmap = Bitmap.createScaledBitmap(bitmap, dip2px * 2, dip2px2 * 2, true);
            } else {
                createScaledBitmap = Bitmap.createScaledBitmap(bitmap, dip2px3 * 2, dip2px4 * 2, true);
            }
            dragTextView.setBackground(new BitmapDrawable(createScaledBitmap));
        }
        dragTextView.setType(i);
        dragTextView.setParentBorder(0, 0, this.borderWidth, this.gwD);
        dragTextView.setOnDragViewEventListener(eVar);
        dragTextView.setTextColor(getContext().getResources().getColor(i2));
        if (i == 1) {
            dragTextView.setCanEdit(false);
        } else {
            dragTextView.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds26));
            dragTextView.setCanEdit(true);
            dragTextView.setGravity(17);
            dragTextView.setSingleLine();
            String string = getContext().getResources().getString(a.h.ala_live_striker_text);
            dragTextView.setText(string);
            alaLiveStickerInfo.text = string;
        }
        if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(dip2px * 2, dip2px2 * 2);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(dip2px3 * 2, dip2px4 * 2);
        }
        int childCount = (getChildCount() * getResources().getDimensionPixelOffset(a.d.sdk_ds40)) + ((int) (this.borderWidth * 0.2f));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds266);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelOffset += UtilHelper.getImmersiveStickyBarHeight();
        }
        int childCount2 = (getChildCount() * getResources().getDimensionPixelOffset(a.d.sdk_ds80)) + dimensionPixelOffset;
        int width = ((View) getParent()).getWidth();
        int height = ((View) getParent()).getHeight();
        if (i == 1) {
            alaLiveStickerInfo.centerX = Math.round((((dip2px + childCount) * 1.0f) / width) * 10000.0d) / 10000.0d;
            alaLiveStickerInfo.centerY = Math.round((((childCount2 + dip2px2) * 1.0f) / height) * 10000.0d) / 10000.0d;
        } else {
            alaLiveStickerInfo.centerX = Math.round((((childCount + dip2px3) * 1.0f) / width) * 10000.0d) / 10000.0d;
            alaLiveStickerInfo.centerY = Math.round(10000.0d * (((childCount2 + dip2px4) * 1.0f) / height)) / 10000.0d;
        }
        dragTextView.setTranslationX(childCount);
        dragTextView.setTranslationY(childCount2);
        dragTextView.setTag(alaLiveStickerInfo);
        addView(dragTextView, layoutParams);
        return dragTextView;
    }

    public void b(int i, Bitmap bitmap, int i2, e eVar, AlaLiveStickerInfo alaLiveStickerInfo) {
        ViewGroup.LayoutParams layoutParams;
        int i3;
        int i4;
        Bitmap createScaledBitmap;
        DragTextView dragTextView = new DragTextView(getContext());
        int dip2px = BdUtilHelper.dip2px(getContext(), 98.0f) / 2;
        int dip2px2 = BdUtilHelper.dip2px(getContext(), 64.0f) / 2;
        int dip2px3 = BdUtilHelper.dip2px(getContext(), 162.0f) / 2;
        int dip2px4 = BdUtilHelper.dip2px(getContext(), 64.0f) / 2;
        if (bitmap != null) {
            if (i == 1) {
                createScaledBitmap = Bitmap.createScaledBitmap(bitmap, dip2px * 2, dip2px2 * 2, true);
            } else {
                createScaledBitmap = Bitmap.createScaledBitmap(bitmap, dip2px3 * 2, dip2px4 * 2, true);
            }
            dragTextView.setBackground(new BitmapDrawable(createScaledBitmap));
        }
        dragTextView.setType(i);
        dragTextView.setParentBorder(0, 0, this.borderWidth, this.gwD);
        dragTextView.setOnDragViewEventListener(eVar);
        dragTextView.setTextColor(getContext().getResources().getColor(i2));
        if (i == 1) {
            dragTextView.setCanEdit(false);
        } else {
            dragTextView.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds26));
            dragTextView.setCanEdit(true);
            dragTextView.setGravity(17);
            dragTextView.setSingleLine();
            String string = getContext().getResources().getString(a.h.ala_live_striker_text);
            dragTextView.setText(string);
            alaLiveStickerInfo.text = string;
        }
        if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(dip2px * 2, dip2px2 * 2);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(dip2px3 * 2, dip2px4 * 2);
        }
        int width = ((View) getParent()).getWidth();
        int height = ((View) getParent()).getHeight();
        if (alaLiveStickerInfo.type == 1) {
            i3 = ((int) (width * alaLiveStickerInfo.centerX)) - dip2px;
            i4 = ((int) (height * alaLiveStickerInfo.centerY)) - dip2px2;
        } else {
            i3 = ((int) (width * alaLiveStickerInfo.centerX)) - dip2px3;
            i4 = ((int) (height * alaLiveStickerInfo.centerY)) - dip2px4;
        }
        dragTextView.setTranslationX(i3);
        dragTextView.setTranslationY(i4);
        dragTextView.setTag(alaLiveStickerInfo);
        addView(dragTextView, layoutParams);
    }

    public void cl(View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public Bitmap getVisibleBitmap() {
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(-getScrollX(), -getScrollY());
        draw(canvas);
        return createBitmap;
    }

    public void setStickerCanOperate(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof DragTextView) {
                    ((DragTextView) getChildAt(i2)).setStickerCanOperate(z);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
