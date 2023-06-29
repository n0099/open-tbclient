package com.baidu.tbadk.suspended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.st5;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SusPendedView a;
    public TranView b;
    public NavigationBar c;
    public NoNetworkView d;
    public TextView e;
    public LinearLayout f;
    public LinearLayout g;
    public st5 h;
    public boolean i;
    public NoNetworkView.b j;

    public abstract void D1();

    public abstract st5 u1(LinearLayout linearLayout, NavigationBar navigationBar);

    public View.OnClickListener w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SuspendedActivity a;

        public a(SuspendedActivity suspendedActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suspendedActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = suspendedActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void i(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.D1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SuspendedActivity a;

        public b(SuspendedActivity suspendedActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suspendedActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = suspendedActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t1();
            }
        }
    }

    public SuspendedActivity() {
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
        this.j = new a(this);
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.view_no_network);
            this.d = noNetworkView;
            noNetworkView.a(this.j);
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TranView tranView = new TranView(getPageContext().getPageActivity());
            this.b = tranView;
            tranView.setVisibility(0);
            this.b.setOnClickListener(w1());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            SusPendedView susPendedView = this.a;
            if (susPendedView != null) {
                susPendedView.g();
            }
        }
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            st5 st5Var = this.h;
            if (st5Var != null && !st5Var.Q0()) {
                return;
            }
            if (this.b != null) {
                this.a.h();
            } else {
                finish();
            }
        }
    }

    public int v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        }
        return invokeV.intValue;
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content_view);
            this.g = linearLayout;
            st5 u1 = u1(linearLayout, this.c);
            this.h = u1;
            if (u1 != null) {
                this.a.setContentViewTop(u1);
            }
        }
    }

    public void E1(boolean z) {
        SusPendedView susPendedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (susPendedView = this.a) != null) {
            susPendedView.setCanDragClose(z);
        }
    }

    public void F1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.i = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.activity_suspended);
            x1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.i) {
                super.finish();
                return;
            }
            st5 st5Var = this.h;
            if (st5Var != null) {
                Intent resultIntent = st5Var.getResultIntent();
                if (resultIntent != null) {
                    setResult(-1, resultIntent);
                }
                if (this.b != null && !this.a.getIsFinish()) {
                    this.a.h();
                    return;
                } else {
                    super.finish();
                    return;
                }
            }
            super.finish();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a = (SusPendedView) findViewById(R.id.obfuscated_res_0x7f091f38);
            C1();
            z1();
            A1();
            y1();
            this.a.setNavigationBar(this.f);
            this.a.setTranView(this.b);
            this.a.setContentView(this.g);
            this.a.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.c.onChangeSkinType(getPageContext(), i);
            this.d.d(getPageContext(), i);
            this.a.e(i);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            st5 st5Var = this.h;
            if (st5Var != null) {
                st5Var.q(i);
            }
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.mCenterText.setTextSize(0, xi.g(getPageContext().getPageActivity(), R.dimen.tbds44));
            TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.obfuscated_res_0x7f0f0588), new b(this));
            this.e = addTextButton;
            addTextButton.setTextSize(0, xi.g(getPageContext().getPageActivity(), R.dimen.tbds44));
            this.c.setIsCorner(true);
            this.c.setStatusBarVisibility(8);
            this.c.hideBottomLine();
            this.f = (LinearLayout) findViewById(R.id.navigation_bar_group);
            this.f.addView(this.b, 0, new LinearLayout.LayoutParams(-1, v1()));
        }
    }
}
