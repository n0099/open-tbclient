package com.baidu.tieba.ala.personcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class AlaPersonCenterFragment extends BaseFragment {
    private TbPageContext eSJ;
    private com.baidu.tieba.ala.personcenter.b.a hUw;
    private String hUx;
    private String mForumId;
    private String mForumName;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.eSJ = getPageContext();
        this.hUw = new com.baidu.tieba.ala.personcenter.b.a(this.eSJ, true);
        this.hUw.setForumName(this.mForumName);
        this.hUw.setForumId(this.mForumId);
        this.hUw.HI(this.hUx);
        if (getArguments() != null) {
            this.hUw.h(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), true);
        }
        return this.hUw.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.hUw.loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hUw != null) {
            this.hUw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.hUw.onDestory();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.hUw != null) {
            this.hUw.onChangeSkinType(i);
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

    public void HI(String str) {
        this.hUx = str;
    }
}
