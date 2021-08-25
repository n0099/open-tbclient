package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.j;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.p0.s.f0.f;
import c.a.p0.s.f0.g;
import c.a.p0.s.q.c2;
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
/* loaded from: classes7.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements c.a.q0.v0.r1.a.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f51026e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f51027f;

    /* renamed from: g  reason: collision with root package name */
    public g f51028g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f51029h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f51030i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.f0.g f51031j;
    public PbListView k;
    public c.a.q0.v0.r1.a.e.c l;
    public c.a.q0.v0.w1.b m;
    public c.a.q0.v0.r1.a.d.a n;
    public List<n> o;
    public int p;
    public int q;
    public boolean r;
    public w s;
    public f.g t;

    /* loaded from: classes7.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f51032e;

        /* renamed from: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1757a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f51033e;

            public RunnableC1757a(a aVar, String str) {
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
                this.f51033e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f51033e);
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
            this.f51032e = frsGameStrategyItemListView;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            c2 threadData;
            boolean z;
            c.a.q0.v0.r1.a.d.e a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || nVar == null || !(nVar instanceof c.a.q0.v0.r1.a.a.b) || (threadData = ((c.a.q0.v0.r1.a.a.b) nVar).getThreadData()) == null) {
                return;
            }
            if (this.f51032e.n != null && (a2 = this.f51032e.n.a(this.f51032e.p)) != null) {
                Object obj = a2.f27131c;
                if (obj instanceof LabelDataList) {
                    String labelName = ((LabelDataList) obj).getLabelName(this.f51032e.q);
                    if (labelName == null) {
                        labelName = "";
                    }
                    TiebaStatic.log(new StatisticItem("c12388").param("fid", this.f51032e.n.getForumId()).param("tid", threadData.f0()).param("obj_id", a2.f27130b).param("obj_locate", labelName));
                }
            }
            if (threadData.E() == null || threadData.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f51032e.f51026e.getPageActivity())) {
                if (threadData.w() != 1 || ViewHelper.checkUpIsLogin(this.f51032e.f51026e.getPageActivity())) {
                    c.a.q0.i3.o0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.f0())) {
                        readThreadHistory.a(threadData.f0());
                        this.f51032e.l.b();
                    }
                    String z2 = threadData.z();
                    if (z2 == null || z2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new RunnableC1757a(this, z2)).start();
                        z = true;
                    }
                    String q1 = threadData.q1();
                    if (q1 == null) {
                        q1 = "";
                    }
                    if (threadData.p0() == 2 && !q1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f51032e.f51026e, new String[]{q1, "", null});
                        return;
                    }
                    if (q1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        threadData.H3(q1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f51032e.f51026e.getPageActivity()).createFromThreadCfg(threadData, null, FrsFragment.STAR_FRS, 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(threadData.T()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f51032e.f51026e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f51034e;

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
            this.f51034e = frsGameStrategyItemListView;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f51034e.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f51035e;

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
            this.f51035e = frsGameStrategyItemListView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f51035e.r && this.f51035e.n != null) {
                this.f51035e.n.c(this.f51035e.p, this.f51035e.q);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f51036e;

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
            this.f51036e = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f51036e.m != null) {
                    this.f51036e.m.b(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f51037e;

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
            this.f51037e = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51037e.m();
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
        this.f51026e = (TbPageContext) j.a(context);
        this.f51027f = bdUniqueId;
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
            this.f51029h.setNextPage(null);
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
        c.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.f51031j) == null) {
            return;
        }
        gVar.dettachView(this);
    }

    public final void k() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.f51030i) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BdTypeListView bdTypeListView = new BdTypeListView(getContext());
            this.f51029h = bdTypeListView;
            bdTypeListView.setDivider(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0204)));
            this.f51029h.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
            this.f51029h.setCacheColorHint(getContext().getResources().getColor(17170445));
            this.f51029h.setFadingEdgeLength(0);
            this.f51029h.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
            this.f51029h.setOnSrollToBottomListener(new c(this));
            this.f51029h.setOnTouchListener(new d(this));
            addView(this.f51029h);
            c.a.q0.v0.r1.a.e.c cVar = new c.a.q0.v0.r1.a.e.c(this.f51026e, this.f51029h);
            this.l = cVar;
            cVar.c(this.s);
            g gVar = new g(this.f51026e);
            this.f51028g = gVar;
            gVar.V(this.f51027f);
            this.f51028g.a(this.t);
            this.m = new c.a.q0.v0.w1.b(this.f51026e.getPageActivity(), this.f51027f, true);
            this.f51029h.setPullRefresh(this.f51028g);
            if (this.k == null) {
                PbListView pbListView = new PbListView(this.f51026e.getPageActivity());
                this.k = pbListView;
                pbListView.a();
            }
            this.k.o(R.color.CAM_X0204);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k();
            c.a.q0.v0.r1.a.d.a aVar = this.n;
            if (aVar != null) {
                aVar.b(this.p, this.q);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.r = true;
            this.f51029h.setNextPage(this.k);
            this.k.O();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f51031j == null) {
                c.a.p0.f0.g gVar = new c.a.p0.f0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
                this.f51031j = gVar;
                gVar.onChangeSkinType();
            }
            this.f51031j.attachView(this, false);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f51029h, R.color.CAM_X0204);
            g gVar = this.f51028g;
            if (gVar != null) {
                gVar.D(i2);
            }
            NoDataView noDataView = this.f51030i;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f51026e, i2);
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
            if (this.f51030i == null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
                this.f51030i = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.c(str), NoDataViewFactory.c.b(new NoDataViewFactory.b(getContext().getString(R.string.refresh_view_button_text), new e(this)), getResources().getDimensionPixelSize(R.dimen.ds20)));
            }
            this.f51030i.onChangeSkinType(this.f51026e, TbadkCoreApplication.getInst().getSkinType());
            this.f51030i.setVisibility(0);
            this.f51030i.bringToFront();
        }
    }

    public void pullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f51029h.startPullRefresh();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.r = false;
            this.f51029h.setNextPage(this.k);
            this.k.f();
            this.k.A(this.f51026e.getResources().getString(R.string.list_no_more));
        }
    }

    @Override // c.a.q0.v0.r1.a.d.b
    public void refreshView(int i2, int i3, List<n> list, List<c.a.q0.v0.r1.a.d.e> list2, boolean z, boolean z2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) {
            if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
                j();
                this.f51029h.completePullRefresh();
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

    public void setFrsGameTabDataLoadListener(c.a.q0.v0.r1.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.n = aVar;
        }
    }

    @Override // c.a.q0.v0.r1.a.d.b
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
                this.f51026e.showToast(str);
                q();
            }
        }
    }
}
