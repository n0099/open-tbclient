package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class hj8 extends p9<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SystemHelpSettingActivity a;
    public View b;
    public TbSettingTextTipView c;
    public TbSettingTextTipView d;
    public BdSwitchView e;
    public BdSwitchView f;
    public TbSettingTextNewDotView g;
    public MsgSettingItemView h;
    public TbSettingTextTipView i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public NavigationBar p;
    public BdSwitchView.b q;

    /* loaded from: classes4.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hj8 a;

        public a(hj8 hj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hj8Var;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void h0(View view2, BdSwitchView.SwitchState switchState) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) && view2 == this.a.h.getSwitchView()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    z = true;
                } else {
                    z = false;
                }
                qy4 k = qy4.k();
                k.u("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.a.a.z1("recnbar", z ^ true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hj8(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {systemHelpSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = null;
        this.q = new a(this);
        this.a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d085b);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f092613);
        this.p = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f139b));
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09065b);
        this.c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.c.setOnClickListener(this.a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09065c);
        this.d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.d.setOnClickListener(this.a);
        this.e = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f091007);
        yi.b(this.a.getPageContext().getPageActivity(), this.e, 10, 10, 10, 10);
        this.e.setOnSwitchStateChangeListener(this.a);
        this.f = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f091ec1);
        yi.b(this.a.getPageContext().getPageActivity(), this.f, 10, 10, 10, 10);
        this.f.setOnSwitchStateChangeListener(this.a);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09078c);
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09205a);
        this.k = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09205c);
        this.l = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09205b);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090feb);
        this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090fec);
        this.n = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092059);
        if (uq4.h()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.i.c();
        this.i.setOnClickListener(this.a);
        this.b = this.a.findViewById(R.id.obfuscated_res_0x7f0917cc);
        if (TbadkCoreApplication.isLogin()) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.obfuscated_res_0x7f092016);
        this.g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.a);
        this.g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f091bc4);
        this.h = msgSettingItemView;
        msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f0f46);
        this.h.setOnSwitchStateChangeListener(this.q);
        qy4 k = qy4.k();
        r(k.h("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                this.h.getSwitchView().m();
            } else {
                this.h.getSwitchView().j();
            }
        }
    }

    public TbSettingTextTipView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            sq4 layoutMode = this.a.getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
            this.p.onChangeSkinType(getPageContext(), i);
            this.e.b();
            this.f.b();
            this.h.c(this.a.getPageContext(), i);
            SkinManager.setBackgroundResource(this.c, R.drawable.more_all);
            qw4.d(this.j).v(R.color.CAM_X0205);
            qw4.d(this.k).v(R.color.CAM_X0205);
            qw4.d(this.l).v(R.color.CAM_X0105);
            qw4.d(this.m).v(R.color.CAM_X0109);
            qw4.d(this.n).v(R.color.CAM_X0108);
            qw4.d(this.o).v(R.color.CAM_X0105);
        }
    }
}
