package com.baidu.tieba.bubble;

import android.text.TextUtils;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.model.h {
    final /* synthetic */ BubbleChooseActivity ajj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleChooseActivity bubbleChooseActivity) {
        this.ajj = bubbleChooseActivity;
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
        gVar = this.ajj.ajb;
        gVar.hideProgressBar();
        if (bubbleListData != null) {
            gVar2 = this.ajj.ajb;
            gVar2.setData(bubbleListData.getB_info(), com.baidu.tieba.model.e.ag(bubbleListData.getB_info()));
            eVar = this.ajj.ajc;
            if (eVar.Th() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        eVar3 = this.ajj.ajc;
                        if (bcode == eVar3.Th()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            eVar4 = this.ajj.ajc;
                            eVar5 = this.ajj.ajc;
                            eVar4.gy(eVar5.Th());
                            eVar6 = this.ajj.ajc;
                            eVar7 = this.ajj.ajc;
                            eVar6.p(eVar7.Th(), com.baidu.adp.lib.util.m.n(this.ajj), com.baidu.adp.lib.util.m.o(this.ajj));
                        } else {
                            continue;
                        }
                    }
                }
                eVar2 = this.ajj.ajc;
                eVar2.gz(-1);
            }
        }
    }

    @Override // com.baidu.tieba.model.h
    public void b(BubbleListData bubbleListData) {
        g gVar;
        g gVar2;
        gVar = this.ajj.ajb;
        gVar.hideProgressBar();
        gVar2 = this.ajj.ajb;
        gVar2.setData(null, false);
        if (bubbleListData != null) {
            if (!bubbleListData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                    this.ajj.showToast(bubbleListData.getError_msg());
                    return;
                } else {
                    this.ajj.showToast(y.neterror);
                    return;
                }
            }
            this.ajj.showToast(y.neterror);
            return;
        }
        this.ajj.showToast(y.neterror);
    }
}
