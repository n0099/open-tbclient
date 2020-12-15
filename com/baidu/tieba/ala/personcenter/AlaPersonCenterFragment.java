package com.baidu.tieba.ala.personcenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class AlaPersonCenterFragment extends BaseFragment {
    private TbPageContext eNx;
    private com.baidu.tieba.ala.personcenter.b.a hMG;
    private String hMH;
    private String mForumId;
    private String mForumName;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.eNx = getPageContext();
        this.hMG = new com.baidu.tieba.ala.personcenter.b.a(this.eNx, true);
        this.hMG.setForumName(this.mForumName);
        this.hMG.setForumId(this.mForumId);
        this.hMG.IW(this.hMH);
        if (getArguments() != null) {
            this.hMG.f(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), true);
        }
        return this.hMG.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.hMG.loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hMG != null) {
            this.hMG.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.hMG.onDestory();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.hMG != null) {
            this.hMG.onChangeSkinType(i);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setForumGameLabel(String str) {
    }

    public void IW(String str) {
        this.hMH = str;
    }
}
