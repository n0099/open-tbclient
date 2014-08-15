package com.baidu.tieba.bubble;

import android.text.TextUtils;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.model.h {
    final /* synthetic */ BubbleChooseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleChooseActivity bubbleChooseActivity) {
        this.a = bubbleChooseActivity;
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
        gVar = this.a.b;
        gVar.e();
        if (bubbleListData != null) {
            gVar2 = this.a.b;
            gVar2.a(bubbleListData.getB_info(), com.baidu.tieba.model.e.a(bubbleListData.getB_info()));
            eVar = this.a.c;
            if (eVar.b() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        eVar3 = this.a.c;
                        if (bcode == eVar3.b()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            eVar4 = this.a.c;
                            eVar5 = this.a.c;
                            eVar4.a(eVar5.b());
                            eVar6 = this.a.c;
                            eVar7 = this.a.c;
                            eVar6.a(eVar7.b(), com.baidu.adp.lib.util.j.b(this.a), com.baidu.adp.lib.util.j.c(this.a));
                        } else {
                            continue;
                        }
                    }
                }
                eVar2 = this.a.c;
                eVar2.b(-1);
            }
        }
    }

    @Override // com.baidu.tieba.model.h
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
                    this.a.showToast(x.neterror);
                    return;
                }
            }
            this.a.showToast(x.neterror);
            return;
        }
        this.a.showToast(x.neterror);
    }
}
