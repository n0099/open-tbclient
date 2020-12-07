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
    private BaseFragment iXC;
    private FrsTopItemInfoView iXD;

    public ak(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.iXC = baseFragment;
            this.iXD = new FrsTopItemInfoView(baseFragment.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (com.baidu.tbadk.a.d.bkA()) {
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            } else {
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            }
            this.iXD.setLayoutParams(layoutParams);
            onChangeSkinType();
            if ((this.iXC instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.iXC).jbO) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.iXD.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.iXD != null) {
            this.iXD.setData(itemInfo);
        }
    }

    public View getView() {
        return this.iXD;
    }

    public void onChangeSkinType() {
        if (this.iXD != null) {
            this.iXD.onChangeSkinType();
        }
    }
}
