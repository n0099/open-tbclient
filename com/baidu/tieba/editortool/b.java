package com.baidu.tieba.editortool;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements com.baidu.tieba.model.i {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.model.i
    public final void a(BubbleListData bubbleListData) {
        if (bubbleListData != null) {
            this.a.b = bubbleListData;
            if (this.a.a.b() > 0) {
                this.a.a.a(this.a.a.b());
                com.baidu.tieba.model.f fVar = this.a.a;
                com.baidu.tieba.model.f.a(this.a.a.b(), 0, 0);
                this.a.a.b(-1);
            }
            a.a(this.a);
            al i = this.a.i();
            a aVar = this.a;
            i.a();
        }
    }

    @Override // com.baidu.tieba.model.i
    public final void b(BubbleListData bubbleListData) {
        this.a.b = null;
        UtilHelper.a(this.a.d, com.baidu.tieba.a.k.neterror);
    }
}
