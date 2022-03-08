package com.baidu.tieba.frs.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.o.e.n;
import c.a.d.o.e.v;
import c.a.l.q;
import c.a.q0.r.v.c;
import c.a.r0.d1.j2.e;
import c.a.r0.d1.j2.f;
import c.a.r0.d1.j2.h;
import c.a.r0.y3.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsLikeRecommendLayout extends ConstraintLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42344e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f42345f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f42346g;

    /* renamed from: h  reason: collision with root package name */
    public e f42347h;

    /* renamed from: i  reason: collision with root package name */
    public f f42348i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendLayout(Context context) {
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

    private v getItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new v() { // from class: c.a.r0.d1.j2.c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.d.o.e.v
            public final void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                    FrsLikeRecommendLayout.this.b(view, nVar, bdUniqueId, viewGroup, i2, j2);
                }
            }
        } : (v) invokeV.objValue;
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_like_recommend_forum_layout, this);
            this.f42344e = (TextView) findViewById(R.id.frs_like_recommend_title);
            this.f42346g = (BdTypeRecyclerView) findViewById(R.id.frs_like_recommend_recycler);
            this.f42345f = (ImageView) findViewById(R.id.frs_like_recommend_close);
            e eVar = new e(getContext());
            this.f42347h = eVar;
            eVar.V(getItemClickListener());
            BdTypeRecyclerView bdTypeRecyclerView = this.f42346g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
                this.f42346g.addItemDecoration(new FrsLikeRecommendDecoration());
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f42347h);
                this.f42346g.addAdapters(arrayList);
            }
        }
    }

    public /* synthetic */ void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, final int i2, long j2) {
        f fVar;
        if (nVar instanceof m) {
            if (view.getId() == R.id.frs_like_recommend_item_root) {
                f fVar2 = this.f42348i;
                if (fVar2 != null) {
                    fVar2.g((m) nVar);
                }
            } else if (view.getId() != R.id.forum_like_btn || (fVar = this.f42348i) == null) {
            } else {
                fVar.h((m) nVar, i2, new h() { // from class: c.a.r0.d1.j2.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // c.a.r0.d1.j2.h
                    public final void a() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            FrsLikeRecommendLayout.this.c(i2);
                        }
                    }
                });
            }
        }
    }

    public void bind(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull List<m> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, str, list) == null) || this.f42346g == null || ListUtils.isEmpty(list)) {
            return;
        }
        f fVar = new f(tbPageContext, str);
        this.f42348i = fVar;
        fVar.l(list.size());
        this.f42346g.setData(list);
    }

    public /* synthetic */ void d(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        f fVar = this.f42348i;
        if (fVar != null) {
            fVar.i();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public final void c(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (bdTypeRecyclerView = this.f42346g) == null || this.f42347h == null) {
            return;
        }
        n item = bdTypeRecyclerView.getItem(i2);
        if (item instanceof m) {
            ((m) item).f25085i = true;
            this.f42347h.H();
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            TextView textView = this.f42344e;
            if (textView != null) {
                c d2 = c.d(textView);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0101);
            }
            ImageView imageView = this.f42345f;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0622, null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            f fVar = this.f42348i;
            if (fVar != null) {
                fVar.d();
            }
        }
    }

    public void setCloseListener(final View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) || (imageView = this.f42345f) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.d1.j2.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    FrsLikeRecommendLayout.this.d(onClickListener, view);
                }
            }
        });
    }

    public void setThemeColor(String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (eVar = this.f42347h) == null) {
            return;
        }
        eVar.c0(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendLayout(Context context, AttributeSet attributeSet) {
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
    public FrsLikeRecommendLayout(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
