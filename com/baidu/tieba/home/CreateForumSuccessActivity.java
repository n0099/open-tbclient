package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CreateForumSuccessActivity f45560e;

        public a(CreateForumSuccessActivity createForumSuccessActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumSuccessActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45560e = createForumSuccessActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45560e.finish();
            }
        }
    }

    public CreateForumSuccessActivity() {
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
            this.mRootView = (LinearLayout) findViewById(R.id.root_view);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.create_bar);
            this.mNoNetView = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            int f2 = m.f(getActivity(), R.dimen.ds100);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.mRootView.findViewById(R.id.emotion_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, f2), null, null);
            this.emptyView = a2;
            a2.setVisibility(0);
            this.mTextView = (TextView) findViewById(R.id.text_suc_tip);
            this.mTextView.setText(getActivity().getString(R.string.noforum_create_suc_tip1) + this.mForumName + getActivity().getString(R.string.noforum_create_suc_tip2));
            this.mTextAuditTip = (TextView) findViewById(R.id.text_audit_tip);
            String string = getResources().getString(R.string.noforum_create_audit_tip);
            if (!StringUtils.isNull(string) && this.mTextAuditTip != null) {
                this.mTextAuditTip.setText(string.replace(FormattableUtils.SIMPLEST_FORMAT, this.mForumName));
            }
            findViewById(R.id.text_create_succ).setOnClickListener(new a(this));
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
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.changeSkinType(i2);
            super.changeSkinType(i2);
            getLayoutMode().j(this.mRootView);
            c.a.r0.w0.a.a(getPageContext(), this.mRootView);
            NoNetworkView noNetworkView = this.mNoNetView;
            if (noNetworkView != null && noNetworkView.getVisibility() == 0) {
                this.mNoNetView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.emptyView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.create_forum_success_activity);
            initData();
            initUi();
        }
    }
}
