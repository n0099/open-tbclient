package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f95;
import com.repackage.oi;
/* loaded from: classes3.dex */
public class CreateForumSuccessActivity extends BaseActivity<CreateForumSuccessActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORUM_NAME_STRING = "forumname";
    public transient /* synthetic */ FieldHolder $fh;
    public NoDataView emptyView;
    public String mForumName;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public LinearLayout mRootView;
    public TextView mTextAuditTip;
    public TextView mTextView;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateForumSuccessActivity a;

        public a(CreateForumSuccessActivity createForumSuccessActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumSuccessActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createForumSuccessActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    public CreateForumSuccessActivity() {
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
        this.mForumName = null;
        this.mTextView = null;
        this.mTextAuditTip = null;
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            String stringExtra = getIntent().getStringExtra(FORUM_NAME_STRING);
            this.mForumName = stringExtra;
            if (stringExtra == null) {
                this.mForumName = "";
            }
        }
    }

    private void initUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mRootView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091add);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.obfuscated_res_0x7f0f0457);
            this.mNoNetView = (NoNetworkView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0923ad);
            int f = oi.f(getActivity(), R.dimen.obfuscated_res_0x7f07019a);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090891), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, f), null, null);
            this.emptyView = a2;
            a2.setVisibility(0);
            this.mTextView = (TextView) findViewById(R.id.obfuscated_res_0x7f091f3b);
            this.mTextView.setText(getActivity().getString(R.string.obfuscated_res_0x7f0f0c66) + this.mForumName + getActivity().getString(R.string.obfuscated_res_0x7f0f0c67));
            this.mTextAuditTip = (TextView) findViewById(R.id.obfuscated_res_0x7f091f12);
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0c62);
            if (!StringUtils.isNull(string) && this.mTextAuditTip != null) {
                this.mTextAuditTip.setText(string.replace("%s", this.mForumName));
            }
            findViewById(R.id.obfuscated_res_0x7f091f1f).setOnClickListener(new a(this));
        }
    }

    public static void startActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        Intent intent = new Intent(context, CreateForumSuccessActivity.class);
        intent.putExtra(FORUM_NAME_STRING, str);
        if (!(context instanceof Activity)) {
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.changeSkinType(i);
            super.changeSkinType(i);
            getLayoutMode().j(this.mRootView);
            f95.a(getPageContext(), this.mRootView);
            NoNetworkView noNetworkView = this.mNoNetView;
            if (noNetworkView != null && noNetworkView.getVisibility() == 0) {
                this.mNoNetView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.emptyView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d020e);
            initData();
            initUi();
        }
    }
}
