package com.baidu.tieba.faceshop.forumpackage;

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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.r.f0.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.b {

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.m0.z.c.a f15002e;
    public d.a.o0.m0.z.a.c j;

    /* renamed from: f  reason: collision with root package name */
    public ForumEmotionModel f15003f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15004g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15005h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15006i = false;
    public final CustomMessageListener k = new a(2000994);
    public CustomMessageListener l = new b(2921059);
    public final d.a.o0.m0.z.a.a m = new c();
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
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || ForumEmotionFragment.this.f15003f == null || ForumEmotionFragment.this.f15002e == null || ForumEmotionFragment.this.f15002e.c() == null || ForumEmotionFragment.this.f15002e.c().getVisibility() != 0) {
                return;
            }
            ForumEmotionFragment.this.f15003f.B(ForumEmotionFragment.this);
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
            ForumEmotionPackageData forumEmotionPackageData;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ForumEmotionPackageData) || (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) == null || ForumEmotionFragment.this.j == null) {
                return;
            }
            ForumEmotionFragment.this.j.g(forumEmotionPackageData);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.o0.m0.z.a.a {
        public c() {
        }

        @Override // d.a.o0.m0.z.a.a
        public void a(int i2) {
            ForumEmotionFragment.this.j.d();
            ForumEmotionFragment.this.f15003f.B(ForumEmotionFragment.this);
        }

        @Override // d.a.o0.m0.z.a.a
        public void b() {
            ForumEmotionFragment.this.j.d();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (ForumEmotionFragment.this.f15003f == null || ForumEmotionFragment.this.f15005h) {
                return;
            }
            ForumEmotionFragment.this.f15003f.B(ForumEmotionFragment.this);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (ForumEmotionFragment.this.f15003f == null || ForumEmotionFragment.this.f15005h) {
                return;
            }
            if (ForumEmotionFragment.this.f15003f.z()) {
                ForumEmotionFragment.this.f15002e.p();
                ForumEmotionFragment.this.f15003f.A(ForumEmotionFragment.this);
                return;
            }
            ForumEmotionFragment.this.f15002e.s();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionData f15012e;

        public f(ForumEmotionData forumEmotionData) {
            this.f15012e = forumEmotionData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f15012e.activity_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(ForumEmotionFragment.this.getPageContext(), new String[]{this.f15012e.activity_url});
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void U(ForumEmotionData forumEmotionData) {
        this.f15005h = false;
        this.f15002e.f();
        this.f15002e.h();
        if (forumEmotionData == null) {
            return;
        }
        if (!ListUtils.isEmpty(forumEmotionData.rank_pkg_list)) {
            ArrayList arrayList = new ArrayList();
            for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                d.a.o0.m0.z.b.c cVar = new d.a.o0.m0.z.b.c();
                cVar.f61253e = forumEmotionPackageData;
                arrayList.add(cVar);
            }
            this.j.a(arrayList);
        }
        this.j.d();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.o0.m0.z.c.a aVar = this.f15002e;
        if (aVar != null) {
            aVar.l(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ForumEmotionModel forumEmotionModel;
        ForumEmotionModel forumEmotionModel2;
        d.a.o0.m0.z.c.a aVar = new d.a.o0.m0.z.c.a(getPageContext(), getUniqueId());
        this.f15002e = aVar;
        aVar.n(this.n);
        this.f15002e.o(this.o);
        registerListener(this.k);
        registerListener(this.l);
        if (this.f15003f == null) {
            this.f15003f = new ForumEmotionModel(getPageContext());
        }
        d.a.o0.m0.z.a.c cVar = new d.a.o0.m0.z.a.c(getPageContext(), this.f15002e.b(), this.f15003f);
        this.j = cVar;
        cVar.f(this.m);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f15006i = arguments.getBoolean("need_check_login");
        }
        if (!this.f15006i) {
            if (this.f15004g && (forumEmotionModel2 = this.f15003f) != null) {
                forumEmotionModel2.B(this);
                this.f15005h = true;
                this.f15004g = false;
            }
        } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.f15004g && (forumEmotionModel = this.f15003f) != null) {
                forumEmotionModel.B(this);
                this.f15005h = true;
                this.f15004g = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.f15002e.d();
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void onFailed(String str) {
        this.f15005h = false;
        this.f15002e.a();
        this.f15002e.g();
        d.a.o0.m0.z.a.c cVar = this.j;
        if (cVar != null && cVar.b() > 0) {
            l.M(getPageContext().getContext(), str);
        } else {
            this.f15002e.r();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void y0(ForumEmotionData forumEmotionData) {
        this.f15005h = false;
        this.f15002e.a();
        this.f15002e.f();
        this.f15002e.g();
        this.f15002e.h();
        if (forumEmotionData == null) {
            return;
        }
        this.f15002e.m(forumEmotionData);
        this.f15002e.e().setOnClickListener(new f(forumEmotionData));
        if (forumEmotionData.rank_pkg_list != null) {
            ArrayList arrayList = new ArrayList();
            for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                d.a.o0.m0.z.b.c cVar = new d.a.o0.m0.z.b.c();
                cVar.f61253e = forumEmotionPackageData;
                arrayList.add(cVar);
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new d.a.o0.m0.z.b.a());
            }
            this.j.e(arrayList);
        }
        this.j.d();
    }
}
