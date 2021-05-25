package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import d.a.c.e.m.b;
import d.a.c.e.p.k;
import d.a.m0.k0.d;
import d.a.n0.q3.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class VideoMiddlePageActivity extends BaseFragmentActivity {
    public VideoMiddlePageFragment mFragment;
    public String mFrom;
    public String mId;
    public boolean mIsFromSchema = false;
    public String mNid;

    private void doEnterStatistic() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
        if (!StringUtils.isNull(this.mFrom)) {
            statisticItem.param("obj_source", this.mFrom);
        }
        if (TextUtils.isEmpty(this.mNid)) {
            statisticItem.param("obj_type", "1");
        } else {
            statisticItem.param("obj_type", "2");
            statisticItem.param("obj_id", this.mNid);
        }
        TiebaStatic.log(statisticItem);
    }

    private void init() {
        Intent intent = getIntent();
        this.mId = intent.getStringExtra("PARAM_FID");
        this.mFrom = intent.getStringExtra("PARAM_FROM");
        this.mNid = intent.getStringExtra("key_nid");
        initFragment();
        doEnterStatistic();
    }

    private void initFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager == null || supportFragmentManager.isDestroyed()) {
            return;
        }
        VideoMiddlePageFragment videoMiddlePageFragment = (VideoMiddlePageFragment) supportFragmentManager.findFragmentByTag(VideoMiddlePageFragment.class.getCanonicalName());
        if (videoMiddlePageFragment == null) {
            videoMiddlePageFragment = VideoMiddlePageFragment.M0(this.mFrom, this.mId);
            supportFragmentManager.beginTransaction().add(R.id.video_middle_page_container, videoMiddlePageFragment, VideoMiddlePageFragment.class.getCanonicalName()).commitAllowingStateLoss();
        }
        this.mFragment = videoMiddlePageFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a023";
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        if (k.isEmpty(this.mId)) {
            return 0L;
        }
        return b.f(this.mId, 0L);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && !StringUtils.isNull(this.mFrom)) {
            ArrayList arrayList = new ArrayList();
            if ("index".equals(this.mFrom)) {
                arrayList.add("a002");
            } else if ("concern_tab".equals(this.mFrom)) {
                arrayList.add("a038");
            } else if ("frs".equals(this.mFrom)) {
                arrayList.add("a006");
            } else if ("homepage".equals(this.mFrom)) {
                arrayList.add("a002");
            }
            pageStayDurationItem.u(arrayList);
            pageStayDurationItem.l = "0";
            pageStayDurationItem.p = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = getCurrentPageKey();
        return tbPageTag;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        if (UtilHelper.isFlyMeOs()) {
            return;
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            setSwipeBackEnabled(false);
        } else {
            setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.c.a.b.f().h("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_middle_page_layout);
        init();
        if (Build.VERSION.SDK_INT >= 28) {
            if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                c.b(1, getWindow().getAttributes(), getWindow());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        VideoMiddlePageFragment videoMiddlePageFragment;
        if (keyEvent != null && (videoMiddlePageFragment = this.mFragment) != null) {
            if (videoMiddlePageFragment.Q0(i2)) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d.a.m0.a.c.y().E();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (k.isEmpty(this.mId)) {
            return;
        }
        d.a.m0.a.c.y().P(d.a.m0.a.b.Z, b.f(this.mId, 0L));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
