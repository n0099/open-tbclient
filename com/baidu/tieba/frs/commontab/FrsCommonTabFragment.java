package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.ab8;
import com.baidu.tieba.ah6;
import com.baidu.tieba.du4;
import com.baidu.tieba.eh;
import com.baidu.tieba.eo;
import com.baidu.tieba.er6;
import com.baidu.tieba.ez;
import com.baidu.tieba.f95;
import com.baidu.tieba.fj;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.i26;
import com.baidu.tieba.ie8;
import com.baidu.tieba.kv6;
import com.baidu.tieba.mk6;
import com.baidu.tieba.nk6;
import com.baidu.tieba.ok6;
import com.baidu.tieba.pu4;
import com.baidu.tieba.ri6;
import com.baidu.tieba.sl8;
import com.baidu.tieba.st6;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tc5;
import com.baidu.tieba.ti6;
import com.baidu.tieba.ux4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.j, ri6, ti6, ie8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final RecyclerView.OnScrollListener F;
    public mk6 a;
    public nk6 b;
    public View c;
    public FrsViewData d;
    public String e;
    public String f;
    public int g;
    public int h;
    public String i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public VoiceManager o;
    public boolean p;
    public f95 q;
    public ThreadCardViewHolder r;
    public int s;
    public int t;
    public long u;
    public int v;
    public int w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    public String E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    public int F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d0300 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ti6
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i d1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ri6
    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.ie8
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ FrsCommonTabFragment b;

        public a(FrsCommonTabFragment frsCommonTabFragment, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsCommonTabFragment;
            this.a = pu4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pu4 pu4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (pu4Var = this.a) != null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsCommonTabFragment frsCommonTabFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && this.a.q != null && this.a.q.isViewAttached()) {
                this.a.B1(num.intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsCommonTabFragment frsCommonTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i)};
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
            this.a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int parseInt = Integer.parseInt(data.toString());
                FrsCommonTabFragment frsCommonTabFragment = this.a;
                if (parseInt == frsCommonTabFragment.g) {
                    mk6 mk6Var = frsCommonTabFragment.a;
                    if (mk6Var != null) {
                        mk6Var.z(0);
                    }
                    if (this.a.q != null && this.a.q.isViewAttached()) {
                        this.a.onNetRefreshButtonClicked();
                        return;
                    }
                    mk6 mk6Var2 = this.a.a;
                    if (mk6Var2 != null) {
                        mk6Var2.x(true);
                    }
                    this.a.U0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsCommonTabFragment frsCommonTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i)};
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
            this.a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            mk6 mk6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && (mk6Var = this.a.a) != null) {
                    mk6Var.m(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsCommonTabFragment frsCommonTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i)};
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
            this.a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            mk6 mk6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (mk6Var = this.a.a) != null) {
                    ab8 i = mk6Var.i();
                    if (i != null && i.j() != null && (i.j().getTag() instanceof ThreadCardViewHolder)) {
                        this.a.r = (ThreadCardViewHolder) i.j().getTag();
                    }
                    if (this.a.r != null && this.a.r.a() != null) {
                        this.a.r.a().o(new ez.a(3));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsCommonTabFragment frsCommonTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i)};
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
            this.a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.b.l(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsCommonTabFragment frsCommonTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i)};
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
            this.a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment.h == 100 && frsCommonTabFragment.b.d()) {
                this.a.K1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsCommonTabFragment frsCommonTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i)};
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
            this.a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                this.a.u = ((Long) customResponsedMessage.getData()).longValue();
                ArrayList arrayList = this.a.b.f().c;
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    eo eoVar = (eo) arrayList.get(i);
                    if ((eoVar instanceof du4) && TextUtils.equals(((du4) eoVar).t.getTid(), String.valueOf(this.a.u))) {
                        this.a.v = i;
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;

        public i(FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsCommonTabFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    sl8.g().h(this.a.getUniqueId(), true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.a.t += i2;
                if (this.a.t >= this.a.s * 2 && i2 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ FrsCommonTabFragment b;

        public j(FrsCommonTabFragment frsCommonTabFragment, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsCommonTabFragment;
            this.a = pu4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pu4 pu4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (pu4Var = this.a) != null) {
                pu4Var.dismiss();
            }
        }
    }

    public FrsCommonTabFragment() {
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
        this.n = 3;
        this.p = true;
        this.s = 0;
        this.t = 0;
        this.u = 0L;
        this.v = 0;
        this.w = 0;
        this.y = new b(this, 2921397, true);
        this.z = new c(this, 2001624);
        this.A = new d(this, 2921031);
        this.B = new e(this, 2921381);
        this.C = new f(this, 2016331);
        this.D = new g(this, 2921629);
        this.E = new h(this, 2921630);
        this.F = new i(this);
    }

    public void A1(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, threadData) != null) || threadData == null) {
            return;
        }
        this.b.a(threadData);
    }

    public void B1(int i2) {
        f95 f95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (f95Var = this.q) != null && f95Var.isViewAttached()) {
            this.q.a(i2);
        }
    }

    public void P1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.w = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view2) == null) {
            mk6 mk6Var = this.a;
            if (mk6Var != null) {
                mk6Var.v(true);
            }
            f95 f95Var = this.q;
            if (f95Var != null) {
                f95Var.dettachView(view2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (this.n == 3 && this.a == null) {
                return;
            }
            this.n = i2;
            super.onChangeSkinType(i2);
            this.a.l(i2);
        }
    }

    public final void C1() {
        mk6 mk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !ListUtils.isEmpty(ah6.h().i()) && (mk6Var = this.a) != null && mk6Var.j() != null && this.a.j().getData() != null) {
            ArrayList arrayList = this.b.f().c;
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            Iterator it = arrayList.iterator();
            List<eo> data = this.a.j().getData();
            int count = ListUtils.getCount(ah6.h().i());
            int i2 = 0;
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                ThreadData threadData = null;
                if (eoVar instanceof du4) {
                    threadData = ((du4) eoVar).t;
                } else if (eoVar instanceof ThreadData) {
                    threadData = (ThreadData) eoVar;
                }
                if (threadData != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= count) {
                            break;
                        } else if (StringHelper.equals(((ThreadData) ah6.h().i().get(i3)).getId(), threadData.getId())) {
                            it.remove();
                            data.remove(eoVar);
                            this.a.j().getAdapter().notifyItemRemoved(i2);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                i2++;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                mk6 mk6Var = this.a;
                if (mk6Var != null) {
                    mk6Var.s();
                }
                if (this.p) {
                    this.p = false;
                    if (this.g == 502) {
                        if (ux4.k().h("first_into_tab_profession", true) && !J1()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            ux4.k().u("first_into_tab_profession", false);
                            Q1();
                        }
                        new er6(getPageContext()).f(this.e);
                        onLazyLoad();
                    }
                    int i2 = this.g;
                    if (i2 != 503 && i2 != 504) {
                        if (!this.isLazyLoaded) {
                            onLazyLoad();
                        }
                    } else {
                        onLazyLoad();
                    }
                }
                R1();
            } else {
                mk6 mk6Var2 = this.a;
                if (mk6Var2 != null) {
                    mk6Var2.p();
                }
            }
            mk6 mk6Var3 = this.a;
            if (mk6Var3 != null && this.u != 0) {
                mk6Var3.t(this.v + 1);
            }
            this.u = 0L;
        }
    }

    public final void D1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.e);
            if (i2 == 89) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 502) {
                statisticItem.param("obj_type", 8);
            } else if (i2 == 504) {
                statisticItem.param("obj_type", 11);
            } else {
                int i4 = this.h;
                if (i4 == 3) {
                    statisticItem.param("obj_type", 13);
                } else if (this.j == 1) {
                    statisticItem.param("obj_type", 12);
                } else if (i4 == 102) {
                    statisticItem.param("obj_type", 17);
                }
            }
            statisticItem.param("obj_locate", i3);
            statisticItem.eventStat();
        }
    }

    public mk6 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (mk6) invokeV.objValue;
    }

    public nk6 H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (nk6) invokeV.objValue;
    }

    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !fj.D()) {
            return;
        }
        VoiceManager voiceManager = this.o;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
        nk6 nk6Var = this.b;
        if (nk6Var != null) {
            nk6Var.o(this.w);
        }
    }

    public void O1() {
        mk6 mk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (mk6Var = this.a) != null) {
            mk6Var.q();
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.g == 502) {
            StatisticItem statisticItem = new StatisticItem("c13376");
            statisticItem.param("fid", this.e);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.ie8
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ie8
    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b.e();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public tc5 getTbPageExtra() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            String E1 = E1();
            if (baseFragmentActivity == null) {
                intent = null;
            } else {
                intent = baseFragmentActivity.getIntent();
            }
            return new tc5(getUniqueId(), E1, this.mTbPageExtraPageTabName, intent);
        }
        return (tc5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.sortType = st6.g(I1());
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = this.g;
            tbPageTag.tabType = this.h;
            tbPageTag.isGeneralTab = this.j;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ri6
    public void n1() {
        mk6 mk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (mk6Var = this.a) != null) {
            mk6Var.u();
        }
    }

    @Override // com.baidu.tieba.ie8
    public TbPageContext o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            D1(this.g, 2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.c);
            showLoadingView(this.c, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
            N1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onPause();
            mk6 mk6Var = this.a;
            if (mk6Var != null) {
                mk6Var.p();
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onStop();
            sl8.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.o == null) {
                this.o = VoiceManager.instance();
            }
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ri6
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            n1();
            mk6 mk6Var = this.a;
            if (mk6Var != null) {
                mk6Var.x(true);
            }
        }
    }

    public final boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String string = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f09a0);
            FrsViewData frsViewData = this.d;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.d.getForum().getFirst_class()) && this.d.getForum().getFirst_class().equals(string)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            pu4 pu4Var = new pu4(getActivity());
            pu4Var.setContentViewSize(1);
            ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
            professionDialogLayout.setButtonClickListener(new j(this, pu4Var));
            professionDialogLayout.setCloseViewClickListener(new a(this, pu4Var));
            pu4Var.setContentView(professionDialogLayout);
            pu4Var.setCancelable(false);
            pu4Var.setCanceledOnTouchOutside(false);
            pu4Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tieba.ti6
    public void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || getContext() == null) {
            return;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.c);
            if (this.b.h()) {
                hideLoadingView(this.c);
            } else {
                showLoadingView(this.c, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
            }
            N1();
            return;
        }
        mk6 mk6Var = this.a;
        if (mk6Var != null) {
            mk6Var.x(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            sl8.g().k(getUniqueId());
            i26.b().e(false);
            MessageManager.getInstance().unRegisterListener(this.y);
            MessageManager.getInstance().unRegisterListener(this.C);
            super.onDestroy();
            mk6 mk6Var = this.a;
            if (mk6Var != null) {
                mk6Var.n();
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!fj.D()) {
                return;
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            nk6 nk6Var = this.b;
            if (nk6Var != null) {
                nk6Var.k(this.w);
            }
        }
    }

    public void M1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            C1();
            int i3 = 0;
            int i4 = -1;
            for (eo eoVar : this.b.f().c) {
                if ((eoVar instanceof du4) && (i2 = ((du4) eoVar).position) != i4) {
                    i3++;
                    i4 = i2;
                    continue;
                }
                if (i3 >= 6) {
                    break;
                }
            }
            if (i3 < 6) {
                K1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                showLoadingView(this.c, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
                N1();
                return;
            }
            showNetRefreshView(this.c, null, true);
        }
    }

    public void L1(ok6 ok6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, ok6Var) != null) || ok6Var == null) {
            return;
        }
        hideLoadingView(this.c);
        this.w = ok6Var.i;
        mk6 mk6Var = this.a;
        if (mk6Var != null) {
            mk6Var.x(false);
            this.a.r();
            this.a.o(ok6Var);
        }
        if (this.b.j() && this.g == 89) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.FALSE));
        }
        sl8.g().h(getUniqueId(), false);
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, errorData) == null) {
            hideLoadingView(this.c);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            if (!this.b.h()) {
                String str = null;
                if (errorData != null) {
                    str = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c67, errorData.error_msg, Integer.valueOf(errorData.error_code));
                }
                showNetRefreshView(this.c, str, true);
            }
            mk6 mk6Var = this.a;
            if (mk6Var != null) {
                mk6Var.x(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        mk6 mk6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                String stringExtra = intent.getStringExtra("tid");
                int intExtra = intent.getIntExtra("type", -1);
                if (!StringUtils.isNull(stringExtra) && intExtra == 0 && (mk6Var = this.a) != null) {
                    mk6Var.m(stringExtra);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.g = bundle.getInt(TiebaStatic.Params.TAB_ID);
                this.h = bundle.getInt("tab_type");
                bundle.getString("from");
                this.e = bundle.getString("forum_id");
                this.f = bundle.getString("name");
                this.m = bundle.getBoolean("can_auto_play_video");
                this.k = bundle.getBoolean("need_log");
                this.l = bundle.getBoolean("is_brand_forum");
                this.i = bundle.getString("tab_name");
                this.j = bundle.getInt("is_general_tab");
                this.d = (FrsViewData) bundle.getSerializable("view_data");
                this.x = bundle.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
                if (this.j != 1) {
                    this.w = bundle.getInt("sort_type", 0);
                }
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.g = arguments.getInt(TiebaStatic.Params.TAB_ID);
                    this.h = arguments.getInt("tab_type");
                    arguments.getString("from");
                    this.e = arguments.getString("forum_id");
                    this.f = arguments.getString("name");
                    this.m = arguments.getBoolean("can_auto_play_video");
                    this.k = arguments.getBoolean("need_log");
                    this.l = arguments.getBoolean("is_brand_forum");
                    this.i = arguments.getString("tab_name");
                    this.j = arguments.getInt("is_general_tab");
                    this.d = (FrsViewData) arguments.getSerializable("view_data");
                    this.x = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
                }
            }
            VoiceManager t0 = t0();
            this.o = t0;
            t0.onCreate(getPageContext());
            sl8.g().i(getUniqueId());
            nk6 nk6Var = new nk6(this, eh.e(this.e, 0), this.g, this.i, this.j);
            this.b = nk6Var;
            nk6Var.r(this.h);
            this.b.p(kv6.a(this.x));
            if (this.h == 100) {
                N1();
            }
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.B);
            registerListener(this.C);
            registerListener(this.y);
            registerListener(this.D);
            registerListener(this.E);
            this.s = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(F1(), (ViewGroup) null);
            this.c = inflate;
            mk6 mk6Var = new mk6(this, inflate, this.d);
            this.a = mk6Var;
            mk6Var.y(this.F);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(TiebaStatic.Params.TAB_ID, this.g);
            bundle.putString("forum_id", this.e);
            bundle.putString("name", this.f);
            bundle.putBoolean("can_auto_play_video", this.m);
            bundle.putBoolean("need_log", this.k);
            bundle.putBoolean("is_brand_forum", this.l);
            bundle.putString("tab_name", this.i);
            bundle.putInt("is_general_tab", this.j);
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, this.x);
            if (this.j != 1) {
                bundle.putInt("sort_type", this.w);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048621, this, view2, str, z) == null) {
            mk6 mk6Var = this.a;
            if (mk6Var != null) {
                mk6Var.v(false);
            }
            if (getPageContext() != null && getPageContext().getContext() != null) {
                if (this.q == null) {
                    this.q = new f95(getPageContext().getContext(), getNetRefreshListener());
                }
                this.q.e(null);
                this.q.d(str);
                this.q.c(null);
                this.q.attachView(view2, z);
                this.q.f();
                this.q.a(0);
            }
        }
    }
}
