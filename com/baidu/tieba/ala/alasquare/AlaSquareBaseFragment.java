package com.baidu.tieba.ala.alasquare;

import android.os.Bundle;
import com.baidu.ala.refresh.AlaAutoRefreshFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public abstract class AlaSquareBaseFragment extends AlaAutoRefreshFragment {
    public abstract void D0();

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        D0();
    }
}
