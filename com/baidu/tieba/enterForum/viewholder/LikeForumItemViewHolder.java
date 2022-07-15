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
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c56;
import com.repackage.cq4;
import com.repackage.lo4;
import com.repackage.pi;
import com.repackage.x75;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lo4 a;
        public final /* synthetic */ LikeForumItemViewHolder b;

        public a(LikeForumItemViewHolder likeForumItemViewHolder, lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeForumItemViewHolder, lo4Var};
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
            this.a = lo4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.b.f());
                bundle.putParcelable("info_forum_name_rect", this.b.g());
                x75 x75Var = new x75(1, this.a, null, null);
                x75Var.g(bundle);
                this.b.h.dispatchMvcEvent(x75Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lo4 a;
        public final /* synthetic */ LikeForumItemViewHolder b;

        public b(LikeForumItemViewHolder likeForumItemViewHolder, lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeForumItemViewHolder, lo4Var};
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
            this.a = lo4Var;
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

    /* loaded from: classes3.dex */
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
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (k = pi.k(this.c.itemView.getContext())) != 0) {
                this.a.setMaxWidth(k - (this.b + pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
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
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091b73);
        this.b = findViewById;
        this.c = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f09155e);
        this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091d86);
        this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090c91);
        this.f = (BarImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0909fc);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a2e);
        this.f.setPlaceHolder(1);
        this.f.setStrokeColorResId(R.color.CAM_X0201);
    }

    public void e(c56 c56Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c56Var) == null) || c56Var == null) {
            return;
        }
        j(c56Var);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.obfuscated_res_0x7f0808ed, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
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

    public final void j(lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, lo4Var) == null) || lo4Var == null) {
            return;
        }
        this.b.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        if (lo4Var instanceof c56) {
            c56 c56Var = (c56) lo4Var;
            this.c.setText(c56Var.o());
            this.d.setVisibility(c56Var.G() == 0 ? 8 : 0);
            if (c56Var.m() == 0) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                SkinManager.setImageResource(this.e, BitmapHelper.getGradeResourceIdInEnterForum(c56Var.m()));
            }
            this.f.setShowOval(true);
            this.f.J(c56Var.g(), 10, false);
            this.f.setShowOuterBorder(false);
            this.f.setShowInnerBorder(true);
            this.f.setStrokeWith(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f.setStrokeColorResId(R.color.CAM_X0401);
            this.g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f088d), StringHelper.numberUniformFormatExtraWithRoundInt(c56Var.A())));
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(c56Var.o())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
        } else if (lo4Var instanceof cq4) {
            cq4 cq4Var = (cq4) lo4Var;
            this.c.setText(cq4Var.k());
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(cq4Var.k())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
        this.b.setOnClickListener(new a(this, lo4Var));
        this.b.setOnLongClickListener(new b(this, lo4Var));
        i(this.c, 0);
    }
}
