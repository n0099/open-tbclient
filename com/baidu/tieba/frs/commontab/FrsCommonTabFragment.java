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
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ba8;
import com.repackage.c45;
import com.repackage.dr4;
import com.repackage.js6;
import com.repackage.kx5;
import com.repackage.m00;
import com.repackage.mg;
import com.repackage.mi;
import com.repackage.oe6;
import com.repackage.oi;
import com.repackage.on6;
import com.repackage.oq6;
import com.repackage.p75;
import com.repackage.qe6;
import com.repackage.rq4;
import com.repackage.ug6;
import com.repackage.uo;
import com.repackage.v68;
import com.repackage.vg6;
import com.repackage.wg6;
import com.repackage.wi8;
import com.repackage.wt4;
import com.repackage.yc6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.j, oe6, qe6, ba8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final RecyclerView.OnScrollListener F;
    public ug6 a;
    public vg6 b;
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
    public c45 q;
    public ThreadCardViewHolder r;
    public int s;
    public int t;
    public long u;
    public int v;
    public int w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ FrsCommonTabFragment b;

        public a(FrsCommonTabFragment frsCommonTabFragment, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            dr4 dr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (dr4Var = this.a) == null) {
                return;
            }
            dr4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.q == null || !this.a.q.isViewAttached()) {
                return;
            }
            this.a.L0(num.intValue());
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int parseInt = Integer.parseInt(data.toString());
                FrsCommonTabFragment frsCommonTabFragment = this.a;
                if (parseInt == frsCommonTabFragment.g) {
                    ug6 ug6Var = frsCommonTabFragment.a;
                    if (ug6Var != null) {
                        ug6Var.z(0);
                    }
                    if (this.a.q != null && this.a.q.isViewAttached()) {
                        this.a.onNetRefreshButtonClicked();
                        return;
                    }
                    ug6 ug6Var2 = this.a.a;
                    if (ug6Var2 != null) {
                        ug6Var2.x(true);
                    }
                    this.a.k0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ug6 ug6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || (ug6Var = this.a.a) == null) {
                    return;
                }
                ug6Var.m(str);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ug6 ug6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (ug6Var = this.a.a) != null) {
                    v68 i = ug6Var.i();
                    if (i != null && i.j() != null && (i.j().getTag() instanceof ThreadCardViewHolder)) {
                        this.a.r = (ThreadCardViewHolder) i.j().getTag();
                    }
                    if (this.a.r == null || this.a.r.c() == null) {
                        return;
                    }
                    this.a.r.c().o(new m00.a(3));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.b == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.a.b.l(str);
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment.h == 100 && frsCommonTabFragment.b.d()) {
                this.a.U0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.a.u = ((Long) customResponsedMessage.getData()).longValue();
            ArrayList<uo> arrayList = this.a.b.f().c;
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                uo uoVar = arrayList.get(i);
                if ((uoVar instanceof rq4) && TextUtils.equals(((rq4) uoVar).s.getTid(), String.valueOf(this.a.u))) {
                    this.a.v = i;
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    wi8.g().h(this.a.getUniqueId(), true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.a.t += i2;
                if (this.a.t < this.a.s * 2 || i2 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ FrsCommonTabFragment b;

        public j(FrsCommonTabFragment frsCommonTabFragment, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            dr4 dr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (dr4Var = this.a) == null) {
                return;
            }
            dr4Var.dismiss();
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

    @Override // com.repackage.qe6
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.oe6
    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    public void K0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null) {
            return;
        }
        this.b.a(threadData);
    }

    @Override // com.repackage.ba8
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void L0(int i2) {
        c45 c45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && (c45Var = this.q) != null && c45Var.isViewAttached()) {
            this.q.a(i2);
        }
    }

    public final void M0() {
        ug6 ug6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ListUtils.isEmpty(yc6.h().i()) || (ug6Var = this.a) == null || ug6Var.j() == null || this.a.j().getData() == null) {
            return;
        }
        ArrayList<uo> arrayList = this.b.f().c;
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<uo> it = arrayList.iterator();
        List<uo> data = this.a.j().getData();
        int count = ListUtils.getCount(yc6.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            uo next = it.next();
            ThreadData threadData = null;
            if (next instanceof rq4) {
                threadData = ((rq4) next).s;
            } else if (next instanceof ThreadData) {
                threadData = (ThreadData) next;
            }
            if (threadData != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(yc6.h().i().get(i3).getId(), threadData.getId())) {
                        it.remove();
                        data.remove(next);
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

    public final void N0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.e);
            if (i2 == 89) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 502) {
                statisticItem.param("obj_type", 8);
            } else if (i2 == 504) {
                statisticItem.param("obj_type", 11);
            } else if (this.h == 3) {
                statisticItem.param("obj_type", 13);
            } else if (this.j == 1) {
                statisticItem.param("obj_type", 12);
            }
            statisticItem.param("obj_locate", i3);
            statisticItem.eventStat();
        }
    }

    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.layout.obfuscated_res_0x7f0d030b : invokeV.intValue;
    }

    public ug6 Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (ug6) invokeV.objValue;
    }

    public vg6 R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (vg6) invokeV.objValue;
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : invokeV.intValue;
    }

    public final boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String string = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0960);
            FrsViewData frsViewData = this.d;
            return (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.d.getForum().getFirst_class()) || !this.d.getForum().getFirst_class().equals(string)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (oi.C()) {
                VoiceManager voiceManager = this.o;
                if (voiceManager != null) {
                    voiceManager.stopPlay();
                }
                vg6 vg6Var = this.b;
                if (vg6Var != null) {
                    vg6Var.k(this.w);
                }
            }
        }
    }

    public void V0(wg6 wg6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, wg6Var) == null) || wg6Var == null) {
            return;
        }
        hideLoadingView(this.c);
        this.w = wg6Var.i;
        ug6 ug6Var = this.a;
        if (ug6Var != null) {
            ug6Var.x(false);
            this.a.r();
            this.a.o(wg6Var);
        }
        if (this.b.j() && this.g == 89) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.FALSE));
        }
        wi8.g().h(getUniqueId(), false);
    }

    public void W0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            M0();
            int i3 = 0;
            int i4 = -1;
            for (uo uoVar : this.b.f().c) {
                if ((uoVar instanceof rq4) && (i2 = ((rq4) uoVar).position) != i4) {
                    i3++;
                    i4 = i2;
                    continue;
                }
                if (i3 >= 6) {
                    break;
                }
            }
            if (i3 < 6) {
                U0();
            }
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && oi.C()) {
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            vg6 vg6Var = this.b;
            if (vg6Var != null) {
                vg6Var.o(this.w);
            }
        }
    }

    public void Y0() {
        ug6 ug6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (ug6Var = this.a) == null) {
            return;
        }
        ug6Var.q();
    }

    public void Z0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.w = i2;
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            dr4 dr4Var = new dr4(getActivity());
            dr4Var.setContentViewSize(1);
            ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
            professionDialogLayout.setButtonClickListener(new j(this, dr4Var));
            professionDialogLayout.setCloseViewClickListener(new a(this, dr4Var));
            dr4Var.setContentView(professionDialogLayout);
            dr4Var.setCancelable(false);
            dr4Var.setCanceledOnTouchOutside(false);
            dr4Var.create(getPageContext()).show();
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.g == 502) {
            StatisticItem statisticItem = new StatisticItem("c13376");
            statisticItem.param("fid", this.e);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p75 getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            return new p75(getUniqueId(), O0(), this.mTbPageExtraPageTabName, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
        }
        return (p75) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.sortType = oq6.g(S0());
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = this.g;
            tbPageTag.tabType = this.h;
            tbPageTag.isGeneralTab = this.j;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.o == null) {
                this.o = VoiceManager.instance();
            }
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            ug6 ug6Var = this.a;
            if (ug6Var != null) {
                ug6Var.v(true);
            }
            c45 c45Var = this.q;
            if (c45Var != null) {
                c45Var.dettachView(view2);
            }
        }
    }

    @Override // com.repackage.ba8
    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // com.repackage.qe6
    public void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || getContext() == null) {
            return;
        }
        if (mi.z()) {
            hideNetRefreshView(this.c);
            if (this.b.h()) {
                hideLoadingView(this.c);
            } else {
                showLoadingView(this.c, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b));
            }
            X0();
            return;
        }
        ug6 ug6Var = this.a;
        if (ug6Var != null) {
            ug6Var.x(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ug6 ug6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048604, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                String stringExtra = intent.getStringExtra("tid");
                int intExtra = intent.getIntExtra("type", -1);
                if (StringUtils.isNull(stringExtra) || intExtra != 0 || (ug6Var = this.a) == null) {
                    return;
                }
                ug6Var.m(stringExtra);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            if (this.n == 3 && this.a == null) {
                return;
            }
            this.n = i2;
            super.onChangeSkinType(i2);
            this.a.l(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.g = bundle.getInt("tab_id");
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
                    this.g = arguments.getInt("tab_id");
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
            VoiceManager voiceManager = getVoiceManager();
            this.o = voiceManager;
            voiceManager.onCreate(getPageContext());
            wi8.g().i(getUniqueId());
            vg6 vg6Var = new vg6(this, mg.e(this.e, 0), this.g, this.i, this.j);
            this.b = vg6Var;
            vg6Var.s(this.h);
            this.b.p(js6.a(this.x));
            if (this.h == 100) {
                X0();
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(P0(), (ViewGroup) null);
            this.c = inflate;
            ug6 ug6Var = new ug6(this, inflate, this.d);
            this.a = ug6Var;
            ug6Var.y(this.F);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            wi8.g().k(getUniqueId());
            kx5.b().e(false);
            MessageManager.getInstance().unRegisterListener(this.y);
            MessageManager.getInstance().unRegisterListener(this.C);
            super.onDestroy();
            ug6 ug6Var = this.a;
            if (ug6Var != null) {
                ug6Var.n();
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onLazyLoad();
            if (mi.z()) {
                showLoadingView(this.c, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b));
                X0();
                return;
            }
            showNetRefreshView(this.c, null, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            N0(this.g, 2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && mi.z()) {
            hideNetRefreshView(this.c);
            showLoadingView(this.c, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b));
            X0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onPause();
            ug6 ug6Var = this.a;
            if (ug6Var != null) {
                ug6Var.p();
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                ug6 ug6Var = this.a;
                if (ug6Var != null) {
                    ug6Var.s();
                }
                if (this.p) {
                    this.p = false;
                    if (this.g == 502) {
                        if (wt4.k().h("first_into_tab_profession", true) && !T0()) {
                            wt4.k().u("first_into_tab_profession", false);
                            a1();
                        }
                        new on6(getPageContext()).f(this.e);
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
                b1();
            } else {
                ug6 ug6Var2 = this.a;
                if (ug6Var2 != null) {
                    ug6Var2.p();
                }
            }
            ug6 ug6Var3 = this.a;
            if (ug6Var3 != null && this.u != 0) {
                ug6Var3.t(this.v + 1);
            }
            this.u = 0L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.g);
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

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, errorData) == null) {
            hideLoadingView(this.c);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f089e);
                }
            }
            if (!this.b.h()) {
                showNetRefreshView(this.c, errorData != null ? getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            ug6 ug6Var = this.a;
            if (ug6Var != null) {
                ug6Var.x(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onStop();
            wi8.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.repackage.oe6
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            z0();
            ug6 ug6Var = this.a;
            if (ug6Var != null) {
                ug6Var.x(true);
            }
        }
    }

    @Override // com.repackage.ba8
    public int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.b.e() : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048621, this, view2, str, z) == null) {
            ug6 ug6Var = this.a;
            if (ug6Var != null) {
                ug6Var.v(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.q == null) {
                this.q = new c45(getPageContext().getContext(), getNetRefreshListener());
            }
            this.q.e(null);
            this.q.d(str);
            this.q.c(null);
            this.q.attachView(view2, z);
            this.q.f();
            this.q.a(0);
        }
    }

    @Override // com.repackage.ba8
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.repackage.oe6
    public void z0() {
        ug6 ug6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (ug6Var = this.a) == null) {
            return;
        }
        ug6Var.u();
    }
}
