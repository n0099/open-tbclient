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
import com.baidu.tieba.ez7;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.oy7;
import com.baidu.tieba.pi;
import com.baidu.tieba.uy7;
import com.baidu.tieba.wy7;
import com.baidu.tieba.xy7;
import com.baidu.tieba.yy7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScrollHorizontalTabView a;
    public FoldedGridView b;
    public xy7 c;
    public CustomViewPager d;
    public FrsGameTabPagerAdapter e;
    public View f;
    public View g;
    public List<yy7> h;
    public int i;
    public int j;
    public boolean k;
    public ez7 l;
    public uy7 m;
    public uy7 n;
    public wy7 o;

    /* loaded from: classes6.dex */
    public class a implements uy7 {
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

        @Override // com.baidu.tieba.uy7
        public yy7 a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.m != null) {
                    return this.a.m.a(i);
                }
                return null;
            }
            return (yy7) invokeI.objValue;
        }

        @Override // com.baidu.tieba.uy7
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && this.a.m != null) {
                this.a.m.b(i, i2);
            }
        }

        @Override // com.baidu.tieba.uy7
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && this.a.m != null) {
                this.a.m.c(i, i2);
            }
        }

        @Override // com.baidu.tieba.uy7
        public boolean d(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
                if (this.a.m != null) {
                    return this.a.m.d(i, i2);
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        @Override // com.baidu.tieba.uy7
        public String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.a.m != null) {
                    return this.a.m.w();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements wy7 {
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

        @Override // com.baidu.tieba.wy7
        public yy7 a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return (yy7) ListUtils.getItem(this.a.h, i);
            }
            return (yy7) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ScrollHorizontalTabView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollLabelTabHost a;

        @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.f
        public boolean a(int i, yy7 yy7Var) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, yy7Var)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }

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
        public void b(int i, yy7 yy7Var) {
            oy7 oy7Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, yy7Var) != null) || yy7Var == null) {
                return;
            }
            this.a.i = yy7Var.a;
            Object obj = yy7Var.c;
            if (obj instanceof LabelDataList) {
                LabelDataList labelDataList = (LabelDataList) obj;
                if (!labelDataList.isEmpty() && (oy7Var = labelDataList.get(0)) != null) {
                    this.a.j = oy7Var.a;
                }
            }
            if (this.a.o(yy7Var)) {
                this.a.b.setVisibility(0);
            } else {
                this.a.b.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, obj) == null) && (obj instanceof oy7)) {
                this.a.j = ((oy7) obj).a;
                FrsGameStrategyItemListView b = this.a.e.b();
                b.o(this.a.i, this.a.j);
                if (this.a.n != null && !this.a.n.d(this.a.i, this.a.j)) {
                    b.s();
                }
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

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.onChangeSkinType(i);
            this.b.d(i);
            this.e.e(i);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
        }
    }

    public boolean o(yy7 yy7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yy7Var)) == null) {
            if (yy7Var != null) {
                Object obj = yy7Var.c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (labelDataList.isEmpty()) {
                        return false;
                    }
                    this.c.n(labelDataList);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setDelegateFrsGameTabDataLoadListener(uy7 uy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uy7Var) == null) {
            this.m = uy7Var;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrsGameTabPagerAdapter frsGameTabPagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) && (frsGameTabPagerAdapter = this.e) != null) {
            frsGameTabPagerAdapter.h(bdUniqueId);
        }
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e.b();
        }
        return (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public void k() {
        FrsGameStrategyItemListView b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (b2 = this.e.b()) != null) {
            b2.s();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ez7 ez7Var = this.l;
            if (ez7Var != null) {
                ez7Var.g();
            }
            this.e.f();
        }
    }

    public void j(int i, int i2, List<pi> list, List<yy7> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && (c2 = this.e.c(i, i2)) != null) {
            c2.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                q(i3);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0380, this);
            this.e = new FrsGameTabPagerAdapter(context, this.n, this.o);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f090d0e);
            this.d = customViewPager;
            customViewPager.setAdapter(this.e);
            ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) findViewById(R.id.obfuscated_res_0x7f090d13);
            this.a = scrollHorizontalTabView;
            scrollHorizontalTabView.setViewPager(this.d);
            this.a.setScrollTabPageListener(new c(this));
            this.c = new xy7(getContext());
            FoldedGridView foldedGridView = (FoldedGridView) findViewById(R.id.obfuscated_res_0x7f090d01);
            this.b = foldedGridView;
            foldedGridView.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
            this.b.setNumColumns(5);
            this.b.setFoldAdapter(this.c);
            this.b.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
            this.b.setFoldGridViewOnItemClickListener(new d(this));
            this.f = findViewById(R.id.obfuscated_res_0x7f090d12);
            this.g = findViewById(R.id.obfuscated_res_0x7f090cff);
        }
    }

    public void p(int i, int i2, String str) {
        FrsGameStrategyItemListView c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, str) == null) && (c2 = this.e.c(i, i2)) != null) {
            c2.b(i, i2, str);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            ez7 ez7Var = this.l;
            if (ez7Var != null && ez7Var.f()) {
                this.l.g();
            }
            this.l = new ez7(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253));
            layoutParams.addRule(10);
            TextView e = this.l.e();
            if (i == 0) {
                e.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
            } else {
                e.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
            }
            addView(e, layoutParams);
            this.l.d();
        }
    }

    public void setTabData(List<yy7> list, boolean z) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048587, this, list, z) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.k && this.h != null) {
            return;
        }
        this.k = z;
        this.h = list;
        FrsGameTabPagerAdapter frsGameTabPagerAdapter = this.e;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        frsGameTabPagerAdapter.g(size);
        this.a.setData(list);
        if (ListUtils.isEmpty(list)) {
            this.a.setVisibility(8);
            this.f.setVisibility(8);
            return;
        }
        this.a.setVisibility(0);
        this.f.setVisibility(0);
        this.a.setCurrentIndex(0, false);
        if (o(list.get(0))) {
            this.b.setVisibility(0);
            this.g.setVisibility(0);
            return;
        }
        this.b.setVisibility(8);
        this.g.setVisibility(8);
    }
}
