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
    private b eXS;
    private RecommendDetailModel eXT;
    private long mUserId;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXS = new b(this);
        this.eXT = new RecommendDetailModel(getPageContext(), this);
        initData(bundle);
        aTT();
        this.eXT.cy(this.mUserId);
    }

    private void aTT() {
        boolean z = true;
        if (this.eXS != null) {
            HashSet<String> Io = com.baidu.tbadk.coreExtra.messageCenter.a.HP().Io();
            if (Io != null && Io.size() > 0 && Io.contains(String.valueOf(this.mUserId))) {
                z = false;
            }
            if (z) {
                this.eXS.aTY();
            } else {
                this.eXS.aTZ();
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
        if (this.eXS != null) {
            this.eXS.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void nH(String str) {
        if (!StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.eXS != null && this.eXT != null && this.eXT.aTX() && !this.eXT.aTW()) {
            if (l.ll()) {
                this.eXS.jX(e.j.no_data_text);
            } else {
                this.eXS.jX(e.j.game_index_no_network_text);
            }
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void a(UserInfoBigVip userInfoBigVip, boolean z) {
        if (this.eXS != null && userInfoBigVip != null) {
            this.eXS.hideNoDataView();
            this.eXS.b(userInfoBigVip, z);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.eXT.iU(false);
        } else {
            this.eXT.iU(true);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void iS(boolean z) {
        if (z) {
            showToast(e.j.success);
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), true);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.1
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.eXS.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.a
    public void iT(boolean z) {
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), false);
            showToast(e.j.success);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailActivity.2
            @Override // java.lang.Runnable
            public void run() {
                RecommendDetailActivity.this.eXS.setSwitch(true);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eXT != null) {
            this.eXT.onDestroy();
        }
        super.onDestroy();
    }
}
