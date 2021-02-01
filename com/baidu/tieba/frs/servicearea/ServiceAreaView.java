package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ServiceAreaView extends FrameLayout {
    private b jGH;
    private int jGI;
    private boolean jGJ;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.jGI = ap.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jGI = ap.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jGI = ap.getColor(R.color.CAM_X0302);
    }

    public void setData(aa aaVar, FrsViewData frsViewData) {
        ab abVar;
        if (this.jGJ) {
            if (aaVar == null) {
                aaVar = new aa();
                aaVar.dataList = new ArrayList();
            }
            if (!y.isEmpty(aaVar.dataList) && (abVar = aaVar.dataList.get(0)) != null && getResources().getString(R.string.hot_user_rank).equals(abVar.name) && getResources().getString(R.string.hot_user_rank).equals(abVar.imageUrl)) {
                aaVar.nvz--;
                aaVar.dataList.remove(0);
            }
            aaVar.nvz++;
            ab abVar2 = new ab();
            abVar2.name = getResources().getString(R.string.hot_user_rank);
            abVar2.imageUrl = getResources().getString(R.string.hot_user_rank);
            aaVar.dataList.add(0, abVar2);
        }
        if (aaVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.M_H_X001);
            int dimens2 = l.getDimens(getContext(), R.dimen.M_H_X001);
            if (aaVar.nvz >= 2) {
                this.jGH = new MultiServiceViewController(getContext());
            } else if (aaVar.nvz == 1) {
                this.jGH = new c(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds12);
                dimens = l.getDimens(getContext(), R.dimen.tbds5);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.jGH.getView(), -1, -2);
            this.jGH.setData(aaVar, frsViewData);
            if (this.jGH instanceof a) {
                ((a) this.jGH).setThemeFontColor(this.jGI);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jGH != null) {
            this.jGH.onChangeSkinType(i);
        }
    }

    public void setThemeFontColor(int i) {
        this.jGI = i;
        if (this.jGH instanceof a) {
            ((a) this.jGH).setThemeFontColor(this.jGI);
        }
    }

    public void setHasHotRankList(boolean z) {
        this.jGJ = z;
    }

    public boolean cJY() {
        return this.jGJ;
    }
}
