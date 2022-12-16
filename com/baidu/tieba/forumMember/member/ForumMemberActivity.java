package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.az4;
import com.baidu.tieba.bi6;
import com.baidu.tieba.fk6;
import com.baidu.tieba.ml6;
import com.baidu.tieba.ni6;
import com.baidu.tieba.sl6;
import com.baidu.tieba.xl6;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements az4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sl6 a;
    public String b;
    public String c;
    public List<xn> d;
    public ni6 e;
    public bi6 f;
    public ml6 g;
    public NoNetworkView.b h;

    /* loaded from: classes4.dex */
    public class a implements ml6 {
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

        @Override // com.baidu.tieba.ml6
        public void a(int i, int i2, xl6 xl6Var, ArrayList<xn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), xl6Var, arrayList}) == null) {
                this.a.e.d();
                this.a.e.c();
                if (arrayList != null) {
                    Iterator<xn> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next() instanceof fk6) {
                            it.remove();
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    this.a.e.e();
                    this.a.d = arrayList;
                    this.a.e.f(this.a.d);
                } else if (ListUtils.isEmpty(this.a.d) && xl6Var != null) {
                    this.a.e.l(xl6Var.f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.e.b(z);
                if (z) {
                    if (ListUtils.isEmpty(this.a.d)) {
                        this.a.B1();
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

    @Override // com.baidu.tieba.az4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f.z(3, 0, this.a);
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

    public final void A1(Bundle bundle) {
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
            sl6 sl6Var = new sl6();
            this.a = sl6Var;
            sl6Var.b = this.c;
            sl6Var.a = this.b;
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.k();
            this.f.z(3, 0, this.a);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.f.k();
            ni6 ni6Var = this.e;
            if (ni6Var != null) {
                ni6Var.i();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            return;
        }
        B1();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            A1(bundle);
            ni6 ni6Var = new ni6(this);
            this.e = ni6Var;
            ni6Var.j(this.h);
            bi6 bi6Var = new bi6();
            this.f = bi6Var;
            bi6Var.E(getUniqueId());
            this.f.init();
            this.f.D(this.g);
            B1();
        }
    }
}
