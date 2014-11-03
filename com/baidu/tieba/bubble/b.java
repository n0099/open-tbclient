package com.baidu.tieba.bubble;

import android.text.TextUtils;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.data.SetBubbleResultData;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.model.i {
    final /* synthetic */ BubbleChooseActivity ajj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BubbleChooseActivity bubbleChooseActivity) {
        this.ajj = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.model.i
    public void a(SetBubbleResultData setBubbleResultData) {
        g gVar;
        com.baidu.tieba.model.e eVar;
        g gVar2;
        gVar = this.ajj.ajb;
        gVar.hideProgressBar();
        eVar = this.ajj.ajc;
        int Tg = eVar.Tg();
        gVar2 = this.ajj.ajb;
        f ym = gVar2.ym();
        if (Tg == 0) {
            ym.bn(true);
            for (BubbleListData.BubbleData bubbleData : ym.yl()) {
                if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                    bubbleData.setIs_def(0);
                }
            }
            ym.notifyDataSetChanged();
        } else if (setBubbleResultData.getB_info().canUser()) {
            for (BubbleListData.BubbleData bubbleData2 : ym.yl()) {
                if (bubbleData2.getBcode() == Tg) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
            }
            ym.bn(false);
            ym.notifyDataSetChanged();
        } else {
            this.ajj.showToast(y.bubble_setdefualt_error);
        }
    }

    @Override // com.baidu.tieba.model.i
    public void b(SetBubbleResultData setBubbleResultData) {
        g gVar;
        gVar = this.ajj.ajb;
        gVar.hideProgressBar();
        if (setBubbleResultData != null) {
            if (!setBubbleResultData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                    this.ajj.showToast(setBubbleResultData.getError_msg());
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
