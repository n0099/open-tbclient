package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class f87 extends p9<OfficialBarTipActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public OfficialBarTipListAdapter b;
    public NavigationBar c;
    public NoDataView d;
    public NoNetworkView e;
    public OfficialBarTipActivity f;
    public ViewGroup g;
    public boolean h;
    public RelativeLayout i;
    public TextView j;
    public boolean k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        public a(f87 f87Var, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f87Var, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;
        public final /* synthetic */ f87 b;

        public b(f87 f87Var, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f87Var, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f87Var;
            this.a = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.b.h) {
                    if (this.b.f.P1()) {
                        this.b.n.setVisibility(0);
                    }
                    this.b.u(this.a, true);
                    return;
                }
                this.b.u(this.a, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;
        public final /* synthetic */ f87 b;

        public c(f87 f87Var, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f87Var, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f87Var;
            this.a = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N1();
                this.b.u(this.a, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f87 a;

        public d(f87 f87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f87Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.k) {
                    this.a.w(true);
                } else {
                    this.a.w(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;
        public final /* synthetic */ f87 b;

        public e(f87 f87Var, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f87Var, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f87Var;
            this.a = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.f.Z1();
                this.b.u(this.a, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f87(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {officialBarTipActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = null;
        this.k = false;
        officialBarTipActivity.setContentView(R.layout.obfuscated_res_0x7f0d0689);
        this.f = officialBarTipActivity;
        r(officialBarTipActivity);
        s(officialBarTipActivity);
        q(officialBarTipActivity);
    }

    public OfficialBarTipListAdapter o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (OfficialBarTipListAdapter) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f.getLayoutMode().l(i == 1);
            this.f.getLayoutMode().k(this.g);
            this.c.onChangeSkinType(this.f.getPageContext(), i);
            SkinManager.setNavbarTitleColor(this.o, R.color.navi_op_text, R.color.obfuscated_res_0x7f0608a0);
            SkinManager.setNavbarTitleColor(this.n, R.color.navi_op_text, R.color.obfuscated_res_0x7f0608a0);
            NoDataView noDataView = this.d;
            if (noDataView != null) {
                noDataView.f(this.f.getPageContext(), i);
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.d(this.f.getPageContext(), i);
            }
            this.b.notifyDataSetChanged();
        }
    }

    public BdListView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (BdListView) invokeV.objValue;
    }

    public final void q(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, officialBarTipActivity) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) officialBarTipActivity.findViewById(R.id.obfuscated_res_0x7f0921ff);
            this.i = relativeLayout;
            TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090793);
            this.l = textView;
            textView.setOnClickListener(new c(this, officialBarTipActivity));
            this.j = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091e36);
            int f = ej.f(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070225);
            Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
            drawable.setBounds(0, 0, f, f);
            this.j.setText(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f1102));
            this.j.setCompoundDrawables(drawable, null, null, null);
            this.j.setOnClickListener(new d(this));
        }
    }

    public final void r(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, officialBarTipActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.obfuscated_res_0x7f0925c2);
            this.c = navigationBar;
            navigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f123a));
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this, officialBarTipActivity));
            this.c.showBottomLine();
            ViewGroup viewGroup = (ViewGroup) officialBarTipActivity.findViewById(R.id.obfuscated_res_0x7f091c81);
            this.g = viewGroup;
            this.e = (NoNetworkView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0916dc);
            View inflate = LayoutInflater.from(this.f.getBaseContext()).inflate(R.layout.obfuscated_res_0x7f0d03bd, (ViewGroup) null);
            this.m = inflate;
            inflate.setVisibility(8);
            TextView textView = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09026d);
            this.n = textView;
            textView.setVisibility(8);
            TextView textView2 = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09086a);
            this.o = textView2;
            textView2.setVisibility(0);
            this.m = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.m, (View.OnClickListener) null);
            this.o.setOnClickListener(new b(this, officialBarTipActivity));
        }
    }

    public final void s(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, officialBarTipActivity) == null) {
            this.a = (BdListView) officialBarTipActivity.findViewById(R.id.obfuscated_res_0x7f091583);
            OfficialBarTipListAdapter officialBarTipListAdapter = new OfficialBarTipListAdapter(officialBarTipActivity);
            this.b = officialBarTipListAdapter;
            this.a.setAdapter((ListAdapter) officialBarTipListAdapter);
            this.d = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.g, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0cee), null);
        }
    }

    public void t(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b.r(list);
            if (list == null || list.size() > 0) {
                return;
            }
            this.o.setVisibility(8);
        }
    }

    public final void u(OfficialBarTipActivity officialBarTipActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, officialBarTipActivity, z) == null) {
            if (z) {
                this.i.setVisibility(0);
                this.b.s(true);
                this.b.notifyDataSetChanged();
                if (officialBarTipActivity.Q1()) {
                    v(true);
                } else {
                    v(false);
                }
                this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0375));
                this.n.setOnClickListener(new e(this, officialBarTipActivity));
                this.h = true;
                return;
            }
            this.i.setVisibility(8);
            this.n.setVisibility(8);
            this.b.s(false);
            this.b.notifyDataSetChanged();
            this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0534));
            this.h = false;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.l.setAlpha(1.0f);
                this.l.setEnabled(true);
                return;
            }
            this.l.setAlpha(0.3f);
            this.l.setEnabled(false);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            int f = ej.f(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070225);
            if (z) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_s);
                drawable.setBounds(0, 0, f, f);
                this.j.setText(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f037e));
                this.j.setCompoundDrawables(drawable, null, null, null);
                v(true);
                this.k = true;
                this.f.b2(true);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
            drawable2.setBounds(0, 0, f, f);
            this.j.setText(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f1102));
            this.j.setCompoundDrawables(drawable2, null, null, null);
            v(false);
            this.k = false;
            this.f.b2(false);
        }
    }
}
