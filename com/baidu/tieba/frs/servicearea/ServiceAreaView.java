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
    private b jBd;
    private int jBe;
    private boolean jBf;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.jBe = ao.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBe = ao.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBe = ao.getColor(R.color.CAM_X0302);
    }

    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (this.jBf) {
            if (aaVar == null) {
                aaVar = new aa();
                aaVar.dataList = new ArrayList();
            }
            aaVar.nlP++;
            ab abVar = new ab();
            abVar.name = getResources().getString(R.string.hot_user_rank);
            abVar.imageUrl = getResources().getString(R.string.hot_user_rank);
            aaVar.dataList.add(0, abVar);
        }
        if (aaVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.M_H_X001);
            int dimens2 = l.getDimens(getContext(), R.dimen.M_H_X001);
            if (aaVar.nlP >= 2) {
                this.jBd = new MultiServiceViewController(getContext());
            } else if (aaVar.nlP == 1) {
                this.jBd = new c(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds12);
                dimens = l.getDimens(getContext(), R.dimen.tbds5);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.jBd.getView(), -1, -2);
            this.jBd.setData(aaVar, frsViewData);
            if (this.jBd instanceof a) {
                ((a) this.jBd).setThemeFontColor(this.jBe);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jBd != null) {
            this.jBd.onChangeSkinType(i);
        }
    }

    public void setThemeFontColor(int i) {
        this.jBe = i;
        if (this.jBd instanceof a) {
            ((a) this.jBd).setThemeFontColor(this.jBe);
        }
    }

    public void setHasHotRankList(boolean z) {
        this.jBf = z;
    }

    public boolean cIL() {
        return this.jBf;
    }
}
