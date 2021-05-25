package com.baidu.tieba.homepage.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.m0.z0.b0;
import d.a.n0.b1.k.a;
import d.a.n0.r0.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoTabFragment extends BaseFragment implements o0 {

    /* renamed from: e  reason: collision with root package name */
    public a f16643e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16644f = false;

    @Override // d.a.n0.r0.o0
    public void G() {
    }

    @Override // d.a.n0.r0.o0
    public void H() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a067";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f16643e;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f16643e == null) {
            this.f16643e = new a(getPageContext(), getUniqueId());
        }
        this.f16643e.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        a aVar = this.f16643e;
        if (aVar != null && aVar.j() != null) {
            if (this.f16643e.j().getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f16643e.j().getParent()).removeView(this.f16643e.j());
            }
            return this.f16643e.j();
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.f16643e;
        if (aVar != null) {
            aVar.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        a aVar = this.f16643e;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        a aVar = this.f16643e;
        if (aVar != null) {
            aVar.n();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.f16644f) {
                this.f16644f = true;
                TiebaStatic.log(new StatisticItem("c13579"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
        }
        a aVar = this.f16643e;
        if (aVar != null) {
            aVar.p(isPrimary());
        }
    }

    @Override // d.a.n0.r0.o0
    public void p() {
        a aVar = this.f16643e;
        if (aVar != null) {
            aVar.o();
        }
    }

    @Override // d.a.n0.r0.o0
    public void s() {
    }

    @Override // d.a.n0.r0.o0
    public void u() {
    }

    @Override // d.a.n0.r0.o0
    public void y(b0 b0Var) {
    }
}
