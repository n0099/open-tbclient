package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.view.FrsTopItemInfoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ItemInfo;
/* loaded from: classes22.dex */
public class al {
    private BaseFragment iLY;
    private FrsTopItemInfoView iLZ;

    public al(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.iLY = baseFragment;
            this.iLZ = new FrsTopItemInfoView(baseFragment.getContext());
            this.iLZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            onChangeSkinType();
            if ((this.iLY instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.iLY).iQj) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.iLZ.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.iLZ != null) {
            this.iLZ.setData(itemInfo);
        }
    }

    public View getView() {
        return this.iLZ;
    }

    public void onChangeSkinType() {
        if (this.iLZ != null) {
            this.iLZ.onChangeSkinType();
        }
    }
}
