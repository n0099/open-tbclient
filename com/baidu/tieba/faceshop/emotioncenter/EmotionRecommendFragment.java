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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.f0.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class EmotionRecommendFragment extends BaseFragment implements d.b.j0.l0.y.d.b {

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.l0.y.e.a f15427e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionCenterModel f15428f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15429g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15430h = false;
    public boolean i = false;
    public boolean j = false;
    public final CustomMessageListener k = new a(2000994);
    public CustomMessageListener l = new b(2921059);
    public CustomMessageListener m = new c(2921040);
    public f.g n = new d();
    public BdListView.p o = new e();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || EmotionRecommendFragment.this.f15428f == null || EmotionRecommendFragment.this.f15427e == null || EmotionRecommendFragment.this.f15427e.i() == null || EmotionRecommendFragment.this.f15427e.i().getVisibility() != 0) {
                return;
            }
            EmotionRecommendFragment.this.f15428f.u(EmotionRecommendFragment.this);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof EmotionPackageData) || (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) == null || EmotionRecommendFragment.this.f15427e == null) {
                return;
            }
            EmotionRecommendFragment.this.f15427e.z(emotionPackageData);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                return;
            }
            HashMap hashMap = (HashMap) customResponsedMessage.getData();
            if (hashMap == null || hashMap.isEmpty()) {
                if (EmotionRecommendFragment.this.f15427e != null) {
                    EmotionRecommendFragment.this.f15427e.o();
                }
            } else if (!hashMap.containsKey("upload_result")) {
                if (EmotionRecommendFragment.this.f15427e != null) {
                    EmotionRecommendFragment.this.f15427e.o();
                }
            } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                if (EmotionRecommendFragment.this.f15427e != null) {
                    EmotionRecommendFragment.this.f15427e.o();
                }
            } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                if (EmotionRecommendFragment.this.f15427e != null) {
                    String str = (String) hashMap.get("upload_msg");
                    if (!TextUtils.isEmpty(str)) {
                        l.I(EmotionRecommendFragment.this.getActivity(), str);
                    } else {
                        l.I(EmotionRecommendFragment.this.getActivity(), EmotionRecommendFragment.this.getString(R.string.emotion_error_default_net_tip));
                    }
                    EmotionRecommendFragment.this.f15427e.y();
                }
            } else {
                BdToast.c(EmotionRecommendFragment.this.getPageContext().getPageActivity(), EmotionRecommendFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                if (EmotionRecommendFragment.this.f15427e != null) {
                    EmotionRecommendFragment.this.f15427e.o();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (EmotionRecommendFragment.this.f15428f != null && !EmotionRecommendFragment.this.i) {
                EmotionRecommendFragment.this.f15428f.u(EmotionRecommendFragment.this);
            }
            EmotionRecommendFragment.this.f15427e.k().d();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (EmotionRecommendFragment.this.f15428f == null || EmotionRecommendFragment.this.i) {
                return;
            }
            if (EmotionRecommendFragment.this.f15430h) {
                EmotionRecommendFragment.this.f15427e.u();
                EmotionRecommendFragment.this.f15428f.t(EmotionRecommendFragment.this);
                return;
            }
            EmotionRecommendFragment.this.f15427e.w();
        }
    }

    @Override // d.b.j0.l0.y.d.b
    public void B(EmotionCenterData emotionCenterData) {
    }

    public final void I0() {
        if (d.b.j0.y1.g.e.l().r()) {
            d.b.j0.l0.y.e.a aVar = this.f15427e;
            if (aVar != null) {
                aVar.s();
                return;
            }
            return;
        }
        d.b.j0.l0.y.e.a aVar2 = this.f15427e;
        if (aVar2 != null) {
            aVar2.o();
        }
    }

    public int J0() {
        d.b.j0.l0.y.e.a aVar = this.f15427e;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // d.b.j0.l0.y.d.b
    public void U(EmotionCenterData emotionCenterData) {
        this.i = false;
        this.f15427e.d();
        this.f15427e.l();
        if (emotionCenterData == null) {
            return;
        }
        if (!"1".equals(emotionCenterData.has_more)) {
            this.f15430h = false;
        } else {
            this.f15430h = true;
        }
        if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921060, emotionCenterData.activity_url));
        }
        this.f15427e.p(emotionCenterData);
    }

    @Override // d.b.j0.l0.y.d.b
    public void f(EmotionCenterData emotionCenterData) {
        this.i = false;
        this.f15427e.l();
        if (emotionCenterData == null) {
            return;
        }
        this.f15427e.c(emotionCenterData);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.j0.l0.y.e.a aVar = this.f15427e;
        if (aVar != null) {
            aVar.n(i);
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
        d.b.j0.l0.y.e.a aVar = new d.b.j0.l0.y.e.a(getPageContext(), getUniqueId());
        this.f15427e = aVar;
        aVar.q(this.n);
        this.f15427e.r(this.o);
        registerListener(this.k);
        registerListener(this.l);
        if (this.f15428f == null) {
            this.f15428f = new EmotionCenterModel(getPageContext());
        }
        registerListener(this.m);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.j = arguments.getBoolean("need_check_login");
        }
        if (!this.j) {
            if (this.f15429g && (emotionCenterModel2 = this.f15428f) != null) {
                emotionCenterModel2.u(this);
                this.i = true;
                this.f15429g = false;
            }
        } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.f15429g && (emotionCenterModel = this.f15428f) != null) {
                emotionCenterModel.u(this);
                this.i = true;
                this.f15429g = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.f15427e.j();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        I0();
    }
}
