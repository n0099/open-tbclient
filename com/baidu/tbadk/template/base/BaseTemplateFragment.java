package com.baidu.tbadk.template.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes3.dex */
public abstract class BaseTemplateFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.x0.a f13687e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f13688f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f13689g = new a(2001453);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() != 2001453) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof d.b.h0.x0.b.a.a) {
                d.b.h0.x0.b.a.a aVar = (d.b.h0.x0.b.a.a) data;
                if (aVar.a() != BaseTemplateFragment.this.getUniqueId()) {
                    return;
                }
                if (aVar.c()) {
                    BaseTemplateFragment.this.I0(aVar);
                } else if (aVar.b()) {
                    BaseTemplateFragment.this.H0(aVar);
                }
            }
        }
    }

    public final String E0(Object obj) {
        return obj != null ? obj.getClass().getSimpleName() : StringUtil.NULL_STRING;
    }

    public abstract d.b.h0.x0.a F0(ViewGroup viewGroup);

    public abstract ViewGroup G0();

    public void H0(d.b.h0.x0.b.a.a aVar) {
    }

    public void I0(d.b.h0.x0.b.a.a aVar) {
    }

    public void J0() {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->sendReq----");
        d.b.h0.x0.a aVar = this.f13687e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onActivityCreated---- ");
        super.onActivityCreated(bundle);
        if (isPrimary()) {
            J0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onAttach---- ");
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onAttachFragment----parentFragment=" + E0(getParentFragment()));
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onAttachFragment----currentFragment=" + E0(this));
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onAttachFragment----childFragment=" + E0(fragment));
        super.onAttachFragment(fragment);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onChangeSkinType---- ");
        super.onChangeSkinType(i);
        d.b.h0.x0.a aVar = this.f13687e;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onCreate---- ");
        super.onCreate(bundle);
        getArguments();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onCreateView---- ");
        ViewGroup viewGroup2 = this.f13688f;
        if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f13688f.getParent()).removeView(this.f13688f);
        }
        if (this.f13688f == null) {
            this.f13688f = G0();
        }
        if (this.f13687e == null) {
            this.f13687e = F0(this.f13688f);
        }
        this.f13687e.f(getUniqueId());
        registerListener(this.f13689g);
        return this.f13688f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onDestroy---- ");
        super.onDestroy();
        d.b.h0.x0.a aVar = this.f13687e;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onDetach---- ");
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onHiddenChanged----hidden=" + z);
        super.onHiddenChanged(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onLazyLoad---- ");
        super.onLazyLoad();
        J0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onLazyLoad---- ");
        super.onLoad();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onPause---- ");
        super.onPause();
        d.b.h0.x0.a aVar = this.f13687e;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onPrimary----isPrimary =" + isPrimary());
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            d.b.h0.x0.a aVar = this.f13687e;
            if (aVar != null) {
                aVar.d();
                return;
            }
            return;
        }
        d.b.h0.x0.a aVar2 = this.f13687e;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->onViewCreated---- ");
        super.onViewCreated(view, bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        d.b.h0.x0.d.a.b("BaseTemplateFragment-->setUserVisibleHint----isVisibleToUser=" + z);
        super.setUserVisibleHint(z);
    }
}
