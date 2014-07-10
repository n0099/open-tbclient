package com.baidu.tieba.bubble;

import android.text.TextUtils;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.model.g {
    final /* synthetic */ BubbleChooseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleChooseActivity bubbleChooseActivity) {
        this.a = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.model.g
    public void a(BubbleListData bubbleListData) {
        g gVar;
        g gVar2;
        com.baidu.tieba.model.d dVar;
        List<BubbleListData.BubbleData> b_info;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        com.baidu.tieba.model.d dVar4;
        com.baidu.tieba.model.d dVar5;
        com.baidu.tieba.model.d dVar6;
        com.baidu.tieba.model.d dVar7;
        gVar = this.a.b;
        gVar.e();
        if (bubbleListData != null) {
            gVar2 = this.a.b;
            gVar2.a(bubbleListData.getB_info(), com.baidu.tieba.model.d.a(bubbleListData.getB_info()));
            dVar = this.a.c;
            if (dVar.b() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        dVar3 = this.a.c;
                        if (bcode == dVar3.b()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            dVar4 = this.a.c;
                            dVar5 = this.a.c;
                            dVar4.a(dVar5.b());
                            dVar6 = this.a.c;
                            dVar7 = this.a.c;
                            dVar6.a(dVar7.b(), com.baidu.adp.lib.util.j.b(this.a), com.baidu.adp.lib.util.j.c(this.a));
                        } else {
                            continue;
                        }
                    }
                }
                dVar2 = this.a.c;
                dVar2.b(-1);
            }
        }
    }

    @Override // com.baidu.tieba.model.g
    public void b(BubbleListData bubbleListData) {
        g gVar;
        g gVar2;
        gVar = this.a.b;
        gVar.e();
        gVar2 = this.a.b;
        gVar2.a(null, false);
        if (bubbleListData != null) {
            if (!bubbleListData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                    this.a.showToast(bubbleListData.getError_msg());
                    return;
                } else {
                    this.a.showToast(y.neterror);
                    return;
                }
            }
            this.a.showToast(y.neterror);
            return;
        }
        this.a.showToast(y.neterror);
    }
}
