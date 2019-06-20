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
/* loaded from: classes3.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements BdSwitchView.a, RecommendDetailModel.a {
    private b gIH;
    private RecommendDetailModel gII;
    private long mUserId;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gIH = new b(this);
        this.gII = new RecommendDetailModel(getPageContext(), this);
        initData(bundle);
        bDv();
        this.gII.dF(this.mUserId);
    }

    private void bDv() {
        boolean z = true;
        if (this.gIH != null) {
            HashSet<String> amX = com.baidu.tbadk.coreExtra.messageCenter.b.amy().amX();
            if (amX != null && amX.size() > 0 && amX.contains(String.valueOf(this.mUserId))) {
                z = false;
            }
            if (z) {
                this.gIH.bDz();
            } else {
                this.gIH.bDA();
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
        if (this.gIH != null) {
            this.gIH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void vX(String str) {
        if (!StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.gIH != null && this.gII != null && this.gII.bDy() && !this.gII.bDx()) {
            if (l.ki()) {
                this.gIH.oH(R.string.no_data_text);
            } else {
                this.gIH.oH(R.string.game_index_no_network_text);
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void a(UserInfoBigVip userInfoBigVip, boolean z) {
        if (this.gIH != null && userInfoBigVip != null) {
            this.gIH.hideNoDataView();
            this.gIH.b(userInfoBigVip, z);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.gII.mn(false);
        } else {
            this.gII.mn(true);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void ml(boolean z) {
        if (z) {
            showToast(R.string.success);
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), true);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.1
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.gIH.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void mm(boolean z) {
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), false);
            showToast(R.string.success);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.2
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.gIH.setSwitch(true);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gII != null) {
            this.gII.onDestroy();
        }
        super.onDestroy();
    }
}
