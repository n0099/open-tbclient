package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e96;
import com.repackage.ft4;
import com.repackage.ib6;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.oc6;
import com.repackage.q96;
import com.repackage.uc6;
import com.repackage.yc6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements ft4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oc6 mCallback;
    public String mForumId;
    public String mForumName;
    public List<jn> mListViewData;
    public e96 mModel;
    public NoNetworkView.b mNetworkChangeListener;
    public uc6 mPageInfo;
    public q96 mView;

    /* loaded from: classes3.dex */
    public class a implements oc6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumMemberActivity a;

        public a(ForumMemberActivity forumMemberActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumMemberActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumMemberActivity;
        }

        @Override // com.repackage.oc6
        public void a(int i, int i2, yc6 yc6Var, ArrayList<jn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), yc6Var, arrayList}) == null) {
                this.a.mView.d();
                this.a.mView.c();
                if (arrayList != null) {
                    Iterator<jn> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next() instanceof ib6) {
                            it.remove();
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    this.a.mView.e();
                    this.a.mListViewData = arrayList;
                    this.a.mView.f(this.a.mListViewData);
                } else if (!ListUtils.isEmpty(this.a.mListViewData) || yc6Var == null) {
                } else {
                    this.a.mView.l(yc6Var.f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumMemberActivity a;

        public b(ForumMemberActivity forumMemberActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumMemberActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumMemberActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.mView.b(z);
                if (z) {
                    if (ListUtils.isEmpty(this.a.mListViewData)) {
                        this.a.startFirstTimeLoad();
                    } else {
                        this.a.mView.m();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || interceptable.invokeL(65541, this, bundle) == null) {
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
            uc6 uc6Var = new uc6();
            this.mPageInfo = uc6Var;
            uc6Var.b = this.mForumId;
            uc6Var.a = this.mForumName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFirstTimeLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mView.k();
            this.mModel.s(3, 0, this.mPageInfo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.h(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            initBundle(bundle);
            q96 q96Var = new q96(this);
            this.mView = q96Var;
            q96Var.j(this.mNetworkChangeListener);
            e96 e96Var = new e96();
            this.mModel = e96Var;
            e96Var.E(getUniqueId());
            this.mModel.init();
            this.mModel.v(this.mCallback);
            startFirstTimeLoad();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            this.mModel.i();
            q96 q96Var = this.mView;
            if (q96Var != null) {
                q96Var.i();
            }
        }
    }

    @Override // com.repackage.ft4.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mModel.s(3, 0, this.mPageInfo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && ji.A()) {
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
