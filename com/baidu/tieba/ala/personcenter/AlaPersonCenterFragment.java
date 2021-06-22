package com.baidu.tieba.ala.personcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.o0.v.j.c.a;
/* loaded from: classes4.dex */
public class AlaPersonCenterFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f14144e;

    /* renamed from: f  reason: collision with root package name */
    public String f14145f;

    /* renamed from: g  reason: collision with root package name */
    public String f14146g;

    /* renamed from: h  reason: collision with root package name */
    public String f14147h;

    /* renamed from: i  reason: collision with root package name */
    public a f14148i;

    public void G0(String str) {
    }

    public void H0(String str) {
        this.f14145f = str;
    }

    public void I0(String str) {
        this.f14146g = str;
    }

    public void J0(String str) {
        this.f14147h = str;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i2) {
        super.changeSkinType(i2);
        a aVar = this.f14148i;
        if (aVar != null) {
            aVar.m(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f14148i;
        if (aVar != null) {
            aVar.m(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        this.f14144e = pageContext;
        a aVar = new a(pageContext, true);
        this.f14148i = aVar;
        aVar.s(this.f14146g);
        this.f14148i.r(this.f14145f);
        this.f14148i.t(this.f14147h);
        if (getArguments() != null) {
            this.f14148i.k(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), true);
        }
        return this.f14148i.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f14148i.o();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f14148i.l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
