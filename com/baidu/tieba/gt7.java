package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment;
import com.baidu.tieba.newinterest.fragment.InterestSelectionStyleAFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumStyleAFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class gt7 implements View.OnClickListener, BaseInterestSelectionFragment.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public int b;
    public boolean c;
    public ArrayList<Integer> d;
    public String[] e;
    public boolean f;
    public View g;
    public View h;
    public TextView i;
    public NavigationBar j;
    public BaseInterestedForumFragment k;
    public BaseInterestSelectionFragment l;

    public gt7(BaseFragmentActivity baseFragmentActivity, int i, boolean z, ArrayList<Integer> arrayList, String[] strArr, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i), Boolean.valueOf(z), arrayList, strArr, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseFragmentActivity;
        this.b = i;
        this.c = z;
        this.d = arrayList;
        this.e = strArr;
        this.f = z2;
        f();
        g();
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment.a
    public void a(List<vs7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            InterestedForumStyleAFragment w1 = InterestedForumStyleAFragment.w1(this.b, this.e);
            this.k = w1;
            w1.t1(list);
            b().beginTransaction().add(R.id.obfuscated_res_0x7f0906e9, this.k).addToBackStack(null).commitAllowingStateLoss();
            ct7.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.b, c(list), "");
        }
    }

    public final FragmentManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    public String c(List<vs7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (vs7 vs7Var : list) {
                if (vs7Var != null) {
                    if (sb.length() > 0) {
                        sb.append("|");
                    }
                    sb.append(TextUtils.isEmpty(vs7Var.a()) ? vs7Var.d() : vs7Var.a());
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (View) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
            if (this.f) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.a).createNormalCfg(0)));
            } else {
                this.a.finish();
            }
        }
    }

    public final void f() {
        BaseInterestedForumFragment baseInterestedForumFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d003e, (ViewGroup) null);
            this.g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091657);
            this.j = navigationBar;
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f11c2));
            this.i = addTextButton;
            addTextButton.setId(R.id.obfuscated_res_0x7f09045b);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0108);
            this.h = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            boolean z = this.c;
            if (z) {
                this.k = InterestedForumStyleAFragment.v1(this.b, z, this.e);
                List<vs7> j = j();
                if (j != null) {
                    this.k.t1(j);
                }
                BaseInterestedForumFragment baseInterestedForumFragment2 = this.k;
                this.h.setVisibility(4);
                baseInterestedForumFragment = baseInterestedForumFragment2;
            } else {
                InterestSelectionStyleAFragment u1 = InterestSelectionStyleAFragment.u1(this.b, this.e);
                this.l = u1;
                baseInterestedForumFragment = u1;
            }
            b().beginTransaction().add(R.id.obfuscated_res_0x7f0906e9, baseInterestedForumFragment).commitAllowingStateLoss();
            TiebaStatic.log(new StatisticItem("c13681"));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i.setOnClickListener(this);
            this.h.setOnClickListener(this);
            BaseInterestSelectionFragment baseInterestSelectionFragment = this.l;
            if (baseInterestSelectionFragment != null) {
                baseInterestSelectionFragment.t1(this);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b().getFragments().size() == 1) {
            ct7.c(1, this.b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
        }
    }

    public final List<vs7> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = this.d.iterator();
            while (it.hasNext()) {
                vs7 vs7Var = new vs7();
                vs7Var.i(it.next().intValue());
                arrayList.add(vs7Var);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2 == this.h && this.a != null) {
                BaseInterestedForumFragment baseInterestedForumFragment = this.k;
                if (baseInterestedForumFragment != null && baseInterestedForumFragment.isVisible()) {
                    b().popBackStack();
                    ct7.c(1, this.b);
                    return;
                }
                e();
            } else if (view2 == this.i) {
                e();
                ct7.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.b, "", "");
            }
        }
    }
}
