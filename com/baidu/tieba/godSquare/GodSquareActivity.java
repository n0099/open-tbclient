package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.r.f0.f;
import d.a.s0.z0.c.b;
import java.util.List;
/* loaded from: classes5.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements f.g, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mAttentionListener;
    public b.c mCallBack;
    public boolean mHasMore;
    public d.a.s0.z0.c.b mModel;
    public NoNetworkView.b mNetworkChangeListener;
    public d.a.s0.z0.a mView;
    public boolean needRefreshView;

    /* loaded from: classes5.dex */
    public class a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GodSquareActivity f16365a;

        public a(GodSquareActivity godSquareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godSquareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16365a = godSquareActivity;
        }

        @Override // d.a.s0.z0.c.b.c
        public void a(List<n> list, boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f16365a.mHasMore = z2;
                this.f16365a.mView.a().A(0L);
                this.f16365a.mView.b();
                if (ListUtils.isEmpty(list)) {
                    this.f16365a.mView.d();
                    if (ListUtils.isEmpty(this.f16365a.mModel.f69709e)) {
                        this.f16365a.mView.k(str);
                        return;
                    }
                    this.f16365a.mHasMore = true;
                    if (l.D()) {
                        this.f16365a.showToast(str);
                        return;
                    }
                    return;
                }
                this.f16365a.mView.c();
                if (z) {
                    this.f16365a.mModel.f69709e = list;
                    this.f16365a.mView.m(this.f16365a.mModel.f69709e);
                } else {
                    this.f16365a.mModel.f69709e.addAll(list);
                    this.f16365a.mView.g();
                }
                if (z2) {
                    this.f16365a.mView.f();
                } else {
                    this.f16365a.mView.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GodSquareActivity f16366a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GodSquareActivity godSquareActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godSquareActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16366a = godSquareActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12802c)) {
                    return;
                }
                if (this.f16366a.mModel.g(d.a.c.e.m.b.f(updateAttentionMessage.getData().f12802c, 0L))) {
                    this.f16366a.needRefreshView = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GodSquareActivity f16367e;

        public c(GodSquareActivity godSquareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godSquareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16367e = godSquareActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                if (ListUtils.isEmpty(this.f16367e.mModel.f69709e)) {
                    this.f16367e.loadFirstTime();
                } else {
                    this.f16367e.mView.l();
                }
            }
        }
    }

    public GodSquareActivity() {
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
        this.mHasMore = true;
        this.needRefreshView = false;
        this.mCallBack = new a(this);
        this.mAttentionListener = new b(this, 2001115);
        this.mNetworkChangeListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFirstTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mView.j();
            this.mModel.l();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a009" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.h(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            d.a.s0.z0.a aVar = new d.a.s0.z0.a(this);
            this.mView = aVar;
            aVar.i(this.mNetworkChangeListener);
            this.mModel = new d.a.s0.z0.c.b(this.mCallBack, this);
            registerListener(this.mAttentionListener);
            loadFirstTime();
        }
    }

    @Override // d.a.r0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.needRefreshView = false;
            this.mModel.l();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && j.A()) {
            loadFirstTime();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            this.mView.g();
            if (this.needRefreshView) {
                this.mView.l();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.mHasMore) {
            this.mModel.j();
            this.mView.f();
        }
    }
}
