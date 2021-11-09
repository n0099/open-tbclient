package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.a.o;
import b.a.q0.a.x;
import b.a.q0.d1.b0;
import b.a.q0.t.c.h0;
import b.a.r0.h1.d.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class RecommendFrsControlFragment extends BaseFragment implements b.a.q0.s.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f49458e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.h1.d.c f49459f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f49460g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49461h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49462i;
    public boolean j;
    public x k;
    public NoNetworkView.b l;
    public x.b m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public boolean t;
    public CustomMessageListener u;
    public b.a.r0.h1.d.b v;
    public ConcernPageView.l w;
    public CustomMessageListener x;

    /* loaded from: classes9.dex */
    public static class ControlModelMessage extends CustomMessage<b.a.r0.h1.d.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ControlModelMessage(b.a.r0.h1.d.c cVar) {
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

    /* loaded from: classes9.dex */
    public class a implements b.a.r0.h1.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49463a;

        public a(RecommendFrsControlFragment recommendFrsControlFragment) {
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
            this.f49463a = recommendFrsControlFragment;
        }

        @Override // b.a.r0.h1.d.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // b.a.r0.h1.d.b
        public void c(int i2, b.a.q0.d1.e eVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), eVar, Integer.valueOf(i3)}) == null) {
                this.f49463a.f49459f.h(1, i2, eVar, 1, i3);
                if (b.a.e.e.p.j.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
            }
        }

        @Override // b.a.r0.h1.d.b
        public void d(int i2, int i3, b.a.q0.d1.e eVar, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, Integer.valueOf(i4)}) == null) {
                this.f49463a.f49459f.h(2, i3, eVar, i2, i4);
                if (b.a.e.e.p.j.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ConcernPageView.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49464a;

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
            this.f49464a = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    if (z2) {
                        this.f49464a.f49459f.b(false);
                        return;
                    }
                    return;
                }
                this.f49464a.f49458e.setShowConcernRedTip(false);
                if (this.f49464a.f49461h) {
                    if (!this.f49464a.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                this.f49464a.f49461h = false;
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void b(b.a.q0.d1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f49464a.f49459f.g("", eVar);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void c(String str, b.a.q0.d1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, eVar) == null) {
                this.f49464a.f49459f.g(str, eVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49465a;

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
            this.f49465a = recommendFrsControlFragment;
        }

        @Override // b.a.r0.h1.d.c.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f49465a.f49458e == null) {
                return;
            }
            this.f49465a.f49458e.setShowConcernRedTip(z);
            if (this.f49465a.isPrimary() && z) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
        }

        @Override // b.a.r0.h1.d.c.d
        public void b(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f49465a.f49458e.updatePersonalizeData(dataRes, z, z2);
            }
        }

        @Override // b.a.r0.h1.d.c.d
        public void c(String str, String str2, int i2, boolean z, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && this.f49465a.f49458e.hasContentData()) {
                this.f49465a.f49458e.updateError(str2, i2, i3);
            }
        }

        @Override // b.a.r0.h1.d.c.d
        public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048579, this, dataRes, z) == null) {
                this.f49465a.f49458e.updateConcernData(dataRes, z);
            }
        }

        @Override // b.a.r0.h1.d.c.d
        public void e(boolean z, b.a.r0.h1.i.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2), str, str2, Boolean.valueOf(z3)}) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends b.a.q0.o0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // b.a.q0.o0.b
        public boolean canStat(b.a.q0.o0.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // b.a.q0.o0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b.a.q0.o0.e.b().c() : invokeV.intValue;
        }

        @Override // b.a.q0.o0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49466a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
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
            this.f49466a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f49466a.f49458e != null && this.f49466a.f49458e.getCurrentTabType() == 1) {
                this.f49466a.f49458e.reloadCurrentTab();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49467e;

        public f(RecommendFrsControlFragment recommendFrsControlFragment) {
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
            this.f49467e = recommendFrsControlFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f49467e.isPrimary() && this.f49467e.f49458e.getCurrentTabType() != 1) {
                this.f49467e.f49458e.reloadCurrentTab();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49468a;

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
            this.f49468a = recommendFrsControlFragment;
        }

        @Override // b.a.q0.a.x.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f49468a.isPrimary() && this.f49468a.k != null) {
                if (b.a.e.e.p.l.D()) {
                    this.f49468a.k.h(true);
                    this.f49468a.k.g();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().a() != null) {
                        UrlManager.getInstance().dealOneLink(this.f49468a.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().a()});
                    }
                    TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "1"));
                    return;
                }
                b.a.e.e.p.l.L(this.f49468a.getContext(), R.string.neterror);
                TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "2"));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49469a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(RecommendFrsControlFragment recommendFrsControlFragment, int i2) {
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
            this.f49469a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f49469a.f49458e != null && this.f49469a.f49458e.getCurrentTabType() != 0) {
                this.f49469a.f49458e.setCurrentTab(0);
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49470a;

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
            this.f49470a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                b.a.q0.s.b0.b.e(this.f49470a.getPageContext().getPageActivity(), 2);
                if (this.f49470a.f49458e == null || this.f49470a.f49458e.getCurrentTabType() == 0) {
                    return;
                }
                this.f49470a.f49458e.setCurrentTab(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49471a;

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
            this.f49471a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f49471a.f49458e == null || this.f49471a.f49458e.getCurrentTabType() == 6) {
                return;
            }
            this.f49471a.f49458e.setFakeClickCurrentTab(6);
        }
    }

    /* loaded from: classes9.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49472a;

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
            this.f49472a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f49472a.k != null) {
                    if (!this.f49472a.l() || this.f49472a.k.d() || !this.f49472a.isResumed() || this.f49472a.j) {
                        if (!this.f49472a.l() && this.f49472a.k.d()) {
                            this.f49472a.k.c();
                        }
                    } else {
                        this.f49472a.k.f();
                    }
                }
                if (!this.f49472a.isPrimary() || (newGodData = TbSingleton.getInstance().getNewGodData()) == null) {
                    return;
                }
                b0.g().k(1, newGodData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49473a;

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
            this.f49473a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f49473a.f49458e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                if (((Integer) data).intValue() == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    if (this.f49473a.f49458e.getCurrentTabType() == 1) {
                        b.a.q0.s.n.b.i().n(true);
                    }
                    if (this.f49473a.isPrimary()) {
                        this.f49473a.f49458e.reloadCurrentTab();
                        return;
                    } else if (this.f49473a.f49458e.getCurrentTabType() == 0) {
                        boolean isShowConcernRedTip = this.f49473a.f49458e.isShowConcernRedTip();
                        TiebaStatic.log(new StatisticItem("c12350").param("obj_type", isShowConcernRedTip ? 1 : 0));
                        if (isShowConcernRedTip) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                            this.f49473a.f49458e.reloadCurrentTab();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                b.a.q0.s.n.b.i().n(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49474a;

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
            this.f49474a = recommendFrsControlFragment;
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
                    this.f49474a.j = true;
                    if (this.f49474a.k == null || !this.f49474a.k.d()) {
                        return;
                    }
                    this.f49474a.k.c();
                    return;
                }
                this.f49474a.j = false;
                if (this.f49474a.k == null || !this.f49474a.isResumed() || !this.f49474a.l() || this.f49474a.k.d()) {
                    return;
                }
                this.f49474a.k.f();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f49475a;

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
            this.f49475a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    this.f49475a.t = false;
                } else if (!TbadkCoreApplication.isLogin() || this.f49475a.t) {
                } else {
                    this.f49475a.f49459f.b(false);
                }
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
        this.f49460g = null;
        this.f49461h = true;
        this.f49462i = true;
        this.j = false;
        this.l = new f(this);
        this.m = new g(this);
        this.n = new h(this, 2001378);
        this.o = new i(this, 2921323);
        this.p = new j(this, 2921445);
        this.q = new k(this, 2001371);
        this.r = new l(this, 2001384);
        this.s = new m(this, 2921392);
        this.u = new n(this, 2001011);
        this.v = new a(this);
        this.w = new b(this);
        this.x = new e(this, 2921455);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.f49458e;
            if (scrollFragmentTabHost != null) {
                return scrollFragmentTabHost.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.q0.o0.a
    public b.a.q0.o0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new d(this) : (b.a.q0.o0.b) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.r0.h1.d.c cVar = new b.a.r0.h1.d.c(getPageContext(), getUniqueId());
            this.f49459f = cVar;
            cVar.j(new c(this));
            MessageManager.getInstance().sendMessage(new ControlModelMessage(this.f49459f));
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            h0 shakeData = TbSingleton.getInstance().getShakeData();
            if (shakeData == null) {
                shakeData = new h0();
            }
            if (shakeData.c() == Long.MAX_VALUE || shakeData.b() == 0 || StringUtils.isNull(shakeData.a())) {
                try {
                    shakeData.parserJson(new JSONObject(b.a.q0.s.e0.b.j().p("shake_data", StringUtil.EMPTY_ARRAY)));
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4014);
            super.onActivityCreated(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4015);
            if (this.f49462i) {
                k();
                SpeedStatsManager.getInstance().addStatsTimeStamp(4016);
                SpeedStatsManager.getInstance().addStatsTimeStamp(4017);
                this.f49458e.initTab(getPageContext(), this.l);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY);
                SpeedStatsManager.getInstance().addStatsTimeStamp(4019);
                this.f49458e.initViewPager(getChildFragmentManager(), this.v, this.w);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY);
                this.f49458e.setScrollShadow(false);
                this.f49458e.setPageUniqueId(getUniqueId());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_START_STAMP_KEY);
                this.f49458e.startFirstLoad();
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY);
                this.t = TbadkCoreApplication.isLogin();
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_START_STAMP_KEY);
                if (TbadkCoreApplication.isLogin() && this.f49458e.getCurrentTabType() != 0) {
                    this.f49459f.b(System.currentTimeMillis() > b.a.q0.s.e0.b.j().l(b.a.q0.s.e0.b.n("concern_unread_tip_next_show_time"), 0L));
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_END_STAMP_KEY);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY);
                b.a.r0.h1.d.a.d().h(System.currentTimeMillis() - b.a.r0.h1.d.a.d().a(1));
                b.a.q0.q0.l.b().G(System.currentTimeMillis() - b.a.r0.h1.d.a.d().a(1));
                if (b.a.q0.b.d.i()) {
                    this.f49458e.showConcernTabForumTips();
                } else {
                    this.f49458e.showConcernTabTips();
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003 && (stringExtra = intent.getStringExtra("tid")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
                if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                    this.f49458e.reloadCurrentTab();
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4000);
            super.onAttach(context);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4001);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            ScrollFragmentTabHost scrollFragmentTabHost = this.f49458e;
            if (scrollFragmentTabHost != null) {
                SkinManager.setBackgroundColor(scrollFragmentTabHost, R.color.CAM_X0202);
                this.f49458e.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4002);
            b.a.r0.h1.d.a.d().g(System.currentTimeMillis(), 1);
            b.a.q0.q0.l.b().F(System.currentTimeMillis());
            super.onCreate(bundle);
            registerListener(this.r);
            registerListener(this.u);
            this.n.setSelfListener(true);
            this.n.setTag(getPageContext().getUniqueId());
            registerListener(this.n);
            registerListener(this.o);
            registerListener(this.p);
            registerListener(this.q);
            registerListener(this.s);
            registerListener(this.x);
            this.k = new x(getContext(), this.m);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4003);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4004);
            if (this.f49458e == null) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
                this.f49458e = scrollFragmentTabHost;
                scrollFragmentTabHost.setDrawingCacheEnabled(false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(4005);
            return this.f49458e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.n);
            this.f49458e.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            ScrollFragmentTabHost scrollFragmentTabHost = this.f49458e;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.setPrimary(isPrimary());
                this.f49458e.dismissConcernTabTips();
            }
            x xVar = this.k;
            if (xVar != null && xVar.d()) {
                this.k.c();
            }
            b0.g().i();
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
            if (this.f49458e == null) {
                return;
            }
            if (isPrimary()) {
                o.b().j(true);
                this.f49458e.logMissionEntranceStatistic();
            } else {
                o.b().j(false);
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
                this.f49458e.setVideoThreadId(str);
                ScrollFragmentTabHost scrollFragmentTabHost = this.f49458e;
                scrollFragmentTabHost.setCurrentTab(scrollFragmentTabHost.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if (UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC.equals(intent.getDataString())) {
                    this.f49458e.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(b.a.q0.a.g.L)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.f49458e.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.f49458e.getCurrentTabType() != 5) {
                            TiebaStatic.log(new StatisticItem("c13888"));
                        }
                        this.f49458e.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.f49458e.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18)) {
                this.f49458e.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", PrefetchEvent.STATE_CLICK);
            } else {
                VoiceManager a2 = b.a.r0.l3.r0.b.a(getActivity());
                if (a2 != null) {
                    a2.stopPlay();
                }
            }
            this.f49458e.setPrimary(isPrimary());
            this.f49458e.onSwitchToHomeTAB();
            if (isPrimary()) {
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(b.a.q0.a.g.G);
                    getActivity().getIntent().removeExtra(b.a.q0.a.g.G);
                }
                if (!"sms".equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        b0.g().k(1, newGodData);
                        return;
                    }
                    return;
                } else if (!TbadkCoreApplication.isLogin() || getActivity() == null || getActivity().getIntent() == null) {
                    return;
                } else {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(b.a.q0.a.g.H);
                    if (StringUtils.isNull(stringExtra2)) {
                        return;
                    }
                    NewGodData newGodData2 = new NewGodData();
                    newGodData2.setFieldId(stringExtra2);
                    b0.g().l(5, newGodData2, false);
                    return;
                }
            }
            b0.g().i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f49462i) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_START_STAMP_KEY);
            }
            super.onResume();
            Boolean bool = this.f49460g;
            if (bool == null) {
                this.f49460g = Boolean.valueOf(b.a.q0.s.k.c().g());
                z = false;
            } else {
                z = bool.booleanValue() != b.a.q0.s.k.c().g();
                this.f49460g = Boolean.valueOf(b.a.q0.s.k.c().g());
            }
            if (z) {
                this.f49458e.forceRefresh();
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.f49458e;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.setPrimary(isPrimary());
                this.f49458e.onResume();
            }
            if (this.k != null && l() && !this.k.d() && !this.j) {
                this.k.f();
            }
            if (this.f49462i) {
                this.f49462i = false;
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (scrollFragmentTabHost = this.f49458e) == null) {
            return;
        }
        scrollFragmentTabHost.notifyDataSetChanged();
    }

    @Override // b.a.q0.s.g
    public void setCurrentSubTab(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("sub_locate_type", 0);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f49458e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setCurrentTab(intExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.setPrimary(z);
            if (z) {
                return;
            }
            this.f49458e.dismissConcernTabTips();
        }
    }
}
