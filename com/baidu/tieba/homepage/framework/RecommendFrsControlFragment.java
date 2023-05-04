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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.a55;
import com.baidu.tieba.as9;
import com.baidu.tieba.cw4;
import com.baidu.tieba.d9;
import com.baidu.tieba.f55;
import com.baidu.tieba.fn5;
import com.baidu.tieba.ft9;
import com.baidu.tieba.gm5;
import com.baidu.tieba.gt9;
import com.baidu.tieba.hc5;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.tieba.hq5;
import com.baidu.tieba.ii;
import com.baidu.tieba.im5;
import com.baidu.tieba.ir9;
import com.baidu.tieba.iw4;
import com.baidu.tieba.jg;
import com.baidu.tieba.jm5;
import com.baidu.tieba.n95;
import com.baidu.tieba.op7;
import com.baidu.tieba.oq4;
import com.baidu.tieba.pp7;
import com.baidu.tieba.pt4;
import com.baidu.tieba.rp7;
import com.baidu.tieba.ru7;
import com.baidu.tieba.sprite.homepage.HomeSpriteShowController;
import com.baidu.tieba.xq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecommendFrsControlFragment extends BaseFragment implements cw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScrollFragmentTabHost a;
    public rp7 b;
    public Boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public xq4 h;
    public boolean i;
    public n j;
    public HomeSpriteShowController k;
    public Runnable l;
    public xq4.b m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public final CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public pp7 t;
    public ConcernPageView.s u;
    public CustomMessageListener v;

    /* loaded from: classes4.dex */
    public static class ControlModelMessage extends CustomMessage<rp7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ControlModelMessage(rp7 rp7Var) {
            super(2001406);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setData(rp7Var);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ConcernPageView.s {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.s
        public void b(hq5 hq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hq5Var) == null) {
                this.a.b.g("", hq5Var);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.s
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
                if (this.a.a != null) {
                    this.a.a.setShowConcernRedTip(false);
                }
                if (this.a.d) {
                    if (!this.a.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                this.a.d = false;
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.s
        public void c(String str, hq5 hq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, hq5Var) == null) {
                this.a.b.g(str, hq5Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements rp7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        @Override // com.baidu.tieba.rp7.c
        public void d(boolean z, ru7 ru7Var, boolean z2, String str, String str2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), ru7Var, Boolean.valueOf(z2), str, str2, Boolean.valueOf(z3)}) == null) {
            }
        }

        public b(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.rp7.c
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.a.a == null) {
                return;
            }
            this.a.a.w0(dataRes, z, z2);
        }

        @Override // com.baidu.tieba.rp7.c
        public void b(String str, String str2, int i, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) != null) || this.a.a == null || !this.a.a.X()) {
                return;
            }
            this.a.a.u0(str2, i, i2);
        }

        @Override // com.baidu.tieba.rp7.c
        public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, dataRes, z) != null) || this.a.a == null) {
                return;
            }
            this.a.a.t0(dataRes, z);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends gm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment b;

        @Override // com.baidu.tieba.gm5
        public boolean a(im5 im5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, im5Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.gm5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public c(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.gm5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return jm5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i)};
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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.a != null && this.a.a.getCurrentTabType() == 1) {
                this.a.a.l0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendFrsControlFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921653, this.a.j));
                this.a.j = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements xq4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        public f(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.xq4.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.isPrimary() && this.a.h != null) {
                if (ii.F()) {
                    this.a.h.h(true);
                    this.a.h.g();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().a() != null) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().a()});
                    }
                    TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "1"));
                    return;
                }
                ii.P(this.a.getContext(), R.string.obfuscated_res_0x7f0f0d30);
                TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "2"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i)};
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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                if (this.a.a != null && this.a.a.getCurrentTabType() != 0) {
                    this.a.a.setCurrentTab(0);
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i)};
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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                a55.e(this.a.getPageContext().getPageActivity(), 2);
                if (this.a.a != null && this.a.a.getCurrentTabType() != 0) {
                    this.a.a.setCurrentTab(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i)};
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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.h != null) {
                    if (this.a.S1() && !this.a.h.d() && this.a.isResumed() && !this.a.f) {
                        this.a.h.f();
                    } else if (!this.a.S1() && this.a.h.d()) {
                        this.a.h.c();
                    }
                }
                if (this.a.a != null && this.a.a.R()) {
                    RecommendFrsControlFragment recommendFrsControlFragment = this.a;
                    recommendFrsControlFragment.j = new n(recommendFrsControlFragment.a.getCurrentTabType(), this.a.a.getCurrentSecondName());
                    if (this.a.isPrimary()) {
                        jg.a().postDelayed(this.a.l, 10L);
                    } else {
                        this.a.g = true;
                    }
                }
                if (!TbSingleton.getInstance().personalizedRecSwitchChanged) {
                    return;
                }
                this.a.g = true;
                TbSingleton.getInstance().personalizedRecSwitchChanged = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i)};
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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && this.a.isPrimary() && BdNetTypeUtil.isNetWorkAvailable() && this.a.a != null && this.a.a.getCurrentTabType() != 1) {
                this.a.a.l0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i)};
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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.a != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof Integer)) {
                    return;
                }
                int intValue = ((Integer) data).intValue();
                if (this.a.getActivity() != null && this.a.getActivity().getIntent() != null) {
                    String stringExtra = this.a.getActivity().getIntent().getStringExtra(MainTabActivityConfig.PUSH_TID);
                    if (!TextUtils.isEmpty(stringExtra)) {
                        TbSingleton.getInstance().setPushTid(stringExtra);
                        this.a.getActivity().getIntent().putExtra(MainTabActivityConfig.PUSH_TID, "");
                        this.a.a.setCurrentTab(1);
                    }
                } else {
                    TbSingleton.getInstance().setPushTid(null);
                }
                if (intValue == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    if (!this.a.isPrimary() && TextUtils.isEmpty(TbSingleton.getInstance().getPushTid())) {
                        if (this.a.a.getCurrentTabType() == 0) {
                            boolean c0 = this.a.a.c0();
                            TiebaStatic.log(new StatisticItem("c12350").param("obj_type", c0 ? 1 : 0));
                            if (c0) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                this.a.a.l0();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.a.a.l0();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, Integer.valueOf(i)};
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
            this.a = recommendFrsControlFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof Boolean)) {
                return;
            }
            if (((Boolean) data).booleanValue()) {
                this.a.f = true;
                if (this.a.h != null && this.a.h.d()) {
                    this.a.h.c();
                    return;
                }
                return;
            }
            this.a.f = false;
            if (this.a.h != null && this.a.isResumed() && this.a.S1() && !this.a.h.d()) {
                this.a.h.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements pp7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        @Override // com.baidu.tieba.pp7
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public m(RecommendFrsControlFragment recommendFrsControlFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.pp7
        public void c(int i, hq5 hq5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), hq5Var, Integer.valueOf(i2)}) == null) {
                this.a.b.h(1, i, hq5Var, 1, i2);
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
            }
        }

        @Override // com.baidu.tieba.pp7
        public void d(int i, int i2, hq5 hq5Var, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), hq5Var, Integer.valueOf(i3)}) == null) {
                this.a.b.h(2, i2, hq5Var, i, i3);
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;

        public n(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.a = i;
            this.b = str;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
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
        this.c = null;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = false;
        this.i = false;
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this, 2001378);
        this.o = new h(this, 2921323);
        this.p = new i(this, 2001371);
        this.q = new j(this, 2000994);
        this.r = new k(this, 2001384);
        this.s = new l(this, 2921392);
        this.t = new m(this);
        this.u = new a(this);
        this.v = new d(this, 2921455);
    }

    public final boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            n95 shakeData = TbSingleton.getInstance().getShakeData();
            if (shakeData == null) {
                shakeData = new n95();
            }
            if (shakeData.c() == Long.MAX_VALUE || shakeData.b() == 0 || StringUtils.isNull(shakeData.a())) {
                try {
                    shakeData.parserJson(new JSONObject(f55.m().s("shake_data", StringUtil.EMPTY_ARRAY)));
                    TbSingleton.getInstance().setShakeData(shakeData);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            if (currentTimeMillis <= shakeData.c() || currentTimeMillis >= shakeData.b()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onActivityCreated(bundle);
            T1(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4000);
            super.onAttach(context);
            SpeedStatsManager.getInstance().addStatsTimeStamp(4001);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            if (scrollFragmentTabHost != null) {
                SkinManager.setBackgroundColor(scrollFragmentTabHost, R.color.CAM_X0202);
                this.a.e0(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (scrollFragmentTabHost = this.a) != null) {
            scrollFragmentTabHost.d0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            super.setPrimary(z);
            if (!z && (scrollFragmentTabHost = this.a) != null) {
                scrollFragmentTabHost.S();
            }
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            rp7 rp7Var = new rp7(getPageContext(), getUniqueId());
            this.b = rp7Var;
            rp7Var.j(new b(this));
            MessageManager.getInstance().sendMessage(new ControlModelMessage(this.b));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            jg.a().removeCallbacks(this.l);
            MessageManager.getInstance().unRegisterListener(this.n);
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.f0();
            }
            HomeSpriteShowController homeSpriteShowController = this.k;
            if (homeSpriteShowController != null) {
                homeSpriteShowController.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.setPrimary(isPrimary());
                this.a.S();
            }
            xq4 xq4Var = this.h;
            if (xq4Var != null && xq4Var.d()) {
                this.h.c();
            }
            ScrollFragmentTabHost scrollFragmentTabHost2 = this.a;
            if (scrollFragmentTabHost2 != null) {
                scrollFragmentTabHost2.g0();
            }
        }
    }

    public void T1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) != null) || getHost() == null) {
            return;
        }
        as9.a("RecommendFrsControlFragment onActivityCreatedInternal");
        SpeedStatsManager.getInstance().addStatsTimeStamp(4014);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4015);
        R1();
        SpeedStatsManager.getInstance().addStatsTimeStamp(4016);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4017);
        this.a.Z(getPageContext());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4019);
        this.a.a0(getChildFragmentManager(), this.t, this.u);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY);
        this.a.setPageUniqueId(getUniqueId());
        if (this.b != null) {
            RecPersonalizePageModel.e().p(this.b.d());
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_START_STAMP_KEY);
        this.a.s0(false);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY);
        op7.d().h(System.currentTimeMillis() - op7.d().a(1));
        fn5.b().C(System.currentTimeMillis() - op7.d().a(1));
        if (UbsABTestHelper.isConcernForumCardShow()) {
            this.a.q0();
        } else {
            this.a.r0();
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.fm5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            if (scrollFragmentTabHost != null) {
                return scrollFragmentTabHost.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.fm5
    public gm5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new c(this);
        }
        return (gm5) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        ScrollFragmentTabHost scrollFragmentTabHost;
        hc5 homeOperateData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 18003) {
                if (i2 == 25071 && (homeOperateData = TbSingleton.getInstance().getHomeOperateData()) != null) {
                    String b2 = homeOperateData.b();
                    if (!TextUtils.isEmpty(b2) && getContext() != null) {
                        pt4.v(getContext(), null, b2, true);
                    }
                }
            } else if (i3 == -1 && (stringExtra = intent.getStringExtra("tid")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
                if (intent.getIntExtra("type", -1) == 4 && isPrimary() && (scrollFragmentTabHost = this.a) != null) {
                    scrollFragmentTabHost.l0();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4002);
            op7.d().g(System.currentTimeMillis(), 1);
            fn5.b().B(System.currentTimeMillis());
            super.onCreate(bundle);
            registerListener(this.r);
            registerListener(this.q);
            this.n.setSelfListener(true);
            this.n.setTag(getPageContext().getUniqueId());
            registerListener(this.n);
            registerListener(this.o);
            this.p.setPriority(Integer.MAX_VALUE);
            registerListener(this.p);
            registerListener(this.s);
            registerListener(this.v);
            this.h = new xq4(getContext(), this.m);
            this.k = new HomeSpriteShowController(getLifecycle());
            SpeedStatsManager.getInstance().addStatsTimeStamp(4003);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4004);
            if (this.a == null) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07e0, (ViewGroup) null);
                this.a = scrollFragmentTabHost;
                scrollFragmentTabHost.setDrawingCacheEnabled(false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(4005);
            if (WindowGreySwitch.getIsOnNew()) {
                d9.b(this.a);
            }
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
        gt9 h0;
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                TbSingleton.getInstance().setIsRecommendPage(isPrimary());
            }
            if (this.a == null) {
                return;
            }
            if (isPrimary()) {
                oq4.b().j(true);
            } else {
                oq4.b().j(false);
            }
            if (getActivity().getIntent() != null) {
                str = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str2 = getActivity().getIntent().getDataString();
            } else {
                str = null;
                str2 = null;
            }
            if ((!StringUtils.isNull(str) && isPrimary()) || (!StringUtils.isNull(str2) && str2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_VIDEO_SQUARE))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.a.setVideoThreadId(str);
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setCurrentTab(scrollFragmentTabHost.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if (UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC.equals(intent.getDataString())) {
                    this.a.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    String stringExtra2 = intent.getStringExtra("sub_tab_code");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(BdUniDispatchSchemeController.PARAM_HOT_TREND)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.a.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra2)) {
                        this.a.setCurrentTabByCode(stringExtra2);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_code");
                    } else if (intExtra2 == 16) {
                        if (this.a.getCurrentTabType() != 5) {
                            TiebaStatic.log(new StatisticItem("c13888"));
                        }
                        this.a.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.a.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18)) {
                this.a.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager a2 = ir9.a(getActivity());
                if (a2 != null) {
                    a2.stopPlay();
                }
            }
            this.a.setPrimary(isPrimary());
            this.a.i0();
            if (isPrimary() && this.g) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921653, this.j));
                this.g = false;
                this.j = null;
            }
            if (isPrimary() && (getActivity() instanceof ft9) && (h0 = ((ft9) getActivity()).h0()) != null) {
                h0.a();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            as9.a("RecommendFrsControlFragment onResume");
            if (this.e) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_START_STAMP_KEY);
            }
            super.onResume();
            Boolean bool = this.c;
            if (bool == null) {
                this.c = Boolean.valueOf(iw4.c().g());
                z = false;
            } else {
                if (bool.booleanValue() != iw4.c().g()) {
                    z = true;
                } else {
                    z = false;
                }
                this.c = Boolean.valueOf(iw4.c().g());
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            if (scrollFragmentTabHost != null) {
                if (z) {
                    scrollFragmentTabHost.T();
                }
                this.a.setPrimary(isPrimary());
                this.a.h0();
            }
            if (this.h != null && S1() && !this.h.d() && !this.f) {
                this.h.f();
            }
            if (this.e) {
                this.e = false;
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_END_STAMP_KEY);
            }
            if (this.i != WindowGreySwitch.getIsOnNew()) {
                if (WindowGreySwitch.getIsOnNew()) {
                    d9.b(this.a);
                } else {
                    d9.a(this.a);
                }
                this.i = WindowGreySwitch.getIsOnNew();
            }
        }
    }

    @Override // com.baidu.tieba.cw4
    public void r1(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, intent) == null) && intent != null && this.a != null) {
            String stringExtra = intent.getStringExtra("sub_tab_code");
            String stringExtra2 = intent.getStringExtra("sub_tab_name");
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.a.setCurrentTabByCode(stringExtra);
            } else if (!TextUtils.isEmpty(stringExtra2)) {
                this.a.setCurrentTab(stringExtra2);
            } else {
                this.a.setCurrentTab(intExtra);
            }
        }
    }
}
