package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.l1;
import c.a.t0.e1.a0;
import c.a.t0.e1.c0;
import c.a.t0.e1.c1;
import c.a.t0.e1.d0;
import c.a.t0.e1.d1;
import c.a.t0.e1.e0;
import c.a.t0.e1.e1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g0;
import c.a.t0.e1.i1;
import c.a.t0.e1.o1;
import c.a.t0.e1.p1;
import c.a.t0.e1.q0;
import c.a.t0.e1.s0;
import c.a.t0.e1.z2.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes12.dex */
public class FrsTabViewController implements c.a.t0.e1.a3.n, TbTabLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public String D;
    public CustomMessageListener E;
    public ViewPager.OnPageChangeListener F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public final CustomMessageListener I;
    public CustomMessageListener J;
    public View.OnClickListener K;

    /* renamed from: e  reason: collision with root package name */
    public FrsFragment f43749e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f43750f;

    /* renamed from: g  reason: collision with root package name */
    public View f43751g;

    /* renamed from: h  reason: collision with root package name */
    public View f43752h;

    /* renamed from: i  reason: collision with root package name */
    public TbTabLayout f43753i;

    /* renamed from: j  reason: collision with root package name */
    public FrsTabViewPager f43754j;
    public RelativeLayout k;
    public LinearGradientView l;
    public TabData m;
    public FrsViewData n;
    public ThemeColorInfo o;
    public FragmentAdapter p;
    public List<o> q;
    public c.a.t0.e1.g r;
    public c.a.t0.e1.z1.f.a.b s;
    public n t;
    public PublishProgressView u;
    public int v;
    public int w;
    public c.a.t0.k0.g x;
    public boolean y;
    public boolean z;

    /* loaded from: classes12.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public List<o> f43755b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f43756c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FrsTabViewController frsTabViewController, FragmentManager fragmentManager, List<o> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43756c = frsTabViewController;
            this.a = -1;
            this.f43755b = list;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = -1;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43755b.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f43755b.get(i2).f43769b : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f43755b.get(i2).f43770c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                if (obj == null || (i3 = this.a) == i2) {
                    return;
                }
                if (i3 != -1 && i3 < getCount()) {
                    BaseFragment baseFragment = (BaseFragment) getItem(this.a);
                    if (baseFragment instanceof FrsAllThreadFragment) {
                        this.f43756c.f43749e.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.a = i2;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        this.f43756c.f43749e.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a extends c.a.s0.i0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f43757b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f43758c;

        public a(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43758c = frsTabViewController;
            this.a = frsTabInfo;
            this.f43757b = i2;
        }

        @Override // c.a.s0.i0.b
        public c.a.s0.i0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, c.a.t0.g1.a.e(this.a, this.f43758c.n.showAdsense.intValue()));
                bundle.putString("name", this.f43758c.f43749e.getForumName());
                bundle.putString("from", this.f43758c.f43749e.getFrom());
                bundle.putString("forum_id", this.f43758c.f43749e.getForumId());
                bundle.putInt("tab_id", this.f43757b);
                bundle.putInt("tab_type", this.a.tab_type.intValue());
                bundle.putString("tab_name", this.a.tab_name);
                bundle.putInt(FrsCommonTabFragment.IS_GENERAL_TAB, this.a.is_general_tab.intValue());
                bundle.putBoolean(FrsCommonTabFragment.CAN_AUTO_PLAY_VIDEO, this.f43758c.n.isFrsVideoAutoPlay);
                bundle.putBoolean(FrsCommonTabFragment.NEED_LOG, this.f43758c.n.needLog == 1);
                bundle.putBoolean(FrsCommonTabFragment.IS_BRAND_FORUM, this.f43758c.n.isBrandForum);
                bundle.putSerializable(FrsCommonTabFragment.VIEW_DATA, this.f43758c.n);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                c.a.s0.i0.c cVar = new c.a.s0.i0.c();
                cVar.a = frsCommonTabFragment;
                cVar.f12933e = this.f43757b;
                cVar.f12937i = c.a.s0.i0.c.k;
                return cVar;
            }
            return (c.a.s0.i0.c) invokeV.objValue;
        }

        @Override // c.a.s0.i0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.s0.i0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b extends c.a.s0.i0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f43759b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f43760c;

        public b(FrsTabViewController frsTabViewController, int i2, FrsTabInfo frsTabInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i2), frsTabInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43760c = frsTabViewController;
            this.a = i2;
            this.f43759b = frsTabInfo;
        }

        @Override // c.a.s0.i0.b
        public c.a.s0.i0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.f43760c.f43749e.getForumName());
                bundle.putString("from", this.f43760c.f43749e.getFrom());
                bundle.putString("forum_id", this.f43760c.f43749e.getForumId());
                bundle.putInt("tab_id", this.a);
                bundle.putInt("tab_type", this.f43759b.tab_type.intValue());
                bundle.putString("tab_name", this.f43759b.tab_name);
                bundle.putString("tab_code", this.f43759b.tab_code);
                bundle.putBoolean(FrsCommonTabFragment.NEED_LOG, this.f43760c.n.needLog == 1);
                bundle.putString(FrsCommonTabFragment.THEME_COLOR, this.f43760c.D);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.f43760c.f43749e.getFrsCallFromByItemPosition());
                frsItemTabFragment.setArguments(bundle);
                frsItemTabFragment.setFrsFragmentTag(this.f43760c.f43749e.getUniqueId());
                c.a.s0.i0.c cVar = new c.a.s0.i0.c();
                cVar.a = frsItemTabFragment;
                cVar.f12933e = this.a;
                cVar.f12937i = c.a.s0.i0.c.k;
                return cVar;
            }
            return (c.a.s0.i0.c) invokeV.objValue;
        }

        @Override // c.a.s0.i0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.s0.i0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsTabViewController frsTabViewController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384 && (customResponsedMessage.getData() instanceof c.a.t0.e1.x2.e)) {
                c.a.t0.e1.x2.e eVar = (c.a.t0.e1.x2.e) customResponsedMessage.getData();
                int i2 = -1;
                for (int i3 = 0; i3 < ListUtils.getCount(this.a.m); i3++) {
                    if (this.a.m.get(i3) != null && (this.a.m.get(i3).f17097b == eVar.f17097b || this.a.m.get(i3).f17100e == eVar.f17100e)) {
                        i2 = i3;
                        break;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                this.a.f43754j.setCurrentItem(i2, true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f43761e;

        public d(FrsTabViewController frsTabViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43761e = frsTabViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43761e.x.I();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsTabViewController frsTabViewController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.t0.e1.g) || this.a.y) {
                return;
            }
            this.a.V();
            this.a.y = true;
        }
    }

    /* loaded from: classes12.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f43762e;

        public f(FrsTabViewController frsTabViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43762e = frsTabViewController;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                c.a.t0.e1.x2.a aVar = new c.a.t0.e1.x2.a();
                aVar.f17095b = i2;
                aVar.f17096c = i3;
                CustomMessage customMessage = new CustomMessage(2921590);
                customMessage.setTag(this.f43762e.f43749e.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                a(this.f43762e.A() == null ? 0 : this.f43762e.A().a, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f43762e.f43754j == null) {
                return;
            }
            this.f43762e.f43754j.notifyFrsTabViewPagerStatus();
            if (ListUtils.isEmpty(this.f43762e.q) || this.f43762e.q.size() <= i2) {
                return;
            }
            o oVar = (o) ListUtils.getItem(this.f43762e.q, i2);
            if (oVar.a == 506) {
                c.a.s0.s.k0.p.b bVar = new c.a.s0.s.k0.p.b(5);
                bVar.n(13);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
            if (oVar.f43771d == 100) {
                TiebaStatic.log(new StatisticItem("c13008").param("obj_type", 16));
            }
            if (oVar.f43769b instanceof s0) {
                a0 a0Var = new a0();
                a0Var.a = oVar.a;
                a0Var.f15991b = (s0) oVar.f43769b;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, a0Var));
            } else {
                a0 a0Var2 = new a0();
                a0Var2.a = oVar.a;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, a0Var2));
            }
            a(oVar.a, 0);
            this.f43762e.f43749e.getWriteIcon().setVisibility(this.f43762e.f43749e.canShowWriteButton(oVar.a) ? 0 : 8);
        }
    }

    /* loaded from: classes12.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsTabViewController frsTabViewController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                if (this.a.n == null || this.a.n.isShowRedTip() == booleanValue || this.a.f43753i.getTabCount() <= 0 || ListUtils.isEmpty(this.a.m)) {
                    return;
                }
                this.a.n.setIsShowRedTip(booleanValue);
                int min = Math.min(this.a.m.size(), this.a.f43753i.getTabCount());
                for (int i2 = 0; i2 < min; i2++) {
                    TbTabLayout.f tabAt = this.a.f43753i.getTabAt(i2);
                    if (tabAt != null) {
                        if (this.a.m.get(i2).f17097b == 89) {
                            tabAt.j(0, booleanValue);
                        } else {
                            tabAt.j(0, false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsTabViewController frsTabViewController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            o A;
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
            if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (A = this.a.A()) != null && (fragment = A.f43769b) != null && (fragment instanceof q0)) {
                ((q0) fragment).forceRefresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsTabViewController frsTabViewController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            l1 l1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof l1) || (l1Var = (l1) customResponsedMessage.getData()) == null || c.a.t0.x3.s0.b.k().s() || c.a.t0.x3.s0.b.k().i() == null || this.a.f43749e == null || !l1Var.c(this.a.f43749e.getForumId()) || this.a.u == null) {
                return;
            }
            this.a.u.updateCurProgressData(l1Var);
        }
    }

    /* loaded from: classes12.dex */
    public class j extends c.a.s0.i0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f43763b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f43764c;

        public j(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43764c = frsTabViewController;
            this.a = frsTabInfo;
            this.f43763b = i2;
        }

        @Override // c.a.s0.i0.b
        public c.a.s0.i0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                if (this.f43764c.f43749e != null && this.f43764c.f43749e.getFrsView() != null) {
                    frsAllThreadFragment.setView(this.f43764c.f43749e.getFrsView().U());
                    this.f43764c.f43749e.setShowAdFlag(c.a.t0.g1.a.e(this.a, this.f43764c.n.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                if (this.f43764c.f43749e != null) {
                    bundle.putString("forum_id", this.f43764c.f43749e.getForumId());
                }
                bundle.putInt("tab_id", this.f43763b);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                c.a.s0.i0.c cVar = new c.a.s0.i0.c();
                cVar.a = frsAllThreadFragment;
                cVar.f12933e = 1;
                cVar.f12937i = c.a.s0.i0.c.k;
                return cVar;
            }
            return (c.a.s0.i0.c) invokeV.objValue;
        }

        @Override // c.a.s0.i0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.s0.i0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class k extends c.a.s0.i0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f43765b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f43766c;

        public k(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43766c = frsTabViewController;
            this.a = frsTabInfo;
            this.f43765b = i2;
        }

        @Override // c.a.s0.i0.b
        public c.a.s0.i0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, c.a.t0.g1.a.e(this.a, this.f43766c.n.showAdsense.intValue()));
                bundle.putString("name", this.f43766c.f43749e.getForumName());
                bundle.putString("from", this.f43766c.f43749e.getFrom());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean("good", true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.f43766c.f43749e.getForumId());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                c.a.s0.i0.c cVar = new c.a.s0.i0.c();
                cVar.a = frsGoodFragment;
                cVar.f12933e = this.f43765b;
                cVar.f12937i = c.a.s0.i0.c.k;
                return cVar;
            }
            return (c.a.s0.i0.c) invokeV.objValue;
        }

        @Override // c.a.s0.i0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.s0.i0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class l extends c.a.s0.i0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f43767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f43768c;

        public l(FrsTabViewController frsTabViewController, FrsTabInfo frsTabInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController, frsTabInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43768c = frsTabViewController;
            this.a = frsTabInfo;
            this.f43767b = i2;
        }

        @Override // c.a.s0.i0.b
        public c.a.s0.i0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, c.a.t0.g1.a.e(this.a, this.f43768c.n.showAdsense.intValue()));
                bundle.putString("name", this.f43768c.f43749e.getForumName());
                bundle.putString("from", this.f43768c.f43749e.getFrom());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.f43768c.f43749e.getForumId());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                c.a.s0.i0.c cVar = new c.a.s0.i0.c();
                cVar.a = frsNewAreaFragment;
                cVar.f12933e = this.f43767b;
                cVar.f12937i = c.a.s0.i0.c.k;
                return cVar;
            }
            return (c.a.s0.i0.c) invokeV.objValue;
        }

        @Override // c.a.s0.i0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.s0.i0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class m extends c.a.s0.i0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        public m(FrsTabViewController frsTabViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabViewController;
        }

        @Override // c.a.s0.i0.b
        public c.a.s0.i0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.a.f43749e.getForumName());
                bundle.putString("from", this.a.f43749e.getFrom());
                bundle.putString("forum_id", this.a.f43749e.getForumId());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                c.a.s0.i0.c cVar = new c.a.s0.i0.c();
                cVar.a = frsADFragment;
                cVar.f12933e = 90;
                cVar.f12937i = c.a.s0.i0.c.k;
                return cVar;
            }
            return (c.a.s0.i0.c) invokeV.objValue;
        }

        @Override // c.a.s0.i0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.s0.i0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public interface n {
        void a(int i2, int i3, String str);
    }

    /* loaded from: classes12.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f43769b;

        /* renamed from: c  reason: collision with root package name */
        public String f43770c;

        /* renamed from: d  reason: collision with root package name */
        public int f43771d;

        public o(FrsTabViewController frsTabViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = 0;
        this.w = -1;
        this.y = false;
        this.B = false;
        this.C = false;
        this.E = new e(this, 2001623);
        this.F = new f(this);
        this.G = new g(this, 2001612);
        this.H = new h(this, 0);
        this.I = new i(this, 2921526);
        this.J = new c(this, 2921384);
        this.K = new d(this);
        this.f43749e = frsFragment;
        this.f43750f = (RelativeLayout) view.findViewById(f1.frs_tab_view_container);
        this.f43752h = view.findViewById(f1.frs_tab_bg);
        this.f43751g = view.findViewById(f1.divider_shadow);
        this.l = (LinearGradientView) view.findViewById(f1.frs_tab_linear_bg);
        TbTabLayout tbTabLayout = (TbTabLayout) view.findViewById(f1.frs_tab_layout);
        this.f43753i = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.f43753i.setSelectedTabTextBlod(true);
        this.f43753i.setTabTextSize(B(d1.tbds42));
        c.a.t0.k0.g gVar = new c.a.t0.k0.g(frsFragment.getPageContext(), this.f43753i);
        this.x = gVar;
        gVar.g0(e1.bg_tip_blue_up_left);
        this.x.O(16);
        this.x.h0(true);
        this.x.j0(B(d1.tbds34));
        this.x.k0(B(d1.tbds10));
        this.x.M(this.K);
        this.f43754j = (FrsTabViewPager) view.findViewById(f1.frs_viewpager);
        this.q = new ArrayList();
        this.p = new FragmentAdapter(this, this.f43749e.getActivity().getSupportFragmentManager(), this.q);
        this.f43754j.addOnPageChangeListener(this.F);
        RelativeLayout relativeLayout = new RelativeLayout(this.f43749e.getContext());
        this.k = relativeLayout;
        this.s = new c.a.t0.e1.z1.f.a.b(frsFragment, relativeLayout);
        PublishProgressView publishProgressView = (PublishProgressView) view.findViewById(f1.publish_progress_view);
        this.u = publishProgressView;
        publishProgressView.setVisibility(8);
    }

    public static boolean R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    public o A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsTabViewPager frsTabViewPager = this.f43754j;
            if (frsTabViewPager == null) {
                return null;
            }
            return (o) ListUtils.getItem(this.q, frsTabViewPager.getCurrentItem());
        }
        return (o) invokeV.objValue;
    }

    public final int B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Iterator<c.a.t0.e1.x2.e> it = this.m.iterator();
            while (it.hasNext()) {
                c.a.t0.e1.x2.e next = it.next();
                if (next != null && ((i2 = next.f17097b) == 1 || i2 == 503)) {
                    return next.f17097b;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : invokeV.intValue;
    }

    public View F() {
        InterceptResult invokeV;
        c.a.t0.e1.z1.f.a.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (N() || (bVar = this.s) == null) {
                return null;
            }
            return bVar.h();
        }
        return (View) invokeV.objValue;
    }

    public RelativeLayout G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (RelativeLayout) invokeV.objValue;
    }

    public o H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            for (o oVar : this.q) {
                if (oVar != null && oVar.a == i2) {
                    return oVar;
                }
            }
            return null;
        }
        return (o) invokeI.objValue;
    }

    public c.a.t0.e1.x2.e I(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.m) != null && tabData.size() > 0) {
                Iterator<c.a.t0.e1.x2.e> it = this.m.iterator();
                while (it.hasNext()) {
                    c.a.t0.e1.x2.e next = it.next();
                    if (next.f17097b == i2) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (c.a.t0.e1.x2.e) invokeI.objValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.v : invokeV.intValue;
    }

    public FrsTabViewPager K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f43754j : (FrsTabViewPager) invokeV.objValue;
    }

    public final void L(FrsViewData frsViewData) {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, frsViewData) == null) || frsViewData == null || (themeColorInfo = frsViewData.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        this.D = themeElement.common_color;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.x.I();
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            FrsViewData frsViewData = this.n;
            return frsViewData != null && frsViewData.getIsBrandForum();
        }
        return invokeV.booleanValue;
    }

    public final boolean O(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, frsTabInfo)) == null) ? frsTabInfo == null || (frsTabInfo.tab_type.intValue() == 0 && frsTabInfo.tab_id.intValue() >= 100) || ((frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) || (frsTabInfo.tab_type.intValue() == 11 && !R(frsTabInfo.tab_id.intValue()))) : invokeL.booleanValue;
    }

    public final boolean P(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            W(tabData);
            if (ListUtils.isEmpty(this.p.f43755b) || tabData.size() != this.p.f43755b.size()) {
                return true;
            }
            int size = tabData.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (tabData.get(i2) != null && this.p.f43755b.get(i2) != null && tabData.get(i2).f17097b != ((o) this.p.f43755b.get(i2)).a) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Q(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            return (!ListUtils.isEmpty(this.m) && tabData.size() == this.m.size() && this.m.containsAll(tabData)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final boolean S(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, frsTabInfo)) == null) ? frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim()) || !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 92 || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 17 || frsTabInfo.tab_type.intValue() == 100) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4 : invokeL.booleanValue;
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || ListUtils.isEmpty(this.q)) {
            return;
        }
        for (o oVar : this.q) {
            if (oVar != null) {
                Fragment fragment = oVar.f43769b;
                if (fragment instanceof q0) {
                    ((q0) fragment).changeToSpecialFrs(z);
                }
            }
        }
    }

    public void U(int i2) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f43751g, e1.personalize_tab_shadow);
            Y();
            if (this.f43753i != null) {
                ThemeColorInfo themeColorInfo = this.o;
                if (themeColorInfo != null) {
                    ThemeElement themeElement = themeColorInfo.dark;
                    if (themeElement != null && i2 == 4) {
                        color = c.a.t0.y1.o.k.b.b(themeElement.font_color);
                    } else {
                        ThemeElement themeElement2 = this.o.night;
                        if (themeElement2 != null && i2 == 1) {
                            color = c.a.t0.y1.o.k.b.b(themeElement2.font_color);
                        } else {
                            ThemeElement themeElement3 = this.o.day;
                            if (themeElement3 != null && i2 == 0) {
                                color = c.a.t0.y1.o.k.b.b(themeElement3.font_color);
                            } else {
                                color = SkinManager.getColor(c1.plugin_button_shadow_red);
                            }
                        }
                    }
                } else {
                    color = SkinManager.getColor(c1.plugin_button_shadow_red);
                }
                this.f43753i.setSelectedTabIndicatorColor(color);
                this.f43753i.setSelectedIndicatorBottomMargin(B(d1.tbds11));
                SkinManager.setBackgroundColor(this.f43753i, c1.transparent);
                this.f43753i.setTabTextColors(SkinManager.getColor(c1.CAM_X0107), SkinManager.getColor(c1.CAM_X0105));
            }
            if (this.s != null && !N()) {
                this.s.i();
            }
            LinearGradientView linearGradientView = this.l;
            if (linearGradientView != null) {
                linearGradientView.changeSkinType(i2);
            }
            if (!ListUtils.isEmpty(this.q)) {
                for (o oVar : this.q) {
                    if (oVar != null) {
                        Fragment fragment = oVar.f43769b;
                        if (fragment instanceof BaseFragment) {
                            ((BaseFragment) fragment).changeSkinType(i2);
                        }
                    }
                }
            }
            L(this.n);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921591, this.D));
        }
    }

    public final void V() {
        c.a.t0.e1.g gVar;
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (gVar = this.r) == null) {
            return;
        }
        List<c.a.s0.i0.b> f2 = gVar.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.m)) {
            return;
        }
        if (this.f43753i.getTabCount() > 0) {
            this.f43753i.removeAllTabs();
        }
        a0();
        ArrayList arrayList = new ArrayList();
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ThemeColorInfo themeColorInfo = this.o;
        if (themeColorInfo != null) {
            ThemeElement themeElement = themeColorInfo.dark;
            if (themeElement != null && skinType == 4) {
                color = c.a.t0.y1.o.k.b.b(themeElement.font_color);
            } else {
                ThemeElement themeElement2 = this.o.night;
                if (themeElement2 != null && skinType == 1) {
                    color = c.a.t0.y1.o.k.b.b(themeElement2.font_color);
                } else {
                    ThemeElement themeElement3 = this.o.day;
                    if (themeElement3 != null && skinType == 0) {
                        color = c.a.t0.y1.o.k.b.b(themeElement3.font_color);
                    } else {
                        color = SkinManager.getColor(c1.plugin_button_shadow_red);
                    }
                }
            }
        } else {
            color = SkinManager.getColor(c1.plugin_button_shadow_red);
        }
        this.f43753i.setSelectedTabIndicatorColor(color);
        this.f43753i.setSelectedIndicatorBottomMargin(B(d1.tbds10));
        Iterator<c.a.t0.e1.x2.e> it = this.m.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            c.a.t0.e1.x2.e next = it.next();
            Fragment y = y(next.f17097b, f2);
            if (y != null) {
                TbTabLayout.f newTab = this.f43753i.newTab();
                newTab.s(next.a);
                if (next.f17097b == 1 && i3 < 0) {
                    i3 = i4;
                }
                boolean z = this.n.defaultShowTab == next.f17097b;
                if (z && i2 < 0) {
                    i2 = i4;
                }
                if (!FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.f43749e.getFrom()) ? !(!FrsActivityConfig.FRS_FROM_ITEM.equals(this.f43749e.getFrom()) || 506 != next.f17097b) : 3 == next.f17100e) {
                    i2 = i4;
                }
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.f17097b == 89) {
                    newTab.j(0, true);
                } else {
                    newTab.j(0, false);
                }
                this.f43753i.addTab(newTab, z);
                o oVar = new o(this);
                oVar.a = next.f17097b;
                oVar.f43770c = next.a;
                oVar.f43769b = y;
                oVar.f43771d = next.f17100e;
                arrayList.add(oVar);
                i4++;
            } else {
                it.remove();
            }
        }
        if (i2 < 0) {
            i2 = Math.max(i3, 0);
        }
        if (arrayList.size() > 0) {
            this.q.clear();
            this.q.addAll(arrayList);
        }
        FragmentAdapter fragmentAdapter = this.p;
        if (fragmentAdapter == null) {
            this.p = new FragmentAdapter(this, this.f43749e.getActivity().getSupportFragmentManager(), this.q);
        } else {
            fragmentAdapter.b();
        }
        this.f43754j.setAdapter(this.p);
        this.p.notifyDataSetChanged();
        if (this.f43753i.getTabCount() > 0 && this.f43750f.getVisibility() != 0) {
            this.f43750f.setVisibility(0);
        }
        this.f43753i.setupWithViewPager(this.f43754j);
        this.f43754j.setOffscreenPageLimit(this.q.size());
        this.f43754j.setCurrentItem(i2, false);
        this.f43754j.notifyFrsTabViewPagerStatus();
    }

    public final void W(TabData tabData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, tabData) == null) || ListUtils.isEmpty(tabData)) {
            return;
        }
        boolean isRegistedIntent = TbadkCoreApplication.getInst().isRegistedIntent(HotRanklistActivityConfig.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            c.a.t0.e1.x2.e eVar = (c.a.t0.e1.x2.e) it.next();
            if (eVar != null && eVar.f17097b == 401 && !isRegistedIntent) {
                arrayList.add(eVar);
            }
        }
        tabData.removeAll(arrayList);
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PublishProgressView publishProgressView = this.u;
            return publishProgressView != null && publishProgressView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            int i2 = this.v;
            if (i2 == 2) {
                SkinManager.setBackgroundColor(this.f43750f, c1.CAM_X0207);
                SkinManager.setBackgroundColor(this.f43752h, c1.CAM_X0207);
                this.f43751g.setVisibility(0);
                this.f43749e.hideRefreshIcon();
            } else if (i2 == 1) {
                SkinManager.setBackgroundColor(this.f43750f, c1.CAM_X0207);
                SkinManager.setBackgroundColor(this.f43752h, c1.CAM_X0207);
                this.f43751g.setVisibility(0);
            } else {
                t();
                this.f43751g.setVisibility(8);
                FrsFragment frsFragment = this.f43749e;
                if (frsFragment != null) {
                    frsFragment.hideRefreshIcon();
                }
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.E.setPriority(Integer.MAX_VALUE);
            this.f43749e.registerListener(this.E);
            this.f43749e.registerListener(this.G);
            FrsFragment frsFragment = this.f43749e;
            frsFragment.registerListener(2001446, this.H, frsFragment.getBaseFragmentActivity().getUniqueId());
            this.f43749e.registerListener(this.J);
            this.f43749e.registerListener(this.I);
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        c.a.t0.e1.x2.e eVar;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) || fVar == null) {
            return;
        }
        int e2 = fVar.e();
        TabData tabData = this.m;
        if (tabData == null || e2 < 0 || e2 >= tabData.size() || (eVar = this.m.get(e2)) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(eVar.f17097b)));
        TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f43749e.forumId).param("tab_id", eVar.f17097b));
        if (c.a.d.f.p.l.A() && eVar.f17097b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
            this.n.setIsShowRedTip(false);
            fVar.j(0, false);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f43754j == null || this.p == null || this.q == null) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = this.f43749e.getActivity().getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                o oVar = this.q.get(i2);
                if (oVar != null && oVar.f43769b != null) {
                    beginTransaction.remove(oVar.f43769b);
                }
            }
            beginTransaction.commit();
            supportFragmentManager.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // c.a.t0.e1.a3.n
    public boolean b(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.m) != null && tabData.size() != 0) {
                int i3 = -1;
                int i4 = 0;
                while (true) {
                    if (i4 >= this.m.size()) {
                        break;
                    } else if (this.m.get(i4).f17097b == i2) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 >= 0 && i3 < this.f43753i.getTabCount()) {
                    TbTabLayout.f tabAt = this.f43753i.getTabAt(i3);
                    if (tabAt == null || tabAt.h()) {
                        return true;
                    }
                    tabAt.l();
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
            int i2 = !ListUtils.isEmpty(this.m) ? this.m.get(0).f17097b : -1;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null) {
                frsViewData.mHeadLineDefaultNavTabId = i2;
            }
            FrsFragment frsFragment = this.f43749e;
            if (frsFragment != null) {
                frsFragment.mHeadLineDefaultNavTabId = i2;
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
            M();
            FrsFragment frsFragment = this.f43749e;
            if (frsFragment == null || frsFragment.getHeaderVC() == null) {
                return;
            }
            this.f43749e.getHeaderVC().w();
        }
    }

    public final void c0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
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

    @Override // c.a.t0.e1.a3.n
    public void d(FrsViewData frsViewData, int i2) {
        AccountData currentAccountObj;
        List<c0> list;
        List<c0> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048607, this, frsViewData, i2) == null) || frsViewData == null || frsViewData.getEntelechyTabInfo() == null || frsViewData.getEntelechyTabInfo().a == null) {
            return;
        }
        L(frsViewData);
        TabData tabData = new TabData();
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().a) {
            if (!S(frsTabInfo) && !O(frsTabInfo)) {
                if (frsTabInfo.is_general_tab.intValue() != 1 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_id.intValue() != 506) {
                    if (frsTabInfo.tab_id.intValue() != 89 && frsTabInfo.tab_id.intValue() != 503) {
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            c.a.t0.e1.x2.e eVar = new c.a.t0.e1.x2.e();
                            eVar.f17097b = frsTabInfo.tab_id.intValue();
                            eVar.a = frsTabInfo.tab_name;
                            eVar.f17100e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                c.a.t0.e1.x2.e eVar2 = new c.a.t0.e1.x2.e();
                                eVar2.f17097b = frsTabInfo.tab_id.intValue();
                                eVar2.a = frsTabInfo.tab_name;
                                eVar2.f17100e = frsTabInfo.tab_type.intValue();
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
                                eVar2.f17099d = sb2;
                                c0(sb2, "c10078");
                                tabData.add(eVar2);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && R(frsTabInfo.tab_id.intValue())) {
                            c.a.t0.e1.x2.e eVar3 = new c.a.t0.e1.x2.e();
                            eVar3.f17097b = frsTabInfo.tab_id.intValue();
                            eVar3.a = frsTabInfo.tab_name;
                            eVar3.f17099d = frsTabInfo.tab_url;
                            eVar3.f17100e = frsTabInfo.tab_type.intValue();
                            if (c.a.s0.m.c.g(eVar3.f17099d)) {
                                if (MessageManager.getInstance().findTask(2016447) != null) {
                                    tabData.add(eVar3);
                                    arrayList.add(frsTabInfo);
                                }
                            } else {
                                tabData.add(eVar3);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && g0.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            c.a.t0.e1.x2.e eVar4 = new c.a.t0.e1.x2.e();
                            eVar4.f17097b = frsTabInfo.tab_id.intValue();
                            eVar4.a = frsTabInfo.tab_name;
                            eVar4.f17100e = frsTabInfo.tab_type.intValue();
                            e0 b2 = d0.a().b(eVar4.f17097b);
                            if (b2 != null && (list2 = b2.f16351b) != null && list2.size() > 0) {
                                p1 p1Var = new p1();
                                eVar4.f17098c = p1Var;
                                p1Var.a = b2.a;
                                p1Var.f16685b = new LinkedList();
                                boolean z = true;
                                for (c0 c0Var : b2.f16351b) {
                                    if (c0Var != null) {
                                        o1 o1Var = new o1();
                                        o1Var.a = c0Var.a;
                                        o1Var.f16683b = c0Var.f16176b;
                                        if (z) {
                                            o1Var.f16684c = true;
                                            z = false;
                                        }
                                        eVar4.f17098c.f16685b.add(o1Var);
                                    }
                                }
                            }
                            tabData.add(eVar4);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            c.a.t0.e1.x2.e eVar5 = new c.a.t0.e1.x2.e();
                            eVar5.f17097b = frsTabInfo.tab_id.intValue();
                            eVar5.a = frsTabInfo.tab_name;
                            eVar5.f17100e = frsTabInfo.tab_type.intValue();
                            e0 b3 = d0.a().b(eVar5.f17097b);
                            if (b3 != null && (list = b3.f16351b) != null && list.size() > 0) {
                                p1 p1Var2 = new p1();
                                eVar5.f17098c = p1Var2;
                                p1Var2.a = b3.a;
                                p1Var2.f16685b = new LinkedList();
                                for (c0 c0Var2 : b3.f16351b) {
                                    if (c0Var2 != null) {
                                        o1 o1Var2 = new o1();
                                        o1Var2.a = c0Var2.a;
                                        o1Var2.f16683b = c0Var2.f16176b;
                                        eVar5.f17098c.f16685b.add(o1Var2);
                                    }
                                }
                            }
                            tabData.add(eVar5);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 49) {
                            if (this.f43749e.getFrsView().V().l(e2.I3)) {
                                c.a.t0.e1.x2.e eVar6 = new c.a.t0.e1.x2.e();
                                eVar6.a = frsTabInfo.tab_name;
                                if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                    eVar6.a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                int i3 = this.w;
                                if (i3 > 0 && i3 != frsViewData.getAlaLiveCount() && this.w <= 99) {
                                    eVar6.a = frsTabInfo.tab_name + "(" + this.w + SmallTailInfo.EMOTION_SUFFIX;
                                } else if (this.w <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                    int i4 = this.w;
                                    if (i4 == 0 && i4 != frsViewData.getAlaLiveCount()) {
                                        eVar6.a = frsTabInfo.tab_name;
                                    }
                                } else {
                                    eVar6.a = frsTabInfo.tab_name + "(99+)";
                                }
                                eVar6.f17097b = frsTabInfo.tab_id.intValue();
                                eVar6.f17100e = frsTabInfo.tab_type.intValue();
                                tabData.add(eVar6);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() == 1120) {
                            c.a.t0.e1.x2.e eVar7 = new c.a.t0.e1.x2.e();
                            eVar7.f17097b = frsTabInfo.tab_id.intValue();
                            eVar7.a = frsTabInfo.tab_name;
                            eVar7.f17100e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar7);
                            arrayList.add(frsTabInfo);
                            w(2);
                        } else if (frsTabInfo.tab_id.intValue() == 90) {
                            c.a.t0.e1.x2.e eVar8 = new c.a.t0.e1.x2.e();
                            eVar8.f17097b = frsTabInfo.tab_id.intValue();
                            eVar8.a = frsTabInfo.tab_name;
                            eVar8.f17100e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar8);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 91) {
                            c.a.t0.e1.x2.e eVar9 = new c.a.t0.e1.x2.e();
                            eVar9.f17097b = frsTabInfo.tab_id.intValue();
                            eVar9.a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, (String) null);
                            eVar9.f17100e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar9);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 504) {
                            c.a.t0.e1.x2.e eVar10 = new c.a.t0.e1.x2.e();
                            eVar10.f17097b = frsTabInfo.tab_id.intValue();
                            eVar10.a = frsTabInfo.tab_name;
                            eVar10.f17100e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar10);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 3) {
                            c.a.t0.e1.x2.e eVar11 = new c.a.t0.e1.x2.e();
                            eVar11.f17097b = frsTabInfo.tab_id.intValue();
                            eVar11.a = frsTabInfo.tab_name;
                            eVar11.f17100e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar11);
                            arrayList.add(frsTabInfo);
                            w(1);
                        }
                    } else {
                        c.a.t0.e1.x2.e eVar12 = new c.a.t0.e1.x2.e();
                        eVar12.f17097b = frsTabInfo.tab_id.intValue();
                        eVar12.a = frsTabInfo.tab_name;
                        eVar12.f17100e = frsTabInfo.tab_type.intValue();
                        tabData.add(eVar12);
                        arrayList.add(frsTabInfo);
                        if (frsTabInfo.tab_id.intValue() == 503) {
                            String str = "";
                            String str2 = TbadkCoreApplication.getCurrentAccountObj() != null ? currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR : "";
                            if (frsViewData.getForum() != null && frsViewData.getForum().getName() != null) {
                                str = frsViewData.getForum().getName();
                            }
                            int h2 = p.h("503~" + str2 + str);
                            if (h2 == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().f25203b.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            p.i("503~" + str2 + str, next.tab_id.intValue());
                                            if (7 == h2) {
                                                c.a.t0.x3.p0.e.b();
                                            } else {
                                                c.a.t0.x3.p0.e.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    c.a.t0.e1.x2.e eVar13 = new c.a.t0.e1.x2.e();
                    eVar13.a = frsTabInfo.tab_name;
                    eVar13.f17097b = frsTabInfo.tab_id.intValue();
                    eVar13.f17100e = frsTabInfo.tab_type.intValue();
                    tabData.add(eVar13);
                    arrayList.add(frsTabInfo);
                }
            }
        }
        if (tabData.size() == 0 || arrayList.size() == 0) {
            return;
        }
        this.n = frsViewData;
        if (frsViewData.getForum() != null) {
            this.o = this.n.getForum().getThemeColorInfo();
        }
        if (!Q(tabData) && this.f43753i.getTabCount() > 0 && !ListUtils.isEmpty(this.m)) {
            int min = Math.min(this.m.size(), this.f43753i.getTabCount());
            for (int i5 = 0; i5 < min; i5++) {
                TbTabLayout.f tabAt = this.f43753i.getTabAt(i5);
                if (tabAt != null) {
                    if (frsViewData.isShowRedTip() && this.m.get(i5).f17097b == 89) {
                        tabAt.j(0, true);
                    } else {
                        tabAt.j(0, false);
                    }
                }
            }
        }
        if (frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> v = v(frsViewData);
            if (N()) {
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(v, 0);
                FrsFragment frsFragment = this.f43749e;
                if (frsFragment != null && frsFragment.getModelController() != null && frsTabInfo2 != null) {
                    this.f43749e.getModelController().I0(frsTabInfo2.tab_id.intValue());
                }
            } else {
                FrsFragment frsFragment2 = this.f43749e;
                if (frsFragment2 != null && frsFragment2.getListView() != null) {
                    if (v != null && v.size() < 2) {
                        this.f43749e.getListView().removeHeaderView(this.k);
                    } else {
                        this.f43749e.getListView().removeHeaderView(this.k);
                        this.f43749e.getListView().addHeaderView(this.k);
                        if (this.s != null && frsViewData.getForum() != null) {
                            this.s.j(v);
                            this.s.k(frsViewData.getForum().getId());
                            this.s.g(this.f43749e.getModelController().R());
                            if (c.a.s0.b.d.u() && c.a.s0.b.g.a.f12403c != c.a.s0.b.g.a.d()) {
                                this.s.g(c.a.s0.b.g.a.d());
                            }
                        }
                    }
                }
            }
        }
        if (P(tabData)) {
            this.m = tabData;
            b0();
            h0(arrayList);
        }
    }

    public void d0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, nVar) == null) {
            this.t = nVar;
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void e(TbTabLayout.f fVar) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
            int e2 = fVar.e();
            TabData tabData = this.m;
            if (tabData == null || e2 < 0 || e2 >= tabData.size()) {
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, 0);
            CustomMessage customMessage = new CustomMessage(2921397);
            if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > e2 && this.q.get(e2) != null && (this.q.get(e2).f43769b instanceof BaseFragment)) {
                customMessage.setTag(((BaseFragment) this.q.get(e2).f43769b).getUniqueId());
                customResponsedMessage.setOrginalMessage(customMessage);
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            c.a.t0.e1.x2.e eVar = this.m.get(e2);
            if (eVar != null) {
                this.A = eVar.f17097b;
                if (c.a.d.f.p.l.A() && eVar.f17097b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
                    this.n.setIsShowRedTip(false);
                    fVar.j(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(eVar.f17097b)));
                }
                if (eVar.f17097b == 502) {
                    if (this.f43749e.getWriteIcon() != null) {
                        this.f43749e.getWriteIcon().setIconFade(e1.btn_frs_professional_edit_n);
                    }
                } else if (this.f43749e.getWriteIcon() != null) {
                    this.f43749e.getWriteIcon().setIconFade(0);
                }
                if (c.a.s0.b.d.y()) {
                    c.a.s0.b.g.a.g(eVar.a);
                }
                n nVar = this.t;
                if (nVar != null) {
                    nVar.a(eVar.f17097b, eVar.f17100e, eVar.a);
                }
                c.a.t0.e1.b.f().t(eVar.f17100e == 14);
                c.a.t0.e1.a.h().o(eVar.f17097b);
                TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f43749e.forumId).param("tab_id", eVar.f17097b));
            }
        }
    }

    public void e0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048610, this, f2) == null) {
        }
    }

    @Override // c.a.t0.e1.a3.n
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.v = i2;
            Y();
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f43753i.setDisableTabSelect(z);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.x.m0(this.f43749e.getString(i1.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
        }
    }

    public final void h0(List<FrsTabInfo> list) {
        FrsFragment frsFragment;
        View U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c.a.t0.e1.g gVar = new c.a.t0.e1.g(this.f43749e.getActivity().getApplicationContext(), list);
        this.r = gVar;
        gVar.i(this.f43749e.getForumId());
        this.r.j(this.f43749e.getForumName());
        this.r.k(this.f43749e.getFrom());
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.r.g(this.n.getForum().getFirst_class());
            this.r.l(this.n.getForum().getSecond_class());
            this.r.h(this.n.getForum().getForumGameLabel());
        }
        int i2 = 0;
        for (FrsTabInfo frsTabInfo : list) {
            if (i2 == 0) {
                x(frsTabInfo.tab_id.intValue(), 1);
            }
            if (frsTabInfo.tab_type.intValue() == 3) {
                w(1);
            }
            i2++;
            c.a.s0.i0.b z = z(frsTabInfo);
            if (z != null) {
                s(frsTabInfo, z);
                this.r.a(z);
            }
        }
        if (list.get(0) != null && list.get(0).tab_id.intValue() != 1 && (frsFragment = this.f43749e) != null && frsFragment.getFrsView() != null && (U = this.f43749e.getFrsView().U()) != null && (U.getParent() instanceof ViewGroup)) {
            ((ViewGroup) U.getParent()).removeView(U);
        }
        this.y = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.r));
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.w = i2;
        }
    }

    public final void s(FrsTabInfo frsTabInfo, c.a.s0.i0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, frsTabInfo, bVar) == null) || bVar == null || bVar.getFragmentTabStructure() == null || !(bVar.getFragmentTabStructure().a instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) bVar.getFragmentTabStructure().a).setTbPageExtraPageTabName(frsTabInfo != null ? frsTabInfo.tab_name : "");
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            SkinManager.setBackgroundColor(this.f43752h, c1.CAM_X0205);
            this.f43752h.setAlpha(0.0f);
            c.a.s0.s.u.c.d(this.f43750f).o(new int[]{c1.CAM_X0202, c1.CAM_X0204});
        }
    }

    public void u(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.B != z) {
                this.B = z;
            }
            if (this.C != z2) {
                this.C = z2;
            }
            t();
        }
    }

    public final List<FrsTabInfo> v(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, frsViewData)) == null) {
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
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().f25203b) {
                if (frsTabInfo.tab_type.intValue() == i2) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13971").param("fid", this.f43749e.forumId).param("fname", this.f43749e.getForumName()).param("obj_locate", i2));
        }
    }

    public final void x(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f43749e.getForumId());
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

    public final Fragment y(int i2, List<c.a.s0.i0.b> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048622, this, i2, list)) == null) {
            for (c.a.s0.i0.b bVar : list) {
                Bundle arguments = bVar.getFragmentTabStructure().a.getArguments();
                if (arguments != null && i2 == bVar.getFragmentTabStructure().f12933e && !arguments.getBoolean("isAdded")) {
                    arguments.putBoolean("isAdded", true);
                    bVar.getFragmentTabStructure().a.setArguments(arguments);
                    return bVar.getFragmentTabStructure().a;
                }
            }
            return null;
        }
        return (Fragment) invokeIL.objValue;
    }

    public final c.a.s0.i0.b z(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, frsTabInfo)) == null) {
            int intValue = frsTabInfo.tab_id.intValue();
            if (intValue == 1) {
                return new j(this, frsTabInfo, intValue);
            }
            if (intValue == 301) {
                return new k(this, frsTabInfo, intValue);
            }
            if (intValue == 503) {
                return new l(this, frsTabInfo, intValue);
            }
            if (intValue == 90) {
                return new m(this);
            }
            if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 100) {
                return new a(this, frsTabInfo, intValue);
            }
            if (intValue == 506) {
                return new b(this, intValue, frsTabInfo);
            }
            return null;
        }
        return (c.a.s0.i0.b) invokeL.objValue;
    }
}
