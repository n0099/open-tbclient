package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bn extends CustomMessageListener {
    final /* synthetic */ bl bau;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bl blVar, int i) {
        super(i);
        this.bau = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        com.baidu.tieba.card.data.o oVar4;
        boolean Nv;
        com.baidu.tieba.card.data.o oVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            oVar = this.bau.aZr;
            if (oVar != null) {
                oVar2 = this.bau.aZr;
                if (oVar2.bbC != null) {
                    oVar3 = this.bau.aZr;
                    if (oVar3.bbC.getTid() != null && this.bau.bat != null && this.bau.bat.mTextTitle != null) {
                        oVar4 = this.bau.aZr;
                        if (((String) customResponsedMessage.getData()).equals(oVar4.bbC.getTid())) {
                            Nv = this.bau.Nv();
                            if (!Nv) {
                                TextView textView = this.bau.bat.mTextTitle;
                                oVar5 = this.bau.aZr;
                                ap.a(textView, oVar5.bbC.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
