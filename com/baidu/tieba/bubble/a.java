package com.baidu.tieba.bubble;

import android.text.TextUtils;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.model.h {
    final /* synthetic */ BubbleChooseActivity aja;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleChooseActivity bubbleChooseActivity) {
        this.aja = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.model.h
    public void a(BubbleListData bubbleListData) {
        g gVar;
        g gVar2;
        com.baidu.tieba.model.e eVar;
        List<BubbleListData.BubbleData> b_info;
        com.baidu.tieba.model.e eVar2;
        com.baidu.tieba.model.e eVar3;
        com.baidu.tieba.model.e eVar4;
        com.baidu.tieba.model.e eVar5;
        com.baidu.tieba.model.e eVar6;
        com.baidu.tieba.model.e eVar7;
        gVar = this.aja.aiS;
        gVar.hideProgressBar();
        if (bubbleListData != null) {
            gVar2 = this.aja.aiS;
            gVar2.setData(bubbleListData.getB_info(), com.baidu.tieba.model.e.ag(bubbleListData.getB_info()));
            eVar = this.aja.aiT;
            if (eVar.Te() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        eVar3 = this.aja.aiT;
                        if (bcode == eVar3.Te()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            eVar4 = this.aja.aiT;
                            eVar5 = this.aja.aiT;
                            eVar4.gy(eVar5.Te());
                            eVar6 = this.aja.aiT;
                            eVar7 = this.aja.aiT;
                            eVar6.p(eVar7.Te(), com.baidu.adp.lib.util.m.n(this.aja), com.baidu.adp.lib.util.m.o(this.aja));
                        } else {
                            continue;
                        }
                    }
                }
                eVar2 = this.aja.aiT;
                eVar2.gz(-1);
            }
        }
    }

    @Override // com.baidu.tieba.model.h
    public void b(BubbleListData bubbleListData) {
        g gVar;
        g gVar2;
        gVar = this.aja.aiS;
        gVar.hideProgressBar();
        gVar2 = this.aja.aiS;
        gVar2.setData(null, false);
        if (bubbleListData != null) {
            if (!bubbleListData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                    this.aja.showToast(bubbleListData.getError_msg());
                    return;
                } else {
                    this.aja.showToast(y.neterror);
                    return;
                }
            }
            this.aja.showToast(y.neterror);
            return;
        }
        this.aja.showToast(y.neterror);
    }
}
