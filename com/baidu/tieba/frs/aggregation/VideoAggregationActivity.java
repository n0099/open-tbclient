package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tieba.R;
import d.b.c.e.m.b;
import d.b.h0.k0.d;
/* loaded from: classes4.dex */
public class VideoAggregationActivity extends BaseFragmentActivity {
    public VideoAggregationFragment mFragment;
    public String mFrom;
    public String mId;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom) ? "a023" : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && StringUtils.isNull(this.mId) && VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom)) {
            pageStayDurationItem.y(b.f(this.mId, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        if (this.mFragment != null) {
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.mFragment.getView());
            this.mFragment.onChangeSkinType(i);
        }
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
        this.mFragment = VideoAggregationFragment.I0(this.mId, this.mFrom, stringExtra, stringExtra2);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, this.mFragment).commit();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        VideoAggregationFragment videoAggregationFragment;
        if (keyEvent != null && (videoAggregationFragment = this.mFragment) != null) {
            if (videoAggregationFragment.M0(i)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
