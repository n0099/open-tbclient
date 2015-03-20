package com.baidu.tieba.im.recommend.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.y;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements com.baidu.adp.widget.BdSwitchView.b, g {
    private String acM;
    private long acN;
    private i blU;
    private c blV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.blU = new i(this);
        this.blV = new c(getPageContext(), this);
        initData(bundle);
        this.blU.gN(this.acM);
        this.blV.ad(this.acN);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.acN = bundle.getLong("user_id", 0L);
            this.acM = bundle.getString("user_name");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.acN = intent.getLongExtra("user_id", 0L);
            this.acM = intent.getStringExtra("user_name");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("user_id", this.acN);
        bundle.putString("user_name", this.acM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.blU != null) {
            this.blU.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.g
    public void onFailed(String str) {
        if (!StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.blU != null && this.blV != null && this.blV.Te() && !this.blV.Td()) {
            if (n.isNetOk()) {
                this.blU.fg(y.no_data_text);
            } else {
                this.blU.fg(y.game_index_no_network_text);
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.g
    public void a(UserInfoBigVip userInfoBigVip, boolean z) {
        if (this.blU != null && userInfoBigVip != null) {
            this.blU.hideNoDataView();
            this.blU.b(userInfoBigVip, z);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.blV.cX(false);
        } else {
            this.blV.cX(true);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.g
    public void cV(boolean z) {
        if (z) {
            showToast(y.success_string);
            TbadkCoreApplication.m411getInst().setPromotedMessage(true);
            return;
        }
        this.mHandler.postDelayed(new a(this), 500L);
    }

    @Override // com.baidu.tieba.im.recommend.detail.g
    public void cW(boolean z) {
        if (z) {
            TbadkCoreApplication.m411getInst().setPromotedMessage(false);
            showToast(y.success_string);
            return;
        }
        this.mHandler.postDelayed(new b(this), 500L);
    }
}
