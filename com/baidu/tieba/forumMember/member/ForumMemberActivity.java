package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.dq7;
import com.baidu.tieba.du7;
import com.baidu.tieba.js7;
import com.baidu.tieba.p55;
import com.baidu.tieba.pi;
import com.baidu.tieba.pq7;
import com.baidu.tieba.rt7;
import com.baidu.tieba.zt7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements p55.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zt7 a;
    public String b;
    public String c;
    public List<pi> d;
    public pq7 e;
    public dq7 f;
    public rt7 g;
    public NoNetworkView.b h;

    /* loaded from: classes6.dex */
    public class a implements rt7 {
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

        @Override // com.baidu.tieba.rt7
        public void a(int i, int i2, du7 du7Var, ArrayList<pi> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), du7Var, arrayList}) == null) {
                this.a.e.d();
                this.a.e.c();
                if (arrayList != null) {
                    Iterator<pi> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next() instanceof js7) {
                            it.remove();
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    this.a.e.e();
                    this.a.d = arrayList;
                    this.a.e.f(this.a.d);
                } else if (ListUtils.isEmpty(this.a.d) && du7Var != null) {
                    this.a.e.l(du7Var.f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void p(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.e.b(z);
                if (z) {
                    if (ListUtils.isEmpty(this.a.d)) {
                        this.a.O0();
                    } else {
                        this.a.e.m();
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
        this.d = null;
        this.g = new a(this);
        this.h = new b(this);
    }

    @Override // com.baidu.tieba.p55.g
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f.J(3, 0, this.a);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.e.h(i);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("forum_id", this.c);
            bundle.putString("forum_name", this.b);
        }
    }

    public final void M0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle == null) {
                if (getIntent() == null) {
                    return;
                }
                this.c = getIntent().getStringExtra("forum_id");
                this.b = getIntent().getStringExtra("forum_name");
            } else {
                this.c = bundle.getString("forum_id", "");
                this.b = bundle.getString("forum_name", "");
            }
            zt7 zt7Var = new zt7();
            this.a = zt7Var;
            zt7Var.b = this.c;
            zt7Var.a = this.b;
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.k();
            this.f.J(3, 0, this.a);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.f.n();
            pq7 pq7Var = this.e;
            if (pq7Var != null) {
                pq7Var.i();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            return;
        }
        O0();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            M0(bundle);
            pq7 pq7Var = new pq7(this);
            this.e = pq7Var;
            pq7Var.j(this.h);
            dq7 dq7Var = new dq7();
            this.f = dq7Var;
            dq7Var.E(getUniqueId());
            this.f.init();
            this.f.N(this.g);
            O0();
        }
    }
}
