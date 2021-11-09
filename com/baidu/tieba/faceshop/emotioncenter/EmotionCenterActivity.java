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
import b.a.e.e.p.l;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class EmotionCenterActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LOAD_URL = "key_load_url";
    public static final String MY_EMOTION_URL = "http://tieba.baidu.com/n/interact/emoticon/download";
    public transient /* synthetic */ FieldHolder $fh;
    public List<BaseFragment> fragments;
    public FragmentPagerAdapter mAdapter;
    public TextView mBackBtn;
    public LinearLayout mEmotionRootView;
    public NavigationBar mNavigationBar;
    public ImageView mSettingImg;
    public CustomMessageListener mShowSingleBarFragment;
    public String mSingleForumTabUrl;
    public CommonPagerSlidingTabStrip mTabStrip;
    public List<String> mTitles;
    public BdBaseViewPager mViewPager;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionCenterActivity f48010a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionCenterActivity emotionCenterActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionCenterActivity, Integer.valueOf(i2)};
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
            this.f48010a = emotionCenterActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str) || str.equals(this.f48010a.mSingleForumTabUrl)) {
                    return;
                }
                this.f48010a.mSingleForumTabUrl = str;
                this.f48010a.updataTab();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionCenterActivity f48011a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionCenterActivity emotionCenterActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionCenterActivity, fragmentManager};
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
            this.f48011a = emotionCenterActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ListUtils.isEmpty(this.f48011a.fragments)) {
                    return 0;
                }
                return this.f48011a.fragments.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (ListUtils.isEmpty(this.f48011a.fragments) || this.f48011a.fragments.size() <= i2) {
                    return null;
                }
                return (Fragment) this.f48011a.fragments.get(i2);
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? ListUtils.isEmpty(this.f48011a.mTitles) ? "" : (CharSequence) this.f48011a.mTitles.get(i2) : (CharSequence) invokeI.objValue;
        }
    }

    public EmotionCenterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fragments = new ArrayList(2);
        this.mTitles = new ArrayList(2);
        this.mShowSingleBarFragment = new a(this, 2921060);
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mViewPager.setAdapter(this.mAdapter);
            this.mTabStrip.setViewPager(this.mViewPager);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mTitles.add(getPageContext().getResources().getString(R.string.emotion_center_quality_recommend));
            EmotionRecommendFragment emotionRecommendFragment = new EmotionRecommendFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("need_check_login", true);
            emotionRecommendFragment.setArguments(bundle);
            this.fragments.add(emotionRecommendFragment);
            this.mTitles.add(getPageContext().getResources().getString(R.string.emotion_center_single_bar));
            ForumEmotionFragment forumEmotionFragment = new ForumEmotionFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_load_url", this.mSingleForumTabUrl);
            forumEmotionFragment.setArguments(bundle2);
            this.fragments.add(forumEmotionFragment);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            TextView addTextButtonByDefTextColor = navigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
            this.mBackBtn = addTextButtonByDefTextColor;
            addTextButtonByDefTextColor.setTextSize(0, l.g(this, R.dimen.ds34));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(getPageContext().getPageActivity());
            this.mSettingImg = imageView;
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, imageView, (View.OnClickListener) null);
            this.mSettingImg.setPadding(0, l.g(this, R.dimen.ds20), l.g(this, R.dimen.ds31), l.g(this, R.dimen.ds20));
            this.mSettingImg.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_bar, (View.OnClickListener) null);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) findViewById(R.id.emotion_center_nav);
            this.mTabStrip = commonPagerSlidingTabStrip;
            commonPagerSlidingTabStrip.build(l.g(this, R.dimen.ds32), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds4), l.g(this, R.dimen.ds64), R.color.CAM_X0107, R.color.CAM_X0105);
            this.mBackBtn.setOnClickListener(this);
            this.mSettingImg.setOnClickListener(this);
            this.mEmotionRootView = (LinearLayout) findViewById(R.id.emotion_root_view);
            BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.emotion_center_viewpager);
            this.mViewPager = bdBaseViewPager;
            bdBaseViewPager.setmDisallowSlip(true);
            this.mAdapter = new b(this, getSupportFragmentManager());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataTab() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mSkinType = i2;
            getLayoutMode().k(i2 == 1);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.mTabStrip;
            if (commonPagerSlidingTabStrip != null) {
                commonPagerSlidingTabStrip.onChangeSkinType(i2);
            }
            if (this.mSettingImg != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mSettingImg, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, null);
            }
            LinearLayout linearLayout = this.mEmotionRootView;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TextView textView = this.mBackBtn;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.navi_back_text_color);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.onClick(view);
            if (view == this.mBackBtn) {
                finish();
            } else if (view == this.mSettingImg) {
                int i2 = 0;
                if (!ListUtils.isEmpty(this.fragments) && (this.fragments.get(0) instanceof EmotionRecommendFragment)) {
                    i2 = ((EmotionRecommendFragment) this.fragments.get(0)).getIsBazhu();
                }
                sendMessage(new CustomMessage(2002001, new NativeEmotionManagerActivityConfig(getPageContext().getPageActivity(), i2)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.emotion_center_layout);
            initView();
            initData();
            registerListener(this.mShowSingleBarFragment);
        }
    }
}
