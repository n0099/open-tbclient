package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.bh7;
import com.baidu.tieba.bn;
import com.baidu.tieba.hf7;
import com.baidu.tieba.ji7;
import com.baidu.tieba.p95;
import com.baidu.tieba.pi7;
import com.baidu.tieba.ui7;
import com.baidu.tieba.ve7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements p95.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pi7 a;
    public String b;
    public String c;
    public List<bn> d;
    public hf7 e;
    public ve7 f;
    public ji7 g;
    public NoNetworkView.b h;

    /* loaded from: classes5.dex */
    public class a implements ji7 {
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

        @Override // com.baidu.tieba.ji7
        public void a(int i, int i2, ui7 ui7Var, ArrayList<bn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ui7Var, arrayList}) == null) {
                this.a.e.d();
                this.a.e.c();
                if (arrayList != null) {
                    Iterator<bn> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next() instanceof bh7) {
                            it.remove();
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    this.a.e.e();
                    this.a.d = arrayList;
                    this.a.e.f(this.a.d);
                } else if (ListUtils.isEmpty(this.a.d) && ui7Var != null) {
                    this.a.e.l(ui7Var.f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.e.b(z);
                if (z) {
                    if (ListUtils.isEmpty(this.a.d)) {
                        this.a.y1();
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

    @Override // com.baidu.tieba.p95.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f.I(3, 0, this.a);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.e.h(i);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("forum_id", this.c);
            bundle.putString("forum_name", this.b);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            x1(bundle);
            hf7 hf7Var = new hf7(this);
            this.e = hf7Var;
            hf7Var.j(this.h);
            ve7 ve7Var = new ve7();
            this.f = ve7Var;
            ve7Var.C(getUniqueId());
            this.f.init();
            this.f.M(this.g);
            y1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.f.q();
            hf7 hf7Var = this.e;
            if (hf7Var != null) {
                hf7Var.i();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            return;
        }
        y1();
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.k();
            this.f.I(3, 0, this.a);
        }
    }

    public final void x1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
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
            pi7 pi7Var = new pi7();
            this.a = pi7Var;
            pi7Var.b = this.c;
            pi7Var.a = this.b;
        }
    }
}
