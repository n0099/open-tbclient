package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class VideoMiddlePageActivity extends BaseFragmentActivity {
    private VideoMiddlePageFragment iim;
    private String mFrom;
    private String mId;
    private String mNid;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_middle_page_layout);
        init();
        if (Build.VERSION.SDK_INT >= 28) {
            if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), this);
            }
        }
    }

    private void init() {
        Intent intent = getIntent();
        this.mId = intent.getStringExtra("PARAM_FID");
        this.mFrom = intent.getStringExtra("PARAM_FROM");
        this.mNid = intent.getStringExtra("key_nid");
        II();
        cjO();
    }

    private void cjO() {
        ap apVar = new ap("c12664");
        if (!StringUtils.isNull(this.mFrom)) {
            apVar.dn("obj_source", this.mFrom);
        }
        if (TextUtils.isEmpty(this.mNid)) {
            apVar.dn("obj_type", "1");
        } else {
            apVar.dn("obj_type", "2");
            apVar.dn("obj_id", this.mNid);
        }
        TiebaStatic.log(apVar);
    }

    private void II() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && !supportFragmentManager.isDestroyed()) {
            VideoMiddlePageFragment videoMiddlePageFragment = (VideoMiddlePageFragment) supportFragmentManager.findFragmentByTag(VideoMiddlePageFragment.class.getCanonicalName());
            if (videoMiddlePageFragment == null) {
                videoMiddlePageFragment = VideoMiddlePageFragment.er(this.mFrom, this.mId);
                supportFragmentManager.beginTransaction().add(R.id.video_middle_page_container, videoMiddlePageFragment, VideoMiddlePageFragment.class.getCanonicalName()).commitAllowingStateLoss();
            }
            this.iim = videoMiddlePageFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!as.isEmpty(this.mId)) {
            com.baidu.tbadk.BdToken.c.aQc().p(com.baidu.tbadk.BdToken.b.dEE, com.baidu.adp.lib.f.b.toLong(this.mId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tbadk.BdToken.c.aQc().aQm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (!UtilHelper.isFlyMeOs()) {
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            setSwipeBackEnabled(false);
        } else {
            setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.iim == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.iim.vj(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.VIDEO_LIST;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && !StringUtils.isNull(this.mFrom)) {
            ArrayList arrayList = new ArrayList();
            if ("index".equals(this.mFrom)) {
                arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            } else if ("concern_tab".equals(this.mFrom)) {
                arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN);
            } else if ("frs".equals(this.mFrom)) {
                arrayList.add(PageStayDurationConstants.PageName.FRS);
            } else if ("homepage".equals(this.mFrom)) {
                arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            pageStayDurationItem.setSorceKeyList(arrayList);
            pageStayDurationItem.isVertical = "0";
            pageStayDurationItem.eGE = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        if (as.isEmpty(this.mId)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.mId, 0L);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = getCurrentPageKey();
        return tbPageTag;
    }
}
