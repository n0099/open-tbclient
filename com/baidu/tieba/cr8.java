package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.pbextra.praise.PraiseListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class cr8 extends y8<PraiseListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ar8 a;
    public PraiseListActivity b;
    public View c;
    public NavigationBar d;
    public View e;
    public NoDataView f;
    public View g;
    public TextView h;
    public BdListView i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr8(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {praiseListActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.obfuscated_res_0x7f0d09b9);
        this.c = praiseListActivity.findViewById(R.id.obfuscated_res_0x7f092916);
        this.d = (NavigationBar) praiseListActivity.findViewById(R.id.obfuscated_res_0x7f092915);
        this.e = praiseListActivity.findViewById(R.id.obfuscated_res_0x7f092913);
        this.f = NoDataViewFactory.a(this.b.getPageContext().getContext(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, hi.g(this.b.getActivity(), R.dimen.obfuscated_res_0x7f07029f)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.i = (BdListView) praiseListActivity.findViewById(R.id.obfuscated_res_0x7f092914);
        TextView textView = new TextView(this.b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.i.w(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.obfuscated_res_0x7f092917);
        ar8 ar8Var = new ar8(praiseListActivity);
        this.a = ar8Var;
        this.i.setAdapter((ListAdapter) ar8Var);
        this.i.setOnScrollListener(this.a);
        this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d09bb, (ViewGroup) null);
        this.g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09290e);
        this.h = textView2;
        textView2.setText(str);
        this.g.setVisibility(8);
        this.i.addHeaderView(this.g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d09ba, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f09290c);
        this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f09290d);
        this.n = (ProgressBar) this.j.findViewById(R.id.obfuscated_res_0x7f09290b);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.i.addFooterView(this.j);
        this.i.setOnItemClickListener(praiseListActivity);
    }

    public void i(fv4 fv4Var, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, fv4Var, i) != null) || fv4Var == null) {
            return;
        }
        if (i == 4) {
            z = true;
        } else {
            z = false;
        }
        fv4Var.l(z);
        fv4Var.k(this.c);
        fv4Var.k(this.g);
        fv4Var.k(this.j);
        this.d.onChangeSkinType(this.b.getPageContext(), i);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f;
        if (noDataView != null) {
            noDataView.f(this.b.getPageContext(), i);
        }
    }

    public void p(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            if (!StringUtils.isNull(str)) {
                this.f.setTextOption(NoDataViewFactory.e.c(str));
            } else if (1 == i) {
                this.f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
            } else {
                this.f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
            }
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k;
        }
        return (View) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.m.getVisibility() != 0 && this.n.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        ar8 ar8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ar8Var = this.a) != null) {
            ar8Var.notifyDataSetChanged();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
            } else {
                this.m.setVisibility(0);
            }
        }
    }

    public void s(int i, List<yq8> list, int i2, int i3) {
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), list, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.g.setVisibility(0);
            if (i > 0) {
                PraiseListActivity praiseListActivity = this.b;
                if (praiseListActivity.a != 1) {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0fd3), StringHelper.numFormatOverWan(i));
                } else {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.obfuscated_res_0x7f0f085e), StringHelper.numFormatOverWan(i));
                }
                this.d.setTitleText(format2);
            } else {
                this.d.setTitleText("");
            }
            if (list != null && list.size() >= 1) {
                this.e.setVisibility(0);
                this.f.setVisibility(8);
                this.a.c(list);
                this.a.notifyDataSetChanged();
                switch (i2) {
                    case 1001:
                        this.j.setVisibility(0);
                        this.k.setVisibility(0);
                        this.l.setVisibility(8);
                        return;
                    case 1002:
                        this.j.setVisibility(8);
                        return;
                    case 1003:
                        this.j.setVisibility(0);
                        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
                        this.k.setVisibility(8);
                        this.l.setVisibility(0);
                        PraiseListActivity praiseListActivity2 = this.b;
                        if (praiseListActivity2.a != 1) {
                            format = String.format(praiseListActivity2.getResources().getString(R.string.praise_item_more), StringHelper.numFormatOverWan(i));
                        } else {
                            format = String.format(praiseListActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f085e), StringHelper.numFormatOverWan(i));
                        }
                        this.l.setText(format);
                        return;
                    default:
                        this.j.setVisibility(8);
                        return;
                }
            }
            p(null, this.b.a);
        }
    }
}
