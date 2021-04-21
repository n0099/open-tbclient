package com.baidu.tieba.homepage.gamevideo;

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
import d.b.i0.z0.b0;
import d.b.j0.a1.d.b.c;
import d.b.j0.q0.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GameVideoFragment extends BaseFragment implements o0 {

    /* renamed from: e  reason: collision with root package name */
    public c f16833e;

    @Override // d.b.j0.q0.o0
    public void A() {
    }

    @Override // d.b.j0.q0.o0
    public void F() {
    }

    @Override // d.b.j0.q0.o0
    public void K(b0 b0Var) {
    }

    @Override // d.b.j0.q0.o0
    public void W() {
    }

    @Override // d.b.j0.q0.o0
    public void b0() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a066";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.k0.a
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
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        c cVar = this.f16833e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f16833e == null) {
            this.f16833e = new c(getPageContext(), getUniqueId());
        }
        this.f16833e.s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        c cVar = this.f16833e;
        if (cVar != null && cVar.r() != null) {
            if (this.f16833e.r().getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f16833e.r().getParent()).removeView(this.f16833e.r());
            }
            return this.f16833e.r();
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f16833e;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        c cVar = this.f16833e;
        if (cVar != null) {
            cVar.t();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        c cVar = this.f16833e;
        if (cVar != null) {
            cVar.w();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.FALSE));
        }
        c cVar = this.f16833e;
        if (cVar != null) {
            cVar.y(isPrimary());
        }
    }

    @Override // d.b.j0.q0.o0
    public void w() {
        c cVar = this.f16833e;
        if (cVar != null) {
            cVar.x();
        }
    }
}
