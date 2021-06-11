package com.baidu.tieba.faceshop.emotioncenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.model.EmotionCenterModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class EmotionRecommendFragment extends BaseFragment implements d.a.n0.m0.y.d.b {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.m0.y.e.a f14854e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionCenterModel f14855f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14856g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14857h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14858i = false;
    public boolean j = false;
    public final CustomMessageListener k = new a(2000994);
    public CustomMessageListener l = new b(2921059);
    public CustomMessageListener m = new c(2921040);
    public f.g n = new d();
    public BdListView.p o = new e();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || EmotionRecommendFragment.this.f14855f == null || EmotionRecommendFragment.this.f14854e == null || EmotionRecommendFragment.this.f14854e.i() == null || EmotionRecommendFragment.this.f14854e.i().getVisibility() != 0) {
                return;
            }
            EmotionRecommendFragment.this.f14855f.y(EmotionRecommendFragment.this);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof EmotionPackageData) || (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) == null || EmotionRecommendFragment.this.f14854e == null) {
                return;
            }
            EmotionRecommendFragment.this.f14854e.y(emotionPackageData);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                return;
            }
            HashMap hashMap = (HashMap) customResponsedMessage.getData();
            if (hashMap == null || hashMap.isEmpty()) {
                if (EmotionRecommendFragment.this.f14854e != null) {
                    EmotionRecommendFragment.this.f14854e.o();
                }
            } else if (!hashMap.containsKey("upload_result")) {
                if (EmotionRecommendFragment.this.f14854e != null) {
                    EmotionRecommendFragment.this.f14854e.o();
                }
            } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                if (EmotionRecommendFragment.this.f14854e != null) {
                    EmotionRecommendFragment.this.f14854e.o();
                }
            } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                if (EmotionRecommendFragment.this.f14854e != null) {
                    String str = (String) hashMap.get("upload_msg");
                    if (!TextUtils.isEmpty(str)) {
                        l.J(EmotionRecommendFragment.this.getActivity(), str);
                    } else {
                        l.J(EmotionRecommendFragment.this.getActivity(), EmotionRecommendFragment.this.getString(R.string.emotion_error_default_net_tip));
                    }
                    EmotionRecommendFragment.this.f14854e.x();
                }
            } else {
                BdToast.c(EmotionRecommendFragment.this.getPageContext().getPageActivity(), EmotionRecommendFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                if (EmotionRecommendFragment.this.f14854e != null) {
                    EmotionRecommendFragment.this.f14854e.o();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (EmotionRecommendFragment.this.f14855f != null && !EmotionRecommendFragment.this.f14858i) {
                EmotionRecommendFragment.this.f14855f.y(EmotionRecommendFragment.this);
            }
            EmotionRecommendFragment.this.f14854e.k().d();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (EmotionRecommendFragment.this.f14855f == null || EmotionRecommendFragment.this.f14858i) {
                return;
            }
            if (EmotionRecommendFragment.this.f14857h) {
                EmotionRecommendFragment.this.f14854e.t();
                EmotionRecommendFragment.this.f14855f.x(EmotionRecommendFragment.this);
                return;
            }
            EmotionRecommendFragment.this.f14854e.v();
        }
    }

    public final void K0() {
        if (d.a.n0.z1.g.e.l().r()) {
            d.a.n0.m0.y.e.a aVar = this.f14854e;
            if (aVar != null) {
                aVar.s();
                return;
            }
            return;
        }
        d.a.n0.m0.y.e.a aVar2 = this.f14854e;
        if (aVar2 != null) {
            aVar2.o();
        }
    }

    public int L0() {
        d.a.n0.m0.y.e.a aVar = this.f14854e;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // d.a.n0.m0.y.d.b
    public void V(EmotionCenterData emotionCenterData) {
        this.f14858i = false;
        this.f14854e.l();
        if (emotionCenterData == null) {
            return;
        }
        this.f14854e.c(emotionCenterData);
    }

    @Override // d.a.n0.m0.y.d.b
    public void d0(EmotionCenterData emotionCenterData) {
    }

    @Override // d.a.n0.m0.y.d.b
    public void k0(EmotionCenterData emotionCenterData) {
        this.f14858i = false;
        this.f14854e.d();
        this.f14854e.l();
        if (emotionCenterData == null) {
            return;
        }
        if (!"1".equals(emotionCenterData.has_more)) {
            this.f14857h = false;
        } else {
            this.f14857h = true;
        }
        if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921060, emotionCenterData.activity_url));
        }
        this.f14854e.p(emotionCenterData);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.m0.y.e.a aVar = this.f14854e;
        if (aVar != null) {
            aVar.n(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        EmotionCenterModel emotionCenterModel;
        EmotionCenterModel emotionCenterModel2;
        d.a.n0.m0.y.e.a aVar = new d.a.n0.m0.y.e.a(getPageContext(), getUniqueId());
        this.f14854e = aVar;
        aVar.q(this.n);
        this.f14854e.r(this.o);
        registerListener(this.k);
        registerListener(this.l);
        if (this.f14855f == null) {
            this.f14855f = new EmotionCenterModel(getPageContext());
        }
        registerListener(this.m);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.j = arguments.getBoolean("need_check_login");
        }
        if (!this.j) {
            if (this.f14856g && (emotionCenterModel2 = this.f14855f) != null) {
                emotionCenterModel2.y(this);
                this.f14858i = true;
                this.f14856g = false;
            }
        } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.f14856g && (emotionCenterModel = this.f14855f) != null) {
                emotionCenterModel.y(this);
                this.f14858i = true;
                this.f14856g = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.f14854e.j();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        K0();
    }
}
