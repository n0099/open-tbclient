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
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.downloadmanager.ui.DownloadManagerFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k16;
import com.repackage.li;
import com.repackage.z35;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class DownloadManagerActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAB_ID = "tab_id";
    public static final String TAB_NEED_LOGIN = "tab_need_login";
    public static final String TAB_SOURCE = "tab_source";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<z35> fragments;
    public int lastSource;
    public CustomMessageListener mCardItemRightBtnClickListener;
    public NavigationBar navigationBar;
    public TbTabLayout tabLayout;
    public BdBaseViewPager viewPager;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k16)) {
                k16 k16Var = (k16) customResponsedMessage.getData();
                View a = k16Var.a();
                if (!ItemCardHelper.d.equals(((TBSpecificationBtn) k16Var.a()).getText())) {
                    ItemCardHelper.f(k16Var.e(), k16Var.d(), ItemCardHelper.e(((TBSpecificationBtn) k16Var.a()).getText()), k16Var.c(), k16Var.b(), true);
                }
                DownloadManagerActivity downloadManagerActivity = this.a;
                ItemCardHelper.l(downloadManagerActivity, downloadManagerActivity.getUniqueId(), a, (ViewGroup) this.a.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DownloadManagerActivity downloadManagerActivity = this.a;
                ItemCardHelper.x(downloadManagerActivity, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) downloadManagerActivity.findViewById(16908290), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                DownloadManagerActivity downloadManagerActivity = this.a;
                ItemCardHelper.x(downloadManagerActivity, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) downloadManagerActivity.findViewById(16908290), j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TbTabLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerActivity a;

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

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void a(TbTabLayout.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void c(TbTabLayout.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                this.a.lastSource = 4;
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void e(TbTabLayout.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_DOWNLOAD_MANAGER_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0981).contentEquals(fVar.g())) {
                    statisticItem.addParam("obj_locate", 1);
                } else if (this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0512).contentEquals(fVar.g())) {
                    statisticItem.addParam("obj_locate", 3);
                } else if (this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08f4).contentEquals(fVar.g())) {
                    statisticItem.addParam("obj_locate", 2);
                }
                statisticItem.addParam("obj_source", this.a.lastSource);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List<z35> b;
        public final /* synthetic */ DownloadManagerActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(DownloadManagerActivity downloadManagerActivity, FragmentManager fragmentManager, List<z35> list) {
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

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<z35> list = this.b;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.b.get(i).a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.b.get(i).c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                if (obj == null || (i2 = this.a) == i) {
                    return;
                }
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
        this.fragments = new ArrayList<>();
        this.mCardItemRightBtnClickListener = new a(this, 2001440);
    }

    private int getCurrentTabPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int intExtra = getIntent().getIntExtra(DownloadManagerActivityConfig.CURRENT_TAB, 0) - 1;
            if (intExtra < 0) {
                return 0;
            }
            return intExtra;
        }
        return invokeV.intValue;
    }

    private void initTabLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.tabLayout.setOnTabSelectedListener(new d(this));
            this.tabLayout.setSelectedTabTextBlod(true);
            this.tabLayout.setTabTextSize(li.f(getActivity(), R.dimen.tbds42));
            this.tabLayout.setupWithViewPager(this.viewPager);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f090806);
            this.navigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0508));
            this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.viewPager = (BdBaseViewPager) findViewById(R.id.obfuscated_res_0x7f090808);
            initViewPager();
            this.tabLayout = (TbTabLayout) findViewById(R.id.obfuscated_res_0x7f090807);
            initTabLayout();
        }
    }

    private void initViewPager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.fragments = new ArrayList<>();
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", 1);
            bundle.putInt(TAB_SOURCE, this.lastSource);
            bundle.putBoolean(TAB_NEED_LOGIN, true);
            z35 z35Var = new z35();
            DownloadManagerFragment O0 = DownloadManagerFragment.O0();
            z35Var.a = O0;
            O0.setArguments(bundle);
            z35Var.c = getResources().getString(R.string.obfuscated_res_0x7f0f0981);
            this.fragments.add(z35Var);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("tab_id", 2);
            bundle2.putInt(TAB_SOURCE, this.lastSource);
            z35 z35Var2 = new z35();
            DownloadManagerFragment O02 = DownloadManagerFragment.O0();
            z35Var2.a = O02;
            O02.setArguments(bundle2);
            z35Var2.c = getResources().getString(R.string.obfuscated_res_0x7f0f08f4);
            this.fragments.add(z35Var2);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("tab_id", 3);
            bundle3.putInt(TAB_SOURCE, this.lastSource);
            z35 z35Var3 = new z35();
            DownloadManagerFragment O03 = DownloadManagerFragment.O0();
            z35Var3.a = O03;
            O03.setArguments(bundle3);
            z35Var3.c = getResources().getString(R.string.obfuscated_res_0x7f0f0512);
            this.fragments.add(z35Var3);
            this.viewPager.setOffscreenPageLimit(this.fragments.size());
            this.viewPager.setAdapter(new e(this, getSupportFragmentManager(), this.fragments));
            this.viewPager.setCurrentItem(getCurrentTabPosition());
            this.viewPager.addOnPageChangeListener(new c(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.navigationBar.onChangeSkinType(getPageContext(), i);
            this.tabLayout.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
            this.tabLayout.setSelectedIndicatorBottomMargin(li.f(getActivity(), R.dimen.tbds5));
            SkinManager.setBackgroundColor(this.tabLayout, R.color.CAM_X0208);
            this.tabLayout.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            Iterator<z35> it = this.fragments.iterator();
            while (it.hasNext()) {
                ((BaseFragment) it.next().a).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0235);
            this.lastSource = getIntent().getIntExtra("source", 0);
            initUI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.mCardItemRightBtnClickListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            ItemCardHelper.v(new b(this));
            MessageManager.getInstance().registerListener(this.mCardItemRightBtnClickListener);
        }
    }
}
