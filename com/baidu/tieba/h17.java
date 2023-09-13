package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.forumSquare.ForumSquareFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h17 extends BdBaseView implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFragment a;
    public LinearLayout b;
    public ForumHeaderView c;
    public NewPagerSlidingTabBaseStrip d;
    public PullLeftViewPager e;
    public EnterForumTabPagerAdapter f;
    public List<EnterForumTabPagerAdapter.a> g;
    public View h;
    public AlphaAnimation i;
    public AlphaAnimation j;
    public t07 k;
    public t07 l;
    public ImageView m;
    public View n;
    public View o;
    public NavigationBar p;
    public View q;
    public NoNetworkView r;
    public v27 s;
    public int t;
    public int u;
    public NetMessageListener v;
    public CustomMessageListener w;
    public ViewPager.OnPageChangeListener x;

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h17 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h17 h17Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h17Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h17Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().M();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().M();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.a.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0673);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h17 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h17 h17Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h17Var, Integer.valueOf(i)};
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
            this.a = h17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.k0();
                } else {
                    this.a.I();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h17 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public c(h17 h17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h17Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) {
                return;
            }
            this.a.c0(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Fragment fragment;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                return;
            }
            this.a.b0(i);
            if (this.a.g != null && this.a.g.size() > i) {
                if (this.a.s != null) {
                    this.a.s.U();
                }
                EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.a.g.get(i);
                if (aVar != null && (fragment = aVar.a) != null) {
                    if (fragment instanceof EnterForumFragment) {
                        z = ((EnterForumFragment) fragment).c2();
                    } else if (fragment instanceof EnterForumTabFeedFragment) {
                        ep6.b().e(false);
                        boolean Z1 = ((EnterForumTabFeedFragment) aVar.a).Z1();
                        TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param("resource_id", ((EnterForumTabFeedFragment) aVar.a).Y1()));
                        z = Z1;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        this.a.k0();
                    } else {
                        this.a.I();
                    }
                    if (i == 0) {
                        TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
                    }
                    if (i == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h17 a;

        public d(h17 h17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h17Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (FileHelper.CheckFile("scan_flag") && PermissionUtil.checkCamera(this.a.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.a.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else {
                    this.a.a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.a.getPageContext().getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h17 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public e(h17 h17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h17Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.q.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h17(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFragment};
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
        this.v = new a(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.w = new b(this, 2001630);
        this.x = new c(this);
        this.a = enterForumTabFragment;
        enterForumTabFragment.registerListener(this.v);
        this.a.registerListener(this.w);
        this.t = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.u = UtilHelper.getStatusBarHeight() + BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public final void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            this.e = (PullLeftViewPager) this.h.findViewById(R.id.obfuscated_res_0x7f090a25);
            EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
            aVar.a = new EnterForumFragment();
            aVar.b = this.a.getResources().getString(R.string.my_forum);
            ((EnterForumFragment) aVar.a).f2(this);
            EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
            aVar2.a = new ForumSquareFragment();
            aVar2.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07e1);
            aVar2.d = MainEntrance.GO_TO_FORUM_SQUARE;
            ArrayList arrayList = new ArrayList();
            this.g = arrayList;
            arrayList.add(aVar);
            this.g.add(aVar2);
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = new EnterForumTabPagerAdapter(this.a.getChildFragmentManager(), this.g);
            this.f = enterForumTabPagerAdapter;
            this.e.setAdapter(enterForumTabPagerAdapter);
            this.e.setOffscreenPageLimit(this.g.size());
        }
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048606, this, i) != null) || this.r == null) {
            return;
        }
        b0(this.e.getCurrentItem());
        NoNetworkView noNetworkView = this.r;
        if (noNetworkView != null) {
            noNetworkView.onChangeSkinType(getPageContext(), i);
        }
        List<EnterForumTabPagerAdapter.a> list = this.g;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                EnterForumTabPagerAdapter.a aVar = this.g.get(i2);
                if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                    ((BaseFragment) fragment).onChangeSkinType(i);
                }
            }
        }
        SkinManager.setBackgroundResource(this.q, R.drawable.personalize_tab_shadow);
        this.d.H();
        this.c.b();
        SkinManager.setBackgroundColorToTransparent(this.o, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        SkinManager.setBackgroundColorToTransparent(this.n, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void H(NewPagerSlidingTabBaseStrip.c cVar) {
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (newPagerSlidingTabBaseStrip = this.d) != null && cVar != null) {
            newPagerSlidingTabBaseStrip.setOnTabItemClickListener(cVar);
        }
    }

    public String O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) ListUtils.getItem(this.g, i);
            if (aVar != null) {
                Fragment fragment = aVar.a;
                if (fragment instanceof EnterForumTabFeedFragment) {
                    return ((EnterForumTabFeedFragment) fragment).Y1();
                }
                return "";
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public boolean e0(int i) {
        InterceptResult invokeI;
        List<EnterForumTabPagerAdapter.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (i >= 0 && (list = this.g) != null && i <= list.size()) {
                this.e.setCurrentItem(i, true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void f0(t07 t07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, t07Var) == null) {
            this.l = this.k;
            this.k = t07Var;
            this.c.setAdState(t07Var);
            b0(this.e.getCurrentItem());
        }
    }

    public void g0(v27 v27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, v27Var) == null) {
            this.s = v27Var;
        }
    }

    public void i0(String str) {
        ForumHeaderView forumHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, str) != null) || (forumHeaderView = this.c) == null) {
            return;
        }
        forumHeaderView.setSearchHint(str);
    }

    public final void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.topMargin = this.u + i;
            this.q.setLayoutParams(layoutParams);
        }
    }

    public static String U(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public void S(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, view2, bundle) != null) || view2 == null) {
            return;
        }
        this.h = view2;
        T(bundle);
        R(bundle);
        Q(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.h.findViewById(R.id.view_no_network);
        this.r = noNetworkView;
        noNetworkView.addNetworkChangeListener(this);
    }

    public void I() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (view2 = this.q) == null || view2.getVisibility() == 8) {
            return;
        }
        if (this.j == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.j = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.j.setDuration(300L);
            this.j.setAnimationListener(new e(this));
        }
        this.q.startAnimation(this.j);
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            EnterForumTabFragment enterForumTabFragment = this.a;
            if (enterForumTabFragment != null && this.g != null && this.e != null && this.f != null) {
                FragmentManager childFragmentManager = enterForumTabFragment.getChildFragmentManager();
                if (childFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
                for (int i = 0; i < this.g.size(); i++) {
                    Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(U(this.e.getId(), this.f.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.r;
            if (noNetworkView != null) {
                noNetworkView.removeNetworkChangeListener(this);
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            LinearLayout linearLayout = this.b;
            if (linearLayout != null && linearLayout.getPaddingTop() < 0) {
                J();
                return;
            }
            View view2 = this.q;
            if (view2 == null) {
                return;
            }
            view2.clearAnimation();
            if (this.q.getVisibility() == 0) {
                return;
            }
            this.q.setVisibility(0);
            if (this.i == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.i = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.i.setDuration(300L);
            }
            this.q.startAnimation(this.i);
        }
    }

    public final void J() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (view2 = this.q) == null || view2.getVisibility() == 8) {
            return;
        }
        this.q.clearAnimation();
        this.q.setVisibility(8);
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f;
            if (enterForumTabPagerAdapter != null) {
                return enterForumTabPagerAdapter.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e.getCurrentItem();
        }
        return invokeV.intValue;
    }

    public View N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getPageContext().getPageActivity().getWindow().getDecorView();
        }
        return (View) invokeV.objValue;
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b0(this.e.getCurrentItem());
        }
    }

    public int K(String str) {
        InterceptResult invokeL;
        List<EnterForumTabPagerAdapter.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (StringUtils.isNull(str) || (list = this.g) == null || list.size() <= 0) {
                return -1;
            }
            int i = -1;
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (str.equals(this.g.get(i2).d)) {
                    i = i2;
                }
            }
            if (i == -1 && this.a.getResources().getString(R.string.my_forum).equals(str)) {
                return 0;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (i == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
            } else if (ListUtils.getItem(this.g, i) != null && (this.g.get(i).a instanceof EnterForumTabFeedFragment)) {
                ((EnterForumTabFeedFragment) this.g.get(i).a).W1(true);
            }
        }
    }

    public final void Q(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) this.h.findViewById(R.id.obfuscated_res_0x7f090a20);
            this.p = navigationBar;
            navigationBar.setNavHeight(this.t);
            this.p.hideBottomLine();
            this.q = this.h.findViewById(R.id.obfuscated_res_0x7f090913);
            l0(0);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.navigationBarGoSignall);
            this.m = imageView;
            imageView.setOnClickListener(new d(this));
            if (this.d != null) {
                this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.b, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.b.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 3;
                    viewGroup.setLayoutParams(layoutParams);
                }
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
                newPagerSlidingTabBaseStrip.setPadding(newPagerSlidingTabBaseStrip.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), this.d.getPaddingBottom());
            }
        }
    }

    public final void R(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d02c2, (ViewGroup) null);
            this.b = linearLayout;
            ForumHeaderView forumHeaderView = (ForumHeaderView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091eac);
            this.c = forumHeaderView;
            forumHeaderView.setFrom(0);
            this.c.b();
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.b.findViewById(R.id.obfuscated_res_0x7f0923c1);
            this.d = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.E(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds46), BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds46), BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds10), BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds46), true);
            this.d.setmIndicatorWidth(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
            this.d.setIndicatorOvershot(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.d.setIndicatorRadius(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds0));
            this.d.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.d.setTabPadding(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds36), 0, BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds36), 0);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(this.x);
            this.o = this.b.findViewById(R.id.obfuscated_res_0x7f090a21);
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f090a22);
        }
    }

    public void X(int i, int i2, Intent intent) {
        List<EnterForumTabPagerAdapter.a> list;
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) && (list = this.g) != null && list.size() > 0 && (pullLeftViewPager = this.e) != null) {
            EnterForumTabPagerAdapter.a aVar = this.g.get(pullLeftViewPager.getCurrentItem());
            if (aVar != null && (fragment = aVar.a) != null) {
                fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public final void b0(int i) {
        t07 t07Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (this.m != null) {
                if (i == 0) {
                    t07 t07Var2 = this.k;
                    if (t07Var2 != null && t07Var2.a && t07Var2.b > 0) {
                        v27 v27Var = this.s;
                        if (v27Var != null && v27Var.T() != null && this.s.T().isViewAttached()) {
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        } else {
                            t07 t07Var3 = this.k;
                            int i4 = t07Var3.c;
                            if (i4 > 0 && t07Var3.b > i4 / 2) {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            } else {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            }
                        }
                    } else {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            NavigationBar navigationBar = this.p;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                if (i == 0) {
                    t07 t07Var4 = this.k;
                    if (t07Var4 != null && t07Var4.a && t07Var4.b > 0) {
                        v27 v27Var2 = this.s;
                        if (v27Var2 != null && v27Var2.T() != null && this.s.T().isViewAttached()) {
                            SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        } else {
                            t07 t07Var5 = this.k;
                            int i5 = t07Var5.c;
                            if (i5 > 0) {
                                int i6 = (t07Var5.b * 255) / i5;
                                if (i6 > 255) {
                                    i6 = 255;
                                }
                                i3 = 255 - i6;
                            } else {
                                i3 = 0;
                            }
                            this.p.setBackgroundColor(0);
                            SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0201, i3 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                        }
                    } else {
                        SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
            if (newPagerSlidingTabBaseStrip != null) {
                if (i == 0) {
                    t07 t07Var6 = this.k;
                    if (t07Var6 != null && t07Var6.a && (i2 = t07Var6.b) > 0) {
                        int i7 = t07Var6.c;
                        if (i7 > 0 && i2 > i7 / 2) {
                            v27 v27Var3 = this.s;
                            if (v27Var3 != null && v27Var3.T() != null && this.s.T().isViewAttached()) {
                                this.d.setWhiteStyle(false);
                            } else {
                                this.d.setWhiteStyle(true);
                            }
                        } else {
                            this.d.setWhiteStyle(false);
                        }
                    } else {
                        this.d.setWhiteStyle(false);
                    }
                } else {
                    newPagerSlidingTabBaseStrip.setWhiteStyle(false);
                }
            }
            ForumHeaderView forumHeaderView = this.c;
            if (forumHeaderView != null) {
                if (i == 0) {
                    forumHeaderView.setAdState(this.k);
                } else {
                    forumHeaderView.setAdState(null);
                }
            }
            if (i == 0 && this.a.isPrimary() && (t07Var = this.k) != null && t07Var.a && i == 0) {
                int i8 = t07Var.b;
                int i9 = t07Var.c;
                if (i8 > i9 / 2) {
                    t07 t07Var7 = this.l;
                    if (t07Var7 != null && t07Var7.b <= i9 / 2) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                        return;
                    }
                    return;
                }
                t07 t07Var8 = this.l;
                if (t07Var8 != null && t07Var8.b >= i9 / 2) {
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            }
        }
    }

    public final void c0(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && this.p != null) {
            if (i == 0) {
                if (i2 == 0) {
                    b0(i);
                    return;
                }
                t07 t07Var = this.k;
                if (t07Var != null && t07Var.a && t07Var.b > 0) {
                    v27 v27Var = this.s;
                    if (v27Var != null && v27Var.T() != null && this.s.T().isViewAttached()) {
                        SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.p.setBackgroundColor(0);
                    SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                b0(i);
            } else {
                t07 t07Var2 = this.k;
                if (t07Var2 != null && t07Var2.a && t07Var2.b > 0) {
                    v27 v27Var2 = this.s;
                    if (v27Var2 != null && v27Var2.T() != null && this.s.T().isViewAttached()) {
                        SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.p.setBackgroundColor(0);
                    SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
            } else if (this.e.getCurrentItem() == 0 && this.a.isPrimary()) {
                v27 v27Var = this.s;
                if (v27Var != null && v27Var.T() != null && this.s.T().isViewAttached()) {
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                    return;
                }
                t07 t07Var = this.k;
                if (t07Var != null && t07Var.a) {
                    int i = t07Var.b;
                    if (i <= t07Var.c / 2 && i != 0) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                        return;
                    } else {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                        return;
                    }
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void h0(boolean z) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f;
            if (enterForumTabPagerAdapter != null) {
                enterForumTabPagerAdapter.c(z);
            }
            List<EnterForumTabPagerAdapter.a> list = this.g;
            if (list != null && list.size() > 0 && (pullLeftViewPager = this.e) != null) {
                EnterForumTabPagerAdapter.a aVar = this.g.get(pullLeftViewPager.getCurrentItem());
                if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                    ((BaseFragment) fragment).setPrimary(z);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void k(boolean z) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            List<EnterForumTabPagerAdapter.a> list = this.g;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.g.size(); i++) {
                    EnterForumTabPagerAdapter.a aVar = this.g.get(i);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof NoNetworkView.b)) {
                        ((NoNetworkView.b) fragment).k(z);
                    }
                }
            }
            b0(this.e.getCurrentItem());
        }
    }

    public void j0(int i, String str) {
        List<EnterForumTabPagerAdapter.a> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048602, this, i, str) == null) && i >= 0 && (list = this.g) != null && i <= list.size()) {
            this.e.setCurrentItem(i, true);
            if (this.g.get(i) != null && (this.g.get(i).a instanceof ForumSquareFragment)) {
                ((ForumSquareFragment) this.g.get(i).a).W1(str);
            }
        }
    }
}
