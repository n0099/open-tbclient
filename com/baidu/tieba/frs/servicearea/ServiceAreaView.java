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
    private b iMD;
    private int iME;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.iME = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iME = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iME = ap.getColor(R.color.cp_link_tip_a);
    }

    public void setData(z zVar) {
        if (zVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (zVar.mDl > 3) {
                this.iMD = new c(getContext());
            } else if (zVar.mDl == 2 || zVar.mDl == 3) {
                this.iMD = new f(getContext());
            } else if (zVar.mDl == 1) {
                this.iMD = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.iMD.getView(), -1, -2);
            this.iMD.setData(zVar);
            if (this.iMD instanceof a) {
                ((a) this.iMD).setThemeFontColor(this.iME);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iMD != null) {
            this.iMD.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.iME = i;
        if (this.iMD instanceof a) {
            ((a) this.iMD).setThemeFontColor(this.iME);
        }
    }
}
