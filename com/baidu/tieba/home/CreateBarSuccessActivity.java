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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.switchs.CreateBarTipSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAR_NAME_STRING = "barname";
    public transient /* synthetic */ FieldHolder $fh;
    public String mBarName;
    public LinearLayout mContainer;
    public NavigationBar mNavigationBar;
    public TextView mTextView;
    public TextView mTextViewMore;

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
        this.mBarName = null;
        this.mTextView = null;
        this.mTextViewMore = null;
        this.mContainer = null;
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            String stringExtra = getIntent().getStringExtra("barname");
            this.mBarName = stringExtra;
            if (stringExtra == null) {
                this.mBarName = "";
            }
        }
    }

    private void initUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mContainer = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906c9);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09202b);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight() + layoutParams.height;
                relativeLayout.setLayoutParams(layoutParams);
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0450));
            this.mTextView = (TextView) findViewById(R.id.obfuscated_res_0x7f091f1b);
            this.mTextViewMore = (TextView) findViewById(R.id.obfuscated_res_0x7f091f40);
        }
    }

    public static void startActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        Intent intent = new Intent(context, CreateBarSuccessActivity.class);
        intent.putExtra("barname", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        StringBuilder sb;
        TbPageContext<CreateBarSuccessActivity> pageContext;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.mContainer);
            boolean isOn = new CreateBarTipSwitch().isOn();
            String string = getPageContext().getString(isOn ? R.string.obfuscated_res_0x7f0f0454 : R.string.obfuscated_res_0x7f0f0451);
            int length = string.length();
            if (isOn) {
                sb = new StringBuilder();
                sb.append(string);
                sb.append(this.mBarName);
                pageContext = getPageContext();
                i2 = R.string.obfuscated_res_0x7f0f0455;
            } else {
                sb = new StringBuilder();
                sb.append(string);
                sb.append(this.mBarName);
                pageContext = getPageContext();
                i2 = R.string.obfuscated_res_0x7f0f0452;
            }
            sb.append(pageContext.getString(i2));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10252)), length, this.mBarName.length() + length, 33);
            this.mTextView.setText(spannableString);
            this.mTextViewMore.setVisibility(isOn ? 0 : 8);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d020b);
            initData();
            initUi();
        }
    }
}
