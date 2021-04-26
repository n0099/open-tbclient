package com.baidu.tieba.frs.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class FrsADImageView extends TbImageView {
    public FrsADImageView(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        if (size > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec((int) (size * 0.5625f), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public FrsADImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public FrsADImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
