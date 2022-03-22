package com.baidu.tieba.enterForum.viewholder;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.o0.r.r.n1;
import c.a.o0.r.r.x;
import c.a.p0.w0.e.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LikeForumItemViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f31998b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31999c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f32000d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f32001e;

    /* renamed from: f  reason: collision with root package name */
    public BarImageView f32002f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32003g;

    /* renamed from: h  reason: collision with root package name */
    public ViewEventCenter f32004h;
    public LikeForumItemAdapter.b i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LikeForumItemViewHolder f32005b;

        public a(LikeForumItemViewHolder likeForumItemViewHolder, x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeForumItemViewHolder, xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32005b = likeForumItemViewHolder;
            this.a = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.f32005b.f());
                bundle.putParcelable("info_forum_name_rect", this.f32005b.g());
                c.a.o0.k0.c.b bVar = new c.a.o0.k0.c.b(1, this.a, null, null);
                bVar.g(bundle);
                this.f32005b.f32004h.dispatchMvcEvent(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LikeForumItemViewHolder f32006b;

        public b(LikeForumItemViewHolder likeForumItemViewHolder, x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeForumItemViewHolder, xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32006b = likeForumItemViewHolder;
            this.a = xVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f32006b.i != null) {
                    return this.f32006b.i.a(this.a, this.f32006b);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f32007b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LikeForumItemViewHolder f32008c;

        public c(LikeForumItemViewHolder likeForumItemViewHolder, TextView textView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeForumItemViewHolder, textView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32008c = likeForumItemViewHolder;
            this.a = textView;
            this.f32007b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (k = n.k(this.f32008c.itemView.getContext())) != 0) {
                this.a.setMaxWidth(k - (this.f32007b + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeForumItemViewHolder(TbPageContext tbPageContext, @NonNull View view, ViewEventCenter viewEventCenter) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f32004h = viewEventCenter;
        View findViewById = view.findViewById(R.id.obfuscated_res_0x7f091aef);
        this.f31998b = findViewById;
        this.f31999c = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0914e9);
        this.f32000d = (ImageView) this.f31998b.findViewById(R.id.obfuscated_res_0x7f091cfc);
        this.f32001e = (ImageView) this.f31998b.findViewById(R.id.obfuscated_res_0x7f090ce0);
        this.f32002f = (BarImageView) this.f31998b.findViewById(R.id.obfuscated_res_0x7f090a1e);
        this.f32003g = (TextView) this.f31998b.findViewById(R.id.obfuscated_res_0x7f090a54);
        this.f32002f.setPlaceHolder(1);
        this.f32002f.setStrokeColorResId(R.color.CAM_X0201);
    }

    public void e(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) || hVar == null) {
            return;
        }
        j(hVar);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f32000d, R.drawable.obfuscated_res_0x7f0808de, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.f31999c, (int) R.color.CAM_X0105);
    }

    public final Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Rect rect = new Rect();
            this.f32002f.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final Rect g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Rect rect = new Rect();
            this.f31999c.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public void h(LikeForumItemAdapter.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public final void i(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, textView, i) == null) || textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new c(this, textView, i));
    }

    public final void j(x xVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, xVar) == null) || xVar == null) {
            return;
        }
        this.f31998b.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        this.f31998b.setVisibility(0);
        this.f31999c.setVisibility(0);
        if (xVar instanceof h) {
            h hVar = (h) xVar;
            this.f31999c.setText(hVar.r());
            this.f32000d.setVisibility(hVar.G() == 0 ? 8 : 0);
            if (hVar.q() == 0) {
                this.f32001e.setVisibility(8);
            } else {
                this.f32001e.setVisibility(0);
                SkinManager.setImageResource(this.f32001e, BitmapHelper.getGradeResourceIdInEnterForum(hVar.q()));
            }
            this.f32002f.setShowOval(true);
            this.f32002f.J(hVar.i(), 10, false);
            this.f32002f.setShowOuterBorder(false);
            this.f32002f.setShowInnerBorder(true);
            this.f32002f.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f32002f.setStrokeColorResId(R.color.CAM_X0401);
            this.f32003g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0877), StringHelper.numberUniformFormatExtraWithRoundInt(hVar.A())));
            SkinManager.setViewTextColor(this.f32003g, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(hVar.r())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
        } else if (xVar instanceof n1) {
            n1 n1Var = (n1) xVar;
            this.f31999c.setText(n1Var.m());
            this.f32000d.setVisibility(8);
            this.f32001e.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(n1Var.m())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setViewTextColor(this.f31999c, (int) R.color.CAM_X0105);
        this.f31998b.setOnClickListener(new a(this, xVar));
        this.f31998b.setOnLongClickListener(new b(this, xVar));
        i(this.f31999c, 0);
    }
}
