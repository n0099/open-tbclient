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
    private b htu;
    private int htv;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.htv = am.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.htv = am.getColor(R.color.cp_link_tip_a);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.htv = am.getColor(R.color.cp_link_tip_a);
    }

    public void setData(y yVar) {
        if (yVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds37);
            if (yVar.kRy > 3) {
                this.htu = new c(getContext());
            } else if (yVar.kRy == 2 || yVar.kRy == 3) {
                this.htu = new f(getContext());
            } else if (yVar.kRy == 1) {
                this.htu = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds19);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.htu.getView(), -1, -2);
            this.htu.setData(yVar);
            if (this.htu instanceof a) {
                ((a) this.htu).setThemeFontColor(this.htv);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.htu != null) {
            this.htu.onChangeSkinType(i);
        }
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    public void setThemeFontColor(int i) {
        this.htv = i;
        if (this.htu instanceof a) {
            ((a) this.htu).setThemeFontColor(this.htv);
        }
    }
}
