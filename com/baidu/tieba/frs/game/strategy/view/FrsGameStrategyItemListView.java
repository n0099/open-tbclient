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
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
import c.a.q0.s.q.d2;
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
public class FrsGameStrategyItemListView extends FrameLayout implements c.a.r0.w0.s1.a.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f51306e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f51307f;

    /* renamed from: g  reason: collision with root package name */
    public g f51308g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f51309h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f51310i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.g0.g f51311j;
    public PbListView k;
    public c.a.r0.w0.s1.a.e.c l;
    public c.a.r0.w0.x1.b m;
    public c.a.r0.w0.s1.a.d.a n;
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
        public final /* synthetic */ FrsGameStrategyItemListView f51312e;

        /* renamed from: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1760a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f51313e;

            public RunnableC1760a(a aVar, String str) {
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
                this.f51313e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f51313e);
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
            this.f51312e = frsGameStrategyItemListView;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            d2 threadData;
            boolean z;
            c.a.r0.w0.s1.a.d.e a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || nVar == null || !(nVar instanceof c.a.r0.w0.s1.a.a.b) || (threadData = ((c.a.r0.w0.s1.a.a.b) nVar).getThreadData()) == null) {
                return;
            }
            if (this.f51312e.n != null && (a2 = this.f51312e.n.a(this.f51312e.p)) != null) {
                Object obj = a2.f27818c;
                if (obj instanceof LabelDataList) {
                    String labelName = ((LabelDataList) obj).getLabelName(this.f51312e.q);
                    if (labelName == null) {
                        labelName = "";
                    }
                    TiebaStatic.log(new StatisticItem("c12388").param("fid", this.f51312e.n.getForumId()).param("tid", threadData.f0()).param("obj_id", a2.f27817b).param("obj_locate", labelName));
                }
            }
            if (threadData.E() == null || threadData.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f51312e.f51306e.getPageActivity())) {
                if (threadData.w() != 1 || ViewHelper.checkUpIsLogin(this.f51312e.f51306e.getPageActivity())) {
                    c.a.r0.j3.o0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.f0())) {
                        readThreadHistory.a(threadData.f0());
                        this.f51312e.l.b();
                    }
                    String z2 = threadData.z();
                    if (z2 == null || z2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new RunnableC1760a(this, z2)).start();
                        z = true;
                    }
                    String s1 = threadData.s1();
                    if (s1 == null) {
                        s1 = "";
                    }
                    if (threadData.r0() == 2 && !s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f51312e.f51306e, new String[]{s1, "", null});
                        return;
                    }
                    if (s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        threadData.N3(s1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f51312e.f51306e.getPageActivity()).createFromThreadCfg(threadData, null, FrsFragment.STAR_FRS, 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(threadData.T()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f51312e.f51306e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f51314e;

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
            this.f51314e = frsGameStrategyItemListView;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f51314e.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f51315e;

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
            this.f51315e = frsGameStrategyItemListView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f51315e.r && this.f51315e.n != null) {
                this.f51315e.n.c(this.f51315e.p, this.f51315e.q);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameStrategyItemListView f51316e;

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
            this.f51316e = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f51316e.m != null) {
                    this.f51316e.m.b(view, motionEvent);
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
        public final /* synthetic */ FrsGameStrategyItemListView f51317e;

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
            this.f51317e = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51317e.m();
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
        this.f51306e = (TbPageContext) j.a(context);
        this.f51307f = bdUniqueId;
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
            this.f51309h.setNextPage(null);
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
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.f51311j) == null) {
            return;
        }
        gVar.dettachView(this);
    }

    public final void k() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.f51310i) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BdTypeListView bdTypeListView = new BdTypeListView(getContext());
            this.f51309h = bdTypeListView;
            bdTypeListView.setDivider(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0204)));
            this.f51309h.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
            this.f51309h.setCacheColorHint(getContext().getResources().getColor(17170445));
            this.f51309h.setFadingEdgeLength(0);
            this.f51309h.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
            this.f51309h.setOnSrollToBottomListener(new c(this));
            this.f51309h.setOnTouchListener(new d(this));
            addView(this.f51309h);
            c.a.r0.w0.s1.a.e.c cVar = new c.a.r0.w0.s1.a.e.c(this.f51306e, this.f51309h);
            this.l = cVar;
            cVar.c(this.s);
            g gVar = new g(this.f51306e);
            this.f51308g = gVar;
            gVar.V(this.f51307f);
            this.f51308g.a(this.t);
            this.m = new c.a.r0.w0.x1.b(this.f51306e.getPageActivity(), this.f51307f, true);
            this.f51309h.setPullRefresh(this.f51308g);
            if (this.k == null) {
                PbListView pbListView = new PbListView(this.f51306e.getPageActivity());
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
            c.a.r0.w0.s1.a.d.a aVar = this.n;
            if (aVar != null) {
                aVar.b(this.p, this.q);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.r = true;
            this.f51309h.setNextPage(this.k);
            this.k.O();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f51311j == null) {
                c.a.q0.g0.g gVar = new c.a.q0.g0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
                this.f51311j = gVar;
                gVar.onChangeSkinType();
            }
            this.f51311j.attachView(this, false);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f51309h, R.color.CAM_X0204);
            g gVar = this.f51308g;
            if (gVar != null) {
                gVar.D(i2);
            }
            NoDataView noDataView = this.f51310i;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f51306e, i2);
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
            if (this.f51310i == null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
                this.f51310i = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.c(str), NoDataViewFactory.c.b(new NoDataViewFactory.b(getContext().getString(R.string.refresh_view_button_text), new e(this)), getResources().getDimensionPixelSize(R.dimen.ds20)));
            }
            this.f51310i.onChangeSkinType(this.f51306e, TbadkCoreApplication.getInst().getSkinType());
            this.f51310i.setVisibility(0);
            this.f51310i.bringToFront();
        }
    }

    public void pullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f51309h.startPullRefresh();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.r = false;
            this.f51309h.setNextPage(this.k);
            this.k.f();
            this.k.A(this.f51306e.getResources().getString(R.string.list_no_more));
        }
    }

    @Override // c.a.r0.w0.s1.a.d.b
    public void refreshView(int i2, int i3, List<n> list, List<c.a.r0.w0.s1.a.d.e> list2, boolean z, boolean z2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) {
            if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
                j();
                this.f51309h.completePullRefresh();
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

    public void setFrsGameTabDataLoadListener(c.a.r0.w0.s1.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.n = aVar;
        }
    }

    @Override // c.a.r0.w0.s1.a.d.b
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
                this.f51306e.showToast(str);
                q();
            }
        }
    }
}
