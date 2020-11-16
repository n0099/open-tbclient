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
import com.baidu.tieba.tbadkCore.z;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class ServiceAreaView extends FrameLayout {
    private b jfJ;
    private int jfK;
    private boolean jfL;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.jfK = ap.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jfK = ap.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jfK = ap.getColor(R.color.CAM_X0302);
    }

    public void setData(z zVar, FrsViewData frsViewData) {
        if (this.jfL) {
            if (zVar == null) {
                zVar = new z();
                zVar.dataList = new ArrayList();
            }
            zVar.mWP++;
            aa aaVar = new aa();
            aaVar.name = getResources().getString(R.string.hot_user_rank);
            aaVar.imageUrl = getResources().getString(R.string.hot_user_rank);
            zVar.dataList.add(0, aaVar);
        }
        if (zVar != null) {
            int dimens = l.getDimens(getContext(), R.dimen.M_H_X001);
            int dimens2 = l.getDimens(getContext(), R.dimen.M_H_X001);
            if (zVar.mWP >= 2) {
                this.jfJ = new c(getContext());
            } else if (zVar.mWP == 1) {
                this.jfJ = new d(getContext());
                dimens2 = l.getDimens(getContext(), R.dimen.tbds12);
                dimens = l.getDimens(getContext(), R.dimen.tbds5);
            }
            setPadding(0, dimens, 0, dimens2);
            removeAllViews();
            addView(this.jfJ.getView(), -1, -2);
            this.jfJ.setData(zVar, frsViewData);
            if (this.jfJ instanceof a) {
                ((a) this.jfJ).setThemeFontColor(this.jfK);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jfJ != null) {
            this.jfJ.onChangeSkinType(i);
        }
    }

    public void setThemeFontColor(int i) {
        this.jfK = i;
        if (this.jfJ instanceof a) {
            ((a) this.jfJ).setThemeFontColor(this.jfK);
        }
    }

    public void setHasHotRankList(boolean z) {
        this.jfL = z;
    }

    public boolean cEo() {
        return this.jfL;
    }
}
