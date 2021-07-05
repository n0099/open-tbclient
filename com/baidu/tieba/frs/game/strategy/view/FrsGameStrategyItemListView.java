package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.r0.r.q.b2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements d.a.s0.u0.r1.a.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15663e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f15664f;

    /* renamed from: g  reason: collision with root package name */
    public g f15665g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f15666h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f15667i;
    public d.a.r0.d0.g j;
    public PbListView k;
    public d.a.s0.u0.r1.a.e.c l;
    public d.a.s0.u0.w1.b m;
    public d.a.s0.u0.r1.a.d.a n;
    public List<n> o;
    public int p;
    public int q;
    public boolean r;
    public w s;
    public f.g t;

    /* loaded from: classes5.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f15668e;

        /* renamed from: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0199a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15669e;

            public RunnableC0199a(a aVar, String str) {
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
                this.f15669e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f15669e);
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
            this.f15668e = frsGameStrategyItemListView;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            b2 threadData;
            boolean z;
            d.a.s0.u0.r1.a.d.e a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || nVar == null || !(nVar instanceof d.a.s0.u0.r1.a.a.b) || (threadData = ((d.a.s0.u0.r1.a.a.b) nVar).getThreadData()) == null) {
                return;
            }
            if (this.f15668e.n != null && (a2 = this.f15668e.n.a(this.f15668e.p)) != null) {
                Object obj = a2.f66937c;
                if (obj instanceof LabelDataList) {
                    String labelName = ((LabelDataList) obj).getLabelName(this.f15668e.q);
                    if (labelName == null) {
                        labelName = "";
                    }
                    TiebaStatic.log(new StatisticItem("c12388").param("fid", this.f15668e.n.i()).param("tid", threadData.c0()).param("obj_id", a2.f66936b).param("obj_locate", labelName));
                }
            }
            if (threadData.C() == null || threadData.C().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f15668e.f15663e.getPageActivity())) {
                if (threadData.q() != 1 || ViewHelper.checkUpIsLogin(this.f15668e.f15663e.getPageActivity())) {
                    d.a.s0.h3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.c0())) {
                        readThreadHistory.a(threadData.c0());
                        this.f15668e.l.b();
                    }
                    String x = threadData.x();
                    if (x == null || x.equals("")) {
                        z = false;
                    } else {
                        new Thread(new RunnableC0199a(this, x)).start();
                        z = true;
                    }
                    String n1 = threadData.n1();
                    if (n1 == null) {
                        n1 = "";
                    }
                    if (threadData.m0() == 2 && !n1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f15668e.f15663e, new String[]{n1, "", null});
                        return;
                    }
                    if (n1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        threadData.v3(n1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f15668e.f15663e.getPageActivity()).createFromThreadCfg(threadData, null, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(threadData.Q()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f15668e.f15663e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f15670e;

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
            this.f15670e = frsGameStrategyItemListView;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f15670e.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f15671e;

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
            this.f15671e = frsGameStrategyItemListView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f15671e.r && this.f15671e.n != null) {
                this.f15671e.n.c(this.f15671e.p, this.f15671e.q);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f15672e;

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
            this.f15672e = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f15672e.m != null) {
                    this.f15672e.m.b(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f15673e;

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
            this.f15673e = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15673e.t();
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
        this.f15663e = (TbPageContext) j.a(context);
        this.f15664f = bdUniqueId;
        n();
    }

    @Override // d.a.s0.u0.r1.a.d.b
    public void a(int i2, int i3, List<n> list, List<d.a.s0.u0.r1.a.d.e> list2, boolean z, boolean z2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) {
            if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
                l();
                this.f15666h.z();
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(this.o)) {
                    w(getContext().getString(R.string.no_data_text));
                    k();
                    this.r = false;
                    return;
                }
                if (!ListUtils.isEmpty(list)) {
                    this.o = list;
                }
                this.l.d(this.o);
                this.r = z;
                if (z) {
                    u();
                } else {
                    x();
                }
            }
        }
    }

    @Override // d.a.s0.u0.r1.a.d.b
    public void b(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
                this.r = false;
                l();
                if (ListUtils.isEmpty(this.o)) {
                    w(str);
                    k();
                    return;
                }
                this.f15663e.showToast(str);
                x();
            }
        }
    }

    public int getLabelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : invokeV.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.r = false;
            this.f15666h.setNextPage(null);
        }
    }

    public final void l() {
        d.a.r0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.dettachView(this);
    }

    public final void m() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (noDataView = this.f15667i) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdTypeListView bdTypeListView = new BdTypeListView(getContext());
            this.f15666h = bdTypeListView;
            bdTypeListView.setDivider(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0204)));
            this.f15666h.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
            this.f15666h.setCacheColorHint(getContext().getResources().getColor(17170445));
            this.f15666h.setFadingEdgeLength(0);
            this.f15666h.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
            this.f15666h.setOnSrollToBottomListener(new c(this));
            this.f15666h.setOnTouchListener(new d(this));
            addView(this.f15666h);
            d.a.s0.u0.r1.a.e.c cVar = new d.a.s0.u0.r1.a.e.c(this.f15663e, this.f15666h);
            this.l = cVar;
            cVar.c(this.s);
            g gVar = new g(this.f15663e);
            this.f15665g = gVar;
            gVar.a0(this.f15664f);
            this.f15665g.a(this.t);
            this.m = new d.a.s0.u0.w1.b(this.f15663e.getPageActivity(), this.f15664f, true);
            this.f15666h.setPullRefresh(this.f15665g);
            if (this.k == null) {
                PbListView pbListView = new PbListView(this.f15663e.getPageActivity());
                this.k = pbListView;
                pbListView.a();
            }
            this.k.o(R.color.CAM_X0204);
        }
    }

    public void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            this.p = i2;
            this.q = i3;
            k();
            LinkedList linkedList = new LinkedList();
            this.o = linkedList;
            this.l.d(linkedList);
            this.n.d(i2, i3);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f15666h, R.color.CAM_X0204);
            g gVar = this.f15665g;
            if (gVar != null) {
                gVar.I(i2);
            }
            NoDataView noDataView = this.f15667i;
            if (noDataView != null) {
                noDataView.f(this.f15663e, i2);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (ListUtils.isEmpty(this.o) && (this.p != 0 || this.q != 0)) {
                v();
                this.n.b(this.p, this.q);
            }
            p(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f15666h.F();
        }
    }

    public void setFrsGameTabDataLoadListener(d.a.s0.u0.r1.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            m();
            d.a.s0.u0.r1.a.d.a aVar = this.n;
            if (aVar != null) {
                aVar.b(this.p, this.q);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.r = true;
            this.f15666h.setNextPage(this.k);
            this.k.O();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.j == null) {
                d.a.r0.d0.g gVar = new d.a.r0.d0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
                this.j = gVar;
                gVar.onChangeSkinType();
            }
            this.j.attachView(this, false);
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (this.f15667i == null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
                this.f15667i = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.c(str), NoDataViewFactory.c.b(new NoDataViewFactory.b(getContext().getString(R.string.refresh_view_button_text), new e(this)), getResources().getDimensionPixelSize(R.dimen.ds20)));
            }
            this.f15667i.f(this.f15663e, TbadkCoreApplication.getInst().getSkinType());
            this.f15667i.setVisibility(0);
            this.f15667i.bringToFront();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.r = false;
            this.f15666h.setNextPage(this.k);
            this.k.f();
            this.k.A(this.f15663e.getResources().getString(R.string.list_no_more));
        }
    }
}
