package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.view.FrsTopItemInfoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ItemInfo;
/* loaded from: classes9.dex */
public class aj {
    private BaseFragment hEc;
    private FrsTopItemInfoView hEd;

    public aj(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.hEc = baseFragment;
            this.hEd = new FrsTopItemInfoView(baseFragment.getContext());
            this.hEd.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            onChangeSkinType();
            if ((this.hEc instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.hEc).hHD) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.hEd.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.hEd != null) {
            this.hEd.setData(itemInfo);
        }
    }

    public View getView() {
        return this.hEd;
    }

    public void onChangeSkinType() {
        if (this.hEd != null) {
            this.hEd.onChangeSkinType();
        }
    }
}
