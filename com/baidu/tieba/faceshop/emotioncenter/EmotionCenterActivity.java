package com.baidu.tieba.faceshop.emotioncenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class EmotionCenterActivity extends BaseFragmentActivity {
    private BdBaseViewPager fmy;
    private TextView iSc;
    private ImageView iSd;
    private CommonPagerSlidingTabStrip iSe;
    private LinearLayout iSf;
    private FragmentPagerAdapter iSg;
    private String iSh;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> euA = new ArrayList(2);
    private List<String> fMx = new ArrayList(2);
    private CustomMessageListener iSi = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER_ADD_FRAGMENT) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str) && !str.equals(EmotionCenterActivity.this.iSh)) {
                    EmotionCenterActivity.this.iSh = str;
                    EmotionCenterActivity.this.cyH();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.emotion_center_layout);
        initView();
        initData();
        registerListener(this.iSi);
    }

    private void initView() {
        this.fMx.add(getPageContext().getResources().getString(R.string.emotion_center_quality_recommend));
        EmotionRecommendFragment emotionRecommendFragment = new EmotionRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("need_check_login", true);
        emotionRecommendFragment.setArguments(bundle);
        this.euA.add(emotionRecommendFragment);
        this.fMx.add(getPageContext().getResources().getString(R.string.emotion_center_single_bar));
        ForumEmotionFragment forumEmotionFragment = new ForumEmotionFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_load_url", this.iSh);
        forumEmotionFragment.setArguments(bundle2);
        this.euA.add(forumEmotionFragment);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.iSc = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
        this.iSc.setTextSize(0, l.getDimens(this, R.dimen.ds34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iSd = new ImageView(getPageContext().getPageActivity());
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iSd, (View.OnClickListener) null);
        this.iSd.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iSd.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_bar, (View.OnClickListener) null);
        this.iSe = (CommonPagerSlidingTabStrip) findViewById(R.id.emotion_center_nav);
        this.iSe.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds4), l.getDimens(this, R.dimen.ds64), R.color.CAM_X0107, R.color.CAM_X0105);
        this.iSc.setOnClickListener(this);
        this.iSd.setOnClickListener(this);
        this.iSf = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.fmy = (BdBaseViewPager) findViewById(R.id.emotion_center_viewpager);
        this.fmy.setmDisallowSlip(true);
        this.iSg = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity.2
            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (!x.isEmpty(EmotionCenterActivity.this.euA) && EmotionCenterActivity.this.euA.size() > i) {
                    return (Fragment) EmotionCenterActivity.this.euA.get(i);
                }
                return null;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (!x.isEmpty(EmotionCenterActivity.this.euA)) {
                    return EmotionCenterActivity.this.euA.size();
                }
                return 0;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                if (!x.isEmpty(EmotionCenterActivity.this.fMx)) {
                    return (CharSequence) EmotionCenterActivity.this.fMx.get(i);
                }
                return "";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyH() {
    }

    private void initData() {
        this.fmy.setAdapter(this.iSg);
        this.iSe.setViewPager(this.fmy);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iSe != null) {
            this.iSe.onChangeSkinType(i);
        }
        if (this.iSd != null) {
            SvgManager.bsx().a(this.iSd, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        }
        if (this.iSf != null) {
            ao.setBackgroundColor(this.iSf, R.color.CAM_X0201);
        }
        if (this.iSc != null) {
            ao.setViewTextColor(this.iSc, R.color.navi_back_text_color);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        super.onClick(view);
        if (view == this.iSc) {
            finish();
        } else if (view == this.iSd) {
            if (!x.isEmpty(this.euA) && (this.euA.get(0) instanceof EmotionRecommendFragment)) {
                i = ((EmotionRecommendFragment) this.euA.get(0)).cyI();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NativeEmotionManagerActivityConfig(getPageContext().getPageActivity(), i)));
        }
    }
}
