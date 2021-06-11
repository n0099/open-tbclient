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
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionCenterActivity extends BaseFragmentActivity {
    public static final String KEY_LOAD_URL = "key_load_url";
    public static final String MY_EMOTION_URL = "http://tieba.baidu.com/n/interact/emoticon/download";
    public FragmentPagerAdapter mAdapter;
    public TextView mBackBtn;
    public LinearLayout mEmotionRootView;
    public NavigationBar mNavigationBar;
    public ImageView mSettingImg;
    public String mSingleForumTabUrl;
    public CommonPagerSlidingTabStrip mTabStrip;
    public BdBaseViewPager mViewPager;
    public List<BaseFragment> fragments = new ArrayList(2);
    public List<String> mTitles = new ArrayList(2);
    public CustomMessageListener mShowSingleBarFragment = new a(2921060);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str) || str.equals(EmotionCenterActivity.this.mSingleForumTabUrl)) {
                    return;
                }
                EmotionCenterActivity.this.mSingleForumTabUrl = str;
                EmotionCenterActivity.this.updataTab();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends FragmentPagerAdapter {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (ListUtils.isEmpty(EmotionCenterActivity.this.fragments)) {
                return 0;
            }
            return EmotionCenterActivity.this.fragments.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            if (ListUtils.isEmpty(EmotionCenterActivity.this.fragments) || EmotionCenterActivity.this.fragments.size() <= i2) {
                return null;
            }
            return (Fragment) EmotionCenterActivity.this.fragments.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return ListUtils.isEmpty(EmotionCenterActivity.this.mTitles) ? "" : (CharSequence) EmotionCenterActivity.this.mTitles.get(i2);
        }
    }

    private void initData() {
        this.mViewPager.setAdapter(this.mAdapter);
        this.mTabStrip.setViewPager(this.mViewPager);
    }

    private void initView() {
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
        commonPagerSlidingTabStrip.k(l.g(this, R.dimen.ds32), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds24), l.g(this, R.dimen.ds4), l.g(this, R.dimen.ds64), R.color.CAM_X0107, R.color.CAM_X0105);
        this.mBackBtn.setOnClickListener(this);
        this.mSettingImg.setOnClickListener(this);
        this.mEmotionRootView = (LinearLayout) findViewById(R.id.emotion_root_view);
        BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.emotion_center_viewpager);
        this.mViewPager = bdBaseViewPager;
        bdBaseViewPager.setmDisallowSlip(true);
        this.mAdapter = new b(getSupportFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataTab() {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mSkinType = i2;
        getLayoutMode().k(i2 == 1);
        CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.mTabStrip;
        if (commonPagerSlidingTabStrip != null) {
            commonPagerSlidingTabStrip.n(i2);
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

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mBackBtn) {
            finish();
        } else if (view == this.mSettingImg) {
            int i2 = 0;
            if (!ListUtils.isEmpty(this.fragments) && (this.fragments.get(0) instanceof EmotionRecommendFragment)) {
                i2 = ((EmotionRecommendFragment) this.fragments.get(0)).L0();
            }
            sendMessage(new CustomMessage(2002001, new NativeEmotionManagerActivityConfig(getPageContext().getPageActivity(), i2)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_center_layout);
        initView();
        initData();
        registerListener(this.mShowSingleBarFragment);
    }
}
