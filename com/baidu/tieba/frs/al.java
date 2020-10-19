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
    private BaseFragment itF;
    private FrsTopItemInfoView itG;

    public al(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.itF = baseFragment;
            this.itG = new FrsTopItemInfoView(baseFragment.getContext());
            this.itG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            onChangeSkinType();
            if ((this.itF instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.itF).ixQ) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.itG.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.itG != null) {
            this.itG.setData(itemInfo);
        }
    }

    public View getView() {
        return this.itG;
    }

    public void onChangeSkinType() {
        if (this.itG != null) {
            this.itG.onChangeSkinType();
        }
    }
}
