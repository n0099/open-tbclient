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
    private String acU;
    private long acV;
    private i bmk;
    private c bml;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bmk = new i(this);
        this.bml = new c(getPageContext(), this);
        initData(bundle);
        this.bmk.gQ(this.acU);
        this.bml.ad(this.acV);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.acV = bundle.getLong("user_id", 0L);
            this.acU = bundle.getString("user_name");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.acV = intent.getLongExtra("user_id", 0L);
            this.acU = intent.getStringExtra("user_name");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("user_id", this.acV);
        bundle.putString("user_name", this.acU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bmk != null) {
            this.bmk.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.g
    public void onFailed(String str) {
        if (!StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.bmk != null && this.bml != null && this.bml.Tr() && !this.bml.Tq()) {
            if (n.isNetOk()) {
                this.bmk.fh(y.no_data_text);
            } else {
                this.bmk.fh(y.game_index_no_network_text);
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.g
    public void a(UserInfoBigVip userInfoBigVip, boolean z) {
        if (this.bmk != null && userInfoBigVip != null) {
            this.bmk.hideNoDataView();
            this.bmk.b(userInfoBigVip, z);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.bml.cV(false);
        } else {
            this.bml.cV(true);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.g
    public void cT(boolean z) {
        if (z) {
            showToast(y.success_string);
            TbadkCoreApplication.m411getInst().setPromotedMessage(true);
            return;
        }
        this.mHandler.postDelayed(new a(this), 500L);
    }

    @Override // com.baidu.tieba.im.recommend.detail.g
    public void cU(boolean z) {
        if (z) {
            TbadkCoreApplication.m411getInst().setPromotedMessage(false);
            showToast(y.success_string);
            return;
        }
        this.mHandler.postDelayed(new b(this), 500L);
    }
}
