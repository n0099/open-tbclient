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
import d.a.p0.s.q.b2;
import d.a.p0.s.q.j1;
import d.a.q0.u0.b0;
import d.a.q0.u0.c0;
import d.a.q0.u0.d0;
import d.a.q0.u0.d1;
import d.a.q0.u0.e1;
import d.a.q0.u0.f0;
import d.a.q0.u0.p0;
import d.a.q0.u0.r0;
import d.a.q0.u0.z;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabViewController implements d.a.q0.u0.o2.n, TbTabLayout.c {
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
    public FrsFragment f16106e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16107f;

    /* renamed from: g  reason: collision with root package name */
    public View f16108g;

    /* renamed from: h  reason: collision with root package name */
    public View f16109h;

    /* renamed from: i  reason: collision with root package name */
    public TbTabLayout f16110i;
    public FrsTabViewPager j;
    public RelativeLayout k;
    public LinearGradientView l;
    public TabData m;
    public FrsViewData n;
    public ThemeColorInfo o;
    public FragmentAdapter p;
    public List<o> q;
    public d.a.q0.u0.g r;
    public d.a.q0.u0.m1.f.a.b s;
    public n t;
    public PublishProgressView u;
    public int v;
    public int w;
    public d.a.q0.e0.e x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16111a;

        /* renamed from: b  reason: collision with root package name */
        public List<o> f16112b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16113c;

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
            this.f16113c = frsTabViewController;
            this.f16111a = -1;
            this.f16112b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16112b.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f16112b.get(i2).f16138b : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f16112b.get(i2).f16139c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                if (obj == null || (i3 = this.f16111a) == i2) {
                    return;
                }
                if (i3 != -1 && i3 < getCount()) {
                    BaseFragment baseFragment = (BaseFragment) getItem(this.f16111a);
                    if (baseFragment instanceof FrsAllThreadFragment) {
                        this.f16113c.f16106e.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.f16111a = i2;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        this.f16113c.f16106e.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends d.a.p0.g0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16114a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16115b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16116c;

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
            this.f16116c = frsTabViewController;
            this.f16114a = frsTabInfo;
            this.f16115b = i2;
        }

        @Override // d.a.p0.g0.b
        public d.a.p0.g0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.q0.w0.a.e(this.f16114a, this.f16116c.n.showAdsense.intValue()));
                bundle.putString("name", this.f16116c.f16106e.g());
                bundle.putString("from", this.f16116c.f16106e.A2());
                bundle.putString("forum_id", this.f16116c.f16106e.h());
                bundle.putInt("tab_id", this.f16115b);
                bundle.putInt("tab_type", this.f16114a.tab_type.intValue());
                bundle.putString("tab_name", this.f16114a.tab_name);
                bundle.putInt("is_general_tab", this.f16114a.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.f16116c.n.isFrsVideoAutoPlay);
                bundle.putBoolean("need_log", this.f16116c.n.needLog == 1);
                bundle.putBoolean("is_brand_forum", this.f16116c.n.isBrandForum);
                bundle.putSerializable("view_data", this.f16116c.n);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                d.a.p0.g0.c cVar = new d.a.p0.g0.c();
                cVar.f52618a = frsCommonTabFragment;
                cVar.f52622e = this.f16115b;
                cVar.f52626i = d.a.p0.g0.c.k;
                return cVar;
            }
            return (d.a.p0.g0.c) invokeV.objValue;
        }

        @Override // d.a.p0.g0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.p0.g0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.p0.g0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f16117a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16118b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16119c;

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
            this.f16119c = frsTabViewController;
            this.f16117a = i2;
            this.f16118b = frsTabInfo;
        }

        @Override // d.a.p0.g0.b
        public d.a.p0.g0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.f16119c.f16106e.g());
                bundle.putString("from", this.f16119c.f16106e.A2());
                bundle.putString("forum_id", this.f16119c.f16106e.h());
                bundle.putInt("tab_id", this.f16117a);
                bundle.putInt("tab_type", this.f16118b.tab_type.intValue());
                bundle.putString("tab_name", this.f16118b.tab_name);
                bundle.putString(LowFlowsActivityConfig.TAB_CODE, this.f16118b.tab_code);
                bundle.putBoolean("need_log", this.f16119c.n.needLog == 1);
                bundle.putString("theme_color", this.f16119c.D);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.f16119c.f16106e.C2());
                frsItemTabFragment.setArguments(bundle);
                d.a.p0.g0.c cVar = new d.a.p0.g0.c();
                cVar.f52618a = frsItemTabFragment;
                cVar.f52622e = this.f16117a;
                cVar.f52626i = d.a.p0.g0.c.k;
                return cVar;
            }
            return (d.a.p0.g0.c) invokeV.objValue;
        }

        @Override // d.a.p0.g0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.p0.g0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16120a;

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
            this.f16120a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384 && (customResponsedMessage.getData() instanceof d.a.q0.u0.k2.e)) {
                d.a.q0.u0.k2.e eVar = (d.a.q0.u0.k2.e) customResponsedMessage.getData();
                int i2 = -1;
                for (int i3 = 0; i3 < ListUtils.getCount(this.f16120a.m); i3++) {
                    if (this.f16120a.m.get(i3) != null && (this.f16120a.m.get(i3).f63656b == eVar.f63656b || this.f16120a.m.get(i3).f63659e == eVar.f63659e)) {
                        i2 = i3;
                        break;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                this.f16120a.j.setCurrentItem(i2, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16121e;

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
            this.f16121e = frsTabViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16121e.x.I();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16122a;

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
            this.f16122a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.q0.u0.g) || this.f16122a.y) {
                return;
            }
            this.f16122a.U();
            this.f16122a.y = true;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16123e;

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
            this.f16123e = frsTabViewController;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                d.a.q0.u0.k2.a aVar = new d.a.q0.u0.k2.a();
                aVar.f63653b = i2;
                aVar.f63654c = i3;
                CustomMessage customMessage = new CustomMessage(2921590);
                customMessage.setTag(this.f16123e.f16106e.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                a(this.f16123e.z() == null ? 0 : this.f16123e.z().f16137a, i2);
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
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f16123e.j == null) {
                return;
            }
            this.f16123e.j.d();
            if (ListUtils.isEmpty(this.f16123e.q) || this.f16123e.q.size() <= i2) {
                return;
            }
            o oVar = (o) ListUtils.getItem(this.f16123e.q, i2);
            if (oVar.f16137a == 506) {
                d.a.p0.s.f0.p.b bVar = new d.a.p0.s.f0.p.b(5);
                bVar.i(13);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
            if (oVar.f16138b instanceof r0) {
                z zVar = new z();
                zVar.f64662a = oVar.f16137a;
                zVar.f64663b = (r0) oVar.f16138b;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar));
            } else {
                z zVar2 = new z();
                zVar2.f64662a = oVar.f16137a;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar2));
            }
            a(oVar.f16137a, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16124a;

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
            this.f16124a = frsTabViewController;
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
                if (this.f16124a.n == null || this.f16124a.n.isShowRedTip() == booleanValue || this.f16124a.f16110i.getTabCount() <= 0 || ListUtils.isEmpty(this.f16124a.m)) {
                    return;
                }
                this.f16124a.n.setIsShowRedTip(booleanValue);
                int min = Math.min(this.f16124a.m.size(), this.f16124a.f16110i.getTabCount());
                for (int i2 = 0; i2 < min; i2++) {
                    TbTabLayout.f w = this.f16124a.f16110i.w(i2);
                    if (w != null) {
                        if (this.f16124a.m.get(i2).f63656b == 89) {
                            w.j(0, booleanValue);
                        } else {
                            w.j(0, false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16125a;

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
            this.f16125a = frsTabViewController;
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
            if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (z = this.f16125a.z()) != null && (fragment = z.f16138b) != null && (fragment instanceof p0)) {
                ((p0) fragment).s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16126a;

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
            this.f16126a = frsTabViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j1 j1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof j1) || (j1Var = (j1) customResponsedMessage.getData()) == null || j1Var.e() || this.f16126a.f16106e == null || !j1Var.c(this.f16126a.f16106e.h()) || this.f16126a.u == null) {
                return;
            }
            this.f16126a.u.c(j1Var);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.a.p0.g0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16127a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16129c;

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
            this.f16129c = frsTabViewController;
            this.f16127a = frsTabInfo;
            this.f16128b = i2;
        }

        @Override // d.a.p0.g0.b
        public d.a.p0.g0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                if (this.f16129c.f16106e != null && this.f16129c.f16106e.G0() != null) {
                    frsAllThreadFragment.O0(this.f16129c.f16106e.G0().U());
                    this.f16129c.f16106e.A3(d.a.q0.w0.a.e(this.f16127a, this.f16129c.n.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                if (this.f16129c.f16106e != null) {
                    bundle.putString("forum_id", this.f16129c.f16106e.h());
                }
                bundle.putInt("tab_id", this.f16128b);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                d.a.p0.g0.c cVar = new d.a.p0.g0.c();
                cVar.f52618a = frsAllThreadFragment;
                cVar.f52622e = 1;
                cVar.f52626i = d.a.p0.g0.c.k;
                return cVar;
            }
            return (d.a.p0.g0.c) invokeV.objValue;
        }

        @Override // d.a.p0.g0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.p0.g0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends d.a.p0.g0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16130a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16131b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16132c;

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
            this.f16132c = frsTabViewController;
            this.f16130a = frsTabInfo;
            this.f16131b = i2;
        }

        @Override // d.a.p0.g0.b
        public d.a.p0.g0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.q0.w0.a.e(this.f16130a, this.f16132c.n.showAdsense.intValue()));
                bundle.putString("name", this.f16132c.f16106e.g());
                bundle.putString("from", this.f16132c.f16106e.A2());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean(FrsActivityConfig.GOOD, true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.f16132c.f16106e.h());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                d.a.p0.g0.c cVar = new d.a.p0.g0.c();
                cVar.f52618a = frsGoodFragment;
                cVar.f52622e = this.f16131b;
                cVar.f52626i = d.a.p0.g0.c.k;
                return cVar;
            }
            return (d.a.p0.g0.c) invokeV.objValue;
        }

        @Override // d.a.p0.g0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.p0.g0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.a.p0.g0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16133a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16134b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16135c;

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
            this.f16135c = frsTabViewController;
            this.f16133a = frsTabInfo;
            this.f16134b = i2;
        }

        @Override // d.a.p0.g0.b
        public d.a.p0.g0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.q0.w0.a.e(this.f16133a, this.f16135c.n.showAdsense.intValue()));
                bundle.putString("name", this.f16135c.f16106e.g());
                bundle.putString("from", this.f16135c.f16106e.A2());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.f16135c.f16106e.h());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                d.a.p0.g0.c cVar = new d.a.p0.g0.c();
                cVar.f52618a = frsNewAreaFragment;
                cVar.f52622e = this.f16134b;
                cVar.f52626i = d.a.p0.g0.c.k;
                return cVar;
            }
            return (d.a.p0.g0.c) invokeV.objValue;
        }

        @Override // d.a.p0.g0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.p0.g0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends d.a.p0.g0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabViewController f16136a;

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
            this.f16136a = frsTabViewController;
        }

        @Override // d.a.p0.g0.b
        public d.a.p0.g0.c createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.f16136a.f16106e.g());
                bundle.putString("from", this.f16136a.f16106e.A2());
                bundle.putString("forum_id", this.f16136a.f16106e.h());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                d.a.p0.g0.c cVar = new d.a.p0.g0.c();
                cVar.f52618a = frsADFragment;
                cVar.f52622e = 90;
                cVar.f52626i = d.a.p0.g0.c.k;
                return cVar;
            }
            return (d.a.p0.g0.c) invokeV.objValue;
        }

        @Override // d.a.p0.g0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // d.a.p0.g0.b
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface n {
        void a(int i2, int i3, String str);
    }

    /* loaded from: classes4.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16137a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f16138b;

        /* renamed from: c  reason: collision with root package name */
        public String f16139c;

        /* renamed from: d  reason: collision with root package name */
        public int f16140d;

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
        this.f16106e = frsFragment;
        this.f16107f = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.f16109h = view.findViewById(R.id.frs_tab_bg);
        this.f16108g = view.findViewById(R.id.divider_shadow);
        this.l = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        TbTabLayout tbTabLayout = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.f16110i = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.f16110i.setSelectedTabTextBlod(true);
        this.f16110i.setTabTextSize(A(R.dimen.tbds42));
        d.a.q0.e0.e eVar = new d.a.q0.e0.e(frsFragment.getPageContext(), this.f16110i);
        this.x = eVar;
        eVar.g0(R.drawable.bg_tip_blue_up_left);
        this.x.O(16);
        this.x.h0(true);
        this.x.j0(A(R.dimen.tbds34));
        this.x.k0(A(R.dimen.tbds10));
        this.x.M(this.K);
        this.j = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.q = new ArrayList();
        this.p = new FragmentAdapter(this, this.f16106e.getActivity().getSupportFragmentManager(), this.q);
        this.j.addOnPageChangeListener(this.F);
        RelativeLayout relativeLayout = new RelativeLayout(this.f16106e.getContext());
        this.k = relativeLayout;
        this.s = new d.a.q0.u0.m1.f.a.b(frsFragment, relativeLayout);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i2) : invokeI.intValue;
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
            Iterator<d.a.q0.u0.k2.e> it = this.m.iterator();
            while (it.hasNext()) {
                d.a.q0.u0.k2.e next = it.next();
                if (next != null && ((i2 = next.f63656b) == 1 || i2 == 503)) {
                    return next.f63656b;
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
        d.a.q0.u0.m1.f.a.b bVar;
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
                if (oVar != null && oVar.f16137a == i2) {
                    return oVar;
                }
            }
            return null;
        }
        return (o) invokeI.objValue;
    }

    public d.a.q0.u0.k2.e H(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.m) != null && tabData.size() > 0) {
                Iterator<d.a.q0.u0.k2.e> it = this.m.iterator();
                while (it.hasNext()) {
                    d.a.q0.u0.k2.e next = it.next();
                    if (next.f63656b == i2) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (d.a.q0.u0.k2.e) invokeI.objValue;
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
            if (ListUtils.isEmpty(this.p.f16112b) || tabData.size() != this.p.f16112b.size()) {
                return true;
            }
            int size = tabData.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (tabData.get(i2) != null && this.p.f16112b.get(i2) != null && tabData.get(i2).f63656b != ((o) this.p.f16112b.get(i2)).f16137a) {
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

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || ListUtils.isEmpty(this.q)) {
            return;
        }
        for (o oVar : this.q) {
            if (oVar != null) {
                Fragment fragment = oVar.f16138b;
                if (fragment instanceof p0) {
                    ((p0) fragment).K(z);
                }
            }
        }
    }

    public void T(int i2) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f16108g, R.drawable.personalize_tab_shadow);
            X();
            if (this.f16110i != null) {
                ThemeColorInfo themeColorInfo = this.o;
                if (themeColorInfo != null) {
                    ThemeElement themeElement = themeColorInfo.dark;
                    if (themeElement != null && i2 == 4) {
                        color = d.a.q0.n1.o.k.b.b(themeElement.font_color);
                    } else {
                        ThemeElement themeElement2 = this.o.night;
                        if (themeElement2 != null && i2 == 1) {
                            color = d.a.q0.n1.o.k.b.b(themeElement2.font_color);
                        } else {
                            ThemeElement themeElement3 = this.o.day;
                            if (themeElement3 != null && i2 == 0) {
                                color = d.a.q0.n1.o.k.b.b(themeElement3.font_color);
                            } else {
                                color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                            }
                        }
                    }
                } else {
                    color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                }
                this.f16110i.setSelectedTabIndicatorColor(color);
                this.f16110i.setSelectedIndicatorBottomMargin(A(R.dimen.tbds11));
                SkinManager.setBackgroundColor(this.f16110i, R.color.transparent);
                this.f16110i.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
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
                        Fragment fragment = oVar.f16138b;
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
        d.a.q0.u0.g gVar;
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gVar = this.r) == null) {
            return;
        }
        List<d.a.p0.g0.b> f2 = gVar.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.m)) {
            return;
        }
        if (this.f16110i.getTabCount() > 0) {
            this.f16110i.B();
        }
        Z();
        ArrayList arrayList = new ArrayList();
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ThemeColorInfo themeColorInfo = this.o;
        if (themeColorInfo != null) {
            ThemeElement themeElement = themeColorInfo.dark;
            if (themeElement != null && skinType == 4) {
                color = d.a.q0.n1.o.k.b.b(themeElement.font_color);
            } else {
                ThemeElement themeElement2 = this.o.night;
                if (themeElement2 != null && skinType == 1) {
                    color = d.a.q0.n1.o.k.b.b(themeElement2.font_color);
                } else {
                    ThemeElement themeElement3 = this.o.day;
                    if (themeElement3 != null && skinType == 0) {
                        color = d.a.q0.n1.o.k.b.b(themeElement3.font_color);
                    } else {
                        color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                    }
                }
            }
        } else {
            color = SkinManager.getColor(R.color.plugin_button_shadow_red);
        }
        this.f16110i.setSelectedTabIndicatorColor(color);
        this.f16110i.setSelectedIndicatorBottomMargin(A(R.dimen.tbds10));
        Iterator<d.a.q0.u0.k2.e> it = this.m.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            d.a.q0.u0.k2.e next = it.next();
            Fragment x = x(next.f63656b, f2);
            if (x != null) {
                TbTabLayout.f z = this.f16110i.z();
                z.s(next.f63655a);
                if (next.f63656b == 1 && i3 < 0) {
                    i3 = i4;
                }
                boolean z2 = this.n.defaultShowTab == next.f63656b;
                if (z2 && i2 < 0) {
                    i2 = i4;
                }
                if (!FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.f16106e.A2()) ? !(!FrsActivityConfig.FRS_FROM_ITEM.equals(this.f16106e.A2()) || 506 != next.f63656b) : 3 == next.f63659e) {
                    i2 = i4;
                }
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.f63656b == 89) {
                    z.j(0, true);
                } else {
                    z.j(0, false);
                }
                this.f16110i.f(z, z2);
                o oVar = new o(this);
                oVar.f16137a = next.f63656b;
                oVar.f16139c = next.f63655a;
                oVar.f16138b = x;
                oVar.f16140d = next.f63659e;
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
            this.p = new FragmentAdapter(this, this.f16106e.getActivity().getSupportFragmentManager(), this.q);
        }
        this.j.setAdapter(this.p);
        this.p.notifyDataSetChanged();
        if (this.f16110i.getTabCount() > 0 && this.f16107f.getVisibility() != 0) {
            this.f16107f.setVisibility(0);
        }
        this.f16110i.setupWithViewPager(this.j);
        this.j.setOffscreenPageLimit(this.q.size());
        this.j.setCurrentItem(i2, false);
        this.j.d();
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
            d.a.q0.u0.k2.e eVar = (d.a.q0.u0.k2.e) it.next();
            if (eVar != null && eVar.f63656b == 401 && !isRegistedIntent) {
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
                SkinManager.setBackgroundColor(this.f16107f, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.f16109h, R.color.CAM_X0207);
                this.f16108g.setVisibility(0);
                this.f16106e.R2();
            } else if (i2 == 1) {
                SkinManager.setBackgroundColor(this.f16107f, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.f16109h, R.color.CAM_X0207);
                this.f16108g.setVisibility(0);
            } else {
                s();
                this.f16108g.setVisibility(8);
                FrsFragment frsFragment = this.f16106e;
                if (frsFragment != null) {
                    frsFragment.R2();
                }
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.E.setPriority(Integer.MAX_VALUE);
            this.f16106e.registerListener(this.E);
            this.f16106e.registerListener(this.G);
            FrsFragment frsFragment = this.f16106e;
            frsFragment.registerListener(2001446, this.H, frsFragment.getBaseFragmentActivity().getUniqueId());
            this.f16106e.registerListener(this.J);
            this.f16106e.registerListener(this.I);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.j == null || this.p == null || this.q == null) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = this.f16106e.getActivity().getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                o oVar = this.q.get(i2);
                if (oVar != null && oVar.f16138b != null) {
                    beginTransaction.remove(oVar.f16138b);
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
        d.a.q0.u0.k2.e eVar;
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(eVar.f63656b)));
        TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f16106e.p).param("tab_id", eVar.f63656b));
        if (d.a.d.e.p.j.A() && eVar.f63656b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
            this.n.setIsShowRedTip(false);
            fVar.j(0, false);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int i2 = !ListUtils.isEmpty(this.m) ? this.m.get(0).f63656b : -1;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null) {
                frsViewData.mHeadLineDefaultNavTabId = i2;
            }
            FrsFragment frsFragment = this.f16106e;
            if (frsFragment != null) {
                frsFragment.P0 = i2;
            }
        }
    }

    @Override // d.a.q0.u0.o2.n
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
                    } else if (this.m.get(i4).f63656b == i2) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 >= 0 && i3 < this.f16110i.getTabCount()) {
                    TbTabLayout.f w = this.f16110i.w(i3);
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
            FrsFragment frsFragment = this.f16106e;
            if (frsFragment == null || frsFragment.R() == null) {
                return;
            }
            this.f16106e.R().y();
        }
    }

    public void c0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, nVar) == null) {
            this.t = nVar;
        }
    }

    @Override // d.a.q0.u0.o2.n
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
                            d.a.q0.u0.k2.e eVar = new d.a.q0.u0.k2.e();
                            eVar.f63656b = frsTabInfo.tab_id.intValue();
                            eVar.f63655a = frsTabInfo.tab_name;
                            eVar.f63659e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                d.a.q0.u0.k2.e eVar2 = new d.a.q0.u0.k2.e();
                                eVar2.f63656b = frsTabInfo.tab_id.intValue();
                                eVar2.f63655a = frsTabInfo.tab_name;
                                eVar2.f63659e = frsTabInfo.tab_type.intValue();
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
                                eVar2.f63658d = sb2;
                                b0(sb2, "c10078");
                                tabData.add(eVar2);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && Q(frsTabInfo.tab_id.intValue())) {
                            d.a.q0.u0.k2.e eVar3 = new d.a.q0.u0.k2.e();
                            eVar3.f63656b = frsTabInfo.tab_id.intValue();
                            eVar3.f63655a = frsTabInfo.tab_name;
                            eVar3.f63658d = frsTabInfo.tab_url;
                            eVar3.f63659e = frsTabInfo.tab_type.intValue();
                            if (d.a.p0.m.c.f(eVar3.f63658d)) {
                                if (MessageManager.getInstance().findTask(2016447) != null) {
                                    tabData.add(eVar3);
                                    arrayList.add(frsTabInfo);
                                }
                            } else {
                                tabData.add(eVar3);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && f0.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            d.a.q0.u0.k2.e eVar4 = new d.a.q0.u0.k2.e();
                            eVar4.f63656b = frsTabInfo.tab_id.intValue();
                            eVar4.f63655a = frsTabInfo.tab_name;
                            eVar4.f63659e = frsTabInfo.tab_type.intValue();
                            d0 b2 = c0.a().b(eVar4.f63656b);
                            if (b2 != null && (list2 = b2.f63253b) != null && list2.size() > 0) {
                                e1 e1Var = new e1();
                                eVar4.f63657c = e1Var;
                                e1Var.f63260a = b2.f63252a;
                                e1Var.f63261b = new LinkedList();
                                boolean z = true;
                                for (b0 b0Var : b2.f63253b) {
                                    if (b0Var != null) {
                                        d1 d1Var = new d1();
                                        d1Var.f63254a = b0Var.f63210a;
                                        d1Var.f63255b = b0Var.f63211b;
                                        if (z) {
                                            d1Var.f63256c = true;
                                            z = false;
                                        }
                                        eVar4.f63657c.f63261b.add(d1Var);
                                    }
                                }
                            }
                            tabData.add(eVar4);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            d.a.q0.u0.k2.e eVar5 = new d.a.q0.u0.k2.e();
                            eVar5.f63656b = frsTabInfo.tab_id.intValue();
                            eVar5.f63655a = frsTabInfo.tab_name;
                            eVar5.f63659e = frsTabInfo.tab_type.intValue();
                            d0 b3 = c0.a().b(eVar5.f63656b);
                            if (b3 != null && (list = b3.f63253b) != null && list.size() > 0) {
                                e1 e1Var2 = new e1();
                                eVar5.f63657c = e1Var2;
                                e1Var2.f63260a = b3.f63252a;
                                e1Var2.f63261b = new LinkedList();
                                for (b0 b0Var2 : b3.f63253b) {
                                    if (b0Var2 != null) {
                                        d1 d1Var2 = new d1();
                                        d1Var2.f63254a = b0Var2.f63210a;
                                        d1Var2.f63255b = b0Var2.f63211b;
                                        eVar5.f63657c.f63261b.add(d1Var2);
                                    }
                                }
                            }
                            tabData.add(eVar5);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 49) {
                            if (this.f16106e.G0().W().k(b2.s3)) {
                                d.a.q0.u0.k2.e eVar6 = new d.a.q0.u0.k2.e();
                                eVar6.f63655a = frsTabInfo.tab_name;
                                if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                    eVar6.f63655a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                int i3 = this.w;
                                if (i3 > 0 && i3 != frsViewData.getAlaLiveCount() && this.w <= 99) {
                                    eVar6.f63655a = frsTabInfo.tab_name + "(" + this.w + SmallTailInfo.EMOTION_SUFFIX;
                                } else if (this.w <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                    int i4 = this.w;
                                    if (i4 == 0 && i4 != frsViewData.getAlaLiveCount()) {
                                        eVar6.f63655a = frsTabInfo.tab_name;
                                    }
                                } else {
                                    eVar6.f63655a = frsTabInfo.tab_name + "(99+)";
                                }
                                eVar6.f63656b = frsTabInfo.tab_id.intValue();
                                eVar6.f63659e = frsTabInfo.tab_type.intValue();
                                tabData.add(eVar6);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() == 1120) {
                            d.a.q0.u0.k2.e eVar7 = new d.a.q0.u0.k2.e();
                            eVar7.f63656b = frsTabInfo.tab_id.intValue();
                            eVar7.f63655a = frsTabInfo.tab_name;
                            eVar7.f63659e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar7);
                            arrayList.add(frsTabInfo);
                            v(2);
                        } else if (frsTabInfo.tab_id.intValue() == 90) {
                            d.a.q0.u0.k2.e eVar8 = new d.a.q0.u0.k2.e();
                            eVar8.f63656b = frsTabInfo.tab_id.intValue();
                            eVar8.f63655a = frsTabInfo.tab_name;
                            eVar8.f63659e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar8);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 91) {
                            d.a.q0.u0.k2.e eVar9 = new d.a.q0.u0.k2.e();
                            eVar9.f63656b = frsTabInfo.tab_id.intValue();
                            eVar9.f63655a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, (String) null);
                            eVar9.f63659e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar9);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 504) {
                            d.a.q0.u0.k2.e eVar10 = new d.a.q0.u0.k2.e();
                            eVar10.f63656b = frsTabInfo.tab_id.intValue();
                            eVar10.f63655a = frsTabInfo.tab_name;
                            eVar10.f63659e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar10);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 3) {
                            d.a.q0.u0.k2.e eVar11 = new d.a.q0.u0.k2.e();
                            eVar11.f63656b = frsTabInfo.tab_id.intValue();
                            eVar11.f63655a = frsTabInfo.tab_name;
                            eVar11.f63659e = frsTabInfo.tab_type.intValue();
                            tabData.add(eVar11);
                            arrayList.add(frsTabInfo);
                            v(1);
                        }
                    } else {
                        d.a.q0.u0.k2.e eVar12 = new d.a.q0.u0.k2.e();
                        eVar12.f63656b = frsTabInfo.tab_id.intValue();
                        eVar12.f63655a = frsTabInfo.tab_name;
                        eVar12.f63659e = frsTabInfo.tab_type.intValue();
                        tabData.add(eVar12);
                        arrayList.add(frsTabInfo);
                        if (frsTabInfo.tab_id.intValue() == 503) {
                            String str = "";
                            String str2 = TbadkCoreApplication.getCurrentAccountObj() != null ? currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR : "";
                            if (frsViewData.getForum() != null && frsViewData.getForum().getName() != null) {
                                str = frsViewData.getForum().getName();
                            }
                            int h2 = d.a.q0.u0.n2.k.h("503~" + str2 + str);
                            if (h2 == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            d.a.q0.u0.n2.k.i("503~" + str2 + str, next.tab_id.intValue());
                                            if (7 == h2) {
                                                d.a.q0.h3.n0.e.b();
                                            } else {
                                                d.a.q0.h3.n0.e.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    d.a.q0.u0.k2.e eVar13 = new d.a.q0.u0.k2.e();
                    eVar13.f63655a = frsTabInfo.tab_name;
                    eVar13.f63656b = frsTabInfo.tab_id.intValue();
                    eVar13.f63659e = frsTabInfo.tab_type.intValue();
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
        if (!P(tabData) && this.f16110i.getTabCount() > 0 && !ListUtils.isEmpty(this.m)) {
            int min = Math.min(this.m.size(), this.f16110i.getTabCount());
            for (int i5 = 0; i5 < min; i5++) {
                TbTabLayout.f w = this.f16110i.w(i5);
                if (w != null) {
                    if (frsViewData.isShowRedTip() && this.m.get(i5).f63656b == 89) {
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
                FrsFragment frsFragment = this.f16106e;
                if (frsFragment != null && frsFragment.g0() != null && frsTabInfo2 != null) {
                    this.f16106e.g0().J0(frsTabInfo2.tab_id.intValue());
                }
            } else {
                FrsFragment frsFragment2 = this.f16106e;
                if (frsFragment2 != null && frsFragment2.G2() != null) {
                    if (u != null && u.size() < 2) {
                        this.f16106e.G2().removeHeaderView(this.k);
                    } else {
                        this.f16106e.G2().removeHeaderView(this.k);
                        this.f16106e.G2().s(this.k);
                        if (this.s != null && frsViewData.getForum() != null) {
                            this.s.j(u);
                            this.s.k(frsViewData.getForum().getId());
                            this.s.g(this.f16106e.g0().R());
                            if (d.a.p0.b.d.y() && d.a.p0.b.g.a.f52014c != d.a.p0.b.g.a.d()) {
                                this.s.g(d.a.p0.b.g.a.d());
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
            if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > e2 && this.q.get(e2) != null && (this.q.get(e2).f16138b instanceof BaseFragment)) {
                customMessage.setTag(((BaseFragment) this.q.get(e2).f16138b).getUniqueId());
                customResponsedMessage.setOrginalMessage(customMessage);
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            d.a.q0.u0.k2.e eVar = this.m.get(e2);
            if (eVar != null) {
                this.A = eVar.f63656b;
                if (d.a.d.e.p.j.A() && eVar.f63656b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
                    this.n.setIsShowRedTip(false);
                    fVar.j(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(eVar.f63656b)));
                }
                if (eVar.f63656b == 502) {
                    if (this.f16106e.N2() != null) {
                        this.f16106e.N2().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.f16106e.N2() != null) {
                    this.f16106e.N2().setIconFade(0);
                }
                if (d.a.p0.b.d.C()) {
                    d.a.p0.b.g.a.g(eVar.f63655a);
                }
                n nVar = this.t;
                if (nVar != null) {
                    nVar.a(eVar.f63656b, eVar.f63659e, eVar.f63655a);
                }
                d.a.q0.u0.b.e().p(eVar.f63659e == 14);
                d.a.q0.u0.a.h().o(eVar.f63656b);
                TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f16106e.p).param("tab_id", eVar.f63656b));
            }
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f16110i.setDisableTabSelect(z);
        }
    }

    @Override // d.a.q0.u0.o2.n
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
            this.x.m0(this.f16106e.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
        }
    }

    public final void g0(List<FrsTabInfo> list) {
        FrsFragment frsFragment;
        View U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        d.a.q0.u0.g gVar = new d.a.q0.u0.g(this.f16106e.getActivity().getApplicationContext(), list);
        this.r = gVar;
        gVar.i(this.f16106e.h());
        this.r.j(this.f16106e.g());
        this.r.k(this.f16106e.A2());
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
            d.a.p0.g0.b y = y(frsTabInfo);
            if (y != null) {
                this.r.a(y);
            }
        }
        if (list.get(0) != null && list.get(0).tab_id.intValue() != 1 && (frsFragment = this.f16106e) != null && frsFragment.G0() != null && (U = this.f16106e.G0().U()) != null && (U.getParent() instanceof ViewGroup)) {
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
            SkinManager.setBackgroundColor(this.f16109h, R.color.CAM_X0205);
            this.f16109h.setAlpha(0.0f);
            d.a.p0.s.u.c.d(this.f16107f).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
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
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13971").param("fid", this.f16106e.p).param("fname", this.f16106e.g()).param("obj_locate", i2));
        }
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048619, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f16106e.h());
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

    public final Fragment x(int i2, List<d.a.p0.g0.b> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048620, this, i2, list)) == null) {
            for (d.a.p0.g0.b bVar : list) {
                Bundle arguments = bVar.getFragmentTabStructure().f52618a.getArguments();
                if (arguments != null && i2 == bVar.getFragmentTabStructure().f52622e && !arguments.getBoolean("isAdded")) {
                    arguments.putBoolean("isAdded", true);
                    bVar.getFragmentTabStructure().f52618a.setArguments(arguments);
                    return bVar.getFragmentTabStructure().f52618a;
                }
            }
            return null;
        }
        return (Fragment) invokeIL.objValue;
    }

    public final d.a.p0.g0.b y(FrsTabInfo frsTabInfo) {
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
            if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 3) {
                return new a(this, frsTabInfo, intValue);
            }
            if (intValue == 506) {
                return new b(this, intValue, frsTabInfo);
            }
            return null;
        }
        return (d.a.p0.g0.b) invokeL.objValue;
    }

    public o z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            FrsTabViewPager frsTabViewPager = this.j;
            if (frsTabViewPager == null) {
                return null;
            }
            return (o) ListUtils.getItem(this.q, frsTabViewPager.getCurrentItem());
        }
        return (o) invokeV.objValue;
    }
}
