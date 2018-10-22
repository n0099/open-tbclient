package com.baidu.tieba.aiapps.apps.a;

import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
/* loaded from: classes4.dex */
public class j extends ActivityDelegation implements OnAiAppLoginResultListener {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (!this.mParams.getBoolean("key_login_force", false) && b.isLogin(getAgent())) {
            this.mResult.putInt("result_code", 0);
            finish();
            return true;
        }
        b.login(getAgent(), this.mParams.getString("key_login_source", AlbumActivityConfig.FROM_AIAPPS), this);
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener
    public void onResult(int i) {
        this.mResult.putInt("result_code", i);
        finish();
    }
}
