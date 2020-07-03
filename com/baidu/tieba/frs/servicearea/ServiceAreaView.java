package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes9.dex */
public class ServiceAreaView extends FrameLayout {
    private b hWh;
    private int hWi;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.hWi = an.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWi = an.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWi = an.getColor(R.color.cp_link_tip_a);
    }

    public void setData(y yVar) {
        if (yVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (yVar.lER > 3) {
                this.hWh = new c(getContext());
            } else if (yVar.lER == 2 || yVar.lER == 3) {
                this.hWh = new f(getContext());
            } else if (yVar.lER == 1) {
                this.hWh = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.hWh.getView(), -1, -2);
            this.hWh.setData(yVar);
            if (this.hWh instanceof a) {
                ((a) this.hWh).setThemeFontColor(this.hWi);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hWh != null) {
            this.hWh.onChangeSkinType(i);
        }
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.hWi = i;
        if (this.hWh instanceof a) {
            ((a) this.hWh).setThemeFontColor(this.hWi);
        }
    }
}
