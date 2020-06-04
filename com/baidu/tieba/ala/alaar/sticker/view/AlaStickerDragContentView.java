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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaStickerDragContentView extends RelativeLayout {
    private int borderWidth;
    private int eYp;

    public AlaStickerDragContentView(Context context) {
        super(context);
    }

    public AlaStickerDragContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlaStickerDragContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void bl(int i, int i2) {
        this.borderWidth = i;
        this.eYp = i2;
    }

    public void a(int i, Bitmap bitmap, int i2, e eVar) {
        Bitmap createScaledBitmap;
        DragTextView dragTextView = new DragTextView(getContext());
        if (bitmap != null) {
            if (i == 2) {
                createScaledBitmap = Bitmap.createScaledBitmap(bitmap, BdUtilHelper.dip2px(getContext(), 294.0f), BdUtilHelper.dip2px(getContext(), 192.0f), true);
            } else {
                createScaledBitmap = Bitmap.createScaledBitmap(bitmap, BdUtilHelper.dip2px(getContext(), 486.0f), BdUtilHelper.dip2px(getContext(), 192.0f), true);
            }
            dragTextView.setBackground(new BitmapDrawable(createScaledBitmap));
        }
        dragTextView.setParentBorder(0, 0, this.borderWidth, this.eYp);
        dragTextView.setOnDragViewEventListener(eVar);
        dragTextView.setTextColor(getContext().getResources().getColor(i2));
        if (i == 2) {
            dragTextView.setCanEdit(false);
        } else {
            dragTextView.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds26));
            dragTextView.setCanEdit(true);
            dragTextView.setGravity(17);
            dragTextView.setSingleLine();
            dragTextView.setText(a.i.ala_live_striker_text);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ((int) (this.borderWidth * 0.2f)) + (getChildCount() * getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds266);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelOffset += UtilHelper.getImmersiveStickyBarHeight();
        }
        layoutParams.topMargin = dimensionPixelOffset + (getChildCount() * getResources().getDimensionPixelOffset(a.e.sdk_ds80));
        addView(dragTextView, layoutParams);
    }

    public void bu(View view) {
        if (view.getParent() != null && view.getVisibility() == 0) {
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
