package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.s0.u0.r1.a.d.e;
import d.a.s0.u0.r1.a.e.f;
import java.util.List;
/* loaded from: classes5.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollHorizontalTabView f15649e;

    /* renamed from: f  reason: collision with root package name */
    public FoldedGridView f15650f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.u0.r1.a.d.d f15651g;

    /* renamed from: h  reason: collision with root package name */
    public CustomViewPager f15652h;

    /* renamed from: i  reason: collision with root package name */
    public FrsGameTabPagerAdapter f15653i;
    public View j;
    public View k;
    public List<e> l;
    public int m;
    public int n;
    public boolean o;
    public f p;
    public d.a.s0.u0.r1.a.d.a q;
    public d.a.s0.u0.r1.a.d.a r;
    public d.a.s0.u0.r1.a.d.c s;

    /* loaded from: classes5.dex */
    public class a implements d.a.s0.u0.r1.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollLabelTabHost f15654a;

        public a(ScrollLabelTabHost scrollLabelTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollLabelTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15654a = scrollLabelTabHost;
        }

        @Override // d.a.s0.u0.r1.a.d.a
        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f15654a.q != null) {
                    return this.f15654a.q.a(i2);
                }
                return null;
            }
            return (e) invokeI.objValue;
        }

        @Override // d.a.s0.u0.r1.a.d.a
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f15654a.q == null) {
                return;
            }
            this.f15654a.q.b(i2, i3);
        }

        @Override // d.a.s0.u0.r1.a.d.a
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f15654a.q == null) {
                return;
            }
            this.f15654a.q.c(i2, i3);
        }

        @Override // d.a.s0.u0.r1.a.d.a
        public boolean d(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
                if (this.f15654a.q != null) {
                    return this.f15654a.q.d(i2, i3);
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        @Override // d.a.s0.u0.r1.a.d.a
        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f15654a.q != null) {
                    return this.f15654a.q.i();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.s0.u0.r1.a.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollLabelTabHost f15655a;

        public b(ScrollLabelTabHost scrollLabelTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollLabelTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15655a = scrollLabelTabHost;
        }

        @Override // d.a.s0.u0.r1.a.d.c
        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (e) ListUtils.getItem(this.f15655a.l, i2) : (e) invokeI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ScrollHorizontalTabView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollLabelTabHost f15656a;

        public c(ScrollLabelTabHost scrollLabelTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollLabelTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15656a = scrollLabelTabHost;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public boolean a(int i2, e eVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, eVar)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public void b(int i2, e eVar) {
            d.a.s0.u0.r1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, eVar) == null) || eVar == null) {
                return;
            }
            this.f15656a.m = eVar.f66935a;
            Object obj = eVar.f66937c;
            if (obj instanceof LabelDataList) {
                LabelDataList labelDataList = (LabelDataList) obj;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.f15656a.n = aVar.f66899a;
                }
            }
            if (this.f15656a.o(eVar)) {
                this.f15656a.f15650f.setVisibility(0);
            } else {
                this.f15656a.f15650f.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements FoldedGridView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollLabelTabHost f15657a;

        public d(ScrollLabelTabHost scrollLabelTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollLabelTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15657a = scrollLabelTabHost;
        }

        @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
        public void a(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, obj) == null) && (obj instanceof d.a.s0.u0.r1.a.a.a)) {
                this.f15657a.n = ((d.a.s0.u0.r1.a.a.a) obj).f66899a;
                FrsGameStrategyItemListView e2 = this.f15657a.f15653i.e();
                e2.o(this.f15657a.m, this.f15657a.n);
                if (this.f15657a.r == null || this.f15657a.r.d(this.f15657a.m, this.f15657a.n)) {
                    return;
                }
                e2.s();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollLabelTabHost(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.r = new a(this);
        this.s = new b(this);
        l(context);
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15653i.e() : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public void j(int i2, int i3, List<n> list, List<e> list2, boolean z, boolean z2, int i4) {
        FrsGameStrategyItemListView f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || (f2 = this.f15653i.f(i2, i3)) == null) {
            return;
        }
        f2.a(i2, i3, list, list2, z, z2, i4);
        if (i4 != -1) {
            q(i4);
        }
    }

    public void k() {
        FrsGameStrategyItemListView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (e2 = this.f15653i.e()) == null) {
            return;
        }
        e2.s();
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
            this.f15653i = new FrsGameTabPagerAdapter(context, this.r, this.s);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
            this.f15652h = customViewPager;
            customViewPager.setAdapter(this.f15653i);
            ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
            this.f15649e = scrollHorizontalTabView;
            scrollHorizontalTabView.setViewPager(this.f15652h);
            this.f15649e.setScrollTabPageListener(new c(this));
            this.f15651g = new d.a.s0.u0.r1.a.d.d(getContext());
            FoldedGridView foldedGridView = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
            this.f15650f = foldedGridView;
            foldedGridView.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
            this.f15650f.setNumColumns(5);
            this.f15650f.setFoldAdapter(this.f15651g);
            this.f15650f.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
            this.f15650f.setFoldGridViewOnItemClickListener(new d(this));
            this.j = findViewById(R.id.frs_game_tab_line);
            this.k = findViewById(R.id.frs_game_label_line);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f15649e.onChangeSkinType(i2);
            this.f15650f.d(i2);
            this.f15653i.j(i2);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f fVar = this.p;
            if (fVar != null) {
                fVar.g();
            }
            this.f15653i.k();
        }
    }

    public boolean o(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null) {
                Object obj = eVar.f66937c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (labelDataList.isEmpty()) {
                        return false;
                    }
                    this.f15651g.n(labelDataList);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p(int i2, int i3, String str) {
        FrsGameStrategyItemListView f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, str) == null) || (f2 = this.f15653i.f(i2, i3)) == null) {
            return;
        }
        f2.b(i2, i3, str);
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            f fVar = this.p;
            if (fVar != null && fVar.f()) {
                this.p.g();
            }
            this.p = new f(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
            layoutParams.addRule(10);
            TextView e2 = this.p.e();
            if (i2 == 0) {
                e2.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
            } else {
                e2.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2)));
            }
            addView(e2, layoutParams);
            this.p.d();
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(d.a.s0.u0.r1.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrsGameTabPagerAdapter frsGameTabPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || (frsGameTabPagerAdapter = this.f15653i) == null) {
            return;
        }
        frsGameTabPagerAdapter.m(bdUniqueId);
    }

    public void setTabData(List<e> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o || this.l == null) {
            this.o = z;
            this.l = list;
            this.f15653i.l(list == null ? 0 : list.size());
            this.f15649e.setData(list);
            if (ListUtils.isEmpty(list)) {
                this.f15649e.setVisibility(8);
                this.j.setVisibility(8);
                return;
            }
            this.f15649e.setVisibility(0);
            this.j.setVisibility(0);
            this.f15649e.setCurrentIndex(0, false);
            if (o(list.get(0))) {
                this.f15650f.setVisibility(0);
                this.k.setVisibility(0);
                return;
            }
            this.f15650f.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.r = new a(this);
        this.s = new b(this);
        l(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.r = new a(this);
        this.s = new b(this);
        l(context);
    }
}
