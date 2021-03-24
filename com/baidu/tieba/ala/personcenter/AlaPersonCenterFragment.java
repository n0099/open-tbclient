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
import d.b.i0.t.j.c.a;
/* loaded from: classes4.dex */
public class AlaPersonCenterFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15035e;

    /* renamed from: f  reason: collision with root package name */
    public String f15036f;

    /* renamed from: g  reason: collision with root package name */
    public String f15037g;

    /* renamed from: h  reason: collision with root package name */
    public String f15038h;
    public a i;

    public void E0(String str) {
    }

    public void F0(String str) {
        this.f15036f = str;
    }

    public void G0(String str) {
        this.f15037g = str;
    }

    public void H0(String str) {
        this.f15038h = str;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        a aVar = this.i;
        if (aVar != null) {
            aVar.m(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a aVar = this.i;
        if (aVar != null) {
            aVar.m(i);
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
        this.f15035e = pageContext;
        a aVar = new a(pageContext, true);
        this.i = aVar;
        aVar.s(this.f15037g);
        this.i.r(this.f15036f);
        this.i.t(this.f15038h);
        if (getArguments() != null) {
            this.i.k(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), true);
        }
        return this.i.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.i.o();
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
            this.i.l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
