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
public class aj {
    private BaseFragment hKa;
    private FrsTopItemInfoView hKb;

    public aj(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        if (baseFragment != null) {
            this.hKa = baseFragment;
            this.hKb = new FrsTopItemInfoView(baseFragment.getContext());
            this.hKb.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            onChangeSkinType();
            if ((this.hKa instanceof FrsCommonTabFragment) && (frsViewData = ((FrsCommonTabFragment) this.hKa).hNE) != null && frsViewData.getForum() != null) {
                ForumData forum = frsViewData.getForum();
                this.hKb.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
            }
        }
    }

    public void setData(ItemInfo itemInfo) {
        if (this.hKb != null) {
            this.hKb.setData(itemInfo);
        }
    }

    public View getView() {
        return this.hKb;
    }

    public void onChangeSkinType() {
        if (this.hKb != null) {
            this.hKb.onChangeSkinType();
        }
    }
}
