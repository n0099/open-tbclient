package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public View b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public b g;
    public RelativeLayout h;
    public View.OnClickListener i;

    /* loaded from: classes5.dex */
    public interface b {
        void onClose();
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq8 a;

        public a(cq8 cq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.e.getId()) {
                    DialogUtil.jumpSystemNotificationSetting(this.a.a);
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
                } else if (view2.getId() == this.a.f.getId()) {
                    SharedPrefHelper.getInstance().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                    if (this.a.g != null) {
                        this.a.g.onClose();
                    }
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 2));
                }
            }
        }
    }

    public cq8(BdPageContext bdPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.a = bdPageContext;
        View inflate = LayoutInflater.from(bdPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d075d, (ViewGroup) null);
        this.b = inflate;
        this.h = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091a2c);
        this.c = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0910f4);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a29);
        TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0904e0);
        this.e = textView;
        textView.setOnClickListener(this.i);
        ImageView imageView = (ImageView) this.b.findViewById(R.id.img_close);
        this.f = imageView;
        imageView.setOnClickListener(this.i);
        TiebaStatic.log("c13704");
        g(TbadkCoreApplication.getInst().getSkinType(), z);
        if (!z) {
            e();
        }
    }

    public void g(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                TBSelector.makeDrawableSelector().setShape(0).tlRadius(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds36)).blRadius(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds36)).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.open_notify_start_color, R.color.open_notify_start_color, R.color.open_notify_end_color).into(this.h);
            } else {
                SkinManager.setBackgroundResource(this.b, R.color.CAM_X0204);
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0110, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            EMManager.from(this.d).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0107).setTextStyle(R.string.F_X01);
            EMManager.from(this.e).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0341);
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.M_H_X001);
            layoutParams.rightMargin = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.M_H_X004);
            this.h.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.M_W_X007);
            this.f.setLeft(dimens);
            this.f.setRight(dimens);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }
}
