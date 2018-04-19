package com.baidu.tieba.im.recommend.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.im.recommend.detail.RecommendDetailModel;
import java.util.HashSet;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements BdSwitchView.a, RecommendDetailModel.a {
    private b egK;
    private RecommendDetailModel egL;
    private long mUserId;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.egK = new b(this);
        this.egL = new RecommendDetailModel(getPageContext(), this);
        initData(bundle);
        aGF();
        this.egL.ce(this.mUserId);
    }

    private void aGF() {
        boolean z = true;
        if (this.egK != null) {
            HashSet<String> zW = com.baidu.tbadk.coreExtra.messageCenter.a.zx().zW();
            if (zW != null && zW.size() > 0 && zW.contains(String.valueOf(this.mUserId))) {
                z = false;
            }
            if (z) {
                this.egK.aGK();
            } else {
                this.egK.aGL();
            }
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mUserId = bundle.getLong("user_id", 0L);
            this.mUserName = bundle.getString("user_name");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.mUserId = intent.getLongExtra("user_id", 0L);
            this.mUserName = intent.getStringExtra("user_name");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("user_id", this.mUserId);
        bundle.putString("user_name", this.mUserName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.egK != null) {
            this.egK.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void lx(String str) {
        if (!StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.egK != null && this.egL != null && this.egL.aGJ() && !this.egL.aGI()) {
            if (l.hg()) {
                this.egK.ij(d.k.no_data_text);
            } else {
                this.egK.ij(d.k.game_index_no_network_text);
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void a(UserInfoBigVip userInfoBigVip, boolean z) {
        if (this.egK != null && userInfoBigVip != null) {
            this.egK.hideNoDataView();
            this.egK.b(userInfoBigVip, z);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.egL.hy(false);
        } else {
            this.egL.hy(true);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void hw(boolean z) {
        if (z) {
            showToast(d.k.success);
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), true);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.1
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.egK.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void hx(boolean z) {
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), false);
            showToast(d.k.success);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.2
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.egK.setSwitch(true);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.egL != null) {
            this.egL.onDestroy();
        }
        super.onDestroy();
    }
}
