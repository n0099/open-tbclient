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
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class ServiceAreaView extends FrameLayout {
    private b jto;
    private int jtp;
    private boolean jtq;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.jtp = ap.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jtp = ap.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jtp = ap.getColor(R.color.CAM_X0302);
    }

    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (this.jtq) {
            if (aaVar == null) {
                aaVar = new aa();
                aaVar.dataList = new ArrayList();
            }
            aaVar.nkP++;
            ab abVar = new ab();
            abVar.name = getResources().getString(R.string.hot_user_rank);
            abVar.imageUrl = getResources().getString(R.string.hot_user_rank);
            aaVar.dataList.add(0, abVar);
        }
        if (aaVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.M_H_X001);
            int dimens2 = l.getDimens(getContext(), R.dimen.M_H_X001);
            if (aaVar.nkP >= 2) {
                this.jto = new c(getContext());
            } else if (aaVar.nkP == 1) {
                this.jto = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds12);
                dimens = l.getDimens(getContext(), R.dimen.tbds5);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.jto.getView(), -1, -2);
            this.jto.setData(aaVar, frsViewData);
            if (this.jto instanceof a) {
                ((a) this.jto).setThemeFontColor(this.jtp);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jto != null) {
            this.jto.onChangeSkinType(i);
        }
    }

    public void setThemeFontColor(int i) {
        this.jtp = i;
        if (this.jto instanceof a) {
            ((a) this.jto).setThemeFontColor(this.jtp);
        }
    }

    public void setHasHotRankList(boolean z) {
        this.jtq = z;
    }

    public boolean cJC() {
        return this.jtq;
    }
}
