package com.baidu.tieba.faceshop.emotioncenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment;
import com.baidu.tieba.tq4;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionCenterActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdBaseViewPager a;
    public NavigationBar b;
    public TextView c;
    public ImageView d;
    public CommonPagerSlidingTabStrip e;
    public LinearLayout f;
    public List<BaseFragment> g;
    public FragmentPagerAdapter h;
    public List<String> i;
    public String j;
    public CustomMessageListener k;

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionCenterActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionCenterActivity emotionCenterActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionCenterActivity, Integer.valueOf(i)};
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
            this.a = emotionCenterActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str) || str.equals(this.a.j)) {
                    return;
                }
                this.a.j = str;
                this.a.S0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionCenterActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionCenterActivity emotionCenterActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionCenterActivity, fragmentManager};
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
            this.a = emotionCenterActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ListUtils.isEmpty(this.a.g)) {
                    return 0;
                }
                return this.a.g.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (!ListUtils.isEmpty(this.a.g) && this.a.g.size() > i) {
                    return (Fragment) this.a.g.get(i);
                }
                return null;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (ListUtils.isEmpty(this.a.i)) {
                    return "";
                }
                return (CharSequence) this.a.i.get(i);
            }
            return (CharSequence) invokeI.objValue;
        }
    }

    public EmotionCenterActivity() {
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
        this.g = new ArrayList(2);
        this.i = new ArrayList(2);
        this.k = new a(this, 2921060);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0255);
            initView();
            R0();
            registerListener(this.k);
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.setAdapter(this.h);
            this.e.setViewPager(this.a);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i.add(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0564));
            EmotionRecommendFragment emotionRecommendFragment = new EmotionRecommendFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("need_check_login", true);
            emotionRecommendFragment.setArguments(bundle);
            this.g.add(emotionRecommendFragment);
            this.i.add(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0565));
            ForumEmotionFragment forumEmotionFragment = new ForumEmotionFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_load_url", this.j);
            forumEmotionFragment.setArguments(bundle2);
            this.g.add(forumEmotionFragment);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.b = navigationBar;
            TextView addTextButtonByDefTextColor = navigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.obfuscated_res_0x7f0f037c));
            this.c = addTextButtonByDefTextColor;
            addTextButtonByDefTextColor.setTextSize(0, yi.g(this, R.dimen.obfuscated_res_0x7f07020f));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(getPageContext().getPageActivity());
            this.d = imageView;
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, imageView, (View.OnClickListener) null);
            this.d.setPadding(0, yi.g(this, R.dimen.obfuscated_res_0x7f0701d5), yi.g(this, R.dimen.obfuscated_res_0x7f07029b), yi.g(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.d.setLayoutParams(layoutParams);
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d0263, (View.OnClickListener) null);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f0908c8);
            this.e = commonPagerSlidingTabStrip;
            commonPagerSlidingTabStrip.k(yi.g(this, R.dimen.obfuscated_res_0x7f070207), yi.g(this, R.dimen.obfuscated_res_0x7f0701e8), yi.g(this, R.dimen.obfuscated_res_0x7f0701e8), yi.g(this, R.dimen.obfuscated_res_0x7f0701e8), yi.g(this, R.dimen.obfuscated_res_0x7f0701e8), yi.g(this, R.dimen.obfuscated_res_0x7f070224), yi.g(this, R.dimen.obfuscated_res_0x7f070258), R.color.CAM_X0107, R.color.CAM_X0105);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090903);
            BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.obfuscated_res_0x7f0908c9);
            this.a = bdBaseViewPager;
            bdBaseViewPager.setmDisallowSlip(true);
            this.h = new b(this, getSupportFragmentManager());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.mSkinType = i;
            tq4 layoutMode = getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.e;
            if (commonPagerSlidingTabStrip != null) {
                commonPagerSlidingTabStrip.n(i);
            }
            if (this.d != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, null);
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TextView textView = this.c;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.navi_back_text_color);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.c) {
                finish();
            } else if (view2 == this.d) {
                int i = 0;
                if (!ListUtils.isEmpty(this.g) && (this.g.get(0) instanceof EmotionRecommendFragment)) {
                    i = ((EmotionRecommendFragment) this.g.get(0)).C1();
                }
                sendMessage(new CustomMessage(2002001, new NativeEmotionManagerActivityConfig(getPageContext().getPageActivity(), i)));
            }
        }
    }
}
