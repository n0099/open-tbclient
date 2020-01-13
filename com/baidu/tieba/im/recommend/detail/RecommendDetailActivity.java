package com.baidu.tieba.im.recommend.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.recommend.detail.RecommendDetailModel;
import java.util.HashSet;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes11.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements BdSwitchView.a, RecommendDetailModel.a {
    private b hGu;
    private RecommendDetailModel hGv;
    private long mUserId;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hGu = new b(this);
        this.hGv = new RecommendDetailModel(getPageContext(), this);
        initData(bundle);
        bWi();
        this.hGv.dZ(this.mUserId);
    }

    private void bWi() {
        boolean z = true;
        if (this.hGu != null) {
            HashSet<String> aII = com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aII();
            if (aII != null && aII.size() > 0 && aII.contains(String.valueOf(this.mUserId))) {
                z = false;
            }
            if (z) {
                this.hGu.bWm();
            } else {
                this.hGu.bWn();
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
        if (this.hGu != null) {
            this.hGu.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void onFailed(String str) {
        if (!StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.hGu != null && this.hGv != null && this.hGv.bWl() && !this.hGv.bWk()) {
            if (l.isNetOk()) {
                this.hGu.wi(R.string.no_data_text);
            } else {
                this.hGu.wi(R.string.game_index_no_network_text);
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void a(UserInfoBigVip userInfoBigVip, boolean z) {
        if (this.hGu != null && userInfoBigVip != null) {
            this.hGu.hideNoDataView();
            this.hGu.b(userInfoBigVip, z);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.hGv.nR(false);
        } else {
            this.hGv.nR(true);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void nP(boolean z) {
        if (z) {
            showToast(R.string.success);
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), true);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.1
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.hGu.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void nQ(boolean z) {
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), false);
            showToast(R.string.success);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.2
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.hGu.setSwitch(true);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hGv != null) {
            this.hGv.onDestroy();
        }
        super.onDestroy();
    }
}
