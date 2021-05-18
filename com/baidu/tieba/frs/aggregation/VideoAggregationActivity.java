package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tieba.R;
import d.a.c.e.m.b;
import d.a.j0.k0.d;
/* loaded from: classes4.dex */
public class VideoAggregationActivity extends BaseFragmentActivity {
    public VideoAggregationFragment mFragment;
    public String mFrom;
    public String mId;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.j0.k0.a
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
    public void onChangeSkinType(int i2) {
        if (this.mFragment != null) {
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mFragment.getView());
            this.mFragment.onChangeSkinType(i2);
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
        this.mFragment = VideoAggregationFragment.H0(this.mId, this.mFrom, stringExtra, stringExtra2);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, this.mFragment).commit();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        VideoAggregationFragment videoAggregationFragment;
        if (keyEvent != null && (videoAggregationFragment = this.mFragment) != null) {
            if (videoAggregationFragment.L0(i2)) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
