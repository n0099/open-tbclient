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
import com.baidu.tieba.ak6;
import com.baidu.tieba.b66;
import com.baidu.tieba.bk6;
import com.baidu.tieba.bo6;
import com.baidu.tieba.cj6;
import com.baidu.tieba.dk6;
import com.baidu.tieba.dl6;
import com.baidu.tieba.el6;
import com.baidu.tieba.ew6;
import com.baidu.tieba.ex6;
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
import com.baidu.tieba.fu6;
import com.baidu.tieba.gr8;
import com.baidu.tieba.hj7;
import com.baidu.tieba.ju6;
import com.baidu.tieba.mv6;
import com.baidu.tieba.nk6;
import com.baidu.tieba.nq8;
import com.baidu.tieba.oa5;
import com.baidu.tieba.pa5;
import com.baidu.tieba.pk6;
import com.baidu.tieba.pw4;
import com.baidu.tieba.st6;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.ut6;
import com.baidu.tieba.wi6;
import com.baidu.tieba.wp4;
import com.baidu.tieba.wz4;
import com.baidu.tieba.xi6;
import com.baidu.tieba.xj6;
import com.baidu.tieba.yi;
import com.baidu.tieba.zj6;
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
public class FrsTabViewController implements ew6, TbTabLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ut6 A;
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
    public cj6 n;
    public bo6 o;
    public o p;
    public PublishProgressView q;
    public int r;
    public int s;
    public b66 t;
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

    public static boolean V(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    public void i0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f2) == null) {
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
    public class a extends oa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.oa5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.oa5
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

        @Override // com.baidu.tieba.oa5
        public pa5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, ex6.e(this.c, this.e.j.showAdsense.intValue()));
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
                pa5 pa5Var = new pa5();
                pa5Var.a = frsCommonTabFragment;
                pa5Var.e = this.d;
                pa5Var.i = pa5.k;
                return pa5Var;
            }
            return (pa5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends oa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.oa5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.oa5
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

        @Override // com.baidu.tieba.oa5
        public pa5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsTabWebFragment frsTabWebFragment = new FrsTabWebFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, ex6.e(this.c, this.e.j.showAdsense.intValue()));
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
                pa5 pa5Var = new pa5();
                pa5Var.a = frsTabWebFragment;
                pa5Var.e = this.d;
                pa5Var.i = pa5.k;
                return pa5Var;
            }
            return (pa5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends oa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int c;
        public final /* synthetic */ FrsTabInfo d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.oa5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.oa5
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

        @Override // com.baidu.tieba.oa5
        public pa5 a() {
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
                pa5 pa5Var = new pa5();
                pa5Var.a = frsItemTabFragment;
                pa5Var.e = this.c;
                pa5Var.i = pa5.k;
                return pa5Var;
            }
            return (pa5) invokeV.objValue;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384 && (customResponsedMessage.getData() instanceof ju6)) {
                ju6 ju6Var = (ju6) customResponsedMessage.getData();
                int i = -1;
                for (int i2 = 0; i2 < ListUtils.getCount(this.a.i); i2++) {
                    if (this.a.i.get(i2) != null && (this.a.i.get(i2).b == ju6Var.b || this.a.i.get(i2).e == ju6Var.e)) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cj6) && !this.a.u) {
                this.a.Z();
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
                if (this.a.D() == null) {
                    i2 = 0;
                } else {
                    i2 = this.a.D().a;
                }
                a(i2, i);
            }
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                fu6 fu6Var = new fu6();
                fu6Var.b = i;
                fu6Var.c = i2;
                CustomMessage customMessage = new CustomMessage(2921590);
                customMessage.setTag(this.a.a.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, fu6Var);
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
                    wz4 wz4Var = new wz4(5);
                    wz4Var.n(13);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, wz4Var));
                }
                if (pVar.d == 100) {
                    TiebaStatic.log(new StatisticItem("c13008").param("obj_type", 16));
                }
                if (pVar.d == 102) {
                    TiebaStatic.log(new StatisticItem("c13008").param("fid", this.a.a.k()).param("obj_type", 17));
                }
                if (pVar.b instanceof pk6) {
                    xj6 xj6Var = new xj6();
                    xj6Var.a = pVar.a;
                    xj6Var.b = (pk6) pVar.b;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, xj6Var));
                } else {
                    xj6 xj6Var2 = new xj6();
                    xj6Var2.a = pVar.a;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, xj6Var2));
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
            p D;
            Fragment fragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length != 2) {
                    return;
                }
                String str = split[0];
                String str2 = split[1];
                if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (D = this.a.D()) != null && (fragment = D.b) != null && (fragment instanceof nk6)) {
                    ((nk6) fragment).x();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof PublishProgressData) && (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) != null && !gr8.k().s() && gr8.k().i() != null && this.a.a != null && publishProgressData.isCurrentForum(this.a.a.k()) && this.a.q != null) {
                this.a.q.c(publishProgressData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends oa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.oa5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.oa5
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

        @Override // com.baidu.tieba.oa5
        public pa5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                if (this.e.a != null && this.e.a.j1() != null) {
                    frsAllThreadFragment.s1(this.e.a.j1().X());
                    this.e.a.F4(ex6.e(this.c, this.e.j.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                if (this.e.a != null) {
                    bundle.putString("forum_id", this.e.a.k());
                }
                bundle.putInt(TiebaStatic.Params.TAB_ID, this.d);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                pa5 pa5Var = new pa5();
                pa5Var.a = frsAllThreadFragment;
                pa5Var.e = 1;
                pa5Var.i = pa5.k;
                return pa5Var;
            }
            return (pa5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l extends oa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.oa5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.oa5
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

        @Override // com.baidu.tieba.oa5
        public pa5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, ex6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean(FrsActivityConfig.GOOD, true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.a.k());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                pa5 pa5Var = new pa5();
                pa5Var.a = frsGoodFragment;
                pa5Var.e = this.d;
                pa5Var.i = pa5.k;
                return pa5Var;
            }
            return (pa5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends oa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FrsTabViewController e;

        @Override // com.baidu.tieba.oa5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.oa5
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

        @Override // com.baidu.tieba.oa5
        public pa5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, ex6.e(this.c, this.e.j.showAdsense.intValue()));
                bundle.putString("name", this.e.a.c());
                bundle.putString("from", this.e.a.o3());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.e.a.k());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                pa5 pa5Var = new pa5();
                pa5Var.a = frsNewAreaFragment;
                pa5Var.e = this.d;
                pa5Var.i = pa5.k;
                return pa5Var;
            }
            return (pa5) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class n extends oa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController c;

        @Override // com.baidu.tieba.oa5
        public TbFragmentTabIndicator c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tieba.oa5
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

        @Override // com.baidu.tieba.oa5
        public pa5 a() {
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
                pa5 pa5Var = new pa5();
                pa5Var.a = frsADFragment;
                pa5Var.e = 90;
                pa5Var.i = pa5.k;
                return pa5Var;
            }
            return (pa5) invokeV.objValue;
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
        this.A = st6.a();
        this.B = new f(this, 2001623);
        this.C = new g(this);
        this.D = new h(this, 2001612);
        this.E = new i(this, 0);
        this.F = new j(this, 2921526);
        this.G = new d(this, 2921384);
        this.H = new e(this);
        this.a = frsFragment;
        this.A.a(view2, onClickListener);
        this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c28);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090c23);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f090833);
        this.h = (LinearGradientView) view2.findViewById(R.id.obfuscated_res_0x7f090c26);
        TbTabLayout tbTabLayout = (TbTabLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c25);
        this.e = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.e.setSelectedTabTextBlod(true);
        this.e.setTabTextSize(st6.c());
        b66 b66Var = new b66(frsFragment.getPageContext(), this.e);
        this.t = b66Var;
        b66Var.L(R.drawable.obfuscated_res_0x7f0802f5);
        this.t.o(16);
        this.t.M(true);
        this.t.P(E(R.dimen.tbds34));
        this.t.Q(E(R.dimen.tbds10));
        this.t.m(this.H);
        this.f = (FrsTabViewPager) view2.findViewById(R.id.obfuscated_res_0x7f090c3e);
        this.m = new ArrayList();
        this.l = new FragmentAdapter(this, this.a.getActivity().getSupportFragmentManager(), this.m);
        this.f.addOnPageChangeListener(this.C);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getContext());
        this.g = relativeLayout;
        this.o = new bo6(frsFragment, relativeLayout);
        PublishProgressView publishProgressView = (PublishProgressView) view2.findViewById(R.id.obfuscated_res_0x7f091b32);
        this.q = publishProgressView;
        publishProgressView.setVisibility(8);
    }

    public final int E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return yi.g(TbadkCoreApplication.getInst().getContext(), i2);
        }
        return invokeI.intValue;
    }

    public p K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            for (p pVar : this.m) {
                if (pVar != null && pVar.a == i2) {
                    return pVar;
                }
            }
            return null;
        }
        return (p) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ew6
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.r = i2;
            c0();
        }
    }

    public void h0(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, oVar) == null) {
            this.p = oVar;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.e.setDisableTabSelect(z);
        }
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.s = i2;
        }
    }

    public final void A(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
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

    public final Fragment B(int i2, List<oa5> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, list)) == null) {
            for (oa5 oa5Var : list) {
                Bundle arguments = oa5Var.b().a.getArguments();
                if (arguments != null && i2 == oa5Var.b().e && !arguments.getBoolean("isAdded")) {
                    arguments.putBoolean("isAdded", true);
                    oa5Var.b().a.setArguments(arguments);
                    return oa5Var.b().a;
                }
            }
            return null;
        }
        return (Fragment) invokeIL.objValue;
    }

    public final oa5 C(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsTabInfo)) == null) {
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
        return (oa5) invokeL.objValue;
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            SkinManager.setBackgroundResource(this.c, R.drawable.personalize_tab_shadow);
            c0();
            TbTabLayout tbTabLayout = this.e;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(N(i2, SkinManager.getColor(R.color.plugin_button_shadow_red)));
                this.e.setSelectedIndicatorBottomMargin(E(R.dimen.tbds11));
                SkinManager.setBackgroundColor(this.e, R.color.transparent);
                this.e.setTabTextColors(st6.b(), SkinManager.getColor(R.color.CAM_X0105));
                x(i2);
            }
            if (this.o != null && !R()) {
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
            P(this.j);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921591, this.z));
        }
    }

    public p D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsTabViewPager frsTabViewPager = this.f;
            if (frsTabViewPager == null) {
                return null;
            }
            return (p) ListUtils.getItem(this.m, frsTabViewPager.getCurrentItem());
        }
        return (p) invokeV.objValue;
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public View I() {
        InterceptResult invokeV;
        bo6 bo6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (R() || (bo6Var = this.o) == null) {
                return null;
            }
            return bo6Var.h();
        }
        return (View) invokeV.objValue;
    }

    public RelativeLayout J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public FrsTabViewPager O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return (FrsTabViewPager) invokeV.objValue;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.t.h();
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PublishProgressView publishProgressView = this.q;
            if (publishProgressView == null || publishProgressView.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
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

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.t.S(this.a.getString(R.string.obfuscated_res_0x7f0f03f7), "key_show_frs_tab_click_to_refresh_tip");
        }
    }

    public int G() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<ju6> it = this.i.iterator();
            while (it.hasNext()) {
                ju6 next = it.next();
                if (next != null && ((i2 = next.b) == 1 || i2 == 503)) {
                    return next.b;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            this.d.setAlpha(0.0f);
            pw4.d(this.b).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
        }
    }

    public ju6 L(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.i) != null && tabData.size() > 0) {
                Iterator<ju6> it = this.i.iterator();
                while (it.hasNext()) {
                    ju6 next = it.next();
                    if (next.b == i2) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (ju6) invokeI.objValue;
    }

    public final void P(FrsViewData frsViewData) {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, frsViewData) == null) && frsViewData != null && (themeColorInfo = frsViewData.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
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

    public final boolean U(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, tabData)) == null) {
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

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048598, this, z) != null) || ListUtils.isEmpty(this.m)) {
            return;
        }
        for (p pVar : this.m) {
            if (pVar != null) {
                Fragment fragment = pVar.b;
                if (fragment instanceof nk6) {
                    ((nk6) fragment).g0(z);
                }
            }
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13971").param("fid", this.a.l).param("fname", this.a.c()).param("obj_locate", i2));
        }
    }

    public final int N(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            ThemeColorInfo themeColorInfo = this.k;
            if (themeColorInfo != null) {
                ThemeElement themeElement = themeColorInfo.dark;
                if (themeElement != null && i2 == 4) {
                    return hj7.b(themeElement.font_color);
                }
                ThemeElement themeElement2 = this.k.night;
                if (themeElement2 != null && i2 == 1) {
                    return hj7.b(themeElement2.font_color);
                }
                ThemeElement themeElement3 = this.k.day;
                if (themeElement3 != null && i2 == 0) {
                    return hj7.b(themeElement3.font_color);
                }
                return i3;
            }
            return i3;
        }
        return invokeII.intValue;
    }

    public final void g0(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
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

    public final void s(FrsTabInfo frsTabInfo, oa5 oa5Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048620, this, frsTabInfo, oa5Var) == null) && oa5Var != null && oa5Var.b() != null && (oa5Var.b().a instanceof BaseFragment)) {
            BaseFragment baseFragment = (BaseFragment) oa5Var.b().a;
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
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.x != z) {
                this.x = z;
            }
            if (this.y != z2) {
                this.y = z2;
            }
            t();
        }
    }

    public final boolean S(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, frsTabInfo)) == null) {
            if (frsTabInfo == null || ((frsTabInfo.tab_type.intValue() == 0 && frsTabInfo.tab_id.intValue() >= 100) || ((frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) || (frsTabInfo.tab_type.intValue() == 11 && !V(frsTabInfo.tab_id.intValue()))))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void a0(TabData tabData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, tabData) != null) || ListUtils.isEmpty(tabData)) {
            return;
        }
        boolean isRegistedIntent = TbadkCoreApplication.getInst().isRegistedIntent(HotRanklistActivityConfig.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            ju6 ju6Var = (ju6) it.next();
            if (ju6Var != null && ju6Var.b == 401 && !isRegistedIntent) {
                arrayList.add(ju6Var);
            }
        }
        tabData.removeAll(arrayList);
    }

    @Override // com.baidu.tieba.ew6
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
            Q();
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

    public final boolean T(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            a0(tabData);
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
        ju6 ju6Var;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, fVar) != null) || fVar == null) {
            return;
        }
        int e2 = fVar.e();
        TabData tabData = this.i;
        if (tabData != null && e2 >= 0 && e2 < tabData.size() && (ju6Var = this.i.get(e2)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(ju6Var.b)));
            TiebaStatic.log(new StatisticItem("c12398").param("fid", this.a.l).param(TiebaStatic.Params.TAB_ID, ju6Var.b));
            if (BdNetTypeUtil.isNetworkAvailableForImmediately() && ju6Var.b == 89 && (frsViewData = this.j) != null && frsViewData.isShowRedTip()) {
                this.j.setIsShowRedTip(false);
                fVar.j(0, false);
            }
        }
    }

    public final void x(int i2) {
        FrsTabItemCustomeView frsTabItemCustomeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i2) == null) && this.e.getTabCount() > 0 && !ListUtils.isEmpty(this.i)) {
            int min = Math.min(this.i.size(), this.e.getTabCount());
            for (int i3 = 0; i3 < min; i3++) {
                TbTabLayout.f w = this.e.w(i3);
                ju6 ju6Var = this.i.get(i3);
                if (w != null && ju6Var != null && ju6Var.e == 102 && (w.b() instanceof FrsTabItemCustomeView) && (frsTabItemCustomeView = (FrsTabItemCustomeView) w.b()) != null) {
                    frsTabItemCustomeView.a();
                    frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(N(i2, SkinManager.getColor(R.color.plugin_button_shadow_red)), PorterDuff.Mode.SRC_IN));
                }
            }
        }
    }

    public final List<FrsTabInfo> y(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, frsViewData)) == null) {
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

    public final boolean W(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, frsTabInfo)) == null) {
            if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim()) || ((frsTabInfo.tab_type.intValue() != 1 && frsTabInfo.tab_type.intValue() != 0 && frsTabInfo.tab_type.intValue() != 11 && frsTabInfo.tab_type.intValue() != 12 && frsTabInfo.tab_type.intValue() != 91 && frsTabInfo.tab_type.intValue() != 13 && frsTabInfo.tab_type.intValue() != 14 && frsTabInfo.tab_type.intValue() != 15 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_type.intValue() != 92 && frsTabInfo.tab_type.intValue() != 3 && frsTabInfo.tab_type.intValue() != 17 && frsTabInfo.tab_type.intValue() != 100 && frsTabInfo.tab_type.intValue() != 102) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l0(List<FrsTabInfo> list) {
        FrsFragment frsFragment;
        View X;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        cj6 cj6Var = new cj6(this.a.getActivity().getApplicationContext(), list);
        this.n = cj6Var;
        cj6Var.h(this.a.k());
        this.n.i(this.a.c());
        this.n.j(this.a.o3());
        FrsViewData frsViewData = this.j;
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.n.g(this.j.getForum().getForumGameLabel());
        }
        int i2 = 0;
        for (FrsTabInfo frsTabInfo : list) {
            if (i2 == 0) {
                A(frsTabInfo.tab_id.intValue(), 1);
            }
            if (frsTabInfo.tab_type.intValue() == 3) {
                z(1);
            }
            i2++;
            oa5 C = C(frsTabInfo);
            if (C != null) {
                s(frsTabInfo, C);
                this.n.a(C);
            }
        }
        if (list.get(0) != null && list.get(0).tab_id.intValue() != 1 && (frsFragment = this.a) != null && frsFragment.j1() != null && (X = this.a.j1().X()) != null && (X.getParent() instanceof ViewGroup)) {
            ((ViewGroup) X.getParent()).removeView(X);
        }
        this.u = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.n));
    }

    public final void Z() {
        cj6 cj6Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || (cj6Var = this.n) == null) {
            return;
        }
        List<oa5> f2 = cj6Var.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.i)) {
            return;
        }
        if (this.e.getTabCount() > 0) {
            this.e.B();
        }
        e0();
        ArrayList arrayList = new ArrayList();
        this.e.setSelectedTabIndicatorColor(N(TbadkCoreApplication.getInst().getSkinType(), SkinManager.getColor(R.color.plugin_button_shadow_red)));
        this.e.setSelectedIndicatorBottomMargin(E(R.dimen.tbds10));
        Iterator<ju6> it = this.i.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            ju6 next = it.next();
            Fragment B = B(next.b, f2);
            if (B != null) {
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
                pVar.b = B;
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
        w();
        this.f.setOffscreenPageLimit(this.m.size());
        this.f.setCurrentItem(i2, false);
        this.f.d();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
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

    public final void e0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.f != null && this.l != null && this.m != null) {
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

    @Override // com.baidu.tieba.ew6
    public void d(FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048607, this, frsViewData, i2) == null) && frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().a != null) {
            P(frsViewData);
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            v(frsViewData, tabData, arrayList);
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.j = frsViewData;
                if (frsViewData.getForum() != null) {
                    this.k = this.j.getForum().getThemeColorInfo();
                }
                if (!U(tabData) && this.e.getTabCount() > 0 && !ListUtils.isEmpty(this.i)) {
                    int min = Math.min(this.i.size(), this.e.getTabCount());
                    for (int i3 = 0; i3 < min; i3++) {
                        TbTabLayout.f w = this.e.w(i3);
                        if (w != null) {
                            if (frsViewData.isShowRedTip() && this.i.get(i3).b == 89) {
                                w.j(0, true);
                            } else {
                                w.j(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> y = y(frsViewData);
                    if (R()) {
                        FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(y, 0);
                        FrsFragment frsFragment = this.a;
                        if (frsFragment != null && frsFragment.J0() != null && frsTabInfo != null) {
                            this.a.J0().O0(frsTabInfo.tab_id.intValue());
                        }
                    } else {
                        FrsFragment frsFragment2 = this.a;
                        if (frsFragment2 != null && frsFragment2.y3() != null) {
                            if (y != null && y.size() < 2) {
                                this.a.y3().removeHeaderView(this.g);
                            } else {
                                this.a.y3().removeHeaderView(this.g);
                                this.a.y3().t(this.g, 0);
                                if (this.o != null && frsViewData.getForum() != null) {
                                    this.o.j(y);
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
                if (!T(tabData)) {
                    return;
                }
                this.i = tabData;
                f0();
                l0(arrayList);
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
                ju6 ju6Var = this.i.get(e2);
                if (ju6Var != null) {
                    if (102 == ju6Var.e && (fVar.b() instanceof FrsTabItemCustomeView)) {
                        ((FrsTabItemCustomeView) fVar.b()).b(true);
                    }
                    this.w = ju6Var.b;
                    if (BdNetTypeUtil.isNetworkAvailableForImmediately() && ju6Var.b == 89 && (frsViewData = this.j) != null && frsViewData.isShowRedTip()) {
                        this.j.setIsShowRedTip(false);
                        fVar.j(0, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(ju6Var.b)));
                    }
                    if (ju6Var.b == 502) {
                        if (this.a.H3() != null) {
                            this.a.H3().setIconFade(R.drawable.btn_frs_professional_edit_n);
                        }
                    } else if (this.a.H3() != null) {
                        this.a.H3().setIconFade(0);
                    }
                    if (UbsABTestHelper.isFrsTabLocationTestC()) {
                        FrsTabTestHelper.storeUserLastAccessTab(ju6Var.a);
                    }
                    o oVar = this.p;
                    if (oVar != null) {
                        oVar.a(ju6Var.b, ju6Var.e, ju6Var.a);
                    }
                    xi6 f2 = xi6.f();
                    if (ju6Var.e == 14) {
                        z = true;
                    }
                    f2.t(z);
                    wi6.h().o(ju6Var.b);
                    TiebaStatic.log(new StatisticItem("c12398").param("fid", this.a.l).param(TiebaStatic.Params.TAB_ID, ju6Var.b));
                }
            }
        }
    }

    public final void v(FrsViewData frsViewData, TabData tabData, List<FrsTabInfo> list) {
        AccountData currentAccountObj;
        String str;
        List<zj6> list2;
        List<zj6> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048623, this, frsViewData, tabData, list) == null) {
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().a) {
                if (!W(frsTabInfo) && !S(frsTabInfo)) {
                    if (frsTabInfo.is_general_tab.intValue() != 1 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_id.intValue() != 506 && frsTabInfo.tab_type.intValue() != 102) {
                        if (frsTabInfo.tab_id.intValue() != 89 && frsTabInfo.tab_id.intValue() != 503) {
                            if (frsTabInfo.tab_type.intValue() == 12) {
                                ju6 ju6Var = new ju6();
                                ju6Var.b = frsTabInfo.tab_id.intValue();
                                ju6Var.a = frsTabInfo.tab_name;
                                ju6Var.e = frsTabInfo.tab_type.intValue();
                                tabData.add(ju6Var);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                                if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                    ju6 ju6Var2 = new ju6();
                                    ju6Var2.b = frsTabInfo.tab_id.intValue();
                                    ju6Var2.a = frsTabInfo.tab_name;
                                    ju6Var2.e = frsTabInfo.tab_type.intValue();
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
                                    ju6Var2.d = sb2;
                                    g0(sb2, "c10078");
                                    tabData.add(ju6Var2);
                                    list.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_type.intValue() == 11 && V(frsTabInfo.tab_id.intValue())) {
                                ju6 ju6Var3 = new ju6();
                                ju6Var3.b = frsTabInfo.tab_id.intValue();
                                ju6Var3.a = frsTabInfo.tab_name;
                                ju6Var3.d = frsTabInfo.tab_url;
                                ju6Var3.e = frsTabInfo.tab_type.intValue();
                                if (wp4.i(ju6Var3.d)) {
                                    if (MessageManager.getInstance().findTask(2016447) != null) {
                                        tabData.add(ju6Var3);
                                        list.add(frsTabInfo);
                                    }
                                } else {
                                    tabData.add(ju6Var3);
                                    list.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_id.intValue() != 1 && dk6.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                                ju6 ju6Var4 = new ju6();
                                ju6Var4.b = frsTabInfo.tab_id.intValue();
                                ju6Var4.a = frsTabInfo.tab_name;
                                ju6Var4.e = frsTabInfo.tab_type.intValue();
                                bk6 b2 = ak6.a().b(ju6Var4.b);
                                if (b2 != null && (list3 = b2.b) != null && list3.size() > 0) {
                                    el6 el6Var = new el6();
                                    ju6Var4.c = el6Var;
                                    el6Var.a = b2.a;
                                    el6Var.b = new LinkedList();
                                    boolean z = true;
                                    for (zj6 zj6Var : b2.b) {
                                        if (zj6Var != null) {
                                            dl6 dl6Var = new dl6();
                                            dl6Var.a = zj6Var.a;
                                            dl6Var.b = zj6Var.b;
                                            if (z) {
                                                dl6Var.c = true;
                                                z = false;
                                            }
                                            ju6Var4.c.b.add(dl6Var);
                                        }
                                    }
                                }
                                tabData.add(ju6Var4);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 1) {
                                ju6 ju6Var5 = new ju6();
                                ju6Var5.b = frsTabInfo.tab_id.intValue();
                                ju6Var5.a = frsTabInfo.tab_name;
                                ju6Var5.e = frsTabInfo.tab_type.intValue();
                                bk6 b3 = ak6.a().b(ju6Var5.b);
                                if (b3 != null && (list2 = b3.b) != null && list2.size() > 0) {
                                    el6 el6Var2 = new el6();
                                    ju6Var5.c = el6Var2;
                                    el6Var2.a = b3.a;
                                    el6Var2.b = new LinkedList();
                                    for (zj6 zj6Var2 : b3.b) {
                                        if (zj6Var2 != null) {
                                            dl6 dl6Var2 = new dl6();
                                            dl6Var2.a = zj6Var2.a;
                                            dl6Var2.b = zj6Var2.b;
                                            ju6Var5.c.b.add(dl6Var2);
                                        }
                                    }
                                }
                                tabData.add(ju6Var5);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 49) {
                                if (this.a.j1().Y().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                                    ju6 ju6Var6 = new ju6();
                                    ju6Var6.a = frsTabInfo.tab_name;
                                    if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                        ju6Var6.a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                    }
                                    int i2 = this.s;
                                    if (i2 > 0 && i2 != frsViewData.getAlaLiveCount() && this.s <= 99) {
                                        ju6Var6.a = frsTabInfo.tab_name + "(" + this.s + SmallTailInfo.EMOTION_SUFFIX;
                                    } else if (this.s <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                        int i3 = this.s;
                                        if (i3 == 0 && i3 != frsViewData.getAlaLiveCount()) {
                                            ju6Var6.a = frsTabInfo.tab_name;
                                        }
                                    } else {
                                        ju6Var6.a = frsTabInfo.tab_name + "(99+)";
                                    }
                                    ju6Var6.b = frsTabInfo.tab_id.intValue();
                                    ju6Var6.e = frsTabInfo.tab_type.intValue();
                                    tabData.add(ju6Var6);
                                    list.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_id.intValue() == 1120) {
                                ju6 ju6Var7 = new ju6();
                                ju6Var7.b = frsTabInfo.tab_id.intValue();
                                ju6Var7.a = frsTabInfo.tab_name;
                                ju6Var7.e = frsTabInfo.tab_type.intValue();
                                tabData.add(ju6Var7);
                                list.add(frsTabInfo);
                                z(2);
                            } else if (frsTabInfo.tab_id.intValue() == 90) {
                                ju6 ju6Var8 = new ju6();
                                ju6Var8.b = frsTabInfo.tab_id.intValue();
                                ju6Var8.a = frsTabInfo.tab_name;
                                ju6Var8.e = frsTabInfo.tab_type.intValue();
                                tabData.add(ju6Var8);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 91) {
                                ju6 ju6Var9 = new ju6();
                                ju6Var9.b = frsTabInfo.tab_id.intValue();
                                ju6Var9.a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, (String) null);
                                ju6Var9.e = frsTabInfo.tab_type.intValue();
                                tabData.add(ju6Var9);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 504) {
                                ju6 ju6Var10 = new ju6();
                                ju6Var10.b = frsTabInfo.tab_id.intValue();
                                ju6Var10.a = frsTabInfo.tab_name;
                                ju6Var10.e = frsTabInfo.tab_type.intValue();
                                tabData.add(ju6Var10);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 3) {
                                ju6 ju6Var11 = new ju6();
                                ju6Var11.b = frsTabInfo.tab_id.intValue();
                                ju6Var11.a = frsTabInfo.tab_name;
                                ju6Var11.e = frsTabInfo.tab_type.intValue();
                                tabData.add(ju6Var11);
                                list.add(frsTabInfo);
                                z(1);
                            }
                        } else {
                            ju6 ju6Var12 = new ju6();
                            ju6Var12.b = frsTabInfo.tab_id.intValue();
                            ju6Var12.a = frsTabInfo.tab_name;
                            ju6Var12.e = frsTabInfo.tab_type.intValue();
                            tabData.add(ju6Var12);
                            list.add(frsTabInfo);
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
                                int h2 = mv6.h("503~" + str + str2);
                                if (h2 == -1) {
                                    Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().b.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            FrsTabInfo next = it.next();
                                            if (next.tab_type == frsTabInfo.tab_type) {
                                                mv6.i("503~" + str + str2, next.tab_id.intValue());
                                                if (7 == h2) {
                                                    nq8.b();
                                                } else {
                                                    nq8.a();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        ju6 ju6Var13 = new ju6();
                        ju6Var13.a = frsTabInfo.tab_name;
                        ju6Var13.b = frsTabInfo.tab_id.intValue();
                        ju6Var13.e = frsTabInfo.tab_type.intValue();
                        ju6Var13.f = frsTabInfo.head_pics;
                        ju6Var13.d = frsTabInfo.tab_url;
                        tabData.add(ju6Var13);
                        list.add(frsTabInfo);
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && this.e.getTabCount() > 0 && !ListUtils.isEmpty(this.i)) {
            int min = Math.min(this.i.size(), this.e.getTabCount());
            for (int i2 = 0; i2 < min; i2++) {
                TbTabLayout.f w = this.e.w(i2);
                ju6 ju6Var = this.i.get(i2);
                if (w != null && ju6Var != null && ju6Var.e == 102 && ju6Var.f != null) {
                    FrsTabItemCustomeView frsTabItemCustomeView = new FrsTabItemCustomeView(this.a.getContext());
                    frsTabItemCustomeView.setNeedNightShade(false);
                    frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(N(TbadkCoreApplication.getInst().getSkinType(), SkinManager.getColor(R.color.plugin_button_shadow_red)), PorterDuff.Mode.SRC_IN));
                    frsTabItemCustomeView.setNeedNightShade(false);
                    frsTabItemCustomeView.e(ju6Var.f);
                    w.o(frsTabItemCustomeView);
                }
            }
        }
    }
}
