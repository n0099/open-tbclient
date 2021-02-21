package com.baidu.tieba.ala.personcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class AlaPersonCenterFragment extends BaseFragment {
    private TbPageContext eUY;
    private com.baidu.tieba.ala.personcenter.b.a hZf;
    private String hZg;
    private String mForumId;
    private String mForumName;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.eUY = getPageContext();
        this.hZf = new com.baidu.tieba.ala.personcenter.b.a(this.eUY, true);
        this.hZf.setForumName(this.mForumName);
        this.hZf.setForumId(this.mForumId);
        this.hZf.In(this.hZg);
        if (getArguments() != null) {
            this.hZf.h(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), true);
        }
        return this.hZf.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.hZf.loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hZf != null) {
            this.hZf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.hZf.onDestory();
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
        if (this.hZf != null) {
            this.hZf.onChangeSkinType(i);
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

    public void In(String str) {
        this.hZg = str;
    }
}
