package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.cra;
import com.baidu.tieba.ei;
import com.baidu.tieba.i78;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HomePageRecentForumItemLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public TextView c;
    public View d;
    public BarImageView e;
    public TbImage f;
    public i78 g;
    public ImageView h;

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageRecentForumItemLayout(Context context) {
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
        this.b = 3;
        a(context);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.b != i && this.g != null) {
            WebPManager.setMaskDrawable(this.h, R.drawable.icon_mask_forum_head_shadow, null);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0105);
            d();
            this.b = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageRecentForumItemLayout(Context context, AttributeSet attributeSet) {
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
        this.b = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageRecentForumItemLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.b = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0877, (ViewGroup) this, true);
            this.c = (TextView) findViewById(R.id.forum_name);
            this.d = findViewById(R.id.obfuscated_res_0x7f09045a);
            this.e = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090be9);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090bea);
            this.f = (TbImage) findViewById(R.id.obfuscated_res_0x7f092252);
            b();
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setShowOval(true);
            this.e.setShowOuterBorder(false);
            this.e.setStrokeWith(UtilHelper.getDimenPixelSize(R.dimen.tbds3));
        }
    }

    public final void d() {
        int i;
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i78 i78Var = this.g;
            int i2 = Integer.MAX_VALUE;
            if (i78Var != null && i78Var.g() != null) {
                i2 = zfa.f(cra.d(this.g.g()));
                i = zfa.f(cra.f(this.g.g()));
            } else {
                i = Integer.MAX_VALUE;
            }
            if (zfa.e(i2) || zfa.e(i)) {
                if (TbadkApplication.getInst().getSkinType() == 4) {
                    f = zfa.f("#4D4070FF");
                } else {
                    f = zfa.f("#324070FF");
                }
                i2 = f;
                i = zfa.f("#004070FF");
            }
            EMManager.from(this.d).setCorner(R.string.J_X05).setGradientColorValue(new int[]{i2, i}, Direction.TOP);
        }
    }

    public final void f(String str, int i, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i), str2, str3, Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", str2);
            statisticItem.param("obj_type", str3);
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_source", z ? 1 : 0);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            i78 i78Var = this.g;
            if (i78Var != null) {
                f("c15375", i78Var.e(), this.g.b(), this.g.d(), this.g.h());
            }
        }
    }

    public void setData(i78 i78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, i78Var) == null) {
            if (i78Var == null) {
                ViewCommonUtil.setVisibility(this, 8);
                return;
            }
            this.g = i78Var;
            String c = i78Var.c();
            String string = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f077f);
            if (!ei.isEmpty(c) && !c.endsWith(string)) {
                c = c + string;
            }
            this.c.setText(c);
            this.e.startLoad(this.g.a(), 10, false);
            if (!ei.isEmpty(i78Var.d())) {
                ViewCommonUtil.setVisibility(this.f, 0);
                this.f.l(i78Var.d());
            } else {
                ViewCommonUtil.setVisibility(this.f, 8);
            }
            d();
            e(TbadkApplication.getInst().getSkinType());
        }
    }
}
