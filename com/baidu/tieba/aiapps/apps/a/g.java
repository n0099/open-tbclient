package com.baidu.tieba.aiapps.apps.a;

import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
/* loaded from: classes4.dex */
public class g extends ActivityDelegation implements com.baidu.swan.apps.a.a {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (!this.mParams.getBoolean("key_login_force", false) && a.bk(getAgent())) {
            this.mResult.putInt("result_code", 0);
            finish();
            return true;
        }
        a.b(getAgent(), this.mParams.getString("key_login_source", AlbumActivityConfig.FROM_AIAPPS), this);
        return false;
    }

    @Override // com.baidu.swan.apps.a.a
    public void onResult(int i) {
        this.mResult.putInt("result_code", i);
        finish();
    }
}
