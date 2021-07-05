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
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
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
import com.baidu.tieba.R;
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
import d.a.r0.r.q.b2;
import d.a.r0.r.q.j1;
import d.a.s0.u0.b0;
import d.a.s0.u0.c0;
import d.a.s0.u0.d0;
import d.a.s0.u0.d1;
import d.a.s0.u0.e1;
import d.a.s0.u0.f0;
import d.a.s0.u0.p0;
import d.a.s0.u0.r0;
import d.a.s0.u0.z;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes5.dex */
public class FrsTabViewController implements d.a.s0.u0.o2.n, TbTabLayout.c {
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
    public FrsFragment f16012e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16013f;

    /* renamed from: g  reason: collision with root package name */
    public View f16014g;

    /* renamed from: h  reason: collision with root package name */
    public View f16015h;

    /* renamed from: i  reason: collision with root package name */
    public TbTabLayout f16016i;
    public FrsTabViewPager j;
    public RelativeLayout k;
    public LinearGradientView l;
    public TabData m;
    public FrsViewData n;
    public ThemeColorInfo o;
    public FragmentAdapter p;
    public List<o> q;
    public d.a.s0.u0.g r;
    public d.a.s0.u0.m1.f.a.b s;
    public n t;
    public PublishProgressView u;
    public int v;
    public int w;
    public d.a.s0.e0.e x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16017a;

