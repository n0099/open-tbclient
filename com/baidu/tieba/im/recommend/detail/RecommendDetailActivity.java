package com.baidu.tieba.im.recommend.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.recommend.detail.RecommendDetailModel;
import d.b.b.e.p.l;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes4.dex */
public class RecommendDetailActivity extends BaseActivity<RecommendDetailActivity> implements RecommendDetailModel.d, BdSwitchView.b {
    public static final String RECOMMEND_DETAIL_URL = "c/u/user/bigvip";
    public RecommendDetailModel mModel;
    public long mUserId;
    public String mUserName;
    public d.b.i0.d1.q.a.b mView;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendDetailActivity.this.mView.f(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendDetailActivity.this.mView.f(true);
        }
    }

    private void checkIsShowAcceptSwitch() {
        if (this.mView == null) {
            return;
        }
        if (!d.b.h0.s.d.b.g0().N(String.valueOf(this.mUserId))) {
            this.mView.g();
        } else {
            this.mView.a();
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

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.mModel.C(false);
        } else {
            this.mModel.C(true);
        }
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.d
    public void onAcceptMsg(boolean z) {
        if (z) {
            showToast(R.string.success);
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), true);
            return;
        }
        this.mHandler.postDelayed(new a(), 500L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.d1.q.a.b bVar = this.mView;
        if (bVar != null) {
            bVar.d(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new d.b.i0.d1.q.a.b(this);
        this.mModel = new RecommendDetailModel(getPageContext(), this);
        initData(bundle);
        checkIsShowAcceptSwitch();
        this.mModel.A(this.mUserId);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        RecommendDetailModel recommendDetailModel = this.mModel;
        if (recommendDetailModel != null) {
            recommendDetailModel.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.d
    public void onFailed(String str) {
        RecommendDetailModel recommendDetailModel;
        if (!StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.mView == null || (recommendDetailModel = this.mModel) == null || !recommendDetailModel.y() || this.mModel.x()) {
            return;
        }
        if (l.C()) {
            this.mView.h(R.string.no_data_text);
        } else {
            this.mView.h(R.string.game_index_no_network_text);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("user_id", this.mUserId);
        bundle.putString("user_name", this.mUserName);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.d
    public void onSuccess(UserInfoBigVip userInfoBigVip, boolean z) {
        d.b.i0.d1.q.a.b bVar = this.mView;
        if (bVar == null || userInfoBigVip == null) {
            return;
        }
        bVar.b();
        this.mView.i(userInfoBigVip, z);
    }

    @Override // com.baidu.tieba.im.recommend.detail.RecommendDetailModel.d
    public void onUnAcceptMsg(boolean z) {
        if (z) {
            TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(this.mUserId), false);
            showToast(R.string.success);
            return;
        }
        this.mHandler.postDelayed(new b(), 500L);
    }
}
