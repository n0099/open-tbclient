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
/* loaded from: classes21.dex */
public class ServiceAreaView extends FrameLayout {
    private b ixK;
    private int ixL;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.ixL = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ixL = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ixL = ap.getColor(R.color.cp_link_tip_a);
    }

    public void setData(z zVar) {
        if (zVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (zVar.mnG > 3) {
                this.ixK = new c(getContext());
            } else if (zVar.mnG == 2 || zVar.mnG == 3) {
                this.ixK = new f(getContext());
            } else if (zVar.mnG == 1) {
                this.ixK = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.ixK.getView(), -1, -2);
            this.ixK.setData(zVar);
            if (this.ixK instanceof a) {
                ((a) this.ixK).setThemeFontColor(this.ixL);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ixK != null) {
            this.ixK.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.ixL = i;
        if (this.ixK instanceof a) {
            ((a) this.ixK).setThemeFontColor(this.ixL);
        }
    }
}
