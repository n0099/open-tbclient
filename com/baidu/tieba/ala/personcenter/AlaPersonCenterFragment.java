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
import d.a.j0.t.j.c.a;
/* loaded from: classes4.dex */
public class AlaPersonCenterFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f14787e;

    /* renamed from: f  reason: collision with root package name */
    public String f14788f;

    /* renamed from: g  reason: collision with root package name */
    public String f14789g;

    /* renamed from: h  reason: collision with root package name */
    public String f14790h;

    /* renamed from: i  reason: collision with root package name */
    public a f14791i;

    public void E0(String str) {
    }

    public void F0(String str) {
        this.f14788f = str;
    }

    public void G0(String str) {
        this.f14789g = str;
    }

    public void H0(String str) {
        this.f14790h = str;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i2) {
        super.changeSkinType(i2);
        a aVar = this.f14791i;
        if (aVar != null) {
            aVar.m(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f14791i;
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
        this.f14787e = pageContext;
        a aVar = new a(pageContext, true);
        this.f14791i = aVar;
        aVar.s(this.f14789g);
        this.f14791i.r(this.f14788f);
        this.f14791i.t(this.f14790h);
        if (getArguments() != null) {
            this.f14791i.k(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), true);
        }
        return this.f14791i.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f14791i.o();
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
            this.f14791i.l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
