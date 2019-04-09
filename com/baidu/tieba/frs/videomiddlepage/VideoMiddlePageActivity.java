package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class VideoMiddlePageActivity extends BaseFragmentActivity {
    private VideoMiddlePageFragment fxk;
    private String mFrom;
    private String mId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.activity_video_middle_page_layout);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        this.mId = intent.getStringExtra("PARAM_FID");
        this.mFrom = intent.getStringExtra("PARAM_FROM");
        bjP();
        am amVar = new am("c12664");
        if (!StringUtils.isNull(this.mFrom)) {
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom);
        }
        TiebaStatic.log(amVar);
    }

    private void bjP() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && !supportFragmentManager.isDestroyed()) {
            VideoMiddlePageFragment videoMiddlePageFragment = (VideoMiddlePageFragment) supportFragmentManager.findFragmentByTag(VideoMiddlePageFragment.class.getCanonicalName());
            if (videoMiddlePageFragment == null) {
                videoMiddlePageFragment = VideoMiddlePageFragment.cQ(this.mFrom, this.mId);
                supportFragmentManager.beginTransaction().add(d.g.video_middle_page_container, videoMiddlePageFragment, VideoMiddlePageFragment.class.getCanonicalName()).commitAllowingStateLoss();
            }
            this.fxk = videoMiddlePageFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!ap.isEmpty(this.mId)) {
            com.baidu.tbadk.BdToken.c.TX().f(com.baidu.tbadk.BdToken.b.bqO, com.baidu.adp.lib.g.b.d(this.mId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tbadk.BdToken.c.TX().TY();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (!UtilHelper.isFlyMeOs()) {
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
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
        if (keyEvent == null || this.fxk == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fxk.qs(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a023";
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
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
            pageStayDurationItem.ah(arrayList);
            pageStayDurationItem.cpQ = "0";
        }
        return pageStayDurationItem;
    }
}
