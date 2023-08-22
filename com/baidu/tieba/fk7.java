package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class fk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public PbListView c;
    public ek7 d;
    public hk7 e;
    public ox9 f;
    public RelativeLayout g;
    public am7 h;
    public boolean i;
    public xh7 j;
    public ItemInfo k;
    public int l;
    public View.OnClickListener m;
    public BdListView.p n;
    public RecyclerView.OnScrollListener o;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk7 a;

        public a(fk7 fk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk7 a;

        public b(fk7 fk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b != null) {
                    this.a.b.stopScroll();
                }
                if (this.a.c != null && this.a.a != null) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.b.setNextPage(this.a.c);
                        this.a.c.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                        this.a.c.G(null);
                        if (this.a.i) {
                            this.a.c.R();
                            this.a.c.G(null);
                            this.a.a.o2();
                            return;
                        }
                        this.a.c.H(this.a.a.getResources().getString(R.string.list_has_no_more));
                        this.a.c.g();
                        this.a.c.G(null);
                        return;
                    }
                    this.a.b.setNextPage(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ fk7 b;

        public c(fk7 fk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fk7Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.f != null) {
                    this.b.f.m(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), this.a, 1);
                }
                co6.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonTabFragment a;
        public final /* synthetic */ fk7 b;

        public d(fk7 fk7Var, FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk7Var, frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fk7Var;
            this.a = frsCommonTabFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            FrsCommonTabFragment frsCommonTabFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.b.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
                    this.b.f.k(view2);
                }
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.h();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.p();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        }
    }

    public fk7(FrsCommonTabFragment frsCommonTabFragment, View view2, FrsViewData frsViewData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, view2, frsViewData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.m = new a(this);
        this.n = new b(this);
        this.o = new c(this);
        if (frsCommonTabFragment != null && view2 != null) {
            this.a = frsCommonTabFragment;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090c8c);
            this.b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            this.b.setOnSrollToBottomListener(this.n);
            this.b.addOnScrollListener(this.o);
            this.b.setRecyclerListener(new d(this, frsCommonTabFragment));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.b;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.b.getPaddingBottom());
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.c = pbListView;
            pbListView.c();
            this.c.s(R.color.transparent);
            this.c.w(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds182));
            this.c.B();
            this.c.L(R.dimen.tbfontsize33);
            this.c.J(SkinManager.getColor(R.color.CAM_X0107));
            this.c.F(R.color.CAM_X0110);
            this.c.v();
            FrsCommonTabFragment frsCommonTabFragment2 = this.a;
            BdTypeRecyclerView bdTypeRecyclerView3 = this.b;
            if (frsCommonTabFragment2.h == 16) {
                z = true;
            } else {
                z = false;
            }
            this.d = new ek7(frsCommonTabFragment2, bdTypeRecyclerView3, frsViewData, z);
            x(false);
            if (this.f == null) {
                this.f = new ox9(this.a.getPageContext(), this.b);
            }
            this.f.p(2);
            this.f.u(this.a.getUniqueId());
            if (g()) {
                this.g = new RelativeLayout(this.a.getContext());
                this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.h = new am7(this.a, this.g);
                this.b.addHeaderView(this.g, 0);
                this.h.i(h());
            }
            FrsCommonTabFragment frsCommonTabFragment3 = this.a;
            if (frsCommonTabFragment3.h == 16) {
                xh7 xh7Var = new xh7(frsCommonTabFragment3);
                this.j = xh7Var;
                this.b.addHeaderView(xh7Var.a(), 0);
                this.j.c(this.k);
            }
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (bdTypeRecyclerView = this.b) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdTypeRecyclerView.setVisibility(i);
        }
    }

    public void w(boolean z) {
        ek7 ek7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (ek7Var = this.d) != null) {
            ek7Var.k(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || this.a == null) {
            return;
        }
        ih7 ih7Var = new ih7();
        ih7Var.a = this.a.g;
        ih7Var.b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ih7Var));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && (bdTypeRecyclerView = this.b) != null) {
            bdTypeRecyclerView.setSelection(i);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment != null) {
                if (frsCommonTabFragment.j == 1 || frsCommonTabFragment.h == 16) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ox9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (ox9) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ox9 ox9Var = this.f;
            if (ox9Var != null) {
                ox9Var.h();
            }
            ek7 ek7Var = this.d;
            if (ek7Var != null) {
                ek7Var.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setRecyclerListener(null);
                this.b.setAdapter(null);
                this.b.setOnScrollListener(null);
            }
        }
    }

    public void p() {
        ox9 ox9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (ox9Var = this.f) != null) {
            ox9Var.r(false);
            this.f.z();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.g();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ih7 ih7Var = new ih7();
            ih7Var.a = this.a.g;
            ih7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ih7Var));
        }
    }

    public void s() {
        ox9 ox9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (ox9Var = this.f) != null) {
            ox9Var.r(true);
            this.f.o();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.scrollToPosition(0);
        }
    }

    public final List<FrsTabInfo> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 2;
            builder.tab_type = Integer.valueOf(this.a.h);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.a.h);
            FrsTabInfo build2 = builder2.build(true);
            arrayList.add(build);
            arrayList.add(build2);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean k(ArrayList<bn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, arrayList, i)) == null) {
            if (ListUtils.isEmpty(arrayList) || i < 0) {
                return false;
            }
            if (i == 0) {
                return true;
            }
            int i2 = 1;
            for (int i3 = 1; i3 < arrayList.size() && i2 <= i; i3++) {
                if (arrayList.get(i3) instanceof c45) {
                    int i4 = i3 - 1;
                    if ((arrayList.get(i4) instanceof c45) && ((c45) arrayList.get(i3)).position == ((c45) arrayList.get(i4)).position) {
                    }
                }
                i2++;
            }
            if (i2 <= i) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.l == i) {
            return;
        }
        this.l = i;
        ek7 ek7Var = this.d;
        if (ek7Var != null) {
            ek7Var.g();
        }
        PbListView pbListView = this.c;
        if (pbListView != null) {
            pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
            this.c.e(i);
        }
        am7 am7Var = this.h;
        if (am7Var != null) {
            am7Var.h();
        }
        xh7 xh7Var = this.j;
        if (xh7Var != null) {
            xh7Var.b();
        }
    }

    public void m(String str) {
        hk7 hk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !StringUtils.isNull(str) && (hk7Var = this.e) != null && !ListUtils.isEmpty(hk7Var.c)) {
            Iterator<bn> it = this.e.c.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                ThreadData threadData = null;
                if (next instanceof c45) {
                    threadData = ((c45) next).t;
                } else if (next instanceof ThreadData) {
                    threadData = (ThreadData) next;
                }
                if (threadData != null && TextUtils.equals(str, threadData.getId())) {
                    it.remove();
                }
            }
            if (ListUtils.isEmpty(this.e.c)) {
                this.e.c.add(new gh7());
            }
            this.d.j(this.e.c);
            this.d.g();
        }
    }

    public void o(hk7 hk7Var) {
        xh7 xh7Var;
        am7 am7Var;
        FrsCommonTabFragment frsCommonTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hk7Var) != null) || hk7Var == null) {
            return;
        }
        this.i = hk7Var.a;
        if (ListUtils.isEmpty(hk7Var.c)) {
            gh7 gh7Var = new gh7();
            ArrayList<bn> arrayList = new ArrayList<>();
            hk7Var.c = arrayList;
            arrayList.add(gh7Var);
            hk7Var.a = false;
        }
        this.e = hk7Var;
        this.c.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.i) {
            this.b.setNextPage(this.c);
            if (k(hk7Var.c, 3)) {
                this.c.G(null);
                this.c.Q();
            } else {
                this.c.Q();
                this.c.G(this.m);
                this.c.H(this.a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.b.setNextPage(null);
            this.c.H(this.a.getResources().getString(R.string.list_has_no_more));
            this.c.G(null);
            this.c.g();
        }
        this.d.j(hk7Var.c);
        this.d.g();
        if (this.f != null && (frsCommonTabFragment = this.a) != null && frsCommonTabFragment.isPrimary()) {
            this.f.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
        }
        if (this.a != null && g() && (am7Var = this.h) != null) {
            am7Var.g(this.a.n2());
            this.h.j(this.a.e);
        }
        this.k = hk7Var.j;
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        if (frsCommonTabFragment2 != null && (frsCommonTabFragment2.getFragmentActivity() instanceof ci7)) {
            ((ci7) this.a.getFragmentActivity()).k1(this.k);
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3 != null && frsCommonTabFragment3.h == 16 && (xh7Var = this.j) != null) {
            xh7Var.c(this.k);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.b.getLayoutManager()).scrollToPositionWithOffset(i, 0);
            if (!this.i) {
                this.n.onScrollToBottom();
            }
            ox9 ox9Var = this.f;
            if (ox9Var != null) {
                ox9Var.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
            }
        }
    }
}
