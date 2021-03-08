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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class EmotionCenterActivity extends BaseFragmentActivity {
    private BdBaseViewPager fqq;
    private TextView iZG;
    private ImageView iZH;
    private CommonPagerSlidingTabStrip iZI;
    private LinearLayout iZJ;
    private FragmentPagerAdapter iZK;
    private String iZL;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> eyj = new ArrayList(2);
    private List<String> fQk = new ArrayList(2);
    private CustomMessageListener iZM = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER_ADD_FRAGMENT) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str) && !str.equals(EmotionCenterActivity.this.iZL)) {
                    EmotionCenterActivity.this.iZL = str;
                    EmotionCenterActivity.this.cAf();
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
        registerListener(this.iZM);
    }

    private void initView() {
        this.fQk.add(getPageContext().getResources().getString(R.string.emotion_center_quality_recommend));
        EmotionRecommendFragment emotionRecommendFragment = new EmotionRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("need_check_login", true);
        emotionRecommendFragment.setArguments(bundle);
        this.eyj.add(emotionRecommendFragment);
        this.fQk.add(getPageContext().getResources().getString(R.string.emotion_center_single_bar));
        ForumEmotionFragment forumEmotionFragment = new ForumEmotionFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_load_url", this.iZL);
        forumEmotionFragment.setArguments(bundle2);
        this.eyj.add(forumEmotionFragment);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.iZG = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
        this.iZG.setTextSize(0, l.getDimens(this, R.dimen.ds34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iZH = new ImageView(getPageContext().getPageActivity());
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iZH, (View.OnClickListener) null);
        this.iZH.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iZH.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_bar, (View.OnClickListener) null);
        this.iZI = (CommonPagerSlidingTabStrip) findViewById(R.id.emotion_center_nav);
        this.iZI.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds4), l.getDimens(this, R.dimen.ds64), R.color.CAM_X0107, R.color.CAM_X0105);
        this.iZG.setOnClickListener(this);
        this.iZH.setOnClickListener(this);
        this.iZJ = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.fqq = (BdBaseViewPager) findViewById(R.id.emotion_center_viewpager);
        this.fqq.setmDisallowSlip(true);
        this.iZK = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity.2
            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (!y.isEmpty(EmotionCenterActivity.this.eyj) && EmotionCenterActivity.this.eyj.size() > i) {
                    return (Fragment) EmotionCenterActivity.this.eyj.get(i);
                }
                return null;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (!y.isEmpty(EmotionCenterActivity.this.eyj)) {
                    return EmotionCenterActivity.this.eyj.size();
                }
                return 0;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                if (!y.isEmpty(EmotionCenterActivity.this.fQk)) {
                    return (CharSequence) EmotionCenterActivity.this.fQk.get(i);
                }
                return "";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAf() {
    }

    private void initData() {
        this.fqq.setAdapter(this.iZK);
        this.iZI.setViewPager(this.fqq);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iZI != null) {
            this.iZI.onChangeSkinType(i);
        }
        if (this.iZH != null) {
            SvgManager.bsU().a(this.iZH, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        }
        if (this.iZJ != null) {
            ap.setBackgroundColor(this.iZJ, R.color.CAM_X0201);
        }
        if (this.iZG != null) {
            ap.setViewTextColor(this.iZG, R.color.navi_back_text_color);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        super.onClick(view);
        if (view == this.iZG) {
            finish();
        } else if (view == this.iZH) {
            if (!y.isEmpty(this.eyj) && (this.eyj.get(0) instanceof EmotionRecommendFragment)) {
                i = ((EmotionRecommendFragment) this.eyj.get(0)).cAg();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NativeEmotionManagerActivityConfig(getPageContext().getPageActivity(), i)));
        }
    }
}
