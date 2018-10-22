package com.baidu.tieba.aiapps.apps.a;

import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import kotlin.jvm.internal.o;
/* loaded from: classes4.dex */
public final class k extends ActivityDelegation implements OnAiAppLoginResultListener {
    public static final a bBh = new a(null);
    private static final String RESULT_CODE = "result_code";

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (b.isLogin(getAgent())) {
            this.mResult.putInt(bBh.Wn(), 0);
            finish();
            return true;
        }
        b.thirdLogin(getAgent(), this.mParams.getInt("key_login_mode", 1), this.mParams.getString("key_login_source", AlbumActivityConfig.FROM_AIAPPS), this);
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener
    public void onResult(int i) {
        this.mResult.putInt(bBh.Wn(), i);
        finish();
    }

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final String Wn() {
            return k.RESULT_CODE;
        }
    }
}
