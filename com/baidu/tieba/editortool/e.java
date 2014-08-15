package com.baidu.tieba.editortool;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
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
        BubbleListData bubbleListData;
        Context context;
        Context context2;
        com.baidu.tieba.bubble.s sVar;
        Context context3;
        Context context4;
        com.baidu.tieba.bubble.s sVar2;
        if (view instanceof com.baidu.tieba.view.b) {
            int intValue = ((Integer) view.getTag()).intValue();
            bubbleListData = this.a.c;
            BubbleListData.BubbleData bubbleData = bubbleListData.getB_info().get(intValue);
            boolean a = com.baidu.tbadk.h.a().a(TbadkApplication.isMem + TbadkApplication.getCurrentAccount(), false);
            if (bubbleData != null && !bubbleData.isDef()) {
                if (bubbleData.getBcode() != 0 && !bubbleData.canUse() && !a) {
                    if (bubbleData.isFree()) {
                        context3 = this.a.d;
                        if (context3 instanceof Activity) {
                            context4 = this.a.d;
                            sVar2 = this.a.k;
                            com.baidu.tieba.bubble.h.a((Activity) context4, bubbleData, sVar2);
                            return;
                        }
                        return;
                    }
                    context = this.a.d;
                    if (context instanceof Activity) {
                        context2 = this.a.d;
                        sVar = this.a.l;
                        com.baidu.tieba.bubble.h.b((Activity) context2, bubbleData, sVar);
                        return;
                    }
                    return;
                }
                this.a.e(bubbleData.getBcode());
            }
        }
    }
}
