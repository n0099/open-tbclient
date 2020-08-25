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
/* loaded from: classes16.dex */
public class ServiceAreaView extends FrameLayout {
    private b iqo;
    private int iqp;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.iqp = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqp = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqp = ap.getColor(R.color.cp_link_tip_a);
    }

    public void setData(z zVar) {
        if (zVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (zVar.mdS > 3) {
                this.iqo = new c(getContext());
            } else if (zVar.mdS == 2 || zVar.mdS == 3) {
                this.iqo = new f(getContext());
            } else if (zVar.mdS == 1) {
                this.iqo = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.iqo.getView(), -1, -2);
            this.iqo.setData(zVar);
            if (this.iqo instanceof a) {
                ((a) this.iqo).setThemeFontColor(this.iqp);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqo != null) {
            this.iqo.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.iqp = i;
        if (this.iqo instanceof a) {
            ((a) this.iqo).setThemeFontColor(this.iqp);
        }
    }
}
