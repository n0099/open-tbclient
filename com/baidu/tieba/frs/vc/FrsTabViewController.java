package com.baidu.tieba.frs.vc;

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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.ag7;
import com.baidu.tieba.bg7;
import com.baidu.tieba.bs7;
import com.baidu.tieba.cg7;
import com.baidu.tieba.df7;
import com.baidu.tieba.ea5;
import com.baidu.tieba.eg7;
import com.baidu.tieba.fh7;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.tab.FrsTabItemCustomeView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.fs7;
import com.baidu.tieba.gh7;
import com.baidu.tieba.gk7;
import com.baidu.tieba.gu7;
import com.baidu.tieba.hq7;
import com.baidu.tieba.jq7;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.lr6;
import com.baidu.tieba.nt7;
import com.baidu.tieba.pg7;
import com.baidu.tieba.rg7;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.uw4;
import com.baidu.tieba.wca;
import com.baidu.tieba.xe7;
import com.baidu.tieba.xs7;
import com.baidu.tieba.ye7;
import com.baidu.tieba.yf7;
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
/* loaded from: classes5.dex */
public class FrsTabViewController implements gu7, TbTabLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final jq7 A;
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
    public df7 m;
    public gk7 n;
    public h o;
    public PublishProgressView p;
    public int q;
    public int r;
    public lr6 s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public String y;
    public int z;

    /* loaded from: classes5.dex */
    public interface h {
        void a(int i, int i2, String str, boolean z);
    }

    public static boolean T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 > 200 && i2 <= 300 : invokeI.booleanValue;
    }

    public void g0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List<i> b;
        public final /* synthetic */ FrsTabViewController c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FrsTabViewController frsTabViewController, FragmentManager fragmentManager, List<i> list) {
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
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            if (list != null) {
                arrayList.addAll(list);
            }
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i, obj) == null) {
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

        public void c(List<i> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                this.b = arrayList;
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.b.get(i).b;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return this.b.get(i).c;
            }
            return (CharSequence) invokeI.objValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a = -1;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsTabViewController frsTabViewController, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof df7) && !this.a.t) {
                this.a.X();
                this.a.t = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public b(FrsTabViewController frsTabViewController) {
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
                if (this.a.B() == null) {
                    i2 = 0;
                } else {
                    i2 = this.a.B().a;
                }
                a(i2, i);
            }
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                bs7 bs7Var = new bs7();
                bs7Var.b = i;
                bs7Var.c = i2;
                CustomMessage customMessage = new CustomMessage(2921590);
                customMessage.setTag(this.a.a.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, bs7Var);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.a.f != null && this.a.l != null) {
                this.a.f.d();
                if (!ListUtils.isEmpty(this.a.l.b) && this.a.l.b.size() > i) {
                    i iVar = (i) ListUtils.getItem(this.a.l.b, i);
                    if (iVar.a == 506) {
                        ea5 ea5Var = new ea5(5);
                        ea5Var.p(13);
                        Fragment fragment = iVar.b;
                        if (fragment instanceof FrsItemTabFragment) {
                            FrsItemTabFragment frsItemTabFragment = (FrsItemTabFragment) fragment;
                            if (frsItemTabFragment.K1() != null) {
                                str = frsItemTabFragment.K1().category1;
                            } else {
                                str = "";
                            }
                            ea5Var.l(str);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ea5Var));
                    }
                    if (iVar.d == 100) {
                        TiebaStatic.log(new StatisticItem("c13008").param("obj_type", 16));
                    }
                    if (iVar.d == 102) {
                        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.a.a.w()).param("obj_type", 17));
                    }
                    if (iVar.b instanceof rg7) {
                        yf7 yf7Var = new yf7();
                        yf7Var.a = iVar.a;
                        yf7Var.b = (rg7) iVar.b;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, yf7Var));
                    } else {
                        yf7 yf7Var2 = new yf7();
                        yf7Var2.a = iVar.a;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, yf7Var2));
                    }
                    int i2 = 0;
                    a(iVar.a, 0);
                    OvalActionButton b4 = this.a.a.b4();
                    if (!this.a.a.s3(iVar.a)) {
                        i2 = 8;
                    }
                    b4.setVisibility(i2);
                }
                if (this.a.a != null && (this.a.a.getActivity() instanceof FrsActivity)) {
                    ((FrsActivity) this.a.a.getActivity()).v1().a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsTabViewController frsTabViewController, int i) {
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

    /* loaded from: classes5.dex */
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
            i B;
            Fragment fragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length != 2) {
                    return;
                }
                String str = split[0];
                String str2 = split[1];
                if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (B = this.a.B()) != null && (fragment = B.b) != null && (fragment instanceof pg7)) {
                    ((pg7) fragment).h();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsTabViewController frsTabViewController, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof PublishProgressData) && (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) != null && !WriteMsgHolder.isFromVideoHotTopic() && WriteMsgHolder.getCurrentWriteActivityFromTag() != null && this.a.a != null && publishProgressData.isCurrentForum(this.a.a.w()) && this.a.p != null) {
                this.a.p.c(publishProgressData);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384 && (customResponsedMessage.getData() instanceof fs7)) {
                fs7 fs7Var = (fs7) customResponsedMessage.getData();
                int i = -1;
                for (int i2 = 0; i2 < ListUtils.getCount(this.a.i); i2++) {
                    if (this.a.i.get(i2) != null && (this.a.i.get(i2).b == fs7Var.b || this.a.i.get(i2).e == fs7Var.e)) {
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

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Fragment b;
        public String c;
        public int d;

        public i(FrsTabViewController frsTabViewController) {
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
        this.q = 0;
        this.r = -1;
        this.t = false;
        this.w = false;
        this.x = false;
        this.A = hq7.a();
        this.B = new a(this, 2001623);
        this.C = new b(this);
        this.D = new c(this, 2001612);
        this.E = new d(this, 0);
        this.F = new e(this, 2921526);
        this.G = new f(this, 2921384);
        this.H = new g(this);
        this.a = frsFragment;
        this.A.a(view2, onClickListener);
        this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d7d);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090d78);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f090915);
        this.h = (LinearGradientView) view2.findViewById(R.id.obfuscated_res_0x7f090d7b);
        TbTabLayout tbTabLayout = (TbTabLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d7a);
        this.e = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.e.setSelectedTabTextBlod(true);
        this.e.setTabTextSize(hq7.c());
        lr6 lr6Var = new lr6(frsFragment.getPageContext(), this.e);
        this.s = lr6Var;
        lr6Var.L(R.drawable.bg_tip_blue_up_left);
        this.s.o(16);
        this.s.N(true);
        this.s.Q(C(R.dimen.tbds34));
        this.s.R(C(R.dimen.tbds10));
        this.s.m(this.H);
        this.f = (FrsTabViewPager) view2.findViewById(R.id.obfuscated_res_0x7f090d93);
        this.l = new FragmentAdapter(this, this.a.getActivity().getSupportFragmentManager(), null);
        this.f.addOnPageChangeListener(this.C);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getContext());
        this.g = relativeLayout;
        this.n = new gk7(frsFragment, relativeLayout);
        PublishProgressView publishProgressView = (PublishProgressView) view2.findViewById(R.id.obfuscated_res_0x7f091d93);
        this.p = publishProgressView;
        publishProgressView.setVisibility(8);
    }

    public final int C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), i2);
        }
        return invokeI.intValue;
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.z = i2;
        }
    }

    @Override // com.baidu.tieba.gu7
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.q = i2;
            Z();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921761, Integer.valueOf(i2)));
        }
    }

    public void f0(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, hVar) == null) {
            this.o = hVar;
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.e.setDisableTabSelect(z);
        }
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.r = i2;
        }
    }

    public final int L(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            ThemeColorInfo themeColorInfo = this.k;
            if (themeColorInfo != null) {
                ThemeElement themeElement = themeColorInfo.dark;
                if (themeElement != null && i2 == 4) {
                    return ColorUtils.parseColor(themeElement.font_color);
                }
                ThemeElement themeElement2 = this.k.day;
                if (themeElement2 != null && i2 == 0) {
                    return ColorUtils.parseColor(themeElement2.font_color);
                }
                return i3;
            }
            return i3;
        }
        return invokeII.intValue;
    }

    public final Fragment A(int i2, List<FragmentDelegate> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, list)) == null) {
            for (FragmentDelegate fragmentDelegate : list) {
                Bundle arguments = fragmentDelegate.getFragmentTabStructure().frag.getArguments();
                if (arguments != null && i2 == fragmentDelegate.getFragmentTabStructure().type && !arguments.getBoolean("isAdded")) {
                    arguments.putBoolean("isAdded", true);
                    fragmentDelegate.getFragmentTabStructure().frag.setArguments(arguments);
                    return fragmentDelegate.getFragmentTabStructure().frag;
                }
            }
            return null;
        }
        return (Fragment) invokeIL.objValue;
    }

    public i B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsTabViewPager frsTabViewPager = this.f;
            if (frsTabViewPager != null && this.l != null) {
                return (i) ListUtils.getItem(this.l.b, frsTabViewPager.getCurrentItem());
            }
            return null;
        }
        return (i) invokeV.objValue;
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
    }

    public View G() {
        InterceptResult invokeV;
        gk7 gk7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (P() || (gk7Var = this.n) == null) {
                return null;
            }
            return gk7Var.h();
        }
        return (View) invokeV.objValue;
    }

    public RelativeLayout H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public FrsTabViewPager M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f;
        }
        return (FrsTabViewPager) invokeV.objValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.s.h();
        }
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PublishProgressView publishProgressView = this.p;
            if (publishProgressView == null || publishProgressView.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void c0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
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
                frsFragment.O0 = i2;
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.s.T(this.a.getString(R.string.obfuscated_res_0x7f0f0464), "key_show_frs_tab_click_to_refresh_tip");
        }
    }

    public int E() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Iterator<fs7> it = this.i.iterator();
            while (it.hasNext()) {
                fs7 next = it.next();
                if (next != null && ((i2 = next.b) == 1 || i2 == 503)) {
                    return next.b;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.B.setPriority(Integer.MAX_VALUE);
            this.a.registerListener(this.B);
            this.a.registerListener(this.D);
            FrsFragment frsFragment = this.a;
            frsFragment.registerListener(2001446, this.E, frsFragment.getBaseFragmentActivity().getUniqueId());
            this.a.registerListener(this.G);
            this.a.registerListener(this.F);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            this.d.setAlpha(0.0f);
            EMManager.from(this.b).setGradientColor(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
        }
    }

    public i I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            FragmentAdapter fragmentAdapter = this.l;
            if (fragmentAdapter == null) {
                return null;
            }
            for (i iVar : fragmentAdapter.b) {
                if (iVar != null && iVar.a == i2) {
                    return iVar;
                }
            }
            return null;
        }
        return (i) invokeI.objValue;
    }

    public fs7 J(int i2) {
        InterceptResult invokeI;
        TabData tabData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 >= 0 && (tabData = this.i) != null && tabData.size() > 0) {
                Iterator<fs7> it = this.i.iterator();
                while (it.hasNext()) {
                    fs7 next = it.next();
                    if (next.b == i2) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (fs7) invokeI.objValue;
    }

    public final void N(FrsViewData frsViewData) {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && frsViewData != null && (themeColorInfo = frsViewData.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                themeElement = themeColorInfo.dark;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.y = themeElement.common_color;
        }
    }

    public final boolean S(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, tabData)) == null) {
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

    public void V(boolean z) {
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (fragmentAdapter = this.l) != null && !ListUtils.isEmpty(fragmentAdapter.b)) {
            for (i iVar : this.l.b) {
                if (iVar != null) {
                    Fragment fragment = iVar.b;
                    if (fragment instanceof pg7) {
                        ((pg7) fragment).r0(z);
                    }
                }
            }
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13971").param("fid", this.a.l).param("fname", this.a.v()).param("obj_locate", i2));
        }
    }

    public final boolean Q(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, frsTabInfo)) == null) {
            if (frsTabInfo == null || ((frsTabInfo.tab_type.intValue() == 0 && frsTabInfo.tab_id.intValue() >= 100) || ((frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) || (frsTabInfo.tab_type.intValue() == 11 && !T(frsTabInfo.tab_id.intValue()))))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.gu7
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
            O();
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.y0() != null) {
                this.a.y0().X();
            }
            int e2 = fVar.e();
            TabData tabData = this.i;
            if (tabData != null && e2 >= 0 && e2 < tabData.size() && this.i.get(e2) != null && 102 == this.i.get(e2).e && (fVar.b() instanceof FrsTabItemCustomeView)) {
                ((FrsTabItemCustomeView) fVar.b()).b(false);
            }
        }
    }

    public final boolean R(TabData tabData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, tabData)) == null) {
            if (ListUtils.isEmpty(tabData)) {
                return false;
            }
            if (ListUtils.isEmpty(this.l.b) || tabData.size() != this.l.b.size()) {
                return true;
            }
            int size = tabData.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (tabData.get(i2) != null && this.l.b.get(i2) != null && tabData.get(i2).b != ((i) this.l.b.get(i2)).a) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        fs7 fs7Var;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, fVar) != null) || fVar == null) {
            return;
        }
        int e2 = fVar.e();
        TabData tabData = this.i;
        if (tabData != null && e2 >= 0 && e2 < tabData.size() && (fs7Var = this.i.get(e2)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(fs7Var.b)));
            TiebaStatic.log(new StatisticItem("c12398").param("fid", this.a.l).param("tab_id", fs7Var.b));
            if (BdNetTypeUtil.isNetworkAvailableForImmediately() && fs7Var.b == 89 && (frsViewData = this.j) != null && frsViewData.isShowRedTip()) {
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
                fs7 fs7Var = this.i.get(i3);
                if (w != null && fs7Var != null && fs7Var.e == 102 && (w.b() instanceof FrsTabItemCustomeView) && (frsTabItemCustomeView = (FrsTabItemCustomeView) w.b()) != null) {
                    frsTabItemCustomeView.a();
                    frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(L(i2, SkinManager.getColor(R.color.plugin_button_shadow_red)), PorterDuff.Mode.SRC_IN));
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

    public final boolean U(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, frsTabInfo)) == null) {
            if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim()) || ((frsTabInfo.tab_type.intValue() != 1 && frsTabInfo.tab_type.intValue() != 0 && frsTabInfo.tab_type.intValue() != 11 && frsTabInfo.tab_type.intValue() != 12 && frsTabInfo.tab_type.intValue() != 91 && frsTabInfo.tab_type.intValue() != 13 && frsTabInfo.tab_type.intValue() != 14 && frsTabInfo.tab_type.intValue() != 15 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_type.intValue() != 92 && frsTabInfo.tab_type.intValue() != 3 && frsTabInfo.tab_type.intValue() != 17 && frsTabInfo.tab_type.intValue() != 100 && frsTabInfo.tab_type.intValue() != 102) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j0(List<FrsTabInfo> list) {
        FrsFragment frsFragment;
        View Z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        df7 df7Var = new df7(this.a.getActivity().getApplicationContext(), list);
        this.m = df7Var;
        df7Var.h(this.a.w());
        this.m.i(this.a.v());
        this.m.j(this.a.getFrom());
        FrsViewData frsViewData = this.j;
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.m.g(this.j.getForum().getForumGameLabel());
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
            FragmentDelegate a2 = xs7.a(frsTabInfo, this.a, this.j, this.y);
            if (a2 != null) {
                r(frsTabInfo, a2);
                this.m.a(a2);
            }
        }
        if (list.get(0) != null && list.get(0).tab_id.intValue() != 1 && (frsFragment = this.a) != null && frsFragment.z1() != null && (Z = this.a.z1().Z()) != null && (Z.getParent() instanceof ViewGroup)) {
            ((ViewGroup) Z.getParent()).removeView(Z);
        }
        this.t = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.m));
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            SkinManager.setBackgroundResource(this.c, R.drawable.personalize_tab_shadow);
            Z();
            TbTabLayout tbTabLayout = this.e;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(L(i2, SkinManager.getColor(R.color.plugin_button_shadow_red)));
                this.e.setSelectedIndicatorBottomMargin(C(R.dimen.tbds11));
                SkinManager.setBackgroundColor(this.e, R.color.transparent);
                this.e.setTabTextColors(hq7.b(), SkinManager.getColor(R.color.CAM_X0105));
                w(i2);
            }
            if (this.n != null && !P()) {
                this.n.i();
            }
            LinearGradientView linearGradientView = this.h;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            FragmentAdapter fragmentAdapter = this.l;
            if (fragmentAdapter != null && !ListUtils.isEmpty(fragmentAdapter.b)) {
                for (i iVar : this.l.b) {
                    if (iVar != null) {
                        Fragment fragment = iVar.b;
                        if (fragment instanceof BaseFragment) {
                            ((BaseFragment) fragment).changeSkinType(i2);
                        }
                    }
                }
            }
            N(this.j);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921591, this.y));
        }
    }

    public final void X() {
        df7 df7Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (df7Var = this.m) == null) {
            return;
        }
        List<FragmentDelegate> f2 = df7Var.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.i)) {
            return;
        }
        if (this.e.getTabCount() > 0) {
            this.e.B();
        }
        b0();
        ArrayList arrayList = new ArrayList();
        this.e.setSelectedTabIndicatorColor(L(TbadkCoreApplication.getInst().getSkinType(), SkinManager.getColor(R.color.plugin_button_shadow_red)));
        this.e.setSelectedIndicatorBottomMargin(C(R.dimen.tbds10));
        Iterator<fs7> it = this.i.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            fs7 next = it.next();
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
                if (!FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.a.getFrom()) ? !(!FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.getFrom()) || 506 != next.b) : 3 == next.e) {
                    i2 = i4;
                }
                int i5 = this.z;
                if (i5 > 0 && i5 == next.b) {
                    i2 = i4;
                }
                FrsViewData frsViewData = this.j;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.b == 89) {
                    z2.j(0, true);
                } else {
                    z2.j(0, false);
                }
                this.e.f(z2, z);
                i iVar = new i(this);
                iVar.a = next.b;
                iVar.c = next.a;
                iVar.b = A;
                iVar.d = next.e;
                arrayList.add(iVar);
                i4++;
            } else {
                it.remove();
            }
        }
        if (i2 < 0) {
            i2 = Math.max(i3, 0);
        }
        FragmentAdapter fragmentAdapter = this.l;
        if (fragmentAdapter == null) {
            this.l = new FragmentAdapter(this, this.a.getActivity().getSupportFragmentManager(), arrayList);
        } else {
            fragmentAdapter.d();
            this.l.c(arrayList);
        }
        this.f.setAdapter(this.l);
        this.l.notifyDataSetChanged();
        if (this.e.getTabCount() > 0 && this.b.getVisibility() != 0) {
            this.b.setVisibility(0);
        }
        this.e.setupWithViewPager(this.f);
        v();
        this.f.setOffscreenPageLimit(this.l.b.size());
        this.f.setCurrentItem(i2, false);
        this.f.d();
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            int i2 = this.q;
            if (i2 == 2) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
                this.c.setVisibility(0);
                this.a.f4();
            } else if (i2 == 1) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
                this.c.setVisibility(0);
            } else {
                s();
                this.c.setVisibility(8);
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.f4();
                }
            }
        }
    }

    public final void b0() {
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.f != null && (fragmentAdapter = this.l) != null && fragmentAdapter.b != null) {
            try {
                FragmentManager supportFragmentManager = this.a.getActivity().getSupportFragmentManager();
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                int size = this.l.b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = (i) this.l.b.get(i2);
                    if (iVar != null && iVar.b != null) {
                        beginTransaction.remove(iVar.b);
                    }
                }
                beginTransaction.commit();
                supportFragmentManager.executePendingTransactions();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.gu7
    public void d(FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048607, this, frsViewData, i2) == null) && frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().a != null) {
            N(frsViewData);
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            u(frsViewData, tabData, arrayList);
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.j = frsViewData;
                if (frsViewData.getForum() != null) {
                    this.k = this.j.getForum().getThemeColorInfo();
                }
                if (!S(tabData) && this.e.getTabCount() > 0 && !ListUtils.isEmpty(this.i)) {
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
                    List<FrsTabInfo> x = x(frsViewData);
                    if (P()) {
                        FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(x, 0);
                        FrsFragment frsFragment = this.a;
                        if (frsFragment != null && frsFragment.W0() != null && frsTabInfo != null) {
                            this.a.W0().c1(frsTabInfo.tab_id.intValue());
                        }
                    } else {
                        FrsFragment frsFragment2 = this.a;
                        if (frsFragment2 != null && frsFragment2.Q3() != null) {
                            if (x != null && x.size() < 2) {
                                this.a.Q3().removeHeaderView(this.g);
                            } else {
                                this.a.Q3().removeHeaderView(this.g);
                                this.a.Q3().addHeaderView(this.g, 0);
                                if (this.n != null && frsViewData.getForum() != null) {
                                    this.n.j(x);
                                    this.n.k(frsViewData.getForum().getId());
                                    this.n.g(this.a.W0().i0());
                                    if (UbsABTestHelper.isFrsNewAreaTabSortTestA() && FrsTabTestHelper.HAVE_NOT_RECORD_SORT != FrsTabTestHelper.getFrsNewAreaTabSort()) {
                                        this.n.g(FrsTabTestHelper.getFrsNewAreaTabSort());
                                    }
                                }
                            }
                        }
                    }
                }
                if (!R(tabData)) {
                    return;
                }
                this.i = tabData;
                c0();
                j0(arrayList);
            }
        }
    }

    public final void d0(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
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

    public final void r(FrsTabInfo frsTabInfo, FragmentDelegate fragmentDelegate) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048618, this, frsTabInfo, fragmentDelegate) == null) && fragmentDelegate != null && fragmentDelegate.getFragmentTabStructure() != null && (fragmentDelegate.getFragmentTabStructure().frag instanceof BaseFragment)) {
            BaseFragment baseFragment = (BaseFragment) fragmentDelegate.getFragmentTabStructure().frag;
            if (frsTabInfo != null) {
                str = frsTabInfo.tab_name;
            } else {
                str = "";
            }
            baseFragment.setTbPageExtraPageTabName(str);
        }
    }

    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.w != z) {
                this.w = z;
            }
            if (this.x != z2) {
                this.x = z2;
            }
            s();
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
                FragmentAdapter fragmentAdapter = this.l;
                if (fragmentAdapter != null && !ListUtils.isEmpty(fragmentAdapter.b) && ListUtils.getCount(this.l.b) > e2 && this.l.b.get(e2) != null && (((i) this.l.b.get(e2)).b instanceof BaseFragment)) {
                    customMessage.setTag(((BaseFragment) ((i) this.l.b.get(e2)).b).getUniqueId());
                    customResponsedMessage.setOrginalMessage(customMessage);
                }
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                fs7 fs7Var = this.i.get(e2);
                if (fs7Var != null) {
                    if (102 == fs7Var.e && (fVar.b() instanceof FrsTabItemCustomeView)) {
                        ((FrsTabItemCustomeView) fVar.b()).b(true);
                    }
                    this.v = fs7Var.b;
                    if (BdNetTypeUtil.isNetworkAvailableForImmediately() && fs7Var.b == 89 && (frsViewData = this.j) != null && frsViewData.isShowRedTip()) {
                        this.j.setIsShowRedTip(false);
                        fVar.j(0, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(fs7Var.b)));
                    }
                    if (this.a.b4() != null) {
                        this.a.b4().setIconFade(0);
                    }
                    if (UbsABTestHelper.isFrsTabLocationTestC()) {
                        FrsTabTestHelper.storeUserLastAccessTab(fs7Var.a);
                    }
                    h hVar = this.o;
                    if (hVar != null) {
                        hVar.a(fs7Var.b, fs7Var.e, fs7Var.a, fs7Var.g);
                    }
                    ye7 f2 = ye7.f();
                    if (fs7Var.e == 14) {
                        z = true;
                    }
                    f2.t(z);
                    xe7.h().o(fs7Var.b);
                    TiebaStatic.log(new StatisticItem("c12398").param("fid", this.a.l).param("tab_id", fs7Var.b));
                }
            }
        }
    }

    public final void u(FrsViewData frsViewData, TabData tabData, List<FrsTabInfo> list) {
        AccountData currentAccountObj;
        String str;
        List<ag7> list2;
        List<ag7> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, frsViewData, tabData, list) == null) {
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().a) {
                if (!U(frsTabInfo) && !Q(frsTabInfo)) {
                    boolean z = false;
                    if (frsTabInfo.is_general_tab.intValue() != 1 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_id.intValue() != 506 && frsTabInfo.tab_type.intValue() != 102) {
                        if (frsTabInfo.tab_id.intValue() != 89 && frsTabInfo.tab_id.intValue() != 503) {
                            if (frsTabInfo.tab_type.intValue() == 12) {
                                fs7 fs7Var = new fs7();
                                fs7Var.b = frsTabInfo.tab_id.intValue();
                                fs7Var.a = frsTabInfo.tab_name;
                                fs7Var.e = frsTabInfo.tab_type.intValue();
                                tabData.add(fs7Var);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                                if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                    fs7 fs7Var2 = new fs7();
                                    fs7Var2.b = frsTabInfo.tab_id.intValue();
                                    fs7Var2.a = frsTabInfo.tab_name;
                                    fs7Var2.e = frsTabInfo.tab_type.intValue();
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
                                    fs7Var2.d = sb2;
                                    d0(sb2, "c10078");
                                    tabData.add(fs7Var2);
                                    list.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_type.intValue() == 11 && T(frsTabInfo.tab_id.intValue())) {
                                fs7 fs7Var3 = new fs7();
                                fs7Var3.b = frsTabInfo.tab_id.intValue();
                                fs7Var3.a = frsTabInfo.tab_name;
                                fs7Var3.d = frsTabInfo.tab_url;
                                fs7Var3.e = frsTabInfo.tab_type.intValue();
                                if (uw4.i(fs7Var3.d)) {
                                    if (MessageManager.getInstance().findTask(2016447) != null) {
                                        tabData.add(fs7Var3);
                                        list.add(frsTabInfo);
                                    }
                                } else {
                                    tabData.add(fs7Var3);
                                    list.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_id.intValue() != 1 && eg7.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                                fs7 fs7Var4 = new fs7();
                                fs7Var4.b = frsTabInfo.tab_id.intValue();
                                fs7Var4.a = frsTabInfo.tab_name;
                                fs7Var4.e = frsTabInfo.tab_type.intValue();
                                cg7 b2 = bg7.a().b(fs7Var4.b);
                                if (b2 != null && (list3 = b2.b) != null && list3.size() > 0) {
                                    gh7 gh7Var = new gh7();
                                    fs7Var4.c = gh7Var;
                                    gh7Var.a = b2.a;
                                    gh7Var.b = new LinkedList();
                                    boolean z2 = true;
                                    for (ag7 ag7Var : b2.b) {
                                        if (ag7Var != null) {
                                            fh7 fh7Var = new fh7();
                                            fh7Var.a = ag7Var.a;
                                            fh7Var.b = ag7Var.b;
                                            if (z2) {
                                                fh7Var.c = true;
                                                z2 = false;
                                            }
                                            fs7Var4.c.b.add(fh7Var);
                                        }
                                    }
                                }
                                tabData.add(fs7Var4);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 1) {
                                fs7 fs7Var5 = new fs7();
                                fs7Var5.b = frsTabInfo.tab_id.intValue();
                                fs7Var5.a = frsTabInfo.tab_name;
                                fs7Var5.e = frsTabInfo.tab_type.intValue();
                                cg7 b3 = bg7.a().b(fs7Var5.b);
                                if (b3 != null && (list2 = b3.b) != null && list2.size() > 0) {
                                    gh7 gh7Var2 = new gh7();
                                    fs7Var5.c = gh7Var2;
                                    gh7Var2.a = b3.a;
                                    gh7Var2.b = new LinkedList();
                                    for (ag7 ag7Var2 : b3.b) {
                                        if (ag7Var2 != null) {
                                            fh7 fh7Var2 = new fh7();
                                            fh7Var2.a = ag7Var2.a;
                                            fh7Var2.b = ag7Var2.b;
                                            fs7Var5.c.b.add(fh7Var2);
                                        }
                                    }
                                }
                                tabData.add(fs7Var5);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 49) {
                                if (this.a.z1().a0().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                                    fs7 fs7Var6 = new fs7();
                                    fs7Var6.a = frsTabInfo.tab_name;
                                    if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                        fs7Var6.a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                    }
                                    int i2 = this.r;
                                    if (i2 > 0 && i2 != frsViewData.getAlaLiveCount() && this.r <= 99) {
                                        fs7Var6.a = frsTabInfo.tab_name + "(" + this.r + SmallTailInfo.EMOTION_SUFFIX;
                                    } else if (this.r <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                        int i3 = this.r;
                                        if (i3 == 0 && i3 != frsViewData.getAlaLiveCount()) {
                                            fs7Var6.a = frsTabInfo.tab_name;
                                        }
                                    } else {
                                        fs7Var6.a = frsTabInfo.tab_name + "(99+)";
                                    }
                                    fs7Var6.b = frsTabInfo.tab_id.intValue();
                                    fs7Var6.e = frsTabInfo.tab_type.intValue();
                                    tabData.add(fs7Var6);
                                    list.add(frsTabInfo);
                                }
                            } else if (frsTabInfo.tab_id.intValue() == 1120) {
                                fs7 fs7Var7 = new fs7();
                                fs7Var7.b = frsTabInfo.tab_id.intValue();
                                fs7Var7.a = frsTabInfo.tab_name;
                                fs7Var7.e = frsTabInfo.tab_type.intValue();
                                tabData.add(fs7Var7);
                                list.add(frsTabInfo);
                                y(2);
                            } else if (frsTabInfo.tab_id.intValue() == 90) {
                                fs7 fs7Var8 = new fs7();
                                fs7Var8.b = frsTabInfo.tab_id.intValue();
                                fs7Var8.a = frsTabInfo.tab_name;
                                fs7Var8.e = frsTabInfo.tab_type.intValue();
                                tabData.add(fs7Var8);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 91) {
                                fs7 fs7Var9 = new fs7();
                                fs7Var9.b = frsTabInfo.tab_id.intValue();
                                fs7Var9.a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, (String) null);
                                fs7Var9.e = frsTabInfo.tab_type.intValue();
                                tabData.add(fs7Var9);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_id.intValue() == 504) {
                                fs7 fs7Var10 = new fs7();
                                fs7Var10.b = frsTabInfo.tab_id.intValue();
                                fs7Var10.a = frsTabInfo.tab_name;
                                fs7Var10.e = frsTabInfo.tab_type.intValue();
                                tabData.add(fs7Var10);
                                list.add(frsTabInfo);
                            } else if (frsTabInfo.tab_type.intValue() == 3) {
                                fs7 fs7Var11 = new fs7();
                                fs7Var11.b = frsTabInfo.tab_id.intValue();
                                fs7Var11.a = frsTabInfo.tab_name;
                                fs7Var11.e = frsTabInfo.tab_type.intValue();
                                tabData.add(fs7Var11);
                                list.add(frsTabInfo);
                                y(1);
                            }
                        } else {
                            fs7 fs7Var12 = new fs7();
                            fs7Var12.b = frsTabInfo.tab_id.intValue();
                            fs7Var12.a = frsTabInfo.tab_name;
                            fs7Var12.e = frsTabInfo.tab_type.intValue();
                            tabData.add(fs7Var12);
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
                                int h2 = nt7.h("503~" + str + str2);
                                if (h2 == -1) {
                                    Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().b.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            FrsTabInfo next = it.next();
                                            if (next.tab_type == frsTabInfo.tab_type) {
                                                nt7.i("503~" + str + str2, next.tab_id.intValue());
                                                if (7 == h2) {
                                                    wca.b();
                                                } else {
                                                    wca.a();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        fs7 fs7Var13 = new fs7();
                        fs7Var13.a = frsTabInfo.tab_name;
                        fs7Var13.b = frsTabInfo.tab_id.intValue();
                        fs7Var13.e = frsTabInfo.tab_type.intValue();
                        fs7Var13.f = frsTabInfo.head_pics;
                        fs7Var13.d = frsTabInfo.tab_url;
                        if (frsTabInfo.is_no_show_publisher.intValue() == 1) {
                            z = true;
                        }
                        fs7Var13.g = z;
                        tabData.add(fs7Var13);
                        list.add(frsTabInfo);
                    }
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
                fs7 fs7Var = this.i.get(i2);
                if (w != null && fs7Var != null && fs7Var.e == 102 && fs7Var.f != null) {
                    FrsTabItemCustomeView frsTabItemCustomeView = new FrsTabItemCustomeView(this.a.getContext());
                    frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(L(TbadkCoreApplication.getInst().getSkinType(), SkinManager.getColor(R.color.plugin_button_shadow_red)), PorterDuff.Mode.SRC_IN));
                    frsTabItemCustomeView.e(fs7Var.f);
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
            statisticItem.param("fid", this.a.w());
            if (i2 == 89) {
                statisticItem.param("obj_type", 1);
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
