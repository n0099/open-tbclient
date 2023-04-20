package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ji7;
import com.baidu.tieba.ki7;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsLikeShareDialogView extends ConstraintLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public ConstraintLayout b;
    public TbImageView c;
    public HeadImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public View j;
    public LinearLayout k;
    public ImageView l;
    public LinearLayout m;
    public ImageView n;
    public LinearLayout o;
    public ImageView p;
    public LinearLayout q;
    public ImageView r;
    public ImageView s;
    public View t;
    public ji7 u;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsLikeShareDialogView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void e(int i) {
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int i2 = 3;
            if (i == 3) {
                i2 = 4;
            } else if (i != 2) {
                if (i == 8) {
                    i2 = 9;
                } else if (i == -1) {
                    i2 = 17;
                } else {
                    i2 = -1;
                }
            }
            if (i2 != -1 && (forumData = this.a) != null) {
                ki7.a(forumData.getId(), i2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        ji7 ji7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2 == this.q) {
                ji7 ji7Var2 = this.u;
                if (ji7Var2 != null) {
                    ji7Var2.a();
                }
                e(-1);
                return;
            }
            if (view2 == this.k) {
                i = 3;
            } else if (view2 == this.m) {
                i = 2;
            } else if (view2 == this.o) {
                i = 8;
            } else {
                i = -1;
            }
            if (i != -1 && (ji7Var = this.u) != null) {
                ji7Var.b(i);
            }
            e(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsLikeShareDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLikeShareDialogView(Context context, AttributeSet attributeSet, int i) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0353, this);
            this.b = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f090c90);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ca1);
            this.d = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090c8e);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090ca2);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090c96);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090c9c);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090c98);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c9f);
            this.j = findViewById(R.id.obfuscated_res_0x7f090c8f);
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090ca3);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ca4);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c91);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c92);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c9d);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c9e);
            this.q = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c94);
            this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c95);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c93);
            this.t = findViewById(R.id.obfuscated_res_0x7f090c9b);
            d();
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r25 d = r25.d(this.j);
            d.o(R.string.J_X17);
            d.h(SkinManager.getColor(0, (int) R.color.CAM_X0204));
            this.l.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.icon_mask_share_wechat40_svg, SvgManager.SvgResourceStateType.NORMAL));
            this.n.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.icon_mask_share_circle40_svg, SvgManager.SvgResourceStateType.NORMAL));
            this.p.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.icon_mask_share_qq40_svg, SvgManager.SvgResourceStateType.NORMAL));
            this.r.setImageDrawable(SvgManager.getInstance().getNormalDrawable(R.drawable.icon_mask_frs_private_share_download40_svg, SvgManager.SvgResourceStateType.NORMAL));
            this.k.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.setAutoChangeStyle(false);
            this.d.setUseNightOrDarkMask(false);
            this.c.setAutoChangeStyle(false);
            this.c.setUseNightOrDarkMask(false);
            this.c.setRadiusById(R.string.J_X14);
            this.c.setConrers(3);
            this.c.setIsBitmapPic(true);
            SkinManager.setImageResource(this.c, R.drawable.obfuscated_res_0x7f080c57, 0);
            r25 d = r25.d(this.t);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0501);
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.s.setOnClickListener(onClickListener);
        }
    }
}
