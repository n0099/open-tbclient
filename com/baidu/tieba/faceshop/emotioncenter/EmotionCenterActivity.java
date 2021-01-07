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
/* loaded from: classes9.dex */
public class EmotionCenterActivity extends BaseFragmentActivity {
    private BdBaseViewPager fri;
    private TextView iWJ;
    private ImageView iWK;
    private CommonPagerSlidingTabStrip iWL;
    private LinearLayout iWM;
    private FragmentPagerAdapter iWN;
    private String iWO;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> ezp = new ArrayList(2);
    private List<String> fRe = new ArrayList(2);
    private CustomMessageListener iWP = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER_ADD_FRAGMENT) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str) && !str.equals(EmotionCenterActivity.this.iWO)) {
                    EmotionCenterActivity.this.iWO = str;
                    EmotionCenterActivity.this.cCz();
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
        registerListener(this.iWP);
    }

    private void initView() {
        this.fRe.add(getPageContext().getResources().getString(R.string.emotion_center_quality_recommend));
        EmotionRecommendFragment emotionRecommendFragment = new EmotionRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("need_check_login", true);
        emotionRecommendFragment.setArguments(bundle);
        this.ezp.add(emotionRecommendFragment);
        this.fRe.add(getPageContext().getResources().getString(R.string.emotion_center_single_bar));
        ForumEmotionFragment forumEmotionFragment = new ForumEmotionFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_load_url", this.iWO);
        forumEmotionFragment.setArguments(bundle2);
        this.ezp.add(forumEmotionFragment);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.iWJ = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
        this.iWJ.setTextSize(0, l.getDimens(this, R.dimen.ds34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iWK = new ImageView(getPageContext().getPageActivity());
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iWK, (View.OnClickListener) null);
        this.iWK.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iWK.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_bar, (View.OnClickListener) null);
        this.iWL = (CommonPagerSlidingTabStrip) findViewById(R.id.emotion_center_nav);
        this.iWL.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds4), l.getDimens(this, R.dimen.ds64), R.color.CAM_X0107, R.color.CAM_X0105);
        this.iWJ.setOnClickListener(this);
        this.iWK.setOnClickListener(this);
        this.iWM = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.fri = (BdBaseViewPager) findViewById(R.id.emotion_center_viewpager);
        this.fri.setmDisallowSlip(true);
        this.iWN = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity.2
            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (!x.isEmpty(EmotionCenterActivity.this.ezp) && EmotionCenterActivity.this.ezp.size() > i) {
                    return (Fragment) EmotionCenterActivity.this.ezp.get(i);
                }
                return null;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (!x.isEmpty(EmotionCenterActivity.this.ezp)) {
                    return EmotionCenterActivity.this.ezp.size();
                }
                return 0;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                if (!x.isEmpty(EmotionCenterActivity.this.fRe)) {
                    return (CharSequence) EmotionCenterActivity.this.fRe.get(i);
                }
                return "";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCz() {
    }

    private void initData() {
        this.fri.setAdapter(this.iWN);
        this.iWL.setViewPager(this.fri);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iWL != null) {
            this.iWL.onChangeSkinType(i);
        }
        if (this.iWK != null) {
            SvgManager.bwr().a(this.iWK, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        }
        if (this.iWM != null) {
            ao.setBackgroundColor(this.iWM, R.color.CAM_X0201);
        }
        if (this.iWJ != null) {
            ao.setViewTextColor(this.iWJ, R.color.navi_back_text_color);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        super.onClick(view);
        if (view == this.iWJ) {
            finish();
        } else if (view == this.iWK) {
            if (!x.isEmpty(this.ezp) && (this.ezp.get(0) instanceof EmotionRecommendFragment)) {
                i = ((EmotionRecommendFragment) this.ezp.get(0)).cCA();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NativeEmotionManagerActivityConfig(getPageContext().getPageActivity(), i)));
        }
    }
}
