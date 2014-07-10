package com.baidu.tieba.bubble;

import android.text.TextUtils;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.data.SetBubbleResultData;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.model.h {
    final /* synthetic */ BubbleChooseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BubbleChooseActivity bubbleChooseActivity) {
        this.a = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.model.h
    public void a(SetBubbleResultData setBubbleResultData) {
        g gVar;
        com.baidu.tieba.model.d dVar;
        g gVar2;
        gVar = this.a.b;
        gVar.e();
        dVar = this.a.c;
        int a = dVar.a();
        gVar2 = this.a.b;
        f a2 = gVar2.a();
        if (a == 0) {
            a2.a(true);
            for (BubbleListData.BubbleData bubbleData : a2.a()) {
                if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                    bubbleData.setIs_def(0);
                }
            }
            a2.notifyDataSetChanged();
        } else if (setBubbleResultData.getB_info().canUser()) {
            for (BubbleListData.BubbleData bubbleData2 : a2.a()) {
                if (bubbleData2.getBcode() == a) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
            }
            a2.a(false);
            a2.notifyDataSetChanged();
        } else {
            this.a.showToast(y.bubble_setdefualt_error);
        }
    }

    @Override // com.baidu.tieba.model.h
    public void b(SetBubbleResultData setBubbleResultData) {
        g gVar;
        gVar = this.a.b;
        gVar.e();
        if (setBubbleResultData != null) {
            if (!setBubbleResultData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                    this.a.showToast(setBubbleResultData.getError_msg());
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
