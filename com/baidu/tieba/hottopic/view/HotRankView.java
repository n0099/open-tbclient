package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.r0.g0.h;
import c.a.r0.s.i0.f;
import c.a.r0.s.i0.g;
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
/* loaded from: classes12.dex */
public class HotRankView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f46155e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f46156f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.q1.j.a f46157g;

    /* renamed from: h  reason: collision with root package name */
    public g f46158h;

    /* renamed from: i  reason: collision with root package name */
    public View f46159i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.g0.g f46160j;

    /* renamed from: k  reason: collision with root package name */
    public h f46161k;

    /* loaded from: classes12.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f46162e;

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
            this.f46162e = hotRankView;
        }

        @Override // c.a.r0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!k.z()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    this.f46162e.f46156f.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
                ((HotRanklistActivity) this.f46162e.f46155e.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f46163e;

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
            this.f46163e = hotRankView;
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

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRankView f46164e;

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
            this.f46164e = hotRankView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && k.A()) {
                this.f46164e.hideNetRefreshView();
                HotRankView hotRankView = this.f46164e;
                hotRankView.showLoadingView(true, m.f(hotRankView.f46155e.getPageActivity(), c.a.s0.q1.c.ds500));
                ((HotRanklistActivity) this.f46164e.f46155e.getOrignalPage()).loadHotTopicRanklistData();
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
        this.f46156f = null;
        this.f46157g = null;
        this.f46158h = null;
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            BdTypeListView bdTypeListView = new BdTypeListView(context);
            this.f46156f = bdTypeListView;
            bdTypeListView.setVerticalScrollBarEnabled(false);
            this.f46156f.setDividerHeight(0);
            this.f46156f.setSelector(17170445);
            c.a.d.a.f<?> a2 = j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f46155e = (TbPageContext) a2;
            }
            g gVar = new g(this.f46155e);
            this.f46158h = gVar;
            gVar.a(new a(this));
            this.f46156f.setPullRefresh(this.f46158h);
            this.f46159i = BdListViewHelper.d(context, this.f46156f, BdListViewHelper.HeadType.HASTAB);
            this.f46156f.setOnScrollListener(new b(this));
            this.f46157g = new c.a.s0.q1.j.a((HotRanklistActivity) this.f46155e.getOrignalPage(), this.f46156f);
            addView(this.f46156f);
        }
    }

    public void completePullRefresh(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdTypeListView = this.f46156f) == null) {
            return;
        }
        if (z) {
            bdTypeListView.completePullRefresh();
        } else {
            bdTypeListView.completePullRefreshPostDelayed(0L);
        }
    }

    public void hideLoadingView() {
        c.a.r0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f46160j) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f46160j = null;
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f46161k) == null) {
            return;
        }
        hVar.dettachView(this);
        this.f46161k = null;
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.r0.g0.g gVar = this.f46160j;
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
            h hVar = this.f46161k;
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdTypeListView = this.f46156f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this, c.a.s0.q1.b.CAM_X0201);
            SkinManager.setBackgroundColor(this.f46156f, c.a.s0.q1.b.CAM_X0201);
            this.f46156f.getListAdapter().notifyDataSetChanged();
            c.a.r0.g0.g gVar = this.f46160j;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.f46161k;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }

    public void onTabLayoutSizeChanged(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.f46159i.getLayoutParams();
            layoutParams.height = i3;
            this.f46159i.setLayoutParams(layoutParams);
        }
    }

    public void refreshView(c.a.s0.q1.l.j jVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, jVar, str) == null) || this.f46157g == null) {
            return;
        }
        if (jVar == null) {
            jVar = new c.a.s0.q1.l.j();
        }
        this.f46156f.setVisibility(0);
        this.f46157g.b(jVar, str);
    }

    public void showLoadingView(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.f46160j == null) {
            if (i2 <= 0) {
                this.f46160j = new c.a.r0.g0.g(getContext());
            } else {
                c.a.r0.g0.g gVar = new c.a.r0.g0.g(getContext(), i2);
                this.f46160j = gVar;
                gVar.h();
            }
            this.f46160j.onChangeSkinType();
        }
        this.f46160j.attachView(this, z);
        this.f46156f.setVisibility(8);
    }

    public void showNetRefreshView(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.f46161k == null) {
            this.f46161k = new h(getContext(), new c(this));
        }
        this.f46161k.k(getContext().getResources().getDimensionPixelSize(c.a.s0.q1.c.ds280));
        this.f46161k.attachView(this, z);
        this.f46161k.p();
        this.f46156f.setVisibility(8);
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
        this.f46156f = null;
        this.f46157g = null;
        this.f46158h = null;
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
        this.f46156f = null;
        this.f46157g = null;
        this.f46158h = null;
        c(context);
    }
}
