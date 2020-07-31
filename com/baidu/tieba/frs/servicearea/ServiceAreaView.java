package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes16.dex */
public class ServiceAreaView extends FrameLayout {
    private b icf;
    private int icg;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.icg = ao.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.icg = ao.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.icg = ao.getColor(R.color.cp_link_tip_a);
    }

    public void setData(y yVar) {
        if (yVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (yVar.lMg > 3) {
                this.icf = new c(getContext());
            } else if (yVar.lMg == 2 || yVar.lMg == 3) {
                this.icf = new f(getContext());
            } else if (yVar.lMg == 1) {
                this.icf = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.icf.getView(), -1, -2);
            this.icf.setData(yVar);
            if (this.icf instanceof a) {
                ((a) this.icf).setThemeFontColor(this.icg);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.icf != null) {
            this.icf.onChangeSkinType(i);
        }
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.icg = i;
        if (this.icf instanceof a) {
            ((a) this.icf).setThemeFontColor(this.icg);
        }
    }
}
