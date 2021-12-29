package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.t0.d1.d2.a.d.e;
import c.a.t0.d1.d2.a.e.f;
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
/* loaded from: classes12.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollHorizontalTabView f44994e;

    /* renamed from: f  reason: collision with root package name */
    public FoldedGridView f44995f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.d1.d2.a.d.d f44996g;

    /* renamed from: h  reason: collision with root package name */
    public CustomViewPager f44997h;

    /* renamed from: i  reason: collision with root package name */
    public FrsGameTabPagerAdapter f44998i;

    /* renamed from: j  reason: collision with root package name */
    public View f44999j;

    /* renamed from: k  reason: collision with root package name */
    public View f45000k;
    public List<e> l;
    public int m;
    public int n;
    public boolean o;
    public f p;
    public c.a.t0.d1.d2.a.d.a q;
    public c.a.t0.d1.d2.a.d.a r;
    public c.a.t0.d1.d2.a.d.c s;

    /* loaded from: classes12.dex */
    public class a implements c.a.t0.d1.d2.a.d.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollLabelTabHost;
        }

        @Override // c.a.t0.d1.d2.a.d.a
        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.a.q != null) {
                    return this.a.q.a(i2);
                }
                return null;
            }
            return (e) invokeI.objValue;
        }

        @Override // c.a.t0.d1.d2.a.d.a
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.a.q == null) {
                return;
            }
            this.a.q.b(i2, i3);
        }

        @Override // c.a.t0.d1.d2.a.d.a
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.a.q == null) {
                return;
            }
            this.a.q.c(i2, i3);
        }

        @Override // c.a.t0.d1.d2.a.d.a
        public boolean d(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
                if (this.a.q != null) {
                    return this.a.q.d(i2, i3);
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        @Override // c.a.t0.d1.d2.a.d.a
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.a.q != null) {
                    return this.a.q.getForumId();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b implements c.a.t0.d1.d2.a.d.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollLabelTabHost;
        }

        @Override // c.a.t0.d1.d2.a.d.c
        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (e) ListUtils.getItem(this.a.l, i2) : (e) invokeI.objValue;
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollLabelTabHost;
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
            c.a.t0.d1.d2.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, eVar) == null) || eVar == null) {
                return;
            }
            this.a.m = eVar.a;
            Object obj = eVar.f16338c;
            if (obj instanceof LabelDataList) {
                LabelDataList labelDataList = (LabelDataList) obj;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.a.n = aVar.a;
                }
            }
            if (this.a.setLabelData(eVar)) {
                this.a.f44995f.setVisibility(0);
            } else {
                this.a.f44995f.setVisibility(8);
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollLabelTabHost;
        }

        @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
        public void a(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, obj) == null) && (obj instanceof c.a.t0.d1.d2.a.a.a)) {
                this.a.n = ((c.a.t0.d1.d2.a.a.a) obj).a;
                FrsGameStrategyItemListView currentView = this.a.f44998i.getCurrentView();
                currentView.initTab(this.a.m, this.a.n);
                if (this.a.r == null || this.a.r.d(this.a.m, this.a.n)) {
                    return;
                }
                currentView.pullToRefresh();
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
        j(context);
    }

    public void fillDataByTabAndLabel(int i2, int i3, List<n> list, List<e> list2, boolean z, boolean z2, int i4) {
        FrsGameStrategyItemListView viewByTabAndLabel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || (viewByTabAndLabel = this.f44998i.getViewByTabAndLabel(i2, i3)) == null) {
            return;
        }
        viewByTabAndLabel.refreshView(i2, i3, list, list2, z, z2, i4);
        if (i4 != -1) {
            showRecommendTipView(i4);
        }
    }

    public void forceRefresh() {
        FrsGameStrategyItemListView currentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (currentView = this.f44998i.getCurrentView()) == null) {
            return;
        }
        currentView.pullToRefresh();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44998i.getCurrentView() : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
            this.f44998i = new FrsGameTabPagerAdapter(context, this.r, this.s);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
            this.f44997h = customViewPager;
            customViewPager.setAdapter(this.f44998i);
            ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
            this.f44994e = scrollHorizontalTabView;
            scrollHorizontalTabView.setViewPager(this.f44997h);
            this.f44994e.setScrollTabPageListener(new c(this));
            this.f44996g = new c.a.t0.d1.d2.a.d.d(getContext());
            FoldedGridView foldedGridView = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
            this.f44995f = foldedGridView;
            foldedGridView.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
            this.f44995f.setNumColumns(5);
            this.f44995f.setFoldAdapter(this.f44996g);
            this.f44995f.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
            this.f44995f.setFoldGridViewOnItemClickListener(new d(this));
            this.f44999j = findViewById(R.id.frs_game_tab_line);
            this.f45000k = findViewById(R.id.frs_game_label_line);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f44994e.onChangeSkinType(i2);
            this.f44995f.onChangeSkinType(i2);
            this.f44998i.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f44999j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f45000k, R.color.CAM_X0204);
        }
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f fVar = this.p;
            if (fVar != null) {
                fVar.g();
            }
            this.f44998i.onDestory();
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(c.a.t0.d1.d2.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public boolean setLabelData(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null) {
                Object obj = eVar.f16338c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (labelDataList.isEmpty()) {
                        return false;
                    }
                    this.f44996g.n(labelDataList);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrsGameTabPagerAdapter frsGameTabPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) || (frsGameTabPagerAdapter = this.f44998i) == null) {
            return;
        }
        frsGameTabPagerAdapter.setPageId(bdUniqueId);
    }

    public void setTabData(List<e> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o || this.l == null) {
            this.o = z;
            this.l = list;
            this.f44998i.setCount(list == null ? 0 : list.size());
            this.f44994e.setData(list);
            if (ListUtils.isEmpty(list)) {
                this.f44994e.setVisibility(8);
                this.f44999j.setVisibility(8);
                return;
            }
            this.f44994e.setVisibility(0);
            this.f44999j.setVisibility(0);
            this.f44994e.setCurrentIndex(0, false);
            if (setLabelData(list.get(0))) {
                this.f44995f.setVisibility(0);
                this.f45000k.setVisibility(0);
                return;
            }
            this.f44995f.setVisibility(8);
            this.f45000k.setVisibility(8);
        }
    }

    public void showErrorByTabAndLabel(int i2, int i3, String str) {
        FrsGameStrategyItemListView viewByTabAndLabel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, str) == null) || (viewByTabAndLabel = this.f44998i.getViewByTabAndLabel(i2, i3)) == null) {
            return;
        }
        viewByTabAndLabel.showError(i2, i3, str);
    }

    public void showRecommendTipView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
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
        j(context);
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
        j(context);
    }
}
