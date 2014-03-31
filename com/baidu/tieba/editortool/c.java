package com.baidu.tieba.editortool;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.data.SetBubbleResultData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tieba.model.j {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.model.j
    public final void a(SetBubbleResultData setBubbleResultData) {
        this.a.f = setBubbleResultData.getB_info().getB_url();
        TbadkApplication.j().q(this.a.f);
        int a = this.a.a.a();
        if (a == 0) {
            for (BubbleListData.BubbleData bubbleData : this.a.b.getB_info()) {
                if (bubbleData.isDef()) {
                    bubbleData.setIs_def(0);
                }
            }
        } else if (setBubbleResultData.getB_info().canUser()) {
            for (BubbleListData.BubbleData bubbleData2 : this.a.b.getB_info()) {
                if (bubbleData2.getBcode() == a) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
            }
        } else {
            UtilHelper.a(this.a.d, com.baidu.tieba.a.k.bubble_setdefualt_error);
        }
        a.a(this.a);
        al i = this.a.i();
        a aVar = this.a;
        i.a();
    }

    @Override // com.baidu.tieba.model.j
    public final void b(SetBubbleResultData setBubbleResultData) {
        UtilHelper.a(this.a.d, com.baidu.tieba.a.k.neterror);
    }
}
