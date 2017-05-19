package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ b aPQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, int i) {
        super(i);
        this.aPQ = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        boolean IB;
        boolean IB2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520) {
            j = this.aPQ.aPH;
            if (j != 0) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof BaseActivity)) {
                    if (!(data instanceof BaseFragmentActivity)) {
                        return;
                    }
                    IB = this.aPQ.IB();
                    if (IB) {
                        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                        Intent intent = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseFragmentActivity.getActivity().startActivity(intent);
                        return;
                    }
                    return;
                }
                IB2 = this.aPQ.IB();
                if (IB2) {
                    BaseActivity baseActivity = (BaseActivity) data;
                    Intent intent2 = new Intent(baseActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseActivity.startActivity(intent2);
                }
            }
        }
    }
}
