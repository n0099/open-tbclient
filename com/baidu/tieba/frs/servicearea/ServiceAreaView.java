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
    private b ich;
    private int ici;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.ici = ao.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ici = ao.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ici = ao.getColor(R.color.cp_link_tip_a);
    }

    public void setData(y yVar) {
        if (yVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (yVar.lMi > 3) {
                this.ich = new c(getContext());
            } else if (yVar.lMi == 2 || yVar.lMi == 3) {
                this.ich = new f(getContext());
            } else if (yVar.lMi == 1) {
                this.ich = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.ich.getView(), -1, -2);
            this.ich.setData(yVar);
            if (this.ich instanceof a) {
                ((a) this.ich).setThemeFontColor(this.ici);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ich != null) {
            this.ich.onChangeSkinType(i);
        }
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.ici = i;
        if (this.ich instanceof a) {
            ((a) this.ich).setThemeFontColor(this.ici);
        }
    }
}
