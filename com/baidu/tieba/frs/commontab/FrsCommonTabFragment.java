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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.au4;
import com.baidu.tieba.bc5;
import com.baidu.tieba.bx4;
import com.baidu.tieba.ca8;
import com.baidu.tieba.dh;
import com.baidu.tieba.dz;
import com.baidu.tieba.ej;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.gg6;
import com.baidu.tieba.jd8;
import com.baidu.tieba.kq6;
import com.baidu.tieba.o16;
import com.baidu.tieba.o85;
import com.baidu.tieba.ot4;
import com.baidu.tieba.pu6;
import com.baidu.tieba.sj6;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tj6;
import com.baidu.tieba.uj6;
import com.baidu.tieba.wk8;
import com.baidu.tieba.xh6;
import com.baidu.tieba.xs6;
import com.baidu.tieba.zh6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.j, xh6, zh6, jd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final RecyclerView.OnScrollListener F;
    public sj6 a;
    public tj6 b;
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
    public o85 q;
    public ThreadCardViewHolder r;
    public int s;
    public int t;
    public long u;
    public int v;
    public int w;
    public boolean x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;
        public final /* synthetic */ FrsCommonTabFragment b;

        public a(FrsCommonTabFragment frsCommonTabFragment, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, au4Var};
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
            this.a = au4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            au4 au4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (au4Var = this.a) == null) {
                return;
            }
            au4Var.dismiss();
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.q == null || !this.a.q.isViewAttached()) {
                return;
            }
            this.a.B1(num.intValue());
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
                    sj6 sj6Var = frsCommonTabFragment.a;
                    if (sj6Var != null) {
                        sj6Var.z(0);
                    }
                    if (this.a.q != null && this.a.q.isViewAttached()) {
                        this.a.onNetRefreshButtonClicked();
                        return;
                    }
                    sj6 sj6Var2 = this.a.a;
                    if (sj6Var2 != null) {
                        sj6Var2.x(true);
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            sj6 sj6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || (sj6Var = this.a.a) == null) {
                    return;
                }
                sj6Var.m(str);
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            sj6 sj6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (sj6Var = this.a.a) != null) {
                    ca8 i = sj6Var.i();
                    if (i != null && i.j() != null && (i.j().getTag() instanceof ThreadCardViewHolder)) {
                        this.a.r = (ThreadCardViewHolder) i.j().getTag();
                    }
                    if (this.a.r == null || this.a.r.a() == null) {
                        return;
                    }
                    this.a.r.a().o(new dz.a(3));
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.a.u = ((Long) customResponsedMessage.getData()).longValue();
            ArrayList<Cdo> arrayList = this.a.b.f().c;
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                Cdo cdo = arrayList.get(i);
                if ((cdo instanceof ot4) && TextUtils.equals(((ot4) cdo).t.getTid(), String.valueOf(this.a.u))) {
                    this.a.v = i;
                    return;
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
                    wk8.g().h(this.a.getUniqueId(), true);
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

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;
        public final /* synthetic */ FrsCommonTabFragment b;

        public j(FrsCommonTabFragment frsCommonTabFragment, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, au4Var};
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
            this.a = au4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            au4 au4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (au4Var = this.a) == null) {
                return;
            }
            au4Var.dismiss();
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null) {
            return;
        }
        this.b.a(threadData);
    }

    public void B1(int i2) {
        o85 o85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (o85Var = this.q) != null && o85Var.isViewAttached()) {
            this.q.a(i2);
        }
    }

    public final void C1() {
        sj6 sj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(gg6.h().i()) || (sj6Var = this.a) == null || sj6Var.j() == null || this.a.j().getData() == null) {
            return;
        }
        ArrayList<Cdo> arrayList = this.b.f().c;
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<Cdo> it = arrayList.iterator();
        List<Cdo> data = this.a.j().getData();
        int count = ListUtils.getCount(gg6.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            Cdo next = it.next();
            ThreadData threadData = null;
            if (next instanceof ot4) {
                threadData = ((ot4) next).t;
            } else if (next instanceof ThreadData) {
                threadData = (ThreadData) next;
            }
            if (threadData != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(gg6.h().i().get(i3).getId(), threadData.getId())) {
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

    public String E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    public int F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d0301 : invokeV.intValue;
    }

    public sj6 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (sj6) invokeV.objValue;
    }

    public tj6 H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (tj6) invokeV.objValue;
    }

    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.w : invokeV.intValue;
    }

    public final boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String string = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0993);
            FrsViewData frsViewData = this.d;
            return (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.d.getForum().getFirst_class()) || !this.d.getForum().getFirst_class().equals(string)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (ej.D()) {
                VoiceManager voiceManager = this.o;
                if (voiceManager != null) {
                    voiceManager.stopPlay();
                }
                tj6 tj6Var = this.b;
                if (tj6Var != null) {
                    tj6Var.k(this.w);
                }
            }
        }
    }

    public void L1(uj6 uj6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, uj6Var) == null) || uj6Var == null) {
            return;
        }
        hideLoadingView(this.c);
        this.w = uj6Var.i;
        sj6 sj6Var = this.a;
        if (sj6Var != null) {
            sj6Var.x(false);
            this.a.r();
            this.a.o(uj6Var);
        }
        if (this.b.j() && this.g == 89) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.FALSE));
        }
        wk8.g().h(getUniqueId(), false);
    }

    public void M1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            C1();
            int i3 = 0;
            int i4 = -1;
            for (Cdo cdo : this.b.f().c) {
                if ((cdo instanceof ot4) && (i2 = ((ot4) cdo).position) != i4) {
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

    public final void N1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ej.D()) {
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            tj6 tj6Var = this.b;
            if (tj6Var != null) {
                tj6Var.o(this.w);
            }
        }
    }

    public void O1() {
        sj6 sj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (sj6Var = this.a) == null) {
            return;
        }
        sj6Var.q();
    }

    public void P1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.w = i2;
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            au4 au4Var = new au4(getActivity());
            au4Var.setContentViewSize(1);
            ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
            professionDialogLayout.setButtonClickListener(new j(this, au4Var));
            professionDialogLayout.setCloseViewClickListener(new a(this, au4Var));
            au4Var.setContentView(professionDialogLayout);
            au4Var.setCancelable(false);
            au4Var.setCanceledOnTouchOutside(false);
            au4Var.create(getPageContext()).show();
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

    @Override // com.baidu.tieba.jd8
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zh6
    public void U0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || getContext() == null) {
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
        sj6 sj6Var = this.a;
        if (sj6Var != null) {
            sj6Var.x(false);
        }
    }

    @Override // com.baidu.tieba.jd8
    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.b.e() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.zh6
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
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
                showNetRefreshView(this.c, errorData != null ? getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c58, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            sj6 sj6Var = this.a;
            if (sj6Var != null) {
                sj6Var.x(false);
            }
        }
    }

    @Override // com.baidu.tieba.xh6
    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public bc5 getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            return new bc5(getUniqueId(), E1(), this.mTbPageExtraPageTabName, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
        }
        return (bc5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.sortType = xs6.g(I1());
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = this.g;
            tbPageTag.tabType = this.h;
            tbPageTag.isGeneralTab = this.j;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view2) == null) {
            sj6 sj6Var = this.a;
            if (sj6Var != null) {
                sj6Var.v(true);
            }
            o85 o85Var = this.q;
            if (o85Var != null) {
                o85Var.dettachView(view2);
            }
        }
    }

    @Override // com.baidu.tieba.jd8
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.baidu.tieba.xh6
    public void m1() {
        sj6 sj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (sj6Var = this.a) == null) {
            return;
        }
        sj6Var.u();
    }

    @Override // com.baidu.tieba.jd8
    public TbPageContext<?> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        sj6 sj6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                String stringExtra = intent.getStringExtra("tid");
                int intExtra = intent.getIntExtra("type", -1);
                if (StringUtils.isNull(stringExtra) || intExtra != 0 || (sj6Var = this.a) == null) {
                    return;
                }
                sj6Var.m(stringExtra);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
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
            VoiceManager t0 = t0();
            this.o = t0;
            t0.onCreate(getPageContext());
            wk8.g().i(getUniqueId());
            tj6 tj6Var = new tj6(this, dh.e(this.e, 0), this.g, this.i, this.j);
            this.b = tj6Var;
            tj6Var.r(this.h);
            this.b.p(pu6.a(this.x));
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
            sj6 sj6Var = new sj6(this, inflate, this.d);
            this.a = sj6Var;
            sj6Var.y(this.F);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            wk8.g().k(getUniqueId());
            o16.b().e(false);
            MessageManager.getInstance().unRegisterListener(this.y);
            MessageManager.getInstance().unRegisterListener(this.C);
            super.onDestroy();
            sj6 sj6Var = this.a;
            if (sj6Var != null) {
                sj6Var.n();
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
            sj6 sj6Var = this.a;
            if (sj6Var != null) {
                sj6Var.p();
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
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                sj6 sj6Var = this.a;
                if (sj6Var != null) {
                    sj6Var.s();
                }
                if (this.p) {
                    this.p = false;
                    if (this.g == 502) {
                        if (bx4.k().h("first_into_tab_profession", true) && !J1()) {
                            bx4.k().u("first_into_tab_profession", false);
                            Q1();
                        }
                        new kq6(getPageContext()).f(this.e);
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
                sj6 sj6Var2 = this.a;
                if (sj6Var2 != null) {
                    sj6Var2.p();
                }
            }
            sj6 sj6Var3 = this.a;
            if (sj6Var3 != null && this.u != 0) {
                sj6Var3.t(this.v + 1);
            }
            this.u = 0L;
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
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
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
            wk8.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048621, this, view2, str, z) == null) {
            sj6 sj6Var = this.a;
            if (sj6Var != null) {
                sj6Var.v(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.q == null) {
                this.q = new o85(getPageContext().getContext(), getNetRefreshListener());
            }
            this.q.e(null);
            this.q.d(str);
            this.q.c(null);
            this.q.attachView(view2, z);
            this.q.f();
            this.q.a(0);
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

    @Override // com.baidu.tieba.xh6
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            m1();
            sj6 sj6Var = this.a;
            if (sj6Var != null) {
                sj6Var.x(true);
            }
        }
    }
}
