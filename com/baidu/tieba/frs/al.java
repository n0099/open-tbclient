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
    private BaseFragment hXE;
    private FrsTopItemInfoView hXF;

    public al(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.hXE = baseFragment;
            this.hXF = new FrsTopItemInfoView(baseFragment.getContext());
            this.hXF.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            onChangeSkinType();
            if ((this.hXE instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.hXE).ibP) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.hXF.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.hXF != null) {
            this.hXF.setData(itemInfo);
        }
    }

    public View getView() {
        return this.hXF;
    }

    public void onChangeSkinType() {
        if (this.hXF != null) {
            this.hXF.onChangeSkinType();
        }
    }
}
