package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.flow.CoverFlowLocalView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.w.b.c;
import d.a.r0.r.w.b.d;
import d.a.r0.r.w.b.e;
import d.a.s0.u0.h;
import java.util.List;
/* loaded from: classes5.dex */
public class LocalBannerLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowLocalView<h> f15405e;

    /* renamed from: f  reason: collision with root package name */
    public d<h> f15406f;

    /* renamed from: g  reason: collision with root package name */
    public List<h> f15407g;

    /* renamed from: h  reason: collision with root package name */
    public d<h> f15408h;

    /* loaded from: classes5.dex */
    public class a extends d.a.r0.r.w.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LocalBannerLayout f15409a;

        public a(LocalBannerLayout localBannerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localBannerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15409a = localBannerLayout;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c cVar = new c();
                cVar.c(R.drawable.icon_mask_goods_select8);
                cVar.g(R.drawable.icon_mask_goods_unselect8);
                cVar.d(81);
                cVar.e(R.dimen.tbds36);
                cVar.h(R.dimen.tbds20);
                return cVar;
            }
            return (c) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a(l.g(this.f15409a.getContext(), R.dimen.tbds690));
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setPlaceHolder(2);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LocalBannerLayout f15410a;

        public b(LocalBannerLayout localBannerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localBannerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15410a = localBannerLayout;
        }

        @Override // d.a.r0.r.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || i2 < 0 || this.f15410a.f15407g == null || i2 > this.f15410a.f15407g.size() + 1 || this.f15410a.f15406f == null) {
                return;
            }
            this.f15410a.f15406f.b(i2, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, h hVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, hVar) == null) || i2 < 0 || this.f15410a.f15407g == null || i2 > this.f15410a.f15407g.size() + 1 || this.f15410a.f15406f == null) {
                return;
            }
            this.f15410a.f15406f.a(i2, hVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalBannerLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15405e = new CoverFlowLocalView<>(getContext());
            a aVar = new a(this);
            this.f15405e.setIndicatorNoOffet(false);
            this.f15405e.setDisableParentEvent(false);
            this.f15405e.setCoverFlowFactory(aVar);
            this.f15405e.setIndicatorVisible(0);
            this.f15405e.setIsAutoPlayDragging(false);
            this.f15405e.setAutoPlay(false);
            this.f15405e.setCallback(this.f15408h);
            addView(this.f15405e);
        }
    }

    public void setData(List<h> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f15407g = list;
            this.f15405e.setData(list);
        }
    }

    public void setOnCoverViewCallback(d<h> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f15406f = dVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBannerLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f15408h = new b(this);
        c();
    }
}
