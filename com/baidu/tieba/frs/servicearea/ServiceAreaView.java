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
    private b iYZ;
    private int iZa;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.iZa = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iZa = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZa = ap.getColor(R.color.cp_link_tip_a);
    }

    public void setData(z zVar) {
        if (zVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (zVar.mPT > 3) {
                this.iYZ = new c(getContext());
            } else if (zVar.mPT == 2 || zVar.mPT == 3) {
                this.iYZ = new f(getContext());
            } else if (zVar.mPT == 1) {
                this.iYZ = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.iYZ.getView(), -1, -2);
            this.iYZ.setData(zVar);
            if (this.iYZ instanceof a) {
                ((a) this.iYZ).setThemeFontColor(this.iZa);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iYZ != null) {
            this.iYZ.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.iZa = i;
        if (this.iYZ instanceof a) {
            ((a) this.iYZ).setThemeFontColor(this.iZa);
        }
    }
}
