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
import c.a.q0.s.q.d2;
import c.a.q0.s.q.l1;
import c.a.r0.x0.b0;
import c.a.r0.x0.c0;
import c.a.r0.x0.d0;
import c.a.r0.x0.d1;
import c.a.r0.x0.e1;
import c.a.r0.x0.f0;
import c.a.r0.x0.p0;
import c.a.r0.x0.r0;
import c.a.r0.x0.z;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class FrsTabViewController implements c.a.r0.x0.o2.n, TbTabLayout.c {
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
    public FrsFragment f51649e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f51650f;

    /* renamed from: g  reason: collision with root package name */
    public View f51651g;

    /* renamed from: h  reason: collision with root package name */
    public View f51652h;

    /* renamed from: i  reason: collision with root package name */
    public TbTabLayout f51653i;

    /* renamed from: j  reason: collision with root package name */
    public FrsTabViewPager f51654j;
    public RelativeLayout k;
    public LinearGradientView l;
    public TabData m;
    public FrsViewData n;
    public ThemeColorInfo o;
    public FragmentAdapter p;
    public List<o> q;
    public c.a.r0.x0.g r;
    public c.a.r0.x0.n1.f.a.b s;
    public n t;
    public PublishProgressView u;
    public int v;
    public int w;
    public c.a.r0.f0.e x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f51655a;

        /* renamed from: b  reason: collision with root package name */
        public List<o> f51656b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51657c;

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
            this.f51657c = frsTabViewController;
            this.f51655a = -1;
            this.f51656b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51656b.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f51656b.get(i2).f51682b : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f51656b.get(i2).f51683c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                if (obj == null || (i3 = this.f51655a) == i2) {
                    return;
                }
                if (i3 != -1 && i3 < getCount()) {
                    BaseFragment baseFragment = (BaseFragment) getItem(this.f51655a);
                    if (baseFragment instanceof FrsAllThreadFragment) {
                        this.f51657c.f51649e.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.f51655a = i2;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        this.f51657c.f51649e.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends c.a.q0.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f51658a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f51659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51660c;

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
            this.f51660c = frsTabViewController;
            this.f51658a = frsTabInfo;
            this.f51659b = i2;
        }

        @Override // c.a.q0.h0.b
        public c.a.q0.h0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, c.a.r0.z0.a.e(this.f51658a, this.f51660c.n.showAdsense.intValue()));
                bundle.putString("name", this.f51660c.f51649e.getForumName());
                bundle.putString("from", this.f51660c.f51649e.getFrom());
                bundle.putString("forum_id", this.f51660c.f51649e.getForumId());
                bundle.putInt("tab_id", this.f51659b);
                bundle.putInt("tab_type", this.f51658a.tab_type.intValue());
                bundle.putString("tab_name", this.f51658a.tab_name);
                bundle.putInt(FrsCommonTabFragment.IS_GENERAL_TAB, this.f51658a.is_general_tab.intValue());
                bundle.putBoolean(FrsCommonTabFragment.CAN_AUTO_PLAY_VIDEO, this.f51660c.n.isFrsVideoAutoPlay);
                bundle.putBoolean(FrsCommonTabFragment.NEED_LOG, this.f51660c.n.needLog == 1);
                bundle.putBoolean(FrsCommonTabFragment.IS_BRAND_FORUM, this.f51660c.n.isBrandForum);
                bundle.putSerializable(FrsCommonTabFragment.VIEW_DATA, this.f51660c.n);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                c.a.q0.h0.c cVar = new c.a.q0.h0.c();
                cVar.f13471a = frsCommonTabFragment;
                cVar.f13475e = this.f51659b;
                cVar.f13479i = c.a.q0.h0.c.k;
                return cVar;
            }
            return (c.a.q0.h0.c) invokeV.objValue;
        }

        @Override // c.a.q0.h0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.q0.h0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.q0.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f51661a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f51662b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51663c;

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
            this.f51663c = frsTabViewController;
            this.f51661a = i2;
            this.f51662b = frsTabInfo;
        }

        @Override // c.a.q0.h0.b
        public c.a.q0.h0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.f51663c.f51649e.getForumName());
                bundle.putString("from", this.f51663c.f51649e.getFrom());
                bundle.putString("forum_id", this.f51663c.f51649e.getForumId());
                bundle.putInt("tab_id", this.f51661a);
                bundle.putInt("tab_type", this.f51662b.tab_type.intValue());
                bundle.putString("tab_name", this.f51662b.tab_name);
                bundle.putString("tab_code", this.f51662b.tab_code);
                bundle.putBoolean(FrsCommonTabFragment.NEED_LOG, this.f51663c.n.needLog == 1);
                bundle.putString(FrsCommonTabFragment.THEME_COLOR, this.f51663c.D);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.f51663c.f51649e.getFrsCallFromByItemPosition());
                frsItemTabFragment.setArguments(bundle);
                c.a.q0.h0.c cVar = new c.a.q0.h0.c();
                cVar.f13471a = frsItemTabFragment;
                cVar.f13475e = this.f51661a;
                cVar.f13479i = c.a.q0.h0.c.k;
                return cVar;
            }
            return (c.a.q0.h0.c) invokeV.objValue;
        }

        @Override // c.a.q0.h0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.q0.h0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51664a;

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
            this.f51664a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384 && (customResponsedMessage.getData() instanceof c.a.r0.x0.l2.e)) {
                c.a.r0.x0.l2.e eVar = (c.a.r0.x0.l2.e) customResponsedMessage.getData();
                int i2 = -1;
                for (int i3 = 0; i3 < ListUtils.getCount(this.f51664a.m); i3++) {
                    if (this.f51664a.m.get(i3) != null && (this.f51664a.m.get(i3).f27196b == eVar.f27196b || this.f51664a.m.get(i3).f27199e == eVar.f27199e)) {
                        i2 = i3;
                        break;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                this.f51664a.f51654j.setCurrentItem(i2, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51665e;

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
            this.f51665e = frsTabViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51665e.x.I();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51666a;

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
            this.f51666a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.r0.x0.g) || this.f51666a.y) {
                return;
            }
            this.f51666a.U();
            this.f51666a.y = true;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51667e;

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
            this.f51667e = frsTabViewController;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                c.a.r0.x0.l2.a aVar = new c.a.r0.x0.l2.a();
                aVar.f27193b = i2;
                aVar.f27194c = i3;
                CustomMessage customMessage = new CustomMessage(2921590);
                customMessage.setTag(this.f51667e.f51649e.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                a(this.f51667e.z() == null ? 0 : this.f51667e.z().f51681a, i2);
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
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f51667e.f51654j == null) {
                return;
            }
            this.f51667e.f51654j.notifyFrsTabViewPagerStatus();
            if (ListUtils.isEmpty(this.f51667e.q) || this.f51667e.q.size() <= i2) {
                return;
            }
            o oVar = (o) ListUtils.getItem(this.f51667e.q, i2);
            if (oVar.f51681a == 506) {
                c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(5);
                bVar.l(13);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
            if (oVar.f51684d == 100) {
                TiebaStatic.log(new StatisticItem("c13008").param("obj_type", 16));
            }
            if (oVar.f51682b instanceof r0) {
                z zVar = new z();
                zVar.f28240a = oVar.f51681a;
                zVar.f28241b = (r0) oVar.f51682b;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar));
            } else {
                z zVar2 = new z();
                zVar2.f28240a = oVar.f51681a;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar2));
            }
            a(oVar.f51681a, 0);
            this.f51667e.f51649e.getWriteIcon().setVisibility(this.f51667e.f51649e.canShowWriteButton(oVar.f51681a) ? 0 : 8);
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51668a;

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
            this.f51668a = frsTabViewController;
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
                if (this.f51668a.n == null || this.f51668a.n.isShowRedTip() == booleanValue || this.f51668a.f51653i.getTabCount() <= 0 || ListUtils.isEmpty(this.f51668a.m)) {
                    return;
                }
                this.f51668a.n.setIsShowRedTip(booleanValue);
                int min = Math.min(this.f51668a.m.size(), this.f51668a.f51653i.getTabCount());
                for (int i2 = 0; i2 < min; i2++) {
                    TbTabLayout.f tabAt = this.f51668a.f51653i.getTabAt(i2);
                    if (tabAt != null) {
                        if (this.f51668a.m.get(i2).f27196b == 89) {
                            tabAt.j(0, booleanValue);
                        } else {
                            tabAt.j(0, false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51669a;

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
            this.f51669a = frsTabViewController;
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
            if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (z = this.f51669a.z()) != null && (fragment = z.f51682b) != null && (fragment instanceof p0)) {
                ((p0) fragment).forceRefresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51670a;

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
            this.f51670a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l1 l1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof l1) || (l1Var = (l1) customResponsedMessage.getData()) == null || c.a.r0.k3.r0.g.j().r() || this.f51670a.f51649e == null || !l1Var.c(this.f51670a.f51649e.getForumId()) || this.f51670a.u == null) {
                return;
            }
            this.f51670a.u.updateCurProgressData(l1Var);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends c.a.q0.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f51671a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f51672b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51673c;

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
            this.f51673c = frsTabViewController;
            this.f51671a = frsTabInfo;
            this.f51672b = i2;
        }

        @Override // c.a.q0.h0.b
        public c.a.q0.h0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                if (this.f51673c.f51649e != null && this.f51673c.f51649e.getFrsView() != null) {
                    frsAllThreadFragment.setView(this.f51673c.f51649e.getFrsView().U());
                    this.f51673c.f51649e.setShowAdFlag(c.a.r0.z0.a.e(this.f51671a, this.f51673c.n.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                if (this.f51673c.f51649e != null) {
                    bundle.putString("forum_id", this.f51673c.f51649e.getForumId());
                }
                bundle.putInt("tab_id", this.f51672b);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                c.a.q0.h0.c cVar = new c.a.q0.h0.c();
                cVar.f13471a = frsAllThreadFragment;
                cVar.f13475e = 1;
                cVar.f13479i = c.a.q0.h0.c.k;
                return cVar;
            }
            return (c.a.q0.h0.c) invokeV.objValue;
        }

        @Override // c.a.q0.h0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.q0.h0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k extends c.a.q0.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f51674a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f51675b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51676c;

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
            this.f51676c = frsTabViewController;
            this.f51674a = frsTabInfo;
            this.f51675b = i2;
        }

        @Override // c.a.q0.h0.b
        public c.a.q0.h0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, c.a.r0.z0.a.e(this.f51674a, this.f51676c.n.showAdsense.intValue()));
                bundle.putString("name", this.f51676c.f51649e.getForumName());
                bundle.putString("from", this.f51676c.f51649e.getFrom());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean("good", true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.f51676c.f51649e.getForumId());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                c.a.q0.h0.c cVar = new c.a.q0.h0.c();
                cVar.f13471a = frsGoodFragment;
                cVar.f13475e = this.f51675b;
                cVar.f13479i = c.a.q0.h0.c.k;
                return cVar;
            }
            return (c.a.q0.h0.c) invokeV.objValue;
        }

        @Override // c.a.q0.h0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.q0.h0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l extends c.a.q0.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f51677a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f51678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51679c;

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
            this.f51679c = frsTabViewController;
            this.f51677a = frsTabInfo;
            this.f51678b = i2;
        }

        @Override // c.a.q0.h0.b
        public c.a.q0.h0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, c.a.r0.z0.a.e(this.f51677a, this.f51679c.n.showAdsense.intValue()));
                bundle.putString("name", this.f51679c.f51649e.getForumName());
                bundle.putString("from", this.f51679c.f51649e.getFrom());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.f51679c.f51649e.getForumId());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                c.a.q0.h0.c cVar = new c.a.q0.h0.c();
                cVar.f13471a = frsNewAreaFragment;
                cVar.f13475e = this.f51678b;
                cVar.f13479i = c.a.q0.h0.c.k;
                return cVar;
            }
            return (c.a.q0.h0.c) invokeV.objValue;
        }

        @Override // c.a.q0.h0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.q0.h0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m extends c.a.q0.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f51680a;

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
            this.f51680a = frsTabViewController;
        }

        @Override // c.a.q0.h0.b
        public c.a.q0.h0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.f51680a.f51649e.getForumName());
                bundle.putString("from", this.f51680a.f51649e.getFrom());
                bundle.putString("forum_id", this.f51680a.f51649e.getForumId());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                c.a.q0.h0.c cVar = new c.a.q0.h0.c();
                cVar.f13471a = frsADFragment;
                cVar.f13475e = 90;
                cVar.f13479i = c.a.q0.h0.c.k;
                return cVar;
            }
            return (c.a.q0.h0.c) invokeV.objValue;
        }

        @Override // c.a.q0.h0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // c.a.q0.h0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface n {
        void a(int i2, int i3, String str);
    }

    /* loaded from: classes7.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f51681a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f51682b;

        /* renamed from: c  reason: collision with root package name */
        public String f51683c;

        /* renamed from: d  reason: collision with root package name */
        public int f51684d;

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
        this.f51649e = frsFragment;
        this.f51650f = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.f51652h = view.findViewById(R.id.frs_tab_bg);
        this.f51651g = view.findViewById(R.id.divider_shadow);
        this.l = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        TbTabLayout tbTabLayout = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.f51653i = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.f51653i.setSelectedTabTextBlod(true);
        this.f51653i.setTabTextSize(A(R.dimen.tbds42));
        c.a.r0.f0.e eVar = new c.a.r0.f0.e(frsFragment.getPageContext(), this.f51653i);
        this.x = eVar;
        eVar.g0(R.drawable.bg_tip_blue_up_left);
        this.x.O(16);
        this.x.h0(true);
        this.x.j0(A(R.dimen.tbds34));
        this.x.k0(A(R.dimen.tbds10));
        this.x.M(this.K);
        this.f51654j = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.q = new ArrayList();
        this.p = new FragmentAdapter(this, this.f51649e.getActivity().getSupportFragmentManager(), this.q);
        this.f51654j.addOnPageChangeListener(this.F);
        RelativeLayout relativeLayout = new RelativeLayout(this.f51649e.getContext());
        this.k = relativeLayout;
        this.s = new c.a.r0.x0.n1.f.a.b(frsFragment, relativeLayout);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
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
            Iterator<c.a.r0.x0.l2.e> it = this.m.iterator();
            while (it.hasNext()) {
                c.a.r0.x0.l2.e next = it.next();
                if (next != null && ((i2 = next.f27196b) == 1 || i2 == 503)) {
                    return next.f27196b;
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
        c.a.r0.x0.n1.f.a.b bVar;
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
                if (oVar != null && oVar.f51681a == i2) {
                    return oVar;
                }
            }
            return null;
        }
        return (o) invokeI.objValue;
    }

    public c.a.r0.x0.l2.e H(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.m) != null && tabData.size() > 0) {
                Iterator<c.a.r0.x0.l2.e> it = this.m.iterator();
                while (it.hasNext()) {
                    c.a.r0.x0.l2.e next = it.next();
                    if (next.f27196b == i2) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (c.a.r0.x0.l2.e) invokeI.objValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : invokeV.intValue;
    }

    public FrsTabViewPager J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f51654j : (FrsTabViewPager) invokeV.objValue;
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
        this.D = themeElement.common_color;
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
            V(tabData);
            if (ListUtils.isEmpty(this.p.f51656b) || tabData.size() != this.p.f51656b.size()) {
                return true;
            }
            int size = tabData.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (tabData.get(i2) != null && this.p.f51656b.get(i2) != null && tabData.get(i2).f27196b != ((o) this.p.f51656b.get(i2)).f51681a) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, frsTabInfo)) == null) ? frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim()) || !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 92 || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 17 || frsTabInfo.tab_type.intValue() == 100) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4 : invokeL.booleanValue;
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || ListUtils.isEmpty(this.q)) {
            return;
        }
        for (o oVar : this.q) {
            if (oVar != null) {
                Fragment fragment = oVar.f51682b;
                if (fragment instanceof p0) {
                    ((p0) fragment).changeToSpecialFrs(z);
                }
            }
        }
    }

    public void T(int i2) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f51651g, R.drawable.personalize_tab_shadow);
            X();
            if (this.f51653i != null) {
                ThemeColorInfo themeColorInfo = this.o;
                if (themeColorInfo != null) {
                    ThemeElement themeElement = themeColorInfo.dark;
                    if (themeElement != null && i2 == 4) {
                        color = c.a.r0.q1.o.k.b.b(themeElement.font_color);
                    } else {
                        ThemeElement themeElement2 = this.o.night;
                        if (themeElement2 != null && i2 == 1) {
                            color = c.a.r0.q1.o.k.b.b(themeElement2.font_color);
                        } else {
                            ThemeElement themeElement3 = this.o.day;
                            if (themeElement3 != null && i2 == 0) {
                                color = c.a.r0.q1.o.k.b.b(themeElement3.font_color);
                            } else {
                                color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                            }
                        }
                    }
                } else {
                    color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                }
                this.f51653i.setSelectedTabIndicatorColor(color);
                this.f51653i.setSelectedIndicatorBottomMargin(A(R.dimen.tbds11));
                SkinManager.setBackgroundColor(this.f51653i, R.color.transparent);
                this.f51653i.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            }
            if (this.s != null && !M()) {
                this.s.i();
            }
            LinearGradientView linearGradientView = this.l;
            if (linearGradientView != null) {
                linearGradientView.changeSkinType(i2);
            }
            if (!ListUtils.isEmpty(this.q)) {
                for (o oVar : this.q) {
                    if (oVar != null) {
                        Fragment fragment = oVar.f51682b;
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

    public final void U() {
        c.a.r0.x0.g gVar;
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gVar = this.r) == null) {
            return;
        }
        List<c.a.q0.h0.b> f2 = gVar.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.m)) {
            return;
        }
        if (this.f51653i.getTabCount() > 0) {
            this.f51653i.removeAllTabs();
        }
        Z();
        ArrayList arrayList = new ArrayList();
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ThemeColorInfo themeColorInfo = this.o;
        if (themeColorInfo != null) {
            ThemeElement themeElement = themeColorInfo.dark;
            if (themeElement != null && skinType == 4) {
                color = c.a.r0.q1.o.k.b.b(themeElement.font_color);
            } else {
                ThemeElement themeElement2 = this.o.night;
                if (themeElement2 != null && skinType == 1) {
                    color = c.a.r0.q1.o.k.b.b(themeElement2.font_color);
                } else {
                    ThemeElement themeElement3 = this.o.day;
                    if (themeElement3 != null && skinType == 0) {
                        color = c.a.r0.q1.o.k.b.b(themeElement3.font_color);
                    } else {
                        color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                    }
                }
            }
        } else {
            color = SkinManager.getColor(R.color.plugin_button_shadow_red);
        }
        this.f51653i.setSelectedTabIndicatorColor(color);
        this.f51653i.setSelectedIndicatorBottomMargin(A(R.dimen.tbds10));
        Iterator<c.a.r0.x0.l2.e> it = this.m.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            c.a.r0.x0.l2.e next = it.next();
            Fragment x = x(next.f27196b, f2);
            if (x != null) {
                TbTabLayout.f newTab = this.f51653i.newTab();
                newTab.s(next.f27195a);
                if (next.f27196b == 1 && i3 < 0) {
                    i3 = i4;
                }
                boolean z = this.n.defaultShowTab == next.f27196b;
                if (z && i2 < 0) {
                    i2 = i4;
                }
                if (!FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.f51649e.getFrom()) ? !(!FrsActivityConfig.FRS_FROM_ITEM.equals(this.f51649e.getFrom()) || 506 != next.f27196b) : 3 == next.f27199e) {
                    i2 = i4;
                }
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.f27196b == 89) {
                    newTab.j(0, true);
                } else {
                    newTab.j(0, false);
                }
                this.f51653i.addTab(newTab, z);
                o oVar = new o(this);
                oVar.f51681a = next.f27196b;
                oVar.f51683c = next.f27195a;
                oVar.f51682b = x;
                oVar.f51684d = next.f27199e;
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
            this.p = new FragmentAdapter(this, this.f51649e.getActivity().getSupportFragmentManager(), this.q);
        }
        this.f51654j.setAdapter(this.p);
        this.p.notifyDataSetChanged();
        if (this.f51653i.getTabCount() > 0 && this.f51650f.getVisibility() != 0) {
            this.f51650f.setVisibility(0);
        }
        this.f51653i.setupWithViewPager(this.f51654j);
        this.f51654j.setOffscreenPageLimit(this.q.size());
        this.f51654j.setCurrentItem(i2, false);
        this.f51654j.notifyFrsTabViewPagerStatus();
    }

    public final void V(TabData tabData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, tabData) == null) || ListUtils.isEmpty(tabData)) {
            return;
        }
        boolean isRegistedIntent = TbadkCoreApplication.getInst().isRegistedIntent(HotRanklistActivityConfig.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            c.a.r0.x0.l2.e eVar = (c.a.r0.x0.l2.e) it.next();
            if (eVar != null && eVar.f27196b == 401 && !isRegistedIntent) {
                arrayList.add(eVar);
            }
        }
        tabData.removeAll(arrayList);
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PublishProgressView publishProgressView = this.u;
            return publishProgressView != null && publishProgressView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            int i2 = this.v;
            if (i2 == 2) {
                SkinManager.setBackgroundColor(this.f51650f, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.f51652h, R.color.CAM_X0207);
                this.f51651g.setVisibility(0);
                this.f51649e.hideRefreshIcon();
            } else if (i2 == 1) {
                SkinManager.setBackgroundColor(this.f51650f, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.f51652h, R.color.CAM_X0207);
                this.f51651g.setVisibility(0);
            } else {
                s();
                this.f51651g.setVisibility(8);
                FrsFragment frsFragment = this.f51649e;
                if (frsFragment != null) {
                    frsFragment.hideRefreshIcon();
                }
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.E.setPriority(Integer.MAX_VALUE);
            this.f51649e.registerListener(this.E);
            this.f51649e.registerListener(this.G);
            FrsFragment frsFragment = this.f51649e;
            frsFragment.registerListener(2001446, this.H, frsFragment.getBaseFragmentActivity().getUniqueId());
            this.f51649e.registerListener(this.J);
            this.f51649e.registerListener(this.I);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f51654j == null || this.p == null || this.q == null) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = this.f51649e.getActivity().getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                o oVar = this.q.get(i2);
                if (oVar != null && oVar.f51682b != null) {
                    beginTransaction.remove(oVar.f51682b);
                }
            }
            beginTransaction.commit();
            supportFragmentManager.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        c.a.r0.x0.l2.e eVar;
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(eVar.f27196b)));
        TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f51649e.forumId).param("tab_id", eVar.f27196b));
        if (c.a.e.e.p.j.A() && eVar.f27196b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
            this.n.setIsShowRedTip(false);
            fVar.j(0, false);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int i2 = !ListUtils.isEmpty(this.m) ? this.m.get(0).f27196b : -1;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null) {
                frsViewData.mHeadLineDefaultNavTabId = i2;
            }
            FrsFragment frsFragment = this.f51649e;
            if (frsFragment != null) {
                frsFragment.mHeadLineDefaultNavTabId = i2;
            }
        }
    }

    @Override // c.a.r0.x0.o2.n
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
                    } else if (this.m.get(i4).f27196b == i2) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 >= 0 && i3 < this.f51653i.getTabCount()) {
                    TbTabLayout.f tabAt = this.f51653i.getTabAt(i3);
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

    public final void b0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
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

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
            L();
            FrsFragment frsFragment = this.f51649e;
            if (frsFragment == null || frsFragment.getHeaderVC() == null) {
                return;
            }
            this.f51649e.getHeaderVC().w();
        }
    }

    public void c0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, nVar) == null) {
            this.t = nVar;
        }
    }

    @Override // c.a.r0.x0.o2.n
    public void d(FrsViewData frsViewData, int i2) {
        AccountData currentAccountObj;
        List<b0> list;
        List<b0> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048607, this, frsViewData, i2) == null) || frsViewData == null || frsViewData.getEntelechyTabInfo() == null || frsViewData.getEntelechyTabInfo().f21174a == null) {
            return;
        }
        K(frsViewData);
        TabData tabData = new TabData();
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().f21174a) {
            if (!R(frsTabInfo) && !N(frsTabInfo)) {
                if (frsTabInfo.is_general_tab.intValue() != 1 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_id.intValue() != 506) {
                    if (frsTabInfo.tab_id.intValue() != 89 && frsTabInfo.tab_id.intValue() != 503) {
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            c.a.r0.x0.l2.e eVar = new c.a.r0.x0.l2.e();
                            eVar.f27196b = frsTabInfo.tab_id.intValue();
                            eVar.f27195a = frsTabInfo.tab_name;
                            eVar.f27199e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                c.a.r0.x0.l2.e eVar2 = new c.a.r0.x0.l2.e();
                                eVar2.f27196b = frsTabInfo.tab_id.intValue();
                                eVar2.f27195a = frsTabInfo.tab_name;
                                eVar2.f27199e = frsTabInfo.tab_type.intValue();
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
                                eVar2.f27198d = sb2;
                                b0(sb2, "c10078");
                                tabData.add(eVar2);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && Q(frsTabInfo.tab_id.intValue())) {
                            c.a.r0.x0.l2.e eVar3 = new c.a.r0.x0.l2.e();
                            eVar3.f27196b = frsTabInfo.tab_id.intValue();
                            eVar3.f27195a = frsTabInfo.tab_name;
                            eVar3.f27198d = frsTabInfo.tab_url;
                            eVar3.f27199e = frsTabInfo.tab_type.intValue();
                            if (c.a.q0.m.c.g(eVar3.f27198d)) {
                                if (MessageManager.getInstance().findTask(2016447) != null) {
                                    tabData.add(eVar3);
                                    arrayList.add(frsTabInfo);
                                }
                            } else {
                                tabData.add(eVar3);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && f0.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            c.a.r0.x0.l2.e eVar4 = new c.a.r0.x0.l2.e();
                            eVar4.f27196b = frsTabInfo.tab_id.intValue();
                            eVar4.f27195a = frsTabInfo.tab_name;
                            eVar4.f27199e = frsTabInfo.tab_type.intValue();
                            d0 b2 = c0.a().b(eVar4.f27196b);
                            if (b2 != null && (list2 = b2.f26739b) != null && list2.size() > 0) {
                                e1 e1Var = new e1();
                                eVar4.f27197c = e1Var;
                                e1Var.f26768a = b2.f26738a;
                                e1Var.f26769b = new LinkedList();
                                boolean z = true;
                                for (b0 b0Var : b2.f26739b) {
                                    if (b0Var != null) {
                                        d1 d1Var = new d1();
                                        d1Var.f26740a = b0Var.f26655a;
                                        d1Var.f26741b = b0Var.f26656b;
                                        if (z) {
                                            d1Var.f26742c = true;
                                            z = false;
                                        }
                                        eVar4.f27197c.f26769b.add(d1Var);
                                    }
                                }
                            }
                            tabData.add(eVar4);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            c.a.r0.x0.l2.e eVar5 = new c.a.r0.x0.l2.e();
                            eVar5.f27196b = frsTabInfo.tab_id.intValue();
                            eVar5.f27195a = frsTabInfo.tab_name;
                            eVar5.f27199e = frsTabInfo.tab_type.intValue();
                            d0 b3 = c0.a().b(eVar5.f27196b);
                            if (b3 != null && (list = b3.f26739b) != null && list.size() > 0) {
                                e1 e1Var2 = new e1();
                                eVar5.f27197c = e1Var2;
                                e1Var2.f26768a = b3.f26738a;
                                e1Var2.f26769b = new LinkedList();
                                for (b0 b0Var2 : b3.f26739b) {
                                    if (b0Var2 != null) {
                                        d1 d1Var2 = new d1();
                                        d1Var2.f26740a = b0Var2.f26655a;
                                        d1Var2.f26741b = b0Var2.f26656b;
                                        eVar5.f27197c.f26769b.add(d1Var2);
                                    }
                                }
                            }
                            tabData.add(eVar5);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 49) {
                            if (this.f51649e.getFrsView().W().l(d2.y3)) {
                                c.a.r0.x0.l2.e eVar6 = new c.a.r0.x0.l2.e();
                                eVar6.f27195a = frsTabInfo.tab_name;
                                if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                    eVar6.f27195a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                int i3 = this.w;
                                if (i3 > 0 && i3 != frsViewData.getAlaLiveCount() && this.w <= 99) {
                                    eVar6.f27195a = frsTabInfo.tab_name + "(" + this.w + SmallTailInfo.EMOTION_SUFFIX;
                                } else if (this.w <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                    int i4 = this.w;
                                    if (i4 == 0 && i4 != frsViewData.getAlaLiveCount()) {
                                        eVar6.f27195a = frsTabInfo.tab_name;
                                    }
                                } else {
                                    eVar6.f27195a = frsTabInfo.tab_name + "(99+)";
                                }
                                eVar6.f27196b = frsTabInfo.tab_id.intValue();
                                eVar6.f27199e = frsTabInfo.tab_type.intValue();
                                tabData.add(eVar6);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() == 1120) {
                            c.a.r0.x0.l2.e eVar7 = new c.a.r0.x0.l2.e();
                            eVar7.f27196b = frsTabInfo.tab_id.intValue();
                            eVar7.f27195a = frsTabInfo.tab_name;
                            eVar7.f27199e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar7);
                            arrayList.add(frsTabInfo);
                            v(2);
                        } else if (frsTabInfo.tab_id.intValue() == 90) {
                            c.a.r0.x0.l2.e eVar8 = new c.a.r0.x0.l2.e();
                            eVar8.f27196b = frsTabInfo.tab_id.intValue();
                            eVar8.f27195a = frsTabInfo.tab_name;
                            eVar8.f27199e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar8);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 91) {
                            c.a.r0.x0.l2.e eVar9 = new c.a.r0.x0.l2.e();
                            eVar9.f27196b = frsTabInfo.tab_id.intValue();
                            eVar9.f27195a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, (String) null);
                            eVar9.f27199e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar9);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 504) {
                            c.a.r0.x0.l2.e eVar10 = new c.a.r0.x0.l2.e();
                            eVar10.f27196b = frsTabInfo.tab_id.intValue();
                            eVar10.f27195a = frsTabInfo.tab_name;
                            eVar10.f27199e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar10);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 3) {
                            c.a.r0.x0.l2.e eVar11 = new c.a.r0.x0.l2.e();
                            eVar11.f27196b = frsTabInfo.tab_id.intValue();
                            eVar11.f27195a = frsTabInfo.tab_name;
                            eVar11.f27199e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar11);
                            arrayList.add(frsTabInfo);
                            v(1);
                        }
                    } else {
                        c.a.r0.x0.l2.e eVar12 = new c.a.r0.x0.l2.e();
                        eVar12.f27196b = frsTabInfo.tab_id.intValue();
                        eVar12.f27195a = frsTabInfo.tab_name;
                        eVar12.f27199e = frsTabInfo.tab_type.intValue();
                        tabData.add(eVar12);
                        arrayList.add(frsTabInfo);
                        if (frsTabInfo.tab_id.intValue() == 503) {
                            String str = "";
                            String str2 = TbadkCoreApplication.getCurrentAccountObj() != null ? currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR : "";
                            if (frsViewData.getForum() != null && frsViewData.getForum().getName() != null) {
                                str = frsViewData.getForum().getName();
                            }
                            int h2 = c.a.r0.x0.n2.k.h("503~" + str2 + str);
                            if (h2 == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().f21175b.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            c.a.r0.x0.n2.k.i("503~" + str2 + str, next.tab_id.intValue());
                                            if (7 == h2) {
                                                c.a.r0.k3.o0.e.b();
                                            } else {
                                                c.a.r0.k3.o0.e.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    c.a.r0.x0.l2.e eVar13 = new c.a.r0.x0.l2.e();
                    eVar13.f27195a = frsTabInfo.tab_name;
                    eVar13.f27196b = frsTabInfo.tab_id.intValue();
                    eVar13.f27199e = frsTabInfo.tab_type.intValue();
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
        if (!P(tabData) && this.f51653i.getTabCount() > 0 && !ListUtils.isEmpty(this.m)) {
            int min = Math.min(this.m.size(), this.f51653i.getTabCount());
            for (int i5 = 0; i5 < min; i5++) {
                TbTabLayout.f tabAt = this.f51653i.getTabAt(i5);
                if (tabAt != null) {
                    if (frsViewData.isShowRedTip() && this.m.get(i5).f27196b == 89) {
                        tabAt.j(0, true);
                    } else {
                        tabAt.j(0, false);
                    }
                }
            }
        }
        if (frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> u = u(frsViewData);
            if (M()) {
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(u, 0);
                FrsFragment frsFragment = this.f51649e;
                if (frsFragment != null && frsFragment.getModelController() != null && frsTabInfo2 != null) {
                    this.f51649e.getModelController().J0(frsTabInfo2.tab_id.intValue());
                }
            } else {
                FrsFragment frsFragment2 = this.f51649e;
                if (frsFragment2 != null && frsFragment2.getListView() != null) {
                    if (u != null && u.size() < 2) {
                        this.f51649e.getListView().removeHeaderView(this.k);
                    } else {
                        this.f51649e.getListView().removeHeaderView(this.k);
                        this.f51649e.getListView().addHeaderView(this.k);
                        if (this.s != null && frsViewData.getForum() != null) {
                            this.s.j(u);
                            this.s.k(frsViewData.getForum().getId());
                            this.s.g(this.f51649e.getModelController().R());
                            if (c.a.q0.b.d.q() && c.a.q0.b.g.a.f12795c != c.a.q0.b.g.a.d()) {
                                this.s.g(c.a.q0.b.g.a.d());
                            }
                        }
                    }
                }
            }
        }
        if (O(tabData)) {
            this.m = tabData;
            a0();
            g0(arrayList);
        }
    }

    public void d0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048608, this, f2) == null) {
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
            if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > e2 && this.q.get(e2) != null && (this.q.get(e2).f51682b instanceof BaseFragment)) {
                customMessage.setTag(((BaseFragment) this.q.get(e2).f51682b).getUniqueId());
                customResponsedMessage.setOrginalMessage(customMessage);
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            c.a.r0.x0.l2.e eVar = this.m.get(e2);
            if (eVar != null) {
                this.A = eVar.f27196b;
                if (c.a.e.e.p.j.A() && eVar.f27196b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
                    this.n.setIsShowRedTip(false);
                    fVar.j(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(eVar.f27196b)));
                }
                if (eVar.f27196b == 502) {
                    if (this.f51649e.getWriteIcon() != null) {
                        this.f51649e.getWriteIcon().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.f51649e.getWriteIcon() != null) {
                    this.f51649e.getWriteIcon().setIconFade(0);
                }
                if (c.a.q0.b.d.u()) {
                    c.a.q0.b.g.a.g(eVar.f27195a);
                }
                n nVar = this.t;
                if (nVar != null) {
                    nVar.a(eVar.f27196b, eVar.f27199e, eVar.f27195a);
                }
                c.a.r0.x0.b.f().t(eVar.f27199e == 14);
                c.a.r0.x0.a.h().o(eVar.f27196b);
                TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f51649e.forumId).param("tab_id", eVar.f27196b));
            }
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f51653i.setDisableTabSelect(z);
        }
    }

    @Override // c.a.r0.x0.o2.n
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.v = i2;
            X();
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.x.m0(this.f51649e.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
        }
    }

    public final void g0(List<FrsTabInfo> list) {
        FrsFragment frsFragment;
        View U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c.a.r0.x0.g gVar = new c.a.r0.x0.g(this.f51649e.getActivity().getApplicationContext(), list);
        this.r = gVar;
        gVar.i(this.f51649e.getForumId());
        this.r.j(this.f51649e.getForumName());
        this.r.k(this.f51649e.getFrom());
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
            c.a.q0.h0.b y = y(frsTabInfo);
            if (y != null) {
                this.r.a(y);
            }
        }
        if (list.get(0) != null && list.get(0).tab_id.intValue() != 1 && (frsFragment = this.f51649e) != null && frsFragment.getFrsView() != null && (U = this.f51649e.getFrsView().U()) != null && (U.getParent() instanceof ViewGroup)) {
            ((ViewGroup) U.getParent()).removeView(U);
        }
        this.y = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.r));
    }

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.w = i2;
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            SkinManager.setBackgroundColor(this.f51652h, R.color.CAM_X0205);
            this.f51652h.setAlpha(0.0f);
            c.a.q0.s.u.c.d(this.f51650f).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
        }
    }

    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().f21174a.iterator();
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
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().f21175b) {
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
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13971").param("fid", this.f51649e.forumId).param("fname", this.f51649e.getForumName()).param("obj_locate", i2));
        }
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048619, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f51649e.getForumId());
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

    public final Fragment x(int i2, List<c.a.q0.h0.b> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048620, this, i2, list)) == null) {
            for (c.a.q0.h0.b bVar : list) {
                Bundle arguments = bVar.getFragmentTabStructure().f13471a.getArguments();
                if (arguments != null && i2 == bVar.getFragmentTabStructure().f13475e && !arguments.getBoolean("isAdded")) {
                    arguments.putBoolean("isAdded", true);
                    bVar.getFragmentTabStructure().f13471a.setArguments(arguments);
                    return bVar.getFragmentTabStructure().f13471a;
                }
            }
            return null;
        }
        return (Fragment) invokeIL.objValue;
    }

    public final c.a.q0.h0.b y(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, frsTabInfo)) == null) {
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
        return (c.a.q0.h0.b) invokeL.objValue;
    }

    public o z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            FrsTabViewPager frsTabViewPager = this.f51654j;
            if (frsTabViewPager == null) {
                return null;
            }
            return (o) ListUtils.getItem(this.q, frsTabViewPager.getCurrentItem());
        }
        return (o) invokeV.objValue;
    }
}
