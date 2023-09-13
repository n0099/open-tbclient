package com.baidu.tieba;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class go7 extends BdBaseView<ForumRulesShowActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;
    public int b;
    public String c;
    public ViewGroup d;
    public NavigationBar e;
    public View f;
    public ImageView g;
    public View h;
    public ImageView i;
    public rn7 j;
    public co7 k;
    public bo7 l;
    public BdTypeRecyclerView m;
    public List<cn> n;
    public View o;
    public wn5 p;
    public int q;
    public int r;
    public yn7 s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ go7 b;

        public a(go7 go7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = go7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.a, this.b.a.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go7(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.n = new ArrayList();
        this.q = 0;
        this.r = 0;
        this.a = forumRulesShowActivity;
        this.c = str;
        forumRulesShowActivity.setContentView(R.layout.obfuscated_res_0x7f0d003a);
        this.k = new co7(forumRulesShowActivity);
        this.l = new bo7(forumRulesShowActivity);
        this.q = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070424);
        this.r = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        K(forumRulesShowActivity);
    }

    public void N(wn5 wn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, wn5Var) == null) {
            this.p = wn5Var;
            wn5Var.b().setOnClickListener(this);
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && this.k != null && !StringUtils.isNull(str)) {
            this.k.a(this.m);
            this.k.e(str);
        }
    }

    public void S(String str) {
        bo7 bo7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && (bo7Var = this.l) != null) {
            bo7Var.a(this.m);
            this.l.e(str);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.c = str;
            rn7 rn7Var = this.j;
            if (rn7Var != null) {
                rn7Var.d(str);
            }
        }
    }

    public void u(yn7 yn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, yn7Var) == null) {
            this.s = yn7Var;
            this.n.add(yn7Var);
        }
    }

    public void x(xn7 xn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, xn7Var) == null) {
            this.n.add(xn7Var);
        }
    }

    public void y(List<zn7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            this.n.addAll(list);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            R(str);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
        }
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public ViewGroup E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void F() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdTypeRecyclerView = this.m) != null) {
            bdTypeRecyclerView.setVisibility(8);
        }
    }

    public void G() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (view2 = this.o) != null) {
            view2.setVisibility(8);
        }
    }

    public void H() {
        co7 co7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (co7Var = this.k) != null) {
            co7Var.d(this.m);
        }
    }

    public void I() {
        bo7 bo7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bo7Var = this.l) != null) {
            bo7Var.d(this.m);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            H();
        }
    }

    public void M() {
        rn7 rn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (rn7Var = this.j) != null) {
            rn7Var.c(this.n);
        }
    }

    public void P() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (bdTypeRecyclerView = this.m) != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void Q() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (view2 = this.o) != null) {
            view2.setVisibility(0);
        }
    }

    public final void J(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, navigationBar) == null) {
            View addSystemImageButton = this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.f = addSystemImageButton;
            this.g = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.e.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07da));
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
            this.h = addCustomView;
            this.i = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int i = this.q;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.rightMargin = this.r;
            this.h.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            O();
        }
    }

    public final void K(ForumRulesShowActivity forumRulesShowActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumRulesShowActivity) == null) {
            this.d = (ViewGroup) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090c0c);
            NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f091922);
            this.e = navigationBar;
            J(navigationBar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090c19);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
            this.j = new rn7(forumRulesShowActivity, this.m);
            this.o = forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090c1a);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.e.onChangeSkinType(this.a.getPageContext(), i);
            if (this.b == i) {
                this.e.getCenterText().setTextSize((float) R.dimen.L_X06);
                SkinManager.setNavbarTitleColor(this.e.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
                WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.k.c(i);
                this.l.c(i);
                this.j.b(i);
                this.b = i;
            }
        }
    }

    public final void O() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (baseSwitchs != null && baseSwitchs.containsKey("is_disable_forumrule_share")) {
                i = baseSwitchs.get("is_disable_forumrule_share").intValue();
            } else {
                i = -1;
            }
            if (i == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.c)) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && this.a != null) {
            if (view2.getId() == R.id.root_pb_more) {
                int i = -1;
                yn7 yn7Var = this.s;
                String str2 = "";
                if (yn7Var == null || yn7Var.e() == null) {
                    str = "";
                } else {
                    i = this.s.e().forum_id.intValue();
                    str = this.s.e().forum_name;
                }
                yn7 yn7Var2 = this.s;
                if (yn7Var2 != null) {
                    str2 = yn7Var2.l();
                }
                String str3 = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                ShareItem shareItem = new ShareItem();
                shareItem.title = str2;
                shareItem.content = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07dd), str);
                shareItem.linkUrl = str3;
                shareItem.showTail = false;
                yn7 yn7Var3 = this.s;
                if (yn7Var3 != null && !StringUtils.isNull(yn7Var3.e().avatar)) {
                    shareItem.imageUri = Uri.parse(this.s.e().avatar);
                    shareItem.saveImageDataIfNecessary();
                }
                shareItem.wbtitle = str2;
                shareItem.wbcontent = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
                this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            } else if (view2.getId() == R.id.navigationBarGoBack) {
                this.a.finish();
            } else if (this.p != null && view2.getId() == this.p.b().getId()) {
                this.a.s1();
            }
        }
    }
}