        /* renamed from: b  reason: collision with root package name */
        public List<o> f16018b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16019c;

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
            this.f16019c = frsTabViewController;
            this.f16017a = -1;
            this.f16018b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16018b.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f16018b.get(i2).f16044b : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f16018b.get(i2).f16045c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                if (obj == null || (i3 = this.f16017a) == i2) {
                    return;
                }
                if (i3 != -1) {
                    BaseFragment baseFragment = (BaseFragment) getItem(i3);
                    if (baseFragment instanceof FrsAllThreadFragment) {
                        this.f16019c.f16012e.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.f16017a = i2;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        this.f16019c.f16012e.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends d.a.r0.e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16020a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16021b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16022c;

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
            this.f16022c = frsTabViewController;
            this.f16020a = frsTabInfo;
            this.f16021b = i2;
        }

        @Override // d.a.r0.e0.b
        public d.a.r0.e0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.s0.w0.a.e(this.f16020a, this.f16022c.n.showAdsense.intValue()));
                bundle.putString("name", this.f16022c.f16012e.h());
                bundle.putString("from", this.f16022c.f16012e.u2());
                bundle.putString("forum_id", this.f16022c.f16012e.i());
                bundle.putInt("tab_id", this.f16021b);
                bundle.putInt("tab_type", this.f16020a.tab_type.intValue());
                bundle.putString("tab_name", this.f16020a.tab_name);
                bundle.putInt("is_general_tab", this.f16020a.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.f16022c.n.isFrsVideoAutoPlay);
                bundle.putBoolean("need_log", this.f16022c.n.needLog == 1);
                bundle.putBoolean("is_brand_forum", this.f16022c.n.isBrandForum);
                bundle.putSerializable("view_data", this.f16022c.n);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                d.a.r0.e0.c cVar = new d.a.r0.e0.c();
                cVar.f55251a = frsCommonTabFragment;
                cVar.f55255e = this.f16021b;
                cVar.f55259i = d.a.r0.e0.c.k;
                return cVar;
            }
            return (d.a.r0.e0.c) invokeV.objValue;
        }

        @Override // d.a.r0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.r0.e0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.r0.e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f16023a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16024b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16025c;

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
            this.f16025c = frsTabViewController;
            this.f16023a = i2;
            this.f16024b = frsTabInfo;
        }

        @Override // d.a.r0.e0.b
        public d.a.r0.e0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.f16025c.f16012e.h());
                bundle.putString("from", this.f16025c.f16012e.u2());
                bundle.putString("forum_id", this.f16025c.f16012e.i());
                bundle.putInt("tab_id", this.f16023a);
                bundle.putInt("tab_type", this.f16024b.tab_type.intValue());
                bundle.putString("tab_name", this.f16024b.tab_name);
                bundle.putString(LowFlowsActivityConfig.TAB_CODE, this.f16024b.tab_code);
                bundle.putBoolean("need_log", this.f16025c.n.needLog == 1);
                bundle.putString("theme_color", this.f16025c.D);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.f16025c.f16012e.w2());
                frsItemTabFragment.setArguments(bundle);
                d.a.r0.e0.c cVar = new d.a.r0.e0.c();
                cVar.f55251a = frsItemTabFragment;
                cVar.f55255e = this.f16023a;
                cVar.f55259i = d.a.r0.e0.c.k;
                return cVar;
            }
            return (d.a.r0.e0.c) invokeV.objValue;
        }

        @Override // d.a.r0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.r0.e0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16026a;

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
            this.f16026a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384 && (customResponsedMessage.getData() instanceof d.a.s0.u0.k2.e)) {
                d.a.s0.u0.k2.e eVar = (d.a.s0.u0.k2.e) customResponsedMessage.getData();
                int i2 = -1;
                for (int i3 = 0; i3 < ListUtils.getCount(this.f16026a.m); i3++) {
                    if (this.f16026a.m.get(i3) != null && (this.f16026a.m.get(i3).f66232b == eVar.f66232b || this.f16026a.m.get(i3).f66235e == eVar.f66235e)) {
                        i2 = i3;
                        break;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                this.f16026a.j.setCurrentItem(i2, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16027e;

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
            this.f16027e = frsTabViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16027e.x.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16028a;

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
            this.f16028a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.s0.u0.g) || this.f16028a.y) {
                return;
            }
            this.f16028a.T();
            this.f16028a.y = true;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16029e;

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
            this.f16029e = frsTabViewController;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                d.a.s0.u0.k2.a aVar = new d.a.s0.u0.k2.a();
                aVar.f66229b = i2;
                aVar.f66230c = i3;
                CustomMessage customMessage = new CustomMessage(2921590);
                customMessage.setTag(this.f16029e.f16012e.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                a(this.f16029e.z() == null ? 0 : this.f16029e.z().f16043a, i2);
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
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f16029e.j == null) {
                return;
            }
            this.f16029e.j.d();
            if (ListUtils.isEmpty(this.f16029e.q) || this.f16029e.q.size() <= i2) {
                return;
            }
            o oVar = (o) ListUtils.getItem(this.f16029e.q, i2);
            if (oVar.f16043a == 506) {
                d.a.s0.u0.a2.h.a aVar = new d.a.s0.u0.a2.h.a(5);
                aVar.i(13);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, aVar));
            }
            if (oVar.f16044b instanceof r0) {
                z zVar = new z();
                zVar.f67234a = oVar.f16043a;
                zVar.f67235b = (r0) oVar.f16044b;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar));
            } else {
                z zVar2 = new z();
                zVar2.f67234a = oVar.f16043a;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar2));
            }
            a(oVar.f16043a, 0);
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16030a;

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
            this.f16030a = frsTabViewController;
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
                if (this.f16030a.n == null || this.f16030a.n.isShowRedTip() == booleanValue || this.f16030a.f16016i.getTabCount() <= 0 || ListUtils.isEmpty(this.f16030a.m)) {
                    return;
                }
                this.f16030a.n.setIsShowRedTip(booleanValue);
                int min = Math.min(this.f16030a.m.size(), this.f16030a.f16016i.getTabCount());
                for (int i2 = 0; i2 < min; i2++) {
                    TbTabLayout.f w = this.f16030a.f16016i.w(i2);
                    if (w != null) {
                        if (this.f16030a.m.get(i2).f66232b == 89) {
                            w.j(0, booleanValue);
                        } else {
                            w.j(0, false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16031a;

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
            this.f16031a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o z;
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
            if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (z = this.f16031a.z()) != null && (fragment = z.f16044b) != null && (fragment instanceof p0)) {
                ((p0) fragment).s();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16032a;

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
            this.f16032a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof j1)) {
                return;
            }
            j1 j1Var = (j1) customResponsedMessage.getData();
            if (this.f16032a.f16012e == null || !j1Var.c(this.f16032a.f16012e.i()) || this.f16032a.u == null) {
                return;
            }
            this.f16032a.u.c(j1Var);
        }
    }

    /* loaded from: classes5.dex */
    public class j extends d.a.r0.e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16033a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16034b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16035c;

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
            this.f16035c = frsTabViewController;
            this.f16033a = frsTabInfo;
            this.f16034b = i2;
        }

        @Override // d.a.r0.e0.b
        public d.a.r0.e0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                if (this.f16035c.f16012e != null && this.f16035c.f16012e.B0() != null) {
                    frsAllThreadFragment.I0(this.f16035c.f16012e.B0().T());
                    this.f16035c.f16012e.u3(d.a.s0.w0.a.e(this.f16033a, this.f16035c.n.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                if (this.f16035c.f16012e != null) {
                    bundle.putString("forum_id", this.f16035c.f16012e.i());
                }
                bundle.putInt("tab_id", this.f16034b);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                d.a.r0.e0.c cVar = new d.a.r0.e0.c();
                cVar.f55251a = frsAllThreadFragment;
                cVar.f55255e = 1;
                cVar.f55259i = d.a.r0.e0.c.k;
                return cVar;
            }
            return (d.a.r0.e0.c) invokeV.objValue;
        }

        @Override // d.a.r0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.r0.e0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k extends d.a.r0.e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16037b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16038c;

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
            this.f16038c = frsTabViewController;
            this.f16036a = frsTabInfo;
            this.f16037b = i2;
        }

        @Override // d.a.r0.e0.b
        public d.a.r0.e0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.s0.w0.a.e(this.f16036a, this.f16038c.n.showAdsense.intValue()));
                bundle.putString("name", this.f16038c.f16012e.h());
                bundle.putString("from", this.f16038c.f16012e.u2());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean(FrsActivityConfig.GOOD, true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.f16038c.f16012e.i());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                d.a.r0.e0.c cVar = new d.a.r0.e0.c();
                cVar.f55251a = frsGoodFragment;
                cVar.f55255e = this.f16037b;
                cVar.f55259i = d.a.r0.e0.c.k;
                return cVar;
            }
            return (d.a.r0.e0.c) invokeV.objValue;
        }

        @Override // d.a.r0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.r0.e0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l extends d.a.r0.e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16039a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16040b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16041c;

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
            this.f16041c = frsTabViewController;
            this.f16039a = frsTabInfo;
            this.f16040b = i2;
        }

        @Override // d.a.r0.e0.b
        public d.a.r0.e0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.s0.w0.a.e(this.f16039a, this.f16041c.n.showAdsense.intValue()));
                bundle.putString("name", this.f16041c.f16012e.h());
                bundle.putString("from", this.f16041c.f16012e.u2());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.f16041c.f16012e.i());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                d.a.r0.e0.c cVar = new d.a.r0.e0.c();
                cVar.f55251a = frsNewAreaFragment;
                cVar.f55255e = this.f16040b;
                cVar.f55259i = d.a.r0.e0.c.k;
                return cVar;
            }
            return (d.a.r0.e0.c) invokeV.objValue;
        }

        @Override // d.a.r0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.r0.e0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m extends d.a.r0.e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16042a;

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
            this.f16042a = frsTabViewController;
        }

        @Override // d.a.r0.e0.b
        public d.a.r0.e0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.f16042a.f16012e.h());
                bundle.putString("from", this.f16042a.f16012e.u2());
                bundle.putString("forum_id", this.f16042a.f16012e.i());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                d.a.r0.e0.c cVar = new d.a.r0.e0.c();
                cVar.f55251a = frsADFragment;
                cVar.f55255e = 90;
                cVar.f55259i = d.a.r0.e0.c.k;
                return cVar;
            }
            return (d.a.r0.e0.c) invokeV.objValue;
        }

        @Override // d.a.r0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.r0.e0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface n {
        void a(int i2, int i3, String str);
    }

    /* loaded from: classes5.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16043a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f16044b;

        /* renamed from: c  reason: collision with root package name */
        public String f16045c;

        /* renamed from: d  reason: collision with root package name */
        public int f16046d;

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
        this.f16012e = frsFragment;
        this.f16013f = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.f16015h = view.findViewById(R.id.frs_tab_bg);
        this.f16014g = view.findViewById(R.id.divider_shadow);
        this.l = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        TbTabLayout tbTabLayout = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.f16016i = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.f16016i.setSelectedTabTextBlod(true);
        this.f16016i.setTabTextSize(A(R.dimen.tbds42));
        d.a.s0.e0.e eVar = new d.a.s0.e0.e(frsFragment.getPageContext(), this.f16016i);
        this.x = eVar;
        eVar.g0(R.drawable.bg_tip_blue_up_left);
        this.x.O(16);
        this.x.h0(true);
        this.x.j0(A(R.dimen.tbds34));
        this.x.k0(A(R.dimen.tbds10));
        this.x.M(this.K);
        this.j = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.q = new ArrayList();
        this.p = new FragmentAdapter(this, this.f16012e.getActivity().getSupportFragmentManager(), this.q);
        this.j.addOnPageChangeListener(this.F);
        RelativeLayout relativeLayout = new RelativeLayout(this.f16012e.getContext());
        this.k = relativeLayout;
        this.s = new d.a.s0.u0.m1.f.a.b(frsFragment, relativeLayout);
        PublishProgressView publishProgressView = (PublishProgressView) view.findViewById(R.id.publish_progress_view);
        this.u = publishProgressView;
        publishProgressView.setVisibility(8);
    }

    public static boolean Q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    public final int A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Iterator<d.a.s0.u0.k2.e> it = this.m.iterator();
            while (it.hasNext()) {
                d.a.s0.u0.k2.e next = it.next();
                if (next != null && ((i2 = next.f66232b) == 1 || i2 == 503)) {
                    return next.f66232b;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.A : invokeV.intValue;
    }

    public View E() {
        InterceptResult invokeV;
        d.a.s0.u0.m1.f.a.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (M() || (bVar = this.s) == null) {
                return null;
            }
            return bVar.h();
        }
        return (View) invokeV.objValue;
    }

    public RelativeLayout F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (RelativeLayout) invokeV.objValue;
    }

    public o G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            for (o oVar : this.q) {
                if (oVar != null && oVar.f16043a == i2) {
                    return oVar;
                }
            }
            return null;
        }
        return (o) invokeI.objValue;
    }

    public d.a.s0.u0.k2.e H(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.m) != null && tabData.size() > 0) {
                Iterator<d.a.s0.u0.k2.e> it = this.m.iterator();
                while (it.hasNext()) {
                    d.a.s0.u0.k2.e next = it.next();
                    if (next.f66232b == i2) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (d.a.s0.u0.k2.e) invokeI.objValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : invokeV.intValue;
    }

    public FrsTabViewPager J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (FrsTabViewPager) invokeV.objValue;
    }

    public final void K(FrsViewData frsViewData) {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, frsViewData) == null) || frsViewData == null || (themeColorInfo = frsViewData.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        this.D = themeElement.light_color;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.x.I();
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            FrsViewData frsViewData = this.n;
            return frsViewData != null && frsViewData.getIsBrandForum();
        }
        return invokeV.booleanValue;
    }

    public final boolean N(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, frsTabInfo)) == null) ? frsTabInfo == null || (frsTabInfo.tab_type.intValue() == 0 && frsTabInfo.tab_id.intValue() >= 100) || ((frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) || (frsTabInfo.tab_type.intValue() == 11 && !Q(frsTabInfo.tab_id.intValue()))) : invokeL.booleanValue;
    }

    public final boolean O(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            U(tabData);
            if (ListUtils.isEmpty(this.p.f16018b) || tabData.size() != this.p.f16018b.size()) {
                return true;
            }
            int size = tabData.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (tabData.get(i2) != null && this.p.f16018b.get(i2) != null && tabData.get(i2).f66232b != ((o) this.p.f16018b.get(i2)).f16043a) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean P(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            return (!ListUtils.isEmpty(this.m) && tabData.size() == this.m.size() && this.m.containsAll(tabData)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final boolean R(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, frsTabInfo)) == null) ? frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim()) || !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 92 || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 17) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4 : invokeL.booleanValue;
    }

    public void S(int i2) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f16014g, R.drawable.personalize_tab_shadow);
            W();
            if (this.f16016i != null) {
                ThemeColorInfo themeColorInfo = this.o;
                if (themeColorInfo != null) {
                    ThemeElement themeElement = themeColorInfo.dark;
                    if (themeElement != null && i2 == 4) {
                        color = d.a.s0.n1.o.k.b.b(themeElement.font_color);
                    } else {
                        ThemeElement themeElement2 = this.o.night;
                        if (themeElement2 != null && i2 == 1) {
                            color = d.a.s0.n1.o.k.b.b(themeElement2.font_color);
                        } else {
                            ThemeElement themeElement3 = this.o.day;
                            if (themeElement3 != null && i2 == 0) {
                                color = d.a.s0.n1.o.k.b.b(themeElement3.font_color);
                            } else {
                                color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                            }
                        }
                    }
                } else {
                    color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                }
                this.f16016i.setSelectedTabIndicatorColor(color);
                this.f16016i.setSelectedIndicatorBottomMargin(A(R.dimen.tbds11));
                SkinManager.setBackgroundColor(this.f16016i, R.color.transparent);
                this.f16016i.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            }
            if (this.s != null && !M()) {
                this.s.i();
            }
            LinearGradientView linearGradientView = this.l;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            if (!ListUtils.isEmpty(this.q)) {
                for (o oVar : this.q) {
                    if (oVar != null) {
                        Fragment fragment = oVar.f16044b;
                        if (fragment instanceof BaseFragment) {
                            ((BaseFragment) fragment).changeSkinType(i2);
                        }
                    }
                }
            }
            K(this.n);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921591, this.D));
        }
    }

    public final void T() {
        d.a.s0.u0.g gVar;
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (gVar = this.r) == null) {
            return;
        }
        List<d.a.r0.e0.b> f2 = gVar.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.m)) {
            return;
        }
        if (this.f16016i.getTabCount() > 0) {
            this.f16016i.B();
        }
        Y();
        ArrayList arrayList = new ArrayList();
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ThemeColorInfo themeColorInfo = this.o;
        if (themeColorInfo != null) {
            ThemeElement themeElement = themeColorInfo.dark;
            if (themeElement != null && skinType == 4) {
                color = d.a.s0.n1.o.k.b.b(themeElement.font_color);
            } else {
                ThemeElement themeElement2 = this.o.night;
                if (themeElement2 != null && skinType == 1) {
                    color = d.a.s0.n1.o.k.b.b(themeElement2.font_color);
                } else {
                    ThemeElement themeElement3 = this.o.day;
                    if (themeElement3 != null && skinType == 0) {
                        color = d.a.s0.n1.o.k.b.b(themeElement3.font_color);
                    } else {
                        color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                    }
                }
            }
        } else {
            color = SkinManager.getColor(R.color.plugin_button_shadow_red);
        }
        this.f16016i.setSelectedTabIndicatorColor(color);
        this.f16016i.setSelectedIndicatorBottomMargin(A(R.dimen.tbds10));
        Iterator<d.a.s0.u0.k2.e> it = this.m.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            d.a.s0.u0.k2.e next = it.next();
            Fragment x = x(next.f66232b, f2);
            if (x != null) {
                TbTabLayout.f z = this.f16016i.z();
                z.s(next.f66231a);
                if (next.f66232b == 1 && i3 < 0) {
                    i3 = i4;
                }
                boolean z2 = this.n.defaultShowTab == next.f66232b;
                if (z2 && i2 < 0) {
                    i2 = i4;
                }
                if (!FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.f16012e.u2()) ? !(!FrsActivityConfig.FRS_FROM_ITEM.equals(this.f16012e.u2()) || 506 != next.f66232b) : 3 == next.f66235e) {
                    i2 = i4;
                }
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.f66232b == 89) {
                    z.j(0, true);
                } else {
                    z.j(0, false);
                }
                this.f16016i.f(z, z2);
                o oVar = new o(this);
                oVar.f16043a = next.f66232b;
                oVar.f16045c = next.f66231a;
                oVar.f16044b = x;
                oVar.f16046d = next.f66235e;
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
        if (this.p == null) {
            this.p = new FragmentAdapter(this, this.f16012e.getActivity().getSupportFragmentManager(), this.q);
        }
        this.j.setAdapter(this.p);
        this.p.notifyDataSetChanged();
        if (this.f16016i.getTabCount() > 0 && this.f16013f.getVisibility() != 0) {
            this.f16013f.setVisibility(0);
        }
        this.f16016i.setupWithViewPager(this.j);
        this.j.setOffscreenPageLimit(this.q.size());
        this.j.setCurrentItem(i2, false);
        this.j.d();
    }

    public final void U(TabData tabData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, tabData) == null) || ListUtils.isEmpty(tabData)) {
            return;
        }
        boolean isRegistedIntent = TbadkCoreApplication.getInst().isRegistedIntent(HotRanklistActivityConfig.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            d.a.s0.u0.k2.e eVar = (d.a.s0.u0.k2.e) it.next();
            if (eVar != null && eVar.f66232b == 401 && !isRegistedIntent) {
                arrayList.add(eVar);
            }
        }
        tabData.removeAll(arrayList);
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PublishProgressView publishProgressView = this.u;
            return publishProgressView != null && publishProgressView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int i2 = this.v;
            if (i2 == 2) {
                SkinManager.setBackgroundColor(this.f16013f, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.f16015h, R.color.CAM_X0207);
                this.f16014g.setVisibility(0);
                this.f16012e.L2();
            } else if (i2 == 1) {
                SkinManager.setBackgroundColor(this.f16013f, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.f16015h, R.color.CAM_X0207);
                this.f16014g.setVisibility(0);
            } else {
                s();
                this.f16014g.setVisibility(8);
                FrsFragment frsFragment = this.f16012e;
                if (frsFragment != null) {
                    frsFragment.L2();
                }
            }
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.E.setPriority(Integer.MAX_VALUE);
            this.f16012e.registerListener(this.E);
            this.f16012e.registerListener(this.G);
            FrsFragment frsFragment = this.f16012e;
            frsFragment.registerListener(2001446, this.H, frsFragment.getBaseFragmentActivity().getUniqueId());
            this.f16012e.registerListener(this.J);
            this.f16012e.registerListener(this.I);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.j == null || this.p == null || this.q == null) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = this.f16012e.getActivity().getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                o oVar = this.q.get(i2);
                if (oVar != null && oVar.f16044b != null) {
                    beginTransaction.remove(oVar.f16044b);
                }
            }
            beginTransaction.commit();
            supportFragmentManager.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            int i2 = !ListUtils.isEmpty(this.m) ? this.m.get(0).f66232b : -1;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null) {
                frsViewData.mHeadLineDefaultNavTabId = i2;
            }
            FrsFragment frsFragment = this.f16012e;
            if (frsFragment != null) {
                frsFragment.P0 = i2;
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        d.a.s0.u0.k2.e eVar;
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(eVar.f66232b)));
        TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f16012e.p).param("tab_id", eVar.f66232b));
        if (d.a.c.e.p.j.A() && eVar.f66232b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
            this.n.setIsShowRedTip(false);
            fVar.j(0, false);
        }
    }

    public final void a0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
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

    @Override // d.a.s0.u0.o2.n
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
                    } else if (this.m.get(i4).f66232b == i2) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 >= 0 && i3 < this.f16016i.getTabCount()) {
                    TbTabLayout.f w = this.f16016i.w(i3);
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

    public void b0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, nVar) == null) {
            this.t = nVar;
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
            L();
            FrsFragment frsFragment = this.f16012e;
            if (frsFragment == null || frsFragment.Q() == null) {
                return;
            }
            this.f16012e.Q().y();
        }
    }

    public void c0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
        }
    }

    @Override // d.a.s0.u0.o2.n
    public void d(FrsViewData frsViewData, int i2) {
        AccountData currentAccountObj;
        List<b0> list;
        List<b0> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048607, this, frsViewData, i2) == null) || frsViewData == null || frsViewData.getEntelechyTabInfo() == null || frsViewData.getEntelechyTabInfo().tab == null) {
            return;
        }
        K(frsViewData);
        TabData tabData = new TabData();
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().tab) {
            if (!R(frsTabInfo) && !N(frsTabInfo)) {
                if (frsTabInfo.is_general_tab.intValue() != 1 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_id.intValue() != 506) {
                    if (frsTabInfo.tab_id.intValue() != 89 && frsTabInfo.tab_id.intValue() != 503) {
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            d.a.s0.u0.k2.e eVar = new d.a.s0.u0.k2.e();
                            eVar.f66232b = frsTabInfo.tab_id.intValue();
                            eVar.f66231a = frsTabInfo.tab_name;
                            eVar.f66235e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                d.a.s0.u0.k2.e eVar2 = new d.a.s0.u0.k2.e();
                                eVar2.f66232b = frsTabInfo.tab_id.intValue();
                                eVar2.f66231a = frsTabInfo.tab_name;
                                eVar2.f66235e = frsTabInfo.tab_type.intValue();
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
                                eVar2.f66234d = sb2;
                                a0(sb2, "c10078");
                                tabData.add(eVar2);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && Q(frsTabInfo.tab_id.intValue())) {
                            d.a.s0.u0.k2.e eVar3 = new d.a.s0.u0.k2.e();
                            eVar3.f66232b = frsTabInfo.tab_id.intValue();
                            eVar3.f66231a = frsTabInfo.tab_name;
                            eVar3.f66234d = frsTabInfo.tab_url;
                            eVar3.f66235e = frsTabInfo.tab_type.intValue();
                            if (d.a.r0.l.c.f(eVar3.f66234d)) {
                                if (MessageManager.getInstance().findTask(2016447) != null) {
                                    tabData.add(eVar3);
                                    arrayList.add(frsTabInfo);
                                }
                            } else {
                                tabData.add(eVar3);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && f0.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            d.a.s0.u0.k2.e eVar4 = new d.a.s0.u0.k2.e();
                            eVar4.f66232b = frsTabInfo.tab_id.intValue();
                            eVar4.f66231a = frsTabInfo.tab_name;
                            eVar4.f66235e = frsTabInfo.tab_type.intValue();
                            d0 b2 = c0.a().b(eVar4.f66232b);
                            if (b2 != null && (list2 = b2.f65829b) != null && list2.size() > 0) {
                                e1 e1Var = new e1();
                                eVar4.f66233c = e1Var;
                                e1Var.f65836a = b2.f65828a;
                                e1Var.f65837b = new LinkedList();
                                boolean z = true;
                                for (b0 b0Var : b2.f65829b) {
                                    if (b0Var != null) {
                                        d1 d1Var = new d1();
                                        d1Var.f65830a = b0Var.f65786a;
                                        d1Var.f65831b = b0Var.f65787b;
                                        if (z) {
                                            d1Var.f65832c = true;
                                            z = false;
                                        }
                                        eVar4.f66233c.f65837b.add(d1Var);
                                    }
                                }
                            }
                            tabData.add(eVar4);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            d.a.s0.u0.k2.e eVar5 = new d.a.s0.u0.k2.e();
                            eVar5.f66232b = frsTabInfo.tab_id.intValue();
                            eVar5.f66231a = frsTabInfo.tab_name;
                            eVar5.f66235e = frsTabInfo.tab_type.intValue();
                            d0 b3 = c0.a().b(eVar5.f66232b);
                            if (b3 != null && (list = b3.f65829b) != null && list.size() > 0) {
                                e1 e1Var2 = new e1();
                                eVar5.f66233c = e1Var2;
                                e1Var2.f65836a = b3.f65828a;
                                e1Var2.f65837b = new LinkedList();
                                for (b0 b0Var2 : b3.f65829b) {
                                    if (b0Var2 != null) {
                                        d1 d1Var2 = new d1();
                                        d1Var2.f65830a = b0Var2.f65786a;
                                        d1Var2.f65831b = b0Var2.f65787b;
                                        eVar5.f66233c.f65837b.add(d1Var2);
                                    }
                                }
                            }
                            tabData.add(eVar5);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 49) {
                            if (this.f16012e.B0().V().k(b2.m3)) {
                                d.a.s0.u0.k2.e eVar6 = new d.a.s0.u0.k2.e();
                                eVar6.f66231a = frsTabInfo.tab_name;
                                if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                    eVar6.f66231a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                int i3 = this.w;
                                if (i3 > 0 && i3 != frsViewData.getAlaLiveCount() && this.w <= 99) {
                                    eVar6.f66231a = frsTabInfo.tab_name + "(" + this.w + SmallTailInfo.EMOTION_SUFFIX;
                                } else if (this.w <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                    int i4 = this.w;
                                    if (i4 == 0 && i4 != frsViewData.getAlaLiveCount()) {
                                        eVar6.f66231a = frsTabInfo.tab_name;
                                    }
                                } else {
                                    eVar6.f66231a = frsTabInfo.tab_name + "(99+)";
                                }
                                eVar6.f66232b = frsTabInfo.tab_id.intValue();
                                eVar6.f66235e = frsTabInfo.tab_type.intValue();
                                tabData.add(eVar6);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() == 1120) {
                            d.a.s0.u0.k2.e eVar7 = new d.a.s0.u0.k2.e();
                            eVar7.f66232b = frsTabInfo.tab_id.intValue();
                            eVar7.f66231a = frsTabInfo.tab_name;
                            eVar7.f66235e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar7);
                            arrayList.add(frsTabInfo);
                            v(2);
                        } else if (frsTabInfo.tab_id.intValue() == 90) {
                            d.a.s0.u0.k2.e eVar8 = new d.a.s0.u0.k2.e();
                            eVar8.f66232b = frsTabInfo.tab_id.intValue();
                            eVar8.f66231a = frsTabInfo.tab_name;
                            eVar8.f66235e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar8);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 91) {
                            d.a.s0.u0.k2.e eVar9 = new d.a.s0.u0.k2.e();
                            eVar9.f66232b = frsTabInfo.tab_id.intValue();
                            eVar9.f66231a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
                            eVar9.f66235e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar9);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 504) {
                            d.a.s0.u0.k2.e eVar10 = new d.a.s0.u0.k2.e();
                            eVar10.f66232b = frsTabInfo.tab_id.intValue();
                            eVar10.f66231a = frsTabInfo.tab_name;
                            eVar10.f66235e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar10);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 3) {
                            d.a.s0.u0.k2.e eVar11 = new d.a.s0.u0.k2.e();
                            eVar11.f66232b = frsTabInfo.tab_id.intValue();
                            eVar11.f66231a = frsTabInfo.tab_name;
                            eVar11.f66235e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar11);
                            arrayList.add(frsTabInfo);
                            v(1);
                        }
                    } else {
                        d.a.s0.u0.k2.e eVar12 = new d.a.s0.u0.k2.e();
                        eVar12.f66232b = frsTabInfo.tab_id.intValue();
                        eVar12.f66231a = frsTabInfo.tab_name;
                        eVar12.f66235e = frsTabInfo.tab_type.intValue();
                        tabData.add(eVar12);
                        arrayList.add(frsTabInfo);
                        if (frsTabInfo.tab_id.intValue() == 503) {
                            String str = "";
                            String str2 = TbadkCoreApplication.getCurrentAccountObj() != null ? currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR : "";
                            if (frsViewData.getForum() != null && frsViewData.getForum().getName() != null) {
                                str = frsViewData.getForum().getName();
                            }
                            int h2 = d.a.s0.u0.n2.k.h("503~" + str2 + str);
                            if (h2 == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            d.a.s0.u0.n2.k.i("503~" + str2 + str, next.tab_id.intValue());
                                            if (7 == h2) {
                                                d.a.s0.h3.n0.e.b();
                                            } else {
                                                d.a.s0.h3.n0.e.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    d.a.s0.u0.k2.e eVar13 = new d.a.s0.u0.k2.e();
                    eVar13.f66231a = frsTabInfo.tab_name;
                    eVar13.f66232b = frsTabInfo.tab_id.intValue();
                    eVar13.f66235e = frsTabInfo.tab_type.intValue();
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
        if (!P(tabData) && this.f16016i.getTabCount() > 0 && !ListUtils.isEmpty(this.m)) {
            int min = Math.min(this.m.size(), this.f16016i.getTabCount());
            for (int i5 = 0; i5 < min; i5++) {
                TbTabLayout.f w = this.f16016i.w(i5);
                if (w != null) {
                    if (frsViewData.isShowRedTip() && this.m.get(i5).f66232b == 89) {
                        w.j(0, true);
                    } else {
                        w.j(0, false);
                    }
                }
            }
        }
        if (frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> u = u(frsViewData);
            if (M()) {
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(u, 0);
                FrsFragment frsFragment = this.f16012e;
                if (frsFragment != null && frsFragment.d0() != null && frsTabInfo2 != null) {
                    this.f16012e.d0().J0(frsTabInfo2.tab_id.intValue());
                }
            } else {
                FrsFragment frsFragment2 = this.f16012e;
                if (frsFragment2 != null && frsFragment2.A2() != null) {
                    if (u != null && u.size() < 2) {
                        this.f16012e.A2().removeHeaderView(this.k);
                    } else {
                        this.f16012e.A2().removeHeaderView(this.k);
                        this.f16012e.A2().s(this.k);
                        if (this.s != null && frsViewData.getForum() != null) {
                            this.s.j(u);
                            this.s.k(frsViewData.getForum().getId());
                            this.s.g(this.f16012e.d0().R());
                            if (d.a.r0.b.d.n() && d.a.r0.b.g.a.f54805c != d.a.r0.b.g.a.d()) {
                                this.s.g(d.a.r0.b.g.a.d());
                            }
                        }
                    }
                }
            }
        }
        if (O(tabData)) {
            this.m = tabData;
            Z();
            f0(arrayList);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.f16016i.setDisableTabSelect(z);
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
            if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > e2 && this.q.get(e2) != null && (this.q.get(e2).f16044b instanceof BaseFragment)) {
                customMessage.setTag(((BaseFragment) this.q.get(e2).f16044b).getUniqueId());
                customResponsedMessage.setOrginalMessage(customMessage);
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            d.a.s0.u0.k2.e eVar = this.m.get(e2);
            if (eVar != null) {
                this.A = eVar.f66232b;
                if (d.a.c.e.p.j.A() && eVar.f66232b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
                    this.n.setIsShowRedTip(false);
                    fVar.j(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(eVar.f66232b)));
                }
                if (eVar.f66232b == 502) {
                    if (this.f16012e.H2() != null) {
                        this.f16012e.H2().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.f16012e.H2() != null) {
                    this.f16012e.H2().setIconFade(0);
                }
                if (d.a.r0.b.d.r()) {
                    d.a.r0.b.g.a.g(eVar.f66231a);
                }
                n nVar = this.t;
                if (nVar != null) {
                    nVar.a(eVar.f66232b, eVar.f66235e, eVar.f66231a);
                }
                d.a.s0.u0.b.e().p(eVar.f66235e == 14);
                d.a.s0.u0.a.h().o(eVar.f66232b);
                TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f16012e.p).param("tab_id", eVar.f66232b));
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.x.m0(this.f16012e.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
        }
    }

    @Override // d.a.s0.u0.o2.n
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.v = i2;
            W();
        }
    }

    public final void f0(List<FrsTabInfo> list) {
        FrsFragment frsFragment;
        View T;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        d.a.s0.u0.g gVar = new d.a.s0.u0.g(this.f16012e.getActivity().getApplicationContext(), list);
        this.r = gVar;
        gVar.i(this.f16012e.i());
        this.r.j(this.f16012e.h());
        this.r.k(this.f16012e.u2());
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.r.g(this.n.getForum().getFirst_class());
            this.r.l(this.n.getForum().getSecond_class());
            this.r.h(this.n.getForum().getForumGameLabel());
        }
        int i2 = 0;
        for (FrsTabInfo frsTabInfo : list) {
            if (i2 == 0) {
                w(frsTabInfo.tab_id.intValue(), 1);
            }
            if (frsTabInfo.tab_type.intValue() == 3) {
                v(1);
            }
            i2++;
            d.a.r0.e0.b y = y(frsTabInfo);
            if (y != null) {
                this.r.a(y);
            }
        }
        if (list.get(0) != null && list.get(0).tab_id.intValue() != 1 && (frsFragment = this.f16012e) != null && frsFragment.B0() != null && (T = this.f16012e.B0().T()) != null && (T.getParent() instanceof ViewGroup)) {
            ((ViewGroup) T.getParent()).removeView(T);
        }
        this.y = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.r));
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.w = i2;
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            SkinManager.setBackgroundColor(this.f16015h, R.color.CAM_X0205);
            this.f16015h.setAlpha(0.0f);
            d.a.r0.r.u.c.d(this.f16013f).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
        }
    }

    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.B != z) {
                this.B = z;
            }
            if (this.C != z2) {
                this.C = z2;
            }
            s();
        }
    }

    public final List<FrsTabInfo> u(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
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
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().menu) {
                if (frsTabInfo.tab_type.intValue() == i2) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13971").param("fid", this.f16012e.p).param("fname", this.f16012e.h()).param("obj_locate", i2));
        }
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048618, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f16012e.i());
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

    public final Fragment x(int i2, List<d.a.r0.e0.b> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048619, this, i2, list)) == null) {
            for (d.a.r0.e0.b bVar : list) {
                Bundle arguments = bVar.getFragmentTabStructure().f55251a.getArguments();
                if (arguments != null && i2 == bVar.getFragmentTabStructure().f55255e && !arguments.getBoolean("isAdded")) {
                    arguments.putBoolean("isAdded", true);
                    bVar.getFragmentTabStructure().f55251a.setArguments(arguments);
                    return bVar.getFragmentTabStructure().f55251a;
                }
            }
            return null;
        }
        return (Fragment) invokeIL.objValue;
    }

    public final d.a.r0.e0.b y(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, frsTabInfo)) == null) {
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
            if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 3) {
                return new a(this, frsTabInfo, intValue);
            }
            if (intValue == 506) {
                return new b(this, intValue, frsTabInfo);
            }
            return null;
        }
        return (d.a.r0.e0.b) invokeL.objValue;
    }

    public o z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            FrsTabViewPager frsTabViewPager = this.j;
            if (frsTabViewPager == null) {
                return null;
            }
            return (o) ListUtils.getItem(this.q, frsTabViewPager.getCurrentItem());
        }
        return (o) invokeV.objValue;
    }
}
