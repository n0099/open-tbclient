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
    private BaseFragment iGb;
    private FrsTopItemInfoView iGc;

    public al(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.iGb = baseFragment;
            this.iGc = new FrsTopItemInfoView(baseFragment.getContext());
            this.iGc.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            onChangeSkinType();
            if ((this.iGb instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.iGb).iKm) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.iGc.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.iGc != null) {
            this.iGc.setData(itemInfo);
        }
    }

    public View getView() {
        return this.iGc;
    }

    public void onChangeSkinType() {
        if (this.iGc != null) {
            this.iGc.onChangeSkinType();
        }
    }
}
