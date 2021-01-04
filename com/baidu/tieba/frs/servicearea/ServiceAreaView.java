package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ServiceAreaView extends FrameLayout {
    private b jFJ;
    private int jFK;
    private boolean jFL;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.jFK = ao.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jFK = ao.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFK = ao.getColor(R.color.CAM_X0302);
    }

    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (this.jFL) {
            if (aaVar == null) {
                aaVar = new aa();
                aaVar.dataList = new ArrayList();
            }
            aaVar.nqx++;
            ab abVar = new ab();
            abVar.name = getResources().getString(R.string.hot_user_rank);
            abVar.imageUrl = getResources().getString(R.string.hot_user_rank);
            aaVar.dataList.add(0, abVar);
        }
        if (aaVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.M_H_X001);
            int dimens2 = l.getDimens(getContext(), R.dimen.M_H_X001);
            if (aaVar.nqx >= 2) {
                this.jFJ = new MultiServiceViewController(getContext());
            } else if (aaVar.nqx == 1) {
                this.jFJ = new c(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds12);
                dimens = l.getDimens(getContext(), R.dimen.tbds5);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.jFJ.getView(), -1, -2);
            this.jFJ.setData(aaVar, frsViewData);
            if (this.jFJ instanceof a) {
                ((a) this.jFJ).setThemeFontColor(this.jFK);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jFJ != null) {
            this.jFJ.onChangeSkinType(i);
        }
    }

    public void setThemeFontColor(int i) {
        this.jFK = i;
        if (this.jFJ instanceof a) {
            ((a) this.jFJ).setThemeFontColor(this.jFK);
        }
    }

    public void setHasHotRankList(boolean z) {
        this.jFL = z;
    }

    public boolean cMC() {
        return this.jFL;
    }
}
