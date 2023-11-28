package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.switchs.CreateBarTipSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public TextView b;
    public TextView c;
    public LinearLayout d;
    public NavigationBar e;

    public CreateBarSuccessActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String stringExtra = getIntent().getStringExtra("barname");
            this.a = stringExtra;
            if (stringExtra == null) {
                this.a = "";
            }
        }
    }

    public static void I0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) && str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra("barname", str);
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0907f7);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092683);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight() + layoutParams.height;
                relativeLayout.setLayoutParams(layoutParams);
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.e.setTitleText(getPageContext().getString(R.string.create_bar));
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09257a);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0925a1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        boolean z;
        int i2;
        StringBuilder sb;
        TbPageContext<CreateBarSuccessActivity> pageContext;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            BDLayoutMode layoutMode = getLayoutMode();
            int i4 = 0;
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(this.d);
            boolean isOn = new CreateBarTipSwitch().isOn();
            TbPageContext<CreateBarSuccessActivity> pageContext2 = getPageContext();
            if (isOn) {
                i2 = R.string.obfuscated_res_0x7f0f0515;
            } else {
                i2 = R.string.obfuscated_res_0x7f0f0512;
            }
            String string = pageContext2.getString(i2);
            int length = string.length();
            if (isOn) {
                sb = new StringBuilder();
                sb.append(string);
                sb.append(this.a);
                pageContext = getPageContext();
                i3 = R.string.obfuscated_res_0x7f0f0516;
            } else {
                sb = new StringBuilder();
                sb.append(string);
                sb.append(this.a);
                pageContext = getPageContext();
                i3 = R.string.obfuscated_res_0x7f0f0513;
            }
            sb.append(pageContext.getString(i3));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10252)), length, this.a.length() + length, 33);
            this.b.setText(spannableString);
            TextView textView = this.c;
            if (!isOn) {
                i4 = 8;
            }
            textView.setVisibility(i4);
            this.e.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0245);
            initData();
            H0();
        }
    }
}
