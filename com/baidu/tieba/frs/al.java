package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.view.FrsTopItemInfoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ItemInfo;
/* loaded from: classes21.dex */
public class al {
    private BaseFragment ieI;
    private FrsTopItemInfoView ieJ;

    public al(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.ieI = baseFragment;
            this.ieJ = new FrsTopItemInfoView(baseFragment.getContext());
            this.ieJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            onChangeSkinType();
            if ((this.ieI instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.ieI).iiT) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.ieJ.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.ieJ != null) {
            this.ieJ.setData(itemInfo);
        }
    }

    public View getView() {
        return this.ieJ;
    }

    public void onChangeSkinType() {
        if (this.ieJ != null) {
            this.ieJ.onChangeSkinType();
        }
    }
}
