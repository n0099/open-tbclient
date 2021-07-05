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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.mContainer = (LinearLayout) findViewById(R.id.container);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.title);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight() + layoutParams.height;
                relativeLayout.setLayoutParams(layoutParams);
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
            this.mTextView = (TextView) findViewById(R.id.text);
            this.mTextViewMore = (TextView) findViewById(R.id.text_more);
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        StringBuilder sb;
        TbPageContext<CreateBarSuccessActivity> pageContext;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mContainer);
            boolean isOn = new CreateBarTipSwitch().isOn();
            String string = getPageContext().getString(isOn ? R.string.create_bar_new_tip : R.string.create_bar_info1);
            int length = string.length();
            if (isOn) {
                sb = new StringBuilder();
                sb.append(string);
                sb.append(this.mBarName);
                pageContext = getPageContext();
                i3 = R.string.create_bar_new_tip2;
            } else {
                sb = new StringBuilder();
                sb.append(string);
                sb.append(this.mBarName);
                pageContext = getPageContext();
                i3 = R.string.create_bar_info2;
            }
            sb.append(pageContext.getString(i3));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10252)), length, this.mBarName.length() + length, 33);
            this.mTextView.setText(spannableString);
            this.mTextViewMore.setVisibility(isOn ? 0 : 8);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.create_bar_success_activity);
            initData();
            initUi();
        }
    }
}
