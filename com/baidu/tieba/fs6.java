package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public RelativeLayout b;
    public LinearGradientView c;
    public BarImageView d;
    public TextView e;
    public FrsHeaderBannerView f;
    public LinearLayout g;
    public ImageView h;
    public View i;
    public TbImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(fs6 fs6Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs6Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.a;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    public fs6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        UtilHelper.getStatusBarHeight();
        UtilHelper.getDimenPixelSize(R.dimen.tbds50);
        UtilHelper.getStatusBarHeight();
        UtilHelper.getDimenPixelSize(R.dimen.tbds51);
        UtilHelper.getStatusBarHeight();
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0304, (ViewGroup) null);
        this.a = inflate;
        this.b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090d39);
        this.c = (LinearGradientView) this.a.findViewById(R.id.obfuscated_res_0x7f090d3c);
        TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d3a);
        this.j = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.j.setDefaultResource(R.drawable.obfuscated_res_0x7f080f35);
        this.d = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090b61);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a8e);
        this.e = textView;
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
        this.f = (FrsHeaderBannerView) this.a.findViewById(R.id.obfuscated_res_0x7f090b50);
        this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09098b);
        this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09098a);
        this.i = this.a.findViewById(R.id.obfuscated_res_0x7f090d52);
        this.k = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09098d);
        this.l = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09098f);
        this.m = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09098c);
        this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09098e);
        this.k.setOnClickListener(new a(this, context));
        this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setContentDescription(context.getResources().getString(R.string.obfuscated_res_0x7f0f02e6));
        this.d.setStrokeWith(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.d.setShowOval(true);
        this.d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        uu4 d = uu4.d(this.i);
        d.m(1);
        d.n(R.string.J_X14);
        d.f(R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080628);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f08062a, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a18, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.obfuscated_res_0x7f080629, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.obfuscated_res_0x7f0802dc, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
