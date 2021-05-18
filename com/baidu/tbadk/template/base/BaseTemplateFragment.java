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
    public d.a.j0.x0.a f13035e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f13036f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f13037g = new a(2001453);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() != 2001453) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof d.a.j0.x0.b.a.a) {
                d.a.j0.x0.b.a.a aVar = (d.a.j0.x0.b.a.a) data;
                if (aVar.a() != BaseTemplateFragment.this.getUniqueId()) {
                    return;
                }
                if (aVar.c()) {
                    BaseTemplateFragment.this.H0(aVar);
                } else if (aVar.b()) {
                    BaseTemplateFragment.this.G0(aVar);
                }
            }
        }
    }

    public final String D0(Object obj) {
        return obj != null ? obj.getClass().getSimpleName() : StringUtil.NULL_STRING;
    }

    public abstract d.a.j0.x0.a E0(ViewGroup viewGroup);

    public abstract ViewGroup F0();

    public void G0(d.a.j0.x0.b.a.a aVar) {
    }

    public void H0(d.a.j0.x0.b.a.a aVar) {
    }

    public void I0() {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->sendReq----");
        d.a.j0.x0.a aVar = this.f13035e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onActivityCreated---- ");
        super.onActivityCreated(bundle);
        if (isPrimary()) {
            I0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onAttach---- ");
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onAttachFragment----parentFragment=" + D0(getParentFragment()));
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onAttachFragment----currentFragment=" + D0(this));
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onAttachFragment----childFragment=" + D0(fragment));
        super.onAttachFragment(fragment);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onChangeSkinType---- ");
        super.onChangeSkinType(i2);
        d.a.j0.x0.a aVar = this.f13035e;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onCreate---- ");
        super.onCreate(bundle);
        getArguments();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onCreateView---- ");
        ViewGroup viewGroup2 = this.f13036f;
        if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f13036f.getParent()).removeView(this.f13036f);
        }
        if (this.f13036f == null) {
            this.f13036f = F0();
        }
        if (this.f13035e == null) {
            this.f13035e = E0(this.f13036f);
        }
        this.f13035e.f(getUniqueId());
        registerListener(this.f13037g);
        return this.f13036f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onDestroy---- ");
        super.onDestroy();
        d.a.j0.x0.a aVar = this.f13035e;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onDetach---- ");
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onHiddenChanged----hidden=" + z);
        super.onHiddenChanged(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onLazyLoad---- ");
        super.onLazyLoad();
        I0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onLazyLoad---- ");
        super.onLoad();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onPause---- ");
        super.onPause();
        d.a.j0.x0.a aVar = this.f13035e;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onPrimary----isPrimary =" + isPrimary());
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            d.a.j0.x0.a aVar = this.f13035e;
            if (aVar != null) {
                aVar.d();
                return;
            }
            return;
        }
        d.a.j0.x0.a aVar2 = this.f13035e;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->onViewCreated---- ");
        super.onViewCreated(view, bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        d.a.j0.x0.d.a.b("BaseTemplateFragment-->setUserVisibleHint----isVisibleToUser=" + z);
        super.setUserVisibleHint(z);
    }
}
