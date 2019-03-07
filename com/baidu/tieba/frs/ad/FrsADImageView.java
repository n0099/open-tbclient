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

    public FrsADImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FrsADImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        if (size > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (size * 0.5625f), 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
