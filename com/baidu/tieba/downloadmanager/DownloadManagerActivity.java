package com.baidu.tieba.downloadmanager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tieba.R;
import com.baidu.tieba.downloadmanager.ui.DownloadManageButton;
import com.baidu.tieba.downloadmanager.ui.DownloadManagerFragment;
import com.baidu.tieba.nx6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class DownloadManagerActivity extends BaseFragmentActivity implements DownloadManagerFragment.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public TbTabLayout b;
    public BdBaseViewPager c;
    public int d;
    public ArrayList<FragmentTabStructure> e;
    public DownloadManageButton f;
    public int g;
    public CustomMessageListener h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DownloadManagerActivity downloadManagerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerActivity, Integer.valueOf(i)};
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
            this.a = downloadManagerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof nx6)) {
                nx6 nx6Var = (nx6) customResponsedMessage.getData();
                View a = nx6Var.a();
                if (!ItemCardHelper.d.equals(((TBSpecificationBtn) nx6Var.a()).getText())) {
                    ItemCardHelper.f(nx6Var.e(), nx6Var.d(), ItemCardHelper.e(((TBSpecificationBtn) nx6Var.a()).getText()), nx6Var.c(), nx6Var.b(), true);
                }
                DownloadManagerActivity downloadManagerActivity = this.a;
                ItemCardHelper.l(downloadManagerActivity, downloadManagerActivity.getUniqueId(), a, (ViewGroup) this.a.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerActivity a;

        public b(DownloadManagerActivity downloadManagerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadManagerActivity;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                DownloadManagerActivity downloadManagerActivity = this.a;
                ItemCardHelper.y(downloadManagerActivity, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) downloadManagerActivity.findViewById(16908290), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                DownloadManagerActivity downloadManagerActivity = this.a;
                ItemCardHelper.y(downloadManagerActivity, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) downloadManagerActivity.findViewById(16908290), j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DownloadManageButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerActivity a;

        public c(DownloadManagerActivity downloadManagerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadManagerActivity;
        }

        @Override // com.baidu.tieba.downloadmanager.ui.DownloadManageButton.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Fragment fragment = ((FragmentTabStructure) this.a.e.get(this.a.g)).frag;
                if (fragment instanceof DownloadManagerFragment) {
                    ((DownloadManagerFragment) fragment).o2();
                }
                this.a.c.setmDisallowSlip(true);
                this.a.b.setDisableTabSelect(true);
                this.a.setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.tieba.downloadmanager.ui.DownloadManageButton.a
        public void switchToNormal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Fragment fragment = ((FragmentTabStructure) this.a.e.get(this.a.g)).frag;
                if (fragment instanceof DownloadManagerFragment) {
                    ((DownloadManagerFragment) fragment).p2();
                }
                this.a.c.setmDisallowSlip(false);
                this.a.b.setDisableTabSelect(false);
                this.a.setSwipeBackEnabled(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerActivity a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public d(DownloadManagerActivity downloadManagerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadManagerActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i == 0) {
                    this.a.f.setVisibility(8);
                } else {
                    this.a.f.setVisibility(0);
                }
                this.a.g = i;
                Fragment fragment = ((FragmentTabStructure) this.a.e.get(i)).frag;
                if (fragment instanceof DownloadManagerFragment) {
                    this.a.f.h(((DownloadManagerFragment) fragment).q2());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TbTabLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerActivity a;

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void a(TbTabLayout.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            }
        }

        public e(DownloadManagerActivity downloadManagerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadManagerActivity;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void c(TbTabLayout.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) != null) {
                return;
            }
            this.a.d = 4;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void e(TbTabLayout.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_DOWNLOAD_MANAGER_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.a.getResources().getString(R.string.item_order_complete).contentEquals(fVar.g())) {
                    statisticItem.addParam("obj_locate", 1);
                } else if (this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0605).contentEquals(fVar.g())) {
                    statisticItem.addParam("obj_locate", 3);
                } else if (this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0aaa).contentEquals(fVar.g())) {
                    statisticItem.addParam("obj_locate", 2);
                }
                statisticItem.addParam("obj_source", this.a.d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List<FragmentTabStructure> b;
        public final /* synthetic */ DownloadManagerActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(DownloadManagerActivity downloadManagerActivity, FragmentManager fragmentManager, List<FragmentTabStructure> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerActivity, fragmentManager, list};
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
            this.c = downloadManagerActivity;
            this.a = -1;
            this.b = list;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                if (obj != null && (i2 = this.a) != i) {
                    if (i2 != -1 && i2 < getCount()) {
                        ((BaseFragment) getItem(this.a)).setPrimary(false);
                    }
                    this.a = i;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(true);
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<FragmentTabStructure> list = this.b;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NonNull
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return this.b.get(i).frag;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.b.get(i).text;
            }
            return (CharSequence) invokeI.objValue;
        }
    }

    public DownloadManagerActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList<>();
        this.g = 0;
        this.h = new a(this, 2001440);
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            DownloadManageButton downloadManageButton = new DownloadManageButton(this);
            this.f = downloadManageButton;
            downloadManageButton.setPadding(0, 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            this.f.setVisibility(8);
            EMManager.from(this.f).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07);
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setOnTabSelectedListener(new e(this));
            this.b.setSelectedTabTextBlod(true);
            this.b.setTabTextSize(BdUtilHelper.getDimens(getActivity(), R.dimen.tbds42));
            this.b.setupWithViewPager(this.c);
        }
    }

    @Override // com.baidu.tieba.downloadmanager.ui.DownloadManagerFragment.i
    public void E(DownloadManageButton.DownloadManageType downloadManageType) {
        DownloadManageButton downloadManageButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, downloadManageType) == null) && (downloadManageButton = this.f) != null) {
            downloadManageButton.h(downloadManageType);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0279);
            this.d = getIntent().getIntExtra("source", 0);
            E1();
        }
    }

    public final int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int intExtra = getIntent().getIntExtra(DownloadManagerActivityConfig.CURRENT_TAB, 0) - 1;
            if (intExtra < 0) {
                return 0;
            }
            return intExtra;
        }
        return invokeV.intValue;
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.addOnPageChangeListener(new d(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f.getCurrentManageType() == DownloadManageButton.DownloadManageType.MANAGE) {
                this.f.h(DownloadManageButton.DownloadManageType.NORMAL);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            ItemCardHelper.w(new b(this));
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09094a);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f05db));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            C1();
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).addView(this.f);
            this.c = (BdBaseViewPager) findViewById(R.id.obfuscated_res_0x7f09094c);
            F1();
            this.b = (TbTabLayout) findViewById(R.id.obfuscated_res_0x7f09094b);
            D1();
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e = new ArrayList<>();
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", 1);
            bundle.putInt("tab_source", this.d);
            bundle.putBoolean("tab_need_login", true);
            FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
            DownloadManagerFragment u2 = DownloadManagerFragment.u2();
            fragmentTabStructure.frag = u2;
            u2.setArguments(bundle);
            fragmentTabStructure.text = getResources().getString(R.string.item_order_complete);
            this.e.add(fragmentTabStructure);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("tab_id", 2);
            bundle2.putInt("tab_source", this.d);
            FragmentTabStructure fragmentTabStructure2 = new FragmentTabStructure();
            DownloadManagerFragment u22 = DownloadManagerFragment.u2();
            fragmentTabStructure2.frag = u22;
            u22.setArguments(bundle2);
            fragmentTabStructure2.text = getResources().getString(R.string.obfuscated_res_0x7f0f0aaa);
            this.e.add(fragmentTabStructure2);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("tab_id", 3);
            bundle3.putInt("tab_source", this.d);
            FragmentTabStructure fragmentTabStructure3 = new FragmentTabStructure();
            DownloadManagerFragment u23 = DownloadManagerFragment.u2();
            fragmentTabStructure3.frag = u23;
            u23.setArguments(bundle3);
            fragmentTabStructure3.text = getResources().getString(R.string.obfuscated_res_0x7f0f0605);
            this.e.add(fragmentTabStructure3);
            this.c.setOffscreenPageLimit(this.e.size());
            this.c.setAdapter(new f(this, getSupportFragmentManager(), this.e));
            G1();
            this.c.setCurrentItem(B1());
            this.f.setTypeChangeCallback(new c(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a.onChangeSkinType(getPageContext(), i);
            this.b.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
            this.b.setSelectedIndicatorBottomMargin(BdUtilHelper.getDimens(getActivity(), R.dimen.tbds5));
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0208);
            this.f.f();
            this.b.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            Iterator<FragmentTabStructure> it = this.e.iterator();
            while (it.hasNext()) {
                ((BaseFragment) it.next().frag).onChangeSkinType(i);
            }
        }
    }
}
