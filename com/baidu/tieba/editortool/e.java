package com.baidu.tieba.editortool;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.data.BubbleListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.bubble.s sVar;
        com.baidu.tieba.bubble.s sVar2;
        if (view instanceof com.baidu.tieba.view.b) {
            BubbleListData.BubbleData bubbleData = this.a.b.getB_info().get(((Integer) view.getTag()).intValue());
            if (bubbleData != null && !bubbleData.isDef()) {
                if (bubbleData.getBcode() != 0 && !bubbleData.canUse()) {
                    if (bubbleData.isFree()) {
                        if (!(this.a.d instanceof Activity)) {
                            return;
                        }
                        sVar2 = this.a.l;
                        com.baidu.tieba.bubble.h.a((Activity) this.a.d, bubbleData, sVar2);
                        return;
                    } else if (!(this.a.d instanceof Activity)) {
                        return;
                    } else {
                        sVar = this.a.m;
                        com.baidu.tieba.bubble.h.b((Activity) this.a.d, bubbleData, sVar);
                        return;
                    }
                }
                this.a.e(bubbleData.getBcode());
            }
        }
    }
}
