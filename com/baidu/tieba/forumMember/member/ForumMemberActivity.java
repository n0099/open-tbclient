package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.q0.s.f0.f;
import c.a.r0.v0.c.d;
import c.a.r0.x0.b1;
import c.a.r0.x0.s0;
import c.a.r0.x0.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s0 mCallback;
    public String mForumId;
    public String mForumName;
    public List<n> mListViewData;
    public d mModel;
    public NoNetworkView.b mNetworkChangeListener;
    public y0 mPageInfo;
    public c.a.r0.v0.c.o.b mView;

    /* loaded from: classes7.dex */
    public class a implements s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumMemberActivity f50796a;

        public a(ForumMemberActivity forumMemberActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumMemberActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50796a = forumMemberActivity;
        }

        @Override // c.a.r0.x0.s0
        public void a(int i2, int i3, b1 b1Var, ArrayList<n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), b1Var, arrayList}) == null) {
                this.f50796a.mView.d();
                this.f50796a.mView.c();
                if (arrayList != null) {
                    Iterator<n> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next() instanceof c.a.r0.x0.n) {
                            it.remove();
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    this.f50796a.mView.e();
                    this.f50796a.mListViewData = arrayList;
                    this.f50796a.mView.f(this.f50796a.mListViewData);
                } else if (!ListUtils.isEmpty(this.f50796a.mListViewData) || b1Var == null) {
                } else {
                    this.f50796a.mView.l(b1Var.f26658f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumMemberActivity f50797e;

        public b(ForumMemberActivity forumMemberActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumMemberActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50797e = forumMemberActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f50797e.mView.b(z);
                if (z) {
                    if (ListUtils.isEmpty(this.f50797e.mListViewData)) {
                        this.f50797e.startFirstTimeLoad();
                    } else {
                        this.f50797e.mView.m();
                    }
                }
            }
        }
    }

    public ForumMemberActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mListViewData = null;
        this.mCallback = new a(this);
        this.mNetworkChangeListener = new b(this);
    }

    private void initBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bundle) == null) {
            if (bundle == null) {
                if (getIntent() == null) {
                    return;
                }
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
            } else {
                this.mForumId = bundle.getString("forum_id", "");
                this.mForumName = bundle.getString("forum_name", "");
            }
            y0 y0Var = new y0();
            this.mPageInfo = y0Var;
            y0Var.f28222b = this.mForumId;
            y0Var.f28221a = this.mForumName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFirstTimeLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mView.k();
            this.mModel.q(3, 0, this.mPageInfo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.h(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            initBundle(bundle);
            c.a.r0.v0.c.o.b bVar = new c.a.r0.v0.c.o.b(this);
            this.mView = bVar;
            bVar.j(this.mNetworkChangeListener);
            d dVar = new d();
            this.mModel = dVar;
            dVar.E(getUniqueId());
            this.mModel.init();
            this.mModel.t(this.mCallback);
            startFirstTimeLoad();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            this.mModel.g();
            c.a.r0.v0.c.o.b bVar = this.mView;
            if (bVar != null) {
                bVar.i();
            }
        }
    }

    @Override // c.a.q0.s.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mModel.q(3, 0, this.mPageInfo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && j.A()) {
            startFirstTimeLoad();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("forum_id", this.mForumId);
            bundle.putString("forum_name", this.mForumName);
        }
    }
}
