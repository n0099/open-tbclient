package com.baidu.tieba;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.forumSquare.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ec7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public RelativeLayout b;
    public vm5 c;
    public RecyclerView d;
    public LinearLayoutManager e;
    public LeftAdapter f;
    public BdTypeRecyclerView g;
    public LinearLayoutManager h;
    public PbListView i;
    public ac7 j;
    public BdListView.p k;
    public BdListView.p l;
    public final View m;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public a(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g != null) {
                    this.a.g.stopScroll();
                }
                if (this.a.k != null) {
                    this.a.k.onScrollToBottom();
                }
            }
        }
    }

    public ec7(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = tbPageContext;
        this.m = view2;
        h();
        g();
    }

    public void n(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048587, this, i, i2) != null) || (bdTypeRecyclerView = this.g) == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i > this.g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.g.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public void p(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            q(list, 0);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.d.setVisibility(i);
            this.g.setVisibility(i);
        }
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) && (leftAdapter = this.f) != null) {
            leftAdapter.r(bVar);
        }
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) && (bdTypeRecyclerView = this.g) != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.g.addOnScrollListener(onScrollListener);
        }
    }

    public void v(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.k = pVar;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.g.setVisibility(i);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, str) != null) || str == null) {
            return;
        }
        int m = this.f.m(str);
        this.f.s(m);
        z(m);
    }

    public Pair<Integer, Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int firstVisiblePosition = this.g.getFirstVisiblePosition();
            int i = 0;
            View childAt = this.g.getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(i));
        }
        return (Pair) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = (RelativeLayout) this.m.findViewById(R.id.right_container);
            this.d = (RecyclerView) this.m.findViewById(R.id.obfuscated_res_0x7f091eec);
            this.g = (BdTypeRecyclerView) this.m.findViewById(R.id.obfuscated_res_0x7f091eee);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.g.setNextPage(this.i);
            this.i.m();
            this.i.c().setPadding(0, 0, 0, 0);
            this.i.H(this.a.getPageActivity().getString(R.string.pb_load_more));
            this.i.g();
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f.n();
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setNextPage(null);
        }
    }

    public void f() {
        vm5 vm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (vm5Var = this.c) != null) {
            vm5Var.dettachView(this.b);
            this.c = null;
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            vm5 vm5Var = this.c;
            if (vm5Var != null) {
                return vm5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g.setNextPage(this.i);
            this.i.m();
            this.i.c().setPadding(0, 0, 0, 0);
            this.i.R();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList arrayList = new ArrayList();
            eo eoVar = new eo();
            eoVar.a = this.a.getString(R.string.obfuscated_res_0x7f0f07cd);
            eoVar.b = R.drawable.new_pic_emotion_06;
            arrayList.add(eoVar);
            this.j.c(arrayList);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.getPageActivity());
            this.e = linearLayoutManager;
            this.d.setLayoutManager(linearLayoutManager);
            LeftAdapter leftAdapter = new LeftAdapter(this.a.getPageActivity());
            this.f = leftAdapter;
            this.d.setAdapter(leftAdapter);
            this.j = new ac7(this.a, this.g);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.a.getPageActivity());
            this.h = linearLayoutManager2;
            this.g.setLayoutManager(linearLayoutManager2);
            this.g.setFadingEdgeLength(0);
            this.g.setOverScrollMode(2);
            this.g.setOnSrollToBottomListener(this.l);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.i = pbListView;
            pbListView.c();
            this.i.s(R.color.CAM_X0205);
            this.i.w(vi.g(this.a.getPageActivity(), R.dimen.tbds182));
            this.i.B();
            this.i.L(R.dimen.tbfontsize33);
            this.i.J(SkinManager.getColor(R.color.CAM_X0107));
            this.i.F(R.color.CAM_X0110);
            this.i.v();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g.setNextPage(this.i);
            this.i.m();
            this.i.c().setPadding(0, vi.g(this.a.getPageActivity(), R.dimen.tbds62), 0, vi.g(this.a.getPageActivity(), R.dimen.tbds362));
            this.i.H(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f07cc));
            this.i.g();
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            ac7 ac7Var = this.j;
            if (ac7Var != null) {
                ac7Var.b();
            }
            LeftAdapter leftAdapter = this.f;
            if (leftAdapter != null) {
                leftAdapter.notifyDataSetChanged();
            }
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
                this.i.e(i);
            }
            vm5 vm5Var = this.c;
            if (vm5Var != null) {
                vm5Var.onChangeSkinType();
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048598, this, z) != null) || i()) {
            return;
        }
        if (this.c == null) {
            vm5 vm5Var = new vm5(this.a.getPageActivity());
            this.c = vm5Var;
            vm5Var.t(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
        }
        this.c.onChangeSkinType();
        this.c.attachView(this.b, z);
    }

    public final void z(int i) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && (recyclerView = this.d) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.d.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.f.getItemCount() - 1) {
                i = this.f.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void o(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, list, z) == null) {
            int position = ListUtils.getPosition(list, str);
            this.f.q(position, list);
            if (z) {
                z(position);
            }
        }
    }

    public void q(List<vn> list, int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                r();
                return;
            }
            if (i > 0) {
                Pair<Integer, Integer> c = c();
                int intValue = ((Integer) c.first).intValue();
                int intValue2 = ((Integer) c.second).intValue();
                int i2 = intValue - i;
                if (this.h != null && (bdTypeRecyclerView = this.g) != null) {
                    bdTypeRecyclerView.startInterceptLayout();
                    this.h.scrollToPositionWithOffset(i2, intValue2);
                    this.g.stopIntercerceptLayout();
                }
            }
            this.j.c(list);
        }
    }
}
