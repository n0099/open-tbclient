package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes22.dex */
public class ServiceAreaView extends FrameLayout {
    private b jeW;
    private int jeX;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.jeX = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jeX = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jeX = ap.getColor(R.color.cp_link_tip_a);
    }

    public void setData(z zVar) {
        if (zVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (zVar.mVW > 3) {
                this.jeW = new c(getContext());
            } else if (zVar.mVW == 2 || zVar.mVW == 3) {
                this.jeW = new f(getContext());
            } else if (zVar.mVW == 1) {
                this.jeW = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.jeW.getView(), -1, -2);
            this.jeW.setData(zVar);
            if (this.jeW instanceof a) {
                ((a) this.jeW).setThemeFontColor(this.jeX);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jeW != null) {
            this.jeW.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.jeX = i;
        if (this.jeW instanceof a) {
            ((a) this.jeW).setThemeFontColor(this.jeX);
        }
    }
}
