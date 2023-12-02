package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.frs.gametabs.NewSpecialFrsWebFragment;
import com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public NavigationBar b;
    public SpecialFrsWebFragment c;
    public NewSpecialFrsWebFragment d;
    public rq6 e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public View.OnClickListener i;
    public CustomMessageListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        public a(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.f) {
                    this.a.s();
                } else if (this.a.e != null && view2 == this.a.e.d()) {
                    if (!ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                    this.a.a.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.a.a.getPageActivity())));
                } else if (view2 == this.a.h) {
                    if (!StringUtils.isNull(this.a.h())) {
                        this.a.a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.a.a.getPageActivity(), this.a.h(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (view2 == this.a.g) {
                    f08 f08Var = this.a;
                    f08Var.r(f08Var.c.o3(null, null, null, null));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f08 f08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof NewsRemindMessage) || customResponsedMessage.getCmd() != 2001626 || (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) == null) {
                return;
            }
            int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
            if (!newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasNotificationRemind()) {
                z = false;
            } else {
                z = true;
            }
            if (this.a.e != null) {
                this.a.e.g(z, msgCount);
            }
        }
    }

    public f08(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.j = new b(this, 2001626);
        this.a = bdPageContext;
        rq6 rq6Var = new rq6(bdPageContext.getPageActivity());
        this.e = rq6Var;
        rq6Var.d().setOnClickListener(this.i);
        this.a.registerListener(this.j);
    }

    public void o(boolean z) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (imageView = this.h) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void p(boolean z) {
        NavigationBar navigationBar;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (navigationBar = this.b) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            navigationBar.setVisibility(i);
        }
    }

    public void q(boolean z) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (imageView = this.g) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void r(ShareItem shareItem) {
        SpecialFrsWebFragment specialFrsWebFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, shareItem) == null) && (specialFrsWebFragment = this.c) != null) {
            specialFrsWebFragment.z3(shareItem);
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SpecialFrsWebFragment specialFrsWebFragment = this.c;
            if (specialFrsWebFragment != null) {
                return specialFrsWebFragment.w();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SpecialFrsWebFragment specialFrsWebFragment = this.c;
            if (specialFrsWebFragment != null) {
                return specialFrsWebFragment.v();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NavigationBar navigationBar = this.b;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void k(NavigationBar navigationBar, NewSpecialFrsWebFragment newSpecialFrsWebFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, navigationBar, newSpecialFrsWebFragment) == null) {
            this.b = navigationBar;
            this.d = newSpecialFrsWebFragment;
            navigationBar.showBottomLine();
            this.b.getBarBgView().setAlpha(1.0f);
            this.b.setCenterTextTitle(i());
            ImageView imageView = (ImageView) this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
            this.f = imageView;
            imageView.setOnClickListener(this.i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), 0);
            ImageView imageView2 = (ImageView) this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0912, (View.OnClickListener) null);
            this.g = imageView2;
            imageView2.setLayoutParams(layoutParams);
            this.g.setOnClickListener(this.i);
            ImageView imageView3 = (ImageView) this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.h = imageView3;
            imageView3.setLayoutParams(layoutParams);
            this.h.setOnClickListener(this.i);
            p(newSpecialFrsWebFragment.K2());
            q(newSpecialFrsWebFragment.L2());
            o(newSpecialFrsWebFragment.J2());
            m(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, navigationBar, specialFrsWebFragment) == null) {
            this.b = navigationBar;
            this.c = specialFrsWebFragment;
            navigationBar.showBottomLine();
            this.b.getBarBgView().setAlpha(1.0f);
            this.b.setCenterTextTitle(i());
            ImageView imageView = (ImageView) this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
            this.f = imageView;
            imageView.setOnClickListener(this.i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), 0);
            ImageView imageView2 = (ImageView) this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0912, (View.OnClickListener) null);
            this.g = imageView2;
            imageView2.setLayoutParams(layoutParams);
            this.g.setOnClickListener(this.i);
            ImageView imageView3 = (ImageView) this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.h = imageView3;
            imageView3.setLayoutParams(layoutParams);
            this.h.setOnClickListener(this.i);
            p(specialFrsWebFragment.K2());
            q(specialFrsWebFragment.L2());
            o(specialFrsWebFragment.J2());
            m(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void m(int i) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.c != null && (navigationBar = this.b) != null) {
            navigationBar.onChangeSkinType(this.a, i);
            SkinManager.setViewTextColor(this.b.mTextTitle, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.b.mCenterText, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundColor(this.b.getBottomLine(), R.color.CAM_X0204);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            rq6 rq6Var = this.e;
            if (rq6Var != null) {
                rq6Var.f(i);
            }
            SkinManager.setNavbarIconSrc(this.h, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
