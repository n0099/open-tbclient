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
    private b iqu;
    private int iqv;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.iqv = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqv = ap.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqv = ap.getColor(R.color.cp_link_tip_a);
    }

    public void setData(z zVar) {
        if (zVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (zVar.meh > 3) {
                this.iqu = new c(getContext());
            } else if (zVar.meh == 2 || zVar.meh == 3) {
                this.iqu = new f(getContext());
            } else if (zVar.meh == 1) {
                this.iqu = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.iqu.getView(), -1, -2);
            this.iqu.setData(zVar);
            if (this.iqu instanceof a) {
                ((a) this.iqu).setThemeFontColor(this.iqv);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqu != null) {
            this.iqu.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.iqv = i;
        if (this.iqu instanceof a) {
            ((a) this.iqu).setThemeFontColor(this.iqv);
        }
    }
}
