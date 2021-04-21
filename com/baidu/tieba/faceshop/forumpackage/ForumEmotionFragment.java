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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.f0.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.b {

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.l0.z.c.a f15489e;
    public d.b.j0.l0.z.a.c j;

    /* renamed from: f  reason: collision with root package name */
    public ForumEmotionModel f15490f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15491g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15492h = false;
    public boolean i = false;
    public final CustomMessageListener k = new a(2000994);
    public CustomMessageListener l = new b(2921059);
    public final d.b.j0.l0.z.a.a m = new c();
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
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !j.z() || ForumEmotionFragment.this.f15490f == null || ForumEmotionFragment.this.f15489e == null || ForumEmotionFragment.this.f15489e.c() == null || ForumEmotionFragment.this.f15489e.c().getVisibility() != 0) {
                return;
            }
            ForumEmotionFragment.this.f15490f.x(ForumEmotionFragment.this);
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
            ForumEmotionPackageData forumEmotionPackageData;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ForumEmotionPackageData) || (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) == null || ForumEmotionFragment.this.j == null) {
                return;
            }
            ForumEmotionFragment.this.j.g(forumEmotionPackageData);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.j0.l0.z.a.a {
        public c() {
        }

        @Override // d.b.j0.l0.z.a.a
        public void a(int i) {
            ForumEmotionFragment.this.j.d();
            ForumEmotionFragment.this.f15490f.x(ForumEmotionFragment.this);
        }

        @Override // d.b.j0.l0.z.a.a
        public void b() {
            ForumEmotionFragment.this.j.d();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (ForumEmotionFragment.this.f15490f == null || ForumEmotionFragment.this.f15492h) {
                return;
            }
            ForumEmotionFragment.this.f15490f.x(ForumEmotionFragment.this);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (ForumEmotionFragment.this.f15490f == null || ForumEmotionFragment.this.f15492h) {
                return;
            }
            if (ForumEmotionFragment.this.f15490f.v()) {
                ForumEmotionFragment.this.f15489e.p();
                ForumEmotionFragment.this.f15490f.w(ForumEmotionFragment.this);
                return;
            }
            ForumEmotionFragment.this.f15489e.s();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionData f15498e;

        public f(ForumEmotionData forumEmotionData) {
            this.f15498e = forumEmotionData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f15498e.activity_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(ForumEmotionFragment.this.getPageContext(), new String[]{this.f15498e.activity_url});
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void e(ForumEmotionData forumEmotionData) {
        this.f15492h = false;
        this.f15489e.f();
        this.f15489e.h();
        if (forumEmotionData == null) {
            return;
        }
        if (!ListUtils.isEmpty(forumEmotionData.rank_pkg_list)) {
            ArrayList arrayList = new ArrayList();
            for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                d.b.j0.l0.z.b.c cVar = new d.b.j0.l0.z.b.c();
                cVar.f58534e = forumEmotionPackageData;
                arrayList.add(cVar);
            }
            this.j.a(arrayList);
        }
        this.j.d();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.j0.l0.z.c.a aVar = this.f15489e;
        if (aVar != null) {
            aVar.l(i);
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
        d.b.j0.l0.z.c.a aVar = new d.b.j0.l0.z.c.a(getPageContext(), getUniqueId());
        this.f15489e = aVar;
        aVar.n(this.n);
        this.f15489e.o(this.o);
        registerListener(this.k);
        registerListener(this.l);
        if (this.f15490f == null) {
            this.f15490f = new ForumEmotionModel(getPageContext());
        }
        d.b.j0.l0.z.a.c cVar = new d.b.j0.l0.z.a.c(getPageContext(), this.f15489e.b(), this.f15490f);
        this.j = cVar;
        cVar.f(this.m);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = arguments.getBoolean("need_check_login");
        }
        if (!this.i) {
            if (this.f15491g && (forumEmotionModel2 = this.f15490f) != null) {
                forumEmotionModel2.x(this);
                this.f15492h = true;
                this.f15491g = false;
            }
        } else if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.f15491g && (forumEmotionModel = this.f15490f) != null) {
                forumEmotionModel.x(this);
                this.f15492h = true;
                this.f15491g = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.f15489e.d();
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void onFailed(String str) {
        this.f15492h = false;
        this.f15489e.a();
        this.f15489e.g();
        d.b.j0.l0.z.a.c cVar = this.j;
        if (cVar != null && cVar.b() > 0) {
            l.L(getPageContext().getContext(), str);
        } else {
            this.f15489e.r();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.b
    public void s0(ForumEmotionData forumEmotionData) {
        this.f15492h = false;
        this.f15489e.a();
        this.f15489e.f();
        this.f15489e.g();
        this.f15489e.h();
        if (forumEmotionData == null) {
            return;
        }
        this.f15489e.m(forumEmotionData);
        this.f15489e.e().setOnClickListener(new f(forumEmotionData));
        if (forumEmotionData.rank_pkg_list != null) {
            ArrayList arrayList = new ArrayList();
            for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                d.b.j0.l0.z.b.c cVar = new d.b.j0.l0.z.b.c();
                cVar.f58534e = forumEmotionPackageData;
                arrayList.add(cVar);
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new d.b.j0.l0.z.b.a());
            }
            this.j.e(arrayList);
        }
        this.j.d();
    }
}
