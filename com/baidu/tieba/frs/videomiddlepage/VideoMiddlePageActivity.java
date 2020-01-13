package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class VideoMiddlePageActivity extends BaseFragmentActivity {
    private VideoMiddlePageFragment gLZ;
    private String mFrom;
    private String mId;
    private String mNid;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_middle_page_layout);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        this.mId = intent.getStringExtra("PARAM_FID");
        this.mFrom = intent.getStringExtra("PARAM_FROM");
        this.mNid = intent.getStringExtra("key_nid");
        xY();
        bJS();
    }

    private void bJS() {
        an anVar = new an("c12664");
        if (!StringUtils.isNull(this.mFrom)) {
            anVar.cp("obj_source", this.mFrom);
        }
        if (TextUtils.isEmpty(this.mNid)) {
            anVar.cp("obj_type", "1");
        } else {
            anVar.cp("obj_type", "2");
            anVar.cp("obj_id", this.mNid);
        }
        TiebaStatic.log(anVar);
    }

    private void xY() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && !supportFragmentManager.isDestroyed()) {
            VideoMiddlePageFragment videoMiddlePageFragment = (VideoMiddlePageFragment) supportFragmentManager.findFragmentByTag(VideoMiddlePageFragment.class.getCanonicalName());
            if (videoMiddlePageFragment == null) {
                videoMiddlePageFragment = VideoMiddlePageFragment.dm(this.mFrom, this.mId);
                supportFragmentManager.beginTransaction().add(R.id.video_middle_page_container, videoMiddlePageFragment, VideoMiddlePageFragment.class.getCanonicalName()).commitAllowingStateLoss();
            }
            this.gLZ = videoMiddlePageFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!aq.isEmpty(this.mId)) {
            com.baidu.tbadk.BdToken.c.avj().o(com.baidu.tbadk.BdToken.b.cCT, com.baidu.adp.lib.f.b.toLong(this.mId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tbadk.BdToken.c.avj().avo();
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
        if (keyEvent == null || this.gLZ == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.gLZ.sZ(i)) {
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
            pageStayDurationItem.dyU = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.mId)) {
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
