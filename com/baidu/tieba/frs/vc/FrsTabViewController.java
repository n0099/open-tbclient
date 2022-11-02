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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.bk6;
import com.baidu.tieba.bv6;
import com.baidu.tieba.cq8;
import com.baidu.tieba.dk6;
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
import com.baidu.tieba.gt6;
import com.baidu.tieba.ia5;
import com.baidu.tieba.it6;
import com.baidu.tieba.ja5;
import com.baidu.tieba.ki6;
import com.baidu.tieba.kw4;
import com.baidu.tieba.li6;
import com.baidu.tieba.lj6;
import com.baidu.tieba.nj6;
import com.baidu.tieba.oj6;
import com.baidu.tieba.p56;
import com.baidu.tieba.pj6;
import com.baidu.tieba.pn6;
import com.baidu.tieba.qi6;
import com.baidu.tieba.rj6;
import com.baidu.tieba.rk6;
import com.baidu.tieba.rz4;
import com.baidu.tieba.sk6;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tt6;
import com.baidu.tieba.tv6;
import com.baidu.tieba.tw6;
import com.baidu.tieba.vp4;
import com.baidu.tieba.vq8;
import com.baidu.tieba.wi7;
import com.baidu.tieba.xi;
import com.baidu.tieba.xt6;
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
/* loaded from: classes4.dex */
public class FrsTabViewController implements tv6, TbTabLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final it6 A;
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
    public qi6 n;
    public pn6 o;
    public o p;
    public PublishProgressView q;
    public int r;
    public int s;
    public p56 t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public String z;

    /* loaded from: classes4.dex */
    public interface o {
        void a(int i, int i2, String str);
    }

    public static boolean U(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    public void h0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.b.get(i).b;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.b.get(i).c;
            }
            return (CharSequence) invokeI.objValue;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                if (obj != null && (i2 = this.a) != i) {
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
    }

    /* loaded from: classes4.dex */
    public class a extends ia5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.ia5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ia5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tieba.ia5
        public ja5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, tw6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putString("forum_id", this.e.a.k());
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.d);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putInt("is_general_tab", this.c.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.e.j.isFrsVideoAutoPlay);
                boolean z = true;
                if (this.e.j.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean("need_log", z);
                bundle.putBoolean("is_brand_forum", this.e.j.isBrandForum);
                bundle.putSerializable("view_data", this.e.j);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                ja5 ja5Var = new ja5();
                ja5Var.a = frsCommonTabFragment;
                ja5Var.e = this.d;
                ja5Var.i = ja5.k;
                return ja5Var;
            }
            return (ja5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ia5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.ia5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ia5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tieba.ia5
        public ja5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsTabWebFragment frsTabWebFragment = new FrsTabWebFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, tw6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putString("forum_id", this.e.a.k());
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.d);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putString("tab_url", this.c.tab_url);
                bundle.putInt("is_general_tab", this.c.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.e.j.isFrsVideoAutoPlay);
                boolean z = true;
                if (this.e.j.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean("need_log", z);
                bundle.putBoolean("is_brand_forum", this.e.j.isBrandForum);
                bundle.putSerializable("view_data", this.e.j);
                bundle.putBoolean("isAdded", false);
                frsTabWebFragment.setArguments(bundle);
                ja5 ja5Var = new ja5();
                ja5Var.a = frsTabWebFragment;
                ja5Var.e = this.d;
                ja5Var.i = ja5.k;
                return ja5Var;
            }
            return (ja5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ia5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int c;
        public final /* synthetic */ FrsTabInfo d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.ia5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ia5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tieba.ia5
        public ja5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putString("forum_id", this.e.a.k());
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.c);
                bundle.putInt("tab_type", this.d.tab_type.intValue());
                bundle.putString("tab_name", this.d.tab_name);
                bundle.putString("tab_code", this.d.tab_code);
                boolean z = true;
                if (this.e.j.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean("need_log", z);
                bundle.putString("theme_color", this.e.z);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.e.a.q3());
                frsItemTabFragment.setArguments(bundle);
                frsItemTabFragment.v1(this.e.a.getUniqueId());
                ja5 ja5Var = new ja5();
                ja5Var.a = frsItemTabFragment;
                ja5Var.e = this.c;
                ja5Var.i = ja5.k;
                return ja5Var;
            }
            return (ja5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384 && (customResponsedMessage.getData() instanceof xt6)) {
                xt6 xt6Var = (xt6) customResponsedMessage.getData();
                int i = -1;
                for (int i2 = 0; i2 < ListUtils.getCount(this.a.i); i2++) {
                    if (this.a.i.get(i2) != null && (this.a.i.get(i2).b == xt6Var.b || this.a.i.get(i2).e == xt6Var.e)) {
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

    /* loaded from: classes4.dex */
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
                this.a.t.h();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qi6) && !this.a.u) {
                this.a.Y();
                this.a.u = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (this.a.C() == null) {
                    i2 = 0;
                } else {
                    i2 = this.a.C().a;
                }
                a(i2, i);
            }
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                tt6 tt6Var = new tt6();
                tt6Var.b = i;
                tt6Var.c = i2;
                CustomMessage customMessage = new CustomMessage(2921590);
                customMessage.setTag(this.a.a.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, tt6Var);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.a.f == null) {
                return;
            }
            this.a.f.d();
            if (!ListUtils.isEmpty(this.a.m) && this.a.m.size() > i) {
                p pVar = (p) ListUtils.getItem(this.a.m, i);
                if (pVar.a == 506) {
                    rz4 rz4Var = new rz4(5);
                    rz4Var.n(13);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, rz4Var));
                }
                if (pVar.d == 100) {
                    TiebaStatic.log(new StatisticItem("c13008").param("obj_type", 16));
                }
                if (pVar.d == 102) {
                    TiebaStatic.log(new StatisticItem("c13008").param("fid", this.a.a.k()).param("obj_type", 17));
                }
                if (pVar.b instanceof dk6) {
                    lj6 lj6Var = new lj6();
                    lj6Var.a = pVar.a;
                    lj6Var.b = (dk6) pVar.b;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, lj6Var));
                } else {
                    lj6 lj6Var2 = new lj6();
                    lj6Var2.a = pVar.a;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, lj6Var2));
                }
                int i2 = 0;
                a(pVar.a, 0);
                OvalActionButton H3 = this.a.a.H3();
                if (!this.a.a.Z2(pVar.a)) {
                    i2 = 8;
                }
                H3.setVisibility(i2);
            }
            if (this.a.a != null && (this.a.a.getActivity() instanceof FrsActivity)) {
                ((FrsActivity) this.a.a.getActivity()).R0().a();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) data).booleanValue();
            if (this.a.j != null && this.a.j.isShowRedTip() != booleanValue && this.a.e.getTabCount() > 0 && !ListUtils.isEmpty(this.a.i)) {
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length != 2) {
                    return;
                }
                String str = split[0];
                String str2 = split[1];
                if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (C = this.a.C()) != null && (fragment = C.b) != null && (fragment instanceof bk6)) {
                    ((bk6) fragment).x();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof PublishProgressData) && (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) != null && !vq8.k().s() && vq8.k().i() != null && this.a.a != null && publishProgressData.isCurrentForum(this.a.a.k()) && this.a.q != null) {
                this.a.q.c(publishProgressData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends ia5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.ia5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ia5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tieba.ia5
        public ja5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                if (this.e.a != null && this.e.a.j1() != null) {
                    frsAllThreadFragment.s1(this.e.a.j1().X());
                    this.e.a.F4(tw6.e(this.c, this.e.j.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                if (this.e.a != null) {
                    bundle.putString("forum_id", this.e.a.k());
                }
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.d);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                ja5 ja5Var = new ja5();
                ja5Var.a = frsAllThreadFragment;
                ja5Var.e = 1;
                ja5Var.i = ja5.k;
                return ja5Var;
            }
            return (ja5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l extends ia5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.ia5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ia5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tieba.ia5
        public ja5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, tw6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean(FrsActivityConfig.GOOD, true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.a.k());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                ja5 ja5Var = new ja5();
                ja5Var.a = frsGoodFragment;
                ja5Var.e = this.d;
                ja5Var.i = ja5.k;
                return ja5Var;
            }
            return (ja5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends ia5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.ia5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ia5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tieba.ia5
        public ja5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, tw6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.a.k());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                ja5 ja5Var = new ja5();
                ja5Var.a = frsNewAreaFragment;
                ja5Var.e = this.d;
                ja5Var.i = ja5.k;
                return ja5Var;
            }
            return (ja5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class n extends ia5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController c;

        @Override // com.baidu.tieba.ia5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ia5
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tieba.ia5
        public ja5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.c.a.c());
                bundle.putString("from", this.c.a.o3());
                bundle.putString("forum_id", this.c.a.k());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                ja5 ja5Var = new ja5();
                ja5Var.a = frsADFragment;
                ja5Var.e = 90;
                ja5Var.i = ja5.k;
                return ja5Var;
            }
            return (ja5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
        this.A = gt6.a();
        this.B = new f(this, 2001623);
        this.C = new g(this);
        this.D = new h(this, 2001612);
        this.E = new i(this, 0);
        this.F = new j(this, 2921526);
        this.G = new d(this, 2921384);
        this.H = new e(this);
        this.a = frsFragment;
        this.A.a(view2, onClickListener);
        this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c27);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090c22);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f090832);
        this.h = (LinearGradientView) view2.findViewById(R.id.obfuscated_res_0x7f090c25);
        TbTabLayout tbTabLayout = (TbTabLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c24);
        this.e = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.e.setSelectedTabTextBlod(true);
        this.e.setTabTextSize(gt6.c());
        p56 p56Var = new p56(frsFragment.getPageContext(), this.e);
        this.t = p56Var;
        p56Var.L(R.drawable.obfuscated_res_0x7f0802f5);
        this.t.o(16);
        this.t.M(true);
        this.t.P(D(R.dimen.tbds34));
        this.t.Q(D(R.dimen.tbds10));
        this.t.m(this.H);
        this.f = (FrsTabViewPager) view2.findViewById(R.id.obfuscated_res_0x7f090c3d);
        this.m = new ArrayList();
        this.l = new FragmentAdapter(this, this.a.getActivity().getSupportFragmentManager(), this.m);
        this.f.addOnPageChangeListener(this.C);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getContext());
        this.g = relativeLayout;
        this.o = new pn6(frsFragment, relativeLayout);
        PublishProgressView publishProgressView = (PublishProgressView) view2.findViewById(R.id.obfuscated_res_0x7f091b28);
        this.q = publishProgressView;
        publishProgressView.setVisibility(8);
    }

    public final int D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return xi.g(TbadkCoreApplication.getInst().getContext(), i2);
        }
        return invokeI.intValue;
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

    @Override // com.baidu.tieba.tv6
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.r = i2;
            b0();
        }
    }

    public void g0(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, oVar) == null) {
            this.p = oVar;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.e.setDisableTabSelect(z);
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.s = i2;
        }
    }

    public final Fragment A(int i2, List<ia5> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, list)) == null) {
            for (ia5 ia5Var : list) {
                Bundle arguments = ia5Var.b().a.getArguments();
                if (arguments != null && i2 == ia5Var.b().e && !arguments.getBoolean("isAdded")) {
                    arguments.putBoolean("isAdded", true);
                    ia5Var.b().a.setArguments(arguments);
                    return ia5Var.b().a;
                }
            }
            return null;
        }
        return (Fragment) invokeIL.objValue;
    }

    public final ia5 B(FrsTabInfo frsTabInfo) {
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
        return (ia5) invokeL.objValue;
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
                this.e.setTabTextColors(gt6.b(), SkinManager.getColor(R.color.CAM_X0105));
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

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public View H() {
        InterceptResult invokeV;
        pn6 pn6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Q() || (pn6Var = this.o) == null) {
                return null;
            }
            return pn6Var.h();
        }
        return (View) invokeV.objValue;
    }

    public RelativeLayout I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public FrsTabViewPager N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f;
        }
        return (FrsTabViewPager) invokeV.objValue;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.t.h();
        }
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PublishProgressView publishProgressView = this.q;
            if (publishProgressView == null || publishProgressView.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (!ListUtils.isEmpty(this.i)) {
                i2 = this.i.get(0).b;
            } else {
                i2 = -1;
            }
            FrsViewData frsViewData = this.j;
            if (frsViewData != null) {
                frsViewData.mHeadLineDefaultNavTabId = i2;
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                frsFragment.L0 = i2;
            }
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.t.S(this.a.getString(R.string.obfuscated_res_0x7f0f03f6), "key_show_frs_tab_click_to_refresh_tip");
        }
    }

    public int F() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<xt6> it = this.i.iterator();
            while (it.hasNext()) {
                xt6 next = it.next();
                if (next != null && ((i2 = next.b) == 1 || i2 == 503)) {
                    return next.b;
                }
            }
            return 0;
        }
        return invokeV.intValue;
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

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            this.d.setAlpha(0.0f);
            kw4.d(this.b).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
        }
    }

    public xt6 K(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.i) != null && tabData.size() > 0) {
                Iterator<xt6> it = this.i.iterator();
                while (it.hasNext()) {
                    xt6 next = it.next();
                    if (next.b == i2) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (xt6) invokeI.objValue;
    }

    public final void O(FrsViewData frsViewData) {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) && frsViewData != null && (themeColorInfo = frsViewData.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
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
    }

    public final boolean T(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            if (!ListUtils.isEmpty(this.i) && tabData.size() == this.i.size() && this.i.containsAll(tabData)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048597, this, z) != null) || ListUtils.isEmpty(this.m)) {
            return;
        }
        for (p pVar : this.m) {
            if (pVar != null) {
                Fragment fragment = pVar.b;
                if (fragment instanceof bk6) {
                    ((bk6) fragment).g0(z);
                }
            }
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13971").param("fid", this.a.l).param("fname", this.a.c()).param("obj_locate", i2));
        }
    }

    public final int M(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            ThemeColorInfo themeColorInfo = this.k;
            if (themeColorInfo != null) {
                ThemeElement themeElement = themeColorInfo.dark;
                if (themeElement != null && i2 == 4) {
                    return wi7.b(themeElement.font_color);
                }
                ThemeElement themeElement2 = this.k.night;
                if (themeElement2 != null && i2 == 1) {
                    return wi7.b(themeElement2.font_color);
                }
                ThemeElement themeElement3 = this.k.day;
                if (themeElement3 != null && i2 == 0) {
                    return wi7.b(themeElement3.font_color);
                }
                return i3;
            }
            return i3;
        }
        return invokeII.intValue;
    }

    public final void f0(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048612, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String host = new URI(str).getHost();
                StatisticItem statisticItem = new StatisticItem(str2);
                statisticItem.param("obj_type", host);
                TiebaStatic.log(statisticItem);
            } catch (URISyntaxException e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void s(FrsTabInfo frsTabInfo, ia5 ia5Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, frsTabInfo, ia5Var) == null) && ia5Var != null && ia5Var.b() != null && (ia5Var.b().a instanceof BaseFragment)) {
            BaseFragment baseFragment = (BaseFragment) ia5Var.b().a;
            if (frsTabInfo != null) {
                str = frsTabInfo.tab_name;
            } else {
                str = "";
            }
            baseFragment.setTbPageExtraPageTabName(str);
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

    public final boolean R(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, frsTabInfo)) == null) {
            if (frsTabInfo == null || ((frsTabInfo.tab_type.intValue() == 0 && frsTabInfo.tab_id.intValue() >= 100) || ((frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) || (frsTabInfo.tab_type.intValue() == 11 && !U(frsTabInfo.tab_id.intValue()))))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void Z(TabData tabData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, tabData) != null) || ListUtils.isEmpty(tabData)) {
            return;
        }
        boolean isRegistedIntent = TbadkCoreApplication.getInst().isRegistedIntent(HotRanklistActivityConfig.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            xt6 xt6Var = (xt6) it.next();
            if (xt6Var != null && xt6Var.b == 401 && !isRegistedIntent) {
                arrayList.add(xt6Var);
            }
        }
        tabData.removeAll(arrayList);
    }

    @Override // com.baidu.tieba.tv6
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
                    if (w != null && !w.h()) {
                        w.l();
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
            P();
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.n0() != null) {
                this.a.n0().D();
            }
            int e2 = fVar.e();
            TabData tabData = this.i;
            if (tabData != null && e2 >= 0 && e2 < tabData.size() && this.i.get(e2) != null && 102 == this.i.get(e2).e && (fVar.b() instanceof FrsTabItemCustomeView)) {
                ((FrsTabItemCustomeView) fVar.b()).b(false);
            }
        }
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

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        xt6 xt6Var;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, fVar) != null) || fVar == null) {
            return;
        }
        int e2 = fVar.e();
        TabData tabData = this.i;
        if (tabData != null && e2 >= 0 && e2 < tabData.size() && (xt6Var = this.i.get(e2)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(xt6Var.b)));
            TiebaStatic.log(new StatisticItem("c12398").param("fid", this.a.l).param(TiebaStatic.Params.TAB_ID, xt6Var.b));
            if (BdNetTypeUtil.isNetworkAvailableForImmediately() && xt6Var.b == 89 && (frsViewData = this.j) != null && frsViewData.isShowRedTip()) {
                this.j.setIsShowRedTip(false);
                fVar.j(0, false);
            }
        }
    }

    public final void w(int i2) {
        FrsTabItemCustomeView frsTabItemCustomeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i2) == null) && this.e.getTabCount() > 0 && !ListUtils.isEmpty(this.i)) {
            int min = Math.min(this.i.size(), this.e.getTabCount());
            for (int i3 = 0; i3 < min; i3++) {
                TbTabLayout.f w = this.e.w(i3);
                xt6 xt6Var = this.i.get(i3);
                if (w != null && xt6Var != null && xt6Var.e == 102 && (w.b() instanceof FrsTabItemCustomeView) && (frsTabItemCustomeView = (FrsTabItemCustomeView) w.b()) != null) {
                    frsTabItemCustomeView.a();
                    frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(M(i2, SkinManager.getColor(R.color.plugin_button_shadow_red)), PorterDuff.Mode.SRC_IN));
                }
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
                if (it.hasNext()) {
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 1) {
                        i2 = next.tab_type.intValue();
                        break;
                    }
                } else {
                    i2 = -1;
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

    public final boolean V(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, frsTabInfo)) == null) {
            if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim()) || ((frsTabInfo.tab_type.intValue() != 1 && frsTabInfo.tab_type.intValue() != 0 && frsTabInfo.tab_type.intValue() != 11 && frsTabInfo.tab_type.intValue() != 12 && frsTabInfo.tab_type.intValue() != 91 && frsTabInfo.tab_type.intValue() != 13 && frsTabInfo.tab_type.intValue() != 14 && frsTabInfo.tab_type.intValue() != 15 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_type.intValue() != 92 && frsTabInfo.tab_type.intValue() != 3 && frsTabInfo.tab_type.intValue() != 17 && frsTabInfo.tab_type.intValue() != 100 && frsTabInfo.tab_type.intValue() != 102) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k0(List<FrsTabInfo> list) {
        FrsFragment frsFragment;
        View X;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        qi6 qi6Var = new qi6(this.a.getActivity().getApplicationContext(), list);
        this.n = qi6Var;
        qi6Var.h(this.a.k());
        this.n.i(this.a.c());
        this.n.j(this.a.o3());
        FrsViewData frsViewData = this.j;
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.n.g(this.j.getForum().getForumGameLabel());
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
            ia5 B = B(frsTabInfo);
            if (B != null) {
                s(frsTabInfo, B);
                this.n.a(B);
            }
        }
        if (list.get(0) != null && list.get(0).tab_id.intValue() != 1 && (frsFragment = this.a) != null && frsFragment.j1() != null && (X = this.a.j1().X()) != null && (X.getParent() instanceof ViewGroup)) {
            ((ViewGroup) X.getParent()).removeView(X);
        }
        this.u = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.n));
    }

    public final void Y() {
        qi6 qi6Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (qi6Var = this.n) == null) {
            return;
        }
        List<ia5> f2 = qi6Var.f();
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
        Iterator<xt6> it = this.i.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            xt6 next = it.next();
            Fragment A = A(next.b, f2);
            if (A != null) {
                TbTabLayout.f z2 = this.e.z();
                z2.s(next.a);
                if (next.b == 1 && i3 < 0) {
                    i3 = i4;
                }
                if (this.j.defaultShowTab == next.b) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && i2 < 0) {
                    i2 = i4;
                }
                if (!FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.a.o3()) ? !(!FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.o3()) || 506 != next.b) : 3 == next.e) {
                    i2 = i4;
                }
                FrsViewData frsViewData = this.j;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.b == 89) {
                    z2.j(0, true);
                } else {
                    z2.j(0, false);
                }
                this.e.f(z2, z);
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

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            int i2 = this.r;
            if (i2 == 2) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
                this.c.setVisibility(0);
                this.a.L3();
            } else if (i2 == 1) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
                this.c.setVisibility(0);
            } else {
                t();
                this.c.setVisibility(8);
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.L3();
                }
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.f != null && this.l != null && this.m != null) {
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
    }

    @Override // com.baidu.tieba.tv6
    public void d(FrsViewData frsViewData, int i2) {
        AccountData currentAccountObj;
        String str;
        List<nj6> list;
        List<nj6> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048607, this, frsViewData, i2) == null) && frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().a != null) {
            O(frsViewData);
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().a) {
                if (!V(frsTabInfo) && !R(frsTabInfo)) {
                    if (frsTabInfo.is_general_tab.intValue() != 1 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_id.intValue() != 506 && frsTabInfo.tab_type.intValue() != 102) {
                        if (frsTabInfo.tab_id.intValue() != 89 && frsTabInfo.tab_id.intValue() != 503) {
                            if (frsTabInfo.tab_type.intValue() == 12) {
                                xt6 xt6Var = new xt6();
                                xt6Var.b = frsTabInfo.tab_id.intValue();
                                xt6Var.a = frsTabInfo.tab_name;
                                xt6Var.e = frsTabInfo.tab_type.intValue();
                                tabData.add(xt6Var);
                                arrayList.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                                if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                    xt6 xt6Var2 = new xt6();
                                    xt6Var2.b = frsTabInfo.tab_id.intValue();
                                    xt6Var2.a = frsTabInfo.tab_name;
                                    xt6Var2.e = frsTabInfo.tab_type.intValue();
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
                                    xt6Var2.d = sb2;
                                    f0(sb2, "c10078");
                                    tabData.add(xt6Var2);
                                    arrayList.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_type.intValue() == 11 && U(frsTabInfo.tab_id.intValue())) {
                                xt6 xt6Var3 = new xt6();
                                xt6Var3.b = frsTabInfo.tab_id.intValue();
                                xt6Var3.a = frsTabInfo.tab_name;
                                xt6Var3.d = frsTabInfo.tab_url;
                                xt6Var3.e = frsTabInfo.tab_type.intValue();
                                if (vp4.i(xt6Var3.d)) {
                                    if (MessageManager.getInstance().findTask(2016447) != null) {
                                        tabData.add(xt6Var3);
                                        arrayList.add(frsTabInfo);
                                    }
                                } else {
                                    tabData.add(xt6Var3);
                                    arrayList.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_id.intValue() != 1 && rj6.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                                xt6 xt6Var4 = new xt6();
                                xt6Var4.b = frsTabInfo.tab_id.intValue();
                                xt6Var4.a = frsTabInfo.tab_name;
                                xt6Var4.e = frsTabInfo.tab_type.intValue();
                                pj6 b2 = oj6.a().b(xt6Var4.b);
                                if (b2 != null && (list2 = b2.b) != null && list2.size() > 0) {
                                    sk6 sk6Var = new sk6();
                                    xt6Var4.c = sk6Var;
                                    sk6Var.a = b2.a;
                                    sk6Var.b = new LinkedList();
                                    boolean z = true;
                                    for (nj6 nj6Var : b2.b) {
                                        if (nj6Var != null) {
                                            rk6 rk6Var = new rk6();
                                            rk6Var.a = nj6Var.a;
                                            rk6Var.b = nj6Var.b;
                                            if (z) {
                                                rk6Var.c = true;
                                                z = false;
                                            }
                                            xt6Var4.c.b.add(rk6Var);
                                        }
                                    }
                                }
                                tabData.add(xt6Var4);
                                arrayList.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 1) {
                                xt6 xt6Var5 = new xt6();
                                xt6Var5.b = frsTabInfo.tab_id.intValue();
                                xt6Var5.a = frsTabInfo.tab_name;
                                xt6Var5.e = frsTabInfo.tab_type.intValue();
                                pj6 b3 = oj6.a().b(xt6Var5.b);
                                if (b3 != null && (list = b3.b) != null && list.size() > 0) {
                                    sk6 sk6Var2 = new sk6();
                                    xt6Var5.c = sk6Var2;
                                    sk6Var2.a = b3.a;
                                    sk6Var2.b = new LinkedList();
                                    for (nj6 nj6Var2 : b3.b) {
                                        if (nj6Var2 != null) {
                                            rk6 rk6Var2 = new rk6();
                                            rk6Var2.a = nj6Var2.a;
                                            rk6Var2.b = nj6Var2.b;
                                            xt6Var5.c.b.add(rk6Var2);
                                        }
                                    }
                                }
                                tabData.add(xt6Var5);
                                arrayList.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 49) {
                                if (this.a.j1().Y().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                                    xt6 xt6Var6 = new xt6();
                                    xt6Var6.a = frsTabInfo.tab_name;
                                    if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                        xt6Var6.a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                    }
                                    int i3 = this.s;
                                    if (i3 > 0 && i3 != frsViewData.getAlaLiveCount() && this.s <= 99) {
                                        xt6Var6.a = frsTabInfo.tab_name + "(" + this.s + SmallTailInfo.EMOTION_SUFFIX;
                                    } else if (this.s <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                        int i4 = this.s;
                                        if (i4 == 0 && i4 != frsViewData.getAlaLiveCount()) {
                                            xt6Var6.a = frsTabInfo.tab_name;
                                        }
                                    } else {
                                        xt6Var6.a = frsTabInfo.tab_name + "(99+)";
                                    }
                                    xt6Var6.b = frsTabInfo.tab_id.intValue();
                                    xt6Var6.e = frsTabInfo.tab_type.intValue();
                                    tabData.add(xt6Var6);
                                    arrayList.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_id.intValue() == 1120) {
                                xt6 xt6Var7 = new xt6();
                                xt6Var7.b = frsTabInfo.tab_id.intValue();
                                xt6Var7.a = frsTabInfo.tab_name;
                                xt6Var7.e = frsTabInfo.tab_type.intValue();
                                tabData.add(xt6Var7);
                                arrayList.add(frsTabInfo);
                                y(2);
                            } else if (frsTabInfo.tab_id.intValue() == 90) {
                                xt6 xt6Var8 = new xt6();
                                xt6Var8.b = frsTabInfo.tab_id.intValue();
                                xt6Var8.a = frsTabInfo.tab_name;
                                xt6Var8.e = frsTabInfo.tab_type.intValue();
                                tabData.add(xt6Var8);
                                arrayList.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 91) {
                                xt6 xt6Var9 = new xt6();
                                xt6Var9.b = frsTabInfo.tab_id.intValue();
                                xt6Var9.a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, (String) null);
                                xt6Var9.e = frsTabInfo.tab_type.intValue();
                                tabData.add(xt6Var9);
                                arrayList.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 504) {
                                xt6 xt6Var10 = new xt6();
                                xt6Var10.b = frsTabInfo.tab_id.intValue();
                                xt6Var10.a = frsTabInfo.tab_name;
                                xt6Var10.e = frsTabInfo.tab_type.intValue();
                                tabData.add(xt6Var10);
                                arrayList.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 3) {
                                xt6 xt6Var11 = new xt6();
                                xt6Var11.b = frsTabInfo.tab_id.intValue();
                                xt6Var11.a = frsTabInfo.tab_name;
                                xt6Var11.e = frsTabInfo.tab_type.intValue();
                                tabData.add(xt6Var11);
                                arrayList.add(frsTabInfo);
                                y(1);
                            }
                        } else {
                            xt6 xt6Var12 = new xt6();
                            xt6Var12.b = frsTabInfo.tab_id.intValue();
                            xt6Var12.a = frsTabInfo.tab_name;
                            xt6Var12.e = frsTabInfo.tab_type.intValue();
                            tabData.add(xt6Var12);
                            arrayList.add(frsTabInfo);
                            if (frsTabInfo.tab_id.intValue() == 503) {
                                String str2 = "";
                                if (TbadkCoreApplication.getCurrentAccountObj() == null) {
                                    str = "";
                                } else {
                                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                                }
                                if (frsViewData.getForum() != null && frsViewData.getForum().getName() != null) {
                                    str2 = frsViewData.getForum().getName();
                                }
                                int h2 = bv6.h("503~" + str + str2);
                                if (h2 == -1) {
                                    Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().b.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            FrsTabInfo next = it.next();
                                            if (next.tab_type == frsTabInfo.tab_type) {
                                                bv6.i("503~" + str + str2, next.tab_id.intValue());
                                                if (7 == h2) {
                                                    cq8.b();
                                                } else {
                                                    cq8.a();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        xt6 xt6Var13 = new xt6();
                        xt6Var13.a = frsTabInfo.tab_name;
                        xt6Var13.b = frsTabInfo.tab_id.intValue();
                        xt6Var13.e = frsTabInfo.tab_type.intValue();
                        xt6Var13.f = frsTabInfo.head_pics;
                        xt6Var13.d = frsTabInfo.tab_url;
                        tabData.add(xt6Var13);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
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
                        if (frsFragment != null && frsFragment.J0() != null && frsTabInfo2 != null) {
                            this.a.J0().N0(frsTabInfo2.tab_id.intValue());
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
                                    this.o.g(this.a.J0().U());
                                    if (UbsABTestHelper.isFrsNewAreaTabSortTestA() && FrsTabTestHelper.HAVE_NOT_RECORD_SORT != FrsTabTestHelper.getFrsNewAreaTabSort()) {
                                        this.o.g(FrsTabTestHelper.getFrsNewAreaTabSort());
                                    }
                                }
                            }
                        }
                    }
                }
                if (!S(tabData)) {
                    return;
                }
                this.i = tabData;
                e0();
                k0(arrayList);
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void e(TbTabLayout.f fVar) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
            int e2 = fVar.e();
            TabData tabData = this.i;
            if (tabData != null && e2 >= 0 && e2 < tabData.size()) {
                boolean z = false;
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, 0);
                CustomMessage customMessage = new CustomMessage(2921397);
                if (!ListUtils.isEmpty(this.m) && ListUtils.getCount(this.m) > e2 && this.m.get(e2) != null && (this.m.get(e2).b instanceof BaseFragment)) {
                    customMessage.setTag(((BaseFragment) this.m.get(e2).b).getUniqueId());
                    customResponsedMessage.setOrginalMessage(customMessage);
                }
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                xt6 xt6Var = this.i.get(e2);
                if (xt6Var != null) {
                    if (102 == xt6Var.e && (fVar.b() instanceof FrsTabItemCustomeView)) {
                        ((FrsTabItemCustomeView) fVar.b()).b(true);
                    }
                    this.w = xt6Var.b;
                    if (BdNetTypeUtil.isNetworkAvailableForImmediately() && xt6Var.b == 89 && (frsViewData = this.j) != null && frsViewData.isShowRedTip()) {
                        this.j.setIsShowRedTip(false);
                        fVar.j(0, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(xt6Var.b)));
                    }
                    if (xt6Var.b == 502) {
                        if (this.a.H3() != null) {
                            this.a.H3().setIconFade(R.drawable.btn_frs_professional_edit_n);
                        }
                    } else if (this.a.H3() != null) {
                        this.a.H3().setIconFade(0);
                    }
                    if (UbsABTestHelper.isFrsTabLocationTestC()) {
                        FrsTabTestHelper.storeUserLastAccessTab(xt6Var.a);
                    }
                    o oVar = this.p;
                    if (oVar != null) {
                        oVar.a(xt6Var.b, xt6Var.e, xt6Var.a);
                    }
                    li6 f2 = li6.f();
                    if (xt6Var.e == 14) {
                        z = true;
                    }
                    f2.t(z);
                    ki6.h().o(xt6Var.b);
                    TiebaStatic.log(new StatisticItem("c12398").param("fid", this.a.l).param(TiebaStatic.Params.TAB_ID, xt6Var.b));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.e.getTabCount() > 0 && !ListUtils.isEmpty(this.i)) {
            int min = Math.min(this.i.size(), this.e.getTabCount());
            for (int i2 = 0; i2 < min; i2++) {
                TbTabLayout.f w = this.e.w(i2);
                xt6 xt6Var = this.i.get(i2);
                if (w != null && xt6Var != null && xt6Var.e == 102 && xt6Var.f != null) {
                    FrsTabItemCustomeView frsTabItemCustomeView = new FrsTabItemCustomeView(this.a.getContext());
                    frsTabItemCustomeView.setNeedNightShade(false);
                    frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(M(TbadkCoreApplication.getInst().getSkinType(), SkinManager.getColor(R.color.plugin_button_shadow_red)), PorterDuff.Mode.SRC_IN));
                    frsTabItemCustomeView.setNeedNightShade(false);
                    frsTabItemCustomeView.e(xt6Var.f);
                    w.o(frsTabItemCustomeView);
                }
            }
        }
    }

    public final void z(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048626, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.a.k());
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
