package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.myCollection.CollectTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class gp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView a;
    public final FragmentTabHost b;
    public int c;
    public Fragment d;
    public final NavigationBar e;
    public final NoNetworkView f;
    public CollectTabActivity g;
    public boolean h;
    public List i;
    public ViewPager.OnPageChangeListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        public a(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.j()) {
                    ej.N(this.a.g, "请先退出编辑状态");
                } else if (this.a.g != null) {
                    this.a.g.finish();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        public b(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.m(i);
                this.a.c(false);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public gp7(CollectTabActivity collectTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collectTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.h = false;
        this.j = new b(this);
        this.g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.obfuscated_res_0x7f092013);
        this.b = fragmentTabHost;
        fragmentTabHost.setup(this.g.getSupportFragmentManager());
        this.b.setOnPageChangeListener(this.j);
        this.e = (NavigationBar) this.g.findViewById(R.id.obfuscated_res_0x7f091657);
        this.f = (NoNetworkView) this.g.findViewById(R.id.obfuscated_res_0x7f0925c4);
        this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.e.setCenterTextTitle(this.g.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b68));
        TextView textView = (TextView) this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d062b, this.g).findViewById(R.id.obfuscated_res_0x7f091c41);
        this.a = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0534);
        this.a.setOnClickListener(this.g);
        this.e.onChangeSkinType(this.g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        k(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.d;
            if (fragment instanceof CollectFragment) {
                CollectFragment collectFragment = (CollectFragment) fragment;
                if (!collectFragment.r1()) {
                    z = false;
                }
                l(collectFragment.r1());
                i = collectFragment.getType();
            } else {
                i = -1;
            }
            this.h = z;
            this.a.setText(z ? R.string.obfuscated_res_0x7f0f0505 : R.string.obfuscated_res_0x7f0f0534);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i2 = R.color.navi_op_text;
            if (skinType == 2) {
                SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f0608a0);
            } else {
                TextView textView = this.a;
                if (this.h) {
                    i2 = R.color.CAM_X0302;
                }
                SkinManager.setNavbarTitleColor(textView, i2, R.color.obfuscated_res_0x7f0608a0);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_edit_state", this.h);
            bundle.putInt("fragment_type", i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public final void d(y85 y85Var, FragmentTabIndicator fragmentTabIndicator) {
        z85 b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y85Var, fragmentTabIndicator) == null) || (b2 = y85Var.b()) == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.c = b2.a;
        bVar.a = b2.e;
        fragmentTabIndicator.setText(b2.b);
        fragmentTabIndicator.setTextSize(0, this.g.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar.b = fragmentTabIndicator;
        bVar.d = y85Var;
        this.b.a(bVar);
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    public Fragment f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (Fragment) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.intValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.i) : invokeV.intValue;
    }

    public void i(ArrayList<y85> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.i = arrayList;
        this.b.q();
        for (int i = 0; i < arrayList.size(); i++) {
            y85 y85Var = arrayList.get(i);
            if (y85Var != null && y85Var.d()) {
                d(y85Var, (FragmentTabIndicator) y85Var.c(this.g.getPageContext().getPageActivity()));
            }
        }
        this.b.k(0);
        this.b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.b.getFragmentTabWidget().setVisibility(8);
        }
        m(0);
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b.p(i);
            if (this.b.getTabWrapper() != null) {
                if (h() <= 1) {
                    this.b.getTabWrapper().setVisibility(8);
                } else {
                    this.b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f0608a0);
            this.e.onChangeSkinType(this.g.getPageContext(), i);
            this.f.d(this.g.getPageContext(), i);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.setEnabled(z);
            if (z) {
                return;
            }
            this.a.setText(R.string.obfuscated_res_0x7f0f0534);
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f0608a0);
        }
    }

    public final void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            FragmentTabHost.b f = this.b.f(i);
            this.c = f.a;
            this.d = f.c;
        }
    }
}
