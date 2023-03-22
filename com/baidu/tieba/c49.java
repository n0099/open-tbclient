package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ShakeAdSwitchData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.more.AdSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c49 extends y8<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdSettingActivity a;
    public View b;
    public NavigationBar c;
    public MsgSettingItemView d;
    public TextView e;
    public ImageView f;
    public ShakeAdSwitchData g;
    public MsgSettingItemView h;

    /* loaded from: classes3.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c49 c49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void g0(View view2, BdSwitchView.SwitchState switchState) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                m35 m = m35.m();
                if (BdSwitchView.SwitchState.ON == switchState) {
                    z = true;
                } else {
                    z = false;
                }
                m.w("key_splash_shake_ad_open", z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c49(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adSettingActivity;
        m();
    }

    public final void i() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.setText(R.string.obfuscated_res_0x7f0f0b79);
            this.d.setOnSwitchStateChangeListener(this.a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i2 = 0;
            if (currentAccountObj != null) {
                i2 = currentAccountObj.getMemberCloseAdIsOpen();
                i = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i = 0;
            }
            if (i2 == 0) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
            } else if (i == 0) {
                this.d.e();
            } else {
                this.d.g();
            }
        }
    }

    public final void l() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (msgSettingItemView = this.h) == null) {
            return;
        }
        ShakeAdSwitchData shakeAdSwitchData = this.g;
        if (shakeAdSwitchData != null && shakeAdSwitchData.isShow != 0) {
            msgSettingItemView.setVisibility(0);
            this.h.setTextStr(this.g.title);
            this.h.setTipTextStr(this.g.desc);
            if (m35.m().i("key_splash_shake_ad_open", true)) {
                this.h.g();
            } else {
                this.h.e();
            }
            this.h.setOnSwitchStateChangeListener(new a(this));
            return;
        }
        this.h.setVisibility(8);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0071);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f00ab));
            this.d = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f091659);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09165a);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0902c5);
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091920);
            this.h = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f092044);
            i();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.e();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.g();
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            fv4 layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
            this.c.onChangeSkinType(getPageContext(), i);
            this.d.c(this.a.getPageContext(), i);
            this.h.c(this.a.getPageContext(), i);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void p(ShakeAdSwitchData shakeAdSwitchData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, shakeAdSwitchData) == null) {
            this.g = shakeAdSwitchData;
            l();
        }
    }
}
