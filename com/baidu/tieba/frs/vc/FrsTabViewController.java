package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.h5.FrsTabWebFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.FrsTabItemCustomeView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ag6;
import com.repackage.aq6;
import com.repackage.cf7;
import com.repackage.cg6;
import com.repackage.em8;
import com.repackage.eq6;
import com.repackage.hr6;
import com.repackage.ke6;
import com.repackage.kf6;
import com.repackage.le6;
import com.repackage.m65;
import com.repackage.mf6;
import com.repackage.ms4;
import com.repackage.n65;
import com.repackage.nf6;
import com.repackage.np6;
import com.repackage.o16;
import com.repackage.of6;
import com.repackage.oi;
import com.repackage.om4;
import com.repackage.pg6;
import com.repackage.pp6;
import com.repackage.qe6;
import com.repackage.qf6;
import com.repackage.qg6;
import com.repackage.qi;
import com.repackage.wm8;
import com.repackage.yv4;
import com.repackage.zj6;
import com.repackage.zr6;
import com.repackage.zs6;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class FrsTabViewController implements zr6, TbTabLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final pp6 A;
    public CustomMessageListener B;
    public ViewPager.OnPageChangeListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final CustomMessageListener F;
    public CustomMessageListener G;
    public View.OnClickListener H;
    public FrsFragment a;
    public RelativeLayout b;
    public View c;
    public View d;
    public TbTabLayout e;
    public FrsTabViewPager f;
    public RelativeLayout g;
    public LinearGradientView h;
    public TabData i;
    public FrsViewData j;
    public ThemeColorInfo k;
    public FragmentAdapter l;
    public List<p> m;
    public qe6 n;
    public zj6 o;
    public o p;
    public PublishProgressView q;
    public int r;
    public int s;
    public o16 t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public String z;

    /* loaded from: classes3.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List<p> b;
        public final /* synthetic */ FrsTabViewController c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FrsTabViewController frsTabViewController, FragmentManager fragmentManager, List<p> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabViewController;
            this.a = -1;
            this.b = list;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = -1;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.b.get(i).b : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.b.get(i).c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                if (obj == null || (i2 = this.a) == i) {
                    return;
                }
                if (i2 != -1 && i2 < getCount()) {
                    BaseFragment baseFragment = (BaseFragment) getItem(this.a);
                    if (baseFragment instanceof FrsAllThreadFragment) {
                        this.c.a.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.a = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        this.c.a.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        public a(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = frsTabViewController;
            this.c = frsTabInfo;
            this.d = i;
        }

        @Override // com.repackage.m65
        public n65 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, zs6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putString("forum_id", this.e.a.d());
                bundle.putInt("tab_id", this.d);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putInt("is_general_tab", this.c.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.e.j.isFrsVideoAutoPlay);
                bundle.putBoolean("need_log", this.e.j.needLog == 1);
                bundle.putBoolean("is_brand_forum", this.e.j.isBrandForum);
                bundle.putSerializable("view_data", this.e.j);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                n65 n65Var = new n65();
                n65Var.a = frsCommonTabFragment;
                n65Var.e = this.d;
                n65Var.i = n65.k;
                return n65Var;
            }
            return (n65) invokeV.objValue;
        }

        @Override // com.repackage.m65
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.repackage.m65
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        public b(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = frsTabViewController;
            this.c = frsTabInfo;
            this.d = i;
        }

        @Override // com.repackage.m65
        public n65 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsTabWebFragment frsTabWebFragment = new FrsTabWebFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, zs6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putString("forum_id", this.e.a.d());
                bundle.putInt("tab_id", this.d);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putString("tab_url", this.c.tab_url);
                bundle.putInt("is_general_tab", this.c.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.e.j.isFrsVideoAutoPlay);
                bundle.putBoolean("need_log", this.e.j.needLog == 1);
                bundle.putBoolean("is_brand_forum", this.e.j.isBrandForum);
                bundle.putSerializable("view_data", this.e.j);
                bundle.putBoolean("isAdded", false);
                frsTabWebFragment.setArguments(bundle);
                n65 n65Var = new n65();
                n65Var.a = frsTabWebFragment;
                n65Var.e = this.d;
                n65Var.i = n65.k;
                return n65Var;
            }
            return (n65) invokeV.objValue;
        }

        @Override // com.repackage.m65
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.repackage.m65
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int c;
        public final /* synthetic */ FrsTabInfo d;
        public final /* synthetic */ FrsTabViewController e;

        public c(FrsTabViewController frsTabViewController, int i, FrsTabInfo frsTabInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i), frsTabInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = frsTabViewController;
            this.c = i;
            this.d = frsTabInfo;
        }

        @Override // com.repackage.m65
        public n65 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putString("forum_id", this.e.a.d());
                bundle.putInt("tab_id", this.c);
                bundle.putInt("tab_type", this.d.tab_type.intValue());
                bundle.putString("tab_name", this.d.tab_name);
                bundle.putString("tab_code", this.d.tab_code);
                bundle.putBoolean("need_log", this.e.j.needLog == 1);
                bundle.putString("theme_color", this.e.z);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.e.a.q3());
                frsItemTabFragment.setArguments(bundle);
                frsItemTabFragment.w1(this.e.a.getUniqueId());
                n65 n65Var = new n65();
                n65Var.a = frsItemTabFragment;
                n65Var.e = this.c;
                n65Var.i = n65.k;
                return n65Var;
            }
            return (n65) invokeV.objValue;
        }

        @Override // com.repackage.m65
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.repackage.m65
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsTabViewController frsTabViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i)};
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
            this.a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384 && (customResponsedMessage.getData() instanceof eq6)) {
                eq6 eq6Var = (eq6) customResponsedMessage.getData();
                int i = -1;
                for (int i2 = 0; i2 < ListUtils.getCount(this.a.i); i2++) {
                    if (this.a.i.get(i2) != null && (this.a.i.get(i2).b == eq6Var.b || this.a.i.get(i2).e == eq6Var.e)) {
                        i = i2;
                        break;
                    }
                }
                if (i < 0) {
                    return;
                }
                this.a.f.setCurrentItem(i, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        public e(FrsTabViewController frsTabViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t.N();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsTabViewController frsTabViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i)};
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
            this.a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof qe6) || this.a.u) {
                return;
            }
            this.a.Y();
            this.a.u = true;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        public g(FrsTabViewController frsTabViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabViewController;
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                aq6 aq6Var = new aq6();
                aq6Var.b = i;
                aq6Var.c = i2;
                CustomMessage customMessage = new CustomMessage(2921590);
                customMessage.setTag(this.a.a.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aq6Var);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                a(this.a.C() == null ? 0 : this.a.C().a, i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.a.f == null) {
                return;
            }
            this.a.f.d();
            if (!ListUtils.isEmpty(this.a.m) && this.a.m.size() > i) {
                p pVar = (p) ListUtils.getItem(this.a.m, i);
                if (pVar.a == 506) {
                    yv4 yv4Var = new yv4(5);
                    yv4Var.n(13);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, yv4Var));
                }
                if (pVar.d == 100) {
                    TiebaStatic.log(new StatisticItem("c13008").param("obj_type", 16));
                }
                if (pVar.d == 102) {
                    TiebaStatic.log(new StatisticItem("c13008").param("fid", this.a.a.d()).param("obj_type", 17));
                }
                if (pVar.b instanceof cg6) {
                    kf6 kf6Var = new kf6();
                    kf6Var.a = pVar.a;
                    kf6Var.b = (cg6) pVar.b;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, kf6Var));
                } else {
                    kf6 kf6Var2 = new kf6();
                    kf6Var2.a = pVar.a;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, kf6Var2));
                }
                a(pVar.a, 0);
                this.a.a.H3().setVisibility(this.a.a.Z2(pVar.a) ? 0 : 8);
            }
            if (this.a.a == null || !(this.a.a.getActivity() instanceof FrsActivity)) {
                return;
            }
            ((FrsActivity) this.a.a.getActivity()).G0().a();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsTabViewController frsTabViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i)};
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
            this.a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                if (this.a.j == null || this.a.j.isShowRedTip() == booleanValue || this.a.e.getTabCount() <= 0 || ListUtils.isEmpty(this.a.i)) {
                    return;
                }
                this.a.j.setIsShowRedTip(booleanValue);
                int min = Math.min(this.a.i.size(), this.a.e.getTabCount());
                for (int i = 0; i < min; i++) {
                    TbTabLayout.f w = this.a.e.w(i);
                    if (w != null) {
                        if (this.a.i.get(i).b == 89) {
                            w.j(0, booleanValue);
                        } else {
                            w.j(0, false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsTabViewController frsTabViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i)};
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
            this.a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            p C;
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            String str = split[0];
            String str2 = split[1];
            if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (C = this.a.C()) != null && (fragment = C.b) != null && (fragment instanceof ag6)) {
                ((ag6) fragment).x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsTabViewController frsTabViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i)};
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
            this.a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PublishProgressData publishProgressData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof PublishProgressData) || (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) == null || wm8.k().s() || wm8.k().i() == null || this.a.a == null || !publishProgressData.isCurrentForum(this.a.a.d()) || this.a.q == null) {
                return;
            }
            this.a.q.c(publishProgressData);
        }
    }

    /* loaded from: classes3.dex */
    public class k extends m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        public k(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = frsTabViewController;
            this.c = frsTabInfo;
            this.d = i;
        }

        @Override // com.repackage.m65
        public n65 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                if (this.e.a != null && this.e.a.k1() != null) {
                    frsAllThreadFragment.t1(this.e.a.k1().W());
                    this.e.a.F4(zs6.e(this.c, this.e.j.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                if (this.e.a != null) {
                    bundle.putString("forum_id", this.e.a.d());
                }
                bundle.putInt("tab_id", this.d);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                n65 n65Var = new n65();
                n65Var.a = frsAllThreadFragment;
                n65Var.e = 1;
                n65Var.i = n65.k;
                return n65Var;
            }
            return (n65) invokeV.objValue;
        }

        @Override // com.repackage.m65
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.repackage.m65
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l extends m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        public l(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = frsTabViewController;
            this.c = frsTabInfo;
            this.d = i;
        }

        @Override // com.repackage.m65
        public n65 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, zs6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean(FrsActivityConfig.GOOD, true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.a.d());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                n65 n65Var = new n65();
                n65Var.a = frsGoodFragment;
                n65Var.e = this.d;
                n65Var.i = n65.k;
                return n65Var;
            }
            return (n65) invokeV.objValue;
        }

        @Override // com.repackage.m65
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.repackage.m65
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m extends m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        public m(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = frsTabViewController;
            this.c = frsTabInfo;
            this.d = i;
        }

        @Override // com.repackage.m65
        public n65 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, zs6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.a.d());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                n65 n65Var = new n65();
                n65Var.a = frsNewAreaFragment;
                n65Var.e = this.d;
                n65Var.i = n65.k;
                return n65Var;
            }
            return (n65) invokeV.objValue;
        }

        @Override // com.repackage.m65
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.repackage.m65
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class n extends m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController c;

        public n(FrsTabViewController frsTabViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsTabViewController;
        }

        @Override // com.repackage.m65
        public n65 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.c.a.c());
                bundle.putString("from", this.c.a.o3());
                bundle.putString("forum_id", this.c.a.d());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                n65 n65Var = new n65();
                n65Var.a = frsADFragment;
                n65Var.e = 90;
                n65Var.i = n65.k;
                return n65Var;
            }
            return (n65) invokeV.objValue;
        }

        @Override // com.repackage.m65
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.repackage.m65
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface o {
        void a(int i, int i2, String str);
    }

    /* loaded from: classes3.dex */
    public class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Fragment b;
        public String c;
        public int d;

        public p(FrsTabViewController frsTabViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public FrsTabViewController(FrsFragment frsFragment, View view2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, view2, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 0;
        this.s = -1;
        this.u = false;
        this.x = false;
        this.y = false;
        this.A = np6.a();
        this.B = new f(this, 2001623);
        this.C = new g(this);
        this.D = new h(this, 2001612);
        this.E = new i(this, 0);
        this.F = new j(this, 2921526);
        this.G = new d(this, 2921384);
        this.H = new e(this);
        this.a = frsFragment;
        this.A.a(view2, onClickListener);
        this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bef);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090beb);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f090803);
        this.h = (LinearGradientView) view2.findViewById(R.id.obfuscated_res_0x7f090bed);
        TbTabLayout tbTabLayout = (TbTabLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bec);
        this.e = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.e.setSelectedTabTextBlod(true);
        this.e.setTabTextSize(np6.c());
        o16 o16Var = new o16(frsFragment.getPageContext(), this.e);
        this.t = o16Var;
        o16Var.q0(R.drawable.obfuscated_res_0x7f0802f1);
        this.t.T(16);
        this.t.r0(true);
        this.t.u0(D(R.dimen.tbds34));
        this.t.v0(D(R.dimen.tbds10));
        this.t.R(this.H);
        this.f = (FrsTabViewPager) view2.findViewById(R.id.obfuscated_res_0x7f090c05);
        this.m = new ArrayList();
        this.l = new FragmentAdapter(this, this.a.getActivity().getSupportFragmentManager(), this.m);
        this.f.addOnPageChangeListener(this.C);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getContext());
        this.g = relativeLayout;
        this.o = new zj6(frsFragment, relativeLayout);
        PublishProgressView publishProgressView = (PublishProgressView) view2.findViewById(R.id.obfuscated_res_0x7f091aa3);
        this.q = publishProgressView;
        publishProgressView.setVisibility(8);
    }

    public static boolean U(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    public final Fragment A(int i2, List<m65> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, list)) == null) {
            for (m65 m65Var : list) {
                Bundle arguments = m65Var.b().a.getArguments();
                if (arguments != null && i2 == m65Var.b().e && !arguments.getBoolean("isAdded")) {
                    arguments.putBoolean("isAdded", true);
                    m65Var.b().a.setArguments(arguments);
                    return m65Var.b().a;
                }
            }
            return null;
        }
        return (Fragment) invokeIL.objValue;
    }

    public final m65 B(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsTabInfo)) == null) {
            int intValue = frsTabInfo.tab_id.intValue();
            if (intValue == 1) {
                return new k(this, frsTabInfo, intValue);
            }
            if (intValue == 301) {
                return new l(this, frsTabInfo, intValue);
            }
            if (intValue == 503) {
                return new m(this, frsTabInfo, intValue);
            }
            if (intValue == 90) {
                return new n(this);
            }
            if (frsTabInfo.tab_type.intValue() != 91 && intValue != 89 && intValue != 504 && frsTabInfo.tab_type.intValue() != 15 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_type.intValue() != 3 && frsTabInfo.tab_type.intValue() != 100) {
                if (frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() == 102) {
                    return new b(this, frsTabInfo, intValue);
                }
                if (intValue == 506) {
                    return new c(this, intValue, frsTabInfo);
                }
                return null;
            }
            return new a(this, frsTabInfo, intValue);
        }
        return (m65) invokeL.objValue;
    }

    public p C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsTabViewPager frsTabViewPager = this.f;
            if (frsTabViewPager == null) {
                return null;
            }
            return (p) ListUtils.getItem(this.m, frsTabViewPager.getCurrentItem());
        }
        return (p) invokeV.objValue;
    }

    public final int D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? qi.f(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<eq6> it = this.i.iterator();
            while (it.hasNext()) {
                eq6 next = it.next();
                if (next != null && ((i2 = next.b) == 1 || i2 == 503)) {
                    return next.b;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.w : invokeV.intValue;
    }

    public View H() {
        InterceptResult invokeV;
        zj6 zj6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Q() || (zj6Var = this.o) == null) {
                return null;
            }
            return zj6Var.h();
        }
        return (View) invokeV.objValue;
    }

    public RelativeLayout I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (RelativeLayout) invokeV.objValue;
    }

    public p J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            for (p pVar : this.m) {
                if (pVar != null && pVar.a == i2) {
                    return pVar;
                }
            }
            return null;
        }
        return (p) invokeI.objValue;
    }

    public eq6 K(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.i) != null && tabData.size() > 0) {
                Iterator<eq6> it = this.i.iterator();
                while (it.hasNext()) {
                    eq6 next = it.next();
                    if (next.b == i2) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (eq6) invokeI.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.r : invokeV.intValue;
    }

    public final int M(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            ThemeColorInfo themeColorInfo = this.k;
            if (themeColorInfo != null) {
                ThemeElement themeElement = themeColorInfo.dark;
                if (themeElement != null && i2 == 4) {
                    return cf7.b(themeElement.font_color);
                }
                ThemeElement themeElement2 = this.k.night;
                if (themeElement2 != null && i2 == 1) {
                    return cf7.b(themeElement2.font_color);
                }
                ThemeElement themeElement3 = this.k.day;
                return (themeElement3 == null || i2 != 0) ? i3 : cf7.b(themeElement3.font_color);
            }
            return i3;
        }
        return invokeII.intValue;
    }

    public FrsTabViewPager N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f : (FrsTabViewPager) invokeV.objValue;
    }

    public final void O(FrsViewData frsViewData) {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || frsViewData == null || (themeColorInfo = frsViewData.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 4) {
            themeElement = themeColorInfo.dark;
        } else if (skinType == 1) {
            themeElement = themeColorInfo.night;
        } else {
            themeElement = themeColorInfo.day;
        }
        this.z = themeElement.common_color;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.t.N();
        }
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrsViewData frsViewData = this.j;
            return frsViewData != null && frsViewData.getIsBrandForum();
        }
        return invokeV.booleanValue;
    }

    public final boolean R(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, frsTabInfo)) == null) ? frsTabInfo == null || (frsTabInfo.tab_type.intValue() == 0 && frsTabInfo.tab_id.intValue() >= 100) || ((frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) || (frsTabInfo.tab_type.intValue() == 11 && !U(frsTabInfo.tab_id.intValue()))) : invokeL.booleanValue;
    }

    public final boolean S(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            Z(tabData);
            if (ListUtils.isEmpty(this.l.b) || tabData.size() != this.l.b.size()) {
                return true;
            }
            int size = tabData.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (tabData.get(i2) != null && this.l.b.get(i2) != null && tabData.get(i2).b != ((p) this.l.b.get(i2)).a) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean T(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            return (!ListUtils.isEmpty(this.i) && tabData.size() == this.i.size() && this.i.containsAll(tabData)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final boolean V(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, frsTabInfo)) == null) ? frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim()) || !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 92 || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 17 || frsTabInfo.tab_type.intValue() == 100 || frsTabInfo.tab_type.intValue() == 102) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4 : invokeL.booleanValue;
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || ListUtils.isEmpty(this.m)) {
            return;
        }
        for (p pVar : this.m) {
            if (pVar != null) {
                Fragment fragment = pVar.b;
                if (fragment instanceof ag6) {
                    ((ag6) fragment).h0(z);
                }
            }
        }
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            SkinManager.setBackgroundResource(this.c, R.drawable.personalize_tab_shadow);
            b0();
            TbTabLayout tbTabLayout = this.e;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(M(i2, SkinManager.getColor(R.color.plugin_button_shadow_red)));
                this.e.setSelectedIndicatorBottomMargin(D(R.dimen.tbds11));
                SkinManager.setBackgroundColor(this.e, R.color.transparent);
                this.e.setTabTextColors(np6.b(), SkinManager.getColor(R.color.CAM_X0105));
                w(i2);
            }
            if (this.o != null && !Q()) {
                this.o.i();
            }
            LinearGradientView linearGradientView = this.h;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            if (!ListUtils.isEmpty(this.m)) {
                for (p pVar : this.m) {
                    if (pVar != null) {
                        Fragment fragment = pVar.b;
                        if (fragment instanceof BaseFragment) {
                            ((BaseFragment) fragment).changeSkinType(i2);
                        }
                    }
                }
            }
            O(this.j);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921591, this.z));
        }
    }

    public final void Y() {
        qe6 qe6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (qe6Var = this.n) == null) {
            return;
        }
        List<m65> f2 = qe6Var.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.i)) {
            return;
        }
        if (this.e.getTabCount() > 0) {
            this.e.B();
        }
        d0();
        ArrayList arrayList = new ArrayList();
        this.e.setSelectedTabIndicatorColor(M(TbadkCoreApplication.getInst().getSkinType(), SkinManager.getColor(R.color.plugin_button_shadow_red)));
        this.e.setSelectedIndicatorBottomMargin(D(R.dimen.tbds10));
        Iterator<eq6> it = this.i.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            eq6 next = it.next();
            Fragment A = A(next.b, f2);
            if (A != null) {
                TbTabLayout.f z = this.e.z();
                z.s(next.a);
                if (next.b == 1 && i3 < 0) {
                    i3 = i4;
                }
                boolean z2 = this.j.defaultShowTab == next.b;
                if (z2 && i2 < 0) {
                    i2 = i4;
                }
                if (!FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.a.o3()) ? !(!FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.o3()) || 506 != next.b) : 3 == next.e) {
                    i2 = i4;
                }
                FrsViewData frsViewData = this.j;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.b == 89) {
                    z.j(0, true);
                } else {
                    z.j(0, false);
                }
                this.e.f(z, z2);
                p pVar = new p(this);
                pVar.a = next.b;
                pVar.c = next.a;
                pVar.b = A;
                pVar.d = next.e;
                arrayList.add(pVar);
                i4++;
            } else {
                it.remove();
            }
        }
        if (i2 < 0) {
            i2 = Math.max(i3, 0);
        }
        if (arrayList.size() > 0) {
            this.m.clear();
            this.m.addAll(arrayList);
        }
        FragmentAdapter fragmentAdapter = this.l;
        if (fragmentAdapter == null) {
            this.l = new FragmentAdapter(this, this.a.getActivity().getSupportFragmentManager(), this.m);
        } else {
            fragmentAdapter.c();
        }
        this.f.setAdapter(this.l);
        this.l.notifyDataSetChanged();
        if (this.e.getTabCount() > 0 && this.b.getVisibility() != 0) {
            this.b.setVisibility(0);
        }
        this.e.setupWithViewPager(this.f);
        v();
        this.f.setOffscreenPageLimit(this.m.size());
        this.f.setCurrentItem(i2, false);
        this.f.d();
    }

    public final void Z(TabData tabData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, tabData) == null) || ListUtils.isEmpty(tabData)) {
            return;
        }
        boolean isRegistedIntent = TbadkCoreApplication.getInst().isRegistedIntent(HotRanklistActivityConfig.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            eq6 eq6Var = (eq6) it.next();
            if (eq6Var != null && eq6Var.b == 401 && !isRegistedIntent) {
                arrayList.add(eq6Var);
            }
        }
        tabData.removeAll(arrayList);
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        eq6 eq6Var;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) || fVar == null) {
            return;
        }
        int e2 = fVar.e();
        TabData tabData = this.i;
        if (tabData == null || e2 < 0 || e2 >= tabData.size() || (eq6Var = this.i.get(e2)) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(eq6Var.b)));
        TiebaStatic.log(new StatisticItem("c12398").param("fid", this.a.l).param("tab_id", eq6Var.b));
        if (oi.A() && eq6Var.b == 89 && (frsViewData = this.j) != null && frsViewData.isShowRedTip()) {
            this.j.setIsShowRedTip(false);
            fVar.j(0, false);
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PublishProgressView publishProgressView = this.q;
            return publishProgressView != null && publishProgressView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.zr6
    public boolean b(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.i) != null && tabData.size() != 0) {
                int i3 = -1;
                int i4 = 0;
                while (true) {
                    if (i4 >= this.i.size()) {
                        break;
                    } else if (this.i.get(i4).b == i2) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 >= 0 && i3 < this.e.getTabCount()) {
                    TbTabLayout.f w = this.e.w(i3);
                    if (w == null || w.h()) {
                        return true;
                    }
                    w.l();
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            int i2 = this.r;
            if (i2 == 2) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
                this.c.setVisibility(0);
                this.a.M3();
            } else if (i2 == 1) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
                this.c.setVisibility(0);
            } else {
                t();
                this.c.setVisibility(8);
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.M3();
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
            P();
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.o0() != null) {
                this.a.o0().D();
            }
            int e2 = fVar.e();
            TabData tabData = this.i;
            if (tabData == null || e2 < 0 || e2 >= tabData.size() || this.i.get(e2) == null || 102 != this.i.get(e2).e || !(fVar.b() instanceof FrsTabItemCustomeView)) {
                return;
            }
            ((FrsTabItemCustomeView) fVar.b()).b(false);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.B.setPriority(Integer.MAX_VALUE);
            this.a.registerListener(this.B);
            this.a.registerListener(this.D);
            FrsFragment frsFragment = this.a;
            frsFragment.registerListener(2001446, this.E, frsFragment.getBaseFragmentActivity().getUniqueId());
            this.a.registerListener(this.G);
            this.a.registerListener(this.F);
        }
    }

    @Override // com.repackage.zr6
    public void d(FrsViewData frsViewData, int i2) {
        AccountData currentAccountObj;
        List<mf6> list;
        List<mf6> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048607, this, frsViewData, i2) == null) || frsViewData == null || frsViewData.getEntelechyTabInfo() == null || frsViewData.getEntelechyTabInfo().a == null) {
            return;
        }
        O(frsViewData);
        TabData tabData = new TabData();
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().a) {
            if (!V(frsTabInfo) && !R(frsTabInfo)) {
                if (frsTabInfo.is_general_tab.intValue() != 1 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_id.intValue() != 506 && frsTabInfo.tab_type.intValue() != 102) {
                    if (frsTabInfo.tab_id.intValue() != 89 && frsTabInfo.tab_id.intValue() != 503) {
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            eq6 eq6Var = new eq6();
                            eq6Var.b = frsTabInfo.tab_id.intValue();
                            eq6Var.a = frsTabInfo.tab_name;
                            eq6Var.e = frsTabInfo.tab_type.intValue();
                            tabData.add(eq6Var);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                eq6 eq6Var2 = new eq6();
                                eq6Var2.b = frsTabInfo.tab_id.intValue();
                                eq6Var2.a = frsTabInfo.tab_name;
                                eq6Var2.e = frsTabInfo.tab_type.intValue();
                                StringBuilder sb = new StringBuilder();
                                String lowerCase = frsTabInfo.tab_url.toLowerCase();
                                if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                    sb.append("http://");
                                }
                                sb.append(frsTabInfo.tab_url);
                                sb.append("&");
                                sb.append("fid");
                                sb.append("=");
                                sb.append(frsViewData.getForum().getId());
                                String sb2 = sb.toString();
                                eq6Var2.d = sb2;
                                f0(sb2, "c10078");
                                tabData.add(eq6Var2);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && U(frsTabInfo.tab_id.intValue())) {
                            eq6 eq6Var3 = new eq6();
                            eq6Var3.b = frsTabInfo.tab_id.intValue();
                            eq6Var3.a = frsTabInfo.tab_name;
                            eq6Var3.d = frsTabInfo.tab_url;
                            eq6Var3.e = frsTabInfo.tab_type.intValue();
                            if (om4.g(eq6Var3.d)) {
                                if (MessageManager.getInstance().findTask(2016447) != null) {
                                    tabData.add(eq6Var3);
                                    arrayList.add(frsTabInfo);
                                }
                            } else {
                                tabData.add(eq6Var3);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && qf6.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            eq6 eq6Var4 = new eq6();
                            eq6Var4.b = frsTabInfo.tab_id.intValue();
                            eq6Var4.a = frsTabInfo.tab_name;
                            eq6Var4.e = frsTabInfo.tab_type.intValue();
                            of6 b2 = nf6.a().b(eq6Var4.b);
                            if (b2 != null && (list2 = b2.b) != null && list2.size() > 0) {
                                qg6 qg6Var = new qg6();
                                eq6Var4.c = qg6Var;
                                qg6Var.a = b2.a;
                                qg6Var.b = new LinkedList();
                                boolean z = true;
                                for (mf6 mf6Var : b2.b) {
                                    if (mf6Var != null) {
                                        pg6 pg6Var = new pg6();
                                        pg6Var.a = mf6Var.a;
                                        pg6Var.b = mf6Var.b;
                                        if (z) {
                                            pg6Var.c = true;
                                            z = false;
                                        }
                                        eq6Var4.c.b.add(pg6Var);
                                    }
                                }
                            }
                            tabData.add(eq6Var4);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            eq6 eq6Var5 = new eq6();
                            eq6Var5.b = frsTabInfo.tab_id.intValue();
                            eq6Var5.a = frsTabInfo.tab_name;
                            eq6Var5.e = frsTabInfo.tab_type.intValue();
                            of6 b3 = nf6.a().b(eq6Var5.b);
                            if (b3 != null && (list = b3.b) != null && list.size() > 0) {
                                qg6 qg6Var2 = new qg6();
                                eq6Var5.c = qg6Var2;
                                qg6Var2.a = b3.a;
                                qg6Var2.b = new LinkedList();
                                for (mf6 mf6Var2 : b3.b) {
                                    if (mf6Var2 != null) {
                                        pg6 pg6Var2 = new pg6();
                                        pg6Var2.a = mf6Var2.a;
                                        pg6Var2.b = mf6Var2.b;
                                        eq6Var5.c.b.add(pg6Var2);
                                    }
                                }
                            }
                            tabData.add(eq6Var5);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 49) {
                            if (this.a.k1().X().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                                eq6 eq6Var6 = new eq6();
                                eq6Var6.a = frsTabInfo.tab_name;
                                if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                    eq6Var6.a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                int i3 = this.s;
                                if (i3 > 0 && i3 != frsViewData.getAlaLiveCount() && this.s <= 99) {
                                    eq6Var6.a = frsTabInfo.tab_name + "(" + this.s + SmallTailInfo.EMOTION_SUFFIX;
                                } else if (this.s <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                    int i4 = this.s;
                                    if (i4 == 0 && i4 != frsViewData.getAlaLiveCount()) {
                                        eq6Var6.a = frsTabInfo.tab_name;
                                    }
                                } else {
                                    eq6Var6.a = frsTabInfo.tab_name + "(99+)";
                                }
                                eq6Var6.b = frsTabInfo.tab_id.intValue();
                                eq6Var6.e = frsTabInfo.tab_type.intValue();
                                tabData.add(eq6Var6);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() == 1120) {
                            eq6 eq6Var7 = new eq6();
                            eq6Var7.b = frsTabInfo.tab_id.intValue();
                            eq6Var7.a = frsTabInfo.tab_name;
                            eq6Var7.e = frsTabInfo.tab_type.intValue();
                            tabData.add(eq6Var7);
                            arrayList.add(frsTabInfo);
                            y(2);
                        } else if (frsTabInfo.tab_id.intValue() == 90) {
                            eq6 eq6Var8 = new eq6();
                            eq6Var8.b = frsTabInfo.tab_id.intValue();
                            eq6Var8.a = frsTabInfo.tab_name;
                            eq6Var8.e = frsTabInfo.tab_type.intValue();
                            tabData.add(eq6Var8);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 91) {
                            eq6 eq6Var9 = new eq6();
                            eq6Var9.b = frsTabInfo.tab_id.intValue();
                            eq6Var9.a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, (String) null);
                            eq6Var9.e = frsTabInfo.tab_type.intValue();
                            tabData.add(eq6Var9);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 504) {
                            eq6 eq6Var10 = new eq6();
                            eq6Var10.b = frsTabInfo.tab_id.intValue();
                            eq6Var10.a = frsTabInfo.tab_name;
                            eq6Var10.e = frsTabInfo.tab_type.intValue();
                            tabData.add(eq6Var10);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 3) {
                            eq6 eq6Var11 = new eq6();
                            eq6Var11.b = frsTabInfo.tab_id.intValue();
                            eq6Var11.a = frsTabInfo.tab_name;
                            eq6Var11.e = frsTabInfo.tab_type.intValue();
                            tabData.add(eq6Var11);
                            arrayList.add(frsTabInfo);
                            y(1);
                        }
                    } else {
                        eq6 eq6Var12 = new eq6();
                        eq6Var12.b = frsTabInfo.tab_id.intValue();
                        eq6Var12.a = frsTabInfo.tab_name;
                        eq6Var12.e = frsTabInfo.tab_type.intValue();
                        tabData.add(eq6Var12);
                        arrayList.add(frsTabInfo);
                        if (frsTabInfo.tab_id.intValue() == 503) {
                            String str = "";
                            String str2 = TbadkCoreApplication.getCurrentAccountObj() != null ? currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR : "";
                            if (frsViewData.getForum() != null && frsViewData.getForum().getName() != null) {
                                str = frsViewData.getForum().getName();
                            }
                            int h2 = hr6.h("503~" + str2 + str);
                            if (h2 == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().b.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            hr6.i("503~" + str2 + str, next.tab_id.intValue());
                                            if (7 == h2) {
                                                em8.b();
                                            } else {
                                                em8.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    eq6 eq6Var13 = new eq6();
                    eq6Var13.a = frsTabInfo.tab_name;
                    eq6Var13.b = frsTabInfo.tab_id.intValue();
                    eq6Var13.e = frsTabInfo.tab_type.intValue();
                    eq6Var13.f = frsTabInfo.head_pics;
                    eq6Var13.d = frsTabInfo.tab_url;
                    tabData.add(eq6Var13);
                    arrayList.add(frsTabInfo);
                }
            }
        }
        if (tabData.size() == 0 || arrayList.size() == 0) {
            return;
        }
        this.j = frsViewData;
        if (frsViewData.getForum() != null) {
            this.k = this.j.getForum().getThemeColorInfo();
        }
        if (!T(tabData) && this.e.getTabCount() > 0 && !ListUtils.isEmpty(this.i)) {
            int min = Math.min(this.i.size(), this.e.getTabCount());
            for (int i5 = 0; i5 < min; i5++) {
                TbTabLayout.f w = this.e.w(i5);
                if (w != null) {
                    if (frsViewData.isShowRedTip() && this.i.get(i5).b == 89) {
                        w.j(0, true);
                    } else {
                        w.j(0, false);
                    }
                }
            }
        }
        if (frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> x = x(frsViewData);
            if (Q()) {
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(x, 0);
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.K0() != null && frsTabInfo2 != null) {
                    this.a.K0().N0(frsTabInfo2.tab_id.intValue());
                }
            } else {
                FrsFragment frsFragment2 = this.a;
                if (frsFragment2 != null && frsFragment2.y3() != null) {
                    if (x != null && x.size() < 2) {
                        this.a.y3().removeHeaderView(this.g);
                    } else {
                        this.a.y3().removeHeaderView(this.g);
                        this.a.y3().t(this.g, 0);
                        if (this.o != null && frsViewData.getForum() != null) {
                            this.o.j(x);
                            this.o.k(frsViewData.getForum().getId());
                            this.o.g(this.a.K0().U());
                            if (UbsABTestHelper.isFrsNewAreaTabSortTestA() && FrsTabTestHelper.HAVE_NOT_RECORD_SORT != FrsTabTestHelper.getFrsNewAreaTabSort()) {
                                this.o.g(FrsTabTestHelper.getFrsNewAreaTabSort());
                            }
                        }
                    }
                }
            }
        }
        if (S(tabData)) {
            this.i = tabData;
            e0();
            k0(arrayList);
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.f == null || this.l == null || this.m == null) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = this.a.getActivity().getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = this.m.get(i2);
                if (pVar != null && pVar.b != null) {
                    beginTransaction.remove(pVar.b);
                }
            }
            beginTransaction.commit();
            supportFragmentManager.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void e(TbTabLayout.f fVar) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
            int e2 = fVar.e();
            TabData tabData = this.i;
            if (tabData == null || e2 < 0 || e2 >= tabData.size()) {
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, 0);
            CustomMessage customMessage = new CustomMessage(2921397);
            if (!ListUtils.isEmpty(this.m) && ListUtils.getCount(this.m) > e2 && this.m.get(e2) != null && (this.m.get(e2).b instanceof BaseFragment)) {
                customMessage.setTag(((BaseFragment) this.m.get(e2).b).getUniqueId());
                customResponsedMessage.setOrginalMessage(customMessage);
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            eq6 eq6Var = this.i.get(e2);
            if (eq6Var != null) {
                if (102 == eq6Var.e && (fVar.b() instanceof FrsTabItemCustomeView)) {
                    ((FrsTabItemCustomeView) fVar.b()).b(true);
                }
                this.w = eq6Var.b;
                if (oi.A() && eq6Var.b == 89 && (frsViewData = this.j) != null && frsViewData.isShowRedTip()) {
                    this.j.setIsShowRedTip(false);
                    fVar.j(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(eq6Var.b)));
                }
                if (eq6Var.b == 502) {
                    if (this.a.H3() != null) {
                        this.a.H3().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.a.H3() != null) {
                    this.a.H3().setIconFade(0);
                }
                if (UbsABTestHelper.isFrsTabLocationTestC()) {
                    FrsTabTestHelper.storeUserLastAccessTab(eq6Var.a);
                }
                o oVar = this.p;
                if (oVar != null) {
                    oVar.a(eq6Var.b, eq6Var.e, eq6Var.a);
                }
                le6.f().t(eq6Var.e == 14);
                ke6.h().o(eq6Var.b);
                TiebaStatic.log(new StatisticItem("c12398").param("fid", this.a.l).param("tab_id", eq6Var.b));
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            int i2 = !ListUtils.isEmpty(this.i) ? this.i.get(0).b : -1;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null) {
                frsViewData.mHeadLineDefaultNavTabId = i2;
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                frsFragment.M0 = i2;
            }
        }
    }

    @Override // com.repackage.zr6
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.r = i2;
            b0();
        }
    }

    public final void f0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048612, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String host = new URI(str).getHost();
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.param("obj_type", host);
            TiebaStatic.log(statisticItem);
        } catch (URISyntaxException e2) {
            BdLog.e(e2);
        }
    }

    public void g0(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, oVar) == null) {
            this.p = oVar;
        }
    }

    public void h0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.e.setDisableTabSelect(z);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.t.x0(this.a.getString(R.string.obfuscated_res_0x7f0f03e8), "key_show_frs_tab_click_to_refresh_tip");
        }
    }

    public final void k0(List<FrsTabInfo> list) {
        FrsFragment frsFragment;
        View W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        qe6 qe6Var = new qe6(this.a.getActivity().getApplicationContext(), list);
        this.n = qe6Var;
        qe6Var.i(this.a.d());
        this.n.j(this.a.c());
        this.n.k(this.a.o3());
        FrsViewData frsViewData = this.j;
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.n.g(this.j.getForum().getFirst_class());
            this.n.l(this.j.getForum().getSecond_class());
            this.n.h(this.j.getForum().getForumGameLabel());
        }
        int i2 = 0;
        for (FrsTabInfo frsTabInfo : list) {
            if (i2 == 0) {
                z(frsTabInfo.tab_id.intValue(), 1);
            }
            if (frsTabInfo.tab_type.intValue() == 3) {
                y(1);
            }
            i2++;
            m65 B = B(frsTabInfo);
            if (B != null) {
                s(frsTabInfo, B);
                this.n.a(B);
            }
        }
        if (list.get(0) != null && list.get(0).tab_id.intValue() != 1 && (frsFragment = this.a) != null && frsFragment.k1() != null && (W = this.a.k1().W()) != null && (W.getParent() instanceof ViewGroup)) {
            ((ViewGroup) W.getParent()).removeView(W);
        }
        this.u = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.n));
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.s = i2;
        }
    }

    public final void s(FrsTabInfo frsTabInfo, m65 m65Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, frsTabInfo, m65Var) == null) || m65Var == null || m65Var.b() == null || !(m65Var.b().a instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) m65Var.b().a).setTbPageExtraPageTabName(frsTabInfo != null ? frsTabInfo.tab_name : "");
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            this.d.setAlpha(0.0f);
            ms4.d(this.b).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
        }
    }

    public void u(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.x != z) {
                this.x = z;
            }
            if (this.y != z2) {
                this.y = z2;
            }
            t();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.e.getTabCount() <= 0 || ListUtils.isEmpty(this.i)) {
            return;
        }
        int min = Math.min(this.i.size(), this.e.getTabCount());
        for (int i2 = 0; i2 < min; i2++) {
            TbTabLayout.f w = this.e.w(i2);
            eq6 eq6Var = this.i.get(i2);
            if (w != null && eq6Var != null && eq6Var.e == 102 && eq6Var.f != null) {
                FrsTabItemCustomeView frsTabItemCustomeView = new FrsTabItemCustomeView(this.a.getContext());
                frsTabItemCustomeView.setNeedNightShade(false);
                frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(M(TbadkCoreApplication.getInst().getSkinType(), SkinManager.getColor(R.color.plugin_button_shadow_red)), PorterDuff.Mode.SRC_IN));
                frsTabItemCustomeView.setNeedNightShade(false);
                frsTabItemCustomeView.e(eq6Var.f);
                w.o(frsTabItemCustomeView);
            }
        }
    }

    public final void w(int i2) {
        FrsTabItemCustomeView frsTabItemCustomeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048623, this, i2) == null) || this.e.getTabCount() <= 0 || ListUtils.isEmpty(this.i)) {
            return;
        }
        int min = Math.min(this.i.size(), this.e.getTabCount());
        for (int i3 = 0; i3 < min; i3++) {
            TbTabLayout.f w = this.e.w(i3);
            eq6 eq6Var = this.i.get(i3);
            if (w != null && eq6Var != null && eq6Var.e == 102 && (w.b() instanceof FrsTabItemCustomeView) && (frsTabItemCustomeView = (FrsTabItemCustomeView) w.b()) != null) {
                frsTabItemCustomeView.a();
                frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(M(i2, SkinManager.getColor(R.color.plugin_button_shadow_red)), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final List<FrsTabInfo> x(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                FrsTabInfo next = it.next();
                if (next.tab_id.intValue() == 1) {
                    i2 = next.tab_type.intValue();
                    break;
                }
            }
            if (i2 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().b) {
                if (frsTabInfo.tab_type.intValue() == i2) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13971").param("fid", this.a.l).param("fname", this.a.c()).param("obj_locate", i2));
        }
    }

    public final void z(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048626, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.a.d());
            if (i2 == 89) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 502) {
                statisticItem.param("obj_type", 8);
            } else if (i2 == 90) {
                statisticItem.param("obj_type", 9);
            } else if (i2 == 1) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    statisticItem.param("obj_type", 4);
                } else {
                    statisticItem.param("obj_type", 5);
                }
            } else if (i2 == 404) {
                statisticItem.param("obj_type", 2);
            } else if (i2 == 301) {
                statisticItem.param("obj_type", 7);
            } else if (i2 == 503) {
                statisticItem.param("obj_type", 6);
            } else if (i2 == 504) {
                statisticItem.param("obj_type", 11);
            }
            statisticItem.param("obj_locate", i3);
            statisticItem.eventStat();
        }
    }
}
