package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.view.FrsTopItemInfoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ItemInfo;
/* loaded from: classes16.dex */
public class al {
    private BaseFragment hXy;
    private FrsTopItemInfoView hXz;

    public al(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.hXy = baseFragment;
            this.hXz = new FrsTopItemInfoView(baseFragment.getContext());
            this.hXz.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            onChangeSkinType();
            if ((this.hXy instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.hXy).ibJ) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.hXz.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.hXz != null) {
            this.hXz.setData(itemInfo);
        }
    }

    public View getView() {
        return this.hXz;
    }

    public void onChangeSkinType() {
        if (this.hXz != null) {
            this.hXz.onChangeSkinType();
        }
    }
}
