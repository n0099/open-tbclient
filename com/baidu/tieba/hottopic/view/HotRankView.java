package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HotRankView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f50028e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f50029f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.j1.j.a f50030g;

    /* renamed from: h  reason: collision with root package name */
    public g f50031h;

    /* renamed from: i  reason: collision with root package name */
    public View f50032i;
    public b.a.q0.g0.g j;
    public h k;

    /* loaded from: classes9.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f50033e;

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
            this.f50033e = hotRankView;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!j.z()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    this.f50033e.f50029f.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
                ((HotRanklistActivity) this.f50033e.f50028e.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f50034e;

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
            this.f50034e = hotRankView;
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

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f50035e;

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
            this.f50035e = hotRankView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f50035e.hideNetRefreshView();
                HotRankView hotRankView = this.f50035e;
                hotRankView.showLoadingView(true, l.g(hotRankView.f50028e.getPageActivity(), b.a.r0.j1.c.ds500));
                ((HotRanklistActivity) this.f50035e.f50028e.getOrignalPage()).loadHotTopicRanklistData();
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
        this.f50029f = null;
        this.f50030g = null;
        this.f50031h = null;
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            BdTypeListView bdTypeListView = new BdTypeListView(context);
            this.f50029f = bdTypeListView;
            bdTypeListView.setVerticalScrollBarEnabled(false);
            this.f50029f.setDividerHeight(0);
            this.f50029f.setSelector(17170445);
            b.a.e.a.f<?> a2 = b.a.e.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f50028e = (TbPageContext) a2;
            }
            g gVar = new g(this.f50028e);
            this.f50031h = gVar;
            gVar.a(new a(this));
            this.f50029f.setPullRefresh(this.f50031h);
            this.f50032i = BdListViewHelper.d(context, this.f50029f, BdListViewHelper.HeadType.HASTAB);
            this.f50029f.setOnScrollListener(new b(this));
            this.f50030g = new b.a.r0.j1.j.a((HotRanklistActivity) this.f50028e.getOrignalPage(), this.f50029f);
            addView(this.f50029f);
        }
    }

    public void completePullRefresh(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdTypeListView = this.f50029f) == null) {
            return;
        }
        if (z) {
            bdTypeListView.completePullRefresh();
        } else {
            bdTypeListView.completePullRefreshPostDelayed(0L);
        }
    }

    public void hideLoadingView() {
        b.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.dettachView(this);
        this.j = null;
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
            b.a.q0.g0.g gVar = this.j;
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdTypeListView = this.f50029f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this, b.a.r0.j1.b.CAM_X0201);
            SkinManager.setBackgroundColor(this.f50029f, b.a.r0.j1.b.CAM_X0201);
            this.f50029f.getListAdapter().notifyDataSetChanged();
            b.a.q0.g0.g gVar = this.j;
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
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.f50032i.getLayoutParams();
            layoutParams.height = i3;
            this.f50032i.setLayoutParams(layoutParams);
        }
    }

    public void refreshView(b.a.r0.j1.l.j jVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, jVar, str) == null) || this.f50030g == null) {
            return;
        }
        if (jVar == null) {
            jVar = new b.a.r0.j1.l.j();
        }
        this.f50029f.setVisibility(0);
        this.f50030g.b(jVar, str);
    }

    public void showLoadingView(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.j == null) {
            if (i2 <= 0) {
                this.j = new b.a.q0.g0.g(getContext());
            } else {
                b.a.q0.g0.g gVar = new b.a.q0.g0.g(getContext(), i2);
                this.j = gVar;
                gVar.h();
            }
            this.j.onChangeSkinType();
        }
        this.j.attachView(this, z);
        this.f50029f.setVisibility(8);
    }

    public void showNetRefreshView(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.k == null) {
            this.k = new h(getContext(), new c(this));
        }
        this.k.j(getContext().getResources().getDimensionPixelSize(b.a.r0.j1.c.ds280));
        this.k.attachView(this, z);
        this.k.o();
        this.f50029f.setVisibility(8);
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
        this.f50029f = null;
        this.f50030g = null;
        this.f50031h = null;
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
        this.f50029f = null;
        this.f50030g = null;
        this.f50031h = null;
        c(context);
    }
}
