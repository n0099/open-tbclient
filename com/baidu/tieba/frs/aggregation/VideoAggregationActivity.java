package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class VideoAggregationActivity extends BaseFragmentActivity {
    private VideoAggregationFragment iaj;
    private String mFrom;
    private String mId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_aggregation);
        this.mFrom = getIntent().getStringExtra("PARAM_FROM");
        this.mId = getIntent().getStringExtra("PARAM_FID");
        String stringExtra = getIntent().getStringExtra("st_type");
        String stringExtra2 = getIntent().getStringExtra("yuelaou_locate");
        if (TextUtils.isEmpty(this.mId)) {
            finish();
        }
        this.iaj = VideoAggregationFragment.y(this.mId, this.mFrom, stringExtra, stringExtra2);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, this.iaj).commit();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.iaj != null) {
            getLayoutMode().setNightMode(i == 1);
            getLayoutMode().onModeChanged(this.iaj.getView());
            this.iaj.onChangeSkinType(i);
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
        if (keyEvent == null || this.iaj == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.iaj.xB(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom) ? PageStayDurationConstants.PageName.VIDEO_LIST : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && StringUtils.isNull(this.mId) && VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom)) {
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.mId, 0L));
        }
        return pageStayDurationItem;
    }
}
