package com.baidu.tieba;

import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.bq6;
import com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class as6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public int b;
    public View c;
    public View d;
    public View e;
    public RecentlyVisitedForumModel f;
    public Vibrator g;
    public TextView h;
    public ImageView i;
    public TextView j;
    public RecyclerView k;
    public View l;
    public RecentlyVisitedForumListAdapter m;
    public boolean n;
    public boolean o;
    public ViewEventCenter p;
    public gq6 q;
    public fn r;
    public qp6 s;
    public j t;
    public CustomMessageListener u;
    public CustomMessageListener v;
    public CustomMessageListener w;

    /* loaded from: classes3.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(as6 as6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var, Integer.valueOf(i)};
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
            this.a = as6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.r == null) {
                        this.a.r = new fn(new dn());
                    }
                    this.a.r.q(this.a.k, 1);
                } else if (this.a.r != null) {
                    this.a.r.w();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(as6 as6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var, Integer.valueOf(i)};
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
            this.a = as6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public c(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public d(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.B(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements RecentlyVisitedForumListAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public e(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
        public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, forumViewHolder) == null) && !this.a.o && forumViewHolder != null && (view2 = forumViewHolder.itemView) != null && (view2.getTag() instanceof VisitedForumData)) {
                VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
                FrsActivityConfig callFrom = new FrsActivityConfig(this.a.a.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                if (callFrom.getIntent() != null) {
                    callFrom.getIntent().putExtra("transition_type", 0);
                }
                this.a.a.sendMessage(new CustomMessage(2003000, callFrom));
                TiebaStatic.log(new StatisticItem("c13002").param("fid", visitedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public f(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.a.B(true);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public g(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f != null && view2.getTag() != null && (view2.getTag() instanceof VisitedForumData)) {
                VisitedForumData visitedForumData = (VisitedForumData) view2.getTag();
                this.a.f.Q(visitedForumData);
                TiebaStatic.log(new StatisticItem("c13005").param("fid", visitedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements bq6.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public h(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // com.baidu.tieba.bq6.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.t(i);
            }
        }

        @Override // com.baidu.tieba.bq6.f
        public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, linkedList, z) == null) {
                this.a.w(linkedList);
                if (!z && this.a.q != null) {
                    this.a.q.c(linkedList, this.a.a.getResources().getDimensionPixelSize(R.dimen.tbds678) + this.a.a.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        }

        @Override // com.baidu.tieba.bq6.f
        public void onNotify() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(as6 as6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var, Integer.valueOf(i)};
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
            this.a = as6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.k(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes3.dex */
    public class k extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;

        public k(as6 as6Var, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getOrientation() == 1) {
                    if (recyclerView.getChildAdapterPosition(view2) == 0) {
                        rect.top = this.a;
                    } else {
                        rect.top = this.b;
                    }
                    if (recyclerView.getChildAdapterPosition(view2) == linearLayoutManager.getItemCount() - 1) {
                        rect.bottom = this.c;
                        return;
                    }
                    return;
                }
                if (recyclerView.getChildAdapterPosition(view2) == 0) {
                    rect.left = this.a;
                } else {
                    rect.left = this.b;
                }
                if (recyclerView.getChildAdapterPosition(view2) == linearLayoutManager.getItemCount() - 1) {
                    rect.right = this.c;
                }
            }
        }
    }

    public as6(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, recentlyVisitedForumModel, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.n = true;
        this.o = false;
        this.u = new a(this, 2156674);
        this.v = new b(this, 2001011);
        this.w = new i(this, 2921347);
        this.a = tbPageContext;
        this.f = recentlyVisitedForumModel;
        this.p = viewEventCenter;
        this.g = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.q = new gq6(tbPageContext);
        MessageManager.getInstance().registerListener(this.u);
        MessageManager.getInstance().registerListener(this.v);
        n();
        o();
    }

    public void A(qp6 qp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qp6Var) == null) {
            this.s = qp6Var;
            y();
        }
    }

    public void C(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
            this.t = jVar;
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.w.setTag(bdUniqueId);
        }
    }

    public void t(int i2) {
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i2) != null) || (recentlyVisitedForumListAdapter = this.m) == null) {
            return;
        }
        recentlyVisitedForumListAdapter.notifyItemRemoved(i2);
        if (this.m.getItemCount() == 0) {
            B(false);
            k(false);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i2) == null) && this.b != i2) {
            this.b = i2;
            y();
        }
    }

    public void w(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, linkedList) == null) && this.m != null && linkedList != null) {
            E();
            this.m.p(linkedList);
            s();
            u(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.o != z && this.m != null) {
            this.o = z;
            if (z) {
                this.j.setVisibility(0);
                this.i.setVisibility(8);
                Vibrator vibrator = this.g;
                if (vibrator != null) {
                    vibrator.vibrate(10L);
                }
                ViewEventCenter viewEventCenter = this.p;
                if (viewEventCenter != null) {
                    viewEventCenter.dispatchMvcEvent(new nk5(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.j.setVisibility(8);
                this.i.setVisibility(0);
                ViewEventCenter viewEventCenter2 = this.p;
                if (viewEventCenter2 != null) {
                    viewEventCenter2.dispatchMvcEvent(new nk5(11, null, null, null));
                }
            }
            this.m.r(this.o);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = this.n;
            int i2 = R.color.white_alpha100;
            if (z) {
                this.k.setVisibility(0);
                this.l.setVisibility(8);
                qp6 qp6Var = this.s;
                if (qp6Var == null || !qp6Var.a) {
                    i2 = R.color.CAM_X0107;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                qp6 qp6Var2 = this.s;
                if (qp6Var2 == null || !qp6Var2.a) {
                    i2 = R.color.CAM_X0107;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_ba_hide24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            j jVar = this.t;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.o) {
                return false;
            }
            B(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public qp6 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.s;
        }
        return (qp6) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n = p45.m().i("key_recently_visited_forum_extend_state", true);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.e.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (recentlyVisitedForumListAdapter = this.m) != null) {
            recentlyVisitedForumListAdapter.notifyDataSetChanged();
            if (this.m.getItemCount() > 0) {
                k(true);
            } else {
                k(false);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.v);
            gq6 gq6Var = this.q;
            if (gq6Var != null) {
                gq6Var.f();
            }
        }
    }

    public void x() {
        RecentlyVisitedForumModel recentlyVisitedForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (recentlyVisitedForumModel = this.f) != null) {
            recentlyVisitedForumModel.refresh();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                p45 m = p45.m();
                if (!m.i("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    this.d.setVisibility(0);
                    this.e.setVisibility(0);
                    E();
                    jVar = this.t;
                    if (jVar == null) {
                        jVar.a();
                        return;
                    }
                    return;
                }
            }
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            jVar = this.t;
            if (jVar == null) {
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            View inflate = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d07c3, (ViewGroup) null);
            this.c = inflate;
            this.d = inflate.findViewById(R.id.obfuscated_res_0x7f091d0d);
            this.e = this.c.findViewById(R.id.title_container);
            this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0923f2);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090a55);
            this.i = imageView;
            imageView.setOnClickListener(new c(this));
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0908de);
            this.j = textView;
            textView.setOnClickListener(new d(this));
            this.l = this.c.findViewById(R.id.obfuscated_res_0x7f090da5);
            this.k = (RecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f091493);
            RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter = new RecentlyVisitedForumListAdapter(this.a);
            this.m = recentlyVisitedForumListAdapter;
            this.k.setAdapter(recentlyVisitedForumListAdapter);
            this.k.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                fn fnVar = new fn(new dn());
                this.r = fnVar;
                fnVar.q(this.k, 1);
            }
            this.k.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            this.k.setItemAnimator(new DefaultItemAnimator());
            this.k.addItemDecoration(new k(this, ii.g(this.a.getPageActivity(), R.dimen.tbds44), 0, ii.g(this.a.getPageActivity(), R.dimen.tbds44)));
            this.m.s(new e(this));
            this.m.t(new f(this));
            this.m.q(new g(this));
            this.f.T(new h(this));
            u(TbadkCoreApplication.getInst().getSkinType());
            this.a.registerListener(this.w);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            qp6 qp6Var = this.s;
            if (qp6Var != null && qp6Var.a) {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColorSelector(this.j, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080509);
            } else {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
                q25 d2 = q25.d(this.d);
                d2.o(R.string.J_X06);
                d2.f(R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080509);
            }
            E();
            s();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.n = !this.n;
            p45.m().w("key_recently_visited_forum_extend_state", this.n);
            if (this.n) {
                TiebaStatic.log(new StatisticItem("c13003"));
            } else {
                TiebaStatic.log(new StatisticItem("c13004"));
            }
            E();
        }
    }
}
