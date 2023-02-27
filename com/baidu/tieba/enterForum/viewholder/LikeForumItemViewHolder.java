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
import com.baidu.tieba.ej;
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.tieba.kk5;
import com.baidu.tieba.n05;
import com.baidu.tieba.um6;
import com.baidu.tieba.xy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LikeForumItemViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public TextView c;
    public ImageView d;
    public ImageView e;
    public BarImageView f;
    public TextView g;
    public ViewEventCenter h;
    public LikeForumItemAdapter.b i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy4 a;
        public final /* synthetic */ LikeForumItemViewHolder b;

        public a(LikeForumItemViewHolder likeForumItemViewHolder, xy4 xy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeForumItemViewHolder, xy4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = likeForumItemViewHolder;
            this.a = xy4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.b.f());
                bundle.putParcelable("info_forum_name_rect", this.b.g());
                kk5 kk5Var = new kk5(1, this.a, null, null);
                kk5Var.g(bundle);
                this.b.h.dispatchMvcEvent(kk5Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy4 a;
        public final /* synthetic */ LikeForumItemViewHolder b;

        public b(LikeForumItemViewHolder likeForumItemViewHolder, xy4 xy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeForumItemViewHolder, xy4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = likeForumItemViewHolder;
            this.a = xy4Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.b.i != null) {
                    return this.b.i.a(this.a, this.b);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ LikeForumItemViewHolder c;

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
            this.c = likeForumItemViewHolder;
            this.a = textView;
            this.b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (l = ej.l(this.c.itemView.getContext())) != 0) {
                this.a.setMaxWidth(l - (this.b + ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeForumItemViewHolder(TbPageContext tbPageContext, @NonNull View view2, ViewEventCenter viewEventCenter) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter};
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
        this.h = viewEventCenter;
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091dfb);
        this.b = findViewById;
        this.c = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091768);
        this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f092051);
        this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090dcf);
        this.f = (BarImageView) this.b.findViewById(R.id.forum_avatar);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090b52);
        this.f.setPlaceHolder(1);
        this.f.setStrokeColorResId(R.color.CAM_X0201);
    }

    public void e(um6 um6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, um6Var) != null) || um6Var == null) {
            return;
        }
        j(um6Var);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
    }

    public void h(LikeForumItemAdapter.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public final Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Rect rect = new Rect();
            this.f.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final Rect g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Rect rect = new Rect();
            this.c.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final void i(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048580, this, textView, i) != null) || textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new c(this, textView, i));
    }

    public final void j(xy4 xy4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, xy4Var) != null) || xy4Var == null) {
            return;
        }
        this.b.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        if (xy4Var instanceof um6) {
            um6 um6Var = (um6) xy4Var;
            this.c.setText(um6Var.n());
            ImageView imageView = this.d;
            if (um6Var.x() == 0) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
            if (um6Var.l() == 0) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                SkinManager.setImageResource(this.e, BitmapHelper.getGradeResourceIdInEnterForum(um6Var.l()));
            }
            this.f.setShowOval(true);
            this.f.K(um6Var.g(), 10, false);
            this.f.setShowOuterBorder(false);
            this.f.setShowInnerBorder(true);
            this.f.setStrokeWith(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f.setStrokeColorResId(R.color.CAM_X0401);
            this.g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0936), StringHelper.numberUniformFormatExtraWithRoundInt(um6Var.r())));
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(um6Var.n())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
        } else if (xy4Var instanceof n05) {
            n05 n05Var = (n05) xy4Var;
            this.c.setText(n05Var.j());
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(n05Var.j())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
        this.b.setOnClickListener(new a(this, xy4Var));
        this.b.setOnLongClickListener(new b(this, xy4Var));
        i(this.c, 0);
    }
}
