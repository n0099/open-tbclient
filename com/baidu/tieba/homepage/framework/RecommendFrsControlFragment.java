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
import c.a.s0.a.x;
import c.a.s0.e1.d0;
import c.a.s0.t.c.h0;
import c.a.t0.o1.d.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
/* loaded from: classes12.dex */
public class RecommendFrsControlFragment extends BaseFragment implements c.a.s0.s.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f45834e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.o1.d.d f45835f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f45836g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45837h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45838i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f45839j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f45840k;
    public x l;
    public NoNetworkView.b m;
    public x.b n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public boolean u;
    public CustomMessageListener v;
    public c.a.t0.o1.d.c w;
    public ConcernPageView.l x;
    public CustomMessageListener y;

    /* loaded from: classes12.dex */
    public static class ControlModelMessage extends CustomMessage<c.a.t0.o1.d.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ControlModelMessage(c.a.t0.o1.d.d dVar) {
            super(2001406);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
            setData(dVar);
        }
    }

    /* loaded from: classes12.dex */
    public class a implements c.a.t0.o1.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        @Override // c.a.t0.o1.d.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.t0.o1.d.c
        public void c(int i2, c.a.s0.e1.g gVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), gVar, Integer.valueOf(i3)}) == null) {
                this.a.f45835f.h(1, i2, gVar, 1, i3);
                if (c.a.d.f.p.l.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
            }
        }

        @Override // c.a.t0.o1.d.c
        public void d(int i2, int i3, c.a.s0.e1.g gVar, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), gVar, Integer.valueOf(i4)}) == null) {
                this.a.f45835f.h(2, i3, gVar, i2, i4);
                if (c.a.d.f.p.l.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements ConcernPageView.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    if (z2) {
                        this.a.f45835f.b(false);
                        return;
                    }
                    return;
                }
                this.a.f45834e.setShowConcernRedTip(false);
                if (this.a.f45837h) {
                    if (!this.a.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                this.a.f45837h = false;
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void b(c.a.s0.e1.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                this.a.f45835f.g("", gVar);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void c(String str, c.a.s0.e1.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, gVar) == null) {
                this.a.f45835f.g(str, gVar);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f45841e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f45842f;

        public c(RecommendFrsControlFragment recommendFrsControlFragment, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45842f = recommendFrsControlFragment;
            this.f45841e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45842f.onActivityCreatedInternal(this.f45841e);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements d.InterfaceC1256d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        @Override // c.a.t0.o1.d.d.InterfaceC1256d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.f45834e == null) {
                return;
            }
            this.a.f45834e.setShowConcernRedTip(z);
            if (this.a.isPrimary() && z) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
        }

        @Override // c.a.t0.o1.d.d.InterfaceC1256d
        public void b(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.f45834e.updatePersonalizeData(dataRes, z, z2);
            }
        }

        @Override // c.a.t0.o1.d.d.InterfaceC1256d
        public void c(String str, String str2, int i2, boolean z, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && this.a.f45834e.hasContentData()) {
                this.a.f45834e.updateError(str2, i2, i3);
            }
        }

        @Override // c.a.t0.o1.d.d.InterfaceC1256d
        public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048579, this, dataRes, z) == null) {
                this.a.f45834e.updateConcernData(dataRes, z);
            }
        }

        @Override // c.a.t0.o1.d.d.InterfaceC1256d
        public void e(boolean z, c.a.t0.o1.i.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2), str, str2, Boolean.valueOf(z3)}) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends c.a.s0.q0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        @Override // c.a.s0.q0.b
        public boolean canStat(c.a.s0.q0.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.s0.q0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.s0.q0.e.b().c() : invokeV.intValue;
        }

        @Override // c.a.s0.q0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.f45834e != null && this.a.f45834e.getCurrentTabType() == 1) {
                this.a.f45834e.reloadCurrentTab();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendFrsControlFragment f45843e;

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
            this.f45843e = recommendFrsControlFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f45843e.isPrimary() && this.f45843e.f45834e.getCurrentTabType() != 1) {
                this.f45843e.f45834e.reloadCurrentTab();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        @Override // c.a.s0.a.x.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.isPrimary() && this.a.l != null) {
                if (c.a.d.f.p.n.C()) {
                    this.a.l.h(true);
                    this.a.l.g();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().a() != null) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().a()});
                    }
                    TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "1"));
                    return;
                }
                c.a.d.f.p.n.L(this.a.getContext(), R.string.neterror);
                TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "2"));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.f45834e != null && this.a.f45834e.getCurrentTabType() != 0) {
                this.a.f45834e.setCurrentTab(0);
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes12.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c.a.s0.s.d0.b.e(this.a.getPageContext().getPageActivity(), 2);
                if (this.a.f45834e == null || this.a.f45834e.getCurrentTabType() == 0) {
                    return;
                }
                this.a.f45834e.setCurrentTab(0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f45834e == null || this.a.f45834e.getCurrentTabType() == 6) {
                return;
            }
            this.a.f45834e.setFakeClickCurrentTab(6);
        }
    }

    /* loaded from: classes12.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.l != null) {
                    if (!this.a.r() || this.a.l.d() || !this.a.isResumed() || this.a.f45839j) {
                        if (!this.a.r() && this.a.l.d()) {
                            this.a.l.c();
                        }
                    } else {
                        this.a.l.f();
                    }
                }
                if (this.a.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                    d0.g().k(1, newGodData);
                }
                if (TbSingleton.getInstance().personalizedRecSwitchChanged) {
                    this.a.f45840k = true;
                    TbSingleton.getInstance().personalizedRecSwitchChanged = false;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.f45834e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                if (((Integer) data).intValue() == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    if (this.a.f45834e.getCurrentTabType() == 1) {
                        c.a.s0.s.n.b.i().n(true);
                    }
                    if (this.a.isPrimary()) {
                        this.a.f45834e.reloadCurrentTab();
                        return;
                    } else if (this.a.f45834e.getCurrentTabType() == 0) {
                        boolean isShowConcernRedTip = this.a.f45834e.isShowConcernRedTip();
                        TiebaStatic.log(new StatisticItem("c12350").param("obj_type", isShowConcernRedTip ? 1 : 0));
                        if (isShowConcernRedTip) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                            this.a.f45834e.reloadCurrentTab();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                c.a.s0.s.n.b.i().n(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
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
                    this.a.f45839j = true;
                    if (this.a.l == null || !this.a.l.d()) {
                        return;
                    }
                    this.a.l.c();
                    return;
                }
                this.a.f45839j = false;
                if (this.a.l == null || !this.a.isResumed() || !this.a.r() || this.a.l.d()) {
                    return;
                }
                this.a.l.f();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    this.a.u = false;
                } else if (!TbadkCoreApplication.isLogin() || this.a.u || this.a.f45835f == null) {
                } else {
                    this.a.f45835f.b(false);
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
        this.f45836g = null;
        this.f45837h = true;
        this.f45838i = true;
        this.f45839j = false;
        this.f45840k = false;
        this.m = new g(this);
        this.n = new h(this);
        this.o = new i(this, 2001378);
        this.p = new j(this, 2921323);
        this.q = new k(this, 2921445);
        this.r = new l(this, 2001371);
        this.s = new m(this, 2001384);
        this.t = new n(this, 2921392);
        this.v = new o(this, 2001011);
        this.w = new a(this);
        this.x = new b(this);
        this.y = new f(this, 2921455);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.f45834e;
            if (scrollFragmentTabHost != null) {
                return scrollFragmentTabHost.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public c.a.s0.q0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(this) : (c.a.s0.q0.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            c.a.t0.z3.c.b(new c(this, bundle), 3);
        }
    }

    public void onActivityCreatedInternal(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4014);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4015);
            q();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4016);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4017);
            this.f45834e.initTab(getPageContext(), this.m);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4019);
            this.f45834e.initViewPager(getChildFragmentManager(), this.w, this.x);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY);
            this.f45834e.setScrollShadow(false);
            this.f45834e.setPageUniqueId(getUniqueId());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_START_STAMP_KEY);
            this.f45834e.startFirstLoad();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4022);
            this.u = TbadkCoreApplication.isLogin();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_START_STAMP_KEY);
            if (TbadkCoreApplication.isLogin() && this.f45834e.getCurrentTabType() != 0) {
                this.f45835f.b(System.currentTimeMillis() > c.a.s0.s.g0.b.j().l(c.a.s0.s.g0.b.n("concern_unread_tip_next_show_time"), 0L));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY);
            c.a.t0.o1.d.b.d().h(System.currentTimeMillis() - c.a.t0.o1.d.b.d().a(1));
            c.a.s0.s0.l.b().D(System.currentTimeMillis() - c.a.t0.o1.d.b.d().a(1));
            if (c.a.s0.b.d.j()) {
                this.f45834e.showConcernTabForumTips();
            } else {
                this.f45834e.showConcernTabTips();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003 && (stringExtra = intent.getStringExtra("tid")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
                if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                    this.f45834e.reloadCurrentTab();
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4000);
            super.onAttach(context);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4001);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            ScrollFragmentTabHost scrollFragmentTabHost = this.f45834e;
            if (scrollFragmentTabHost != null) {
                SkinManager.setBackgroundColor(scrollFragmentTabHost, R.color.CAM_X0202);
                this.f45834e.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4002);
            c.a.t0.o1.d.b.d().g(System.currentTimeMillis(), 1);
            c.a.s0.s0.l.b().C(System.currentTimeMillis());
            super.onCreate(bundle);
            registerListener(this.s);
            registerListener(this.v);
            this.o.setSelfListener(true);
            this.o.setTag(getPageContext().getUniqueId());
            registerListener(this.o);
            registerListener(this.p);
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.t);
            registerListener(this.y);
            this.l = new x(getContext(), this.n);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4003);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4004);
            if (this.f45834e == null) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
                this.f45834e = scrollFragmentTabHost;
                scrollFragmentTabHost.setDrawingCacheEnabled(false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(4005);
            return this.f45834e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.o);
            this.f45834e.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            ScrollFragmentTabHost scrollFragmentTabHost = this.f45834e;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.setPrimary(isPrimary());
                this.f45834e.dismissConcernTabTips();
            }
            x xVar = this.l;
            if (xVar != null && xVar.d()) {
                this.l.c();
            }
            d0.g().i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                TbSingleton.getInstance().setIsRecommendPage(isPrimary());
            }
            if (this.f45834e == null) {
                return;
            }
            if (isPrimary()) {
                c.a.s0.a.o.b().j(true);
                this.f45834e.logMissionEntranceStatistic();
            } else {
                c.a.s0.a.o.b().j(false);
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
                this.f45834e.setVideoThreadId(str);
                ScrollFragmentTabHost scrollFragmentTabHost = this.f45834e;
                scrollFragmentTabHost.setCurrentTab(scrollFragmentTabHost.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if (UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC.equals(intent.getDataString())) {
                    this.f45834e.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    String stringExtra2 = intent.getStringExtra("sub_tab_code");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(c.a.s0.a.g.N)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.f45834e.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra2)) {
                        this.f45834e.setCurrentTabByCode(stringExtra2);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_code");
                    } else if (intExtra2 == 16) {
                        if (this.f45834e.getCurrentTabType() != 5) {
                            TiebaStatic.log(new StatisticItem("c13888"));
                        }
                        this.f45834e.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.f45834e.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18)) {
                this.f45834e.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager a2 = c.a.t0.w3.r0.b.a(getActivity());
                if (a2 != null) {
                    a2.stopPlay();
                }
            }
            this.f45834e.setPrimary(isPrimary());
            this.f45834e.onSwitchToHomeTAB();
            if (isPrimary()) {
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(c.a.s0.a.g.I);
                    getActivity().getIntent().removeExtra(c.a.s0.a.g.I);
                }
                if (!"sms".equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        d0.g().k(1, newGodData);
                    }
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra3 = getActivity().getIntent().getStringExtra(c.a.s0.a.g.J);
                    if (!StringUtils.isNull(stringExtra3)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra3);
                        d0.g().l(5, newGodData2, false);
                    }
                }
            } else {
                d0.g().i();
            }
            if (isPrimary() && this.f45840k) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921653));
                this.f45840k = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f45838i) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_START_STAMP_KEY);
            }
            super.onResume();
            Boolean bool = this.f45836g;
            if (bool == null) {
                this.f45836g = Boolean.valueOf(c.a.s0.s.k.c().g());
                z = false;
            } else {
                z = bool.booleanValue() != c.a.s0.s.k.c().g();
                this.f45836g = Boolean.valueOf(c.a.s0.s.k.c().g());
            }
            if (z) {
                this.f45834e.forceRefresh();
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.f45834e;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.setPrimary(isPrimary());
                this.f45834e.onResume();
            }
            if (this.l != null && r() && !this.l.d() && !this.f45839j) {
                this.l.f();
            }
            if (this.f45838i) {
                this.f45838i = false;
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (scrollFragmentTabHost = this.f45834e) == null) {
            return;
        }
        scrollFragmentTabHost.notifyDataSetChanged();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.t0.o1.d.d dVar = new c.a.t0.o1.d.d(getPageContext(), getUniqueId());
            this.f45835f = dVar;
            dVar.j(new d(this));
            MessageManager.getInstance().sendMessage(new ControlModelMessage(this.f45835f));
        }
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            h0 shakeData = TbSingleton.getInstance().getShakeData();
            if (shakeData == null) {
                shakeData = new h0();
            }
            if (shakeData.c() == Long.MAX_VALUE || shakeData.b() == 0 || StringUtils.isNull(shakeData.a())) {
                try {
                    shakeData.parserJson(new JSONObject(c.a.s0.s.g0.b.j().p("shake_data", StringUtil.EMPTY_ARRAY)));
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

    @Override // c.a.s0.s.g
    public void setCurrentSubTab(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("sub_locate_type", 0);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f45834e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setCurrentTab(intExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            super.setPrimary(z);
            if (z) {
                return;
            }
            this.f45834e.dismissConcernTabTips();
        }
    }
}
