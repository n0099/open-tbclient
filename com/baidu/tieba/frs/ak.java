package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.view.FrsTopItemInfoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ItemInfo;
/* loaded from: classes22.dex */
public class ak {
    private BaseFragment iXE;
    private FrsTopItemInfoView iXF;

    public ak(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.iXE = baseFragment;
            this.iXF = new FrsTopItemInfoView(baseFragment.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (com.baidu.tbadk.a.d.bkA()) {
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            } else {
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            }
            this.iXF.setLayoutParams(layoutParams);
            onChangeSkinType();
            if ((this.iXE instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.iXE).jbQ) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.iXF.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.iXF != null) {
            this.iXF.setData(itemInfo);
        }
    }

    public View getView() {
        return this.iXF;
    }

    public void onChangeSkinType() {
        if (this.iXF != null) {
            this.iXF.onChangeSkinType();
        }
    }
}
