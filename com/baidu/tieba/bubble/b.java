package com.baidu.tieba.bubble;

import android.text.TextUtils;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.data.SetBubbleResultData;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.model.i {
    final /* synthetic */ BubbleChooseActivity aja;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BubbleChooseActivity bubbleChooseActivity) {
        this.aja = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.model.i
    public void a(SetBubbleResultData setBubbleResultData) {
        g gVar;
        com.baidu.tieba.model.e eVar;
        g gVar2;
        gVar = this.aja.aiS;
        gVar.hideProgressBar();
        eVar = this.aja.aiT;
        int Td = eVar.Td();
        gVar2 = this.aja.aiS;
        f yk = gVar2.yk();
        if (Td == 0) {
            yk.bn(true);
            for (BubbleListData.BubbleData bubbleData : yk.yj()) {
                if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                    bubbleData.setIs_def(0);
                }
            }
            yk.notifyDataSetChanged();
        } else if (setBubbleResultData.getB_info().canUser()) {
            for (BubbleListData.BubbleData bubbleData2 : yk.yj()) {
                if (bubbleData2.getBcode() == Td) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
            }
            yk.bn(false);
            yk.notifyDataSetChanged();
        } else {
            this.aja.showToast(y.bubble_setdefualt_error);
        }
    }

    @Override // com.baidu.tieba.model.i
    public void b(SetBubbleResultData setBubbleResultData) {
        g gVar;
        gVar = this.aja.aiS;
        gVar.hideProgressBar();
        if (setBubbleResultData != null) {
            if (!setBubbleResultData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                    this.aja.showToast(setBubbleResultData.getError_msg());
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
