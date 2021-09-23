package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.g0.h;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HotRankView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f52819e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f52820f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.i1.a.a f52821g;

    /* renamed from: h  reason: collision with root package name */
    public g f52822h;

    /* renamed from: i  reason: collision with root package name */
    public View f52823i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.g0.g f52824j;
    public h k;

    /* loaded from: classes7.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f52825e;

        public a(HotRankView hotRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52825e = hotRankView;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!j.z()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    this.f52825e.f52820f.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
                ((HotRanklistActivity) this.f52825e.f52819e.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f52826e;

        public b(HotRankView hotRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52826e = hotRankView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013));
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f52827e;

        public c(HotRankView hotRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52827e = hotRankView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f52827e.hideNetRefreshView();
                HotRankView hotRankView = this.f52827e;
                hotRankView.showLoadingView(true, l.g(hotRankView.f52819e.getPageActivity(), R.dimen.ds500));
                ((HotRanklistActivity) this.f52827e.f52819e.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRankView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f52820f = null;
        this.f52821g = null;
        this.f52822h = null;
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            BdTypeListView bdTypeListView = new BdTypeListView(context);
            this.f52820f = bdTypeListView;
            bdTypeListView.setVerticalScrollBarEnabled(false);
            this.f52820f.setDividerHeight(0);
            this.f52820f.setSelector(17170445);
            c.a.e.a.f<?> a2 = c.a.e.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f52819e = (TbPageContext) a2;
            }
            g gVar = new g(this.f52819e);
            this.f52822h = gVar;
            gVar.a(new a(this));
            this.f52820f.setPullRefresh(this.f52822h);
            this.f52823i = BdListViewHelper.d(context, this.f52820f, BdListViewHelper.HeadType.HASTAB);
            this.f52820f.setOnScrollListener(new b(this));
            this.f52821g = new c.a.r0.i1.a.a((HotRanklistActivity) this.f52819e.getOrignalPage(), this.f52820f);
            addView(this.f52820f);
        }
    }

    public void completePullRefresh(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdTypeListView = this.f52820f) == null) {
            return;
        }
        if (z) {
            bdTypeListView.completePullRefresh();
        } else {
            bdTypeListView.completePullRefreshPostDelayed(0L);
        }
    }

    public void hideLoadingView() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f52824j) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f52824j = null;
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.k) == null) {
            return;
        }
        hVar.dettachView(this);
        this.k = null;
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.q0.g0.g gVar = this.f52824j;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRefreshViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h hVar = this.k;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void listViewStartPullRefresh() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdTypeListView = this.f52820f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f52820f, R.color.CAM_X0201);
            this.f52820f.getListAdapter().notifyDataSetChanged();
            c.a.q0.g0.g gVar = this.f52824j;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.k;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }

    public void onTabLayoutSizeChanged(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.f52823i.getLayoutParams();
            layoutParams.height = i3;
            this.f52823i.setLayoutParams(layoutParams);
        }
    }

    public void refreshView(c.a.r0.i1.c.j jVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, jVar, str) == null) || this.f52821g == null) {
            return;
        }
        if (jVar == null) {
            jVar = new c.a.r0.i1.c.j();
        }
        this.f52820f.setVisibility(0);
        this.f52821g.b(jVar, str);
    }

    public void showLoadingView(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.f52824j == null) {
            if (i2 <= 0) {
                this.f52824j = new c.a.q0.g0.g(getContext());
            } else {
                c.a.q0.g0.g gVar = new c.a.q0.g0.g(getContext(), i2);
                this.f52824j = gVar;
                gVar.h();
            }
            this.f52824j.onChangeSkinType();
        }
        this.f52824j.attachView(this, z);
        this.f52820f.setVisibility(8);
    }

    public void showNetRefreshView(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.k == null) {
            this.k = new h(getContext(), new c(this));
        }
        this.k.j(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.k.attachView(this, z);
        this.k.o();
        this.f52820f.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRankView(Context context, AttributeSet attributeSet) {
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
        this.f52820f = null;
        this.f52821g = null;
        this.f52822h = null;
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRankView(Context context) {
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
        this.f52820f = null;
        this.f52821g = null;
        this.f52822h = null;
        c(context);
    }
}
