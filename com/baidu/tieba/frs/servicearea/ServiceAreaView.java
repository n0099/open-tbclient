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
    private b hto;
    private int htp;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.htp = am.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.htp = am.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.htp = am.getColor(R.color.cp_link_tip_a);
    }

    public void setData(y yVar) {
        if (yVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (yVar.kRu > 3) {
                this.hto = new c(getContext());
            } else if (yVar.kRu == 2 || yVar.kRu == 3) {
                this.hto = new f(getContext());
            } else if (yVar.kRu == 1) {
                this.hto = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.hto.getView(), -1, -2);
            this.hto.setData(yVar);
            if (this.hto instanceof a) {
                ((a) this.hto).setThemeFontColor(this.htp);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hto != null) {
            this.hto.onChangeSkinType(i);
        }
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.htp = i;
        if (this.hto instanceof a) {
            ((a) this.hto).setThemeFontColor(this.htp);
        }
    }
}
