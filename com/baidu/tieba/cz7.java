package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.homepage.lowFlows.LowFlowsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class cz7 implements my7, View.OnClickListener, vz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LowFlowsActivity b;
    public ly7 c;
    public qy7 d;
    public String e;
    public String f;
    public String g;
    public int h;
    public View i;
    public ImageView j;
    public ImageView k;
    public NavigationBar l;
    public BdTypeRecyclerView m;
    public View n;
    public ImageView o;
    public TextView p;
    public CollapsingToolbarLayout q;
    public View r;
    public View s;
    public AppBarLayout t;
    public TextView u;
    public RelativeLayout v;
    public AppBarLayout.OnOffsetChangedListener w;

    @Override // com.baidu.tieba.vz4
    public void c(View view2, Object obj, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz7 a;

        public a(cz7 cz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz7Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                int totalScrollRange = appBarLayout.getTotalScrollRange() - this.a.j();
                if (totalScrollRange <= 0) {
                    return;
                }
                float abs = Math.abs(i * 1.0f) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (this.a.l != null && abs == 1.0f) {
                    if (this.a.l.getBarBgView() != null) {
                        this.a.l.getBarBgView().setAlpha(1.0f);
                    }
                    if (this.a.p != null) {
                        this.a.p.setAlpha(1.0f);
                    }
                    WebPManager.setPureDrawable(this.a.o, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                    return;
                }
                WebPManager.setPureDrawable(this.a.o, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (this.a.p != null) {
                    this.a.p.setAlpha(0.0f);
                }
                if (this.a.l.getBarBgView() != null) {
                    this.a.l.getBarBgView().setAlpha(0.0f);
                }
            }
        }
    }

    public cz7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = "";
        this.h = 3;
        this.w = new a(this);
        this.a = tbPageContext;
        this.b = (LowFlowsActivity) tbPageContext.getPageActivity();
        this.c = new yy7(this);
        n();
        l();
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Drawable[] a2 = az7.a(str);
            if (a2 != null) {
                this.j.setImageDrawable(a2[0]);
                this.k.setImageDrawable(a2[1]);
            }
            p(az7.b(str));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view2) == null) && this.a != null && view2.getId() == R.id.navigationBarGoBack && this.a.getPageActivity() != null) {
            this.a.getPageActivity().finish();
        }
    }

    @Override // com.baidu.tieba.my7
    public void a() {
        LowFlowsActivity lowFlowsActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View view2 = this.s;
            if (view2 != null && view2.getParent() != null && (lowFlowsActivity = this.b) != null) {
                lowFlowsActivity.hideNetRefreshView(this.s);
                this.s.setVisibility(8);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.m;
            if (bdTypeRecyclerView != null && bdTypeRecyclerView.getParent() != null) {
                this.m.setVisibility(8);
            }
            View view3 = this.r;
            if (view3 != null && this.b != null) {
                view3.setVisibility(0);
                this.b.showLoadingView(this.r);
            }
            ImageView imageView = this.k;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.k.setVisibility(8);
            }
            ly7 ly7Var = this.c;
            if (ly7Var != null) {
                ly7Var.a(i(), this.e, this.f, this.g);
            }
        }
    }

    public final void m() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (tbPageContext = this.a) != null) {
            int g = vi.g(tbPageContext.getPageActivity(), R.dimen.M_H_X008);
            this.v = new RelativeLayout(this.a.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.v.setPadding(0, g, 0, g);
            this.v.setLayoutParams(layoutParams);
            this.u = new TextView(this.a.getPageActivity());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.u.setLayoutParams(layoutParams2);
            this.u.setText(R.string.obfuscated_res_0x7f0f0b6c);
            this.u.setBackgroundColor(0);
            this.v.addView(this.u);
        }
    }

    @Override // com.baidu.tieba.my7
    public void b(int i) {
        View view2;
        LowFlowsActivity lowFlowsActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            View view3 = this.r;
            if (view3 != null && view3.getParent() != null && (lowFlowsActivity = this.b) != null) {
                lowFlowsActivity.hideLoadingView(this.r);
                this.r.setVisibility(8);
            }
            if (this.b != null && (view2 = this.s) != null) {
                view2.setVisibility(0);
                this.b.showNetRefreshView(this.s, "");
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            View addSystemImageButton = this.l.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.n = addSystemImageButton;
            this.o = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.p = this.l.getCenterText();
            this.l.setCenterTextTitle(str);
        }
    }

    @Override // com.baidu.tieba.vz4
    public void d(View view2, Object obj, int i, long j) {
        String lFUserTaskId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (StringUtils.isNull(this.g)) {
                lFUserTaskId = "0";
            } else {
                lFUserTaskId = TbSingleton.getInstance().getLFUserTaskId();
            }
            zy7.a("c14084", lFUserTaskId, this.e);
        }
    }

    public final BdUniqueId i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            NavigationBar navigationBar = this.l;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public View k() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.i == null && (tbPageContext = this.a) != null) {
                this.i = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0047, (ViewGroup) null);
            }
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public final void l() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (tbPageContext = this.a) != null && tbPageContext.getPageActivity() != null) {
            this.a.getPageActivity().setContentView(k());
            this.j = (ImageView) k().findViewById(R.id.obfuscated_res_0x7f090eed);
            this.k = (ImageView) k().findViewById(R.id.obfuscated_res_0x7f090ef3);
            this.l = (NavigationBar) k().findViewById(R.id.obfuscated_res_0x7f0914c6);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) k().findViewById(R.id.obfuscated_res_0x7f09175d);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.m.setFadingEdgeLength(0);
            o(this.e);
            AppBarLayout appBarLayout = (AppBarLayout) k().findViewById(R.id.obfuscated_res_0x7f0914c3);
            this.t = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.w);
            this.q = (CollapsingToolbarLayout) k().findViewById(R.id.obfuscated_res_0x7f0914c4);
            this.r = k().findViewById(R.id.obfuscated_res_0x7f09187a);
            this.s = k().findViewById(R.id.obfuscated_res_0x7f091880);
            m();
            qy7 qy7Var = new qy7(this.a, this.m);
            this.d = qy7Var;
            qy7Var.e(i());
            this.d.d(this);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n() {
        TbPageContext tbPageContext;
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tbPageContext = this.a) != null && tbPageContext.getPageActivity() != null && (intent = this.a.getPageActivity().getIntent()) != null) {
            this.e = intent.getStringExtra("tab_code");
            this.f = intent.getStringExtra(LowFlowsActivityConfig.LF_USER);
            this.g = intent.getStringExtra(LowFlowsActivityConfig.LF_USER_TASKID);
        }
    }

    @Override // com.baidu.tieba.my7
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (this.h != i) {
                o75 d = o75.d(this.p);
                d.C(R.string.F_X02);
                d.B(R.dimen.T_X05);
                d.w(R.color.CAM_X0105);
                this.l.getBarBgView().setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
                Drawable[] a2 = az7.a(this.e);
                if (a2 != null) {
                    this.j.setImageDrawable(a2[0]);
                    this.k.setImageDrawable(a2[1]);
                }
                this.v.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
                o75 d2 = o75.d(this.u);
                d2.B(R.dimen.T_X08);
                d2.w(R.color.CAM_X0109);
                qy7 qy7Var = this.d;
                if (qy7Var != null) {
                    qy7Var.b();
                }
            }
            this.h = i;
        }
    }

    @Override // com.baidu.tieba.my7
    public void setData(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            View view2 = this.r;
            if (view2 != null && this.b != null && view2.getParent() != null) {
                this.b.hideLoadingView(this.r);
                this.r.setVisibility(8);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.m;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(0);
            }
            ImageView imageView = this.k;
            if (imageView != null && imageView.getVisibility() == 8) {
                this.k.setVisibility(0);
            }
            for (vn vnVar : list) {
                if (vnVar instanceof n45) {
                    ((n45) vnVar).getThreadData().mTabCode = this.e;
                }
            }
            qy7 qy7Var = this.d;
            if (qy7Var != null) {
                qy7Var.c(list);
            }
            this.m.setFooterView(this.v);
        }
    }
}
