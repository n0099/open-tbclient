package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.r;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r.c bsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r.c cVar) {
        this.bsr = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cf cfVar;
        cf cfVar2;
        cf cfVar3;
        cfVar = this.bsr.bqY;
        if (cfVar != null) {
            if (view.getId() == w.h.hlistview_item_layout_root) {
                if (view.getTag(w.h.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                    cfVar3 = this.bsr.bqY;
                    cfVar3.a(view, null, (CardHListViewNormalItemData) view.getTag(w.h.hlistview_item_layout_root));
                }
            } else if (view.getId() == w.h.fourm_name && (view.getTag(w.h.fourm_name) instanceof CardHListViewNormalItemData)) {
                cfVar2 = this.bsr.bqY;
                cfVar2.a(view, null, (CardHListViewNormalItemData) view.getTag(w.h.fourm_name));
            }
        }
    }
}
