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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.j.v0.a;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.s0.n2.i;
import d.a.s0.u0.n2.k;
import d.a.s0.u0.p0;
import d.a.s0.u0.r0;
import d.a.s0.w2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.j, p0, r0, t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public final CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.u0.k1.b f15504e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.u0.k1.c f15505f;

    /* renamed from: g  reason: collision with root package name */
    public View f15506g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f15507h;

    /* renamed from: i  reason: collision with root package name */
    public String f15508i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public VoiceManager s;
    public boolean t;
    public d.a.r0.d0.c u;
    public ThreadCardViewHolder v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f15509a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsCommonTabFragment frsCommonTabFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15509a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f15509a.u == null || !this.f15509a.u.isViewAttached()) {
                return;
            }
            this.f15509a.N0(num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f15510a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f15510a = frsCommonTabFragment;
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
                FrsCommonTabFragment frsCommonTabFragment = this.f15510a;
                if (parseInt == frsCommonTabFragment.k) {
                    d.a.s0.u0.k1.b bVar = frsCommonTabFragment.f15504e;
                    if (bVar != null) {
                        bVar.y(0);
                    }
                    if (this.f15510a.u != null && this.f15510a.u.isViewAttached()) {
                        this.f15510a.onNetRefreshButtonClicked();
                        return;
                    }
                    d.a.s0.u0.k1.b bVar2 = this.f15510a.f15504e;
                    if (bVar2 != null) {
                        bVar2.w(true);
                    }
                    this.f15510a.l0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f15511a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f15511a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.s0.u0.k1.b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || (bVar = this.f15511a.f15504e) == null) {
                    return;
                }
                bVar.m(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f15512a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f15512a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.s0.u0.k1.b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bVar = this.f15512a.f15504e) != null) {
                    i i2 = bVar.i();
                    if (i2 != null && i2.j() != null && (i2.j().getTag() instanceof ThreadCardViewHolder)) {
                        this.f15512a.v = (ThreadCardViewHolder) i2.j().getTag();
                    }
                    if (this.f15512a.v == null || this.f15512a.v.b() == null) {
                        return;
                    }
                    this.f15512a.v.b().o(new a.C0645a(3));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f15513a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f15513a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f15513a.f15505f == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f15513a.f15505f.l(str);
        }
    }

    /* loaded from: classes5.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f15514a;

        public f(FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15514a = frsCommonTabFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    d.a.s0.g3.c.g().h(this.f15514a.getUniqueId(), true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f15514a.x += i3;
                if (this.f15514a.x < this.f15514a.w * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f15515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f15516f;

        public g(FrsCommonTabFragment frsCommonTabFragment, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15516f = frsCommonTabFragment;
            this.f15515e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.r0.r.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f15515e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f15517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f15518f;

        public h(FrsCommonTabFragment frsCommonTabFragment, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15518f = frsCommonTabFragment;
            this.f15517e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.r0.r.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f15517e) == null) {
                return;
            }
            aVar.dismiss();
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
        this.r = 3;
        this.t = true;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.A = new a(this, 2921397, true);
        this.B = new b(this, 2001624);
        this.C = new c(this, 2921031);
        this.D = new d(this, 2921381);
        this.E = new e(this, 2016331);
        this.F = new f(this);
    }

    @Override // d.a.s0.w2.t
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15508i : (String) invokeV.objValue;
    }

    @Override // d.a.s0.u0.p0
    public void E0() {
        d.a.s0.u0.k1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f15504e) == null) {
            return;
        }
        bVar.t();
    }

    @Override // d.a.s0.u0.r0
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void M0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.f15505f.a(b2Var);
    }

    public void N0(int i2) {
        d.a.r0.d0.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && (cVar = this.u) != null && cVar.isViewAttached()) {
            this.u.a(i2);
        }
    }

    @Override // d.a.s0.w2.t
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void O0() {
        d.a.s0.u0.k1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || ListUtils.isEmpty(d.a.s0.u0.a.h().i()) || (bVar = this.f15504e) == null || bVar.j() == null || this.f15504e.j().getData() == null) {
            return;
        }
        ArrayList<n> arrayList = this.f15505f.f().f66225g;
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        List<n> data = this.f15504e.j().getData();
        int count = ListUtils.getCount(d.a.s0.u0.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            b2 b2Var = null;
            if (next instanceof a2) {
                b2Var = ((a2) next).w;
            } else if (next instanceof b2) {
                b2Var = (b2) next;
            }
            if (b2Var != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(d.a.s0.u0.a.h().i().get(i3).c0(), b2Var.c0())) {
                        it.remove();
                        data.remove(next);
                        this.f15504e.j().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public final void P0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f15508i);
            if (i2 == 89) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 502) {
                statisticItem.param("obj_type", 8);
            } else if (i2 == 504) {
                statisticItem.param("obj_type", 11);
            } else if (this.l == 3) {
                statisticItem.param("obj_type", 13);
            } else if (this.n == 1) {
                statisticItem.param("obj_type", 12);
            }
            statisticItem.param("obj_locate", i3);
            statisticItem.eventStat();
        }
    }

    public String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k == 89 ? "a006" : "a006" : (String) invokeV.objValue;
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.frs_common_tab_fragment : invokeV.intValue;
    }

    public d.a.s0.u0.k1.b S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f15504e : (d.a.s0.u0.k1.b) invokeV.objValue;
    }

    public d.a.s0.u0.k1.c T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f15505f : (d.a.s0.u0.k1.c) invokeV.objValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.y : invokeV.intValue;
    }

    public final boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String string = getPageContext().getResources().getString(R.string.is_district_forum);
            FrsViewData frsViewData = this.f15507h;
            return (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.f15507h.getForum().getFirst_class()) || !this.f15507h.getForum().getFirst_class().equals(string)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (l.D()) {
                VoiceManager voiceManager = this.s;
                if (voiceManager != null) {
                    voiceManager.stopPlay();
                }
                d.a.s0.u0.k1.c cVar = this.f15505f;
                if (cVar != null) {
                    cVar.k(this.y);
                }
            }
        }
    }

    public void X0(d.a.s0.u0.k1.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) || dVar == null) {
            return;
        }
        hideLoadingView(this.f15506g);
        this.y = dVar.m;
        d.a.s0.u0.k1.b bVar = this.f15504e;
        if (bVar != null) {
            bVar.w(false);
            this.f15504e.r();
            this.f15504e.o(dVar);
        }
        if (this.f15505f.j() && this.k == 89) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.FALSE));
        }
        d.a.s0.g3.c.g().h(getUniqueId(), false);
    }

    public void Y0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            O0();
            int i3 = 0;
            int i4 = -1;
            for (n nVar : this.f15505f.f().f66225g) {
                if ((nVar instanceof a2) && (i2 = ((a2) nVar).position) != i4) {
                    i3++;
                    i4 = i2;
                    continue;
                }
                if (i3 >= 6) {
                    break;
                }
            }
            if (i3 < 6) {
                W0();
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && l.D()) {
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            d.a.s0.u0.k1.c cVar = this.f15505f;
            if (cVar != null) {
                cVar.n(this.y);
            }
        }
    }

    public void a1() {
        d.a.s0.u0.k1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bVar = this.f15504e) == null) {
            return;
        }
        bVar.q();
    }

    public void b1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.y = i2;
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getActivity());
            aVar.setContentViewSize(1);
            ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
            professionDialogLayout.setButtonClickListener(new g(this, aVar));
            professionDialogLayout.setCloseViewClickListener(new h(this, aVar));
            aVar.setContentView(professionDialogLayout);
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.create(getPageContext()).show();
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.k == 502) {
            StatisticItem statisticItem = new StatisticItem("c13376");
            statisticItem.param("fid", this.f15508i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.r0.i0.c getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            return new d.a.r0.i0.c(getUniqueId(), Q0(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
        }
        return (d.a.r0.i0.c) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.sortType = k.g(U0());
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = this.k;
            tbPageTag.tabType = this.l;
            tbPageTag.isGeneralTab = this.n;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.s == null) {
                this.s = VoiceManager.instance();
            }
            return this.s;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view) == null) {
            d.a.s0.u0.k1.b bVar = this.f15504e;
            if (bVar != null) {
                bVar.u(true);
            }
            d.a.r0.d0.c cVar = this.u;
            if (cVar != null) {
                cVar.dettachView(view);
            }
        }
    }

    @Override // d.a.s0.u0.r0
    public void l0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || getContext() == null) {
            return;
        }
        if (j.z()) {
            hideNetRefreshView(this.f15506g);
            if (this.f15505f.h()) {
                hideLoadingView(this.f15506g);
            } else {
                showLoadingView(this.f15506g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            Z0();
            return;
        }
        d.a.s0.u0.k1.b bVar = this.f15504e;
        if (bVar != null) {
            bVar.w(false);
        }
    }

    @Override // d.a.s0.w2.t
    public TbPageContext<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        d.a.s0.u0.k1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048605, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                String stringExtra = intent.getStringExtra("tid");
                int intExtra = intent.getIntExtra("type", -1);
                if (StringUtils.isNull(stringExtra) || intExtra != 0 || (bVar = this.f15504e) == null) {
                    return;
                }
                bVar.m(stringExtra);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (this.r == 3 && this.f15504e == null) {
                return;
            }
            this.r = i2;
            super.onChangeSkinType(i2);
            this.f15504e.l(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.k = bundle.getInt("tab_id");
                this.l = bundle.getInt("tab_type");
                bundle.getString("from");
                this.f15508i = bundle.getString("forum_id");
                this.j = bundle.getString("name");
                this.q = bundle.getBoolean("can_auto_play_video");
                this.o = bundle.getBoolean("need_log");
                this.p = bundle.getBoolean("is_brand_forum");
                this.m = bundle.getString("tab_name");
                this.n = bundle.getInt("is_general_tab");
                this.f15507h = (FrsViewData) bundle.getSerializable("view_data");
                this.z = bundle.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
                if (this.n != 1) {
                    this.y = bundle.getInt("sort_type", 0);
                }
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.k = arguments.getInt("tab_id");
                    this.l = arguments.getInt("tab_type");
                    arguments.getString("from");
                    this.f15508i = arguments.getString("forum_id");
                    this.j = arguments.getString("name");
                    this.q = arguments.getBoolean("can_auto_play_video");
                    this.o = arguments.getBoolean("need_log");
                    this.p = arguments.getBoolean("is_brand_forum");
                    this.m = arguments.getString("tab_name");
                    this.n = arguments.getInt("is_general_tab");
                    this.f15507h = (FrsViewData) arguments.getSerializable("view_data");
                    this.z = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
                }
            }
            VoiceManager voiceManager = getVoiceManager();
            this.s = voiceManager;
            voiceManager.onCreate(getPageContext());
            d.a.s0.g3.c.g().i(getUniqueId());
            d.a.s0.u0.k1.c cVar = new d.a.s0.u0.k1.c(this, d.a.c.e.m.b.d(this.f15508i, 0), this.k, this.m, this.n);
            this.f15505f = cVar;
            cVar.r(this.l);
            this.f15505f.o(d.a.s0.w0.a.a(this.z));
            registerListener(this.B);
            registerListener(this.C);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.A);
            this.w = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048608, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R0(), (ViewGroup) null);
            this.f15506g = inflate;
            d.a.s0.u0.k1.b bVar = new d.a.s0.u0.k1.b(this, inflate, this.f15507h);
            this.f15504e = bVar;
            bVar.x(this.F);
            return this.f15506g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            d.a.s0.g3.c.g().k(getUniqueId());
            d.a.s0.a0.t.b().e(false);
            MessageManager.getInstance().unRegisterListener(this.A);
            MessageManager.getInstance().unRegisterListener(this.E);
            super.onDestroy();
            d.a.s0.u0.k1.b bVar = this.f15504e;
            if (bVar != null) {
                bVar.n();
            }
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onLazyLoad();
            if (j.z()) {
                showLoadingView(this.f15506g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                Z0();
                return;
            }
            showNetRefreshView(this.f15506g, null, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            P0(this.k, 2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && j.z()) {
            hideNetRefreshView(this.f15506g);
            showLoadingView(this.f15506g, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            Z0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onPause();
            d.a.s0.u0.k1.b bVar = this.f15504e;
            if (bVar != null) {
                bVar.p();
            }
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                d.a.s0.u0.k1.b bVar = this.f15504e;
                if (bVar != null) {
                    bVar.s();
                }
                if (this.t) {
                    this.t = false;
                    if (this.k == 502) {
                        boolean z = true;
                        if ((!d.a.r0.r.d0.b.j().g("first_into_tab_profession", true) || V0()) ? false : false) {
                            d.a.r0.r.d0.b.j().t("first_into_tab_profession", false);
                            c1();
                        }
                        new d.a.s0.u0.f2.a.c(getPageContext()).g(this.f15508i);
                        onLazyLoad();
                    }
                    int i2 = this.k;
                    if (i2 != 503 && i2 != 504) {
                        if (!this.isLazyLoaded) {
                            onLazyLoad();
                        }
                    } else {
                        onLazyLoad();
                    }
                }
                d1();
                return;
            }
            d.a.s0.u0.k1.b bVar2 = this.f15504e;
            if (bVar2 != null) {
                bVar2.p();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.k);
            bundle.putString("forum_id", this.f15508i);
            bundle.putString("name", this.j);
            bundle.putBoolean("can_auto_play_video", this.q);
            bundle.putBoolean("need_log", this.o);
            bundle.putBoolean("is_brand_forum", this.p);
            bundle.putString("tab_name", this.m);
            bundle.putInt("is_general_tab", this.n);
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, this.z);
            if (this.n != 1) {
                bundle.putInt("sort_type", this.y);
            }
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, errorData) == null) {
            hideLoadingView(this.f15506g);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            if (!this.f15505f.h()) {
                showNetRefreshView(this.f15506g, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            d.a.s0.u0.k1.b bVar = this.f15504e;
            if (bVar != null) {
                bVar.w(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onStop();
            d.a.s0.g3.c.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.s;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // d.a.s0.u0.p0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            E0();
            d.a.s0.u0.k1.b bVar = this.f15504e;
            if (bVar != null) {
                bVar.w(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048621, this, view, str, z) == null) {
            d.a.s0.u0.k1.b bVar = this.f15504e;
            if (bVar != null) {
                bVar.u(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.u == null) {
                this.u = new d.a.r0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.u.e(null);
            this.u.d(str);
            this.u.c(null);
            this.u.attachView(view, z);
            this.u.f();
            this.u.a(0);
        }
    }

    @Override // d.a.s0.w2.t
    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f15505f.e() : invokeV.intValue;
    }
}
