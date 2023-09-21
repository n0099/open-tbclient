package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fba extends BdBaseView<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext<?> a;
    public View b;
    public NavigationBar c;
    public TextView d;
    public TextView e;
    public BdSwitchView f;
    public TextView g;
    public TextView h;
    public BdSwitchView i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fba a;

        public a(fba fbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fbaVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void z(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                int i = 3;
                boolean z = false;
                int i2 = 1;
                if (view2 == this.a.f) {
                    fba fbaVar = this.a;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        z = true;
                    }
                    fbaVar.k = z;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        i = 1;
                    }
                    this.a.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, i));
                } else if (view2 == this.a.i) {
                    fba fbaVar2 = this.a;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        z = true;
                    }
                    fbaVar2.j = z;
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        i = 1;
                    }
                    this.a.a.sendMessage(new PrivacySettingMessage("bazhu_show_outside", i));
                }
                StatisticItem param = new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount());
                if (view2 != this.a.f) {
                    i2 = 2;
                }
                TiebaStatic.log(param.param("obj_type", i2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fba(BdPageContext<PrivacyMarkActivity> bdPageContext, int i) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = bdPageContext;
        x(bdPageContext.getPageActivity(), i);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
            this.c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f.m();
            } else {
                this.f.j();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.j;
            this.j = z;
            if (z) {
                this.i.m();
            } else {
                this.i.j();
            }
        }
    }

    public final void x(Context context, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0831, (ViewGroup) null);
            this.b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.obfuscated_res_0x7f0f1159));
            this.c.showBottomLine();
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091142);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09113f);
            this.f = (BdSwitchView) this.b.findViewById(R.id.obfuscated_res_0x7f091140);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a43);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a40);
            this.i = (BdSwitchView) this.b.findViewById(R.id.obfuscated_res_0x7f091a41);
            this.d.setText(R.string.obfuscated_res_0x7f0f0c65);
            this.e.setText(R.string.obfuscated_res_0x7f0f0c64);
            this.g.setText(R.string.obfuscated_res_0x7f0f0c66);
            this.h.setText(R.string.obfuscated_res_0x7f0f0c67);
            int i2 = i & 3;
            int i3 = (i >> 2) & 3;
            if (i2 == 3) {
                this.i.j();
            } else {
                this.i.m();
            }
            if (i3 == 3) {
                this.f.j();
            } else {
                this.f.m();
            }
            boolean z2 = true;
            if (i2 != 3) {
                z = true;
            } else {
                z = false;
            }
            this.j = z;
            if (i3 == 3) {
                z2 = false;
            }
            this.k = z2;
            this.f.setOnSwitchStateChangeListener(this.l);
            this.i.setOnSwitchStateChangeListener(this.l);
        }
    }
}
