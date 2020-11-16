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
/* loaded from: classes21.dex */
public class al {
    private BaseFragment iML;
    private FrsTopItemInfoView iMM;

    public al(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.iML = baseFragment;
            this.iMM = new FrsTopItemInfoView(baseFragment.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (com.baidu.tbadk.a.d.bhw()) {
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            } else {
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            }
            this.iMM.setLayoutParams(layoutParams);
            onChangeSkinType();
            if ((this.iML instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.iML).iQW) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.iMM.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.iMM != null) {
            this.iMM.setData(itemInfo);
        }
    }

    public View getView() {
        return this.iMM;
    }

    public void onChangeSkinType() {
        if (this.iMM != null) {
            this.iMM.onChangeSkinType();
        }
    }
}
