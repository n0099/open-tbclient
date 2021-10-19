package com.baidu.tieba.godSquare;

import android.os.Bundle;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.f0.f;
import c.a.r0.c1.c.b;
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
import java.util.List;
/* loaded from: classes7.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements f.g, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mAttentionListener;
    public b.c mCallBack;
    public boolean mHasMore;
    public c.a.r0.c1.c.b mModel;
    public NoNetworkView.b mNetworkChangeListener;
    public c.a.r0.c1.a mView;
    public boolean needRefreshView;

    /* loaded from: classes7.dex */
    public class a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GodSquareActivity f52017a;

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
            this.f52017a = godSquareActivity;
        }

        @Override // c.a.r0.c1.c.b.c
        public void a(List<n> list, boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f52017a.mHasMore = z2;
                this.f52017a.mView.a().completePullRefreshPostDelayed(0L);
                this.f52017a.mView.b();
                if (ListUtils.isEmpty(list)) {
                    this.f52017a.mView.d();
                    if (ListUtils.isEmpty(this.f52017a.mModel.f16103e)) {
                        this.f52017a.mView.k(str);
                        return;
                    }
                    this.f52017a.mHasMore = true;
                    if (l.D()) {
                        this.f52017a.showToast(str);
                        return;
                    }
                    return;
                }
                this.f52017a.mView.c();
                if (z) {
                    this.f52017a.mModel.f16103e = list;
                    this.f52017a.mView.m(this.f52017a.mModel.f16103e);
                } else {
                    this.f52017a.mModel.f16103e.addAll(list);
                    this.f52017a.mView.g();
                }
                if (z2) {
                    this.f52017a.mView.f();
                } else {
                    this.f52017a.mView.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GodSquareActivity f52018a;

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
            this.f52018a = godSquareActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f48113c)) {
                    return;
                }
                if (this.f52018a.mModel.g(c.a.e.e.m.b.g(updateAttentionMessage.getData().f48113c, 0L))) {
                    this.f52018a.needRefreshView = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GodSquareActivity f52019e;

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
            this.f52019e = godSquareActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                if (ListUtils.isEmpty(this.f52019e.mModel.f16103e)) {
                    this.f52019e.loadFirstTime();
                } else {
                    this.f52019e.mView.l();
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

    @Override // com.baidu.tbadk.BaseActivity, c.a.q0.o0.a
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
            c.a.r0.c1.a aVar = new c.a.r0.c1.a(this);
            this.mView = aVar;
            aVar.i(this.mNetworkChangeListener);
            this.mModel = new c.a.r0.c1.c.b(this.mCallBack, this);
            registerListener(this.mAttentionListener);
            loadFirstTime();
        }
    }

    @Override // c.a.q0.s.f0.f.g
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
