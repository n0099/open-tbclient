package com.baidu.tieba.ala.alasquare;

import android.os.Bundle;
import com.baidu.ala.refresh.AlaAutoRefreshFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public abstract class AlaSquareBaseFragment extends AlaAutoRefreshFragment {
    protected abstract void bqj();

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        bqj();
    }
}
