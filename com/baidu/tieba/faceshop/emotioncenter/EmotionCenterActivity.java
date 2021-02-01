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
/* loaded from: classes9.dex */
public class EmotionCenterActivity extends BaseFragmentActivity {
    private BdBaseViewPager foQ;
    private TextView iXJ;
    private ImageView iXK;
    private CommonPagerSlidingTabStrip iXL;
    private LinearLayout iXM;
    private FragmentPagerAdapter iXN;
    private String iXO;
    private NavigationBar mNavigationBar;
    private List<BaseFragment> ewG = new ArrayList(2);
    private List<String> fOK = new ArrayList(2);
    private CustomMessageListener iXP = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER_ADD_FRAGMENT) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str) && !str.equals(EmotionCenterActivity.this.iXO)) {
                    EmotionCenterActivity.this.iXO = str;
                    EmotionCenterActivity.this.czS();
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
        registerListener(this.iXP);
    }

    private void initView() {
        this.fOK.add(getPageContext().getResources().getString(R.string.emotion_center_quality_recommend));
        EmotionRecommendFragment emotionRecommendFragment = new EmotionRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("need_check_login", true);
        emotionRecommendFragment.setArguments(bundle);
        this.ewG.add(emotionRecommendFragment);
        this.fOK.add(getPageContext().getResources().getString(R.string.emotion_center_single_bar));
        ForumEmotionFragment forumEmotionFragment = new ForumEmotionFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_load_url", this.iXO);
        forumEmotionFragment.setArguments(bundle2);
        this.ewG.add(forumEmotionFragment);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.iXJ = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
        this.iXJ.setTextSize(0, l.getDimens(this, R.dimen.ds34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iXK = new ImageView(getPageContext().getPageActivity());
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iXK, (View.OnClickListener) null);
        this.iXK.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.iXK.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.emotion_navigation_bar, (View.OnClickListener) null);
        this.iXL = (CommonPagerSlidingTabStrip) findViewById(R.id.emotion_center_nav);
        this.iXL.a(l.getDimens(this, R.dimen.ds32), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds24), l.getDimens(this, R.dimen.ds4), l.getDimens(this, R.dimen.ds64), R.color.CAM_X0107, R.color.CAM_X0105);
        this.iXJ.setOnClickListener(this);
        this.iXK.setOnClickListener(this);
        this.iXM = (LinearLayout) findViewById(R.id.emotion_root_view);
        this.foQ = (BdBaseViewPager) findViewById(R.id.emotion_center_viewpager);
        this.foQ.setmDisallowSlip(true);
        this.iXN = new FragmentPagerAdapter(getSupportFragmentManager()) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionCenterActivity.2
            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (!y.isEmpty(EmotionCenterActivity.this.ewG) && EmotionCenterActivity.this.ewG.size() > i) {
                    return (Fragment) EmotionCenterActivity.this.ewG.get(i);
                }
                return null;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                if (!y.isEmpty(EmotionCenterActivity.this.ewG)) {
                    return EmotionCenterActivity.this.ewG.size();
                }
                return 0;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                if (!y.isEmpty(EmotionCenterActivity.this.fOK)) {
                    return (CharSequence) EmotionCenterActivity.this.fOK.get(i);
                }
                return "";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czS() {
    }

    private void initData() {
        this.foQ.setAdapter(this.iXN);
        this.iXL.setViewPager(this.foQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        if (this.iXL != null) {
            this.iXL.onChangeSkinType(i);
        }
        if (this.iXK != null) {
            SvgManager.bsR().a(this.iXK, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        }
        if (this.iXM != null) {
            ap.setBackgroundColor(this.iXM, R.color.CAM_X0201);
        }
        if (this.iXJ != null) {
            ap.setViewTextColor(this.iXJ, R.color.navi_back_text_color);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        super.onClick(view);
        if (view == this.iXJ) {
            finish();
        } else if (view == this.iXK) {
            if (!y.isEmpty(this.ewG) && (this.ewG.get(0) instanceof EmotionRecommendFragment)) {
                i = ((EmotionRecommendFragment) this.ewG.get(0)).czT();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NativeEmotionManagerActivityConfig(getPageContext().getPageActivity(), i)));
        }
    }
}
