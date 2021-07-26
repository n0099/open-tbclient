package com.baidu.tieba.homepage.framework;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.a.p;
import d.a.p0.a.y;
import d.a.p0.t.c.f0;
import d.a.q0.e1.d.c;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecommendFrsControlFragment extends BaseFragment implements d.a.p0.s.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f16598e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.e1.d.c f16599f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f16600g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16601h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16602i;
    public y j;
    public NoNetworkView.b k;
    public y.b l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public boolean t;
    public CustomMessageListener u;
    public d.a.q0.e1.d.b v;
    public ConcernPageView.l w;
    public CustomMessageListener x;

    /* loaded from: classes4.dex */
    public static class ControlModelMessage extends CustomMessage<d.a.q0.e1.d.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ControlModelMessage(d.a.q0.e1.d.c cVar) {
            super(2001406);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setData(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16603a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16603a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    this.f16603a.t = false;
                } else if (!TbadkCoreApplication.isLogin() || this.f16603a.t) {
                } else {
                    this.f16603a.f16599f.b(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.q0.e1.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16604a;

        public b(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16604a = recommendFrsControlFragment;
        }

        @Override // d.a.q0.e1.d.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.q0.e1.d.b
        public void c(int i2, d.a.p0.b1.c cVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), cVar, Integer.valueOf(i3)}) == null) {
                this.f16604a.f16599f.h(1, i2, cVar, 1, i3);
                if (d.a.d.e.p.j.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
            }
        }

        @Override // d.a.q0.e1.d.b
        public void d(int i2, int i3, d.a.p0.b1.c cVar, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, Integer.valueOf(i4)}) == null) {
                this.f16604a.f16599f.h(2, i3, cVar, i2, i4);
                if (d.a.d.e.p.j.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ConcernPageView.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16605a;

        public c(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16605a = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    if (z2) {
                        this.f16605a.f16599f.b(false);
                        return;
                    }
                    return;
                }
                this.f16605a.f16598e.setShowConcernRedTip(false);
                if (this.f16605a.f16601h) {
                    if (!this.f16605a.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                this.f16605a.f16601h = false;
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void b(d.a.p0.b1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                this.f16605a.f16599f.g("", cVar);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void c(String str, d.a.p0.b1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
                this.f16605a.f16599f.g(str, cVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16606a;

        public d(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16606a = recommendFrsControlFragment;
        }

        @Override // d.a.q0.e1.d.c.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f16606a.f16598e == null) {
                return;
            }
            this.f16606a.f16598e.setShowConcernRedTip(z);
            if (this.f16606a.isPrimary() && z) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
        }

        @Override // d.a.q0.e1.d.c.d
        public void b(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f16606a.f16598e.a0(dataRes, z, z2);
            }
        }

        @Override // d.a.q0.e1.d.c.d
        public void c(String str, String str2, int i2, boolean z, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && this.f16606a.f16598e.C()) {
                this.f16606a.f16598e.Y(str2, i2, i3);
            }
        }

        @Override // d.a.q0.e1.d.c.d
        public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048579, this, dataRes, z) == null) {
                this.f16606a.f16598e.X(dataRes, z);
            }
        }

        @Override // d.a.q0.e1.d.c.d
        public void e(boolean z, d.a.q0.e1.i.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2), str, str2, Boolean.valueOf(z3)}) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.p0.m0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16607a;

        public e(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16607a = recommendFrsControlFragment;
        }

        @Override // d.a.p0.m0.b
        public boolean canStat(d.a.p0.m0.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.p0.m0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.p0.m0.e.b().c() : invokeV.intValue;
        }

        @Override // d.a.p0.m0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16608a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16608a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f16608a.f16598e != null && this.f16608a.f16598e.getCurrentTabType() == 1) {
                this.f16608a.f16598e.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16609e;

        public g(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16609e = recommendFrsControlFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f16609e.isPrimary() && this.f16609e.f16598e.getCurrentTabType() != 1) {
                this.f16609e.f16598e.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements y.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16610a;

        public h(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16610a = recommendFrsControlFragment;
        }

        @Override // d.a.p0.a.y.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16610a.isPrimary() && this.f16610a.j != null) {
                if (d.a.d.e.p.l.D()) {
                    this.f16610a.j.h(true);
                    this.f16610a.j.g();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().a() != null) {
                        UrlManager.getInstance().dealOneLink(this.f16610a.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().a()});
                    }
                    TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "1"));
                    return;
                }
                d.a.d.e.p.l.L(this.f16610a.getContext(), R.string.neterror);
                TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "2"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16611a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16611a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f16611a.f16598e != null && this.f16611a.f16598e.getCurrentTabType() != 0) {
                this.f16611a.f16598e.setCurrentTab(0);
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16612a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16612a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                d.a.p0.s.a0.b.e(this.f16612a.getPageContext().getPageActivity(), 2);
                if (this.f16612a.f16598e == null || this.f16612a.f16598e.getCurrentTabType() == 0) {
                    return;
                }
                this.f16612a.f16598e.setCurrentTab(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16613a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16613a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16613a.f16598e == null || this.f16613a.f16598e.getCurrentTabType() == 6) {
                return;
            }
            this.f16613a.f16598e.setFakeClickCurrentTab(6);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16614a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16614a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f16614a.j != null) {
                    if (!this.f16614a.X0() || this.f16614a.j.d() || !this.f16614a.isResumed() || this.f16614a.f16602i) {
                        if (!this.f16614a.X0() && this.f16614a.j.d()) {
                            this.f16614a.j.c();
                        }
                    } else {
                        this.f16614a.j.f();
                    }
                }
                if (!this.f16614a.isPrimary() || (newGodData = TbSingleton.getInstance().getNewGodData()) == null) {
                    return;
                }
                d.a.p0.b1.y.g().k(1, newGodData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16615a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16615a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f16615a.f16598e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                if (((Integer) data).intValue() == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    if (this.f16615a.f16598e.getCurrentTabType() == 1) {
                        d.a.p0.s.n.b.i().n(true);
                    }
                    if (this.f16615a.isPrimary()) {
                        this.f16615a.f16598e.R();
                        return;
                    } else if (this.f16615a.f16598e.getCurrentTabType() == 0) {
                        boolean H = this.f16615a.f16598e.H();
                        TiebaStatic.log(new StatisticItem("c12350").param("obj_type", H ? 1 : 0));
                        if (H) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                            this.f16615a.f16598e.R();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                d.a.p0.s.n.b.i().n(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16616a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16616a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f16617a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i2)};
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
            this.f16617a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                if (((Boolean) data).booleanValue()) {
                    this.f16617a.f16602i = true;
                    if (this.f16617a.j == null || !this.f16617a.j.d()) {
                        return;
                    }
                    this.f16617a.j.c();
                    return;
                }
                this.f16617a.f16602i = false;
                if (this.f16617a.j == null || !this.f16617a.isResumed() || !this.f16617a.X0() || this.f16617a.j.d()) {
                    return;
                }
                this.f16617a.j.f();
            }
        }
    }

    public RecommendFrsControlFragment() {
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
        this.f16600g = null;
        this.f16601h = true;
        this.f16602i = false;
        this.k = new g(this);
        this.l = new h(this);
        this.m = new i(this, 2001378);
        this.n = new j(this, 2921323);
        this.o = new k(this, 2921445);
        this.p = new l(this, 2001371);
        this.q = new m(this, 2001384);
        this.r = new n(this, 2921308);
        this.s = new o(this, 2921392);
        this.u = new a(this, 2001011);
        this.v = new b(this);
        this.w = new c(this);
        this.x = new f(this, 2921455);
    }

    @Override // d.a.p0.s.g
    public void B0(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("sub_locate_type", 0);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16598e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setCurrentTab(intExtra);
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.e1.d.c cVar = new d.a.q0.e1.d.c(getPageContext(), getUniqueId());
            this.f16599f = cVar;
            cVar.j(new d(this));
            MessageManager.getInstance().sendMessage(new ControlModelMessage(this.f16599f));
        }
    }

    public final boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            f0 shakeData = TbSingleton.getInstance().getShakeData();
            if (shakeData == null) {
                shakeData = new f0();
            }
            if (shakeData.c() == Long.MAX_VALUE || shakeData.b() == 0 || StringUtils.isNull(shakeData.a())) {
                try {
                    shakeData.parserJson(new JSONObject(d.a.p0.s.d0.b.j().p("shake_data", StringUtil.EMPTY_ARRAY)));
                    TbSingleton.getInstance().setShakeData(shakeData);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return currentTimeMillis > shakeData.c() && currentTimeMillis < shakeData.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.f16598e;
            if (scrollFragmentTabHost != null) {
                return scrollFragmentTabHost.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.m0.a
    public d.a.p0.m0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this) : (d.a.p0.m0.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onActivityCreated(bundle);
            W0();
            this.f16598e.E(getPageContext(), this.k);
            this.f16598e.F(getChildFragmentManager(), this.v, this.w);
            this.f16598e.setScrollShadow(false);
            this.f16598e.setPageUniqueId(getUniqueId());
            this.f16598e.W();
            this.t = TbadkCoreApplication.isLogin();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (TbadkCoreApplication.isLogin() && this.f16598e.getCurrentTabType() != 0) {
                this.f16599f.b(System.currentTimeMillis() > d.a.p0.s.d0.b.j().l(d.a.p0.s.d0.b.n("concern_unread_tip_next_show_time"), 0L));
            }
            d.a.q0.e1.d.a.d().h(System.currentTimeMillis() - d.a.q0.e1.d.a.d().a(1));
            d.a.p0.o0.l.b().G(System.currentTimeMillis() - d.a.q0.e1.d.a.d().a(1));
            if (d.a.p0.b.d.i()) {
                this.f16598e.T();
            } else {
                this.f16598e.U();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003 && (stringExtra = intent.getStringExtra("tid")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
                if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                    this.f16598e.R();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            ScrollFragmentTabHost scrollFragmentTabHost = this.f16598e;
            if (scrollFragmentTabHost != null) {
                SkinManager.setBackgroundColor(scrollFragmentTabHost, R.color.CAM_X0202);
                this.f16598e.N(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            d.a.q0.e1.d.a.d().g(System.currentTimeMillis(), 1);
            d.a.p0.o0.l.b().F(System.currentTimeMillis());
            super.onCreate(bundle);
            registerListener(this.q);
            registerListener(this.u);
            registerListener(this.r);
            this.m.setSelfListener(true);
            this.m.setTag(getPageContext().getUniqueId());
            registerListener(this.m);
            registerListener(this.n);
            registerListener(this.o);
            registerListener(this.p);
            registerListener(this.s);
            registerListener(this.x);
            this.j = new y(getContext(), this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
            this.f16598e = scrollFragmentTabHost;
            scrollFragmentTabHost.setDrawingCacheEnabled(false);
            return this.f16598e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.m);
            this.f16598e.O();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            ScrollFragmentTabHost scrollFragmentTabHost = this.f16598e;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.setPrimary(isPrimary());
                this.f16598e.x();
            }
            y yVar = this.j;
            if (yVar != null && yVar.d()) {
                this.j.c();
            }
            d.a.p0.b1.y.g().i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                TbSingleton.getInstance().setIsRecommendPage(isPrimary());
            }
            if (this.f16598e == null) {
                return;
            }
            if (isPrimary()) {
                p.b().j(true);
                this.f16598e.K();
            } else {
                p.b().j(false);
            }
            if (getActivity().getIntent() != null) {
                str = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str2 = getActivity().getIntent().getDataString();
            } else {
                str = null;
                str2 = null;
            }
            String str3 = "";
            if ((!StringUtils.isNull(str) && isPrimary()) || (!StringUtils.isNull(str2) && str2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_VIDEO_SQUARE))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.f16598e.setVideoThreadId(str);
                ScrollFragmentTabHost scrollFragmentTabHost = this.f16598e;
                scrollFragmentTabHost.setCurrentTab(scrollFragmentTabHost.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if (UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC.equals(intent.getDataString())) {
                    this.f16598e.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(d.a.p0.a.g.I)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.f16598e.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.f16598e.getCurrentTabType() != 5) {
                            TiebaStatic.log(new StatisticItem("c13888"));
                        }
                        this.f16598e.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.f16598e.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18)) {
                this.f16598e.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", PrefetchEvent.STATE_CLICK);
            } else {
                VoiceManager a2 = d.a.q0.h3.p0.b.a(getActivity());
                if (a2 != null) {
                    a2.stopPlay();
                }
            }
            this.f16598e.setPrimary(isPrimary());
            this.f16598e.Q();
            if (isPrimary()) {
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(d.a.p0.a.g.D);
                    getActivity().getIntent().removeExtra(d.a.p0.a.g.D);
                }
                if (!"sms".equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        d.a.p0.b1.y.g().k(1, newGodData);
                        return;
                    }
                    return;
                } else if (!TbadkCoreApplication.isLogin() || getActivity() == null || getActivity().getIntent() == null) {
                    return;
                } else {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(d.a.p0.a.g.E);
                    if (StringUtils.isNull(stringExtra2)) {
                        return;
                    }
                    NewGodData newGodData2 = new NewGodData();
                    newGodData2.setFieldId(stringExtra2);
                    d.a.p0.b1.y.g().l(5, newGodData2, false);
                    return;
                }
            }
            d.a.p0.b1.y.g().i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            Boolean bool = this.f16600g;
            if (bool == null) {
                this.f16600g = Boolean.valueOf(d.a.p0.s.k.c().g());
            } else {
                r1 = bool.booleanValue() != d.a.p0.s.k.c().g();
                this.f16600g = Boolean.valueOf(d.a.p0.s.k.c().g());
            }
            if (r1) {
                this.f16598e.z();
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.f16598e;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.setPrimary(isPrimary());
                this.f16598e.P();
            }
            if (this.j == null || !X0() || this.j.d() || this.f16602i) {
                return;
            }
            this.j.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (scrollFragmentTabHost = this.f16598e) == null) {
            return;
        }
        scrollFragmentTabHost.L();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            super.setPrimary(z);
            if (z) {
                return;
            }
            this.f16598e.x();
        }
    }
}
