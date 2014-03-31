package com.baidu.tieba.bubble;

import com.baidu.tieba.a.k;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.model.f;
import com.baidu.tieba.model.i;
import java.util.List;
/* loaded from: classes.dex */
final class a implements i {
    final /* synthetic */ BubbleChooseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleChooseActivity bubbleChooseActivity) {
        this.a = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.model.i
    public final void a(BubbleListData bubbleListData) {
        e eVar;
        e eVar2;
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        f unused;
        eVar = this.a.b;
        eVar.g();
        if (bubbleListData != null) {
            eVar2 = this.a.b;
            eVar2.a(bubbleListData.getB_info(), f.a(bubbleListData.getB_info()));
            fVar = this.a.c;
            if (fVar.b() > 0) {
                fVar2 = this.a.c;
                fVar3 = this.a.c;
                fVar2.a(fVar3.b());
                unused = this.a.c;
                fVar4 = this.a.c;
                f.a(fVar4.b(), com.baidu.adp.lib.util.i.b(this.a), com.baidu.adp.lib.util.i.c(this.a));
                fVar5 = this.a.c;
                fVar5.b(-1);
            }
        }
    }

    @Override // com.baidu.tieba.model.i
    public final void b(BubbleListData bubbleListData) {
        e eVar;
        e eVar2;
        eVar = this.a.b;
        eVar.g();
        eVar2 = this.a.b;
        eVar2.a((List<BubbleListData.BubbleData>) null, false);
        this.a.showToast(k.neterror);
    }
}
