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
import com.baidu.tieba.qf5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CreateForumSuccessActivity extends BaseActivity<CreateForumSuccessActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public LinearLayout b;
    public NavigationBar c;
    public NoNetworkView d;
    public NoDataView e;
    public TextView f;
    public TextView g;

    /* loaded from: classes4.dex */
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
        this.a = null;
        this.f = null;
        this.g = null;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String stringExtra = getIntent().getStringExtra("forumname");
            this.a = stringExtra;
            if (stringExtra == null) {
                this.a = "";
            }
        }
    }

    public static void startActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) && str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateForumSuccessActivity.class);
            intent.putExtra("forumname", str);
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.changeSkinType(i);
            super.changeSkinType(i);
            getLayoutMode().k(this.b);
            qf5.a(getPageContext(), this.b);
            NoNetworkView noNetworkView = this.d;
            if (noNetworkView != null && noNetworkView.getVisibility() == 0) {
                this.d.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.e;
            if (noDataView != null) {
                noDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0205);
            initData();
            x1();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cd4);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092613);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(R.string.obfuscated_res_0x7f0f0478);
            this.d = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f092615);
            int g = yi.g(getActivity(), R.dimen.obfuscated_res_0x7f07019a);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0908c8), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, g), null, null);
            this.e = a2;
            a2.setVisibility(0);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f092194);
            this.f.setText(getActivity().getString(R.string.obfuscated_res_0x7f0f0cd5) + this.a + getActivity().getString(R.string.obfuscated_res_0x7f0f0cd6));
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09216a);
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0cd1);
            if (!StringUtils.isNull(string) && this.g != null) {
                this.g.setText(string.replace("%s", this.a));
            }
            findViewById(R.id.obfuscated_res_0x7f092177).setOnClickListener(new a(this));
        }
    }
}
