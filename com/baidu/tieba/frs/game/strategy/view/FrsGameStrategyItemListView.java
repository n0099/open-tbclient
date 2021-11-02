package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import b.a.e.l.e.n;
import b.a.e.l.e.w;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements b.a.r0.x0.c2.a.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f48571e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f48572f;

    /* renamed from: g  reason: collision with root package name */
    public g f48573g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f48574h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f48575i;
    public b.a.q0.g0.g j;
    public PbListView k;
    public b.a.r0.x0.c2.a.e.c l;
    public b.a.r0.x0.h2.b m;
    public b.a.r0.x0.c2.a.d.a n;
    public List<n> o;
    public int p;
    public int q;
    public boolean r;
    public w s;
    public f.g t;

    /* loaded from: classes9.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f48576e;

        /* renamed from: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1720a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48577e;

            public RunnableC1720a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48577e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f48577e);
                    netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                    netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                    netWork.getNetData();
                }
            }
        }

        public a(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48576e = frsGameStrategyItemListView;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d2 threadData;
            boolean z;
            b.a.r0.x0.c2.a.d.e a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || nVar == null || !(nVar instanceof b.a.r0.x0.c2.a.a.b) || (threadData = ((b.a.r0.x0.c2.a.a.b) nVar).getThreadData()) == null) {
                return;
            }
            if (this.f48576e.n != null && (a2 = this.f48576e.n.a(this.f48576e.p)) != null) {
                Object obj = a2.f25657c;
                if (obj instanceof LabelDataList) {
                    String labelName = ((LabelDataList) obj).getLabelName(this.f48576e.q);
                    if (labelName == null) {
                        labelName = "";
                    }
                    TiebaStatic.log(new StatisticItem("c12388").param("fid", this.f48576e.n.getForumId()).param("tid", threadData.f0()).param("obj_id", a2.f25656b).param("obj_locate", labelName));
                }
            }
            if (threadData.E() == null || threadData.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f48576e.f48571e.getPageActivity())) {
                if (threadData.w() != 1 || ViewHelper.checkUpIsLogin(this.f48576e.f48571e.getPageActivity())) {
                    b.a.r0.l3.p0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.f0())) {
                        readThreadHistory.a(threadData.f0());
                        this.f48576e.l.b();
                    }
                    String z2 = threadData.z();
                    if (z2 == null || z2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new RunnableC1720a(this, z2)).start();
                        z = true;
                    }
                    String s1 = threadData.s1();
                    if (s1 == null) {
                        s1 = "";
                    }
                    if (threadData.r0() == 2 && !s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f48576e.f48571e, new String[]{s1, "", null});
                        return;
                    }
                    if (s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        threadData.O3(s1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f48576e.f48571e.getPageActivity()).createFromThreadCfg(threadData, null, FrsFragment.STAR_FRS, 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(threadData.T()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f48576e.f48571e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f48578e;

        public b(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48578e = frsGameStrategyItemListView;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f48578e.m();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f48579e;

        public c(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48579e = frsGameStrategyItemListView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f48579e.r && this.f48579e.n != null) {
                this.f48579e.n.c(this.f48579e.p, this.f48579e.q);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f48580e;

        public d(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48580e = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f48580e.m != null) {
                    this.f48580e.m.b(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f48581e;

        public e(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48581e = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48581e.m();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new a(this);
        this.t = new b(this);
        this.f48571e = (TbPageContext) j.a(context);
        this.f48572f = bdUniqueId;
        l();
    }

    public int getLabelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.r = false;
            this.f48574h.setNextPage(null);
        }
    }

    public void initTab(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.p = i2;
            this.q = i3;
            i();
            LinkedList linkedList = new LinkedList();
            this.o = linkedList;
            this.l.d(linkedList);
            this.n.d(i2, i3);
        }
    }

    public final void j() {
        b.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.dettachView(this);
    }

    public final void k() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.f48575i) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BdTypeListView bdTypeListView = new BdTypeListView(getContext());
            this.f48574h = bdTypeListView;
            bdTypeListView.setDivider(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0204)));
            this.f48574h.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
            this.f48574h.setCacheColorHint(getContext().getResources().getColor(17170445));
            this.f48574h.setFadingEdgeLength(0);
            this.f48574h.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
            this.f48574h.setOnSrollToBottomListener(new c(this));
            this.f48574h.setOnTouchListener(new d(this));
            addView(this.f48574h);
            b.a.r0.x0.c2.a.e.c cVar = new b.a.r0.x0.c2.a.e.c(this.f48571e, this.f48574h);
            this.l = cVar;
            cVar.c(this.s);
            g gVar = new g(this.f48571e);
            this.f48573g = gVar;
            gVar.U(this.f48572f);
            this.f48573g.a(this.t);
            this.m = new b.a.r0.x0.h2.b(this.f48571e.getPageActivity(), this.f48572f, true);
            this.f48574h.setPullRefresh(this.f48573g);
            if (this.k == null) {
                PbListView pbListView = new PbListView(this.f48571e.getPageActivity());
                this.k = pbListView;
                pbListView.a();
            }
            this.k.p(R.color.CAM_X0204);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k();
            b.a.r0.x0.c2.a.d.a aVar = this.n;
            if (aVar != null) {
                aVar.b(this.p, this.q);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.r = true;
            this.f48574h.setNextPage(this.k);
            this.k.Q();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.j == null) {
                b.a.q0.g0.g gVar = new b.a.q0.g0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
                this.j = gVar;
                gVar.onChangeSkinType();
            }
            this.j.attachView(this, false);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f48574h, R.color.CAM_X0204);
            g gVar = this.f48573g;
            if (gVar != null) {
                gVar.C(i2);
            }
            NoDataView noDataView = this.f48575i;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f48571e, i2);
            }
        }
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void onEnterForground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (ListUtils.isEmpty(this.o) && (this.p != 0 || this.q != 0)) {
                o();
                this.n.b(this.p, this.q);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (this.f48575i == null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
                this.f48575i = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.c(str), NoDataViewFactory.c.b(new NoDataViewFactory.b(getContext().getString(R.string.refresh_view_button_text), new e(this)), getResources().getDimensionPixelSize(R.dimen.ds20)));
            }
            this.f48575i.onChangeSkinType(this.f48571e, TbadkCoreApplication.getInst().getSkinType());
            this.f48575i.setVisibility(0);
            this.f48575i.bringToFront();
        }
    }

    public void pullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f48574h.startPullRefresh();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.r = false;
            this.f48574h.setNextPage(this.k);
            this.k.f();
            this.k.C(this.f48571e.getResources().getString(R.string.list_no_more));
        }
    }

    @Override // b.a.r0.x0.c2.a.d.b
    public void refreshView(int i2, int i3, List<n> list, List<b.a.r0.x0.c2.a.d.e> list2, boolean z, boolean z2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) {
            if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
                j();
                this.f48574h.completePullRefresh();
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(this.o)) {
                    p(getContext().getString(R.string.no_data_text));
                    i();
                    this.r = false;
                    return;
                }
                if (!ListUtils.isEmpty(list)) {
                    this.o = list;
                }
                this.l.d(this.o);
                this.r = z;
                if (z) {
                    n();
                } else {
                    q();
                }
            }
        }
    }

    public void setFrsGameTabDataLoadListener(b.a.r0.x0.c2.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.n = aVar;
        }
    }

    @Override // b.a.r0.x0.c2.a.d.b
    public void showError(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, str) == null) {
            if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
                this.r = false;
                j();
                if (ListUtils.isEmpty(this.o)) {
                    p(str);
                    i();
                    return;
                }
                this.f48571e.showToast(str);
                q();
            }
        }
    }
}
