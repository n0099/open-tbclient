package com.baidu.tieba.im.recommend.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.im.recommend.detail.RecommendDetailModel;
import java.util.HashSet;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements BdSwitchView.a, RecommendDetailModel.a {
    private b eRd;
    private RecommendDetailModel eRe;
    private long mUserId;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eRd = new b(this);
        this.eRe = new RecommendDetailModel(getPageContext(), this);
        initData(bundle);
        aSb();
        this.eRe.cr(this.mUserId);
    }

    private void aSb() {
        boolean z = true;
        if (this.eRd != null) {
            HashSet<String> Hk = com.baidu.tbadk.coreExtra.messageCenter.a.GL().Hk();
            if (Hk != null && Hk.size() > 0 && Hk.contains(String.valueOf(this.mUserId))) {
                z = false;
            }
            if (z) {
                this.eRd.aSg();
            } else {
                this.eRd.aSh();
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
        if (this.eRd != null) {
            this.eRd.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void ni(String str) {
        if (!StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.eRd != null && this.eRe != null && this.eRe.aSf() && !this.eRe.aSe()) {
            if (l.lm()) {
                this.eRd.jJ(e.j.no_data_text);
            } else {
                this.eRd.jJ(e.j.game_index_no_network_text);
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void a(UserInfoBigVip userInfoBigVip, boolean z) {
        if (this.eRd != null && userInfoBigVip != null) {
            this.eRd.hideNoDataView();
            this.eRd.b(userInfoBigVip, z);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.eRe.iR(false);
        } else {
            this.eRe.iR(true);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void iP(boolean z) {
        if (z) {
            showToast(e.j.success);
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), true);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.1
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.eRd.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void iQ(boolean z) {
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), false);
            showToast(e.j.success);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.2
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.eRd.setSwitch(true);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eRe != null) {
            this.eRe.onDestroy();
        }
        super.onDestroy();
    }
}
