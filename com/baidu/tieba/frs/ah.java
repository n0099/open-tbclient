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
/* loaded from: classes2.dex */
public class ah {
    private BaseFragment jmO;
    private FrsTopItemInfoView jmP;

    public ah(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.jmO = baseFragment;
            this.jmP = new FrsTopItemInfoView(baseFragment.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            this.jmP.setLayoutParams(layoutParams);
            onChangeSkinType();
            if ((this.jmO instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.jmO).jrc) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.jmP.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.jmP != null) {
            this.jmP.setData(itemInfo);
        }
    }

    public View getView() {
        return this.jmP;
    }

    public void onChangeSkinType() {
        if (this.jmP != null) {
            this.jmP.onChangeSkinType();
        }
    }
}
