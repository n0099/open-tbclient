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
import d.a.m0.r.f0.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.b {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.m0.z.c.a f14863e;
    public d.a.n0.m0.z.a.c j;

    /* renamed from: f  reason: collision with root package name */
    public ForumEmotionModel f14864f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14865g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14866h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14867i = false;
    public final CustomMessageListener k = new a(2000994);
    public CustomMessageListener l = new b(2921059);
    public final d.a.n0.m0.z.a.a m = new c();
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
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || ForumEmotionFragment.this.f14864f == null || ForumEmotionFragment.this.f14863e == null || ForumEmotionFragment.this.f14863e.c() == null || ForumEmotionFragment.this.f14863e.c().getVisibility() != 0) {
                return;
            }
            ForumEmotionFragment.this.f14864f.x(ForumEmotionFragment.this);
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
    public class c implements d.a.n0.m0.z.a.a {
        public c() {
        }

        @Override // d.a.n0.m0.z.a.a
        public void a(int i2) {
            ForumEmotionFragment.this.j.d();
            ForumEmotionFragment.this.f14864f.x(ForumEmotionFragment.this);
        }

        @Override // d.a.n0.m0.z.a.a
        public void b() {
            ForumEmotionFragment.this.j.d();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (ForumEmotionFragment.this.f14864f == null || ForumEmotionFragment.this.f14866h) {
                return;
            }
            ForumEmotionFragment.this.f14864f.x(ForumEmotionFragment.this);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (ForumEmotionFragment.this.f14864f == null || ForumEmotionFragment.this.f14866h) {
                return;
            }
            if (ForumEmotionFragment.this.f14864f.v()) {
                ForumEmotionFragment.this.f14863e.p();
                ForumEmotionFragment.this.f14864f.w(ForumEmotionFragment.this);
                return;
            }
            ForumEmotionFragment.this.f14863e.s();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionData f14873e;

        public f(ForumEmotionData forumEmotionData) {
            this.f14873e = forumEmotionData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f14873e.activity_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(ForumEmotionFragment.this.getPageContext(), new String[]{this.f14873e.activity_url});
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void S(ForumEmotionData forumEmotionData) {
        this.f14866h = false;
        this.f14863e.f();
        this.f14863e.h();
        if (forumEmotionData == null) {
            return;
        }
        if (!ListUtils.isEmpty(forumEmotionData.rank_pkg_list)) {
            ArrayList arrayList = new ArrayList();
            for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                d.a.n0.m0.z.b.c cVar = new d.a.n0.m0.z.b.c();
                cVar.f57439e = forumEmotionPackageData;
                arrayList.add(cVar);
            }
            this.j.a(arrayList);
        }
        this.j.d();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.m0.z.c.a aVar = this.f14863e;
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
        d.a.n0.m0.z.c.a aVar = new d.a.n0.m0.z.c.a(getPageContext(), getUniqueId());
        this.f14863e = aVar;
        aVar.n(this.n);
        this.f14863e.o(this.o);
        registerListener(this.k);
        registerListener(this.l);
        if (this.f14864f == null) {
            this.f14864f = new ForumEmotionModel(getPageContext());
        }
        d.a.n0.m0.z.a.c cVar = new d.a.n0.m0.z.a.c(getPageContext(), this.f14863e.b(), this.f14864f);
        this.j = cVar;
        cVar.f(this.m);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f14867i = arguments.getBoolean("need_check_login");
        }
        if (!this.f14867i) {
            if (this.f14865g && (forumEmotionModel2 = this.f14864f) != null) {
                forumEmotionModel2.x(this);
                this.f14866h = true;
                this.f14865g = false;
            }
        } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.f14865g && (forumEmotionModel = this.f14864f) != null) {
                forumEmotionModel.x(this);
                this.f14866h = true;
                this.f14865g = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.f14863e.d();
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void onFailed(String str) {
        this.f14866h = false;
        this.f14863e.a();
        this.f14863e.g();
        d.a.n0.m0.z.a.c cVar = this.j;
        if (cVar != null && cVar.b() > 0) {
            l.M(getPageContext().getContext(), str);
        } else {
            this.f14863e.r();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void v0(ForumEmotionData forumEmotionData) {
        this.f14866h = false;
        this.f14863e.a();
        this.f14863e.f();
        this.f14863e.g();
        this.f14863e.h();
        if (forumEmotionData == null) {
            return;
        }
        this.f14863e.m(forumEmotionData);
        this.f14863e.e().setOnClickListener(new f(forumEmotionData));
        if (forumEmotionData.rank_pkg_list != null) {
            ArrayList arrayList = new ArrayList();
            for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                d.a.n0.m0.z.b.c cVar = new d.a.n0.m0.z.b.c();
                cVar.f57439e = forumEmotionPackageData;
                arrayList.add(cVar);
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new d.a.n0.m0.z.b.a());
            }
            this.j.e(arrayList);
        }
        this.j.d();
    }
}
