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
    private b jtm;
    private int jtn;
    private boolean jto;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.jtn = ap.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jtn = ap.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jtn = ap.getColor(R.color.CAM_X0302);
    }

    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (this.jto) {
            if (aaVar == null) {
                aaVar = new aa();
                aaVar.dataList = new ArrayList();
            }
            aaVar.nkN++;
            ab abVar = new ab();
            abVar.name = getResources().getString(R.string.hot_user_rank);
            abVar.imageUrl = getResources().getString(R.string.hot_user_rank);
            aaVar.dataList.add(0, abVar);
        }
        if (aaVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.M_H_X001);
            int dimens2 = l.getDimens(getContext(), R.dimen.M_H_X001);
            if (aaVar.nkN >= 2) {
                this.jtm = new c(getContext());
            } else if (aaVar.nkN == 1) {
                this.jtm = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds12);
                dimens = l.getDimens(getContext(), R.dimen.tbds5);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.jtm.getView(), -1, -2);
            this.jtm.setData(aaVar, frsViewData);
            if (this.jtm instanceof a) {
                ((a) this.jtm).setThemeFontColor(this.jtn);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jtm != null) {
            this.jtm.onChangeSkinType(i);
        }
    }

    public void setThemeFontColor(int i) {
        this.jtn = i;
        if (this.jtm instanceof a) {
            ((a) this.jtm).setThemeFontColor(this.jtn);
        }
    }

    public void setHasHotRankList(boolean z) {
        this.jto = z;
    }

    public boolean cJB() {
        return this.jto;
    }
}
