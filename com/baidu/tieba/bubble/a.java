package com.baidu.tieba.bubble;

import android.text.TextUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.model.f;
import com.baidu.tieba.model.i;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a implements i {
    final /* synthetic */ BubbleChooseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleChooseActivity bubbleChooseActivity) {
        this.a = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.model.i
    public void a(BubbleListData bubbleListData) {
        e eVar;
        e eVar2;
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        f fVar6;
        eVar = this.a.b;
        eVar.e();
        if (bubbleListData != null) {
            eVar2 = this.a.b;
            eVar2.a(bubbleListData.getB_info(), f.a(bubbleListData.getB_info()));
            fVar = this.a.c;
            if (fVar.b() > 0) {
                fVar2 = this.a.c;
                fVar3 = this.a.c;
                fVar2.a(fVar3.b());
                fVar4 = this.a.c;
                fVar5 = this.a.c;
                fVar4.a(fVar5.b(), k.b(this.a), k.c(this.a));
                fVar6 = this.a.c;
                fVar6.b(-1);
            }
        }
    }

    @Override // com.baidu.tieba.model.i
    public void b(BubbleListData bubbleListData) {
        e eVar;
        e eVar2;
        eVar = this.a.b;
        eVar.e();
        eVar2 = this.a.b;
        eVar2.a(null, false);
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
