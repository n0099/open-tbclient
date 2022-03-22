package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.f1.u1.a.d.e;
import c.a.p0.f1.u1.a.e.f;
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
import java.util.List;
/* loaded from: classes5.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScrollHorizontalTabView a;

    /* renamed from: b  reason: collision with root package name */
    public FoldedGridView f32542b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f1.u1.a.d.d f32543c;

    /* renamed from: d  reason: collision with root package name */
    public CustomViewPager f32544d;

    /* renamed from: e  reason: collision with root package name */
    public FrsGameTabPagerAdapter f32545e;

    /* renamed from: f  reason: collision with root package name */
    public View f32546f;

    /* renamed from: g  reason: collision with root package name */
    public View f32547g;

    /* renamed from: h  reason: collision with root package name */
    public List<e> f32548h;
    public int i;
    public int j;
    public boolean k;
    public f l;
    public c.a.p0.f1.u1.a.d.a m;
    public c.a.p0.f1.u1.a.d.a n;
    public c.a.p0.f1.u1.a.d.c o;

    /* loaded from: classes5.dex */
    public class a implements c.a.p0.f1.u1.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollLabelTabHost a;

        public a(ScrollLabelTabHost scrollLabelTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollLabelTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollLabelTabHost;
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public e a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.m != null) {
                    return this.a.m.a(i);
                }
                return null;
            }
            return (e) invokeI.objValue;
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || this.a.m == null) {
                return;
            }
            this.a.m.b(i, i2);
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a.m != null) {
                    return this.a.m.c();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || this.a.m == null) {
                return;
            }
            this.a.m.d(i, i2);
        }

        @Override // c.a.p0.f1.u1.a.d.a
        public boolean e(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
                if (this.a.m != null) {
                    return this.a.m.e(i, i2);
                }
                return false;
            }
            return invokeII.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.p0.f1.u1.a.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollLabelTabHost a;

        public b(ScrollLabelTabHost scrollLabelTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollLabelTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollLabelTabHost;
        }

        @Override // c.a.p0.f1.u1.a.d.c
        public e a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (e) ListUtils.getItem(this.a.f32548h, i) : (e) invokeI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ScrollHorizontalTabView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollLabelTabHost a;

        public c(ScrollLabelTabHost scrollLabelTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollLabelTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollLabelTabHost;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public boolean a(int i, e eVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, eVar)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public void b(int i, e eVar) {
            c.a.p0.f1.u1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, eVar) == null) || eVar == null) {
                return;
            }
            this.a.i = eVar.a;
            Object obj = eVar.f14714c;
            if (obj instanceof LabelDataList) {
                LabelDataList labelDataList = (LabelDataList) obj;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.a.j = aVar.a;
                }
            }
            if (this.a.o(eVar)) {
                this.a.f32542b.setVisibility(0);
            } else {
                this.a.f32542b.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements FoldedGridView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollLabelTabHost a;

        public d(ScrollLabelTabHost scrollLabelTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollLabelTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollLabelTabHost;
        }

        @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
        public void a(int i, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, obj) == null) && (obj instanceof c.a.p0.f1.u1.a.a.a)) {
                this.a.j = ((c.a.p0.f1.u1.a.a.a) obj).a;
                FrsGameStrategyItemListView b2 = this.a.f32545e.b();
                b2.o(this.a.i, this.a.j);
                if (this.a.n == null || this.a.n.e(this.a.i, this.a.j)) {
                    return;
                }
                b2.s();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.n = new a(this);
        this.o = new b(this);
        l(context);
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32545e.b() : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public void j(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || (c2 = this.f32545e.c(i, i2)) == null) {
            return;
        }
        c2.a(i, i2, list, list2, z, z2, i3);
        if (i3 != -1) {
            q(i3);
        }
    }

    public void k() {
        FrsGameStrategyItemListView b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (b2 = this.f32545e.b()) == null) {
            return;
        }
        b2.s();
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0319, this);
            this.f32545e = new FrsGameTabPagerAdapter(context, this.n, this.o);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f090b09);
            this.f32544d = customViewPager;
            customViewPager.setAdapter(this.f32545e);
            ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) findViewById(R.id.obfuscated_res_0x7f090b0e);
            this.a = scrollHorizontalTabView;
            scrollHorizontalTabView.setViewPager(this.f32544d);
            this.a.setScrollTabPageListener(new c(this));
            this.f32543c = new c.a.p0.f1.u1.a.d.d(getContext());
            FoldedGridView foldedGridView = (FoldedGridView) findViewById(R.id.obfuscated_res_0x7f090afc);
            this.f32542b = foldedGridView;
            foldedGridView.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
            this.f32542b.setNumColumns(5);
            this.f32542b.setFoldAdapter(this.f32543c);
            this.f32542b.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
            this.f32542b.setFoldGridViewOnItemClickListener(new d(this));
            this.f32546f = findViewById(R.id.obfuscated_res_0x7f090b0d);
            this.f32547g = findViewById(R.id.obfuscated_res_0x7f090afa);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.onChangeSkinType(i);
            this.f32542b.d(i);
            this.f32545e.e(i);
            SkinManager.setBackgroundColor(this.f32546f, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f32547g, R.color.CAM_X0204);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f fVar = this.l;
            if (fVar != null) {
                fVar.g();
            }
            this.f32545e.f();
        }
    }

    public boolean o(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null) {
                Object obj = eVar.f14714c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (labelDataList.isEmpty()) {
                        return false;
                    }
                    this.f32543c.n(labelDataList);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p(int i, int i2, String str) {
        FrsGameStrategyItemListView c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, str) == null) || (c2 = this.f32545e.c(i, i2)) == null) {
            return;
        }
        c2.b(i, i2, str);
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            f fVar = this.l;
            if (fVar != null && fVar.f()) {
                this.l.g();
            }
            this.l = new f(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253));
            layoutParams.addRule(10);
            TextView e2 = this.l.e();
            if (i == 0) {
                e2.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0f4d));
            } else {
                e2.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0f4e), Integer.valueOf(i)));
            }
            addView(e2, layoutParams);
            this.l.d();
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(c.a.p0.f1.u1.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrsGameTabPagerAdapter frsGameTabPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || (frsGameTabPagerAdapter = this.f32545e) == null) {
            return;
        }
        frsGameTabPagerAdapter.h(bdUniqueId);
    }

    public void setTabData(List<e> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.k || this.f32548h == null) {
            this.k = z;
            this.f32548h = list;
            this.f32545e.g(list == null ? 0 : list.size());
            this.a.setData(list);
            if (ListUtils.isEmpty(list)) {
                this.a.setVisibility(8);
                this.f32546f.setVisibility(8);
                return;
            }
            this.a.setVisibility(0);
            this.f32546f.setVisibility(0);
            this.a.setCurrentIndex(0, false);
            if (o(list.get(0))) {
                this.f32542b.setVisibility(0);
                this.f32547g.setVisibility(0);
                return;
            }
            this.f32542b.setVisibility(8);
            this.f32547g.setVisibility(8);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.n = new a(this);
        this.o = new b(this);
        l(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.n = new a(this);
        this.o = new b(this);
        l(context);
    }
}
