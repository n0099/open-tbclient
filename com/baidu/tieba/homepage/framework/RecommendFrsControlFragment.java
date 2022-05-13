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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tbadk.switchs.MainTabDataSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.az6;
import com.repackage.du4;
import com.repackage.gz6;
import com.repackage.hn4;
import com.repackage.iu4;
import com.repackage.j95;
import com.repackage.ki;
import com.repackage.kj4;
import com.repackage.ld5;
import com.repackage.ln4;
import com.repackage.mc5;
import com.repackage.mi;
import com.repackage.mu6;
import com.repackage.n85;
import com.repackage.ng;
import com.repackage.nu6;
import com.repackage.om8;
import com.repackage.ou6;
import com.repackage.oz6;
import com.repackage.p85;
import com.repackage.q85;
import com.repackage.sl8;
import com.repackage.tj4;
import com.repackage.vn4;
import com.repackage.zx4;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class RecommendFrsControlFragment extends BaseFragment implements hn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScrollFragmentTabHost a;
    public ou6 b;
    public Boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public tj4 h;
    public Runnable i;
    public NoNetworkView.b j;
    public tj4.b k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public boolean r;
    public CustomMessageListener s;
    public nu6 t;
    public ConcernPageView.l u;
    public CustomMessageListener v;

    /* loaded from: classes3.dex */
    public static class ControlModelMessage extends CustomMessage<ou6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ControlModelMessage(ou6 ou6Var) {
            super(2001406);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ou6Var};
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
            setData(ou6Var);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
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
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    this.a.r = false;
                } else if (!TbadkCoreApplication.isLogin() || this.a.r || this.a.b == null) {
                } else {
                    this.a.b.b(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements nu6 {
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

        @Override // com.repackage.nu6
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.nu6
        public void c(int i, mc5 mc5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), mc5Var, Integer.valueOf(i2)}) == null) {
                this.a.b.i(1, i, mc5Var, 1, i2);
                if (ki.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
            }
        }

        @Override // com.repackage.nu6
        public void d(int i, int i2, mc5 mc5Var, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), mc5Var, Integer.valueOf(i3)}) == null) {
                this.a.b.i(2, i2, mc5Var, i, i3);
                if (ki.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ConcernPageView.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

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
            this.a = recommendFrsControlFragment;
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    if (z2) {
                        this.a.b.b(false);
                        return;
                    }
                    return;
                }
                this.a.a.setShowConcernRedTip(false);
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

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void b(mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mc5Var) == null) {
                this.a.b.h("", mc5Var);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void c(String str, mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mc5Var) == null) {
                this.a.b.h(str, mc5Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ RecommendFrsControlFragment b;

        public d(RecommendFrsControlFragment recommendFrsControlFragment, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFrsControlFragment, bundle};
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
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.Q0(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ou6.d {
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

        @Override // com.repackage.ou6.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.a == null) {
                return;
            }
            this.a.a.setShowConcernRedTip(z);
            if (this.a.isPrimary() && z) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
        }

        @Override // com.repackage.ou6.d
        public void b(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.a.d0(dataRes, z, z2);
            }
        }

        @Override // com.repackage.ou6.d
        public void c(String str, String str2, int i, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && this.a.a.G()) {
                gz6.a("mTabHostError");
                this.a.a.b0(str2, i, i2);
            }
        }

        @Override // com.repackage.ou6.d
        public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048579, this, dataRes, z) == null) {
                this.a.a.a0(dataRes, z);
            }
        }

        @Override // com.repackage.ou6.d
        public void e(boolean z, oz6 oz6Var, boolean z2, String str, String str2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), oz6Var, Boolean.valueOf(z2), str, str2, Boolean.valueOf(z3)}) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends n85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment b;

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
            this.b = recommendFrsControlFragment;
        }

        @Override // com.repackage.n85
        public boolean a(p85 p85Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p85Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.n85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? q85.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.n85
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.a != null && this.a.a.getCurrentTabType() == 1) {
                this.a.a.T();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921653));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        public i(RecommendFrsControlFragment recommendFrsControlFragment) {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.isPrimary() && this.a.a.getCurrentTabType() != 1) {
                this.a.a.T();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements tj4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        public j(RecommendFrsControlFragment recommendFrsControlFragment) {
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

        @Override // com.repackage.tj4.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.isPrimary() && this.a.h != null) {
                if (mi.C()) {
                    this.a.h.h(true);
                    this.a.h.g();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().a() != null) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().a()});
                    }
                    TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "1"));
                    return;
                }
                mi.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c2d);
                TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "2"));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.a != null && this.a.a.getCurrentTabType() != 0) {
                this.a.a.setCurrentTab(0);
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                du4.e(this.a.getPageContext().getPageActivity(), 2);
                if (this.a.a == null || this.a.a.getCurrentTabType() == 0) {
                    return;
                }
                this.a.a.setCurrentTab(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null || this.a.a.getCurrentTabType() == 6) {
                return;
            }
            this.a.a.setFakeClickCurrentTab(6);
        }
    }

    /* loaded from: classes3.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
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
            NewGodData newGodData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.h != null) {
                    if (!this.a.P0() || this.a.h.d() || !this.a.isResumed() || this.a.f) {
                        if (!this.a.P0() && this.a.h.d()) {
                            this.a.h.c();
                        }
                    } else {
                        this.a.h.f();
                    }
                }
                if (this.a.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                    ld5.g().k(1, newGodData);
                }
                if (this.a.a != null && this.a.a.A()) {
                    if (this.a.isPrimary()) {
                        ng.a().postDelayed(this.a.i, 10L);
                    } else {
                        this.a.g = true;
                    }
                }
                if (TbSingleton.getInstance().personalizedRecSwitchChanged) {
                    this.a.g = true;
                    TbSingleton.getInstance().personalizedRecSwitchChanged = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.a == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                if (((Integer) data).intValue() == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    if (this.a.a.getCurrentTabType() == 1) {
                        vn4.i().n(true);
                    }
                    if (this.a.isPrimary()) {
                        this.a.a.T();
                        return;
                    } else if (this.a.a.getCurrentTabType() == 0) {
                        boolean L = this.a.a.L();
                        TiebaStatic.log(new StatisticItem("c12350").param("obj_type", L ? 1 : 0));
                        if (L) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                            this.a.a.T();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                vn4.i().n(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                if (((Boolean) data).booleanValue()) {
                    this.a.f = true;
                    if (this.a.h == null || !this.a.h.d()) {
                        return;
                    }
                    this.a.h.c();
                    return;
                }
                this.a.f = false;
                if (this.a.h == null || !this.a.isResumed() || !this.a.P0() || this.a.h.d()) {
                    return;
                }
                this.a.h.f();
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
        this.c = null;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = false;
        this.i = new h(this);
        this.j = new i(this);
        this.k = new j(this);
        this.l = new k(this, 2001378);
        this.m = new l(this, 2921323);
        this.n = new m(this, 2921445);
        this.o = new n(this, 2001371);
        this.p = new o(this, 2001384);
        this.q = new p(this, 2921392);
        this.s = new a(this, 2001011);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new g(this, 2921455);
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ou6 ou6Var = new ou6(getPageContext(), getUniqueId());
            this.b = ou6Var;
            ou6Var.k(new e(this));
            MessageManager.getInstance().sendMessage(new ControlModelMessage(this.b));
        }
    }

    public final boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            zx4 shakeData = TbSingleton.getInstance().getShakeData();
            if (shakeData == null) {
                shakeData = new zx4();
            }
            if (shakeData.c() == Long.MAX_VALUE || shakeData.b() == 0 || StringUtils.isNull(shakeData.a())) {
                try {
                    shakeData.parserJson(new JSONObject(iu4.k().q("shake_data", StringUtil.EMPTY_ARRAY)));
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

    public void Q0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) || getHost() == null) {
            return;
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(4014);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4015);
        O0();
        SpeedStatsManager.getInstance().addStatsTimeStamp(4016);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4017);
        this.a.I(getPageContext(), this.j);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4019);
        this.a.J(getChildFragmentManager(), this.t, this.u);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY);
        this.a.setScrollShadow(false);
        this.a.setPageUniqueId(getUniqueId());
        if (this.b != null) {
            if (MainTabDataSwitch.isCacheOpen()) {
                RecPersonalizePageModel.g().r(this.b.e());
            } else {
                az6.m().q(this.b.e());
            }
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_START_STAMP_KEY);
        this.a.Z();
        SpeedStatsManager.getInstance().addStatsTimeStamp(4022);
        this.r = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_START_STAMP_KEY);
        if (TbadkCoreApplication.isLogin() && this.a.getCurrentTabType() != 0) {
            boolean z = System.currentTimeMillis() > iu4.k().m(iu4.o("concern_unread_tip_next_show_time"), 0L);
            ou6 ou6Var = this.b;
            if (ou6Var != null) {
                ou6Var.b(z);
            }
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY);
        mu6.d().h(System.currentTimeMillis() - mu6.d().a(1));
        j95.b().C(System.currentTimeMillis() - mu6.d().a(1));
        if (UbsABTestHelper.isConcernForumCardShow()) {
            this.a.W();
        } else {
            this.a.X();
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.m85
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.m85
    public n85 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new f(this) : (n85) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onActivityCreated(bundle);
            om8.b(new d(this, bundle), 3);
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
                    this.a.T();
                }
            }
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
                this.a.P(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4002);
            mu6.d().g(System.currentTimeMillis(), 1);
            j95.b().B(System.currentTimeMillis());
            super.onCreate(bundle);
            registerListener(this.p);
            registerListener(this.s);
            this.l.setSelfListener(true);
            this.l.setTag(getPageContext().getUniqueId());
            registerListener(this.l);
            registerListener(this.m);
            registerListener(this.n);
            this.o.setPriority(Integer.MAX_VALUE);
            registerListener(this.o);
            registerListener(this.q);
            registerListener(this.v);
            this.h = new tj4(getContext(), this.k);
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
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0716, (ViewGroup) null);
                this.a = scrollFragmentTabHost;
                scrollFragmentTabHost.setDrawingCacheEnabled(false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(4005);
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            ng.a().removeCallbacks(this.i);
            MessageManager.getInstance().unRegisterListener(this.l);
            this.a.Q();
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
                this.a.B();
            }
            tj4 tj4Var = this.h;
            if (tj4Var != null && tj4Var.d()) {
                this.h.c();
            }
            ld5.g().i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
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
                kj4.b().j(true);
                this.a.M();
            } else {
                kj4.b().j(false);
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
                VoiceManager a2 = sl8.a(getActivity());
                if (a2 != null) {
                    a2.stopPlay();
                }
            }
            this.a.setPrimary(isPrimary());
            this.a.S();
            if (isPrimary()) {
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(BdUniDispatchSchemeController.PARAM_NEW_GOD_FROM);
                    getActivity().getIntent().removeExtra(BdUniDispatchSchemeController.PARAM_NEW_GOD_FROM);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        ld5.g().k(1, newGodData);
                    }
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra3 = getActivity().getIntent().getStringExtra(BdUniDispatchSchemeController.PARAM_FIELD_ID);
                    if (!StringUtils.isNull(stringExtra3)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra3);
                        ld5.g().l(5, newGodData2, false);
                    }
                }
            } else {
                ld5.g().i();
            }
            if (isPrimary() && this.g) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921653));
                this.g = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.e) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_START_STAMP_KEY);
            }
            super.onResume();
            Boolean bool = this.c;
            if (bool == null) {
                this.c = Boolean.valueOf(ln4.c().g());
                z = false;
            } else {
                z = bool.booleanValue() != ln4.c().g();
                this.c = Boolean.valueOf(ln4.c().g());
            }
            if (z) {
                this.a.D();
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.setPrimary(isPrimary());
                this.a.R();
            }
            if (this.h != null && P0() && !this.h.d() && !this.f) {
                this.h.f();
            }
            if (this.e) {
                this.e = false;
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (scrollFragmentTabHost = this.a) == null) {
            return;
        }
        scrollFragmentTabHost.N();
    }

    @Override // com.repackage.hn4
    public void r0(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("sub_locate_type", 0);
        ScrollFragmentTabHost scrollFragmentTabHost = this.a;
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
            this.a.B();
        }
    }
}
