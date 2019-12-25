package com.baidu.tieba.ala.endliveroom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class FlexibleHeightView extends View {
    private int ds160;
    private int ds48;
    private Context mContext;

    public FlexibleHeightView(Context context) {
        super(context);
        init(context);
    }

    public FlexibleHeightView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FlexibleHeightView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ds48 = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds48);
        this.ds160 = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (size < this.ds48) {
            size = this.ds48;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }
}
