package com.baidu.tieba.im.b;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ b bBH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b bVar, int i) {
        super(i);
        this.bBH = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        SparseArray sparseArray4;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            sparseArray = this.bBH.bBD;
            if (sparseArray != null) {
                sparseArray4 = this.bBH.bBD;
                sparseArray4.clear();
            }
            sparseArray2 = this.bBH.bBE;
            if (sparseArray2 != null) {
                sparseArray3 = this.bBH.bBE;
                sparseArray3.clear();
            }
            this.bBH.bBz = null;
        }
    }
}
