package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes9.dex */
public class ServiceAreaView extends FrameLayout {
    private b hIi;
    private int hIj;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.hIj = am.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hIj = am.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hIj = am.getColor(R.color.cp_link_tip_a);
    }

    public void setData(y yVar) {
        if (yVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (yVar.ljO > 3) {
                this.hIi = new c(getContext());
            } else if (yVar.ljO == 2 || yVar.ljO == 3) {
                this.hIi = new f(getContext());
            } else if (yVar.ljO == 1) {
                this.hIi = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.hIi.getView(), -1, -2);
            this.hIi.setData(yVar);
            if (this.hIi instanceof a) {
                ((a) this.hIi).setThemeFontColor(this.hIj);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hIi != null) {
            this.hIi.onChangeSkinType(i);
        }
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.hIj = i;
        if (this.hIi instanceof a) {
            ((a) this.hIi).setThemeFontColor(this.hIj);
        }
    }
}
