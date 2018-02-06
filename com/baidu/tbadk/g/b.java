package com.baidu.tbadk.g;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public abstract class b extends BaseFragment {
    protected boolean aIK = false;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.g.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                b.this.eb(b.this.getType());
                if (!b.this.aIK) {
                    b.this.e(false, b.this.getType());
                }
            }
        }
    };

    public abstract int getType();

    public abstract boolean wP();

    public boolean wO() {
        return this.aIK;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eb(int i) {
        Bundle bundle = new Bundle();
        this.aIK = !wP() && j.oJ();
        bundle.putBoolean("is_enable_edit", this.aIK);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022209, bundle));
    }

    protected void e(boolean z, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", z);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }
}
