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
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.d27;
import com.baidu.tieba.dd9;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.g37;
import com.baidu.tieba.g9;
import com.baidu.tieba.gn;
import com.baidu.tieba.i27;
import com.baidu.tieba.j27;
import com.baidu.tieba.kf5;
import com.baidu.tieba.m27;
import com.baidu.tieba.p27;
import com.baidu.tieba.qn;
import com.baidu.tieba.v35;
import com.baidu.tieba.w35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements j27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public w35 c;
    public BdTypeListView d;
    public NoDataView e;
    public kf5 f;
    public PbListView g;
    public p27 h;
    public g37 i;
    public i27 j;
    public List<gn> k;
    public int l;
    public int m;
    public boolean n;
    public qn o;
    public v35.g p;

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyItemListView a;

        /* renamed from: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0263a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public RunnableC0263a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyItemListView;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            ThreadData threadData;
            boolean z;
            m27 a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || gnVar == null || !(gnVar instanceof d27) || (threadData = ((d27) gnVar).getThreadData()) == null) {
                return;
            }
            if (this.a.j != null && (a = this.a.j.a(this.a.l)) != null) {
                Object obj = a.c;
                if (obj instanceof LabelDataList) {
                    String labelName = ((LabelDataList) obj).getLabelName(this.a.m);
                    if (labelName == null) {
                        labelName = "";
                    }
                    TiebaStatic.log(new StatisticItem("c12388").param("fid", this.a.j.w()).param("tid", threadData.getId()).param("obj_id", a.b).param("obj_locate", labelName));
                }
            }
            if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                return;
            }
            if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                return;
            }
            dd9 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                readThreadHistory.a(threadData.getId());
                this.a.h.b();
            }
            String ad_url = threadData.getAd_url();
            if (ad_url != null && !ad_url.equals("")) {
                new Thread(new RunnableC0263a(this, ad_url)).start();
                z = true;
            } else {
                z = false;
            }
            String tid = threadData.getTid();
            if (tid == null) {
                tid = "";
            }
            if (threadData.getIs_top() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{tid, "", null});
                return;
            }
            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                threadData.setId(tid.substring(3));
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.a.a.getPageActivity()).createFromThreadCfg(threadData, null, "frs_page", 18003, true, false, z);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setStartFrom(3);
            this.a.a.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements v35.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyItemListView a;

        public b(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyItemListView;
        }

        @Override // com.baidu.tieba.v35.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.t();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyItemListView a;

        public c(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyItemListView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.n && this.a.j != null) {
                this.a.j.c(this.a.l, this.a.m);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyItemListView a;

        public d(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.i != null) {
                    this.a.i.b(view2, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameStrategyItemListView a;

        public e(FrsGameStrategyItemListView frsGameStrategyItemListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyItemListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.t();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.a = (TbPageContext) g9.a(context);
        this.b = bdUniqueId;
        n();
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
            w35 w35Var = this.c;
            if (w35Var != null) {
                w35Var.H(i);
            }
            NoDataView noDataView = this.e;
            if (noDataView != null) {
                noDataView.f(this.a, i);
            }
        }
    }

    public void setFrsGameTabDataLoadListener(i27 i27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, i27Var) == null) {
            this.j = i27Var;
        }
    }

    @Override // com.baidu.tieba.j27
    public void a(int i, int i2, List<gn> list, List<m27> list2, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            if ((i == 0 && i2 == 0) || (i == this.l && i2 == this.m)) {
                l();
                this.d.y();
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(this.k)) {
                    w(getContext().getString(R.string.no_data_text));
                    k();
                    this.n = false;
                    return;
                }
                if (!ListUtils.isEmpty(list)) {
                    this.k = list;
                }
                this.h.d(this.k);
                this.n = z;
                if (z) {
                    u();
                } else {
                    x();
                }
            }
        }
    }

    @Override // com.baidu.tieba.j27
    public void b(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
            if ((i == 0 && i2 == 0) || (i == this.l && i2 == this.m)) {
                this.n = false;
                l();
                if (ListUtils.isEmpty(this.k)) {
                    w(str);
                    k();
                    return;
                }
                this.a.showToast(str);
                x();
            }
        }
    }

    public int getLabelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.n = false;
            this.d.setNextPage(null);
        }
    }

    public final void l() {
        kf5 kf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (kf5Var = this.f) != null) {
            kf5Var.dettachView(this);
        }
    }

    public final void m() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (noDataView = this.e) != null) {
            noDataView.setVisibility(8);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.d.E();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            m();
            i27 i27Var = this.j;
            if (i27Var != null) {
                i27Var.b(this.l, this.m);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n = true;
            this.d.setNextPage(this.g);
            this.g.T();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.n = false;
            this.d.setNextPage(this.g);
            this.g.g();
            this.g.F(this.a.getResources().getString(R.string.list_no_more));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdTypeListView bdTypeListView = new BdTypeListView(getContext());
            this.d = bdTypeListView;
            bdTypeListView.setDivider(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0204)));
            this.d.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
            this.d.setCacheColorHint(getContext().getResources().getColor(17170445));
            this.d.setFadingEdgeLength(0);
            this.d.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
            this.d.setOnSrollToBottomListener(new c(this));
            this.d.setOnTouchListener(new d(this));
            addView(this.d);
            p27 p27Var = new p27(this.a, this.d);
            this.h = p27Var;
            p27Var.c(this.o);
            w35 w35Var = new w35(this.a);
            this.c = w35Var;
            w35Var.a0(this.b);
            this.c.f(this.p);
            this.i = new g37(this.a.getPageActivity(), this.b, true);
            this.d.setPullRefresh(this.c);
            if (this.g == null) {
                PbListView pbListView = new PbListView(this.a.getPageActivity());
                this.g = pbListView;
                pbListView.a();
            }
            this.g.r(R.color.CAM_X0204);
        }
    }

    public void o(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.l = i;
            this.m = i2;
            k();
            LinkedList linkedList = new LinkedList();
            this.k = linkedList;
            this.h.d(linkedList);
            this.j.d(i, i2);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (ListUtils.isEmpty(this.k) && (this.l != 0 || this.m != 0)) {
                v();
                this.j.b(this.l, this.m);
            }
            p(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f == null) {
                kf5 kf5Var = new kf5(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023d));
                this.f = kf5Var;
                kf5Var.onChangeSkinType();
            }
            this.f.attachView(this, false);
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (this.e == null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023d);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cd);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ab);
                this.e = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.c(str), NoDataViewFactory.c.b(new NoDataViewFactory.b(getContext().getString(R.string.refresh_view_button_text), new e(this)), getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5)));
            }
            this.e.f(this.a, TbadkCoreApplication.getInst().getSkinType());
            this.e.setVisibility(0);
            this.e.bringToFront();
        }
    }
}
