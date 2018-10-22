package com.baidu.tieba.aiapps.apps.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.ng.ai.apps.setting.actions.PrivateGetUserInfoAction;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
class h extends ProviderDelegation {
    h() {
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null && !TextUtils.isEmpty(bundle.getString("key_uid"))) {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            bundle2.putString("user_login_nickname_key", session.displayname);
            bundle2.putString("user_login_portrait_key", session.getSocialPortrait());
            bundle2.putInt(PrivateGetUserInfoAction.KEY_GENDER, TbadkCoreApplication.getCurrentAccountObj() == null ? -1 : TbadkCoreApplication.getCurrentAccountObj().getSex());
            return bundle2;
        }
        return bundle2;
    }
}
