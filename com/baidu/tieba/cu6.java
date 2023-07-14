package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public RelativeLayout c;
    public ImageView d;
    public MessageRedDotView e;
    @Nullable
    public MessageRedDotView f;
    public boolean g;
    public lf5 h;

    public cu6(Context context) {
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
        this.g = false;
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.b = inflate;
        this.c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.d = (ImageView) this.b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.img_red_tip);
        this.e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
        this.h = (lf5) ServiceManager.getService(lf5.a);
    }

    public void j(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, navigationBar) != null) || !TbSingleton.MsgUpgradeTips.shouldShow()) {
            return;
        }
        MessageRedDotView messageRedDotView = this.e;
        if (messageRedDotView != null) {
            messageRedDotView.setVisibility(8);
        }
        Context context = navigationBar.getContext();
        MessageRedDotView messageRedDotView2 = new MessageRedDotView(context);
        this.f = messageRedDotView2;
        messageRedDotView2.g(context.getString(R.string.message_notify_upgrade), false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds90);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds20);
        navigationBar.addView(this.f, layoutParams);
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GUIDE_SHOW);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }

    public MessageRedDotView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public ImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (ImageView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f == null) {
                this.h.d();
            }
            MessageRedDotView messageRedDotView = this.f;
            if (messageRedDotView != null) {
                messageRedDotView.setVisibility(8);
                TbSingleton.MsgUpgradeTips.markHasShown();
                this.f = null;
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GUIDE_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            if (this.g && this.e != null && !this.h.c()) {
                this.e.setVisibility(0);
            }
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.e.e();
            this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void h(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (view2 = this.b) != null) {
            view2.setVisibility(i);
        }
    }

    public void i(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        MessageRedDotView messageRedDotView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) && (messageRedDotView = this.f) != null) {
            messageRedDotView.setAlpha(f);
        }
    }

    public void f(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.e.f(i);
                this.g = true;
                if (this.h.c() && i <= 0) {
                    this.e.setVisibility(8);
                    return;
                } else if (this.f == null) {
                    this.e.setVisibility(0);
                    return;
                } else {
                    return;
                }
            }
            this.e.setVisibility(8);
            this.g = false;
        }
    }

    public void g(NavigationBar.ControlAlign controlAlign, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048582, this, controlAlign, z) == null) && !z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.d.getLayoutParams()).rightMargin = -yi.g(this.a, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.e.getLayoutParams()).rightMargin = -yi.g(this.a, R.dimen.tbds10);
            this.c.getLayoutParams().width = yi.g(this.a, R.dimen.obfuscated_res_0x7f070420);
        }
    }
}
